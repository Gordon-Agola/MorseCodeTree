package morsetree;

import java.util.Scanner;

public class MorseMain {
	static boolean isValidMorse(String code)
	  {
	    int n = code.length();
	 
	    
	    	
	 
	    for (int i = 0; i < n; i++) {
	    
	      if (Character.compare(code.charAt(i), '.') == 0 || Character.compare(code.charAt(i), '-') == 0)
	      {
		        return true;
		   }
	    }
	 
	    return false;
	  }
	 
    public static void main(String[] args) {
        //Do not modify this file.
        MorseCoder mc = new MorseCoder();
         
            
         
            // sos decode
            Scanner myObj = new Scanner(System.in);  // Create a Scanner object
            

            
            System.out.println("Enter E (encode), D (decode) or Q (quit)");
            String choice = myObj.nextLine();
            
            if(choice.equalsIgnoreCase("Q")) {
            	System.out.println("The program has been Quited");
            	System.exit(0);
            }
            if(choice.equalsIgnoreCase("E")) {
            	System.out.println("Enter text to encode to morse code");
            	String encode = myObj.nextLine();
            	System.out.println("Plain text = " + encode);
               
                System.out.println("encode to morse code = " + mc.encode(encode.toUpperCase()));
            	
            }
            if(choice.equalsIgnoreCase("D")) {
            	System.out.println("Enter morse code to change to text(separate by words when more than two characters being rpresented, \nthe lenght of one code cannot be more than 5");
            	String decode = myObj.nextLine();
            	System.out.println("Morse code = " + decode);
            	if(isValidMorse(decode)) {
            		System.out.println("decode string = " + mc.decode(decode));
            	}
            	else {
            		System.out.println("Enter the valid morse code");
            	}
                
                
            }
            
         
    }
     
    
}
