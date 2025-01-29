package PAT.LMS;

import java.util.Scanner;

public class Dashboard {

    private String user;
    Scanner sc = new Scanner(System.in);

    Dashboard(String username) {
        this.user = username;
    }

    public void showDashBoard() {
        System.out.println("User DashBoard: ");
        System.out.println("1.Search book ");
        System.out.println("2.add book");
        System.out.println("3.return book");
        System.out.println("4.Exit");
        System.out.println("Choose an option an option: ");
        int option = sc.nextInt();
        Library lib = new Library();
        switch (option) {
            case 1:
                System.out.println("in the library");
                lib.searchBook();
                break;
            case 2:
                lib.addBook();
                break;
            case 3:
            default:
                System.out.println("Enter Valid Option");
        }

    }

}
