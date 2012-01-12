import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;


public class StudentData {

    public String studentName;
    public String studentID;
    public String answers;
    public String formattedName;
    public String gender;
    
    public StudentData(String studentID, String studentName, String answers, String gender){
        
        this.studentName = studentName;
        this.studentID = studentID;
        this.answers = answers;
        this.formattedName=studentName.substring(studentName.indexOf(",")+1,studentName.length())+studentName.substring(0,studentName.indexOf(","));
        this.gender = null;
    }
    
    public String getAnswers() {
		return answers;
	}


	public static Scanner getData(String loc){
        
        Scanner input = null;
       // String 
        int count=0;
        while (input == null){
            if (count>0)
            loc = JOptionPane.showInputDialog("Enter the file name");
           try{
              
              input = new Scanner(new File (loc));
              JOptionPane.showMessageDialog(null, "File Found");
              
           } catch( FileNotFoundException e){
               count++;
               JOptionPane.showMessageDialog(null, "File \"" + loc + "\"" +
                                           " not Found, Specify name again");
           }
        }
        
        return input;
        
    }
    
    public static ArrayList<StudentData> createStudentList(Scanner io, Scanner ao){
        ArrayList<StudentData> data = new ArrayList<StudentData>();
        
        while (io.hasNextLine()){
            try{
            data.add(new StudentData(("" + io.nextInt()), io.nextLine(), ao.nextLine().toUpperCase(), null));
            
            }catch (NullPointerException e){
                throw new NullPointerException(e.getMessage());
            }
        }
        for(StudentData thing: data){
        	String answers = thing.getAnswers();
        	String gender = answers.substring(0,1);
        	thing.setAnswers(answers.substring(1,answers.length()));
        	thing.setGender(gender);
        	System.out.println(gender);
        }
        return data;
    }
    
    public void setAnswers(String answers) {
		this.answers = answers;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

    
}
