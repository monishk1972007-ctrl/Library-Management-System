import java.util.ArrayList;
import java.util.Scanner;

class Book {
    int bookId;
    String title;
    String author;
    boolean issued;

    Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.issued = false;
    }

    void displayBook() {
        System.out.println(
            "ID: " + bookId +
            " | Title: " + title +
            " | Author: " + author +
            " | Status: " + (issued ? "Issued" : "Available")
        );
    }
}

class Member {
    int memberId;
    String name;

    Member(int memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }

    void displayMember() {
        System.out.println(
            "ID: " + memberId +
            " | Name: " + name
        );
    }
}

public class LibraryManagementSystem {

    static ArrayList<Book> books = new ArrayList<>();
    static ArrayList<Member> members = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Add Member");
            System.out.println("4. View Members");
            System.out.println("5. Issue Book");
            System.out.println("6. Return Book");
            System.out.println("7. Overdue Calculation");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addBook();
                    break;

                case 2:
                    viewBooks();
                    break;

                case 3:
                    addMember();
                    break;

                case 4:
                    viewMembers();
                    break;

                case 5:
                    issueBook();
                    break;

                case 6:
                    returnBook();
                    break;

                case 7:
                    overdueCalculation();
                    break;

                case 8:
                    System.out.println("Thank you for using the Library System!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 8);
    }

    static void addBook() {

        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();

        sc.nextLine();

        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Author Name: ");
        String author = sc.nextLine();

        books.add(new Book(id, title, author));

        System.out.println("Book added successfully!");
    }

    static void viewBooks() {

        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        System.out.println("\n----- BOOK LIST -----");

        for (Book book : books) {
            book.displayBook();
        }
    }

    static void addMember() {

        System.out.print("Enter Member ID: ");
        int id = sc.nextInt();

        sc.nextLine();

        System.out.print("Enter Member Name: ");
        String name = sc.nextLine();

        members.add(new Member(id, name));

        System.out.println("Member added successfully!");
    }

    static void viewMembers() {

        if (members.isEmpty()) {
            System.out.println("No members available.");
            return;
        }

        System.out.println("\n----- MEMBER LIST -----");

        for (Member member : members) {
            member.displayMember();
        }
    }

    static void issueBook() {

        System.out.print("Enter Book ID to issue: ");
        int id = sc.nextInt();

        for (Book book : books) {

            if (book.bookId == id) {

                if (!book.issued) {
                    book.issued = true;
                    System.out.println("Book issued successfully!");
                } else {
                    System.out.println("Book is already issued.");
                }

                return;
            }
        }

        System.out.println("Book not found.");
    }

    static void returnBook() {

        System.out.print("Enter Book ID to return: ");
        int id = sc.nextInt();

        for (Book book : books) {

            if (book.bookId == id) {

                if (book.issued) {
                    book.issued = false;
                    System.out.println("Book returned successfully!");
                } else {
                    System.out.println("Book was not issued.");
                }

                return;
            }
        }

        System.out.println("Book not found.");
    }

    static void overdueCalculation() {

        System.out.print("Enter number of overdue days: ");
        int days = sc.nextInt();

        int finePerDay = 5;
        int fine = days * finePerDay;

        if (days > 0) {
            System.out.println("Overdue Days: " + days);
            System.out.println("Fine Per Day: Rs." + finePerDay);
            System.out.println("Total Fine: Rs." + fine);
        } else {
            System.out.println("No overdue fine.");
        }
    }
}
