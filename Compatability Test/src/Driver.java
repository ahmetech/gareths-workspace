import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;


/*
 * Alexander Jeffries
 * CMNS131
 * 111756735
 * Comparison Test Driver and Main Method
 */

public class Driver {

    /*
     * BEFORE RUNNING THIS PROGRAM*********************************************
     * Make sure all the textfiles needed are in the Library
     * Files you need:
     * TXTFILE w/ Student Names and ID in : ID <Space> Name format
     * Ex:
     * 000651350 Jeffries, Alexander J
     * TXTFILE w/ Student answers in format abcdabcdabcdabcd (No Spaces after each answer)
     * Ex:
     * aabcdababaabcddde
     * IF: either of these txt files is not in this format run the respective formatter class in this project
     * ALSO
     * if maleAndFemaleMatches set to true, change the question number in the final
     * constant in the algorithm class
     * 
     * MINOR ERRORS THAT MIGHT NEED FIXING depending on what you're testing,
     * I never really tested this for every case, just this a debug through and it all looked right :P
     * Error will make for learning how to use debug fully lol
     * 
     */
    
  //  public final static int NUM_MATCHES_WANTED = 5;
    public final static boolean M_AND_F_MATCHES = false; //Change this if you want Male and Female Matches
    
    public static void main(String[] args){

        
        String studentDataLocation = JOptionPane.showInputDialog("" +
        	"Enter the file location that Student ID # and Name can be found");
        Scanner io = StudentData.getData(studentDataLocation);
        
        String studentAnswersLocation = JOptionPane.showInputDialog("" +
            "Enter the file location that Student answers can be found");
        Scanner ao = StudentData.getData(studentAnswersLocation);
        Scanner userInput=new Scanner(System.in);

        ArrayList<StudentData> allStudents = StudentData.createStudentList(io, ao, userInput);
       
        ArrayList<StudentData> maleStudents = new ArrayList<StudentData>();
        ArrayList<StudentData> femaleStudents = new ArrayList<StudentData>();
        
        for (StudentData find:allStudents)
        {
        	if(find.getGender().equals("A"))
        	{
        		maleStudents.add(find);
        	}
        	else if(find.getGender().equals("B"))
        	{
        		femaleStudents.add(find);
        	}
        }
        
        /*
         * allStudents contains object StudentData which contains 3 string fields
         * name, ID, and answers
         * Use this data set to generate your answers
         */
        
        int[][] matchesWithMales = StudentAnswers.calculateMatches(maleStudents);
        int[][] matchesWithFemales = StudentAnswers.calculateMatches(maleStudents);
        
        if (M_AND_F_MATCHES){
            //run first fileWrite
            for (int x=0;x< allStudents.size(); x++){
                Algorithm maleMatches = Algorithm.bestMatches(matchesForAll[x], allStudents, true);
                Algorithm femaleMatches = Algorithm.bestMatches(matchesForAll[x], allStudents, false);
              
                writeToFileMatches(allStudents.get(x).studentName, femaleMatches, maleMatches, allStudents);
            }
            
        }else{
            //run second fileWrite
            for (int x=0;x< allStudents.size(); x++){
            Algorithm matches = Algorithm.bestMatches(matchesForAll[x], allStudents);
            
            writeToFileMatches(allStudents.get(x).studentName, matches, allStudents);
            
            }
        }
     
    }
    
    /*
     * topFemale should contain the String ID of the top results in order
     * topMale should contain the String ID of the top results in order
     * ID should be the name of the person that the matches represent for
     */
    public static void writeToFileMatches(String name, Algorithm topFemale, Algorithm topMale, ArrayList<StudentData> a){
        
        try{
            
            FileWriter fstream = new FileWriter(name + ".txt");
            BufferedWriter out = new BufferedWriter(fstream);
            int z=1;
            out.write("Female Matches for " + name);
            out.newLine();
            for (int x=0;x<topFemale.matches.length;x++){
                
                for (int y=0; y<a.size();y++){
                    if (topFemale.matches[x].equals(a.get(y).studentID)){
                        out.write(z + ".  " + a.get(y).studentName + " with score: " + topFemale.scores[x]);
                        out.newLine();
                        z++;
                        break;
                    }
                }
            }
            z=1;
            out.newLine();
            out.write("Male Matches for " + name);
            out.newLine();
            for (int x=0;x<topMale.matches.length;x++){
                
                for (int y=0; y<a.size();y++){
                    if (topMale.matches[x].equals(a.get(y).studentID)){
                        out.write(z + ".  " + a.get(y).studentName + " with score: " + topMale.scores[x]);
                        out.newLine();
                        z++;
                        break;
                    }
                }
            }
            
            out.close();
            }catch (Exception e){//Catch exception if any
            System.err.println("Error: " + e.getMessage());
            }
        
        
    }
    
    public static void writeToFileMatches(String name, Algorithm matches, ArrayList<StudentData> a){

        try{
            
            FileWriter fstream = new FileWriter(name+ ".txt");
            BufferedWriter out = new BufferedWriter(fstream);
            int z=1;
            out.write("Top Matches for: " + name);
            out.newLine();
            for (int x=0;x<matches.matches.length;x++){
                
                for (int y=0; y<a.size();y++){
                    if (matches.matches[x].equals(a.get(y).studentID)){
                        out.write(z + ".  " + a.get(y).studentName + " with score: " + matches.scores[x]);
                        out.newLine();
                        z++;
                        break;
                    }
                }
            }
            
            out.close();
            }catch (Exception e){//Catch exception if any
           //System.err.println("Error: " + e.getMessage());
            }
    }
    
}
