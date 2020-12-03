import java.util.*; // import the ArrayList class


public class Day1 {

    public static void main(String[] args) throws Exception {
        
        Scanner scanObj = new Scanner(System.in);
        List<Integer> list = new ArrayList<Integer>();
       
        int in; 

        while(scanObj.hasNextInt()){

            in = scanObj.nextInt();    
            list.add(in);
        }

        //Lista är inmattad!
        //System.out.println(list);

        int a = 0; 
        int b = 0; 
        int c = 2021;

        for(int i = 0; i < list.size(); i++){
            a = list.get(i);

            for(int j = i +1; j < list.size(); j++){

                b = list.get(j);

                for(int l = i+2; l < list.size(); l++){

                    c = list.get(l);

                    if((a+b+c)==2020){
                        System.out.println("Sucess!! " + a + ", " + b + " and " + c);
                        
                        int result = a * b * c; 
                        System.out.println("Result: " + result);
                    }
                }
                
            }
        }
        
    }

}

/*
TestFall 1

1721
979
366
299
675
1456

*/