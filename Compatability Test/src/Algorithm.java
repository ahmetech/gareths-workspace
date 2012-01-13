import java.util.ArrayList;


public class Algorithm {

    public final static int M_OR_F_Q_NUM = 0; //Change this to your Q Number
    public final static char MALE = "A"; //Change this to the char Answer for 'male'
    public final static int NUM_MATCHES_WANTED = 5; //Change this to how many results you want
    
    public String[] matches;
    public int[] scores;
    
    public Algorithm(String[] m, int[] s){
        
        matches = m;
        scores = s;
        
    }
    public static Algorithm bestMatches(int[] m, ArrayList<StudentData> all, boolean isMale){
        String[] matches = new String[NUM_MATCHES_WANTED];
        int[] scores = new int[NUM_MATCHES_WANTED];
        
        for (int x=0;x<m.length; x++){
            for (int y=0;y<scores.length;y++){
                
                if (m[x] > scores[y] && (all.get(x).answers.charAt(M_OR_F_Q_NUM) == MALE) == isMale){
                    
                    scores[y] = m[x];
                    matches[y] = all.get(x).studentID;
                    break;
                }
            }
        }
        
        Algorithm a = new Algorithm(matches, scores);
        return a;
        
    }
    public static Algorithm bestMatches(int[] m, ArrayList<StudentData> all){
        String[] matches = new String[NUM_MATCHES_WANTED];
        int[] scores = new int[NUM_MATCHES_WANTED];
        
        for (int x=0;x<m.length; x++){
            for (int y=0;y<scores.length;y++){
                
                if (m[x] > scores[y]){
                    
                    scores[y] = m[x];
                    matches[y] = all.get(x).studentID;
                    break;
                }
            }
        }
        Algorithm a = new Algorithm(matches, scores);
        return a;
        
        
    }
    
    public static int[] singleAnswers(int[][] m, int p){
        int[] singlePerson = new int[m[p].length];
        
        for (int x=0;x<singlePerson.length;x++){
            singlePerson[x] = m[p][x];
        }
        return singlePerson;
        
    }
    
    
}
