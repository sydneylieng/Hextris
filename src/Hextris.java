import java.awt.EventQueue;

public class Hextris {
	
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable() {
			public void run(){
				try{
					// Connects the Controller to the View and Model
					startMenuView smV = new startMenuView();
					startMenuModel smM = new startMenuModel();
					startMenuController smC = new startMenuController(smV, smM);
				}
				catch (Exception e){
					e.printStackTrace();
				}
			}
		});
	}
}