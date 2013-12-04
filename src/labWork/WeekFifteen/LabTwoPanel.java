/*
 * Sae Hun Kim
 * Week 15 lab 2
 */

package labWork.WeekFifteen;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class LabTwoPanel extends JPanel {
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Font f = new Font("SansSerif", Font.BOLD, 14);
		Font fi = new Font("SansSerif", Font.BOLD + Font.ITALIC, 14);
		FontMetrics fm = g.getFontMetrics(f);
		FontMetrics fim = g.getFontMetrics(fi);
		int cx = 75;
		int cy = 100;
		g.setFont(f);
		g.drawString("Hello, ", cx, cy);
		cx += fm.stringWidth("Hello, ");
		g.setFont(fi);
		g.drawString("Frame!", cx, cy);
		g.draw3DRect(20, 20, 15, 24, true);
		g.drawOval(0, 120, 18, 23);
		g.setColor(Color.BLUE);
		g.fill3DRect(36, 45, 15, 24, true);
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, 10, 123);
		g.setColor(Color.CYAN);
		int[] r = { 20, 30, 40, 50, 80 };
		int[] r2 = { 10, 30, 23, 50, 0 };
		g.fillPolygon(r, r2, 5);
	} // paintComponent

	// =============================================
	// /////////// main ////////////////////////////

	public static void main(String[] args) {
		JFrame f = new LabTwoFrame("My tFrame");
		f.show();
	}
}
