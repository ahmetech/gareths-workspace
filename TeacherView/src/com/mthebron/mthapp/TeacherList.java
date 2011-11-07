package com.mthebron.mthapp;
import java.io.FileNotFoundException;
import java.util.Scanner;
import 	android.content.res.AssetManager;

public class TeacherList {
	public static Teacher[] MakeList() throws FileNotFoundException{
		Teacher[] teachers=new Teacher[71];	
		Scanner iScanner=new Scanner(getAssets().open("TeacherInformation.txt"));
		StringBuilder teachersBuilder=new StringBuilder();
		while(iScanner.hasNext()) {
			teachersBuilder.append(iScanner.nextLine());
			teachersBuilder.append("\n");
		}
		String fullList=teachersBuilder.toString();
		String[] seperatedList=fullList.split("'");
		String[] blah=seperatedList[0].split("\n");
		String temp=blah[0].substring(3, 9);	
		String name=temp;
		String department=blah[1];
		String planning=blah[2];
		String club=blah[3];
		String sport=null;
		String email=blah[5];
		String website=null;
		teachers[0]=new Teacher(name, department, planning, club, sport, email, website);
		System.out.println(teachers[0].getSportsCoached());
		for (int i = 1; i < seperatedList.length; i++) {
			blah=seperatedList[i].split("\n");
			name=blah[1];
			department=blah[2];
			if (blah[3].equals("null")) {
				planning=null;
			}else planning=blah[3];
			if (blah[4].equals("null")) {
				sport=null;
			}else sport=blah[4];
			if (blah[5].equals("null")) {
				club=null;
			}else club=blah[5];
			if (blah[6].equals("null")) {
				email=null;
			}else email=blah[6];
			if (blah[7].equals("null")) {
				website=null;
			}else website=blah[7];
			teachers[i]=new Teacher(name, department, planning, sport, club, email, website);
		}
		return teachers;
	}
}
