package Engine;

import Graphics.AnimatedView;
import Graphics.View;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Model {
    private List<TileObserver> observers = new ArrayList();
    private List<Tile> movingShape = new ArrayList<>();
    private List<TileShape> ls = new ArrayList<>();
    private Timer timer;


    public Model(View frame, int x, int y){
        timer = new Timer(1000, new TimeListener());
        observers.add(frame);


    }
    public void start(){
        timer.start();
    }

    //TODO defensive copy
    public void setMovingShape(List<Tile> s){
        this.movingShape = s;
    }

    //TODO REMOVE

    public void moveRight(){
        movingShape.forEach(Tile -> Tile.moveRight());
    }
    public void moveLeft(){
        movingShape.forEach(Tile -> Tile.moveLeft());
    }
    public void moveUp(){
        movingShape.forEach(Tile -> Tile.moveUp());
    }

    //should go faster down. increase gravity?
    public void moveDown(){
        movingShape.forEach(Tile -> Tile.moveDown());
    }

    public void updateObservers() {
        for (TileObserver to : observers)
            to.actOnPositionChange();

    }


    //TODO change delay so you can go faster
    //TODO FIXA FUNKAR INTE
    public class TimeListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            updateObservers();
            gravity();
            System.out.println(movingShape.get(0).getLocation());
        }
    }
    private void gravity(){
        movingShape.forEach(Tile -> moveDown());
    }




}
