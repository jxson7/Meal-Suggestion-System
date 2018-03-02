import java.io.*;
import java.util.Scanner;

class DinnerSuggest {

// Y/N Boolean System
  public static Boolean askYN(String question){
    System.out.println(question);
    Scanner scanner = new Scanner(System.in);
    String str = scanner.nextLine();
    return (str.equals("Y"));
  }

  //Main class

  public static void main (String[] args) throws IOException{
    // Scanner setup
    // BufferedWriter setup for File
    Scanner scanner = new Scanner(System.in);
    // string variables string, suggestion and question declared
    String str = "" , sug = "", q = "";
    Boolean playGame = true;
    File file = new File("suggest.txt");
    BufferedWriter write = new BufferedWriter(new FileWriter(file));
    // Asks questions, helping to allocate the direction of the Tree
    System.out.println("Let me help you find a dinner option today. I will ask you a series of questions that will help me determine what you may like tonight. Remember, answer Y/N only");
    // assigning the first question to the head of the Tree
    TreeNode head = new TreeNode("Do you like to eat something hot?");
    TreeNode tree = head;
    tree.addLeftChild("In the mood for something healthy?");
    tree.addRightChild("Lime, Shrimp and Avocado Salad");
    tree = tree.getLeftChild();
    tree.addLeftChild("Chicken and Chips");
    tree.addRightChild("Spaghetti Bolognese");
    tree = head;

    while (playGame == true){
      if (askYN(tree.getPayload())){
        tree = tree.getLeftChild();
      }
      else{
          tree = tree.getRightChild();
      }

      if (tree.isLeaf()){
          System.out.println("Perhaps you may like " + tree.getPayload());
          System.out.println("Is this satisfactory? Y/N");
          str = scanner.nextLine();

          if (str.equals("Y")){
            System.out.println("Would you like to play again? Y/N");
            str = scanner.nextLine();
            if (str.equals("Y")){
              tree = head;
            }
            else{
              System.out.println("Save these questions?");
              str = scanner.nextLine();
              if (str.equals("Y")) head.preOrder(write);
              playGame = false;
            }
          }
          else {
            System.out.println("What would you prefer instead?");
            sug = scanner.nextLine();
            System.out.println("What question would help distinguish " + sug + " & " + tree.getPayload() + "?");
            q = scanner.nextLine();
            System.out.println("What is the answer to this question for "+sug +"? Y/N");
            str = scanner.nextLine();

            if (str.equals("Y")){
              tree.addLeftChild(sug);
              tree.setPayload(q);
              tree.addRightChild(tree.getPayload());
            }
            else{
                tree.addRightChild(sug);
                tree.addLeftChild(tree.getPayload());
                tree.setPayload(q);
            }
            System.out.println("Would you like to play again? Y/N only");
            str = scanner.nextLine();
            if (str.equals("Y")){
              tree = head;
            }
            else{
                System.out.println("Save these questions?");
                str = scanner.nextLine();
                if (str.equals("Y")){
                  head.preOrder(write);
                  playGame = false;
                }
            }
          }
      }

    } write.close();
    }

  }
