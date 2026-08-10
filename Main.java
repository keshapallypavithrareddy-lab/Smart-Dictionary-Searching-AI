import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Dictionary dictionary = new Dictionary();

        // Sample words
     // Sample words
dictionary.addWord(
        "apple",
        "A round fruit."
);

dictionary.addWord(
        "application",
        "A software program."
);

dictionary.addWord(
        "apply",
        "To put something into use."
);

dictionary.addWord(
        "app",
        "Short form of application."
);

dictionary.addWord(
        "banana",
        "A yellow fruit."
);

dictionary.addWord(
        "computer",
        "An electronic device used for processing data."
);

dictionary.addWord(
        "program",
        "A set of instructions given to a computer."
);

dictionary.addWord(
        "programming",
        "The process of creating computer programs."
);

dictionary.addWord(
        "algorithm",
        "A step-by-step procedure for solving a problem."
);

dictionary.addWord(
        "database",
        "An organized collection of data."
);

dictionary.addWord(
        "developer",
        "A person who creates software applications."
);

dictionary.addWord(
        "development",
        "The process of creating and improving software."
);

dictionary.addWord(
        "debugging",
        "The process of finding and fixing errors in a program."
);

dictionary.addWord(
        "software",
        "A collection of programs used by a computer."
);

dictionary.addWord(
        "hardware",
        "The physical components of a computer."
);

dictionary.addWord(
        "internet",
        "A global network connecting computers and devices."
);

dictionary.addWord(
        "information",
        "Facts or knowledge about something."
);

dictionary.addWord(
        "intelligence",
        "The ability to learn, understand, and solve problems."
);

dictionary.addWord(
        "artificial",
        "Something created by humans rather than occurring naturally."
);

dictionary.addWord(
        "search",
        "The process of looking for specific information."
);

dictionary.addWord(
        "dictionary",
        "A collection of words and their meanings."
);

dictionary.addWord(
        "knowledge",
        "Information and understanding gained through learning."
);

dictionary.addWord(
        "student",
        "A person who is learning or studying."
);

dictionary.addWord(
        "education",
        "The process of gaining knowledge and skills."
);

dictionary.addWord(
        "technology",
        "The application of scientific knowledge for practical purposes."
);

dictionary.addWord(
        "network",
        "A group of connected computers or devices."
);

dictionary.addWord(
        "security",
        "Protection of computer systems and information."
);

dictionary.addWord(
        "password",
        "A secret sequence used to access an account or system."
);

dictionary.addWord(
        "java",
        "A popular programming language."
);

dictionary.addWord(
        "coding",
        "The process of writing instructions for a computer."
);

        int choice;

        // Menu
        do {

            System.out.println(
                    "\n=============================="
            );

            System.out.println(
                    "       SMART DICTIONARY"
            );

            System.out.println(
                    "=============================="
            );

            System.out.println(
                    "1. Add Word"
            );

            System.out.println(
                    "2. Delete Word"
            );

            System.out.println(
                    "3. Search Word"
            );

            System.out.println(
                    "4. Auto-Complete"
            );

            System.out.println(
                    "5. KMP Pattern Search"
            );

            System.out.println(
                    "6. Display All Words"
            );

            System.out.println(
                    "7. Exit"
            );

            System.out.print(
                    "Enter your choice: "
            );

            choice = sc.nextInt();

            sc.nextLine();

            // Switch case
            switch (choice) {

                case 1:

                    System.out.print(
                            "Enter word: "
                    );

                    String word = sc.nextLine();

                    System.out.print(
                            "Enter meaning: "
                    );

                    String meaning = sc.nextLine();

                    dictionary.addWord(
                            word,
                            meaning
                    );

                    break;

                case 2:

                    System.out.print(
                            "Enter word to delete: "
                    );

                    word = sc.nextLine();

                    dictionary.deleteWord(word);

                    break;

                case 3:

                    System.out.print(
                            "Enter word to search: "
                    );

                    word = sc.nextLine();

                    dictionary.searchWord(word);

                    break;

                case 4:

                    System.out.print(
                            "Enter prefix: "
                    );

                    String prefix = sc.nextLine();

                    dictionary.autoComplete(prefix);

                    break;

                case 5:

                    System.out.print(
                            "Enter pattern: "
                    );

                    String pattern = sc.nextLine();

                    dictionary.patternSearch(pattern);

                    break;

                case 6:

                    dictionary.displayAllWords();

                    break;

                case 7:

                    System.out.println(
                            "Thank you!"
                    );

                    break;

                default:

                    System.out.println(
                            "Invalid choice!"
                    );
            }

        } while (choice != 7);

        sc.close();
    }
}
