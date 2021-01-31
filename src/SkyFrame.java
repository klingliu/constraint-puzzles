import java.awt.*;
import java.io.FileNotFoundException;
import javax.swing.*;

public class SkyFrame extends JFrame {
    private JLabel message;
    private JLabel errorMessage;
    private SkyButton[][] buttons;

    public void setUpFrame() throws FileNotFoundException {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container pane = getContentPane();
        pane.setLayout(new FlowLayout());

        Skyscraper sky = new Skyscraper(this);

        buttons = new SkyButton[5][5];

        HeadingPanel panelTitle = new HeadingPanel("Skyscraper");

        message = new JLabel("Play Skyscraper!");
        errorMessage = new JLabel(" ");

        // check button
        JButton check = new JButton("Check");
        check.addActionListener(sky);

        // show solution
        JButton show = new JButton("Show solution");
        Skyscraper defaultSky = new Skyscraper(this);
        Solver skySolver = new Solver(defaultSky);
        show.addActionListener(skySolver);

        // instructions button
        JButton instructions = new JButton("Instructions");
        InstructionsFrame instructionsListener = new InstructionsFrame("skyInstructions.txt");
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

        JPanel skyPanel = new JPanel();
        skyPanel.setPreferredSize(new Dimension(600,600));
        skyPanel.setLayout(new GridLayout(0,7));
        skyPanel.add(new SidePanel(" "));
        for (int i = 0; i < 5; i++)
            skyPanel.add(new SidePanel(Integer.toString(sky.getTopInstances()[i])));
        skyPanel.add(new SidePanel(" "));

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 7; j++) {
                if (j == 0)
                    skyPanel.add(new SidePanel(Integer.toString(sky.getLeftInstances()[i])));
                else if (j == 6)
                    skyPanel.add(new SidePanel(Integer.toString(sky.getRightInstances()[i])));
                else {
                    SkyButton button = new SkyButton(); // creates a button and draws the number
                    skyPanel.add(button);
                    button.setSpot(sky.getSpots()[i][j-1]);
                    buttons[i][j-1] = button;
                    if (button.getSpot().isPrefilled()) button.setEnabled(false);
                }

            }
        }
        skyPanel.add(new SidePanel(" "));
        for (int i = 0; i < 5; i++)
            skyPanel.add(new SidePanel(Integer.toString(sky.getBotInstances()[i])));
        skyPanel.add(new SidePanel(" "));

        pane.add(skyPanel);

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
        for (SkyButton[] button : buttons)
            for (SkyButton skyButton : button)
                skyButton.setEnabled(false);
    }

}
