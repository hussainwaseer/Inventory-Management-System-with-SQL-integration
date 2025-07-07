import java.sql.*;
import java.util.Scanner;
public class Main{
    static Scanner scanner = new Scanner(System.in);
    static Statement statement;
    static final String databaseusername="root";
    static final String databasepassword="root";
    static final String databasepath="jdbc:mysql://localhost:3306/inventory_system";
    static String username;
    static String password;
    static int userId;
    static boolean run=true;
    static{
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection databaseConnection = DriverManager.getConnection(databasepath,databaseusername,databasepassword);
         statement = databaseConnection.createStatement();
    }catch(Exception e){
        System.out.println(e.getMessage());
    }
    }


    public static void welcome(){
        System.out.println("********************************");
        System.out.println("     INVENTORY MANAGEMENT");
        System.out.println("********************************");
        System.out.println("1 for login\n2. for signup\n3. for exit");
    }


    public static void login(){
        System.out.println("********************************");
        System.out.println("         LOGIN                  ");
        System.out.println("********************************");
        System.out.print("Enter your username: ");
        scanner.nextLine();
        String getUsername=scanner.nextLine();
        System.out.print("Enter your password: ");
        String getPassword=scanner.nextLine();
        String query = "select * from users;";
        String U=null;
        String P=null;
        int I=0;
        boolean got=false;
        try{
        ResultSet resultSet = statement.executeQuery(query);
        while(resultSet.next()){
            U=resultSet.getNString("name");
            P = resultSet.getNString("password");
            I = resultSet.getInt("user_id");
            if(getUsername.equals(U) && getPassword.equals(P)){
                got=true;
                break;
            }

        }
            if(got){
                userId=I;
                username=U;
                password=P;
                System.out.println("Login succesful");
                mainMenu();
            }
            else{
                System.out.println("login failed");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void signup(){
        System.out.println("********************************");
        System.out.println("             SIGNUP              ");
        System.out.println("********************************");
        scanner.nextLine();
        System.out.print("Enter username to create: ");
        String user=scanner.nextLine();
        System.out.print("Enter password to create: ");
        String pass=scanner.next();
        try {
            String query = "insert into users (name,password) values('" + user + "','" + pass + "');";
            int Rows = statement.executeUpdate(query);
            if (Rows > 0) {
                System.out.println("created succesfullly");
                login();
            } else {
                System.out.println("OOPS SOME ERROR CAME!");
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void categories(){
        System.out.println("********************************");
        System.out.println("           Categories           ");
        System.out.println("********************************");
        String query = "select * from categories;";
        try{
            ResultSet resultSet = statement.executeQuery(query);
            System.out.println("Category_ID \t\t Category_Name");
            while(resultSet.next()){
                int id = resultSet.getInt("category_id");
                String name = resultSet.getNString("name");
                System.out.print(" "+id+"\t\t\t\t\t");
                System.out.println(name);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        System.out.print("Do you want to insert a new category?:(1 to yes or 2 to no): ");
        int choice= scanner.nextInt();
        if(choice==1){
            insertCategory();
        }
        else{
            mainMenu();
        }
    }

    public static void insertCategory(){
        scanner.nextLine();
        System.out.print("insert category name: ");
        String cname=scanner.nextLine();
        String query = "insert into categories (name) value('"+cname+"');";
        try{
            int rows = statement.executeUpdate(query);
            if(rows>0){
                System.out.println("category added succesfully!!");
                mainMenu();
            }
            else{
                System.out.println("error occured");
                mainMenu();
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void products() {
        System.out.println("********************************");
        System.out.println("           PRODUCTS            ");
        System.out.println("********************************");
        String query = "select * from products;";
        try {
            ResultSet resultSet = statement.executeQuery(query);
            System.out.println("Product_ID\tName\t\tCategory_ID\tSupplier_ID");
            while (resultSet.next()) {
                int id = resultSet.getInt("product_id");
                String name = resultSet.getNString("name");
                int catId = resultSet.getInt("category_id");
                int supId = resultSet.getInt("supplier_id");
                System.out.println(id + "\t\t\t\t" + name + "\t\t" + catId + "\t\t" + supId);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.print("Do you want to insert a new product? (1 to yes, 2 to no): ");
        int choice = scanner.nextInt();
        if (choice == 1) {
            insertProduct();
        } else {
            mainMenu();
        }
    }

    public static void insertProduct() {
        scanner.nextLine();
        System.out.print("Insert product name: ");
        String pname = scanner.nextLine();
        System.out.print("Insert category ID: ");
        int catId = scanner.nextInt();
        System.out.print("Insert supplier ID: ");
        int supId = scanner.nextInt();

        String query = "insert into products (name, category_id, supplier_id) values('" + pname + "', " + catId + ", " + supId + ");";
        try {
            int rows = statement.executeUpdate(query);
            if (rows > 0) {
                System.out.println("Product added successfully!");
            } else {
                System.out.println("Error occurred");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        mainMenu();
    }
    public static void suppliers() {
        System.out.println("********************************");
        System.out.println("           SUPPLIERS           ");
        System.out.println("********************************");
        String query = "select * from suppliers;";
        try {
            ResultSet resultSet = statement.executeQuery(query);
            System.out.println("Supplier_ID \t\t Supplier_Name");
            while (resultSet.next()) {
                int id = resultSet.getInt("supplier_id");
                String name = resultSet.getNString("name");
                System.out.println(" " + id + "\t\t\t\t" + name);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.print("Do you want to insert a new supplier? (1 to yes, 2 to no): ");
        int choice = scanner.nextInt();
        if (choice == 1) {
            insertSupplier();
        } else {
            mainMenu();
        }
    }

    public static void insertSupplier() {
        scanner.nextLine();
        System.out.print("Insert supplier name: ");
        String sname = scanner.nextLine();
        String query = "insert into suppliers (name) value('" + sname + "');";
        try {
            int rows = statement.executeUpdate(query);
            if (rows > 0) {
                System.out.println("Supplier added successfully!");
            } else {
                System.out.println("Error occurred");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        mainMenu();
    }

    public static void stockEntries() {
        System.out.println("********************************");
        System.out.println("         STOCK ENTRIES         ");
        System.out.println("********************************");
        String query = "select * from stock_entries;";
        try {
            ResultSet resultSet = statement.executeQuery(query);
            System.out.println("Entry_ID\tProduct_ID\tQuantity\tDate");
            while (resultSet.next()) {
                int id = resultSet.getInt("entry_id");
                int pid = resultSet.getInt("product_id");
                int qty = resultSet.getInt("quantity");
                Date date = resultSet.getDate("entry_date");
                System.out.println(id + "\t\t" + pid + "\t\t" + qty + "\t\t" + date);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.print("Do you want to insert a new stock entry? (1 to yes, 2 to no): ");
        int choice = scanner.nextInt();
        if (choice == 1) {
            insertStockEntry();
        } else {
            mainMenu();
        }
    }

    public static void insertStockEntry() {
        System.out.print("Insert product ID: ");
        int pid = scanner.nextInt();
        System.out.print("Insert quantity: ");
        int qty = scanner.nextInt();
        String query = "insert into stock_entries (product_id, quantity, entry_date) values(" + pid + ", " + qty + ", CURDATE());";
        try {
            int rows = statement.executeUpdate(query);
            if (rows > 0) {
                System.out.println("Stock entry added successfully!");
            } else {
                System.out.println("Error occurred");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        mainMenu();
    }

    public static void  mainMenu(){
            System.out.println("********************************");
            System.out.println("        MAIN MENU");
            System.out.println("********************************");
            System.out.println("1. View Categories");
            System.out.println("2. View Suppliers");
            System.out.println("3. View Products");
            System.out.println("4. View Stock Entries");
            System.out.println("5. Logout");
            System.out.print("Enter choice: ");
            int choice=scanner.nextInt();
            switch (choice){
                case 1:
                    categories();
                    break;
                case 2:
                    suppliers();
                    break;
                case 3:
                    products();
                    break;
                case 4:
                    stockEntries();
                    break;
                case 5:
                    run=false;
                    break;
                default:

            }
    }

    public static void main(String[] args) {


        do{
            welcome();
            System.out.print("Enter your choice: ");
            int getinput=scanner.nextInt();
            switch(getinput){
                case 1:
                    login();
                    break;
                case 2:
                    signup();
                    break;
                case 3:
                    run=false;
                    break;
                default:
                    System.out.println("Wrong input");
            }
        }while(run);
    }
}