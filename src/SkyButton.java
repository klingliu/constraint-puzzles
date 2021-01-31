import java.awt.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class SkyButton extends JButton implements ActionListener {
    private SkySpot spot;
    JPopupMenu menu;

    public SkyButton() {
        ButtonMenuListener m = new ButtonMenuListener(this);
        this.addActionListener(m);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.fillRect(0,0,200,200);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 40));
        if (spot.getValue() == 0) g.drawString(" ",30,55);
        else g.drawString(Integer.toString(spot.getValue()),30,55);
    }

    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if (action.equals("blank")) spot.setValue(0);
        if (action.equals("1")) spot.setValue(1);
        if (action.equals("2")) spot.setValue(2);
        if (action.equals("3")) spot.setValue(3);
        if (action.equals("4")) spot.setValue(4);
        if (action.equals("5")) spot.setValue(5);
    }

    public void setSpot(SkySpot spot) { this.spot = spot; }
    public SkySpot getSpot() { return this.spot; }

}


