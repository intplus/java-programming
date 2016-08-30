package lesson5;

import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import javax.swing.*;

public class CompositeIt extends JFrame {
    int rules[] = { AlphaComposite.CLEAR, AlphaComposite.DST,
            AlphaComposite.DST_ATOP, AlphaComposite.DST_IN,
            AlphaComposite.DST_OUT, AlphaComposite.DST_OVER,
            AlphaComposite.SRC, AlphaComposite.SRC_ATOP, AlphaComposite.SRC_IN,
            AlphaComposite.SRC_OUT, AlphaComposite.SRC_OVER, AlphaComposite.XOR };
    float percents[] = { .33f, .67f, 1.0f };
    BufferedImage source, dest;
    GeneralPath sourcePath, destPath;

    public CompositeIt() {
        sourcePath = new GeneralPath();
        sourcePath.moveTo(0, 0);
        sourcePath.lineTo(50, 0);
        sourcePath.lineTo(50, 25);
        sourcePath.closePath();
        source = new BufferedImage(80, 30, BufferedImage.TYPE_INT_ARGB);
        destPath = new GeneralPath();
        destPath.moveTo(25, 0);
        destPath.lineTo(75, 0);
        destPath.lineTo(25, 25);
        destPath.closePath();
        dest = new BufferedImage(80, 30, BufferedImage.TYPE_INT_ARGB);
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Graphics2D sourceG = source.createGraphics();
        Graphics2D destG = dest.createGraphics();
        AffineTransform at = new AffineTransform();
        Composite originalComposite = g2d.getComposite();
        for (int i = 0; i < 3; i++) {
            for (int j = 0, n = rules.length; j < n; j++) {
                at = AffineTransform.getTranslateInstance(j * 80 + 10,
                        i * 30 + 30);
                if (j >= rules.length / 2) {
                    at.translate(-rules.length / 2 * 80, 120);
                }
                g2d.setTransform(at);
                g.drawRect(0, 0, 80, 30);
                destG.setComposite(AlphaComposite.Clear);
                destG.fillRect(0, 0, 80, 30);
                destG.setComposite(AlphaComposite.getInstance(
                        AlphaComposite.XOR, percents[i]));
                destG.setPaint(Color.MAGENTA);
                destG.fill(destPath);
                sourceG.setComposite(AlphaComposite.Clear);
                sourceG.fillRect(0, 0, 80, 30);
                sourceG.setComposite(AlphaComposite.getInstance(
                        AlphaComposite.XOR, percents[i]));
                sourceG.setPaint(Color.GREEN);
                sourceG.fill(sourcePath);
                destG.setComposite(AlphaComposite.getInstance(rules[j]));
                destG.drawImage(source, 0, 0, null);
                g2d.drawImage(dest, 0, 0, this);
            }
        }
    }

    public static void main(String args[]) {
        JFrame f = new CompositeIt();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setTitle("CompositeIt");
        f.setSize(525, 275);
        f.show();
    }
}