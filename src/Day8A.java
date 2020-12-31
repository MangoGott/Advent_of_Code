import java.util.*; // import the ArrayList class
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.w3c.dom.css.Counter;


public class Day8A {

    public static void main(String[] args) throws Exception {
        
        ArrayList<String> operations = new ArrayList<String>();

        Scanner in = new Scanner(System.in);
        String temp = "";
        int counter = 0;


        while(!in.hasNext("x")){

            //String paragraf = ""; 
            temp = in.nextLine();
            //System.out.println("first row: " + temp );

            operations.add(counter, temp);

            counter++;
          
            //Every Line
            //sum += counter;
        }

        List<Integer> operationsCheck = new ArrayList<Integer>(Collections.nCopies(operations.size(), 0));

        //Två listor klara, en med operationerna en med om den operationen har körts. 

        int index = 0;
        int accumulator = 0;
        //Börja köra operationerna 
        while(operationsCheck.get(index)!=1){
            String[] line = operations.get(index).split(" ");
           
           
            if(line[0].equals("acc")){

                
                operationsCheck.set(index, 1);
                accumulator += Integer.parseInt(line[1]);
                index++;
            }

            if(line[0].equals("jmp")){
                operationsCheck.set(index, 1);
                index += Integer.parseInt(line[1]);
            }

            if(line[0].equals("nop")){
                operationsCheck.set(index, 1);
                index++;
            }

        }
        

        System.out.println("Yea: " + accumulator);
    }
}