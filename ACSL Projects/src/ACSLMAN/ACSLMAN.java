package ACSLMAN;

import java.util.ArrayList;
import java.util.Scanner;

public class ACSLMAN {
	public static void main(String[] args){
		for (int i = 0; i < 5; i++) {
			int lives=0;
			int numberCorrect=0;
			ArrayList<String> input=getInput();
			String hiddenWord=input.get(0);
			input.remove(0);
			input.remove(0);
			for (String phrase: input) {
				if (checkWord(phrase, hiddenWord)) {
					numberCorrect++;
				}else lives++;
			}
			printTheOutput(lives, numberCorrect);
		}
	}
	
	public static ArrayList<String> getInput(){
		Scanner scanner=new Scanner(System.in);
		String rawInput=scanner.nextLine();
		String[] input=rawInput.split(",");
		ArrayList<String> input1=new ArrayList<String>();
		for (int i = 0; i < input.length; i++) {
			input1.add(input[i]);
		}
		return input1;
	}
	
	public static boolean checkWord(String phrase, String hiddenWord){
		String tempWord=hiddenWord;
		char[] temporary=tempWord.toCharArray();
		ArrayList<String> word=new ArrayList<String>();
		for (int i = 0; i < temporary.length; i++) {
			word.add(Character.toString(temporary[i]));
		}
			for (int i = 0; i < phrase.length(); i++) {
				for (int j=0; j< word.size(); j++) {
					if (phrase.substring(0+i, 1+i).equals(word.get(j))) {
						word.remove(index)
					}
				}
			}
	}
	
	
	public static String getLives(int lives){
		String figure="NONE";
		if (lives==1) {
			figure="O";
			return figure;
		}
		if (lives==2) {
			figure="  O\n"+"+";
			return figure;
		}
		if (lives==3) {
			figure="  O\n"+"+=";
			return figure;
		}
		if (lives==4) {
			figure="  O\n"+"+=[]";
			return figure;
		}
		if (lives==5) {
			figure="  O\n"+"+=[]=";
			return figure;
		}
		if (lives==6) {
			figure="  O\n"+"+=[]=+";
			return figure;
		}
		if (lives==7) {
			figure="  O\n"+"+=[]=+\n"+"  []";
			return figure;
		}
		if (lives==8) {
			figure="  O\n"+"+=[]=+\n"+"  []\n"+"  /";
			return figure;
		}
		if (lives==9) {
			figure="  O\n"+"+=[]=+\n"+"  []\n"+"  /\\";
			return figure;
		}
		return figure;
	}
	
	public static void printTheOutput(int lives, int numberCorrect){
		String figure=getLives(lives);
		System.out.println(figure+numberCorrect);
	}
}
