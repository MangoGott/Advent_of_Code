import java.util.*; // import the ArrayList class
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.w3c.dom.css.Counter;


public class Day7B {

    static ArrayList<String> rules = new ArrayList<String>();
    
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        String temp = "";

        while(!in.hasNext("x")){
            temp = in.nextLine();
            rules.add(temp);
        }
        //Rules är klar.
        
        //Åk ner genom alla väskor rekursivt och gånga siffrorna sen addera dom. 

        
        int product = 0;
        product = recursiveMan(1, "shiny gold");

       System.out.println(product-1);
       //INGEN ANING VRF -1 men, jajajaj yihaaa i did it. 
}

public static int recursiveMan(int amount, String bag){
    int total = 1;
    for(String rule :rules){
        //kolla vilka regler som innehåller chosenOne (börjar som shiny golden)
        //dvs inte första väskan i meningen. 
        String firstBag = rule.substring(0, rule.indexOf(" bags"));
        
        System.out.println("HELLO: " + firstBag);

        if(bag.equals(firstBag)){

            System.out.println("FOUND THE BAG!");

            System.out.println(rule);
            //Strippa bort lite saker från Strängen. 
            String content = rule.substring(rule.indexOf("contain")+8, rule.indexOf("."));
            //System.out.println(content);
            //Slänga in alla väskor i en lista!
            String[] containedBags = content.split(", ");
            
            for(String theBag : containedBags){
                Scanner scanner = new Scanner(theBag);
                //System.out.println("theBag: " + theBag);

                if(!scanner.hasNextInt()){
                    return 1;
                }

                int nrBags = scanner.nextInt();
                System.out.println("nrBags: " + nrBags);

                String niceBag = "";
                for(int i = 0; i < 2; i++){
                    niceBag = niceBag + " " + scanner.next();
                }
                niceBag = niceBag.substring(1);
               // System.out.println("niceBag: " + niceBag);
               // System.out.println("RECURSED!");
                
                total += nrBags * recursiveMan(nrBags,niceBag);
            }
            //Vilken väska håller i chosenOne? Separera loss första väskan på raden. Det blir nya chosen one. 
            //lägg den väskan på stacken och 
        }
    }
    System.out.println("hur kom jag hit?");
    return total;

}


}
