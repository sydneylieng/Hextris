import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class startMenuView {
	
	JFrame startMenuFrame = new JFrame("Hextris");  				// Name of the window
    private JLabel backgroundImg = new JLabel("");	// Creates new object on the screen
    private JLabel rulesImg = new JLabel("");
	private JButton playButton= new JButton("");
	private JButton rulesButton= new JButton("");
	private JButton backButton= new JButton("");
	
	startMenuView(){		
	
		setFrame(startMenuFrame);
		playB(startMenuFrame);
		rulesB(startMenuFrame);
		setBackgroundStart(startMenuFrame);
	}
	
	public void setFrame(JFrame frame){	//setting the frame
		frame.setPreferredSize(new Dimension(1280, 720));	//set size of the game window
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.pack();	// Display the window
		frame.setVisible(true);		// Set visibility to be true
		frame.setResizable(false);	//window cannot be resized
	}
	
	private void setBackgroundStart(JFrame Frame){ //Start Menu Background
        backgroundImg.setBounds(0, 0, 1280, 720);	// Sets x,y,width,height of the object
        Image background = new ImageIcon(this.getClass().getResource("/title.png")).getImage();	// Upload picture called title
        backgroundImg.setIcon(new ImageIcon(background));	// Set the object to be the image
        Frame.getContentPane().add(backgroundImg);	// Adds background to the JFrame
	}
	
	private void playB(JFrame Frame){ // Play button
        playButton.setBounds(555, 350, 195, 76);
        Image pImg = new ImageIcon(this.getClass().getResource("/play.png")).getImage();
        playButton.setIcon(new ImageIcon(pImg));
        Frame.getContentPane().add(playButton);
        
	}
	
	private void rulesB(JFrame Frame){ //Rules button
        rulesButton.setBounds(555, 474, 195, 76);
        Image rImg = new ImageIcon(this.getClass().getResource("/rules.png")).getImage();
        rulesButton.setIcon(new ImageIcon(rImg));
        Frame.getContentPane().add(rulesButton);
	}
	
	void rulesBoard(JFrame Frame){
		
        backButton.setBounds(1050, 550, 195, 76);
        Image bImg = new ImageIcon(this.getClass().getResource("/back.png")).getImage();
        backButton.setIcon(new ImageIcon(bImg));
        Frame.getContentPane().add(backButton);
		
        rulesImg.setBounds(0, 0, 1280, 720);	// Sets x,y,width,height of the object
        ImageIcon rules = new ImageIcon(this.getClass().getResource("/rulesPage.gif"));	// Upload picture called rulesPage
        rulesImg.setIcon(rules);	// Set the object to be the image
        Frame.getContentPane().add(rulesImg);	// Adds background to the JFrame
        
        rulesImg.setVisible(true);
        
		backgroundImg.setVisible(false);
		playButton.setVisible(false);
		rulesButton.setVisible(false);

	}
	
	void back(JFrame Frame){

		//rulesImg.setVisible(false);
		Frame.remove(rulesImg);
		Frame.remove(backButton);
		
		backgroundImg.setVisible(true);
		playButton.setVisible(true);
		rulesButton.setVisible(true);
		
		//TODO add back button actions, and instructions here
	}
	
	// Get Functions
	JFrame getFrame(){ // Returns Frame
		return startMenuFrame;
	}
	
	void playButtonListener(ActionListener listenForClick){	// Event listener for exit button
		playButton.addActionListener(listenForClick);
	}
	
	void rulesButtonListener(ActionListener listenForClick){ // Event listener for p1Button	
		rulesButton.addActionListener(listenForClick);
	}
	
	void backButtonListener(ActionListener listenForClick){ // Event listener for p1Button	
		backButton.addActionListener(listenForClick);
	}
}
