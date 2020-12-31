import java.util.*; // import the ArrayList class
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Day5 {

    static int front = 0; 
    static int back = 127;
        
    static int left = 0;
    static int right= 7;

    static int seatID = 0;

    public static void main(String[] args) throws Exception {
        
        ArrayList<Integer> seatIDcollection = new ArrayList<Integer>();

        Scanner in = new Scanner(System.in);
        int[][] seats = new int[128][8];

        while(!in.hasNext("x")){
            String[] line = in.nextLine().split("");

            for(int i = 0; i < line.length; i++){
                //System.out.println(line[i]);

                if(line[i].equals("F")){
                    System.out.println("method");

                    frontMethod();
                } else 
                if(line[i].equals("B")){
                    System.out.println("method");

                    backMethod();
                } else 
                if(line[i].equals("R")){
                    System.out.println("method");

                    rightMethod();
                } else 
                if(line[i].equals("L")){
                    System.out.println("method");

                    leftMethod();
                } else {
                    System.out.println("OUTPUT SUCKS");
                }

            }

            int temp = front * 8 + left;
            seatIDcollection.add(temp);

            if (temp > seatID){
                seatID = temp;
            }

            front = 0; 
            back = 127;
            left = 0;
            right= 7;
        
        }
        int mySeatID = 0;
        Collections.sort(seatIDcollection);

        for(int i = 0; i < seatIDcollection.size()-1; i++){
            mySeatID = seatIDcollection.get(i); 
            int nextSeatID = seatIDcollection.get(i+1);

            if(mySeatID + 1 != (nextSeatID)){
                mySeatID++;
                break;
            }

        }
        System.out.println(seatIDcollection);
        System.out.println("MY SEAT: " + mySeatID);

    }

    public static void frontMethod(){
        int midpoint = (int) Math.floor((back-front)/2);
        back = back - (midpoint + 1);
    }

    public static void backMethod(){
        int midpoint = (int) Math.floor((back-front)/2);
        front += (midpoint + 1);
    }

    public static void leftMethod(){
        int midpoint = (int) Math.floor((right-left)/2);
        right = right - (midpoint + 1);
    }

    public static void rightMethod(){
        int midpoint = (int) Math.floor((right-left)/2);
        left += (midpoint + 1);
    }

    private static void testSum(int x, int y){
        System.out.println(x+y);
    }


}

/*
    -^-
back 127

front 0
    -v-
FBFBBFF
Start by considering the whole range, rows 0 through 127.
F means to take the lower half, keeping rows 0 through 63.
B means to take the upper half, keeping rows 32 through 63.
F means to take the lower half, keeping rows 32 through 47.
B means to take the upper half, keeping rows 40 through 47.
B keeps rows 44 through 47.
F keeps rows 44 through 45.
The final F keeps the lower of the two, row 44.

RLR:
Start by considering the whole range, columns 0 through 7.
R means to take the upper half, keeping columns 4 through 7.
L means to take the lower half, keeping columns 4 through 5.
The final R keeps the upper of the two, column 5.



*/