import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.*;
import java.util.*;
public class Fireworks extends JPanel implements MouseListener, ActionListener 
{
    static JFrame f = new JFrame("Fireworks");
    int x = 0, y = 0;
    static int fwidth = 1000, fheight = 700;
    javax.swing.Timer timer = new javax.swing.Timer(40, this);
    Color color;
    ArrayList < FireworksCreator > ar = new ArrayList < FireworksCreator > ();
    int arSize = 0, counter = 0;
    public Fireworks() 
    {
        addMouseListener(this);
        setBackground(Color.BLACK);
        timer.start();
    }
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        arSize = ar.size() - 1;
        if (arSize == -1)
        {
            g2.setPaint(Color.BLACK);
            g2.fillRect(0, 0, Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
        }
        for (FireworksCreator obj2: ar) 
        {
            if (obj2.rat1 > 6)
                 super.paintComponent(g);
            obj2.paintComponent(g);
            if (counter == arSize)
            {
                if (obj2.rat1 >= 13) 
                {
                    g2.setPaint(Color.BLACK);
                    g2.fillRect(0, 0, Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
                }
            }
            counter++;
        }
        counter = 0;
        for (int a = ar.size() - 1; a >= 0; a--) 
        {
            if (ar.get(a).rat1 == 13) 
                ar.remove(a);
        }
    }
    public Color colors() 
    {
        int a = (int)(Math.random() * 255);
        int b = (int)(Math.random() * 255);
        int c = (int)(Math.random() * 255);
        Color d = new Color(a, b, c, 80);
        return d;
    }
    public static void main(String args[])
    {
        f.getContentPane().setBackground(Color.BLACK);
        f.setResizable(true);
        f.setSize(fwidth, fheight);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.getContentPane().setBackground(Color.BLACK);
        Fireworks obj = new Fireworks();
        f.add(obj);
        f.setVisible(true);
        JOptionPane.showMessageDialog(null, "Click mouse repeatedly in random areas for an awesome display of fireworks !!" + "\n" + "                                          Created by Sourish Banerjee" + "\n" + "                                                     Achieved with java");
    }
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) 
    {
        x = e.getX();
        y = e.getY();
        FireworksCreator obj = new FireworksCreator(x, y);
        ar.add(obj);
    }
    public void mouseClicked(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void actionPerformed(ActionEvent e) 
    {
        repaint();
    }
}