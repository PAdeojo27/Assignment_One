import java.util.Scanner;

public class EncryptionMachine {
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    public static final Integer SHIFT = 3;
    /**
     * @Name - main
     * @Description - The method that kicks off the program
     *
     */
    public static void main(String[] args) {
        // Start Program
            startProgram();
        }

    /**
     * @Name - startProgramn
     * @Description - The main control structure of the code.
     *
     */
    static void startProgram() {

        //User Input Variabl
            Scanner ResponeCollecter = new Scanner(System.in);
            String userInput = "";
            int wordsInMessage =0;
            String nextInput = "";

            System.out.println("Welcome to the CSCI717 Encryption Machine Construction");
            System.out.println("The program lets you encrypt a message");
            System.out.println("with a key for your recipient to decrypt!");
            System.out.println("Enter Key");
        //Key Intake
            userInput = ResponeCollecter.nextLine();
        //Encrypt the Key
            System.out.println("\""+ userInput+ "\" " +"has been encrypted to: "+caesarCipher(userInput));


        //Take number of words
            System.out.println("How many words is your message?:");

            wordsInMessage = ResponeCollecter.nextInt();

            for (int i = 0; i < wordsInMessage; ++i) {
                System.out.println("Next word:");
                nextInput = ResponeCollecter.next();
                System.out.println("\""+ nextInput+ "\" " +"has been encrypted to: "+ caesarCipher(nextInput));
            }

            System.out.println("Message fully encrypted. Happy secret messaging!");

        }


    /**
     * @Name - caesarCipher
     * @Description - Encypts a string and returns the resluting encryption
     *
     * @param String _unencryptedMessage - The unencrypted string from the user
     * @return String encrpyedMessage - This is the returned encrypted string
     */
        static String caesarCipher(String _unencryptedMessage)
        {
            StringBuilder encryptedMessage = new StringBuilder();
            // Loop through each character in the plaintext
            for (int i = 0; i < _unencryptedMessage.length(); i++) {
                char currentChar = _unencryptedMessage.charAt(i);
                // Find the position of the character in the alphabet
                int currentIndex = ALPHABET.indexOf(currentChar);
                // If the character is in the alphabet, shift it
                if (currentIndex != -1) {
                    int shiftedIndex = (currentIndex + SHIFT) % ALPHABET.length();
                    char shiftedChar = ALPHABET.charAt(shiftedIndex);
                    encryptedMessage.append(shiftedChar);
                } else {
                    // If character is not in alphabet, add it as is (e.g., space, punctuation)
                    encryptedMessage.append(currentChar);
                }
            }

            return encryptedMessage.toString();

        }
    }
