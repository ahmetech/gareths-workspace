import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class AnswerAnalysis {

	public static String[] answers;//contains {person ID,a,b,c,d}
	public static int[][] ansAna;
	public static String[][] output;
	public static String[][] namesAndGrades;
	public static final int genderQ = 1;//gender question
	public static void main(String[] args) {
		if(laodAllPersons()){
			System.out.println("People Loaded\n");
		}else{
			System.out.println("People loading failed");
			return;
		}
		if(loadCompCfg()){	//{question ID,compared Question ID, ans 1, ans 2, points} 
							//ans is starting at 0 and represents ABCD
			System.out.println("AnsID\tAnswers\tPoints");
			for(int i = 0; i < ansAna.length; i++){
				System.out.print(	""+ansAna[i][0]+
									"-"+ansAna[i][1]+
									"\t"+abcdto1234(ansAna[i][2])+
									"-"+abcdto1234(ansAna[i][3])+
									"\t"+ansAna[i][4]+"\n");
			}
		}
		System.out.println("\nLoading results...");
		compResults();
		System.out.println("\nResults Loaded");
		loadNames();

	}
	public static void compResults(){
		output = new String[2000][4000];//ID
		for(int i = 0; i < answers.length; i++){
			if(answers[i] != null){
			int[] PrimaryPersonsAnswers = strArrtoIntAtt(abcdto1234(answers[i].split(",")));
				for(int i2 = 0; i2 < answers.length; i2++){
					if(answers[i2] != null){
					int count = 0;
					int points = 0;
					int[] otherPersonsAnswers = strArrtoIntAtt(abcdto1234(answers[i2].split(",")));
					for(int i3 = 0; i3 < ansAna.length; i3++){
						if(PrimaryPersonsAnswers[ansAna[i3][0]] == ansAna[i3][2] && otherPersonsAnswers[ansAna[i3][1]] == ansAna[i3][3]){
							points += ansAna[i3][4];
						}
					}
					output[i][count++] = ""+points;//points
					output[i][count++] = otherPersonsAnswers[0]+"";
					//System.out.println(points);
					}
				}
			}
		}
	}
	public static boolean loadNames(){
		namesAndGrades = new String[2000][2];
		File list = new File("playerList.txt");
		BufferedReader reader = null;
		try {
		reader = new BufferedReader(new FileReader(list));
		String text = null;
		int i = 0;
		while ((text = reader.readLine()) != null) {
			
			namesAndGrades[i] = text.split("\t");//last name,first name, grade
			i++;
		}
		return true;
		}catch (IOException ex){
			return false;
		}
		
	}
	public static String[] abcdto1234(String a[]){
		for(int i = 0; i < a.length; i++){
			if(a[i].equals("a")){ a[i] = "1"; }
			if(a[i].equals("b")){ a[i] = "2"; }
			if(a[i].equals("c")){ a[i] = "3"; }
			if(a[i].equals("d")){ a[i] = "4"; }
			if(a[i].equals("e")){ a[i] = "5"; }
			if(a[i].equals("z")){ a[i] = "6"; }
		}
		return a;
	
	}
	public static String abcdto1234(int a){
		String b = null;
			if(a ==1){ b = "a"; }
			if(a ==2){ b = "b"; }
			if(a ==3){ b = "c"; }
			if(a ==4){ b = "d"; }
			if(a ==5){ b = "e"; }
			if(a ==6){ b = "z"; }
		return b;
	
	}
	public static int count(String filename) throws IOException {
		File cfg = new File(filename);
		BufferedReader reader = null;
		try {
		reader = new BufferedReader(new FileReader(cfg));
		String text = null;
		int i = 0;
		while ((text = reader.readLine()) != null) {
			i++;
		}
		return i;
		}catch (IOException ex){
			return 0;
		}
	}
	public static boolean loadCompCfg(){
		File cfg = new File("config.cfg");
		BufferedReader reader = null;
		try {
		reader = new BufferedReader(new FileReader(cfg));
		String text = null;
		int i = 0;
		ansAna = new int[count("config.cfg")][4];
		while ((text = reader.readLine()) != null) {
			
			ansAna[i] = strArrtoIntAtt(text.split(","));
			i++;
		}
		return true;
		}catch (IOException ex){
			return false;
		}
	}
	private static int[] strArrtoIntAtt(String[] split) {
		int[] toreturn = new int[split.length]; 
		for(int i = 0; i < toreturn.length; i++){
			toreturn[i] = Integer.parseInt(split[i]);
		}
		return toreturn;
	}
	public static boolean laodAllPersons(){
		File aaadata = new File("AAA Participant Data.txt");
		BufferedReader reader = null;
		try {
		reader = new BufferedReader(new FileReader(aaadata));
		String text = null;
		int i = 0;
		answers = new String[2000];
		while ((text = reader.readLine()) != null) {
			answers[i] = text.substring(0,4);
			text =  text.substring(4);
			int tl = text.length();
			for(int i2 = 0; i2 < tl; i2++){
				//System.out.println(text);
				answers[i] = answers[i]+","+text.substring(0,1);
				text = text.substring(1);
			}
			//System.out.println(answers[i]);
			i++;
		}
		return true;
		}catch (IOException ex){
			return false;
		}

	}

}
