import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class SwitchMenuListener implements ActionListener {
    private ChooseButton button;
    JPopupMenu menu;

    public SwitchMenuListener(ChooseButton button) {
        this.button = button;

        // create popup menu
        menu = new JPopupMenu("Menu");

        // menu items
        JMenuItem game1 = new JMenuItem("Hitori");
        game1.addActionListener(button);
        menu.add(game1);
        JMenuItem game2 = new JMenuItem("Kakurasu");
        game2.addActionListener(button);
        menu.add(game2);
        JMenuItem game3 = new JMenuItem("Skyscraper");
        game3.addActionListener(button);
        menu.add(game3);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        menu.show(button,button.getWidth()/2,button.getHeight()/2);
    }
}
