import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InstructionsFrame extends JFrame implements ActionListener {
    private String instructions;

    public InstructionsFrame(String fileName) throws FileNotFoundException {
        Scanner scan = new java.util.Scanner(new java.io.FileReader(fileName));
        instructions = "";
        while (scan.hasNextLine()) {
            instructions = instructions + "\n" + scan.nextLine();
        }
    }

    public void actionPerformed(ActionEvent e) {
        createFrame();
    }

    public void createFrame() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JTextArea textArea = new JTextArea(instructions);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        textArea.setFont(new Font("Verdana", Font.PLAIN, 16));
        JScrollPane scroller = new JScrollPane(textArea);
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        frame.add(scroller);
        frame.pack();
        frame.setPreferredSize(new Dimension(600,600));
        frame.setVisible(true);
        frame.repaint();
    }
}
