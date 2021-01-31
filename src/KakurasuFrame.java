import java.awt.*;
import java.io.FileNotFoundException;
import javax.swing.*;

public class KakurasuFrame extends JFrame {

    private JLabel message;
    private JLabel errorMessage;
    private KakurasuButton[][] buttons;

    public void setUpFrame() throws FileNotFoundException {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container pane = getContentPane();
        pane.setLayout(new FlowLayout());

        Kakurasu kakurasu = new Kakurasu(this, false);

        buttons = new KakurasuButton[5][5];

        HeadingPanel panelTitle = new HeadingPanel("Kakurasu");

        message = new JLabel("Play Kakurasu!");
        errorMessage = new JLabel(" ");

        // check button
        JButton check = new JButton("Check");
        check.addActionListener(kakurasu);

        // show solution
        JButton show = new JButton("Show solution");
        Kakurasu defaultKakurasu = new Kakurasu(this, true);
        Solver kakurasuSolver = new Solver(defaultKakurasu);
        show.addActionListener(kakurasuSolver);

        // instructions button
        JButton instructions = new JButton("Instructions");
        InstructionsFrame instructionsListener = new InstructionsFrame("kakurasuInstructions.txt");
        instructions.addActionListener(instructionsListener);

        // home button
        HomeButton home = new HomeButton("Home", this);

        panelTitle.add(new JLabel(""));
        panelTitle.add(check);
        panelTitle.add(show);
        panelTitle.add(instructions);
        panelTitle.add(home);
        panelTitle.add(message);
        panelTitle.add(errorMessage);
        pane.add(panelTitle);

        JPanel kakurasuPanel = new JPanel();
        kakurasuPanel.setPreferredSize(new Dimension(600,600));
        kakurasuPanel.setLayout(new GridLayout(0,7));
        kakurasuPanel.add(new SidePanel(" "));
        for (int i = 0; i < 5; i++)
            kakurasuPanel.add(new SidePanel(Integer.toString(i+1)));
        kakurasuPanel.add(new SidePanel(" "));

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 7; j++) {
                if (j == 0)
                    kakurasuPanel.add(new SidePanel(Integer.toString(i+1)));
                else if (j == 6)
                    kakurasuPanel.add(new SidePanel(Integer.toString(kakurasu.getRowInstances()[i])));
                else {
                    KakurasuButton button = new KakurasuButton(); // creates a button and draws the number
                    kakurasuPanel.add(button);
                    button.setSpot(kakurasu.getSpots()[i][j-1]);
                    buttons[i][j-1] = button;
                }

            }
        }
        kakurasuPanel.add(new SidePanel(" "));
        for (int i = 0; i < 5; i++)
            kakurasuPanel.add(new SidePanel(Integer.toString(kakurasu.getColInstances()[i])));
        kakurasuPanel.add(new SidePanel(" "));

        pane.add(kakurasuPanel);

        pack();
        setVisible(true);
        setPreferredSize(new Dimension(600,600));
        repaint();

    }

    private int count = 0;
    public void setMessage(String message1) {
        count++;
        message.setText("try again " + "x"+count);
        errorMessage.setText(message1);
    }
    public void setDoneMessage(String message1) {
        message.setText(message1);
        errorMessage.setText(" ");
        for (KakurasuButton[] button : buttons)
            for (KakurasuButton kakurasuButton : button)
                kakurasuButton.setEnabled(false);
    }
}
