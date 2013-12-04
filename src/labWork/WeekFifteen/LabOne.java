/*
 * Sae Hun Kim
 * CS 112
 * lab 1
 */

package labWork.WeekFifteen;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class LabOne extends JFrame {
	public LabOne() {
		setTitle("Lab One");
		setSize(300, 200);
		setLocation(10, 200);

		addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent e) {
				System.out.println("HFOAIWEJMOKAWMEOR");
			}
		});
	}

	public static void main(String[] args) {
		JFrame f = new LabOne();
		f.show();
	}
}
