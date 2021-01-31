import java.awt.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.io.FileNotFoundException;
import javax.swing.*;

public class ChooseButton extends JButton implements ActionListener {
    JFrame frame;

    public ChooseButton(String name, JFrame frame) {
        super(name);
        this.frame = frame;
    }

    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if (action.equals("Hitori")) {
            frame.dispose();
            HitoriFrame newFrame = new HitoriFrame();
            try {
                newFrame.setUpFrame();
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        }
        if (action.equals("Kakurasu")) {
            frame.dispose();
            KakurasuFrame newFrame = new KakurasuFrame();
            try {
                newFrame.setUpFrame();
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        }
        if (action.equals("Skyscraper")) {
            frame.dispose();
            SkyFrame newFrame = new SkyFrame();
            try {
                newFrame.setUpFrame();
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        }
    }
}
