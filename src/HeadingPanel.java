import javax.swing.JPanel;
import java.awt.*;

public class HeadingPanel extends JPanel {

	private String heading;

	public HeadingPanel(String heading) {
		// set size, otherwise Java will assume 0 x 0 and component may disappear
		setPreferredSize(new Dimension(200, 400));
		setLayout(new GridLayout(7, 1));
		this.heading = heading;
	}

	// This method is called whenever java wants to draw the panel; Change this to change the appearance of the panel
	public void paintComponent(Graphics g) {
		g.setColor(Color.BLACK);
		g.setFont(new Font("TimesRoman", Font.BOLD, 35));
		g.drawString(heading,10,40);
	}

}

