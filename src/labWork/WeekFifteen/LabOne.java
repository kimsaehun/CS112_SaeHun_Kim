/*
 * Sae Hun Kim
 * CS 112
 * lab 1
 */

package labWork.WeekFifteen;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import javax.swing.JFrame;

public class LabOne extends JFrame {
	public LabOne() {
		setTitle("Lab One");
		setSize(300, 200);
		setLocation(10, 200);

		addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent e) {
				System.out.println("HFOAIWEJMOKAWMEOR   opened");
			}

			public void windowClosing(WindowEvent e) {
				System.out.println("HFOAIWEJMOKAWMEOR   closing");
				dispose();
			}

			public void windowClosed(WindowEvent e) {
				System.out.println("HFOAIWEJMOKAWMEOR   closed");
				System.exit(0);
			}

			public void windowIconified(WindowEvent e) {
				System.out.println("YOU CANT SEEE MEEEEE       windowIconify");
			}

			public void windowDeiconified(WindowEvent e) {
				System.out.println("YOU SEE MEE NOW      windowDeiconified");
			}
		});
	}

	public static void main(String[] args) {
		JFrame f = new LabOne();
		f.show();
	}
}
