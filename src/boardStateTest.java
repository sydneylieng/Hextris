import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class boardStateTest {

	@Test
	public void test() {
		graphicSettings gS = new graphicSettings();
		
		int[][] board0 = {{0,0,0,0,0,0},
						  {0,0,0,0,0,0},
						  {0,0,0,0,0,0},
						  {0,0,0,0,0,0},
						  {0,0,0,0,0,0},
						  {0,0,0,0,0,0},
						  {0,0,0,0,0,0},
						  {0,0,0,0,0,0},
						  {0,0,0,0,0,0}};
		
		int[][] board20 = {{0,0,0,0,0,0},
						   {0,0,0,0,0,0},
						   {0,0,0,0,0,0},
						   {0,0,0,0,0,0},
						   {0,0,0,0,0,0},
						   {0,0,0,0,0,0},
						   {0,0,0,0,0,0},
						   {0,0,0,0,0,0},
						   {0,0,0,0,0,0}};
		
		int[][] expectedOutput = {{0,0,0,0,0,0},
				  				  {0,0,0,0,0,0},
				  				  {0,0,0,0,0,0},
				  				  {0,0,0,0,0,0},
				  				  {0,0,0,0,0,0},
				  				  {0,0,0,0,0,0},
				  				  {0,0,0,0,0,0},
				  				  {0,0,0,0,0,0},
				  				  {0,0,0,0,0,0}};
		
		gS.board = board0;
		gS.board2 = board20;
		
		Assert.assertArrayEquals(gS.boardState(gS.board, gS.board2), expectedOutput);
		
		int[][] board1 = {{1,1,1,0,0,0},
						  {0,2,2,0,0,0},
						  {0,0,3,0,0,0},
						  {0,0,0,0,0,0},
						  {0,0,0,0,0,0},
						  {0,0,0,0,0,0},
						  {0,0,0,0,0,0},
						  {0,0,0,0,0,0},
						  {0,0,0,0,0,0}};

		int[][] board21 = {{0,1,2,0,0,0},
						   {0,3,4,0,0,0},
						   {0,0,5,0,0,0},
						   {0,0,0,0,0,0},
						   {0,0,0,0,0,0},
						   {0,0,0,0,0,0},
						   {0,0,0,0,0,0},
						   {0,0,0,0,0,0},
						   {0,0,0,0,0,0}};

		int[][] expectedOutput2 = {{0,2,2,0,0,0},
		  		  				   {0,0,3,0,0,0},
		  		  				   {0,0,0,0,0,0},
		  		  				   {0,0,0,0,0,0},
		  		  				   {0,0,0,0,0,0},
		  		  				   {0,0,0,0,0,0},
		  		  				   {0,0,0,0,0,0},
		  		  				   {0,0,0,0,0,0},
		  		  				   {0,0,0,0,0,0}};

		gS.board = board1;
		gS.board2 = board21;

		Assert.assertArrayEquals(gS.boardState(gS.board, gS.board2), expectedOutput2);
		
		int[][] board2 = {{1,1,1,0,0,4},
				  		  {0,2,2,0,0,0},
				  		  {0,0,3,0,1,0},
				  		  {0,0,0,0,0,0},
				  		  {0,0,0,0,0,0},
				  		  {0,0,0,2,0,0},
				  		  {0,0,4,2,2,0},
				  		  {0,0,0,0,3,0},
				  		  {0,0,0,0,0,0}};

		int[][] board22 = {{0,1,2,0,0,12},
						   {0,3,4,0,0,0},
						   {0,0,5,0,6,0},
						   {0,0,0,0,0,0},
						   {0,0,0,0,0,0},
						   {0,0,0,7,0,0},
						   {0,0,8,9,10,0},
						   {0,0,0,0,11,0},
						   {0,0,0,0,0,0}};

		int[][] expectedOutput3 = {{0,2,2,0,1,4},
		  				   		   {0,0,3,0,3,0},
		  				   		   {0,0,4,0,0,0},
		  				   		   {0,0,0,0,0,0},
		  				   		   {0,0,0,0,0,0},
		  				   		   {0,0,0,0,0,0},
		  				   		   {0,0,0,0,0,0},
		  				   		   {0,0,0,0,0,0},
		  				   		   {0,0,0,0,0,0}};

		gS.board = board2;
		gS.board2 = board22;

		Assert.assertArrayEquals(gS.boardState(gS.board, gS.board2), expectedOutput3);
	}
}
