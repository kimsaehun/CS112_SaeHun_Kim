/*
 * Sae Hun Kim
 * Week 15
 * cs 112
 * lab 2
 */

package labWork.WeekFifteen;

import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class LabTwoFrame extends JFrame {
	public LabTwoFrame(String t) {
		setTitle(t);
		setSize(300, 200); // default size is 0,0
		setLocation(10, 200); // default is 0,0 (top left corner)
		// Window Listeners
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			} // windowClosing
		}); // addWindowLister
		// Add Panels
		Container contentPane = getContentPane();
		contentPane.add(new LabTwoPanel());
	}
}
