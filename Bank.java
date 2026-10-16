import java.io.*;
import java.util.*;
import java.util.stream.*;

// ---------- 4. Exception Handling: custom exception ----------
class InsufficientFundsException extends Exception {
    InsufficientFundsException(String msg) { super(msg); }
}

// ---------- 4. OOP: Account class (encapsulation) ----------
class Account {
    private String id, name, pin;
    private double balance;
    private List<String> history = new ArrayList<>();

    Account(String id, String name, String pin, double balance) {
        this.id = id; this.name = name; this.pin = pin; this.balance = balance;
    }

    String getId() { return id; }
    String getName() { return name; }
    double getBalance() { return balance; }
    List<String> getHistory() { return history; }
    boolean checkPin(String p) { return pin.equals(p); }

    void deposit(double amt) {
        if (amt <= 0) throw new IllegalArgumentException("Amount must be positive.");
        balance += amt;
        history.add("DEPOSIT:" + amt);
    }

    void withdraw(double amt) throws InsufficientFundsException {
        if (amt <= 0) throw new IllegalArgumentException("Amount must be positive.");
        if (amt > balance) throw new InsufficientFundsException("Not enough balance!");
        balance -= amt;
        history.add("WITHDRAW:" + amt);
    }

    // ---------- 5. Strings: build a line to save in a file ----------
    String toFileLine() { return String.join(",", id, name, pin, String.valueOf(balance)); }
}

public class Bank{
    static Map<String, Account> accounts = new HashMap<>();
    static final String FILE = "accounts.txt";
    static Scanner sc = new Scanner(System.in);

    // ---------- 3. Arrays: note denominations ----------
    static int[] notes = {500, 200, 100, 50};

    // ---------- 3. Methods + Recursion ----------
    // Recursive: balance after 'years' with 5% yearly interest
    static double futureValue(double amount, int years) {
        if (years == 0) return amount;                 // base case
        return futureValue(amount * 1.05, years - 1);  // recursive case
    }

    static void showNotes(int amount) {
        for (int n : notes) {
            int count = amount / n;
            if (count > 0) System.out.println("  " + count + " x Rs." + n);
            amount %= n;
        }
    }

    // ---------- 5. File I/O ----------
    static void loadAccounts() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] p = line.split(",");   // String splitting
                accounts.put(p[0], new Account(p[0], p[1], p[2], Double.parseDouble(p[3])));
            }
        } catch (IOException e) {
            // First run: create default accounts
            accounts.put("101", new Account("101", "Asha", "1234", 5000));
            accounts.put("102", new Account("102", "Ravi", "4321", 8000));
        }
    }

    static void saveAccounts() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE))) {
            accounts.values().forEach(a -> pw.println(a.toFileLine()));
        } catch (IOException e) {
            System.out.println("Could not save: " + e.getMessage());
        }
    }

    static Account login() {
        // ---------- 2. Iteration: 3 attempts ----------
        for (int attempt = 1; attempt <= 3; attempt++) {
            System.out.print("Account ID: ");
            String id = sc.nextLine().trim();
            System.out.print("PIN: ");
            String pin = sc.nextLine().trim();
            Account a = accounts.get(id);
            if (a != null && a.checkPin(pin)) return a;
            System.out.println("Wrong ID or PIN. Attempt " + attempt + "/3");
        }
        return null;
    }

    static double readAmount() {
        System.out.print("Enter amount: ");
        return Double.parseDouble(sc.nextLine());  // may throw NumberFormatException
    }

    public static void main(String[] args) {
        loadAccounts();
        System.out.println("===== WELCOME TO SIMPLE ATM =====");
        Account user = login();
        if (user == null) {
            System.out.println("Too many failed attempts. Card blocked.");
            return;
        }
        System.out.println("Hello, " + user.getName().toUpperCase() + "!");

        boolean running = true;
        // ---------- 2. Control flow: loop + switch ----------
        while (running) {
            System.out.println("\n1.Balance 2.Deposit 3.Withdraw 4.Statement 5.Future Value 6.Exit");
            System.out.print("Choose: ");
            String choice = sc.nextLine().trim();

            try {
                switch (choice) {
                    case "1":
                        System.out.println("Balance: Rs." + user.getBalance());
                        break;
                    case "2":
                        user.deposit(readAmount());
                        System.out.println("Deposited. New balance: Rs." + user.getBalance());
                        break;
                    case "3":
                        double amt = readAmount();
                        user.withdraw(amt);
                        System.out.println("Collect your cash:");
                        showNotes((int) amt);
                        break;
                    case "4":
                        showStatement(user);
                        break;
                    case "5":
                        System.out.println("Balance after 3 years @5%: Rs."
                                + String.format("%.2f", futureValue(user.getBalance(), 3)));
                        break;
                    case "6":
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (InsufficientFundsException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Error: please enter a valid number.");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        saveAccounts();
        System.out.println("Thank you! Data saved.");
    }
// vaideesh
    // ---------- 6. Streams & Collections ----------
    static void showStatement(Account a) {
        List<String> h = a.getHistory();
        if (h.isEmpty()) {
            System.out.println("No transactions yet.");
            return;
        }
        h.forEach(t -> System.out.println("  " + t));

        double totalDeposits = h.stream()
                .filter(t -> t.startsWith("DEPOSIT"))
                .mapToDouble(t -> Double.parseDouble(t.split(":")[1]))
                .sum();

        double totalWithdrawn = h.stream()
                .filter(t -> t.startsWith("WITHDRAW"))
                .mapToDouble(t -> Double.parseDouble(t.split(":")[1]))
                .sum();

        System.out.println("Total deposited: Rs." + totalDeposits);
        System.out.println("Total withdrawn: Rs." + totalWithdrawn);

        // Library algorithm: sort all accounts by balance (highest first)
        String ranking = accounts.values().stream()
                .sorted(Comparator.comparingDouble(Account::getBalance).reversed())
                .map(Account::getName)
                .collect(Collectors.joining(" > "));
        System.out.println("Richest to poorest: " + ranking);
    }
}
