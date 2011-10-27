package StringFlicker;

import java.util.Scanner;

public class String_Flicker {
	public static void main(String[] Args){
		for(int x=0;x<5;x++){
			Scanner kasperisasmallpieceofdoodoo= new Scanner(System.in);
			String userinput=kasperisasmallpieceofdoodoo.next();
			int numbexp=findnumberofexpressions(userinput);
			String[] things=userinput.split("/");
			String word=things[numbexp];
			word=change(things, word, numbexp);
			System.out.print(word);
		}
	}
	public static int findnumberofexpressions(String userinput){
		boolean blah=true;
		int o=0;
		if(blah){
			for(int x=0; x<userinput.length();x++){
				if((userinput.substring(x,x+1)).matches("/")){
					o++;
				}
			}
		}
		return o;
	}
	public static String change(String[] things, String word, int numbexp){
		for(int i=0; i<numbexp;i++){
			String blah=things[i];
			if(blah.substring(0,2).equals("LS")){
				word=lsx(blah, word);
			}
			if(blah.substring(0,2).equals("RS")){
				word=rsx(blah, word);
			}
			if(blah.substring(0,2).equals("LC")){
				word=lcx(blah, word);
			}
			if(blah.substring(0,2).equals("RC")){
				word=rcx(blah, word);
			}
			if(blah.substring(0,2).equals("MC")){
				word=mcslxd(blah, word);
			}
			if(blah.substring(0,3).equals("REV")){
				word=revsl(blah, word);
			}
			if(blah.substring(0,4).equals("SWAP")){
				word=swapslp(blah, word);
			}
			if(blah.substring(0,4).equals("SORT")){
				word=sortslm(blah, word);
			}
		}
		return word;
	}
	public static String lsx(String exp, String word){
		String[] temporary=exp.split("-");
		int change=Integer.valueOf(temporary[temporary.length-1]);
		word=word.substring(change, word.length());
		for(int j=0;j<change;j++){
			word+="#";
		}
		return word;
	}
	public static String rsx(String exp, String word){
		String[] temporary=exp.split("-");
		int change=Integer.valueOf(temporary[temporary.length-1]);
		word=word.substring(0, word.length()-change);
		for(int j=0;j<change;j++){
			word="#"+word;
		}
		return word;
	}
	public static String lcx(String exp, String word){
		String[] temporary=exp.split("-");
		int change=Integer.valueOf(temporary[temporary.length-1]);
		String word1=word.substring(0, change);
		String word2=word.substring(change, word.length());
		word=word2+word1;
		return word;
	}
	public static String rcx(String exp, String word){
		String[] temporary=exp.split("-");
		int change=Integer.valueOf(temporary[temporary.length-1]);
		String word1=word.substring(0, word.length()-change);
		String word2=word.substring(word.length()-change, word.length());
		word=word2+word1;
		return word;
	}
	public static String mcslxd(String exp, String word){
		String[] temporary=exp.split("-");
		String change=(temporary[temporary.length-1]);
		int start=Integer.valueOf(change.substring(0,1));start-=1;
		int length=Integer.valueOf(change.substring(1,2));
		int changex= Integer.valueOf(change.substring(2,3));
		String dir=change.substring(3,4);
		if (start==0) {
			String word1=word.substring(0,length);
			String word2=word.substring(length, word.length());
			if(dir.equals("L")){
				String word2part1=word1.substring(0,changex);
				String word2part2=word1.substring(changex, word1.length());
				word1= word2part2+word2part1;
				word=word1+word2;
			}
			if (dir.equals("R")) {
				String word2part1=word1.substring(0,word1.length()-changex);
				String word2part2=word1.substring(word1.length()-changex, word1.length());
				word1= word2part2+word2part1;
				word=word1+word2;
			}
		} else {
			String word1=word.substring(0,start);
			String word2=word.substring(start, start+length);
			String word3=word.substring(start+length, word.length());
			if(dir.equals("L")){
				String word2part1=word2.substring(0,changex);
				String word2part2=word2.substring(changex, word2.length());
				word2= word2part2+word2part1;
				word=word1+word2+word3;
			}
			if (dir.equals("R")) {
				String word2part1=word2.substring(0,word2.length()-changex);
				String word2part2=word2.substring(word2.length()-changex, word2.length());
				word2= word2part2+word2part1;
				word=word1+word2+word3;
			}
		}
		return word;
	}
	public static String revsl(String exp, String word){
		String[] temporary=exp.split("-");
		String change=(temporary[temporary.length-1]);
		int start=Integer.valueOf(change.substring(0,1));start-=1;
		int length=Integer.valueOf(change.substring(1,2));
		if (start==0) {
			String word1=word.substring(0,length);
			String word2=word.substring(length, word.length());
			char[] bob=new char[word1.length()];
			for (int i = 0; i < bob.length; i++) {
				bob[i]=word1.charAt(i);
			}
			char[]switched=new char[bob.length];
			for (int i = 0; i < bob.length; i++) {
				switched[bob.length-1-i]=bob[i];
			}
			word1="";
			for (int i = 0; i < bob.length; i++) {
				word1+=switched[i];
			}
			word=word1+word2;
		} else {
			String word1=word.substring(0,start);
			String word2=word.substring(start, start+length);
			String word3=word.substring(start+length, word.length());
			char[] bob=new char[word2.length()];
			for (int i = 0; i < bob.length; i++) {
				bob[i]=word2.charAt(i);
			}
			char[]switched=new char[bob.length];
			for (int i = 0; i < bob.length; i++) {
				switched[bob.length-1-i]=bob[i];
			}
			word2="";
			for (int i = 0; i < bob.length; i++) {
				word2+=switched[i];
			}
			word=word1+word2+word3;
		}

		return word;
	}
	public static String swapslp(String exp, String word){
		String[] temporary=exp.split("-");
		String change=(temporary[temporary.length-1]);
		int start=Integer.valueOf(change.substring(0,1));start-=1;
		int length=Integer.valueOf(change.substring(1,2));
		int position=Integer.valueOf(change.substring(2,3));position-=1;
		if (start==0) {
			String word2=word.substring(start, start+length);
			String word3=word.substring(start+length, position);
			String word4=word.substring(position, position+length);
			String word5=word.substring(position+length, word.length());
			word=word4+word3+word2+word5;
		} else {
			String word1=word.substring(0,start);
			String word2=word.substring(start, start+length);
			String word3=word.substring(start+length, position);
			String word4=word.substring(position, position+length);
			String word5=word.substring(position+length, word.length());
			word=word1+word4+word3+word2+word5;
		}
		return word;
	}
	public static String sortslm(String exp, String word){
		String[] temporary=exp.split("-");
		String change=(temporary[temporary.length-1]);
		int start=Integer.valueOf(change.substring(0,1));start-=1;
		int length=Integer.valueOf(change.substring(1,2));
		String m=change.substring(2,3);
		if (start==0) {
			String word1=word.substring(0,length);
			String word2=word.substring(length, word.length());
			if (m.equals("A")) {
				int[] bob=new int[word1.length()];
				for (int i = 0; i < word1.length(); i++) {
					bob[i]=word1.charAt(i)-65;
				}
				for (int i = 0; i < bob.length; i++) {
					for (int j =i+1; j < bob.length; j++) {
						int first=bob[i];
						int second=bob[j];
						if(second<first){
							bob[i]=second;
							bob[j]=first;
						}
					}
				}
				char[] thing=new char[bob.length];
				for (int i = 0; i < bob.length; i++) {
					thing[i]=(char) ((bob[i])+65);
				}
				word1="";
				for (int i = 0; i < bob.length; i++) {
					word1+=thing[i];
				}
				word=word1+word2;
			} 
			if(m.equals("D")){
				int[] bob=new int[word1.length()];
				for (int i = 0; i < word1.length(); i++) {
					bob[i]=word1.charAt(i)-65;
				}
				for (int i = 0; i < bob.length; i++) {
					for (int j = i+1; j < bob.length; j++) {
						int first=bob[i];
						int second=bob[j];
						if(second>first){
							bob[i]=second;
							bob[j]=first;
						}
					}
				}
				char[] thing=new char[bob.length];
				for (int i = 0; i < bob.length; i++) {
					thing[i]=(char) ((bob[i])+65);
				}
				word1="";
				for (int i = 0; i < bob.length; i++) {
					word1+=thing[i];
				}
				word=word1+word2;
			}
		} else {
			String word1=word.substring(0,start);
			String word2=word.substring(start, start+length);
			String word3=word.substring(start+length, word.length());
			if (m.equals("A")) {
				int[] bob=new int[word2.length()];
				for (int i = 0; i < word2.length(); i++) {
					bob[i]=word2.charAt(i)-65;
				}
				for (int i = 0; i < bob.length; i++) {
					for (int j = i+1; j < bob.length; j++) {
						int first=bob[i];
						int second=bob[j];
						if(second<first){
							bob[i]=second;
							bob[j]=first;
						}
					}
				}
				char[] thing=new char[bob.length];
				for (int i = 0; i < bob.length; i++) {
					thing[i]=(char) ((bob[i])+65);
				}
				word2="";
				for (int i = 0; i < bob.length; i++) {
					word2+=thing[i];
				}
				word=word1+word2+word3;
			} 
			if(m.equals("D")){
				int[] bob=new int[word2.length()];
				for (int i = 0; i < word2.length(); i++) {
					bob[i]=word2.charAt(i)-65;
				}
				for (int i = 0; i < bob.length; i++) {
					for (int j = i+1; j < bob.length; j++) {
						int first=bob[i];
						int second=bob[j];
						if(second>first){
							bob[i]=second;
							bob[j]=first;
						}
					}
				}
				char[] thing=new char[bob.length];
				for (int i = 0; i < bob.length; i++) {
					thing[i]=(char) ((bob[i])+65);
				}
				word2="";
				for (int i = 0; i < bob.length; i++) {
					word2+=thing[i];
				}
				word=word1+word2+word3;
			}
			word=word1+word2+word3;
		}
		return word;
	}


}