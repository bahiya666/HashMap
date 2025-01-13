public class Main {
    public static void main(String[] args) {
        // Prime number generator testing
        PrimeNumberGenerator PRIME = new PrimeNumberGenerator();

        System.out.println("Initial prime list: " + PRIME);

        PRIME.nextPrime();
        System.out.println("Prime list after calling nextPrime(): " + PRIME);
        for (int i = 0; i < 15; i++) {
            PRIME.nextPrime();

            System.out.println("Prime list after calling nextPrime(): " + PRIME);
        }

        // Default constructor testing
        Hashmap HASHmap = new Hashmap();
        System.out.println("\nDefault Constructor:");
        System.out.println(HASHmap.toString());

        // Parameterized constructor testing
        String input = "11[u37:18%,u29:13%,u100:44%,u12:14%,u112:21%,u14:5%,u111:14%]";
        Hashmap hashStrings = new Hashmap(input);
        System.out.println("\nParameterized Constructor:");
        System.out.println(hashStrings.toString());

        // Hash function testing
        System.out.println("\nHash Function Tests:");
        int studentNumber1 = 100;
        int hashValue1 = hashStrings.hash(studentNumber1);
        System.out.println("Hash value of student number 100: " + hashValue1);

        int studentNumber2 = 112;
        int hashValue2 = hashStrings.hash(studentNumber2);
        System.out.println("Hash value of student number 112: " + hashValue2);

        int studentNumber3 = 37;
        int hashValue3 = hashStrings.hash(studentNumber3);
        System.out.println("Hash value of student number 37: " + hashValue3);

        // Insertion and removal testing
        Hashmap hash3000 = new Hashmap();
        System.out.println("\nInitial state of hash3000:");
        System.out.println(hash3000);

        hash3000.insert(59, 12);
        System.out.println("\nAfter inserting (59, 12):");
        System.out.println(hash3000);

        hash3000.insert(18, 44);
        System.out.println("\nAfter inserting (18, 44):");
        System.out.println(hash3000);

        hash3000.insert(67, 72);
        System.out.println("\nAfter inserting (67, 72):");
        System.out.println(hash3000);

        hash3000.insert(42, 55);
        System.out.println("\nAfter inserting (42, 55):");
        System.out.println(hash3000);

        hash3000.insert(37, 89);
        System.out.println("\nAfter inserting (37, 89):");
        System.out.println(hash3000);

        hash3000.insert(5, 23);
        System.out.println("\nAfter inserting (5, 23):");
        System.out.println(hash3000);

        int studentToRemove1 = 14;
        System.out.println("\nRemoving student number " + studentToRemove1 + ":");
        hashStrings.remove(studentToRemove1);
        System.out.println(hashStrings);

        int studentToRemove2 = 100;
        System.out.println("\nRemoving student number " + studentToRemove2 + ":");
        hashStrings.remove(studentToRemove2);
        System.out.println(hashStrings);

        // Additional testing (insertion, search, and removal)
        System.out.println("\nAdditional Testing:");
        hashStrings.insert(99, 85);
        System.out.println("\nAfter inserting (99, 85):");
        System.out.println(hashStrings);

        KeyValuePair searchResult = hashStrings.search(37);
        System.out.println("\nSearch result for student number 37: " + searchResult);

        hashStrings.remove(37);
        System.out.println("\nAfter removing student number 37:");
        System.out.println(hashStrings);
    }
}
