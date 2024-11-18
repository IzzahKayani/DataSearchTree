import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Main
{
    // takes user input of an id and prints out the corresponding fields if it exists within the tree
    public static void search(RedBlackTree<String, Product> rbt, Scanner user)
    {
        System.out.print("\nSearch for id: ");
        String input = user.nextLine();

        if(rbt.contains(input))
        {
            Product foundProduct = rbt.get(input);
            String category = foundProduct.getCategory();
            if(category == "")
                category = "No entry given";

            System.out.println("Id: " + input + "\nName: " + foundProduct.getName() + "\nCategory: "
                    + category + "\nPrice: " + foundProduct.getPrice());
        }
        else
            System.out.println("No such product with id: " + input);
    }

    public static void main(String[] args) throws FileNotFoundException {
        RedBlackTree<String, Product> rbt = new RedBlackTree<>();

        Scanner user = new Scanner(System.in);
        Scanner sc = new Scanner(new File("amazon-product-data.csv"));
        sc.useDelimiter("\n");
        sc.next();

        while(sc.hasNext())
        {
            // tokens are split between each field column
            String[] tokens = sc.next().split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

            if(tokens.length >= 3) //checks if line has at least 3 fields
            {
                String id = tokens[0];
                String name = tokens[1].replace("\"", ""); // removes quotes from name if present
                String category = tokens[2];
                String price = ""; //set to blank in case the price is missing
                if(tokens.length > 3)
                    price = tokens[3];

                Product product = new Product(name, category, price); //product class holds the name, category, and price
                rbt.put(id, product); // id is the key while the value is set to the product class
            }
        }
        sc.close();

        //lets the user search for an id
        System.out.print("\nWould you like to search? (y/n): ");
        String input = user.nextLine();
        while (!input.equals("n"))
        {
            search(rbt, user);
            System.out.print("\nWould you like to search? (y/n): ");
            input = user.nextLine();
        }
        user.close();

        // Inserting a duplicate id
        System.out.println("\nNow inserting a duplicate product id that is already in the tree");
        Product newProduct = new Product("Losi Ride Height Gauge", "Toys & Games", "$11.99");
        rbt.put("54f37f5ba4be7549cdf4a945bf1bdaad",newProduct);

        //Inserting a new id
        System.out.println("\nNow inserting a brand new product and id");
        newProduct = new Product("IPhone 13 Case","Phone Cases ","$11.59");
        String newId = "2bb91aefb3468ed83860e0e2711c5f10";
        rbt.put(newId, newProduct);

        //Confirming new id was added to the tree
        System.out.println("Searching the id that was just inserted to make sure it was properly implemented into the tree:");
        Product foundProduct = rbt.get(newId);
        System.out.println("Id: " + newId + "\nName: " + foundProduct.getName() + "\nCategory: "
                + foundProduct.getCategory() + "\nPrice: " + foundProduct.getPrice());
    }
}