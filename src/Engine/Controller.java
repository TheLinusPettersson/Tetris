package Engine;

import Graphics.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

//TODO doesn't get focused for some fk reason
public class Controller implements ActionListener, KeyListener{
    Model model;
    View view;
    Timer timer;
    public Controller(int x, int y, int delay){

        List<Tile> ms = ShapeFactory.generateShape(x/2 ,  - 2 * Tile.getTileSize());
        List<Tile> st = new ArrayList<>();

        this.model = new Model(x, y, ms, st);
        this.view = new View(x, y, ms , st);

        view.addKeyListener(this);
        view.setFocusable(true);

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
        view.actOnPositionChange(points, color);

    }
    public class TimeListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            model.moveDown();
            updateView();

        }
    }

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
