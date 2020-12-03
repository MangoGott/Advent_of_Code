import java.util.*; // import the ArrayList class


public class Day3 {

    public static void main(String[] args) throws Exception {
        
        Scanner in = new Scanner(System.in);
        int x = 0;
        int x1 = 0;
        int x2 = 0; 
        int x3 = 0; 
        int x4 = 0;

        int y = 0;
        char tree = '#';
        int trees = 0;

        while(!in.hasNext("!")){     
            String line = in.nextLine();
            
            //Splitta upp raden i index.
            char[] arr = line.toCharArray();
            int width = arr.length;
            //Del A
            /*
            //Kolla om platsen är ett träd. plussa på då. 
            if(arr[x] == tree){
                trees++; 
            }          
            //flytta 3 rader åt höger. Mod% längd på det. 
            x = (x+3) % width;
            */

            //Del B
            

        }
        System.out.println("\n TREES: " +trees);

       
    }

}

/*
Testfall 1
11 rader
..##.......
#...#...#..
.#....#..#.
..#.#...#.#
.#...##..#.
..#.##.....
.#.#.#....#
.#........#
#.##...#...
#...##....#
.#..#...#.#

Svar: 7

Testfall 2
..##..
#...#.

*/