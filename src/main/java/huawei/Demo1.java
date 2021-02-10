package huawei;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Demo1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.next();
        String mg = scan.next();
        Map<Character, Integer> mgMap = new TreeMap<>();
        Map<Character, Integer> inputMap = new TreeMap<>();
        for(Character c:mg.toCharArray()){
            if(mgMap.containsKey(c)){
                mgMap.replace(c, mgMap.get(c)+1);
            }else{
                mgMap.put(c,1);
            }
        }
    }
}
