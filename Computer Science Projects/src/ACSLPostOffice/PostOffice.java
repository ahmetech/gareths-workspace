package ACSLPostOffice;

import java.util.Scanner;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

public class PostOffice {
	public static void main(String[] args){
		for (int i = 0; i < 5; i++) {
			String[] userinput;
			double length=0;
			double height = 0;
			double thickness= 0;
			int zone1= 0;
			int zone2= 0;
			double cost;
			Scanner input=new Scanner(System.in);
			String user=input.nextLine();
			userinput=getinput(user);
			organizeinput(userinput, length, height, thickness, zone1, zone2);
			if((length>3.5&&length<4.25)&&(height>3.5&&height<6)&&(thickness>.007&&thickness<.016)){
				RegularPostCard regularPostCard=new RegularPostCard(length, height, thickness, zone1, zone2);
				cost=regularPostCard.getCost();
			}else if ((length>4.25&&length<6)&&(height>6&&height<11.5)&&(thickness>.016&&thickness<.25)) {
				LargePostCard largePostCard=new LargePostCard(length, height, thickness, zone1, zone2);
				cost=largePostCard.getCost();
			}else if((length>3.5&&length<6.125)&&(height>5&&height<11.5)&&(thickness>.016&&thickness<.25)){
				Envelope envelope=new Envelope(length, height, thickness, zone1, zone2);
				cost=envelope.getCost();
			}else if ((length>6.125&&length<24)&&(height>11&&height<18)&&(thickness>.25&&thickness<.5)){
				LargeEnvelope largeEnvelope=new LargeEnvelope(length, height, thickness, zone1, zone2);
				cost=largeEnvelope.getCost();
			}else if ((length>3.5&&length<6.125)&&(height>5&&height<11.5)&&(thickness>.016&&thickness<.25)){
				Package package1=new Package(length, height, thickness, zone1, zone2);
				cost=package1.getCost();
			}else if((length>3.5&&length<6.125)&&(height>5&&height<11.5)&&(thickness>.016&&thickness<.25)){
				LargePackage largePackage=new LargePackage(length, height, thickness, zone1, zone2);
				cost=largePackage.getCost();
			}else{
				System.out.println("Unmailable");
			}
			
		}
	}
	public static String[] getinput(String user){
		String[] userinput=user.split(",");
		return userinput;
	}
	public static void organizeinput(String[] userinput, double length,double height,double thickness,int zone1,int zone2){
		length=Double.valueOf(userinput[0]);
		height=Double.valueOf(userinput[1]);
		thickness=Double.valueOf(userinput[2]);
		if (userinput[3].substring(0,2).equals(" 0")) {
			zone1=Integer.valueOf(userinput[3].substring(2, 6));
		}else zone1=Integer.valueOf(userinput[3]);
		if (userinput[4].substring(0,2).equals(" 0")) {
			zone2=Integer.valueOf(userinput[4].substring(2, 6));
		}else zone2=Integer.valueOf(userinput[4]);
	}
	public static void findcost(double cost, int zone1, int zone2){
		
	}
}
