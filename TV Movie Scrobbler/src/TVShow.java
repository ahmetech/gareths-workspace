import java.io.Serializable;


public class TVShow implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String ShowTitle;
	public String EpisodesWatches;
	public String Score;
	
	public TVShow(String Name){
		ShowTitle = Name;
	}
	
	public String getShowTitle() {
		return ShowTitle;
	}
	public void setShowTitle(String showTitle) {
		ShowTitle = showTitle;
	}
	public String getEpisodesWatches() {
		return EpisodesWatches;
	}
	public void setEpisodesWatches(String episodesWatches) {
		EpisodesWatches = episodesWatches;
	}
	public String getScore() {
		return Score;
	}
	public void setScore(String score) {
		Score = score;
	}
}
