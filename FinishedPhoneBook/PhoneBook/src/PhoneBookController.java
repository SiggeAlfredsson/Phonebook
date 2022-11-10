import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class PhoneBookController {

    static Scanner in = new Scanner(System.in);

    public static void findPerson() {
        System.out.println("1. Find with Fullname");
        System.out.println("2. Find with Firstname");
        System.out.println("3. Find with Surname");
        System.out.println("4. Find with Address");
        System.out.println("5. Find with Areacode");
        System.out.println("6. Find with City");
        System.out.println("7. Find with ID");
        System.out.println("8. Free Search");

        int choice;
        do {
            choice = in.nextInt();
            in.nextLine();
            switch (choice) {
                case 1:
                    findByFullName();
                    break;
                case 2:
                    findByFirstname();
                    break;
                case 3:
                    findBySurname();
                    break;
                case 4:
                    findByAddress();
                    break;
                case 5:
                    findByAreaCode();
                    break;
                case 6:
                    findByCity();
                    break;
                case 7:
                    findByID();
                    break;
                case 8:
                    findByNumber();
                    break;
                case 9:
                    findByFreeSearch();
                    break;
                default:
                    System.out.print("Choose 1-8: ");
            }
        } while (!(choice >= 1 && choice <= 5));
        System.out.println();
    }

    public static void findBySurname() {
        System.out.print("Enter Surname: ");
        String surnameToFind = in.nextLine();
        int matches = 0;
        for (Contact contact : DataFile.people) {
            if (contact.getSurname().equalsIgnoreCase(surnameToFind)) {
                System.out.println(contact);
                matches++;
            }
        }
        if (matches <= 0) {
            System.out.println("There is no person with this surname");
        }
    }

    public static void findByFirstname () {
            System.out.print("Enter Firstname: ");
            String firstnameToFind = in.nextLine();
            int matches = 0;
            for (Contact contact : DataFile.people) {
                if (contact.getFirstName().equalsIgnoreCase(firstnameToFind)) {
                    System.out.println(contact);
                    matches++;
                }
            }
            if (matches <= 0) {
                System.out.println("There is no person with this firstname");
            }
        }

    public static void findByAddress() {
        System.out.print("Enter Address: ");
        String adressToFind = in.nextLine();
        int matches = 0;
        for (Contact contact : DataFile.people) {
            if (contact.getAddress().contains(adressToFind)) {
                System.out.println(contact);
                matches++;
            }
        }
        if (matches <= 0) {
            System.out.println("There is no person with this Address");
        }
    }

    public static void findByAreaCode() {
        System.out.print("Enter Area Code: ");
        String areaToFind = in.nextLine();
        String areaToFind1 = areaToFind.replaceAll("\\s", "");
        int matches = 0;
        for (Contact contact : DataFile.people) {
            String areaCode = contact.getAreaCode();
            areaCode = areaCode.replaceAll("\\s", "");
            if (areaCode.equals(areaToFind1)) {
                System.out.println(contact);
                matches++;
            }
        }
        if (matches <= 0) {
            System.out.println("There is no person with " + areaToFind + " as Areacode");
        }
    }

    public static void findByCity() {
        System.out.print("Enter City: ");
        String cityToFind = in.nextLine();
        int matches = 0;
        for (Contact contact : DataFile.people) {
            if (contact.getCity().equalsIgnoreCase(cityToFind)) {
                System.out.println(contact);
                matches++;
            }
        }
        if (matches <= 0) {
            System.out.println("No person lives in " + cityToFind);
        }
    }

    public static void findByNumber() {
        System.out.print("Enter Number: ");
        String numberToFind = in.nextLine();
        int matches = 0;
        for (Contact contact : DataFile.people) {
            if (contact.getMobile().equals(numberToFind) ||
                    contact.getHome().equals(numberToFind) ||
                    contact.getWork().equals(numberToFind)) {
                System.out.println(contact);
                matches++;
            }
        }
        if (matches <= 0) {
            System.out.println("No person with number: " + numberToFind);
        }
    }

    public static void findByID() {
        System.out.print("Enter ID: ");
        int idToFind = in.nextInt();
        int matches = 0;
        for (Contact contact : DataFile.people) {
            if (contact.getID() == (idToFind)) {
                System.out.println(contact);
                matches++;
            }
        }
        if (matches <= 0) {
            System.out.println("There is no person with this surname");
        }
    }

    public static void findByFullName() {
        System.out.print("Enter Fullname (Firstname Surname): ");
        String fullnameToFind = in.nextLine();
        fullnameToFind = fullnameToFind.replaceAll("\\s", "");
        int matches = 0;
        for (Contact contact : DataFile.people) {
            if (contact.getName().equalsIgnoreCase(fullnameToFind)) {
                System.out.println(contact);
                matches++;
            }
        }
        if (matches <= 0) {
            System.out.println("There is no person with this name ");
        }
    }

    public static void addPerson() {

        System.out.println("Enter Firstname: ");
        String firstname = in.nextLine();
        System.out.println("Enter Lastname: ");
        String surname = in.nextLine();
        System.out.println("Enter Age: ");
        String age = in.nextLine();
        System.out.println("Enter Address: ");
        String address = in.nextLine();
        System.out.println("Enter Area Code: ");
        String areaCode = in.nextLine();
        System.out.println("Enter City: ");
        String city = in.nextLine();
        System.out.println("Enter Mobile: ");
        String mobile = in.nextLine();
        System.out.println("Enter Home: ");
        String home = in.nextLine();
        System.out.println("Enter Work: ");
        String work = in.nextLine();

        Contact contact = new Contact(firstname, surname, age, address, areaCode, city, mobile, home, work);
        DataFile.people.add(contact);
        System.out.println("\nAdded person: " + contact);  //!! ID ?
        System.out.println();
    }

    public static void deletePerson() {
        System.out.println("Enter the ID of the person to remove");
        int idToDelete = in.nextInt();

        int matches = 0;
        List<Contact> found = new ArrayList<>();
        for (Contact contact : DataFile.people) {
            if (contact.getID() == idToDelete) {
                found.add(contact);
                System.out.println(contact);
                matches++;
            }
        }
      if (matches == 1){
            System.out.println("Are you sure you want to delete this contact? (Y/N)");
            in.nextLine();
            String choice = in.nextLine();

            if (choice.equalsIgnoreCase("Y")) {
                DataFile.people.removeAll(found);
                System.out.println("Contact is deleted.");
            }
        }
            if (matches <= 0) {
                System.out.println("There is no contact with this ID");

            }
        }

    public static void editPerson() {


        System.out.println("What do you want to edit?");
        System.out.println("1. Firstname");
        System.out.println("2. Lastname");
        System.out.println("3. Age");
        System.out.println("4. Phonenumber");
        System.out.println("5. Address");
        System.out.println("6. Area Code");
        System.out.println("7. City");
        // no one?

        int choice;
        do {
            choice = in.nextInt();
            switch (choice) {
                case 1:
                    editPersonFirstname();
                    break;
                case 2:
                    editPersonLastname();
                    break;
                case 3:
                    editPersonAge();
                    break;
                case 4:
                    editPersonPhoneNumber();
                    break;
                case 5:
                    editPersonAddress();
                    break;
                case 6:
                    editPersonAreaCode();
                    break;
                case 7:
                    editPersonCity();
                    break;
                default:
                    System.out.print("Choose 1-7: ");

            }
        } while (!(choice >= 1 && choice <= 7));
        System.out.println();

    }

    public static void editPersonFirstname () {
            System.out.println("Enter the ID of the contact to edit: ");  // back?
            int idToEdit = in.nextInt();
            in.nextLine();
            int matches = 0;
            for (Contact contact : DataFile.people) {
                if (contact.getID() == idToEdit) {
                    System.out.println(contact);
                    matches++;
                    System.out.println("Enter new Firstname: ");
                    String newFirstName = in.nextLine();
                    contact.setFirstName(newFirstName);
                    System.out.println("Contact updated:");
                    System.out.println(contact);

                }
                }
                if (matches <= 0) {
                    System.out.println("There is no contact with this ID");
            }
        }

    public static void editPersonLastname() {
        System.out.println("Enter the ID of the contact to edit: ");  // back?
        int idToEdit = in.nextInt();
        in.nextLine();
        int matches = 0;
        for (Contact contact : DataFile.people) {
            if (contact.getID() == idToEdit) {
                System.out.println(contact);
                matches++;
                System.out.println("Enter new Firstname: ");
                String newLastName = in.nextLine();
                contact.setSurname(newLastName);
                System.out.println("Contact updated:");
                System.out.println(contact);

            }
            if (matches <= 0) {
                System.out.println("There is no contact with this ID");
            }
        }
    }

    public static void editPersonAge() {
        System.out.println("Enter the ID of the contact to edit: ");  // back?
        int idToEdit = in.nextInt();
        in.nextLine();
        int matches = 0;
        for (Contact contact : DataFile.people) {
            if (contact.getID() == idToEdit) {
                System.out.println(contact);
                matches++;
                System.out.println("Enter new age: ");
                String newAge = in.nextLine();
                contact.setAge(newAge);
                System.out.println("Contact updated:");
                System.out.println(contact);

            }
            if (matches <= 0) {
                System.out.println("There is no contact with this ID");
            }
        }
    }

    public static void editPersonPhoneNumber() {
        System.out.println("Enter the ID of the contact to edit: ");  // back?
        int idToEdit = in.nextInt();
        in.nextLine();
        int matches = 0;
        for (Contact contact : DataFile.people) {
            if (contact.getID() == idToEdit) {
                System.out.println(contact);
                matches++;
                System.out.println("1.Mobile 2.Home 3.Work");
                int whichOne = in.nextInt();
                in.nextLine();
                if(whichOne==1) {
                    System.out.println("Enter new mobile: ");
                    String newPhoneNumber = in.nextLine();
                    contact.setMobile(newPhoneNumber);
                }else if( whichOne == 2) {
                    System.out.println("Enter new home: ");
                    String newPhoneNumber = in.nextLine();
                    contact.setHome(newPhoneNumber);
                }else if(whichOne == 3) {
                    System.out.println("Enter new work: ");
                    String newPhoneNumber = in.nextLine();
                    contact.setWork(newPhoneNumber);
                }
                System.out.println("Contact updated:");
                System.out.println(contact);
            }
            if (matches <= 0) {
                System.out.println("There is no contact with this ID");
            }
        }
    }

    public static void editPersonAddress() {
        System.out.println("Enter the ID of the contact to edit: ");  // back?
        int idToEdit = in.nextInt();
        in.nextLine();
        int matches = 0;
        for (Contact contact : DataFile.people) {
            if (contact.getID() == idToEdit) {
                System.out.println(contact);
                matches++;
                System.out.println("Enter new Address: ");
                String newAddress = in.nextLine();
                contact.setAddress(newAddress);
                System.out.println("Contact updated:");
                System.out.println(contact);

            }
            if (matches <= 0) {
                System.out.println("There is no contact with this ID");
            }
        }
    }

    public static void editPersonAreaCode() {
        System.out.println("Enter the ID of the contact to edit: ");  // back?
        int idToEdit = in.nextInt();
        in.nextLine();
        int matches = 0;
        for (Contact contact : DataFile.people) {
            if (contact.getID() == idToEdit) {
                System.out.println(contact);
                matches++;
                System.out.println("Enter new Area Code: ");
                String newAreaCode = in.nextLine();
                contact.setAreaCode(newAreaCode);
                System.out.println("Contact updated:");
                System.out.println(contact);

            }
            if (matches <= 0) {
                System.out.println("There is no contact with this ID");
            }
        }
    }

    public static void editPersonCity() {
        System.out.println("Enter the ID of the contact to edit: ");  // back?
        int idToEdit = in.nextInt();
        in.nextLine();
        int matches = 0;
        for (Contact contact : DataFile.people) {
            if (contact.getID() == idToEdit) {
                System.out.println(contact);
                matches++;
                System.out.println("Enter new City: ");
                String newCity = in.nextLine();
                contact.setCity(newCity);
                System.out.println("Contact updated:");
                System.out.println(contact);

            }
            if (matches <= 0) {
                System.out.println("There is no contact with this ID");
            }
        }
    }

    public static void findByFreeSearch() {
        System.out.print("Enter word?: ");
        String wordToSearch = in.nextLine();
        int matches = 0;
        for (Contact contact : DataFile.people) {
            if (contact.getFirstName().equalsIgnoreCase(wordToSearch)) {
                System.out.println(contact);
                matches++;
            } else if (contact.getSurname().equalsIgnoreCase(wordToSearch)) {
                System.out.println(contact);
                matches++;
            } else if (contact.getAge().equalsIgnoreCase(wordToSearch)) {
                System.out.println(contact);
                matches++;
            } else if (contact.getName().equalsIgnoreCase(wordToSearch)) {
                System.out.println(contact);
                matches++;
            } else if (contact.getAddress().equalsIgnoreCase(wordToSearch)) {
                System.out.println(contact);
                matches++;
            } else if (contact.getAreaCode().equalsIgnoreCase(wordToSearch)) {
                System.out.println(contact);
                matches++;
            } else if (contact.getCity().equalsIgnoreCase(wordToSearch)) {
                System.out.println(contact);
                matches++;
            } else if (contact.getMobile().equalsIgnoreCase(wordToSearch)) {
                System.out.println(contact);
                matches++;
            } else if (contact.getHome().equalsIgnoreCase(wordToSearch)) {
                System.out.println(contact);
                matches++;
            } else if (contact.getWork().equalsIgnoreCase(wordToSearch)) {
                System.out.println(contact);
                matches++;
            }
            if (matches <= 0) {
                System.out.println("No contact found");
            }
        }
    }
}
