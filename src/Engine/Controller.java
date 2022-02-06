package Engine;

import Graphics.View;

import java.awt.event.*;
import java.util.List;

import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;

//TODO doesn't get focused for some fk reason
public class Controller implements ActionListener, KeyListener{
    Model model;
    View view;

    public Controller(Model m, View v){
        this.model = m;
        this.view = v;
        view.addKeyListener(this);
        view.setFocusable(true);
        m.start();
    }
    public void newMovingShape(){
        List<Tile> ts = ShapeFactory.generateShape(250 ,-100);
        model.setMovingShape(ts);
        view.setMovingShape(ts);

    }

    @Override
    public void keyTyped(KeyEvent e) {

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
            //model.moveUp();
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            model.moveDown();
        }
        view.actOnPositionChange();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
