import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

class Conversation implements Chatbot {

  // Attributes 
  private ArrayList transcript;
  private ArrayList convoOptions = new ArrayList<>();
  Random random = new Random();
  /**
   * Constructor 
   */
  Conversation() {
    transcript = new ArrayList();
    convoOptions.add("Huh...");
    convoOptions.add("Interesting.");
    convoOptions.add("Cool!");
  }

  /**
   * Starts and runs the conversation with the user
   */
  public void chat() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("How many rounds would you like?");
    int rounds = scanner.nextInt();
    System.out.println("Hello! What's going on?");
    String input = scanner.nextLine();
    for(int i = 0; i < rounds; i++){
      int index = random.nextInt(3);
      input = scanner.nextLine();
      System.out.println(convoOptions.get(index));
      transcript.add(input);
    }
    System.out.println("Goodbye!");
  }

  /**
   * Prints transcript of conversation
   */
  public void printTranscript() {
    System.out.println(transcript);
  }

  /**
   * Gives appropriate response (mirrored or canned) to user input
   * @param inputString the users last line of input
   * @return mirrored or canned response to user input  
   */
  public String respond(String inputString) {
    String returnString = ""; 
    return returnString; 
  }

  public static void main(String[] arguments) {

    Conversation myConversation = new Conversation();
    myConversation.chat();
    myConversation.printTranscript();

  }
}
