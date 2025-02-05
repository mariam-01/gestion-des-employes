import java.util.Scanner;

public class GestionEmployes {

    private static Employe[] employes = new Employe[50];
    private static int nbrEmployes = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int choix;

        do {
            afficherMenu();
            choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1 -> ajouterUnEmploye(scanner);
                case 2 -> modifierUnEmploye(scanner);
                case 3 -> supprimerUnEmploye(scanner);
                case 4 -> afficherEmployes();
                case 5 -> rechercherUnEmploye(scanner);
                case 6 -> calculerMasseSalariale();
                case 7 -> trierEmployesParSalaire(scanner);
                case 0 -> System.out.println("Au revoir !");
                default -> System.out.println("Choix invalide.");
            }
        } while (choix != 0);

        scanner.close();
    }


    // Affiche le menu de gestion des employés
    public static void afficherMenu() {
        System.out.println("\n ---Menu Gestion des Employés ---");
        System.out.println("1. Ajouter un employé");
        System.out.println("2. Modifier un employé");
        System.out.println("3. Supprimer un employé");
        System.out.println("4. Afficher la liste des employés");
        System.out.println("5. Rechercher un employé");
        System.out.println("6. Calculer la masse salariale");
        System.out.println("7. Trier les employés par salaire");
        System.out.println("8. Quitter");
        System.out.print(" Entrez votre choix: ");
    }

    // Ajoute un employé à la liste
    public static void ajouterUnEmploye(Scanner scanner) {
        System.out.print("Entrez l'ID de l'employé: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Entrez le nom de l'employé: ");
        String nom = scanner.nextLine();

        System.out.print("Entrez le poste de l'employé: ");
        String poste = scanner.nextLine();

        System.out.print("Entrez le salaire de l'employé: ");
        double salaire = scanner.nextDouble();

        Employe employe = new Employe(id, nom, poste, salaire);
        ajouterEmploye(employe);
    }

    // Modifie les informations d'un employé
    public static void modifierUnEmploye(Scanner scanner) {
        System.out.print("Entrez l'ID de l'employé à modifier: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Entrez le nouveau nom: ");
        String nom = scanner.nextLine();

        System.out.print("Entrez le nouveau poste: ");
        String poste = scanner.nextLine();

        System.out.print("Entrez le nouveau salaire: ");
        double salaire = scanner.nextDouble();

        modifierEmploye(id, nom, poste, salaire);
    }

    // Supprime un employé en fonction de son ID
    public static void supprimerUnEmploye(Scanner scanner) {
        System.out.print("Entrez l'ID de l'employé à supprimer: ");
        int id = scanner.nextInt();

        supprimerEmploye(id);
    }

    // Recherche un employé par nom ou poste

    public static void rechercherUnEmploye(Scanner scanner) {
        System.out.print("Entrez le nom ou le poste de l'employé à rechercher: ");
        String critere = scanner.nextLine();

        rechercherEmploye(critere);
    }

    // Trie les employés par salaire selon l'ordre spécifié
    private static void trierEmployesParSalaire(Scanner scanner) {
        System.out.print("Voulez-vous trier les employés par salaire en ordre croissant (asc) ou décroissant (desc)? ");
        String reponse = scanner.nextLine().trim().toLowerCase();
        boolean ordreCroissant = reponse.equals("asc");
        trierEmployesParSalaireEtOrdre(ordreCroissant);
    }


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


    public static void trierEmployesParSalaireEtOrdre(boolean ordreCroissant) {
        for (int i = 0; i < nbrEmployes - 1; i++) {
            for (int j = 0; j < nbrEmployes - i - 1; j++) {
                if ((ordreCroissant && Employe.compareParSalaire(employes[j], employes[j + 1]) > 0) ||
                        (!ordreCroissant && Employe.compareParSalaire(employes[j], employes[j + 1]) < 0)) {
                    Employe temp = employes[j];
                    employes[j] = employes[j + 1];
                    employes[j + 1] = temp;
                }
            }
        }
        System.out.println("Employés triés par salaire :");
        afficherEmployes();
    }


    public static void calculerMasseSalariale() {
        double total = 0;
        for (int i = 0; i < nbrEmployes; i++) {
            total += employes[i].getSalaire();
        }
        System.out.println("Masse salariale totale: " + total);
    }



}
