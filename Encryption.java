import java.io.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


import java.util.Scanner;
public class Encryption {
	
	private  final String letter = "abcdefghijklmnopqrstuvwxyz";
	 
     private String encryption(String word, int key)
    {
        word = word.toLowerCase();
        String cipherText = "";
        for (int i = 0; i < word.length(); i++)
        {
            int charPosition = letter.indexOf(word.charAt(i));
            int keyVal = (key + charPosition) % 26;
            char replaceVal = letter.charAt(keyVal);
            cipherText += replaceVal;
        }
        return cipherText;
    }
 
    private  String decryption(String word, int key)
    {
        word = word.toLowerCase();
        String plainText = "";
        for (int i = 0; i < word.length(); i++)
        {
            int charPosition = letter.indexOf(word.charAt(i));
            int keyVal = (charPosition - key) % 26;
            if (keyVal < 0)
            {
                keyVal =letter.length() + keyVal;
            }
            
            char replaceVal = letter.charAt(keyVal);
            plainText += replaceVal;
        }
        return plainText;
    }
    
   private void choose()
   {
	   System.out.println("|---------------------------------------- |");
	   System.out.println("| A.Encryption        B. decryption       |");
	   System.out.println("| C. Exit                                 |");
	   System.out.println("|-----------------------------------------|");
   }
   
  public void BigMan()
  {
	  boolean s=true;
  	Scanner magar = new Scanner(System.in);
  	 
  	
  	while(s==true) { 
  		
  		choose();
  		
  		System.out.println("Choose the above code to do the function ");
  		 String choose = magar.nextLine();
  		 String ch = choose.toUpperCase();
  		 
  		
  		 
  		 switch(ch)
  		 {
	    		 case "A":
	    		 {
	    			 System.out.println("Write something in the file Outin.txt ");
	    			 Scanner write = new Scanner(System.in);
	    	         String data = write.nextLine();
	    	         
	    	         try {
	    	              	FileWriter fileWriter = new FileWriter("datain.txt");
	    	               	FileWriter one = new FileWriter("dataout.txt");
	    	               	
	    	               	System.out.println("Enter a key ");
	    	            	int key = write.nextInt();
	    	               PrintWriter printWriter = new PrintWriter(fileWriter);
	    	               PrintWriter printing = new PrintWriter(one);
	    	               printWriter.print(data);
	    	               printing.print(encryption(data,key));
	    	               System.out.println("File is encript in the dataout.txt file");
	    	               printWriter.close();
	    	               printing.close();
	    	         } catch(FileNotFoundException ex) {
	                     System.out.println(
	                             "Unable to open file '" + 
	                             "dataout.txt" + "'");                
	                     }
	                     catch(IOException ex) {
	                         System.out.println(
	                             "Error reading file '" 
	                             + "dataout.txt" + "'");                  
	                         
	                     }
	                     	System.out.println(" ");
	    	         
	    	        break; 
	    		 }
	    		 
	    		 case "B":
	    		 {
	    			 try {
	    	              	
	    	        		 
	    	        		 
	    	        		FileWriter fileWriter = new FileWriter("datain.txt");
	    	                PrintWriter printWriter = new PrintWriter(fileWriter);
	    	                String line =null,data =" ";
	    	                FileReader fileReader = 
	    	                    new FileReader("dataout.txt");
	    	                  
	    	                   BufferedReader bufferedReader = 
	    	                    new BufferedReader(fileReader);

	    	                	 System.out.println("Enter a key ");
	    	                	 Scanner dec = new Scanner(System.in);
	    	                  	int key = dec.nextInt();

	    	                    while((line = bufferedReader.readLine()) != null) {
	    	                        data = line;
	    	                    }  
	    	                   
	    	                  
	    	                   printWriter.print(decryption(data,key));
	    	                    System.out.println("File is decript in the datain.txt file");
	    	                    printWriter.close();
	    	                    bufferedReader.close();   
	    	                    
	    	                }
	    	                catch(FileNotFoundException ex) {
	    	                    System.out.println(
	    	                        "Unable to open file '" + 
	    	                        "dataout.txt" + "'");                
	    	                }
	    	                catch(IOException ex) {
	    	                    System.out.println(
	    	                        "Error reading file '" 
	    	                        + "dataout.txt" + "'");                  
	    	                   
	    	                }
	    			 
	    			 break;
	    		 }
	    		 case "C":
	    		 {
	    			 s=false;
	    			 System.out.println("Exit");
	    			 System.exit(0);
	    			 break;
	    		 }
	    		 
	    		 default:
	    		 {
	    			 System.out.println("You choose the wrong number form the mention above ");
	    			 System.out.println("  ");
	    		 }
  		 }
  		 
  		
  	
  		
  	
     
  }
  	magar.close(); 
  }

}

