package Graphics;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Frame extends JFrame {
    private int gameWidth;
    private int gameHeight;
    private int horizontalBoarder;
    private int verticalBorder;
    AnimatedView animatedView;
    Scoreboard scoreboard;
    //TODO: resizing
    public Frame(int x, int y) {

        // gameSize and boarders
        this.gameWidth = x;
        this.gameHeight = y;
        this.horizontalBoarder = gameWidth/8;
        this.verticalBorder = gameWidth/5;

        //init components
        animatedView = new AnimatedView(x, y);
        scoreboard = new Scoreboard(gameWidth, verticalBorder/2);
        initComponents("T E T R I S");
    }


    public void initComponents(String title) {
        // TODO FIX

        // *** Frame design ***
        this.getContentPane().setBackground(new Color(86,85,211));
        this.setTitle(title);
        this.setVisible(true);

        // size and behaviour
        this.setPreferredSize(new Dimension(gameWidth + 2 * horizontalBoarder, gameHeight + verticalBorder));
        Dimension dim2 = Toolkit.getDefaultToolkit().getScreenSize(); //screen resolution
        this.setLocation(dim2.width / 2 - this.getSize().width / 2, dim2.height / 2 - this.getSize().height / 2);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);


        // *** Layout ***
        this.setLayout(null);
        JLayeredPane jlp = new JLayeredPane();
        jlp.setBounds(0,0, gameWidth + 2 * horizontalBoarder, gameHeight + verticalBorder);
        this.add(jlp);

        // scoreboard
        jlp.add(scoreboard, JLayeredPane.DRAG_LAYER);
        scoreboard.setBounds(gameWidth /8,0, gameWidth, verticalBorder/2);
        scoreboard.setVisible(true);

        // animatedView
        jlp.add(animatedView, JLayeredPane.PALETTE_LAYER);
        animatedView.setBounds(gameWidth /8,0, gameWidth, gameHeight);
        animatedView.setPreferredSize(new Dimension(gameWidth, gameHeight));
        this.pack();

    }

    public void updateScore(int score){scoreboard.changeScore(score);}
    public void actOnPositionChange(List<Point> p, List<Color> c) {
        animatedView.updateView(p,c);
    }
}
