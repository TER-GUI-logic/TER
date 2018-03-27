/**
 * Define a grammar called Analyseur	
 */


grammar Analyseur;	

formul returns [Formule value]:
  va=variable {$value=$va.value;}
| o=ou {$value=$o.value;}
| e=et {$value=$e.value;}
| i=implique {$value=$i.value;}
| eq=equivalent {$value=$eq.value;}
| n=non {$value=$n.value;};

variable returns [Formule value]:
  Faux {$value=new Faux();} | Vrai {$value=new Vrai();}| var=Variable {$value= new Variable($var.text);};

ou 			returns [ Formule value ]: 	'(' f1=formul '\\/' f2=formul ')' {$value = new Ou($f1.value,$f2.value);};
et 			returns [ Formule value ]: 	'(' f1=formul '/\\' f2=formul ')' {$value = new Et($f1.value,$f2.value);};
implique 	returns [ Formule value ]:	'(' f1=formul '=>'  f2=formul ')' {$value = new Implique($f1.value,$f2.value);};
equivalent 	returns [ Formule value ]:	'(' f1=formul '<=>' f2=formul ')' {$value = new Equivalent($f1.value,$f2.value);};
non			returns [ Formule value ]: 	'non' '(' f=formul ')'				{$value = new Non($f.value);};


Faux: 		'False';
Vrai: 		'True';
Variable: 	[A-Z];
WS : [ \t\r\n]+ -> skip;
