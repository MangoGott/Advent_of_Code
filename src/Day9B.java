import java.math.BigInteger;
import java.util.*; // import the ArrayList class
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.w3c.dom.css.Counter;


public class Day9B {

    public static void main(String[] args) throws Exception {
        
        //Svar: 1309761972

        Scanner in = new Scanner(System.in);
        long temp;
        long svar = 1309761972;
        //long svar = 127;
        //long max = 127 + 1;
        
        //int preambleLimit = 25;

        ArrayList<Long> input = new ArrayList<Long>();

        while(!in.hasNext("x")){
            
            temp = in.nextLong();
            input.add(temp);          
          
        }

        long sum = 0;

        for(int i = 0; i < input.size(); i++){
            sum += input.get(i);
            for(int j = i + 1; j < input.size(); j++){
                
                sum += input.get(j);
                
                //index++;

                if(sum > svar){
                    sum = 0;
                    break;
                }
                if(sum == svar){
                    System.out.println("HITTADE EN SERIE");
                    findMaxMin(input, i, j, svar);
                }
            }
        }

    }

public static void findMaxMin(ArrayList list, int start, int end, long svar) {
    long min = svar + 1;
    long max = 0; 

    for(int i = start; i <= end; i++){
        if((long) list.get(i) > max){
            max = (long) list.get(i);
        }
        
        if((long) list.get(i) < min){
            min = (long) list.get(i);
        }        
    }
    
    System.out.println("Max: " + max + "Min: " + min);
    System.out.println("Sum: " + (max + min));

}
       
}

//Svar: 1309761972
//171948980 skitsvar