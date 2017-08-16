import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

import javax.swing.*;

public class graphicSettings extends JComponent implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	hextrisModel hM = new hextrisModel();
	blocks b = new blocks();
	
	Graphics2D graphics; //graphic properties of the hex
	
	Timer t = new Timer(5, this); //timer
	
	JTextArea scoreText = new JTextArea();
	JButton gameOver = new JButton();
	
	int rotation = 0; //defines the degrees of rotation
	int x1 = 0; //keeps track of when it can rotate and how much rotation it should have
	int x2 = 0;
	int ran;
	int speed = 5;
	int track = 0;
	int track2 = 0;
	int score = 0;
	int size = 54;
	
	double check;
	double y = -250;
	double scale = 3.5;
	double fill = -150;
	
	boolean left; //see if left or right was chosen
	boolean turn;
	boolean pause;
	boolean lose = false;
	
	private Polygon bgHex;
	private Polygon hex;
	private Polygon block;
	
	ArrayList<Polygon> Blocks = new ArrayList<Polygon>();
	ArrayList<Polygon> movingBlocks = new ArrayList<Polygon>();
	ArrayList<Integer> color = new ArrayList<Integer>();
	ArrayList<Integer> side = new ArrayList<Integer>();
	
	double[][] scaling = new double[54][5]; //0 = falling of the block (translation), 1 = scaling of the block, 2 = rotation of the block
	int[][] board = new int[9][6];
	int[][] board2 = new int[9][6];
	int[] height = new int[6];
	
	graphicSettings() {
		
		gameOver.setBounds(365, 300, 551, 121);
        ImageIcon gOImg = new ImageIcon(this.getClass().getResource("/gameOver.png"));
        gameOver.setIcon(gOImg);
        gameOver.setVisible(false);
        
        scoreText.setBounds(10, 10, 350, 60);
        scoreText.setBackground(Color.decode("0Xeeeeee"));
        Font font = new Font("Arial", Font.BOLD, 50);
        scoreText.setFont(font);
        scoreText.setForeground(Color.BLUE);
        scoreText.setText("Score: " + score);
        
        setPreferredSize(new Dimension(1280, 720));
    }
	
	public void addHex(Polygon bgHex, Polygon hex){
		this.bgHex = bgHex;
		this.hex = hex;
		scaling = new double[size][5]; //adds doubles within the array
		
		for(int j = 0; j < 6; j++){
			for(int i = 0; i < 9; i++){
				board2[i][j] = -1;
			}
		}
	}
	
	public void addShapes (ArrayList<Polygon> Blocks, ArrayList<Polygon> movingBlocks, ArrayList<Integer> color, ArrayList<Integer> side){
		this.movingBlocks = movingBlocks;
		this.color = color;
		this.side = side;
		
		//scaling = new double[movingBlocks.size()][3]; //adds doubles within the array
    	for(int i = 0; i < movingBlocks.size(); i++){ //for each block
    		if(scaling[i][4] == 0){
    			scaling[i][0] = y; //adds start height
    			scaling[i][1] = scale;
    			scaling[i][2] = 60*(side.get(movingBlocks.size() - 1)); //adds starting side
    			scaling[i][3] = (int) movingBlocks.size() - 1;
    			scaling[i][4] = -1;
    			
    			i = movingBlocks.size();
    		}
    	}
	}

	public void paintComponent(Graphics g){ //creating the shapes for the game
		super.paintComponent(g); //paintComponent is used to make the shapes
		
		graphics = (Graphics2D) g; //create graphic properties for the shape
	    
	    graphics.translate(640, 360); //centre the shape
	    graphics.setColor(Color.DARK_GRAY);
	    graphics.fill(bgHex);
	    
	    AffineTransform at = new AffineTransform(); //add affine transform to create movement within the shape
	    
	    graphics.setTransform(at); //add the affine transform to the shape
	    graphics.translate(640, 360); //centre the shape
	    graphics.rotate(Math.toRadians(rotation)); //allows rotation
	    graphics.setColor(Color.GRAY); //change color
	    graphics.fill(hex); //create the shape and fill the color
	    
	    for(int i = 0; i < movingBlocks.size(); i++){//add graphic properties to each block in the arraylist
	    	block = movingBlocks.get(i);
	    }
	    
	    for(int j = 0; j < size; j++){
	    	if(color.get((int) scaling[j][3]) == 1){
	    		graphics.setColor(Color.decode("0X3399FF")); //change color
	    	}
	    	else if(color.get((int) scaling[j][3]) == 2){
	    		graphics.setColor(Color.decode("0XFF3333")); //change color
	    	}
	    	else if(color.get((int) scaling[j][3]) == 3){
	    		graphics.setColor(Color.decode("0XFFCC33")); //change color
	    	}
	    	else{
	    		graphics.setColor(Color.decode("0X009900")); //change color
	    	}
	    	
	    	graphics.setTransform(at); //add the affine transform to the shape
	    	graphics.translate(640, 360); //centre the shape
	    	graphics.rotate(Math.toRadians(scaling[j][2])); //rotation of each block
	    	graphics.translate(0, scaling[j][0]); //falling position of each block
	    	graphics.scale(scaling[j][1]*1, 1);
	    	graphics.fill(block); //create the shape and fill the color
	    }
	}

	@Override
	public void actionPerformed(ActionEvent e) { //timer actions
		if(pause == false && lose == false){
			hexRotation();
			blockRotation();
			moveBlocks();
			addBlocks();
			repaint();
		}
		
		else if(lose == true){
			gameOver.setVisible(true);
		}
	}
	
	public void hexRotation(){
		if(turn == true){
			
			if(left == true){ //if left is pushed
				rotation -= 3; //rotate to the left
			}
			else{ //otherwise rotate to the right
				rotation += 3;
			}
		
			x1 += 3;
			
		}
	}
	
	public void blockRotation(){
		if(turn == true){
			for(int i = 0; i < size; i++){
				if(scaling[i][4] == 1){ //if block hits the hexagon
					if(left == true){ //if left is pushed
						scaling[i][2] -= 3; //rotate to the left
						scaling[i][2] -= (Math.abs(rotation - scaling[i][2]) % 60); //accounts for if the hexagon is already moving, it makes sure it sticks to a side
					}
					else if(left == false){ //otherwise rotate to the right
						scaling[i][2] += 3;
						scaling[i][2] += ((rotation - scaling[i][2]) % 60);
					}
				}
				
			}
						
			if(x1 == 60){ //rotate it 1/6th of the hex
				x1 = 0;
				turn = false; //hex can now rotate again
				
				if(x1 == 0){
					if(left == true){
						track++;
						track2--;
						if(track >= 6){
							track = 0;
						}
						if(track2 <= -1){
							track2 = 5;
						}
					}
					else if(left == false){
						track--;
						track2++;
						if(track <= -1){
							track = 5;
						}
						if(track2 >= 6){
							track2 = 0;
						}
					}
				}
			}
		}
	}
	
	public void moveBlocks(){ //makes the blocks fall
		for(int i = 0; i < size; i++){ //goes through each block
			if(scaling[i][0] < checkHeight(findSide((int) scaling[i][3]))*-30 && scaling[i][4] == -1){ //if the block is not touching the hex
				scaling[i][0] += 0.1*speed;
				scaling[i][1] -= 0.001*speed;
			}
			else if(scaling[i][0] >= checkHeight(findSide((int) scaling[i][3]))*-30 && scaling[i][4] == -1){
				scaling[i][0] = checkHeight((findSide((int) scaling[i][3])))*-25;
				scaling[i][1] = 1 + checkHeight(findSide((int) scaling[i][3]))*0.25;
				scaling[i][4] = 1;
				checkSide((int) scaling[i][3]);
			}
			else{
				
			}
		}
	}
	
	public int findSide(int num){
		if((track + side.get(num)) > 5){
			return ((track + side.get(num)) - 6);
		}
		else{
			return (track + side.get(num));
		}
	}
	
	public int findSide2(int side){
		return (track2 + side);
	}
	
	public int checkHeight(int side){
		int height = 0;
		for(int i = 0; i < 9; i++){
			if(board[i][side] != 0){
				height++;
			}
		}
		if(height >= 7){
			lose = true;
		}
		return height;
	}
	
	public void checkSide(int num){
		boolean add = true;
		for(int j = 0; j < 6; j++){
			for(int i = 0; i < 9; i++){
				if(board2[i][j] == num){
					add = false;
				}
			}
		}
		if(add == true){
			if((track + side.get(num)) > 5){
				side.set(num, (track + side.get(num)) - 6);
			}
			else{
				side.set(num, (track + side.get(num)));
			}
			
			
			board[height[side.get(num)]][side.get(num)] = color.get(num);
			board2[height[side.get(num)]][side.get(num)] = num;
			height[side.get(num)]++;
			
		}
		deleteBlocks(hM.finalCheck(board, board2));
		increaseSpeed();
	}
	
	public void addBlocks(){
		x2++;
		if(x2 == 400){
			b.blocks();
			movingBlocks.add(b.movingBlocks.get(movingBlocks.size() - 1));
			color.add(b.color.get(color.size() - 1));
			side.add(b.sideHeight.get(side.size() - 1));
			addShapes(Blocks, movingBlocks, color, side);
			x2 = 0;
		}
	}
	
	public void removeBlocks(){
		for(int l = 0; l < size; l++){
			if(scaling[l][4] == 1){
				for(int j = 0; j < 5; j++){
					scaling[l][j] = 0;
				}
			}
		}
	}
	
	public int[][] boardState(int[][] board, int[][] board2){
		deleteBlocks(hM.finalCheck(board, board2));
		/*if(this.board == output){
			return true;
		}
		else{
			return false;
		}*/
		return this.board;
	}
	
	public void deleteBlocks(ArrayList<Integer> delete){
		removeBlocks();
		for(int i = 0; i < delete.size(); i++){
			for(int j = 0; j < 6; j++){
				for(int k = 0; k < 9; k++){
					if(board2[k][j] == delete.get(i)){
						board[k][j] = 0;
						board2[k][j] = -1;
						height[j]--;
						
						updateScore();
						
					}
				}
			}
		}
		shiftBlocks();
	}
	
	public void shiftBlocks(){
		int count;
		for(int j = 0; j < 6; j++){
			count = 0;
			for(int i = 0; i < 9; i++){
				if(board[i][j] == 0){
					count++;
				}
				else if(count > 0){
					board[i - count][j] = board[i][j];
					board2[i - count][j] = board2[i][j];
					
					board[i][j] = 0;
					board2[i][j] = -1;
				}
			}
		}
		reAddBlocks();
	}
	
	public void reAddBlocks(){
		int counter = 0;
		
		for(int j = 0; j < 6; j++){
			for(int i = 0; i < 9; i++){
				if(scaling[counter][4] == -1){
					counter++;
				}
				else if(board[i][j] != 0){
					scaling[counter][0] = i*-25;
					scaling[counter][1] = 1 + i*0.25;
					scaling[counter][2] = findSide2(j)*60;
					scaling[counter][3] = board2[i][j];
					scaling[counter][4] = 1;
					counter++;
				}
			}
		}
		if(hM.finalCheck(board, board2).size() != 0){
			deleteBlocks(hM.finalCheck(board, board2));
		}
	}
	
	public void updateScore(){
		score = score + 115;
		scoreText.setText("Score: " + score);
	}
	
	public void increaseSpeed(){
		speed = (int) (5 + (Math.round(score/500)*1.5));
	}
}