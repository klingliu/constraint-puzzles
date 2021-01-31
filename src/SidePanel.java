import javax.swing.JPanel;
import java.awt.*;

public class SidePanel extends JPanel {
    private String num;

    public SidePanel(String num) {
        // set size, otherwise Java will assume 0 x 0 and component may disappear
        setPreferredSize(new Dimension(200, 200));
        this.num = num;
    }

    // This method is called whenever java wants to draw the panel; Change this to change the appearance of the panel
    public void paintComponent(Graphics g) {
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.PLAIN, 20));
        g.drawString(num,35,50);
    }
}
