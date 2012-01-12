import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

import javax.swing.JOptionPane;


public class NameFormatter {

    /**
     * Run this if you're names are not in the ID NAME format 
     * in a txt file.
     * For this to work, Just have all the names in a txt file, line by line
     * So to get it to txt file, copy from the XML file all the names and copy,
     * paste into a txt file. 
     * Then copy the ID numbers into another txt document.
     * Put both txt files in the library and run.
     * 
     */
    static Scanner names = null;
    static Scanner id = null;
    
    public static void main(String[] args) {
        
         String loc;
   
         while (names == null){
           
             loc = JOptionPane.showInputDialog("Enter the file name");
            try{
               
               names = new Scanner(new File (loc));
               JOptionPane.showMessageDialog(null, "File Found");
               
            } catch( FileNotFoundException e){
             
                JOptionPane.showMessageDialog(null, "File \"" + loc + "\"" +
                                            " not Found, Specify name again");
            }
         }
         
         String loc2;
   
         while (id == null){
           
             loc2 = JOptionPane.showInputDialog("Enter the file name");
            try{
               
               id = new Scanner(new File (loc2));
               JOptionPane.showMessageDialog(null, "File Found");
               
            } catch( FileNotFoundException e){
             
                JOptionPane.showMessageDialog(null, "File \"" + loc2 + "\"" +
                                            " not Found, Specify name again");
            }
         }
         
        
        try{
            // Create file 
            FileWriter fstream = new FileWriter("Names.txt");
            BufferedWriter out = new BufferedWriter(fstream);
           
            while (names.hasNext()){
                
                 out.write(id.nextLine() + " " + names.nextLine());
                 out.newLine();
                 
            }
           
            //Close the output stream
            out.close();
            }catch (Exception e){//Catch exception if any
            System.err.println("Error: " + e.getMessage());
            }
    

    }

}
