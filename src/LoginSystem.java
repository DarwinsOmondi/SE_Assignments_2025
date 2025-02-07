import java.io.Console;
import java.util.Scanner;

public class LoginSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Set your username: ");
        String correctUsername = scanner.nextLine();

        System.out.print("Set your password: ");
        String correctPassword = readPassword();

        System.out.println("\nRegistration successful! Now, login.\n");

        int attempts = 3;

        while (attempts > 0) {
            System.out.print("Enter username: ");
            String username = scanner.nextLine();

            System.out.print("Enter password: ");
            String password = readPassword();

            if (username.equals(correctUsername) && password.equals(correctPassword)) {
                System.out.println("Login successful!");
                return;
            } else {
                attempts--;
                System.out.println("Incorrect username or password. Attempts left: " + attempts);
            }
        }

        System.out.println("Too many failed attempts. Exiting.");
    }

    public static String readPassword() {
        Console console = System.console();
        if (console != null) {
            char[] passwordArray = console.readPassword();
            return new String(passwordArray);
        } else {
            Scanner scanner = new Scanner(System.in);
            return scanner.nextLine();
        }
    }
}
