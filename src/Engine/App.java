package Engine;
import java.awt.*;
import Graphics.View;
public class App {
    public static void main(String[] args) {
        int x = 500, y = 800;
        View view = new View(x, y);
        Model model = new Model(view, x , y);
        Controller c = new Controller(model, view);
        c.newMovingShape();


        // Make the frame pack all it's components by respecting the sizes if possible.
        view.pack();
        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        view.setLocation(dim.width / 2 - view.getSize().width / 2, dim.height / 2 - view.getSize().height / 2);
        // Make the frame visible
        view.setVisible(true);
        // Make sure the frame exits when "x" is pressed
    }
}
