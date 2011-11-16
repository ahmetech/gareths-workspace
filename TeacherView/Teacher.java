

public class Teacher {
	protected String Name;
	protected String Department;
	protected String PlanningPeriod;
	protected String SportsCoached;
	protected String ClubsSponsored;
	protected String Email;
	protected String Website;
	public Teacher(String name, String department, String planningperiod, String clubssponsored, String sportscoached, String email, String website){
		this.setName(name);
		this.setDepartment(department);
		this.setPlanningPeriod(planningperiod);
		this.setSportsCoached(sportscoached);
		this.setClubsSponsored(clubssponsored);
		this.setEmail(email);
		this.setWebsite(website);
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getDepartment() {
		return Department;
	}
	public void setDepartment(String department) {
		Department = department;
	}
	public String getPlanningPeriod() {
		return PlanningPeriod;
	}
	public void setPlanningPeriod(String planningPeriod) {
		PlanningPeriod = planningPeriod;
	}
	public String getSportsCoached() {
		return SportsCoached;
	}
	public void setSportsCoached(String sportsCoached) {
		SportsCoached = sportsCoached;
	}
	public String getClubsSponsored() {
		return ClubsSponsored;
	}
	public void setClubsSponsored(String clubsSponsored) {
		ClubsSponsored = clubsSponsored;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getWebsite() {
		return Website;
	}
	public void setWebsite(String website) {
		Website = website;
	}
}
