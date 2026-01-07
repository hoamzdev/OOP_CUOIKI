package Chuong2.IF_SWITCH;

import java.util.Map;
import java.util.Scanner;

public class BAI4 {

    private static final Map<Integer,String> number = Map.of(
            1, "mot",
            2, "hai",
            3, "ba",
            4, "bon",
            5, "nam",
            6, "sau",
            7, "bay",
            8, "tam",
            9, "chin",
            10, "muoi"
    );

    private static String getTextOfNumber(String number){
        return switch (number){
            case "1" -> "mot";
            case "2" -> "hai";
            case "3" -> "ba";
            case "4" -> "bon";
            case "5" -> "nam";
            case "6" -> "sau";
            case "7" -> "bay";
            case "8" -> "tam";
            case "9" -> "chin";
            default -> "muoi";
        };
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.next();//n in 0 .. 1000
        if(n.length() == 1){
            //so co 1 chu so
            System.out.println(getTextOfNumber(n));
        }
        else if(n.length() == 2){
            if(n.charAt(0) == '1'){
                System.out.println("muoi ");
            }
            else{
                System.out.print(getTextOfNumber(String.valueOf(n.charAt(0))) + " muoi ");
            }
            if(n.charAt(1) != '0') System.out.print(getTextOfNumber(String.valueOf(n.charAt(1))));
        }
        else{
            System.out.print(getTextOfNumber(String.valueOf(n.charAt(0))) + " tram ");
            if(n.charAt(1) == '0' && n.charAt(2) != '0'){
                System.out.print("linh ");
                System.out.println(getTextOfNumber(String.valueOf(n.charAt(2))));
            }
            else if(n.charAt(1) != '0'){
                if(n.charAt(1) == '1'){
                    System.out.print("muoi ");
                }
                else{
                    System.out.print(getTextOfNumber(String.valueOf(n.charAt(1))) + " muoi ");
                }
                if(n.charAt(2) != '0') System.out.print(getTextOfNumber(String.valueOf(n.charAt(2))));
            }
        }
    }
}
