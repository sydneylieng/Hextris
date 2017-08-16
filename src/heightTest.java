import static org.junit.Assert.*;

import org.junit.Test;

public class heightTest {
	
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
		
		gS.board = board0;
		
		assertEquals(gS.checkHeight(2), 0);
		
		int[][] board1 = {{1,0,3,2,0,0},
						  {2,0,4,1,0,0},
						  {2,0,2,0,0,0},
		 				  {3,0,2,0,0,0},
						  {4,0,0,0,0,0},
						  {1,0,0,0,0,0},
						  {0,0,0,0,0,0},
						  {0,0,0,0,0,0},
						  {0,0,0,0,0,0}};

		gS.board = board1;

		assertEquals(gS.checkHeight(0), 6);
		
		int[][] board2 = {{1,2,3,2,2,3},
						  {2,4,4,1,1,3},
						  {2,3,2,4,2,1},
						  {3,1,2,4,1,1},
						  {4,2,0,2,1,0},
						  {1,0,0,1,0,0},
						  {0,0,0,0,0,0},
						  {0,0,0,0,0,0},
						  {0,0,0,0,0,0}};

		gS.board = board2;

		assertEquals(gS.checkHeight(5), 4);
	}

}
