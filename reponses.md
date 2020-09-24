**EXERCICE 1**

**5)** 

Afin d'avoir le programme qui fonctionne encore il faudrait créer deux nouvelles méthodes de type `getSalaireNetV2()` et `getSalaireBrutV2()` qui prenne en compte la nouvelle méthode de calcul du salaire net.

Afin de limiter la redondance de code on peut avant toute chose créer un attribut `SalaireBrut` de type double (on a pas besoin de créer un attibut SalaireNet car il est dit dans l'énoncé que la methode de calcul du SalaireNet ne change jamais).

Ensuite il suffit de mettre en paramettre de la méthode `getSalaireBrut()` un coefficient de type Double qui permet de changer facilement la methode de calcul du SalaireBrut (lorsque le coefficient est égal à 1 pas de changement).

Egalement on créer une surcharge de la fonction `getSalaireBrut()` qui pemet de ne pas changer la méthode de calcul si pas de coefficiant.

```java
class Employe{
    double getSalaireBrut(double coefficient){
            salaireBrut = base * nbHeures * coefficient;
            return salaireBrut;
    }
    
    double getSalaireBrut(){
            return getSalaireBrut(1);
    }
    
    double getSalaireNet(){
            return salaireBrut * 0.8;
    }
}
```

Il suffit donc de faire qu'un seul changement.

**EXERCICE 2**

**5)** 

On a plus accés à la méthode `fabriquerProduit()` si on déclare un objet de type Employe et que l'on l'instancie en tant que Fabricant alors que l'on encore accés au `getSalaireBrut()` de la classe Fabricant.
Ce phenomene est du au fait que lors de l'instanciation vu qu'il existe un `getSalaireBrut()` dans la classe mère et fille, pour cette objet il prendra en priorité le `getSalaireBrut()` de la classe fille.

Et donc au final il ne peut pas utiliser la methode `fabricationProduit()` car elle n'existe pas dans la classe Employe contrairement à `getSalaireBrut()`.

**6)**

Afin de rajouter 100 euros pour tous les employé il suffit de faire deux modification (une dans la fonction `getSalaireBrut()` de la classe Employe et une dans la fonction `getSalaireBrut()` de la classe Commercial.

**EXERCICE 3**

**1)**

Aprés cette question il faut instancier un vendeur et non plus un commercial si on veut obtenir un Employe qui utilise la methode de calcul de salaire d'un commercial car la classe commercial est abstraite.

**3)** 

Afin de faire en sorte qu'un Représentant ait son salaire qui soit calculer comme celui d'un technicien il faut instancier à l'aide du buider de Technicien dans la méthode `getSalaire()` un Technicien délégué qui aura les caractéristiques du Représentant.

```java
class Représentant{

    double getSalaireBrut(){
            Technicien delégué = new TechnicienBuilder().setBase(getBase()).setEchelon(getEchelon()).setNbHeures(getNbHeures()).createTechnicien();
            return delégué.getSalaireBrut();
        }
}
```
De ce fait l'orsque l'on instanciera un Représentant son salaire sera calculé de la meme maniere qu'un technicien.

Pour ce qui est du Vendeur on a pas besoin de faire une methode `getSalaireBrut()` car la classe Vendeur herite déja d'une methode `getSalaireBrut()` qui renvoie le Salaire Brut d'un Commercial.

**4)** 

Avec cette approche on obtient le fonctionnement voulu de cette application mais on est obligé de créer un nouvel objet tampon (le délégué) ce qui peut être problematique si on doit traiter beaucoup d'objet.

Egalement si l'on souhaite modifier la methode de calcul de salaire d'un technicien ça modifiera aussi la methode de calcul d'un Représentant.
Cette fonctionnalitée peut être un incovennient tout comme un avantage.

Enfin on est sur que la methode de calcul d'un salaire d'un représentant sera toujours la même que celle d'un Technicien.