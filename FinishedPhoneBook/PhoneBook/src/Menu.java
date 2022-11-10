import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Menu {
    static boolean exit = true;
    static boolean isAdmin = false;
    static boolean isSignedIn = false;
    static Scanner scanner = new Scanner(System.in);


    public static void runMenu() throws IOException {
        System.out.println("---------------------------------");
        System.out.println("    Welcome to the phonebook");
        System.out.println("---------------------------------");

        while(exit) {
            printMenu();
            int choice = getInput();
            performAction(choice);
        }
    }

    private static void printMenu() {

        System.out.println("\nWhat would you like to do?");
        System.out.println("Signed in: "+isSignedIn+"  |  Admin: "+isAdmin);
        System.out.println("1. Print all existing contacts");
        System.out.println("2. Add a contact");
        System.out.println("3. Search for a contact");
        if (isAdmin) {
            System.out.println("4. Update contact");
            System.out.println("5. Delete contact");
            System.out.println("6. Sign out and exit program");
        } else {
            System.out.println("4. Sign in");
            System.out.println("5. Exit program");
        }
    }

    private static int getInput() {
        int choice = -1;
        while (choice < 0 || choice > 6) {
            try {
                System.out.println("\nEnter your choice: ");
                choice = Integer.parseInt(scanner.nextLine());

            }
            catch (NumberFormatException e) {
                System.out.println("Invalid selection. Please try again.");
            }
        }
        return choice;
    }

    private static void performAction(int choice) throws IOException {
        switch (choice) {
            case 1:
                System.out.println(DataFile.people);
                break;
            case 2:
                PhoneBookController.addPerson();
                break;
            case 3:
                PhoneBookController.findPerson();
                break;
            case 4:
                if(isAdmin){
                    PhoneBookController.editPerson();
                } else {
                    Login();
                }
                break;
            case 5:
                if(isAdmin){
                    PhoneBookController.deletePerson();
                } else {
                   ExitProgram();
                   break;
                }
                break;

            case 6:
                ExitProgram();
                break;
            default:
                System.out.println("ERROR");
        }
    }

    private static void Login() {


        System.out.println("Enter username:");
        String userUsername = scanner.nextLine();
        for (UserProfile userProfile : UserProfile.profiles) {
            if(userUsername.equals(userProfile.getUsername())) {
                System.out.println("Enter Password: ");
                String userPassword = scanner.nextLine();
                if(userPassword.equals(userProfile.getPassword())) {
                    System.out.println("You are now signed in.");
                    isSignedIn=true;
                    if(userProfile.isAdmin()) {
                        isAdmin=true;
                    }
                } else {
                    System.out.println("Incorrect password.");
                }
            } else {
                System.out.println("Found no profile with that username.");
            }
        }
    }

    private static void ExitProgram() throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(DataFile.file);
        writer.print("");  //clears file
        writer.close();
        for (Contact contact : DataFile.people) {  //from list to file
            DataFile.addToFile(contact);
        }
        exit = false;
    }

}
