package pack;
import javax.swing.JFrame;

//import javax.swing.JFrame;


public class ProgramMain {
	

	/** Creates and Presents the Program GUI */
	public static void main(String[] args) {
		
		System.out.println(" >> ProgramWindowMain: START");
		
		//C:\LAB-2021\ECLIPSE\Eclipse-Workspace\ask1\Given_Text_File.txt//
		
		// Create and Show a window
		final MyFrame frame = new MyFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		frame.setVisible(true);
		
		System.out.println(" >> ProgramWindowMain: END");	}

}