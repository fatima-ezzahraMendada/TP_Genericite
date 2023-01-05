import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        int x = 0;
        long id = 0l;
        String nom = "";
        String marque = "";
        double prix = 0f;
        String description = "";
        int stock = 0;

        MetierProduitImpl m = new MetierProduitImpl();
        Produit p = new Produit(1l, "pc", "lenovo", 8000.00f, "i5", 85);
        m.add(p);


        do {
            System.out.println("Welcome to Product app, choose one of the operations:");
            System.out.println("************************************************************");
            System.out.println("1. Display list of products.");
            System.out.println("2. Search product by Id.");
            System.out.println("3. Add new product.");
            System.out.println("4. Delete product by Id.");
            System.out.println("5. Logout.");

            Scanner sc = new Scanner(System.in);
            x = sc.nextInt();


            switch (x) {
                case 1:
                    for (Produit pro : m.getAll()) {
                        System.out.println(pro);
                    }
                    break;

                case 2:
                    System.out.println("Enter the id");
                    Scanner scd = new Scanner(System.in);
                    System.out.println(m.findById(scd.nextLong()).toString());
                    break;

                case 3:
                    Produit produit = new Produit();
                    System.out.print("Enter the id :");
                    id = sc.nextLong();
                    produit.setId(id);
                    if (m.findById(id) != null) {
                        System.out.println("Id already exist, choose another one.");
                        break;
                    }
                    System.out.print("Enter product name :");
                    nom = sc.next();
                    produit.setNom(nom);

                    System.out.print("Enter the product brand :");
                    marque = sc.next();
                    produit.setMarque(marque);

                    System.out.print("Enter the product price :");
                    prix = sc.nextFloat();
                    produit.setPrix(prix);

                    System.out.print("Enter the product description :");
                    description = sc.next();
                    produit.setDescription(description);

                    System.out.print("Enter the product stock :");
                    stock = sc.nextInt();
                    produit.setNbrStock(stock);
                    m.add(produit);

                    for (Produit pro : m.getAll()) {
                        System.out.println(pro);
                    }
                    System.out.print("the product was successfully insert");
                    break;

                case 4:
                    System.out.println("Enter the id :");
                    id = sc.nextLong();
                    m.delete(id);
                    break;

                case 5:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        } while (x != 5);

    }
}

