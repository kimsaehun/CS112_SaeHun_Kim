/*
 * Sae Hun Kim
 * CS 112 week 15
 * lab 3
 */

package labWork.WeekFifteen;

import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class LabThreeFrame extends JFrame {
	public LabThreeFrame(String s) {
		// Frame Parameters
		setTitle(s);
		setSize(300, 200); // default size is 0,0
		setLocation(10, 200); // default is 0,0 (top left corner)
		// Window Listeners
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			} // windowClosing
		});
		Container contentPane = getContentPane();
		// contentPane.add(new FramePanelButton());
		contentPane.add(new LabThreeButton());
	}

	public static void main(String[] args) {
		JFrame f = new LabThreeFrame("Lab 3");
		f.show();
	}
}