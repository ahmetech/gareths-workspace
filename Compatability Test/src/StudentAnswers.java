import java.util.ArrayList;

public class StudentAnswers{
	public static int score=0;
    
    //Change this variable if simple matches are not enough to compare against
    
    public static final boolean BONUS_ON = false;
    
    public static int[][] calculateMatches(ArrayList<StudentData> all){
        
        int[][] matches = new int[all.size()][all.size()];
        double percentMatch=0.00;
        double decscore=0.0;
        int intScore=0;
        
        for (int x=0; x<all.size(); x++){
            for (int y=0; y<all.size(); y++)
            {
            	String Student1=all.get(x).studentID;
            	String Student2=all.get(y).studentID;
                if (!all.get(x).studentID.equals(all.get(y).studentID))
                {	
                	try
                    {
                       matches[x][y] = getScore(all, x, y);
                       if(score>7)
                       {
                    	   decscore=score;
                    	   percentMatch=(decscore/15.0)*100;
                    	   intScore=(int)percentMatch;
                    	   System.out.println(intScore+"% match between" + (all.get(x).formattedName)
                                   +  " and" + (all.get(y).formattedName));
                       }   
                    }
                	catch(NullPointerException e)
                	{
                        System.out.println("ERROR:  " + e.getMessage());
                        System.out.println("Skipped matches for ID: " + all.get(x).studentID
                                +  " with comparison to " + all.get(y).studentID);
                    }
                }
                else
                    matches[x][y] = 0;
            }
        }
        return matches;
    }
    
    public static int getScore(ArrayList<StudentData> all, int x, int y){
        String xAnswers = all.get(x).answers;
        String yAnswers = all.get(y).answers;
        score = 0;
        
        if (xAnswers.length() == yAnswers.length()){
            
            //Simple comparison test
            for (int z=0; z < xAnswers.length(); z++){
                if (xAnswers.charAt(z) == yAnswers.charAt(z))
                    score++;
            }
            
            //This is where specialty questions are called
            if (BONUS_ON){
             score += specialtyQs(xAnswers, yAnswers);
            }
            return score;          
        }else
            //You can change this to all.get(x).studentName if you want to student's name to be printed instead of ID.
            
            throw new NullPointerException("One of the following students answer sheet is incomplete: "
                          + all.get(x).studentID + " or " + all.get(y).studentID);
    }
    
    /*
     * Edit this method if you need
     * Optional
     */
    public static int specialtyQs(String x, String y){
        
        int bonusScore = 0;
        
        //Examples for Specialty Question Format
            if (x.charAt(3) == 'A' && y.charAt(3) == 'D'){
                bonusScore += 3;
            }
            if (x.charAt(4) == 'B' && y.charAt(2) == 'B'){
                bonusScore -= 4;
            }
            
        
        return bonusScore;
        
    }
}
