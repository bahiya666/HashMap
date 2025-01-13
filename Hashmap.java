import java.lang.Math;;

public class Hashmap {
    public KeyValuePair[] array;
    public PrimeNumberGenerator prime = new PrimeNumberGenerator();

    @Override
    public String toString() {
        String res = String.valueOf(prime.currentPrime()) + "\n";
        for (int i = 0; i < array.length; i++) {
            if (i != 0) {
                res += "\n";
            }
            res += i + "\t";
            if (array[i] == null) {
                res += "-";
            } else {
                res += array[i].toString();
            }
        }
        return res;
    }

    public String toStringOneLine() {
        String res = String.valueOf(prime.currentPrime()) + "[";
        for (int i = 0; i < array.length; i++) {
            if (i != 0) {
                res += ",";
            }
            if (array[i] == null) {
                res += "-";
            } else {
                res += array[i].toString();
            }
        }
        return res + "]";
    }

    public Hashmap() {
        array = new KeyValuePair[1];
    }
    
    public Hashmap(String inp) {
        String[] parts = inp.split("\\[|,|\\]");
        int primeNumber = Integer.parseInt(parts[0]);
        prime = new PrimeNumberGenerator();
        while (prime.currentPrime() < primeNumber) {
            prime.nextPrime();
        }
    
        array = new KeyValuePair[parts.length - 1];
        for (int i = 1; i < parts.length; i++) {
            if (!parts[i].equals("-")) {
                String[] kvParts = parts[i].substring(1, parts[i].length() - 1).split(":");
                int studentNumber = Integer.parseInt(kvParts[0]);
                int mark = Integer.parseInt(kvParts[1]);
                array[i - 1] = new KeyValuePair(studentNumber, mark);
            }
        }
    }
    
    
    

    public int hash(int studentNumber)
    {
        String studentNume=String.valueOf(studentNumber);

        int hashVal=0;

        int primesN = this.prime.currentPrime();
        for (int i=0; i <studentNume.length();i++)
        {
            int digit=studentNume.charAt(i)-'0';
            hashVal=primesN*hashVal +digit;
        }
        hashVal=Math.abs(hashVal);
        hashVal %= array.length;
        return hashVal;
    }
    
    

    public KeyValuePair search(int studentNumber)
    {
        int hashValue=hash(studentNumber);
        int currentPrime=prime.currentPrime();

        int idxs=hashValue;
        int qudrprobing=1;
        while (array[idxs] !=null)
        {
            if (array[idxs].studentNumber ==studentNumber)
            {
                return array[idxs];
            }

            idxs=(hashValue+qudrprobing*qudrprobing*currentPrime) %array.length;
            qudrprobing++;

            if (qudrprobing >array.length)
            {
                return null;
            }
        }

        return null;
    }
    
    public void insert(int studentNumber, int mark) {
        int hash = hash(studentNumber); // Calculate the hash of the student number
        
        // Check if the student number already exists in the hashmap
        int index = findIndex(studentNumber);
        if (index != -1) {
            // If the student number exists, update the mark
            array[index].mark = mark;
            return;
        }
        
        // If the index is empty, insert the new student there
        if (array[hash] == null) {
            array[hash] = new KeyValuePair(studentNumber, mark);
            return;
        }
        
        // Collision resolution using quadratic probing
        int offset = 1;
        int startIndex = hash;
        while (true) {
            // Calculate the new index using quadratic probing
            int newIndex = (startIndex + offset * offset * prime.currentPrime()) % array.length;
            
            // If the new index is empty, insert the new student there
            if (array[newIndex] == null) {
                array[newIndex] = new KeyValuePair(studentNumber, mark);
                return;
            }
            
            // Move to the next offset
            offset++;
            
            // If all indices are full, resize the hashmap
            if (offset > array.length) {
                resizeAndRehash();
                insert(studentNumber, mark); // Re-insert the student after resizing
                return;
            }
        }
    }
    
    
    
    private int findIndex(int studentNumber) {
        int hash = hash(studentNumber);
        int offset = 0;
        int originalHash = hash;
        while (array[hash] != null) {
            if (array[hash].studentNumber == studentNumber) {
                return hash; // Return the index if the student number is found
            }
            // Calculate the new index using quadratic probing
            hash = (originalHash + offset * offset * prime.currentPrime()) % array.length;
            offset++;
            if (offset > array.length) {
                break;
            }
        }
        return -1; // Return -1 if the student number is not found
    }
    
    private void resizeAndRehash() {
        // Create a temporary array to store the old elements
        KeyValuePair[] tempArray = array;
        
        // Double the size of the hashmap's array
        array = new KeyValuePair[array.length * 2];
        
        // Call nextPrime() on the prime object to get the new prime number
        prime.nextPrime();
        
        // Loop linearly through the old values and insert them into the new array
        for (KeyValuePair kvp : tempArray) {
            if (kvp != null) {
                insert(kvp.studentNumber, kvp.mark);
            }
        }
    }
    

    public void remove(int studentNumber) {
        int index = findIndex(studentNumber);
        if (index != -1) {
            array[index] = null;
        }
    }
    
    
    
    
}
