package Graphics;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Frame extends JFrame {
    private int x;
    private int y;
    JFrame frame = new JFrame(); //Create the JFrame and give it a title
    AnimatedView animatedView;

    public Frame(int x, int y) {
        //  adding boarders
        //TODO: make it so that border sizes stays equal
        this.x = x + x/4;
        this.y = y + x/6;

        //init
        animatedView = new AnimatedView(x, y);
        initComponents("T E T R I S");
    }


    public void initComponents(String title) {
        //components
        this.add(animatedView);

        // design
        this.getContentPane().setBackground(new Color(86,85,211));
        this.setTitle(title);

        // size and behaviour
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 0));
        this.setPreferredSize(new Dimension(x, y));
        Dimension dim2 = Toolkit.getDefaultToolkit().getScreenSize(); //screen resolution
        this.setLocation(dim2.width / 2 - this.getSize().width / 2, dim2.height / 2 - this.getSize().height / 2);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
    }

    public void actOnPositionChange(List<Point> p, List<Color> c) {
        animatedView.updateView(p,c);
    }
}
