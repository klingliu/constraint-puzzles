import java.awt.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.JButton;

public class KakurasuButton extends JButton implements ActionListener {
    private Color c = Color.WHITE;
    private int clicks;
    private KakurasuSpot spot;
    private boolean black = false;

    public KakurasuButton() {
        clicks = 0;
        this.addActionListener(this);
    }

    public void setSpot(KakurasuSpot spot) { this.spot = spot; }
    public KakurasuSpot getSpot() { return this.spot; }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (black) g.setColor(Color.BLACK);
        else g.setColor(c);
        g.fillRect(0,0,200,200);
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
