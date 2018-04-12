# (Interface graphique pour )réaliser des preuves en logique classique

## Commencement:

Pour le bon fonctionnement du programme sur votre machine local suivre les taches suivantes.

### Prerequis:

Nous vous invitons a verifier que vous avez la version la plus recente du Java Development Kit(JDK)

```
  JDK 9.0.4
  Antlr
```

### Installation

Le JDK doit etre installer et ajouté au variable d'environnement:

```
Parametres systeme avancés
-variables d'environnement
--variables systeme
---selectionner CLASSPATH puis modifier,si elle n'existe pas cliqué sur Nouvelle
---une fois modifier cliquer sur OK
```

Antlr peut etre ajouté temporairement aux variables d'environnement directement dans un invité de commande 

```
$ export CLASSPATH=".:/usr/local/lib/antlr-4.7.1-complete.jar:$CLASSPATH"
$ alias antlr4='java -jar /usr/local/lib/antlr-4.7.1-complete.jar'
$ alias grun='java org.antlr.v4.gui.TestRig'
```

### Lancer un test
Il est temps d'essayer notre programme. Je vous invite a ouvrir votre invité de commande directement dans le dossier ```Ter-GUI-logic``` une fois cette dernier ouverte(si vous avez fermer la fenetre depuis l'ajoutdes variable d'Antlr, les ajouter de nouveau). Compiler l'ensemble des fichiers .java.

```
javac *.java
```

et executer le Main.

```
java Main
```

Il ne reste qu'a suivre les indications.

### Exemple
```
((A\/B)=>A)
```

