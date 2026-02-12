import java.util.Scanner;
/**

 Program description:problem2

 Author: BUSE BERFİN HALEFOĞLU

 E-mail address:210401020@ogr.ikc.edu.tr

 Homework Number:2

 Last Changed:22.03.24

 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Enter a string:");
        Scanner scanner =new Scanner(System.in);
        String input= scanner.nextLine();

        if (bracketMatcher(input))
            System.out.println("The brackets are correctly matched and nested.");
        else
            System.out.println("The brackets are not correctly matched and nested. ");

    }
    public static boolean bracketMatcher(String input){

        Stack stack= new Stack(100);

        for (int i=0;i<=input.length()-1;i++){
            char character=input.charAt(i);

            if (character=='('|| character=='{'||character=='['){
                stack.push(character);
            }
            if (stack.isEmpty()){
                return false;
            }
            char check;
            if (character==')'){
                check= (char) stack.pop();
                if (check=='{'||check=='[')
                    return false;
            } else if (character == '}') {
                check= (char) stack.pop();
                if (check == '(' || check == '[')
                    return false;
            } else if (character==']') {
                check= (char) stack.pop();
                if (check=='('||check=='{')
                    return false;
            }
        }


        return (stack.isEmpty());
    }
}
