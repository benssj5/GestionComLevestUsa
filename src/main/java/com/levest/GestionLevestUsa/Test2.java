package com.levest.GestionLevestUsa;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Test2 {

public static String change(char c) {
switch (c) {
case 'a': return "b";
case 'b' : return "c";
case 'c' : return "d";
case 'd' : return "E";
case 'e' : return "f";
case 'f' : return "g";
case 'g' : return "h";
case 'h' : return "I";
case 'i' : return "j";
case 'j' : return "k";
case 'k' : return "l";
case 'l' : return "m";
case 'm' : return "n";
case 'n' : return "O";
case 'o' : return "p";
case 'p' : return "q";
case 'q' : return "r";
case 'r' : return "s";
case 's' : return "t";
case 't' : return "U";
case 'u' : return "v";
case 'v' : return "w";
case 'w' : return "x";
case 'x' : return "y";
case 'y' : return "z";
case 'z' : return "A";

default:
break;
}
return "";
}
//i taille du mot
public static String rm(String s, int i) {
char[] strChars = s.toCharArray();
strChars[i] = ' ';
return new String(strChars).replaceAll(" ", "");
}
//i taille du mot
public static String rm2(String s, int i) {
char[] strChars = s.toCharArray();
strChars[i] = ' ';
return new String(strChars).replaceAll(" ", "");
} 

    public static String LetterChanges(String str) {
        StringBuilder result = new StringBuilder();
        char[] strChars = str.toLowerCase().toCharArray();
        char[] replacements = {'b', 'c', 'd', 'E', 'f', 'g', 'h', 'I', 'j', 'k', 'l', 'm', 'n', 'O', 'p', 'q', 'r', 's', 't', 'U', 'v', 'w', 'x', 'y', 'z', 'A'};
        for (int i = 0; i < str.length(); i++) {
        result.append(change(strChars[i]));
        }
        return result.toString();
    }
  
  public static void main (String[] args) {  
    // keep this function call here     
    //Scanner s = new Scanner(System.in);
    //System.out.print(LetterChanges(s.nextLine())); 
    
    String str = "couko5uycou";
    String[] t = str.split("\\s");
   //str =  str.substring(0,1).toUpperCase() + str.substring(1,str.length()-1);
    //System.out.println(t[0]);
    String.valueOf(5);
    char[] strChars = str.toCharArray();
        Arrays.sort(strChars);
        String res =  new String(strChars);
        
        String e = "eeeabba";
        /*System.out.println(rm(e,0));
        System.out.println(rm(e,1));
        System.out.println(rm(e,2));
        System.out.println(rm(e,5));
*/
        //System.out.println(PalindromeCreator(e));
        System.out.println(GroupTotals(new String[] {"X:-1", "Y:1","H:1", "X:-4", "B:3", "X:5"}));
    
  }   
  
  
  public static String GroupTotals(String[] strArr) { 
  Map<String, Integer> map = new TreeMap<String, Integer>();
  String result = "";
    
  for(int i=0; i<strArr.length; i++) {
  String[] duo = strArr[i].split(":");
  if(map.get(duo[0]) != null) {
  map.put(duo[0], map.get(duo[0]) + new Integer(duo[1]));
  } else {
  map.put(duo[0],new Integer(duo[1]));
  }
  }
  
  for ( Iterator<Entry <String, Integer>> i = map.entrySet().iterator(); i.hasNext();) {
  Entry <String, Integer>couple = (Entry<String, Integer>)i.next();
  String cle = (String)couple.getKey();
  Integer valeur = (Integer)couple.getValue();
      if(valeur != 0)
      result+=  ","+cle+":"+valeur.toString();
  }
  return result.substring(1);
    
} 
  
  /*
Input:new String[] {"X:-1", "Y:1", "X:-4", "B:3", "X:5"}

Output:"B:3,Y:1"
Input:new String[] {"Z:0", "A:-1"}
Output:"A:-1"
 
 
   */
  
  public static String PalindromeCreator(String str) { 
  char[] strChars = str.toCharArray();
  
    if(isPalindrome(str)){
        return "palindrome";
    }
    
    else {
        for(int i=0; i<str.length();i++){
            if(isPalindrome(rm(str,i))){
            //System.out.println(strChars[i]);
            return strChars[i]+"";
            } 
        }
        
        for(int i=0; i<str.length();i++){
        for(int j=0; j<str.length()-1;j++ ) {
            if(isPalindrome(rm(rm(str,i),j))){
            //System.out.println(strChars[i]);
            return strChars[i]+""+strChars[j+1];
            } 
        }
        }
    }
       
    return "pas palindrome";
    
  } 
  
  public static boolean isPalindrome(String str){
  
        String reverse = new StringBuffer(str).reverse().toString();
         
        if(str.length()<3) return false;
        
        if (reverse.equals(str))
            return true;
         
        return false;
    }
  
}
