import java.awt.BorderLayout;
import java.awt.Dimension;//add imports to create frames and images
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class hextrisView{
	
	boolean pause = false;
	
	graphicSettings gS = new graphicSettings();
	shapes s = new shapes();
	blocks b = new blocks();
	
	JFrame newGame = new JFrame("Hextris");
	JPanel panel = new JPanel(new BorderLayout(1280, 720));
	JLabel label = new JLabel();
	JTextArea listen = new JTextArea();
	
	public hextrisView(){
		addScoreText(panel);
		addShapes(panel);
		setFrame(newGame, panel);
		addListeners(newGame);
	}
	
	public void setFrame(JFrame frame, JPanel panel){	//setting the frame
		frame.setPreferredSize(new Dimension(1280, 720));	//set size of the game window
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.pack();	// Display the window
		frame.setResizable(false);	//window cannot be resized
		frame.getContentPane().add(panel); // Add the panel to the JFrame
		frame.setVisible(true); // Set visibility to be true
	}
	
	public void addGameOver(JPanel panel){
		
	}
	
	public void addScoreText(JPanel panel){
		gS.scoreText.setEditable(false);
		panel.add(label);
	    panel.add(gS.scoreText);
	    panel.add(gS.gameOver);
	    //panel.add(listen);
	}
	
	public void addShapes(JPanel panel){ //add shapes
		gS.t.start();
		s.shapes(); //create the hexagons
		b.blocks(); //create blocks
		gS.addHex(s.bgHex, s.hex);
		gS.addShapes(b.Blocks, b.movingBlocks, b.color, b.sideHeight); //add graphic properites to the shapes
		panel.add(gS); //add the shapes to the frame
	}
	
	public void addListeners(JFrame frame){ //listens for left or right action
		gS.gameOver.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				frame.dispose();
				startMenuView smV = new startMenuView();
				startMenuModel smM = new startMenuModel();
				startMenuController smC = new startMenuController(smV, smM);
			}
			
		});
		
		gS.scoreText.addKeyListener(new KeyListener() {

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode()==40){
					gS.increaseSpeed();
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==80){
					gS.pause = !gS.pause;
				}
				
				
				
				if(gS.pause == false){ //make sure the hex isn't already rotating
					
					if(e.getKeyCode()==40){
						gS.speed = 12;
					}
					
					if(gS.x1 == 0){
						if(e.getKeyCode()==37){ //if left is pushed
							//System.out.println("left");
							gS.left = true; //choose left
							gS.turn = true;
						}
						else if(e.getKeyCode()==39){ //if right is pushed
							//System.out.println("right");
							gS.left = false; //choose right
							gS.turn = true;
						}
					}
				}
			}
		});
	}
}
