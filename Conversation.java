import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

class Conversation implements Chatbot {

  // Attributes 
  private ArrayList transcript;
  private String[] convoOptions = new String[]{"Huh", "Cool", "Interesting", "Ok"};
  private String[] mirrorInput = new String[]{"I", "me", "am", "you", "my", "your"};
  Random random = new Random();
  /**
   * Constructor 
   */
  Conversation() {
    transcript = new ArrayList();
  }

  /**
   * Starts and runs the conversation with the user
   */
  public void chat() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("How many rounds would you like?");
    int rounds = scanner.nextInt();
    System.out.print("Hello! What's going on?");
    String input = scanner.nextLine();
    for(int i = 0; i < rounds; i++){
      System.out.println(respond(input));
      //int index = random.nextInt(convoOptions.length);
      input = scanner.nextLine();
      //System.out.println(convoOptions[index]);
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
    for(int i = 0; i<inputString.length()-3; i++){
      if(inputString.substring(i, i+2) == "I"){
        System.out.print("here");
        returnString += "you ";
        i++;
      }
      else if(inputString.substring(i, i+2) == "me "){
        returnString += "you";
        i+=2;
      }
      else if(inputString.substring(i, i+2) == "am "){
        returnString += "are";
        i+=2;
      }
      else if(inputString.substring(i, i+3) == "you"){
        returnString += "I";
        i+=3;
      }
      else if(inputString.substring(i, i+1) == "my"){
        returnString += "your";
        i+=2;
      }
      else if(inputString.substring(i, i+3) == "your"){
        returnString += "my";
        i+=4;
      }
      else{
        returnString += inputString.substring(i, i+1);
      }
    }
    return returnString; 
  }

  public static void main(String[] arguments) {

    Conversation myConversation = new Conversation();
    myConversation.chat();
    myConversation.printTranscript();

  }
}
