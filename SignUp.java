package PAT.LMS;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SignUp {

    File usersDb;

    public SignUp() {
        usersDb = new File("C:\\sumith\\programming\\java\\PAT\\LMS\\UsersDb.txt");
    }

    public boolean addUser(String username, String password, String email, String phone) {
        try {
            if (!usersDb.exists()) {
                usersDb.createNewFile();
            }
        } catch (Exception e) {
            System.out.println("No file found");
        }

        if (usersDb.exists()) {
            try {
                FileWriter writer = new FileWriter(usersDb, true);
                writer.write(username + " " + password + " " + email + " " + phone + "\n");
                writer.flush();
                writer.close();
                System.out.println("user added");
                return true;
            } catch (IOException e) {
                System.out.println("Error in adding user!" + e.getMessage());
            }
        }
        return false;

    }

}
