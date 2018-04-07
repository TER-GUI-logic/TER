import java.util.ArrayList;

public class Noeud extends Preuve{

	//attributs
	ArrayList<Preuve> prems;
    String rule;
    
	//constructeurs
	public Noeud(Sequent concl, ArrayList<Preuve> prems, String rule) {
		this.concl = concl;
		this.prems = prems;
		this.rule = rule;
	}

	
	//methodes
	
	public void fairePreuve( int i, Regles r){
		rule=r.toString();
		ArrayList<Formule> args;
		Sequent S=  new Sequent(new ArrayList<Formule>(concl.getGamma()),new ArrayList<Formule>(concl.getDelta()));
		Sequent S2 = new Sequent(new ArrayList<Formule>(concl.getGamma()),new ArrayList<Formule>(concl.getDelta()));
		ArrayList<Preuve> P= new ArrayList<Preuve>();
		Formule f;
		
		switch (r){
		case EtG:
			if (S.getGamma().get(i).getClass()==Et.class){
				args=S.getGamma().get(i).getArgs();
				S.getGamma().remove(i);
				S.getGamma().add(args.get(0));
				S.getGamma().add(args.get(1));
				P.add(S.noeudpasfini());
			}else{System.out.println("Erreur : le symbole de tete n'est pas un /\\");}
			break;
			
		case EtD:
			if (S.getDelta().get(i).getClass()==Et.class){
				args=S.getDelta().get(i).getArgs();
				S.getDelta().remove(i);
				S.getDelta().add(args.get(0));
				S2.getDelta().remove(i);
				S2.getDelta().add(args.get(1));
				P.add(S.noeudpasfini());
				P.add(S2.noeudpasfini());
			}else{System.out.println("Erreur : le symbole de tete n'est pas un /\\");}
			break;
			
		case OuG:
			if(S.getGamma().get(i).getClass()==Ou.class){
				args=S.getGamma().get(i).getArgs();
				S.getGamma().remove(i);
				S.getGamma().add(args.get(0));
				S2.getGamma().remove(i);
				S2.getGamma().add(args.get(1));
				P.add(S.noeudpasfini());
				P.add(S2.noeudpasfini());
			}else{System.out.println("Erreur : le symbole de tete n'est pas un \\/");}
		break;
			
		case OuD:
			if (S.getDelta().get(i).getClass()==Ou.class){
				args=S.getDelta().get(i).getArgs();
				S.getDelta().remove(i);
				S.getDelta().add(args.get(0));
				S.getDelta().add(args.get(1));
				P.add(S.noeudpasfini());
			}else{System.out.println("Erreur : le symbole de tete n'est pas un \\/");}
			break;
			
		case NonG:
			if(S.getGamma().get(i).getClass()==Non.class){
				args=S.getGamma().get(i).getArgs();
				S.getGamma().remove(i);
				S.getDelta().add(args.get(0));
				P.add(S.noeudpasfini());
			}else{System.out.println("Erreur : le symbole de tete n'est pas un non");}
			break;
			
		case NonD:
			if(S.getDelta().get(i).getClass()==Non.class){
				args=S.getDelta().get(i).getArgs();
				S.getDelta().remove(i);
				S.getGamma().add(args.get(0));
				P.add(S.noeudpasfini());
			}else{System.out.println("Erreur : le symbole de tete n'est pas un non");}
			break;
		
		case ImpliqueG:
			if(S.getGamma().get(i).getClass()==Implique.class){
				args=S.getGamma().get(i).getArgs();
				S.getGamma().remove(i);
				S.getDelta().add(args.get(0));
				S2.getGamma().remove(i);
				S2.getGamma().add(args.get(1));
				P.add(S.noeudpasfini());
				P.add(S2.noeudpasfini());
			}else{System.out.println("Erreur : le symbole de tete n'est pas un =>");}
			break;
			
		case ImpliqueD:
			if(S.getDelta().get(i).getClass()==Implique.class){
				args=S.getDelta().get(i).getArgs();
				S.getDelta().remove(i);
				S.getGamma().add(args.get(0));
				S.getDelta().add(args.get(1));
				P.add(S.noeudpasfini());
			}else{System.out.println("Erreur : le symbole de tete n'est pas un =>");}
			break;

		case EquivalentG1:
			if(S.getGamma().get(i).getClass()==Equivalent.class){
				args=S.getGamma().get(i).getArgs();
				S.getGamma().remove(i);
				S.getDelta().add(args.get(0));
				S2.getGamma().remove(i);
				S2.getGamma().add(args.get(1));
				P.add(S.noeudpasfini());	
				P.add(S2.noeudpasfini());
			}else{System.out.println("Erreur : le symbole de tete n'est pas un <=>");}
			break;
			
		case EquivalentG2:
			if(S.getGamma().get(i).getClass()==Equivalent.class){
				args=S.getGamma().get(i).getArgs();
				S.getGamma().remove(i);
				S.getDelta().add(args.get(1));
				S2.getGamma().remove(i);
				S2.getGamma().add(args.get(0));
				P.add(S.noeudpasfini());	
				P.add(S2.noeudpasfini());
			}else{System.out.println("Erreur : le symbole de tete n'est pas un <=>");}
			break;
			
		case EquivalentD:
			if(S.getDelta().get(i).getClass()==Equivalent.class){
				args=S.getDelta().get(i).getArgs();
				S.getDelta().remove(i);
				S.getGamma().add(args.get(0));
				S.getDelta().add(args.get(1));
				S2.getDelta().remove(i);
				S2.getGamma().add(args.get(1));
				S2.getDelta().add(args.get(0));
				P.add(S.noeudpasfini());
				P.add(S2.noeudpasfini());
			}else{System.out.println("Erreur : le symbole de tete n'est pas un <=>");}
			break;
		

		case Axiome:
			boolean test=true;			//vrai si aucun n'axiome n'est encore detecte
			for(int k=0;k<S.getGamma().size();k++){
				for(int j=0;j<S.getDelta().size();j++){
					if(S.getGamma().get(k).getClass()== Variable.class 
						&& S.getDelta().get(j).getClass()==Variable.class 
						&& S.getDelta().get(j).toString().equals(S.getGamma().get(k).toString())
						&& test){

						P.add(S.feuille());
						test=false;
					}
				}
			}
			if(test){System.out.println("Non axiomatique");}
			break;

		case contG:
			f=S.getGamma().get(i);
			S.getGamma().add(f);
			P.add(S.noeudpasfini());
			break;
			
		case contD:
			f=S.getDelta().get(i);
			S.getDelta().add(f);
			P.add(S.noeudpasfini());
			break;
			
		default:System.out.println("Regle non implementee");
		}
				
		prems=P;

}



	public ArrayList<Preuve> getPrems() {
		return prems;
	}


	public String toString(){
		String s="";
		if(prems.size()==2){
			s+=prems.get(0).toString() + "   "+ prems.get(1).toString()+"\n";
		}else if (prems.size()==1){
			s=prems.get(0).toString()+"\n";
		}
		s+=concl.toString();
		return s;
	}

	public ArrayList<String> listString(){
		int offset=0;
		ArrayList<String> list=new ArrayList<String>();
		String s=new String(new char[concl.toString().length()]).replace("\0","-");
		s+=rule;
		if(prems.size()==2){
			ArrayList<String> listG=prems.get(0).listString();
			ArrayList<String> listD=prems.get(1).listString();
			list=fusion(listG,listD);
			for (int i=0;i<listG.size();i++){
				offset=Math.max(offset,listG.get(i).length());
			}

		}else if (prems.size()==1){
			list=prems.get(0).listString();
		}
		list.add(s);
		list.add(concl.toString());
		return list;
	}

	public void affiche(){
		ArrayList<String> list=listString();
		for (int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
	}

	private ArrayList<String> fusion(ArrayList<String> listG, ArrayList<String> listD){
		ArrayList<String> list=new ArrayList<String>();
		String espace="";
		int offset=0;
		int k=listG.size()-listD.size();
		for (int i=0;i<listG.size();i++){
				offset=Math.max(offset,listG.get(i).length());
		}
		offset+=3;
		if(k<0){
			espace = new String(new char[offset]).replace("\0"," ");
			for (int i=0;i<-k;i++){
				list.add(espace+listD.get(i));
			}
		}
		if(k>0){
			for (int i=0;i<k;i++){
				list.add(listG.get(i));
			}
		}
		for (int i=0;i<Math.min(listG.size(),listD.size());i++){
			espace = new String(new char[offset-listG.get(Math.max(i,k+i)).length()]).replace("\0"," ");
			list.add(listG.get(Math.max(i,k+i))+espace+listD.get(Math.max(i,-k+i)));
		}
		return list;
	}
}


