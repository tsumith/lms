package PAT.LMS;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Library {

    Scanner sc;
    File booksDb;

    public Library() {
        sc = new Scanner(System.in);
        booksDb = new File("C:\\sumith\\programming\\java\\PAT\\LMS\\BooksDb.txt");
        try {
            if (!booksDb.exists()) {
                booksDb.createNewFile();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public void searchBook() {

        System.out.println("Enter the book name :");
        String bookname = sc.next();
        String results = searchInDb(bookname);
        System.out.println("Book details: " + results);

    }

    public void returnBook(String name) {

    }

    public void addBook() {
        System.out.println("Enter book name:");
        String bookname = sc.nextLine();
        System.out.println("Enter the book author");
        String bookauthor = sc.nextLine();
        String status = "notAlloted";
        try {
            if (booksDb.exists()) {
                FileWriter writer = new FileWriter(booksDb, true);
                writer.write(bookname + " " + bookauthor + " " + status + "\n");
                writer.flush();
                writer.close();

            } else {
                System.out.println("doesn't exist booksDb");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public String searchInDb(String bookname) {

        try {
            if (booksDb.exists()) {
                sc = new Scanner(booksDb);
                String detail;
                while (sc.hasNextLine()) {
                    detail = sc.nextLine();
                    String[] details = detail.split(" ");
                    if (details[0].equals(bookname)) {
                        sc.close();
                        return detail;
                    }

                }
            } else {
                booksDb.createNewFile();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return "book not found";

    }
}
