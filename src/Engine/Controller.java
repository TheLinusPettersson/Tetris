package Engine;

import Graphics.Frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class Controller implements ActionListener, KeyListener{
    Model model;
    Frame frame;
    Timer timer;

    public Controller(int gameWidth, int gameHeight, int delay){
        // model init
        List<Tile> ms = ShapeFactory.generateShape(gameWidth/2 ,  - 2 * Tile.getTileSize());
        List<Tile> st = new ArrayList<>();
        this.model = new Model(gameWidth, gameHeight, ms, st);

        // frame init
        this.frame = new Frame(gameWidth, gameHeight);

        // controls init
        frame.addKeyListener(this);
        frame.setFocusable(true);

        // timer init
        timer = new Timer(delay, new TimeListener());
        timer.start();
    }

    private void updateView(){
        List<Tile> modelInfo = model.getTileInformation();
        List<Point> points = new ArrayList<>();
        List<Color> color = new ArrayList<>();
        for (Tile t : modelInfo){
            points.add(t.getLocation());
            color.add(t.getColor());
        }
        frame.actOnPositionChange(points, color);

    }
    public class TimeListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            model.moveDown();
            updateView();

        }
    }
    // *** Controls ***
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            model.moveRight();
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            model.moveLeft();
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            model.rotateClockwise();
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            model.moveDown();
        }
        updateView();
    }
    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void actionPerformed(ActionEvent e) {}



}
