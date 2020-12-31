import java.math.BigInteger;
import java.util.*; // import the ArrayList class
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.w3c.dom.css.Counter;


public class Day9A {


    public static void main(String[] args) throws Exception {
        

        Scanner in = new Scanner(System.in);
        long temp;
        long counter = 1;
        int preambleLimit = 25;

        Queue<Long> pre25 = new LinkedList<>();

        while(!in.hasNext("x")){
            
            temp = in.nextLong();
            boolean foundIt = false; 

            //lägg in första preamble
            if(counter <= preambleLimit){
                pre25.add(temp);
            } 
            else {
                //System.out.println(pre25);

                //Räkna först om Valid, 
                for(long x: pre25){
                    for(long y: pre25){
                        if(x!=y && (x+y)==temp){
                            foundIt = true;
                        }
                    }
                }

                if(!foundIt){
                    System.out.println("x");
                    System.out.println("x");
                    System.out.println("x");
                    System.out.println("THIS ONE IS BAD: " + temp);
                    System.out.println("x");
                    System.out.println("x");
                    System.out.println("x");

                    break;
                }


                //poppa första o lägg in nya. 
                pre25.remove();
                pre25.add(temp);

            }


            counter++;
          
          
        }



    }
       
}

//Svar: 1309761972