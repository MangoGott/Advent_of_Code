import java.util.*; // import the ArrayList class
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;


public class Day2 {

    public static void main(String[] args) throws Exception {
        
        Scanner scanObj = new Scanner(System.in);
        
        int correct = 0;
        

        while(!scanObj.hasNext("end")){
            int low;
            int high;
            String character = "";
            String text = "";

            String newLine = scanObj.nextLine();

            if("end".equalsIgnoreCase(newLine)){
                break;
            }
            //Pattern groups = Pattern.compile("(\\d+) ([a-z]{1,}) ([a-z]{2,}) "); 

            Pattern digits = Pattern.compile("\\d+"); //FUNKAR


            Pattern letter = Pattern.compile("[a-z]{1,}"); //FUNKAR

            
            Pattern password = Pattern.compile("[a-z]{2,}"); //FUNKAR

            Matcher m = digits.matcher(newLine);
            m.find();
            low = Integer.parseInt(m.group());
            m.find();
            high = Integer.parseInt(m.group());

            Matcher m1 = letter.matcher(newLine);
            m1.find();
            character = m1.group();
                        
            Matcher m2 = password.matcher(newLine);
            m2.find();
            text = m2.group();

            System.out.println(low + " " + high + " " + character + " " + text);
            //System.out.println(newLine);

            int count = text.length() - text.replace(character, "").length();

            /* Case 1
            if(low <= count && count <= high){
                correct++;
            }
            */

            //Case 2
            if(text.substring(low-1,low).equalsIgnoreCase(character) ^ text.substring(high-1,high).equalsIgnoreCase(character)){
                correct++;
            }

        }

        System.out.println(correct);
        
    }

}

/*

1 3 a abcde
TestFall 1

1-3 a: abcde
1-3 b: cdefg
2-9 c: ccccccccc

Svar: 2 passwords are correct
*/