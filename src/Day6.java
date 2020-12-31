import java.util.*; // import the ArrayList class
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.w3c.dom.css.Counter;


public class Day6 {

    public static void main(String[] args) throws Exception {
        
        ArrayList<Integer> seatIDcollection = new ArrayList<Integer>();

        Scanner in = new Scanner(System.in);
        String temp = "";
        int sum = 0;
        int counter;


        while(!in.hasNext("x")){

            //String paragraf = ""; 
            temp = in.nextLine();
            //System.out.println("first row: " + temp );
            HashMap<Character, Integer> firstAnswers = new HashMap<>();

            counter = 0;
            char[] letters = temp.toCharArray();
            for(char c: letters){
                firstAnswers.put(c, 1);
            }
          
            //Every Line
            while(!temp.isEmpty()){
                //paragraf = paragraf.concat(temp);
                
                temp = in.nextLine();
                counter++;

                char[] nextLetters = temp.toCharArray();
                //System.out.println(nextLetters);
                for(char c: nextLetters){
                    if(firstAnswers.containsKey(c)){
                        firstAnswers.put(c, firstAnswers.get(c)+1);
                    }
                }

            }

            /*
            ArrayList<Character> unique = new ArrayList<Character>();
            for(int i = 0; i < paragraf.length(); i++){
                
                
                if( !unique.contains( paragraf.charAt( i ) ) ){
                    unique.add( paragraf.charAt( i ) );
                }
            }
            sum += unique.size();
            */
            for(Map.Entry<Character,Integer> entry : firstAnswers.entrySet()){
                System.out.println(entry.getKey() + " : " + entry.getValue());
                System.out.println("Counter:" + counter);
                if(entry.getValue() == counter){
                    sum ++;
                }
                System.out.println(sum);
            }

            //sum += counter;

        }

        System.out.println(sum);
    }
}

/*
 
abc

a
b
c

ab
ac

a
a
a
a

b

*/