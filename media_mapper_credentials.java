import java.util.Scanner;

public class media_mapper_credentials {
    int MAXSIZE = 1000;
    Scanner sc = new Scanner(System.in);
    int user_count = 0;
    String[] usernames = new String[MAXSIZE];
    String[] passwords = new String[MAXSIZE];

    public int CreateUser() {
        System.out.println("Please enter your desired username: ");
        while (true) {
            String username = sc.nextLine();
            if (CheckUnique(username, usernames) == 1) {
                System.out.println("Username is already taken. Enter a new one: ");
                continue;
            }
            usernames[user_count] = username; // Store the username
            System.out.println("Please enter your desired password: ");
            passwords[user_count] = sc.nextLine(); // Store the password
            user_count++; // Increment after storing
            return 0;
        }
    }

    // overload for testing
    public int CreateUser(String un, String pwd) {
        if (CheckUnique(un, usernames) == 1) {
            System.out.println("Username is already taken. Enter a new one: ");
            return 1;
        }
        usernames[user_count] = un; // Store the username
        passwords[user_count] = pwd; // Store the password
        user_count++; // Increment after storing
        return 0;
    }

    public int CheckUnique(String string, String[] array) {
        for (int i = 0; i < user_count; i++) { // Check up to user_count
            if (string.equals(array[i])) {
                return 1;
            }
        }
        return 0;
    }

    public int VerifyLogin() {
        int index = VerifyUsername();
        int tries = 3;
        String entered_pwd = "";
        while (!entered_pwd.equals(passwords[index])) {
            if (tries == 0) {
                System.out.println("You have run out of tries!");
                return 1;
            }
            System.out.println("Please enter your password: ");
            entered_pwd = sc.nextLine();
            tries--;
        }
        System.out.println("You are now logged in!");
        return 0;
    }

    public int VerifyUsername() {
        String username;
        while (true) {
            System.out.println("Please enter your username: ");
            username = sc.nextLine();
            for (int i = 0; i < user_count; i++) {
                if (username.equals(usernames[i])) {
                    return i;
                }
            }
            System.out.println("Username not found. Try again:");
        }
    }
}
