import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeButton extends JButton implements ActionListener {
    private JFrame frame;
    public HomeButton(String name, JFrame frame) {
        super(name);
        this.frame = frame;
        this.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        frame.dispose();
        MainFrame mainFrame = new MainFrame();
        mainFrame.setUpFrame();
    }
}
