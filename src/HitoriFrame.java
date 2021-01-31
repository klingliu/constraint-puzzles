import java.awt.*;
import java.io.FileNotFoundException;
import javax.swing.*;

public class HitoriFrame extends JFrame {

	private JLabel message;
	private JLabel errorMessage;
	private int buttonCount;
	private HitoriButton[][] buttons;
	private int puzzleSize;

	public void setUpFrame() throws FileNotFoundException {

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit when window is closed

		Container pane = getContentPane();
		pane.setLayout(new FlowLayout());

		Hitori hitori = new Hitori(this, false);
		buttonCount = hitori.getGridSize();

		buttons = new HitoriButton[5][5];
		HeadingPanel panelTitle = new HeadingPanel("Hitori");
		message = new JLabel("Play Hitori!");
		errorMessage = new JLabel(" ");

		// check - inside the puzzle creation classes
		JButton check = new JButton("Check");
		check.addActionListener(hitori);

		// show solution - solver
		JButton show = new JButton("Show solution");
		Hitori defaultHitori = new Hitori(this, true);
		Solver hitoriSolver = new Solver(defaultHitori);
		show.addActionListener(hitoriSolver);

		// instructions - instructions listener; probably need to add a parameter for file name later for reusability
		JButton instructions = new JButton("Instructions");
		InstructionsFrame instructionsListener = new InstructionsFrame("hitoriInstructions.txt");
		instructions.addActionListener(instructionsListener);

		// home button
		HomeButton home = new HomeButton("Home", this);


		/*ImageIcon x = new ImageIcon(("book.gif"));
		JLabel book = new JLabel(x);*/

		// adding buttons to buttons panel
		panelTitle.add(new JLabel(""));
		//panelTitle.add(book);
		panelTitle.add(check);
		panelTitle.add(show);
		panelTitle.add(instructions);
		panelTitle.add(home);
		panelTitle.add(message);
		panelTitle.add(errorMessage);
		pane.add(panelTitle); // adding other buttons panel to main pane


		JPanel hitoriPanel = new JPanel();
		hitoriPanel.setLayout(new GridLayout(5,5));
		hitoriPanel.setPreferredSize(new Dimension(600, 600));

		for (int i = 0; i < buttons.length; i++) {
			for (int j = 0; j < buttons[i].length; j++) {
				HitoriButton button = new HitoriButton(hitori.getPuzzleGrid()[i][j]); // creates a button and draws the number
				hitoriPanel.add(button);
				button.setSpot(hitori.getSpots()[i][j]);
				buttons[i][j] = button;
			}
		}
		pane.add(hitoriPanel);

		pack();
		setVisible(true);
		setPreferredSize(new Dimension(600,600));
		repaint();



	}

	public JButton[][] getButtons() { return buttons; }

	private int count = 0;
	public void setMessage(String message1) {
		count++;
		message.setText("try again " + "x"+count);
		errorMessage.setText(message1);
	}
	public void setDoneMessage(String message1) {
		message.setText(message1);
		errorMessage.setText(" ");
		for (HitoriButton[] button : buttons)
			for (HitoriButton hitoriButton : button)
				hitoriButton.setEnabled(false);
	}
}
