/*
public class EmployeService {

    private static Employe[] employes = new Employe[50];
    private static int nbrEmployes = 0;


    public static boolean ajouterEmploye(Employe employe) {
        if (nbrEmployes < employes.length) {
            // Vérifier l'unicité du id employe
            for (int i = 0; i < nbrEmployes; i++) {
                if (employes[i].getId() == employe.getId()) {
                    System.out.println("Erreur : id employe existe déjà.");
                    return false;
                }
            }
            employes[nbrEmployes++] = employe;
            System.out.println("Employe ajouté avec succès.");
            return true;
        } else {
            System.out.println("Erreur : La table est pleine.");
            return false;
        }
    }

    public static void modifierEmploye(int id, String nouveauNom, String nouveauPoste, double nouveauSalaire) {
        for (int i = 0; i < nbrEmployes; i++) {
            if (employes[i].getId() == id) {
                employes[i].setNom(nouveauNom);
                employes[i].setPoste(nouveauPoste);
                employes[i].setSalaire(nouveauSalaire);
                System.out.println("Employé modifié avec succès.");
                return;
            }
        }
        System.out.println("Employé non trouvé.");
    }

    public static boolean supprimerEmploye(int id) {
        for (int i = 0; i < nbrEmployes; i++) {
            if (employes[i].getId() == id) {
                // Décalage des employes pour supprimer
                for (int j = i; j < nbrEmployes - 1; j++) {
                    employes[j] = employes[j + 1];
                }
                employes[--nbrEmployes] = null;  // Libérer la dernière position
                System.out.println("Employé supprimé avec succès.");
                return true;
            }
        }
        System.out.println("Employé non trouvé.");
        return false;
    }

    public static void rechercherEmploye(String critere) {
        boolean trouve = false;
        for (int i = 0; i < nbrEmployes; i++) {
            if (employes[i].getNom().equalsIgnoreCase(critere) || employes[i].getPoste().equalsIgnoreCase(critere)) {
                System.out.println(employes[i]);
                trouve = true;
            }
        }
        if (!trouve) System.out.println("Aucun employé trouvé.");
    }


    public static void afficherEmployes() {
        if (nbrEmployes == 0) {
            System.out.println("Aucun employé enregistré.");
        } else {
            for (int i = 0; i < nbrEmployes; i++) {
                System.out.println(employes[i]);
            }
        }
    }

    public static void calculerMasseSalariale() {
        double total = Arrays.stream(employes).filter(e -> e != null).mapToDouble(Employe::getSalaire).sum();
        System.out.println("Masse salariale totale: " + total);
    }

    public static void trierEmployesParSalaire(boolean ordreCroissant) {
        Arrays.sort(employes, 0, compteur, Employe.compareParSalaire(ordreCroissant));
        afficherEmployes();
    }



}
*/
