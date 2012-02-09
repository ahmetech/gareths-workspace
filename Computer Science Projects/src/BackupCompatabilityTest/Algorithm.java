package BackupCompatabilityTest;

import java.util.ArrayList;
import java.util.Random;

public class Algorithm {
	static Random numGenerator=new Random();
	public Object matches;
	public int length;
	public int[] scores;

	public static String[][] getMatches(ArrayList<Student> students, int amountOfStudents){
		String[][] matches=new String[amountOfStudents][21];

		//Puts the name in the array
		for(int i =0; i<amountOfStudents; i++){
			matches[i][0]=students.get(i).getName();
		}


		//Splits the students by gender
		ArrayList<String> females=new ArrayList<String>();
		ArrayList<String> males=new ArrayList<String>();
		for(int i =0; i<amountOfStudents; i++){
			if(students.get(i).getGender().equals("M")){
				males.add(students.get(i).getName());
			}else females.add(students.get(i).getName()); 
		}

		//Gets the male matches for everybody
		int number=0;
		for(int i =0; i<amountOfStudents; i++){
			ArrayList<String> temp=males;
			for(int j=1; j<11; j++){
				while(!(number>=0&&number<temp.size())&&(number!=i)){
					number=numGenerator.nextInt();
				}
				if(temp.size()>0){
					matches[i][j]=temp.get(number);
					temp.remove(number);
				}
			}
		}

		//Gets the female matches for everybody
		int number2=0;
		for(int i =0; i<amountOfStudents; i++){
			ArrayList<String> temp2=females;
			for(int j=11; j<21; j++){
				while(!(number2>=0&&number2<temp2.size())&&(number2!=i)){
					number2=numGenerator.nextInt();
				}
				matches[i][j]=temp2.get(number2);
				temp2.remove(number2);
			}
		}

		return matches;

	}
}
