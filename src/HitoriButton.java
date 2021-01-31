import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.JButton;

public class HitoriButton extends JButton implements ActionListener {

	private Color c = Color.WHITE;
	private int clicks;
	private final String gridNum;
	private HitoriSpot spot;
	private boolean black = false;
	
	public HitoriButton(int gridNum) {
		clicks = 0;
		this.gridNum = Integer.toString(gridNum);
		this.addActionListener(this);
	}

	public void setSpot(HitoriSpot spot) { this.spot = spot; }
	public HitoriSpot getSpot() { return this.spot; }

	// The method paintComponent(Graphics g) is called when java needs to draw the component
	public void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    if (black) g.setColor(Color.BLACK);
		else g.setColor(c);
		g.fillRect(0,0,200,200);
		g.setColor(Color.BLACK);
		g.setFont(new Font("Arial", Font.BOLD, 40));
		g.drawString(gridNum,50,75);
		
	}

	public void beenHere() {
		c = Color.BLACK;
	}
	public void beenHereAgain() {
		c = Color.WHITE;
	}
	
	public void actionPerformed(ActionEvent e) {
		clicks++;
		if (clicks % 2 == 1) {
			this.spot.setValue(1);
			beenHere();
		}
		else {
			this.spot.setValue(0);
			beenHereAgain();
		}
	}

	public void setButtonBlack() {
		this.black = true;
	}


	
}
