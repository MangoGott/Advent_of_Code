import java.util.*; // import the ArrayList class


public class Day3 {

    public static void main(String[] args) throws Exception {
        
        Scanner in = new Scanner(System.in);
        int x = 0; // R1D1
        int x1 = 0; // R3D1
        int x2 = 0; // R5D1
        int x3 = 0; // R7D1
        int x4 = 0; // R1D2

        int[] slopeList = {1,3,5,7,1};
        boolean varannan = true;

        char tree = '#';
        int trees = 0;
        int trees1 = 0;
        int trees2 = 0;
        int trees3 = 0;
        int trees4 = 0;

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
            //TO DO: Snygg lösning ;9 
            /*
            for(int slope :slopeList){

                if(arr[x] == tree){
                    trees++; 
                }  
                x = (x + slope) % width;

            }
            */


            //Ful lösningen
            //R1D1
            if(arr[x] == tree){
                trees++; 
            }  
            x = (x+1) % width;

            //R3D1
            if(arr[x1] == tree){
                trees1++; 
            }  
            x1 = (x1+3) % width;

            //R5D1
            if(arr[x2] == tree){
                trees2++; 
            }  
            x2 = (x2+5) % width;

            //R7D1
            if(arr[x3] == tree){
                trees3++; 
            }  
            x3 = (x3+7) % width;

            //R1D2
            
            if(varannan){
                if(arr[x4] == tree){
                    trees4++; 
                }  
                x4 = (x4+1) % width;
            }
            varannan = !varannan;

        }
        long product = trees * trees1 * trees2 * trees3 * trees4;
        System.out.println("\n TREES: " +trees + ", " +trees1 + ", " +trees2 + ", " +trees3 + ", " +trees4 + "\n Product: " + product);

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