import java.util.*; // import the ArrayList class
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.w3c.dom.css.Counter;


public class Day8B {

    static ArrayList<String> operations = new ArrayList<String>();

    public static void main(String[] args) throws Exception {
        

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

        int succsesResult = 0;
        int replacer = 2;

       while(succsesResult==0){

            succsesResult = trial(replacer);
            
            System.out.println("Yea1: " + succsesResult);

            replacer++;
        }
        
        System.out.println("Last-Yea2 " + succsesResult);

        
    }

    static int trial(int replaceCount){
        
        List<Integer> operationsCheck = new ArrayList<Integer>(Collections.nCopies(operations.size(), 0));


        int index = 0;
        int lastindex= -1;
        int accumulator = 0;
        int iterator = 0; 

        //Börja köra operationerna 
        while(operationsCheck.get(index)!=1){ 
            //Måst ha ett nytt end case, när har den lyckats köra allt? Inte bara dubblat en operation.
            String[] line = operations.get(index).split(" ");
           
            if(line[0].equals("acc")){
                operationsCheck.set(index, 1);
                accumulator += Integer.parseInt(line[1]);
                System.out.println("index:" + index);
                index++;
            }

            //byt ut en nop till en jmp, eller en jmp till en nop. 
            if(line[0].equals("jmp")){
                if(iterator==replaceCount){ //om sant, nop ist. 
                    operationsCheck.set(index, 1);
                    
                    System.out.println("index:" + index);


                    lastindex = index;
                    index++;
                    
                    iterator++;
                    System.out.println("REPLACED jmp with nop");
                }else { //Vanliga
                operationsCheck.set(index, 1);
                System.out.println("index:" + index);

                lastindex = index;
                index += Integer.parseInt(line[1]);
                iterator++;
                }
            }

            if(line[0].equals("nop")){
                if(iterator==replaceCount){ //om sant, jmp ist.
                    operationsCheck.set(index, 1);
                    System.out.println("index:" + index);

                    lastindex = index;
                    index += Integer.parseInt(line[1]);
                    iterator++;
                    System.out.println("REPLACED nop with jmp");
                }else { //Vanliga
                operationsCheck.set(index, 1);
                System.out.println("index:" + index);

                lastindex = index;
                index++;
                iterator++;
                }
            }

            if(index >= operations.size()){
                return accumulator;
            }

        }
        
        return 0;    
      
    }
}