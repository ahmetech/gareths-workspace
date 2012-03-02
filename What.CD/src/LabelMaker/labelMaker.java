package LabelMaker;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class labelMaker {
	static String artist;
	static String album;
	static ArrayList<String> description;
	static String year;



	public static void main(String[] args) throws IOException{
		Scanner input=new Scanner(System.in);
		description=new ArrayList<String>();
		boolean on=true;
		ArrayList<String> inputs=new ArrayList<String>();
		System.out.println("Please input:");
		while(on){
			String temp=input.nextLine();
			if(!temp.equals("done")){
				inputs.add(temp);
			}else on=false;

		}
		year=inputs.remove(0);
		album=inputs.remove(0);
		String tempArtist=inputs.remove(0);
		artist=tempArtist.substring(3,tempArtist.length());
		while(!(inputs.size()==0)){
			String one=inputs.remove(0);
			String two=inputs.remove(0);
			String info=one+" "+two;
			description.add(info);
		}
		makeFolders(artist, album);
		makeText(artist, album, description, year);
	}


	public static void makeFolders(String artist, String album){
		try{
			String Directoy ="A:\\Downloads\\Music\\"+artist+" - "+album;
			String FLAC=Directoy+"\\"+artist +" - "+album+" "+year+" (WEB - FLAC - Lossless)";
			String MP3320=Directoy+"\\"+artist +" - "+album+" "+year+" (WEB - MP3 - 320)";
			String V0=Directoy+"\\"+artist +" - "+album+" "+year+" (WEB - MP3 - V0)";
			String V2=Directoy+"\\"+artist +" - "+album+" "+year+" (WEB - MP3 - V2)";
			boolean success = (
					new File(Directoy)).mkdir();
			if (success) {
				System.out.println("Directory: " 
						+ Directoy + " created");
			} 
			boolean success1 = (
					new File(FLAC)).mkdir();
			if (success1) {
				System.out.println("Directory: " 
						+ FLAC + " created");
			} 
			boolean success2 = (
					new File(MP3320)).mkdir();
			if (success2) {
				System.out.println("Directory: " 
						+ MP3320 + " created");
			} boolean success3 = (
					new File(V0)).mkdir();
			if (success3) {
				System.out.println("Directory: " 
						+ V0 + " created");
			} boolean success4 = (
					new File(V2)).mkdir();
			if (success4) {
				System.out.println("Directory: " 
						+ V2 + " created");
			} 
		}
		catch (Exception e){//Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}
	
	public static void makeText(String artist, String album, ArrayList<String> des, String year) throws IOException{
		FileWriter file=new FileWriter("A:\\Downloads\\Music\\"+artist+" - "+album+"\\stuff.txt");
		BufferedWriter out=new BufferedWriter(file);
		out.write(artist);
		out.newLine();
		out.write(album);
		out.newLine();
		out.write(year);
		out.newLine();
		out.write(album+" by "+artist);
		out.newLine();
		out.newLine();
		out.write("Track listing:");
		out.newLine();
		for(int i=0; i<description.size();i++){
			out.write(description.get(i));
			out.newLine();
		}
		out.close();
	}
	
}

