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
		ArrayList<Formule> args;
		Sequent S=  new Sequent(concl.getGamma(),concl.getDelta());
		Sequent S2 = new Sequent(concl.getGamma(),concl.getDelta());
		ArrayList<Preuve> P= new ArrayList<Preuve>();
		Formule f;
		
		switch (r){
		case EtG:
			if (S.getGamma().get(i).getClass().getName()=="Et"){
				args=S.getGamma().get(i).getArgs();
				S.getGamma().remove(i);
				S.getGamma().add(args.get(0));
				S.getGamma().add(args.get(1));
				P.add(S.noeudpasfini());
			}else{System.out.println("erreur");}
			break;
			
		case EtD:
			if (S.getDelta().get(i).getClass().getName()=="Et"){
				args=S.getDelta().get(i).getArgs();
				S.getDelta().remove(i);
				S.getDelta().add(args.get(0));
				S2.getDelta().remove(i);
				S2.getDelta().add(args.get(1));
				P.add(S.noeudpasfini());
				P.add(S2.noeudpasfini());
			}else{System.out.println("erreur");}
			break;
			
		case OuG:
			if(S.getGamma().get(i).getClass().getName()=="Ou"){
				args=S.getGamma().get(i).getArgs();
				S.getGamma().remove(i);
				S.getGamma().add(args.get(0));
				S2.getGamma().remove(i);
				S2.getGamma().add(args.get(1));
				P.add(S.noeudpasfini());
				P.add(S2.noeudpasfini());
			}else{System.out.println("erreur");}
		break;
			
		case OuD:
			if (S.getDelta().get(i).getClass().getName()=="Ou"){
				args=S.getDelta().get(i).getArgs();
				S.getDelta().remove(i);
				S.getDelta().add(args.get(0));
				S.getDelta().add(args.get(1));
				P.add(S.noeudpasfini());
			}else{System.out.println("erreur");}
			break;
			
		case NonG:
			if(S.getGamma().get(i).getClass().getName()=="Non"){
				args=S.getGamma().get(i).getArgs();
				S.getGamma().remove(i);
				S.getDelta().add(args.get(0));
				P.add(S.noeudpasfini());
			}else{System.out.println("erreur");}
			break;
			
		case NonD:
			if(S.getDelta().get(i).getClass().getName()=="Non"){
				args=S.getDelta().get(i).getArgs();
				S.getDelta().remove(i);
				S.getGamma().add(args.get(0));
				P.add(S.noeudpasfini());
			}else{System.out.println("erreur");}
			break;
		
		case ImpliqueG:
			if(S.getGamma().get(i).getClass().getName()=="Implique"){
				args=S.getGamma().get(i).getArgs();
				S.getGamma().remove(i);
				S.getDelta().add(args.get(0));
				S2.getGamma().remove(i);
				S2.getGamma().add(args.get(1));
				P.add(S.noeudpasfini());
				P.add(S2.noeudpasfini());
			}else{System.out.println("erreur");}
			break;
			
		case ImpliqueD:
			if(S.getDelta().get(i).getClass().getName()=="Implique"){
				args=S.getDelta().get(i).getArgs();
				S.getDelta().remove(i);
				S.getGamma().add(args.get(0));
				S.getDelta().add(args.get(1));
				P.add(S.noeudpasfini());
			}else{System.out.println("erreur");}
			break;

		case EquivalentG1:
			if(S.getGamma().get(i).getClass().getName()=="Equivalent"){
				args=S.getGamma().get(i).getArgs();
				S.getGamma().remove(i);
				S.getDelta().add(args.get(0));
				S2.getGamma().remove(i);
				S2.getGamma().add(args.get(1));
				P.add(S.noeudpasfini());	
				P.add(S2.noeudpasfini());
			}else{System.out.println("erreur");}
			break;
			
		case EquivalentG2:
			if(S.getGamma().get(i).getClass().getName()=="Equivalent"){
				args=S.getGamma().get(i).getArgs();
				S.getGamma().remove(i);
				S.getDelta().add(args.get(1));
				S2.getGamma().remove(i);
				S2.getGamma().add(args.get(0));
				P.add(S.noeudpasfini());	
				P.add(S2.noeudpasfini());
			}else{System.out.println("erreur");}
			break;
			
		case EquivalentD:
			if(S.getDelta().get(i).getClass().getName()=="Equivalent"){
				args=S.getDelta().get(i).getArgs();
				S.getDelta().remove(i);
				S.getGamma().add(args.get(0));
				S.getDelta().add(args.get(1));
				S2.getDelta().remove(i);
				S2.getGamma().add(args.get(1));
				S2.getDelta().add(args.get(0));
				P.add(S.noeudpasfini());
				P.add(S2.noeudpasfini());
			}else{System.out.println("erreur");}
			break;
		

		case Axiome:
			for(int k=0;k<S.getGamma().size();k++){
				for(int j=0;j<S.getDelta().size();j++){
					if(S.getGamma().get(k).getClass()== S.getDelta().get(j).getClass() 
						&& S.getDelta().get(j).getClass().getName()== "Variable" 
						&& S.getDelta().get(j).toString()==S.getGamma().get(k).toString()){
						P.add(S.feuille());
					}

				}
			}
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
			
			default:System.out.println("erreur");
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

}


