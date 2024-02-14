public class LoginValidator {
    public static void main(String[] args) {
        String login = "example_login123";
        String password = "D_1hWiKjjP_9";
        String confirmPassword = "D_1hWiKjjP_9";

        try {
            validateLogin(login);
            validatePasswords(password, confirmPassword);
            System.out.println("Login and passwords are valid.");
        } catch (WrongLoginException | WrongPasswordException | PasswordMismatchException e) {
            System.out.println("Login or passwords are not valid: " + e.getMessage());
        }
    }

    public static void validateLogin(String login) throws WrongLoginException {
        if (login.length() > 20 || !login.matches("[a-zA-Z0-9_]+")) {
            throw new WrongLoginException("Login is invalid.");
        }
    }

    public static void validatePasswords(String password, String confirmPassword) throws WrongPasswordException, PasswordMismatchException {
        if (password.length() > 20 || !password.matches("[a-zA-Z0-9_]+")) {
            throw new WrongPasswordException("Password is invalid.");
        }

        if (!password.equals(confirmPassword)) {
            throw new PasswordMismatchException("Passwords do not match.");
        }
    }
}






