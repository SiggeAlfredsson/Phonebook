import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataFile {

    public static File file = new File("Phonebook.txt");
     static List<Contact> people = new ArrayList<>();


    public static void addToFile(Contact contact) {

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(contact.getFirstName()+"\n" + contact.getSurname() + "\n" + contact.getAge() +
                    "\n" + contact.getAddress() + "\n" + contact.getAreaCode() + "\n" + contact.getCity() + "\n" + contact.getMobile() + "\n" + contact.getHome() + "\n" + contact.getWork() + "\n\n");
        } catch(IOException e) {
            System.out.println(e);
        }
    }


    public static boolean loadAll() {
        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String name = null;
            while((name = reader.readLine()) != null) {
                Contact contact = new Contact(name,reader.readLine(), reader.readLine(), reader.readLine(),  reader.readLine(),reader.readLine(),reader.readLine(),reader.readLine(),reader.readLine());
                people.add(contact);        //add to list
                reader.readLine();
            }
            return true;
        }
        catch ( IOException e) {
            System.out.println(e);
        }
        return false;
    }
}
