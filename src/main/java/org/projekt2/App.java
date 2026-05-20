package org.projekt2;
import io.github.cdimascio.dotenv.Dotenv;
import org.projekt2.config.ConfigLoader;
import org.projekt2.config.DatabaseConnection;
import org.projekt2.config.SecurityUtil;
import org.projekt2.model.User;
import org.projekt2.service.UserService;
import java.util.Properties;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Wybierz sposób konfiguracji:");
        System.out.println("1 - AES encrypted config");
        System.out.println("2 - ENV file (.env)");

        String mode = scanner.nextLine();

        String dbUser;
        String dbPass;

        if (mode.equals("1")) {

            Properties props = ConfigLoader.load();

            System.out.print("Podaj master password: ");
            String masterKey = scanner.nextLine();

            dbUser = SecurityUtil.decrypt(
                    props.getProperty("db.user"), masterKey);

            dbPass = SecurityUtil.decrypt(
                    props.getProperty("db.password"), masterKey);

        } else {

            Dotenv dotenv = Dotenv.load();

            dbUser = dotenv.get("DB_USER");
            dbPass = dotenv.get("DB_PASSWORD");
        }

        DatabaseConnection.init(dbUser, dbPass);

        System.out.println("\nWitamy w aplikacji!");

        UserService service = new UserService();

        while (true) {

            System.out.print("\nCzy chcesz utworzyć użytkownika? (tak/nie): ");
            String answer = scanner.nextLine();

            if (answer.equalsIgnoreCase("nie")) {
                System.out.println("Zamykanie aplikacji...");
                break;
            }

            if (!answer.equalsIgnoreCase("tak")) {
                System.out.println("Niepoprawna odpowiedź.");
                continue;
            }

            System.out.print("Podaj username: ");
            String username = scanner.nextLine();

            System.out.print("Podaj hasło: ");
            String password = scanner.nextLine();

            User user = new User(username, password);

            service.createUser(user);

            System.out.println("Użytkownik został zapisany bezpiecznie.");
        }
        scanner.close();
    }
}