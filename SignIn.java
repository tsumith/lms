package PAT.LMS;

import java.io.File;
import java.util.Scanner;

public class SignIn {

    private String username;
    File usersDb;

    public SignIn(String usname, String pass) {
        usersDb = new File("C:\\sumith\\programming\\java\\PAT\\LMS\\UsersDb.txt");
        this.username = usname;
        boolean checked = findUser(username, pass);
        if (checked) {
            System.out.println("user found");
        } else {
            System.out.println("user not found");
        }

    }

    public boolean findUser(String username, String password) {
        if (usersDb.exists()) {
            try {
                Scanner sc = new Scanner(usersDb);
                while (sc.hasNextLine()) {
                    String userDetails = sc.nextLine();
                    String[] details = userDetails.split(" ");
                    if (details[0].equals(username) && details[1].equals(password)) {
                        return true;
                    }
                }

            } catch (Exception e) {
                return false;
            }
        }
        return false;

    }

    public void showDBoard() {
        Dashboard dboard = new Dashboard(username);
        dboard.showDashBoard();
    }

}
