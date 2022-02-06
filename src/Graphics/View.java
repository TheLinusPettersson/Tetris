package Graphics;


import Engine.Tile;
import Engine.TileObserver;

import javax.swing.JFrame;
import java.awt.*;
import java.util.List;

public class View extends JFrame implements TileObserver {
    private int x;
    private int y;
    JFrame frame = new JFrame(); //Create the JFrame and give it a title
    AnimatedView animatedView;

    public View(int x, int y) {
        this.x = x;
        this.y = y;
        animatedView = new AnimatedView(x, y);
        initComponents("T E T R I S");
    }



    public void initComponents(String title) {
        this.add(animatedView);
        this.setTitle(title);
        this.setPreferredSize(new Dimension(x, y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
    }

    @Override
    public void actOnPositionChange() {
        animatedView.repaint();
    }
    public void setMovingShape(List<Tile> s){
        animatedView.setMovingShape(s);
    }
}
