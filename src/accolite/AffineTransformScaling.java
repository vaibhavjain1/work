package accolite;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
//  www  .j av  a 2s. co m
import javax.swing.JComponent;
import javax.swing.JFrame;

public class AffineTransformScaling {
  public static void main(String[] args) {
    JFrame jf = new JFrame("Demo");
    Container cp = jf.getContentPane();
    MyCanvas tl = new MyCanvas();
    cp.add(tl);
    jf.setSize(300, 200);
    jf.setVisible(true);
  }
}

class MyCanvas extends JComponent {

  public void paint(Graphics g) {
    Shape shape = new Rectangle2D.Float(100, 50, 80, 80);
    
    Graphics2D g2 = (Graphics2D) g;


    AffineTransform at = new AffineTransform();
    at.scale(0.8,0.2);
    
    g2.setTransform(at);
    //g2.draw(shape);
    Toolkit.getDefaultToolkit().getScreenResolution();
    Toolkit.getDefaultToolkit().getScreenSize();
    System.out.println(Toolkit.getDefaultToolkit().getScreenSize().getSize());
    System.out.println(g2.getTransform().getScaleX());
    java.awt.Toolkit.getDefaultToolkit().getScreenResolution();
    
    GraphicsConfiguration asdf = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();

    AffineTransform asfd2 = asdf.getDefaultTransform();

    double scaleX = asfd2.getScaleX();
    double scaleY = asfd2.getScaleY();
    System.out.println(scaleX + " "+ scaleY);
  }
}