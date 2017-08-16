import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;


public class startMenuController {
	private startMenuView smV;
	private startMenuModel smM;
	
	startMenuController(startMenuView smV, startMenuModel smM){
		this.smV = smV;
		this.smM = smM;
		
		this.smV.rulesButtonListener(new listenForRules());
		this.smV.playButtonListener(new listenForPlay());
		this.smV.backButtonListener(new listenForBack());
	}
	
	// Action Listener for Rules Button
	class listenForRules implements ActionListener{
		private JFrame theFrame;
		public void actionPerformed(ActionEvent e) {
			try{
				theFrame = smV.getFrame();
				smV.rulesBoard(theFrame);
				
			}
			catch(Exception ex){                 
				ex.printStackTrace();
			}
		}
	}
	
	// Action Listener for Play Button
	class listenForPlay implements ActionListener{
		private JFrame theFrame;
		public void actionPerformed(ActionEvent e) {
			try{
				theFrame = smV.getFrame();
				smM.closeFrame(theFrame);	// Closes current frame
				
				// Creates the game board
				hextrisView hV = new hextrisView();
				hextrisModel hM = new hextrisModel();
				hextrisController hC = new hextrisController(hM, hV);	
			}
			catch(Exception ex){                 
				ex.printStackTrace();
			}
		}
	}
	
	// Action Listener for Rules Button
	class listenForBack implements ActionListener{
		private JFrame theFrame;
		public void actionPerformed(ActionEvent e) {
			try{
				theFrame = smV.getFrame();
				smV.back(theFrame);
				
				//TODO Add the back functions
			}
			catch(Exception ex){                 
				ex.printStackTrace();
			}
		}
	}
	
}
