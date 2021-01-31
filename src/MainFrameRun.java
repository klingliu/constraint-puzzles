import java.awt.*;
import java.io.FileNotFoundException;
import javax.swing.*;

public class MainFrameRun extends JFrame {

    public static void main(String[] args) {

        try {
            javax.swing.UIManager.setLookAndFeel(
                    new javax.swing.plaf.metal.MetalLookAndFeel());
        }
        catch(Exception e) {}

        MainFrame frame = new MainFrame();
        frame.setUpFrame();

        frame.pack();
        frame.setVisible(true);
        frame.setPreferredSize(new Dimension(600,600));
        frame.repaint();

    }


}
