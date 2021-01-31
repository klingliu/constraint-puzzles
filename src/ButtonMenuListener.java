import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class ButtonMenuListener implements ActionListener {
    private SkyButton button;
    JPopupMenu menu;

    public ButtonMenuListener(SkyButton button) {
        this.button = button;

        // create popup menu
        menu = new JPopupMenu("Menu");

        // menu items
        JMenuItem val0 = new JMenuItem("blank");
        val0.addActionListener(button);
        menu.add(val0);
        JMenuItem val1 = new JMenuItem("1");
        val1.addActionListener(button);
        menu.add(val1);
        JMenuItem val2 = new JMenuItem("2");
        val2.addActionListener(button);
        menu.add(val2);
        JMenuItem val3 = new JMenuItem("3");
        val3.addActionListener(button);
        menu.add(val3);
        JMenuItem val4 = new JMenuItem("4");
        val4.addActionListener(button);
        menu.add(val4);
        JMenuItem val5 = new JMenuItem("5");
        val5.addActionListener(button);
        menu.add(val5);
    }

    public void actionPerformed(ActionEvent e) {
        menu.show(button,button.getWidth()/2,button.getHeight()/2);
    }
}
