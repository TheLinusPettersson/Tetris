package Graphics;


import Engine.Tile;
import Engine.TileObserver;

import javax.swing.JFrame;
import java.awt.*;
import java.util.List;

public class View extends JFrame {
    private int x;
    private int y;
    JFrame frame = new JFrame(); //Create the JFrame and give it a title
    AnimatedView animatedView;

    public View(int x, int y, List<Tile> ms, List<Tile> st) {
        this.x = x + x/4;
        this.y = y + x/6;
        animatedView = new AnimatedView(x, y, ms, st);
        initComponents("T E T R I S");
    }


    public void initComponents(String title) {
        this.add(animatedView);

        this.setTitle(title);

        this.setPreferredSize(new Dimension(x, y));

        this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        // Get the computer screen resolution
        Dimension dim2 = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim2.width / 2 - this.getSize().width / 2, dim2.height / 2 - this.getSize().height / 2);
        // Make the frame visible
        this.setVisible(true);
       // Closes application when "X" is pressed
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.pack();
    }

    public void actOnPositionChange(List<Point> p, List<Color> c) {
        animatedView.updateView(p,c);
        animatedView.repaint();
    }
}
