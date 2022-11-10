import java.util.ArrayList;
import java.util.List;

public class UserProfile {

    // Skapa guest profil? Standardprofil?

    public static List<UserProfile> profiles = new ArrayList<>();
    private String username;
    private String password;
    private boolean isAdmin;

    public UserProfile(String username, String password, boolean isAdmin) {
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public static void addUserProfile(UserProfile userProfile) {
        profiles.add(userProfile);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }
}
