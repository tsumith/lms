package PAT.LMS;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class UsersManager {

    File usersDb;

    public UsersManager() {
        usersDb = new File("C:\\sumith\\programming\\java\\PAT\\LMS\\UsersDb.txt");
        try {
            usersDb.createNewFile();

        } catch (IOException e) {
            System.out.println("cannot create file");
        }
    }

    public String getDetails(String username) {
        try {
            Scanner sc = new Scanner(usersDb);
            while (sc.hasNextLine()) {
                String userDetail = sc.nextLine();
                String[] userDetails = userDetail.split(" ");
                if (userDetails[0].equals(username)) {
                    System.out.println("username:" + userDetails[0]);
                    System.out.println("password:" + userDetails[1]);
                    System.out.println("email:" + userDetails[2]);
                    System.out.println("phone:" + userDetails[3]);
                    return userDetail;

                }

            }
            sc.close();

        } catch (FileNotFoundException e) {
            return "file not found";
        }

        return "No user found!";
    }
}
