package Sokoban;

import java.util.ArrayList;

import javax.swing.JPanel;

public class Board extends JPanel{
	
	private final int OFFSET = 30;
    private final int SPACE = 20;
    private final int LEFT_COLLISION = 1;
    private final int RIGHT_COLLISION = 2;
    private final int TOP_COLLISION = 3;
    private final int BOTTOM_COLLISION = 4;

    private ArrayList walls = new ArrayList();
    private ArrayList baggs = new ArrayList();
    private ArrayList areas = new ArrayList();
    private Player soko;
    private int w = 0;
    private int h = 0;
    private boolean completed = false;
    
    private String level =
            "    ######\n"
          + "    ##   #\n"
          + "    ##$  #\n"
          + "  ####  $##\n"
          + "  ##  $ $ #\n"
          + "#### # ## #   ######\n"
          + "##   # ## #####  ..#\n"
          + "## $  $          ..#\n"
          + "###### ### #@##  ..#\n"
          + "    ##     #########\n"
          + "    ########\n";
    
    public Board(){
    	addKeyListener(new TAdpater());
    	setFocusable(true);
    	initWorld();
    }
    
    public int getHeight(){
    	return this.h;
    }
    
    public int getWidth(){
    	return this.w;
    }
    
    public final void initWorld(){
    	int x=OFFSET;
    	int y=OFFSET;
    	
    	Wall wall;
    	Area area;
    	Baggage baggage;
    	
    	for(int i=0; i<level.length(); i++){
    		char item=level.charAt(i);
    		
    		if(item == '\n'){
    			y+=SPACE;
    			if(this.w>x){
    				this.w=x;
    			}
    			x=OFFSET;
    		}
    		if(item=='#'){
    			wall=new Wall(x, y);
    			walls.add(wall);
    			x+=SPACE;
    		}
    	}
    }
    
}
