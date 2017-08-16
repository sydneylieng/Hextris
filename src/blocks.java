import java.awt.*;
import java.util.ArrayList;

public class blocks {
	
	hextrisModel hM = new hextrisModel();
	
	int side; //used for side and color of the block
	
	ArrayList<Polygon> Blocks = new ArrayList<Polygon>(); //arraylist for the blocks
	ArrayList<Polygon> movingBlocks = new ArrayList<Polygon>(); //arraylist for the blocks
	ArrayList<Integer> color = new ArrayList<Integer>(); //arraylist for the colors of the blocks
	ArrayList<Integer> sideHeight = new ArrayList<Integer>(); //array list of the number of blocks on each side

	public void blocks(){ //creating the shapes for the game
		
		side = (int) (Math.round(5*Math.random())); //select random side for the block
		sideHeight.add(side); //add side to the arraylist
		createBlock(hM.check(sideHeight, side)); //create the block and check what height the block should be
		createMovingBlock();
	    
	    side = (int) (Math.round(3*Math.random()) + 1); //pick a random color
	    color.add(side); //add it to the arraylist
	}

	public void createBlock(int height){ //creating the blocks
		Polygon block = new Polygon(); //create the blocks
	    for(int i = side; i < side + 2; i++){ //add coordinates for each vertex
	    	block.addPoint((int) (height * Math.cos(i * 2 * Math.PI / 6)), (int) (height * Math.sin(i * 2 * Math.PI / 6)));
	    }
	    for(int i = side + 1; i > side - 1; i--){ 
	    	block.addPoint((int) ((height - 30) * Math.cos(i * 2 * Math.PI / 6)), (int) ((height - 30) * Math.sin(i * 2 * Math.PI / 6)));
	    }
	    
	    Blocks.add(block); //add to the arraylist
	}
	
	private void createMovingBlock() {
		Polygon block = new Polygon(); //create the blocks
	    for(int i = 4; i < 6; i++){ //add coordinates for each vertex
	    	block.addPoint((int) (130 * Math.cos(i * 2 * Math.PI / 6)), (int) (130 * Math.sin(i * 2 * Math.PI / 6)));
	    }
	    for(int i = 5; i > 3; i--){ 
	    	block.addPoint((int) (100 * Math.cos(i * 2 * Math.PI / 6)), (int) (100 * Math.sin(i * 2 * Math.PI / 6)));
	    }
	    
	    movingBlocks.add(block); //add to the arraylist
	}
}