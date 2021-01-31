import java.awt.*;

public class HitoriSolverPanel extends SolverPanel {

    private final String NUM;
    private final int VALUE;

    public HitoriSolverPanel(int value, int num) {
        this.NUM = Integer.toString(num);
        this.VALUE = value;
        setPreferredSize(new Dimension(200, 200));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Color c;
        if (VALUE % 2 == 0) c = Color.WHITE;
        else c = Color.BLACK;
        g.setColor(c);
        g.fillRect(0,0,200,200);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 40));
        g.drawString(NUM,50,75);
    }
}
