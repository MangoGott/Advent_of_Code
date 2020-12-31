import java.util.*; // import the ArrayList class
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.w3c.dom.css.Counter;


public class Day7A {

    public static void main(String[] args) throws Exception {
        
        ArrayList<String> rules = new ArrayList<String>();

        Scanner in = new Scanner(System.in);
        String temp = "";

        while(!in.hasNext("x")){
            temp = in.nextLine();
            rules.add(temp);
        }


        Stack<String> chosenOnes = new Stack();
        Stack<String> theBags = new Stack();

        //Antar nu att Shiny Gold bag inte finns som första väska i en regel.
        chosenOnes.push("shiny gold");
        
        while(!chosenOnes.isEmpty()){

            temp = chosenOnes.pop();

            for(String rule :rules){
                //kolla vilka regler som innehåller chosenOne (börjar som shiny golden)
                //dvs inte första väskan i meningen. 
                String firstBag = rule.substring(0, rule.indexOf(" bags"));
                //System.out.println("HELLO: " + firstBag);
                if(rule.contains(temp) && !temp.equals(firstBag)){
                    chosenOnes.push(firstBag);
                    if(theBags.search(firstBag) == -1){
                        theBags.push(firstBag);
                    }
                    //Vilken väska håller i chosenOne? Separera loss första väskan på raden. Det blir nya chosen one. 
                    //lägg den väskan på stacken och 
                }
    
            }
        }

        System.out.println(theBags.size());
    

        //kanske får lägga in alla färger i en lista. Sen ta bort dubletter. 
        //System.out.println(rules);
    }
}