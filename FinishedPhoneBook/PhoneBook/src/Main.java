import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        UserProfile admin = new AdminUserProfile("admin", "admin");
        UserProfile.addUserProfile(admin); // Finns ännu ingen klass för detta


        DataFile.loadAll(); // Laddar kontakter från txtfil till list people
        Menu.runMenu();

    }
}