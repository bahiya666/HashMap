Overview
This project implements a custom Hashmap data structure with quadratic probing for collision resolution and a dynamic prime number generator used for hashing. It simulates the functionality of a hash map where the keys are student numbers, and the values are their corresponding marks.

The main components of the project are:

  Hashmap: A hashmap class with methods for insertion, search, and removal of key-value pairs, as well as dynamic resizing.
  PrimeNumberGenerator: A class that generates prime numbers using the Sieve of Eratosthenes method.
  KeyValuePair: A class that represents the key-value pairs (student number and mark).
  PrimeNode: A helper class for the prime number linked list.
  Main: The entry point for testing the functionality of the hash map and prime number generator.

Description
The Hashmap simulates a hash map using a prime-based hash function. It supports quadratic probing for collision resolution. A PrimeNumberGenerator is used to dynamically generate prime numbers, which are employed in the hash function to minimize collisions. The hashmap starts with a small size and dynamically resizes when it becomes full.

Key Features:
Prime Number Generation: Efficiently generates primes using a linked list and the Sieve of Eratosthenes algorithm.
Quadratic Probing: A collision resolution technique that resolves hash collisions by quadratic probing.
Dynamic Resizing: Resizes the hashmap when the number of elements exceeds the current capacity.


Classes and Methods
Hashmap
The Hashmap class represents the hash map with student numbers as keys and marks as values. It provides methods for inserting, searching, and removing key-value pairs.

  Constructor:
  Hashmap(): Initializes an empty hashmap with one slot.
  Hashmap(String inp): Initializes a hashmap from a given input string representing key-value pairs.
  Methods:
  hash(int studentNumber): Computes the hash value for a given student number using a prime number.
  insert(int studentNumber, int mark): Inserts a new key-value pair into the hashmap or updates an existing one.
  search(int studentNumber): Searches for the value associated with the given student number.
  remove(int studentNumber): Removes a key-value pair from the hashmap.
  resizeAndRehash(): Resizes the hashmap when the current capacity is full and rehashes the existing elements.
  toString(): Returns a string representation of the hashmap (formatted with one entry per line).
  toStringOneLine(): Returns a string representation of the hashmap (all entries in one line).
  
PrimeNumberGenerator
The PrimeNumberGenerator class generates prime numbers using a linked list of primes. It uses the Sieve of Eratosthenes algorithm to compute primes.

  Constructor:
  PrimeNumberGenerator(): Initializes the prime generator with the first prime number (2).
  Methods:
  currentPrime(): Returns the current prime number.
  nextPrime(): Moves to the next prime number in the sequence.
  sieveOfEratosthenes(): Generates new primes using the Sieve of Eratosthenes algorithm.
  
KeyValuePair
The KeyValuePair class represents a single key-value pair in the hashmap.

  Constructor:
  KeyValuePair(int studentNumber, int mark): Initializes a new key-value pair with a student number and a corresponding mark.
  Methods:
  toString(): Returns a string representation of the key-value pair in the format u<studentNumber>:<mark>%.
  
PrimeNode
The PrimeNode class is used to create a linked list of prime numbers.

  Constructor:
  PrimeNode(int v): Initializes a new prime node with the value v.
  Methods:
  toString(): Returns a string representation of the node in the format [value].
  
Main
The Main class demonstrates how to use the Hashmap and PrimeNumberGenerator classes. It tests the functionality of inserting, searching, removing, and resizing the hashmap.
Methods:
main(String[] args): The entry point for testing the various features of the hashmap and prime number generator.

Compilation:
javac *.java
java Main
