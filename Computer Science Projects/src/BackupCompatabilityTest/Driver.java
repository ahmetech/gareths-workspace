package BackupCompatabilityTest;

import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
	public static void main(String[] args){
		Scanner thing=new Scanner(System.in);
		System.out.println("Please input the amount of tests");
		int amountOfStudents=thing.nextInt();
		ArrayList<Student> students=new ArrayList<Student>();
		for(int i=0; i<amountOfStudents; i++){
			System.out.println("Please input student name:");
			String name=thing.next();
			System.out.println("Please input gender: M or F");
			String gender=thing.next();
			System.out.println(name+", "+gender);
			students.add(new Student(name, gender));
		}
		String[][] answers=Algorithm.getMatches(students, amountOfStudents);
		for (int i = 0; i < answers.length; i++) {
			for (int j = 0; j < answers[i].length; j++) {
				System.out.println(answers[i][j]);
			}
		}
		
	}
}
