package LabelMaker;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class labelMaker {
	static String artist;
	static String album;
	static ArrayList<String> description;
	static String year;



	public static void main(String[] args){
		/*Scanner input=new Scanner(System.in);
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
		}*/
		makeFolders(artist, album);


		System.out.println(artist);
		System.out.println(album);
		System.out.println(year);
		System.out.println("");
		System.out.println(album+" by "+artist);
		System.out.println("");
		System.out.println("Track listing:");
		for(int i=0; i<description.size();i++){
			System.out.println(description.get(i));
		}
		System.out.println("");
		System.out.println(artist+" - "+album+" "+year+" (WEB - FLAC - Lossless)");
		System.out.println(artist+" - "+album+" "+year+" (WEB - MP3 - 320)");
		System.out.println(artist+" - "+album+" "+year+" (WEB - MP3 - V0)");
		System.out.println(artist+" - "+album+" "+year+" (WEB - MP3 - V2)");
	}


	public static void makeFolders(String artist, String album){
		try{
			String strDirectoy ="E:\\Game\\res\\test";
			String strManyDirectories="dir1/dir2/dir3";

			// Create one directory
			boolean success = (
					new File(strDirectoy)).mkdir();
			if (success) {
				System.out.println("Directory: " 
						+ strDirectoy + " created");
			} 
		}
		catch (Exception e){//Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}
}

