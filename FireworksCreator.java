import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.*;
public class FireworksCreator 
{
    Color color;
    int rat1 = 1;
    int rat2 = 5;
    int x = 0;
    int y = 0;
    int basicStroke = 2;
    int linX[] = new int[50];
    int linY[] = new int[50];
    int trans = 70;
    public FireworksCreator(int x2, int y2) 
    {
        x = x2;
        y = y2;
        neu();
    }
    public void paintComponent(Graphics g) 
    {
        Graphics2D g2 = (Graphics2D) g;
        if (rat1 >= 13) 
        {
            return;
        }
        g2.setStroke(new BasicStroke(basicStroke));
        if (rat1 == 1) 
        {
            color = colors();
        }
        g2.setPaint(color);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        for (int u = 0; u < 50; u++) 
        {
            if (rat1 <= 5) 
            {
                if (!(u % 2 == 0)) 
                {
                    Color p = new Color(color.getRed() + (int)((255 - color.getRed()) * 0.75), color.getGreen() + (int)((255 - color.getGreen()) * 0.75), color.getBlue() + (int)((255 - color.getBlue()) * 0.75), 80);
                    g2.setPaint(p);
                }
            }
            if (rat1 > 5 && rat1 < 13) 
            {
                for (int a = 1, b = 5; a <= 5; a++, b--) 
                {
                    for (int c = 0; c < 50; c++) 
                    {
                        Color p;
                        if (c % 2 != 0) 
                        {
                            p = new Color(color.getRed() + (int)((255 - color.getRed()) * 0.75), color.getGreen() + (int)((255 - color.getGreen()) * 0.75), color.getBlue() + (int)((255 - color.getBlue()) * 0.75), trans);
                        } 
                        else 
                        {
                            p = new Color(color.getRed(), color.getGreen(), color.getBlue(), trans);
                        }
                        g2.setPaint(p);
                        g2.drawLine(x, y, (((a * linX[c]) + (b * x)) / (a + b)), (((a * linY[c]) + (b * y)) / (a + b)));
                    }
                }
                trans -= 10;
                rat1 += 1;
                return;
            }
            g2.drawLine(x, y, (((rat1 * linX[u]) + (rat2 * x)) / (rat1 + rat2)), (((rat1 * linY[u]) + (rat2 * y)) / (rat1 + rat2)));
            g2.setPaint(color);
        }
        rat1 += 1;
        rat2 -= 1;
    }
    public Color colors()  
    {
        int a = (int)(Math.random() * 255);
        int b = (int)(Math.random() * 255);
        int c = (int)(Math.random() * 255);
        Color d = new Color(a, b, c, 80);
        return d;
    }
    public void neu() 
    {
        for (int u = 0; u < 25; u++) 
        {
            linX[u] = x + (int)(Math.random() * 300);
            linY[u] = ((y - 150) + (int)(Math.random() * 350));
        }
        for (int u = 25; u < 50; u++) 
        {
            linX[u] = x - (int)(Math.random() * 300);
            linY[u] = ((y - 150) + (int)(Math.random() * 350));
        }
    }
}