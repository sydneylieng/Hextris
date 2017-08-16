import java.awt.*;

public class shapes {
	
	Polygon bgHex = new Polygon();
	
	Polygon hex = new Polygon(); //create new polygon

	public void shapes(){ //creating the shapes for the game
	    
	    for(int i = 0; i < 6; i++){ //add coordinates for each vertex
	    	bgHex.addPoint((int) (300 * Math.cos(i * 2 * Math.PI / 6)), (int) (300 * Math.sin(i * 2 * Math.PI / 6)));
	    }
		
	    
	    for(int i = 0; i < 6; i++){ //add coordinates for each vertex
	    	hex.addPoint((int) (100 * Math.cos(i * 2 * Math.PI / 6)), (int) (100 * Math.sin(i * 2 * Math.PI / 6)));
	    }
	}
}
