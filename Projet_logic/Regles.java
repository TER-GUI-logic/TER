//import java.lang.reflect.InvocationTargetException;
//import java.lang.reflect.Method;

public enum Regles {
Axiome,
cut,
EtG,
EtD,
OuG,
OuD,
NonG,
NonD,
contG,
contD,
FauxG,
VraiD,
ImpliqueG,
ImpliqueD,
EquivalentG1,
EquivalentG2,
EquivalentD;



/*	public Sequent ImpRight(Sequent Se,int i) {
		Sequent S= Se;
		if (S.getDelta().get(i).getClass().getName()=="Implique"){
			try {
				Method m = S.getDelta().get(i).getClass().getMethod("getArgD", null);
				Formule Roucool =(Formule)m.invoke(S.getDelta().get(i),null);
				Method M = S.getGamma().get(i).getClass().getMethod("getArgG", null);
				Formule Pikachu=(Formule) M.invoke(S.getGamma().get(i),null);
				S.getDelta().remove(i);
				S.getGamma().add(Pikachu);
				S.getDelta().add(Roucool);
				Sequent h=new Sequent(S.getGamma(),S.getDelta());
				
			}catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}
			 catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block.
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
			}
		}
		return null;
		}
	*/	

	
	
	
	
	
	
	
	
	
	
	
}
