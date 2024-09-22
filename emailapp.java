import java.util.Random;
import java.util.Scanner;

class EmailApp {

    String password, fname, lname, dept, emailId;
    int capacity = 15;
    Scanner inp = new Scanner(System.in);

    void gen_email() {
        emailId = fname.toLowerCase() + "." + lname.toLowerCase() + "@" + (dept.equals("none") ? "apple" : dept.toLowerCase() + ".apple") + ".com";
    }

    void gen_pass() {
        StringBuilder sb = new StringBuilder(15);
        Random rand = new Random();
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890!@#$%^&*()";
        for (int i = 0; i < 15; i++) {
            int index = rand.nextInt(letters.length());
            sb.append(letters.charAt(index));
        }
        password = sb.toString();
    }

    void defaults() {
        System.out.print("Do you have a designated dept (y/n): ");
        char ch = inp.next().charAt(0);
        inp.nextLine(); // Clear the buffer
        if (ch == 'y' || ch == 'Y') {
            System.out.print("Enter your dept: ");
            dept = inp.nextLine();
        } else {
            dept = "none";
        }
        System.out.print("Enter your first name and last name: ");
        fname = inp.nextLine();
        lname = inp.nextLine();
    }

    void change() {
        System.out.print("Would you like to change your password (y/n): ");
        char ch = inp.next().charAt(0);
        inp.nextLine(); // Clear the buffer
        if (ch == 'y' || ch == 'Y') {
            System.out.print("Enter your new password: ");
            password = inp.nextLine();
        }
        System.out.print("Would you like to change your email capacity (y/n): ");
        ch = inp.next().charAt(0);
        inp.nextLine(); // Clear the buffer
        if (ch == 'y' || ch == 'Y') {
            System.out.print("Enter your new capacity: ");
            capacity = inp.nextInt();
            inp.nextLine(); // Clear the buffer
        }
        System.out.print("Would you like to change your email id (y/n): ");
        ch = inp.next().charAt(0);
        inp.nextLine(); // Clear the buffer
        if (ch == 'y' || ch == 'Y') {
            System.out.print("Enter your new Email id: ");
            emailId = inp.nextLine();
            fname = emailId.substring(0, emailId.indexOf('.'));
            lname = emailId.substring(emailId.indexOf('.') + 1, emailId.indexOf('@'));
            if (emailId.contains(".")) {
                dept = emailId.substring(emailId.indexOf('.') + 1, emailId.indexOf('@'));
            } else {
                dept = "none";
            }
            gen_email();
        }
    }

    void disp() {
        System.out.println("Email: " + emailId);
        System.out.println("Password: " + password);
        System.out.println("Capacity: " + capacity);
    }
}

class Run {
    public static void main(String[] args) {
        EmailApp e = new EmailApp();
        e.defaults();
        e.gen_email();
        e.gen_pass();
        e.change();
        e.disp();
    }
}
