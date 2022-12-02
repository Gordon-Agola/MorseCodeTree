package morsetree;

import java.io.*;
import java.util.*;
 
public class MorseCoder implements MorseCodeInterface {
     
    private MorseNode root;
 
    /**
     * constructor to build the tree
     */
    public MorseCoder() {
        root = new MorseNode();
        readTreeInfo();
    }
 
    /**
     * reads in the tree info from the text file (helper method)
     */
    private void readTreeInfo() {
        Scanner input = null;
        try {
            input = new Scanner(new File("morse.txt"));
        } catch (FileNotFoundException exception) {
            System.out.println("File not found!");
        }
 
        while (input.hasNextLine()) {
            String data = input.nextLine().trim();
            if (data.length() > 0) {
                add(data.substring(1).trim(), data.charAt(0));
            }
        }
        input.close();
    }
     
    /**
     * adds the letter to the tree based on the mcode string (helper method)
     * @param mcode the string being fed in
     * @param ltr the letter being added at the node
     */
    private void add(String mcode, char ltr) {
        MorseNode current = root;
        String signal = " ";
 
        for (int i = 0; i < mcode.length(); i++) {
            signal = mcode.substring(i, i + 1);
            if (signal.equals(".")) {
                if (current.getLeft() != null) {
                    current = current.getLeft();
                } else {
                    current.setLeft(new MorseNode());
                    current = current.getLeft();
                }
            } else {
                if (current.getRight() != null) {
                    current = current.getRight();
                } else {
                    current.setRight(new MorseNode());
                    current = current.getRight();
                }
            }
        }
        current.setLetter(ltr);
    }
 
    /**
     * prints out inorder tree contents 
     */
    public void inOrderPrint() {        
        MorseNode current = root;
        printInorder(current);
    }
 
    /**
     * called by inOrderPrint to print tree contents (helper method)
     * @param current the node to print
     */
    private void printInorder(MorseNode current) {      
        if (current != null) {
            printInorder(current.getLeft());
            System.out.print(current.getLetter());  
            printInorder(current.getRight());
        }
    }
 
    /**
     * decodes a String of morse code to English
     * @param str String of morse code
     * @return result String of English
     */
    public String decode(String str) {
        String signal = "";
        StringBuffer result = new StringBuffer("");
        MorseNode current = root;
         
        for (int i = 0; i < str.length(); i++) {
            signal = str.substring(i, i + 1);
            if (signal.equals(".")) {
                if (current.getLeft() != null) {
                    current = current.getLeft();
                } else {
                    current.setLeft(new MorseNode());
                    current = current.getLeft();
                }
            } else if (signal.equals("-")) {
                if (current.getRight() != null) {
                    current = current.getRight();
                } else {
                    current.setRight(new MorseNode());
                    current = current.getRight();
                }
            } else {
                result = result.append(current.getLetter());
                current = root;
            }
        }
        result = result.append(current.getLetter());
        
 
        return result.reverse().toString();
    }
 
    /**
     * decodes a String of English to morse code
     * @param str String of English
     * @return result String of morse code
     */
    List<String> al;
    public String encode(String str) {
    	 al = new ArrayList<String>();
    	 MorseNode current = root;
         String result = "";
         String s = "";
         char ltr;
          
         for (int i = 0; i < str.length(); i++) {
             ltr = str.charAt(i);
             searchTree(current, ltr, s);
             al.add("  ");
             
             }
         for (String x : al)
             result+=x;
        
         StringBuilder sb=new StringBuilder(result);  
         sb.reverse();
         return sb.toString();
    }   
 
    /**
     * searches the tree for the letter(s) being inputed and outputs a string of morse (helper method)
    
     */
    public boolean searchTree(MorseNode current, char ltr, String s) {
        if(current==null) {
        	return false;
        }
        int compareOneTwo = Character.compare(current.getLetter(),ltr);
        if (compareOneTwo == 0) {
        	
            return true;
        } else {
        	if (searchTree(current.getLeft(), ltr, s)==true) {
        		
            	s+=".";
            	
            	al.add(s);
                return true;
            }
            
        	else if (searchTree(current.getRight(), ltr, s )==true) {
            	
            	s+="-";
            	
            	al.add(s);
                return true;
            } 
            
            
            
        }
		return false;
    }
}
