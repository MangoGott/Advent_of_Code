import java.util.*; // import the ArrayList class
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Day4 {

    public static void main(String[] args) throws Exception {
        
        Scanner in = new Scanner(System.in);
        String temp = "";
        String[] fields = {
            "byr:((19[2-9][0-9])|200[0-2])[^\\S]",
            "iyr:(201[0-9]|2020)[^\\S]", "eyr:(20(2[0-9]|30))[^\\S]",
            "hgt:(((1[5-8][0-9])|(19[0-3]))cm|(59|6[0-9]|7[0-6])in)[^\\S]",
            "hcl:#[\\d a-f]{6}[^\\S]",
            "ecl:(grn|amb|blu|brn|gry|grn|hzl|oth)[^\\S]",
            "pid:(\\d{9})[^\\S]"};
        int counter = 0;

        while(!in.hasNext("end")){
            
            String paragraf = ""; 
            temp = in.nextLine();
            
            while(!temp.isEmpty()){
                paragraf = paragraf.concat(" " + temp + " ");
                temp = in.nextLine();

            }
            
            counter++;
            for(String field :fields){
                
                String pattern = field;
                Pattern r = Pattern.compile(pattern);
                Matcher m = r.matcher(paragraf);

                if(m.find()){
                    System.out.println("VALID");
                    //System.out.print(m.group());
                    
                }else {
                    //System.out.println("NOT VALID");
                    //System.out.println(field);
                    counter--;
                    break;
                }
            }

        }
        
        System.out.println("#VALID PASSPORTS: " + counter);
        
        }
    }

/*
EYR INVALIND
hgt:59cm ecl:zzz
eyr:2020 hcl:74454a iyr:2020
pid:3556412378 byr:2002

TestFall 4

ecl:gry pid:860033327 eyr:2020 hcl:#fffffd
byr:1937 iyr:2017 cid:147 hgt:183cm

iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884
hcl:#cfa07d byr:1929

hcl:#ae17e1 iyr:2013
eyr:2024
ecl:brn pid:760753108 byr:1931
hgt:179cm

hcl:#cfa07d eyr:2025 pid:166559648
iyr:2011 ecl:brn hgt:59in


cid: is optional
*/