4.2.A Java program to store playing cards in a collection (HashMap). Users can add cards and find all cards of a specific symbol.
import java.util.*;

public class CardCollection {
    static HashMap<String, ArrayList<String>> cards = new HashMap<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1. Add Card\n2. Show Cards by Symbol\n3. Display All\n4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: addCard(); break;
                case 2: showCardsBySymbol(); break;
                case 3: displayAllCards(); break;
                case 4: System.exit(0);
                default: System.out.println("Invalid choice! Try again.");
            }
        }
    }

    static void addCard() {
        System.out.print("Enter Symbol (e.g., Hearts, Spades): ");
        String symbol = scanner.nextLine();
        System.out.print("Enter Card Name (e.g., Ace, King, 10): ");
        String cardName = scanner.nextLine();

        cards.putIfAbsent(symbol, new ArrayList<>());
        cards.get(symbol).add(cardName);

        System.out.println("Card added successfully!");
    }

    static void showCardsBySymbol() {
        System.out.print("Enter Symbol: ");
        String symbol = scanner.nextLine();
        if (cards.containsKey(symbol)) {
            System.out.println("Cards in " + symbol + ": " + cards.get(symbol));
        } else {
            System.out.println("No cards found for this symbol.");
        }
    }

    static void displayAllCards() {
        if (cards.isEmpty()) {
            System.out.println("No cards found!");
        } else {
            for (Map.Entry<String, ArrayList<String>> entry : cards.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }
}
