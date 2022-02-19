package Graphics;

import java.awt.Font;
import javax.swing.*;
import java.awt.*;

public class Scoreboard extends JLabel {
    String text = " ";


    public Scoreboard(int width, int height) {
        // text
        this.setText(text);
        this.setFont(new Font("Arial", Font.BOLD, height));
        this.setForeground(new Color(188, 174, 215));

        // visuals
        this.setHorizontalAlignment(SwingConstants.RIGHT);
        this.setOpaque(false);
        this.setVisible(true);
    }

    public void changeScore(int score) {
        this.setText(text + score + text);
    }
}
