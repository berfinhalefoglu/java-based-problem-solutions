import java.util.Stack;
/**

 Program description:problem3

 Author: BUSE BERFİN HALEFOĞLU

 E-mail address:210401020@ogr.ikc.edu.tr

 Homework Number:2

 Last Changed:22.03.24

 */
public class Main {
    public static void main(String[] args) {



        String infix = "(3 + 4) * 5 - 6 / 2";
        System.out.println("Enter an infix expression: (3 + 4) * 5 - 6 / 2");


        String infix2 = "5 * (6 - 2)";
        System.out.println("Enter another infix expression: 5 * (6 - 2)");

        String postfix = infixToPostfix(infix);
        String postfix2 = infixToPostfix(infix2);

        System.out.println("\nResult: " + postfixEvaluation(postfix));

        System.out.println("\nResult: " + postfixEvaluation(postfix2));

        System.out.println("\n ");
    }

    //İŞLEMLERDE PARANTEZ ÖNCELİĞİ YOK BURAYA EKLEYEMEDİM
    public static boolean compareOpr(char op1, char op2) {
        if (op1 == '*' || op1 == '/')
            return true;
        else if (op2 == '+' || op2 == '-') {
            return true;
        } else
            return false;
    }

    //infixi postfixe dönüştürme methodu
    public static String infixToPostfix(String infix) {
        String postfix = " ";
        Stack<Character> stack = new Stack<>();
        //gelen sembol for döngüsüne sokularak infix uzunluğu kadar currentsymbola infix verisini atasın
        for (int i = 0; i < infix.length(); i++) {
            char currentSymbol = infix.charAt(i);
            //isDigit fonksiyonu characteri analiz edicek
            if (Character.isDigit(currentSymbol))//sayısal karakter mi kontrolü isDigit ile yaptım
            {
                //infixteki veriyi postfixe atıyoruz
                do {
                    postfix += currentSymbol;
                    i++;
                } while (i < infix.length() && Character.isDigit(infix.charAt(i)));
                i--;
                postfix += " ";
            } else if (currentSymbol == '*' || currentSymbol == '/' || currentSymbol == '+' || currentSymbol == '-') {
                while (!stack.isEmpty() && stack.peek() != '(' && compareOpr(stack.peek(), currentSymbol)) {
                    //isEmpty ile boşluk kontrolü
                    //peek ile stack e eklenen son elemanı çağırma
                    postfix += stack.pop();
                    postfix += " ";
                }
                stack.push(currentSymbol);
            }
        }
        while (!stack.isEmpty()) {
            postfix += stack.pop();
            postfix += " ";
        }
        System.out.println("Postfix expression: " + postfix);
        return postfix.trim();//bosluklar olunca -1 döndüürüyor
    }

    //postfixe dönüşmüş işlemi yapma
    public static int postfixEvaluation(String postfix) {
        Stack<Integer> stack = new Stack<>();
        String[] tokens = postfix.split("\\s+");//splite kadar olan işlemi tokense at
        for (String token : tokens) {
            if (isNumeric(token)) {
                stack.push(Integer.valueOf(token));
            } else {
                if (stack.size() < 2) {
                    System.out.println("Invalid postfix expression.");
                    return -1;
                }
                int op2 = stack.pop();
                int op1 = stack.pop();
                int result = calculateOperations(op1, op2, token);
                stack.push(result);
            }
            System.out.println("Currently, the stack >> " + stack);
        }
        return stack.pop(); // Sonucu döndür
    }

    public static int calculateOperations(int op1, int op2, String operator) {
        switch (operator) {
            case "+":
                return op1 + op2;
            case "-":
                return op1 - op2;
            case "*":
                return op1 * op2;
            case "/":
                if (op2 != 0) {
                    return op1 / op2;
                } else {
                    System.out.println("Division by zero");
                    return -1;
                }
        }
        return op1;
    }

    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?"); //regex kullanımı (satır kolaylığı için)
    }

}
