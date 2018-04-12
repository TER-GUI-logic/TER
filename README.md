# (Interface graphique pour) réaliser des preuves en logique classique

## Commencement:

Pour le bon fonctionnement du programme sur votre machine locale suivre les tâches suivantes.

### Prérequis:

Nous vous invitons à vérifier que vous avez la version la plus récente du Java Development Kit(JDK)

```
  JDK 9.0.4
  Antlr
```

### Installation

Le JDK et Antlr doivent être installés et ajoutés aux variables d'environnement:

#### Windows :
```
Paramètres système avancés
-variables d'environnement
--variables système
---sélectionner PATH puis modifier,si elle n'existe pas cliquer sur Nouvelle
---indiquez la valeur de la variable d'environnement PATH vers votre ..\java\jdk?.?.?\bin
---une fois modifiée cliquer sur OK

---sélectionner CLASSPATH puis modifier,si elle n'existe pas cliquer sur Nouvelle
---indiquez la valeur de la variable d'environnement CLASSPATH vers votre antlr-4.7.1-complete.jar
---une fois modifiée cliquer sur OK
```
#### Linux: 

dans un invité de commande 

```
$ export CLASSPATH=".:/usr/local/lib/antlr-4.7.1-complete.jar:$CLASSPATH"
```

### Lancer un test
Il est temps d'essayer notre programme. Je vous invite à ouvrir votre invité de commande directement dans le dossier ```Ter-GUI-logic``` une fois cette dernière ouverte(si vous avez fermé la fenêtre depuis l'ajout de la variable d'Antlr, l'ajouter de nouveau). Compiler l'ensemble des fichiers .java.

```
javac *.java
```

et exécuter le Main.

```
java Main
```

Il ne reste qu'a suivre les indications.

### Exemple
```
((A\/B)=>A)
```

