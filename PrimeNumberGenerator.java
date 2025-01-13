public class PrimeNumberGenerator {
    PrimeNode head;

    @Override
    public String toString() {
        String res = head.toString();
        PrimeNode ptr = head.next;
        while (ptr != null) {
            res += "->" + ptr.toString();
            ptr = ptr.next;
        }
        return res;
    }

    public PrimeNumberGenerator() 
    {
        head =new PrimeNode(2);
    }

    public int currentPrime() 
    {
        return head.value;
    }

    public int nextPrime() {
        if (head.next == null) { // If the head is the only element in the list
            sieveOfEratosthenes(); // Call sieveOfEratosthenes before moving the head along
        }
        head = head.next; // Move the head along
        return head.value;
    }
    

    public void sieveOfEratosthenes() {
        int size = head.value * 2 + 1;
        boolean[] notPrime = new boolean[size]; //initially false
        int jump = 2;
    
        while (jump < size) {
            int counter = jump + jump;
            while (counter < size) {
                notPrime[counter] = true;
                counter += jump;
            }
            jump++;
        }
    
        for (int i = head.value+1; i< size; i++) {
            if (!notPrime[i]) {
                PrimeNode newNode = new PrimeNode(i);
                PrimeNode ptr = head;
                while (ptr.next != null) {
                    ptr = ptr.next;
                }
                ptr.next = newNode;
            }
        }
    }

}