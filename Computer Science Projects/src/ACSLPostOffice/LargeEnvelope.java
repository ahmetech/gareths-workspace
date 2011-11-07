package ACSLPostOffice;

public class LargeEnvelope {
	double length;
	double height;
	double thickness;
	int zone1;
	int zone2;
	double cost;
	
	public LargeEnvelope(double len, double hei, double thick, int zone12, int zone22){
		length=len;
		height=hei;
		thickness=thick;
		zone1=zone12;
		zone2=zone22;
		cost=.03;
	}
	
	public int getZone1() {
		return zone1;
	}
	public void setZone1(int zone1) {
		this.zone1 = zone1;
	}
	public int getZone2() {
		return zone2;
	}
	public void setZone2(int zone2) {
		this.zone2 = zone2;
	}
	public double getCost() {
		return cost;
	}
}
