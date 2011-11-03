package ACSLPostOffice;

import java.util.Scanner;

public class PostOffice {
	public static void main(String[] args){
		for (int i = 0; i < 5; i++) {
			String[] userinput;
			double length=0;
			double height = 0;
			double thickness= 0;
			int zone1= 0;
			int zone2= 0;
			Scanner input=new Scanner(System.in);
			String user=input.next();
			userinput=getinput(user);
			organizeinput(userinput, length, height, thickness, zone1, zone2);
			if((length>3.5&&length<4.25)&&(height>3.5&&height<6)&&(thickness>.007&&thickness<.016)){
				RegularPostCard blah=new RegularPostCard(length, height, thickness, zone1, zone2);
			}
		}
	}
	public static String[] getinput(String user){
		String[] userinput=user.split(",");
		return userinput;
	}
	public static void organizeinput(String[] userinput, double length,double height,double thickness,int zone1,int zone2){
		length=(double)Integer.getInteger(userinput[0]);
		height=(double)Integer.getInteger(userinput[1]);
	}
}
