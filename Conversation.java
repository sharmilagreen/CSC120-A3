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
    System.out.println("Hello! What's going on?");
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
    boolean containsMirror = false;
    for(int i = 0; i<inputString.length(); i++){
      if(i < inputString.length()-2){
        if(i < inputString.length()-3){
          if(i < inputString.length()-4){
            if(inputString.substring(i, i+4).equals("your")){
              containsMirror = true;
              returnString += "my";
              i+=3;
              System.out.println(returnString);
            }
          }
          if(inputString.substring(i, i+3).equals("you")){
            containsMirror = true;
            returnString += "I";
            i+= 2;
          }
          if(inputString.substring(i, i+3).equals("are")){
            containsMirror = true;
            returnString += "am";
            i+= 2;
          }
        }
        if(inputString.substring(i, i+3).equals("me ") || inputString.substring(i, i+2).equals("I ")){
          containsMirror = true;
          returnString += "you";
          i+=2;
        }
        if(inputString.substring(i,i+3).equals("am ")){
          containsMirror = true;
          returnString += "are";
          i+=2;
        }
        if(inputString.substring(i, i+3).equals("my ")){
          containsMirror = true;
          returnString += "your";
          i+=2;
        }
        returnString += inputString.substring(i, i+1);
      }
      else if(inputString.substring(i).equals("I")){
        containsMirror = true;
        returnString += "you";
        i+=1;
        returnString += inputString.substring(i);
      }
    }
    if(containsMirror == false){
      returnString = convoOptions[1];
    }
    return returnString; 
  }

  public static void main(String[] arguments) {

    Conversation myConversation = new Conversation();
    myConversation.chat();
    myConversation.printTranscript();

  }
}
