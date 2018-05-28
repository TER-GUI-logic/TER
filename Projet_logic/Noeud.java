import java.util.ArrayList;

public class Noeud extends Preuve{

	//attributs
	ArrayList<Preuve> prems;
    String rule;
    
	//constructeurs
	public Noeud(Sequent concl, ArrayList<Preuve> prems, String rule) {
		this.concl=concl;
		this.prems = prems;
		this.rule = rule;
	}

	
	//methodes
	
	public String fairePreuve( int i, Regles r){
		ArrayList<Formule> args;
		Sequent S=  new Sequent(new ArrayList<Formule>(concl.getGamma()),new ArrayList<Formule>(concl.getDelta()));
		Sequent S2 = new Sequent(new ArrayList<Formule>(concl.getGamma()),new ArrayList<Formule>(concl.getDelta()));
		ArrayList<Preuve> P= new ArrayList<Preuve>();
		Formule f;
		String str = "";
		
		switch (r){
		case EtG:
			if (S.getGamma().get(i).getClass()==Et.class){
				args=S.getGamma().get(i).getArgs();
				S.getGamma().remove(i);
				S.getGamma().add(args.get(0));
				S.getGamma().add(args.get(1));
				P.add(S.noeudpasfini());
				rule=r.toString();
			}else{
				str = "Erreur : le symbole de tete n'est pas un /\\";
			}
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
				rule=r.toString();
			//	str = "test";
			}else{
				str ="Erreur : le symbole de tete n'est pas un /\\";}
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
				rule=r.toString();
			}else{str = "Erreur : le symbole de tete n'est pas un \\/";}
		break;
			
		case OuD:
			if (S.getDelta().get(i).getClass()==Ou.class){
				args=S.getDelta().get(i).getArgs();
				S.getDelta().remove(i);
				S.getDelta().add(args.get(0));
				S.getDelta().add(args.get(1));
				P.add(S.noeudpasfini());
				rule=r.toString();
			}else{str = "Erreur : le symbole de tete n'est pas un \\/";}
			break;
			
		case NonG:
			if(S.getGamma().get(i).getClass()==Non.class){
				args=S.getGamma().get(i).getArgs();
				S.getGamma().remove(i);
				S.getDelta().add(args.get(0));
				P.add(S.noeudpasfini());
				rule=r.toString();
			}else{str = "Erreur : le symbole de tete n'est pas un non";}
			break;
			
		case NonD:
			if(S.getDelta().get(i).getClass()==Non.class){
				args=S.getDelta().get(i).getArgs();
				S.getDelta().remove(i);
				S.getGamma().add(args.get(0));
				P.add(S.noeudpasfini());
				rule=r.toString();
			}else{str = "Erreur : le symbole de tete n'est pas un non";}
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
				rule=r.toString();
			}else{str = "Erreur : le symbole de tete n'est pas un =>";}
			break;
			
		case ImpliqueD:
			if(S.getDelta().get(i).getClass()==Implique.class){
				args=S.getDelta().get(i).getArgs();
				S.getDelta().remove(i);
				S.getGamma().add(args.get(0));
				S.getDelta().add(args.get(1));
				P.add(S.noeudpasfini());
				rule=r.toString();
			}else{str = "Erreur : le symbole de tete n'est pas un =>";}
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
				rule=r.toString();
			}else{str = "Erreur : le symbole de tete n'est pas un <=>";}
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
				rule=r.toString();
			}else{str = "Erreur : le symbole de tete n'est pas un <=>";}
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
				rule=r.toString();
			}else{str = "Erreur : le symbole de tete n'est pas un <=>";}
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
						rule=r.toString();
					}
				}
			}
			if(test){str = "Non axiomatique";}
			break;

		case contG:
			f=S.getGamma().get(i);
			S.getGamma().add(f);
			P.add(S.noeudpasfini());
			rule=r.toString();
			break;
			
		case contD:
			f=S.getDelta().get(i);
			S.getDelta().add(f);
			P.add(S.noeudpasfini());
			rule=r.toString();
			break;
			
		case cut:
			System.out.println("\nEntrez votre Formule :");
			Formule formule= Util.entrerFormule();
			S.getDelta().add(formule);
			S2.getGamma().add(formule);
			P.add(S.noeudpasfini());	
			P.add(S2.noeudpasfini());
			rule=r.toString();
			break;
			
			
			
		default: str = "Regle non implementee";
		}
				
		prems=P;
		return str;

}

	public String faireCut( String a){
		ArrayList<Formule> args;
		Sequent S=  new Sequent(new ArrayList<Formule>(concl.getGamma()),new ArrayList<Formule>(concl.getDelta()));
		Sequent S2 = new Sequent(new ArrayList<Formule>(concl.getGamma()),new ArrayList<Formule>(concl.getDelta()));
		ArrayList<Preuve> P= new ArrayList<Preuve>();
		Formule f;
		String str = "";
		
		Formule formule = Util.entrerFormule(a);
		S.getDelta().add(formule);
		S2.getGamma().add(formule);
		P.add(S.noeudpasfini());
		P.add(S2.noeudpasfini());
		rule = "cut";
		
		prems = P;
		return str;
	}



	public ArrayList<Preuve> getPrems() {
		return prems;
	}


	public ArrayList<String> listString(boolean mode){
		int offset=0,taille;
		ArrayList<String> list=new ArrayList<String>();
		String s;

		if(prems.size()==2){
			ArrayList<String> listG=prems.get(0).listString(mode);
			ArrayList<String> listD=prems.get(1).listString(mode);
			if(mode){
				list=fusion(listG,listD);
			}else{list=fusion2(listG,listD);}
			for (int i=0;i<listG.size();i++){
				offset=Math.max(offset,listG.get(i).length());
			}

		}else if (prems.size()==1){
			list=prems.get(0).listString(mode);
		}
		if (list.size()==0)
			taille=concl.toString().length();
		else
			taille = Math.max(concl.toString().length(),list.get(list.size()-1).length());
		s=new String(new char[taille]).replace("\0","-");
		s+=rule;
		list.add(s);
		list.add(concl.toString());
		return list;
	}

	public void affiche(boolean mode){
		System.out.println();
		ArrayList<String> list=listString(mode);
		for (int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
		System.out.println();
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
	
	private ArrayList<String> fusion2(ArrayList<String> listG, ArrayList<String> listD){
		ArrayList<String> list=new ArrayList<String>();
		String espace="";
		int offset=0;
		int k=listG.size()-listD.size();
		for (int i=0;i<listG.size();i++){
				offset=Math.max(offset,listG.get(i).length());
		}
		offset+=3;
		if(k<0){
			espace = new String(new char[offset]).replace("\0"," &nbsp ");
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
			espace = new String(new char[offset-listG.get(Math.max(i,k+i)).length()]).replace("\0"," &nbsp ");
			list.add(listG.get(Math.max(i,k+i))+espace+listD.get(Math.max(i,-k+i)));
		}
		return list;
	}

	public boolean estValide(){
		if (prems.size()==1)
			return prems.get(0).estValide();
		if (prems.size()==2)
			return (prems.get(0).estValide() && prems.get(1).estValide());
		else
			return false;
	}
}
