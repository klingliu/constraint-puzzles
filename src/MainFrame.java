import java.awt.*;
import java.io.FileNotFoundException;
import javax.swing.*;

public class MainFrame extends JFrame {

    public void setUpFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container pane = getContentPane();
        pane.setLayout(new FlowLayout());

        HeadingPanel panelTitle = new HeadingPanel("PUZZLES!");
        pane.add(panelTitle);

        ChooseButton choose = new ChooseButton("Choose a game", this);
        pane.add(choose);

        SwitchMenuListener sml = new SwitchMenuListener(choose);

        choose.addActionListener(sml);

        pack();
        setVisible(true);
        setPreferredSize(new Dimension(600,600));
        repaint();
    }
}
