import java.util.ArrayList;

public class hextrisModel { //will be used later when making MVC format
	
	ArrayList<Integer> delete = new ArrayList<Integer>();
	
	int[][] arrayPieces = new int[7][6];// Array will keep track of pieces on board
	int[][] board = new int[9][6];
	int[][] board2 = new int[9][6];
	int x;
	int x1;
	int counter;
	
	public hextrisModel(){
		
	}
	
	
	public int check(ArrayList<Integer> sideHeight, int side){ //used to check how high each piece should be
		x1 = 0;
		for(int i = 0; i < sideHeight.size(); i++){ //go through entire list array
			if(sideHeight.get(i) == side){ //if a piece is on the side new piece is trying to go to
				x1++; //increase x
			}
		}
		
		return 100 + x1*30; //place piece height x number of blocks above hexagon
	}
	
	public double moveBlocks(double y){//takes the height value of the blocks
		y += 0.1; //moves the block down
		return y; //returns new value of height of the block
	}
	
	public void checkAgain(int[][] board, int[][] board2){
		checkWin(board, board2);
	}
	
	public void checkWin(int[][] board, int[][] board2){
		//counter = 1;
		delete.clear();
		
		this.board = board;
		this.board2 = board2;
		
		for(int j = 5; j > -1; j--){
			for(int i = 8; i > -1; i--){
				if(board[i][j] != 0){
					counter = 1;
					delete.add(board2[i][j]);
					checkAll(i, j, board[i][j]);
					if(counter < 3){
						for(int k = counter; k > 0; k--){
							delete.remove(delete.size() - k);
						}
					}
				}
			}
		}
		//finalCheck();
	}
	
	public void checkAll(int i, int j, int color){
		checkRight(i,j,color);
		checkLeft(i,j,color);
		checkVerticalDown(i,j,color);
		checkVerticalDown(i,j,color);
	}

	public void checkVerticalDown(int i, int j, int color){
		if(i > 0){
			if(board[i-1][j] == color){
				if(delete.contains(board2[i-1][j])){
					
				}
				else{
					counter++;
					delete.add(board2[i-1][j]);
					checkAll(i-1,j,color);
				}
			}
		}
	}
	
	public void checkVerticalUp(int i, int j, int color){
		if(i < 8){
			if(board[i+1][j] == color){
				if(delete.contains(board2[i+1][j])){
					
				}
				else{
					counter++;
					delete.add(board2[i+1][j]);
					checkAll(i+1,j,color);
				}
			}
		}
	}

	public void checkRight(int i, int j, int color){
		if(j == 5){
			if(board[i][0] == color){
				if(delete.contains(board2[i][0])){
					
				}
				else{
					counter++;
					delete.add(board2[i][0]);
					checkAll(i,0,color);
				}
			}
		}
		else{
			if(board[i][j+1] == color){
				if(delete.contains(board2[i][j+1])){
					
				}
				else{
					counter++;
					delete.add(board2[i][j+1]);
					checkAll(i,j+1,color);
				}
			}
		}
	}

	public void checkLeft(int i, int j, int color){
		if(j == 0){
			if(board[i][5] == color){
				if(delete.contains(board2[i][5])){
					
				}
				else{
					counter++;
					delete.add(board2[i][5]);
					checkAll(i,5,color);
				}
			}
		}
		else{
			if(board[i][j-1] == color){
				if(delete.contains(board2[i][j-1])){
					
				}
				else{
					counter++;
					delete.add(board2[i][j-1]);
					checkAll(i,j-1,color);
				}
			}
		}
	}

	public ArrayList<Integer> finalCheck(int[][] board, int[][] board2){
		checkWin(board, board2);
		
		return delete;
	}
}