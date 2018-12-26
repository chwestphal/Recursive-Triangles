import java.awt.*;
import java.util.Random;

public class Draw extends Canvas {
    private Point p4;
    private Point p5;
    private Point p6;

    public Draw(int width, int height) {
        return;
    }

    public void paint(Graphics g) {
        drawTriangle(g, p4, p5, p6, 0);
    }

    public void drawTriangle(Graphics g, Point p1, Point p2, Point p3, int depth) {
        p1 = new Point(getWidth() / 2, 0);
        p2 = new Point((p1.x) + ((int) ((getHeight() * 2) / (Math.sqrt(3))) / 2), getHeight());
        p3 = new Point((p1.x) - ((int) ((getHeight() * 2 / (Math.sqrt(3)))) / 2), getHeight());
        //Point p4 = new Point ((p1.x + p2.x)/2, (p1.y + p2.y)/2);
        //Point p5 = new Point ((p2.x + p3.x)/2, (p2.y + p3.y)/2);
        //Point p6 = new Point ((p3.x + p1.x)/2, (p3.y + p1.y)/2);
        //int[] x2 = { p4.x, p5.x, p6.x };
        //int[] y2 = { p4.y, p5.y, p6.y };
        int[] x1 = {p1.x, p2.x, p3.x};
        int[] y1 = {p1.y, p2.y, p3.y};
        g.setColor(randomColor());
        //g.drawPolygon(x1, y1, 3);
        //g.drawPolygon(x2, y2, 3);
        g.fillPolygon(x1, y1, 3);
        drawTriangleRecursive(g, p1, p2, p3, 0);
    }

    public void drawTriangleRecursive(Graphics g, Point p1, Point p2, Point p3, int depth) {
        if (depth < 6) {
            Point p4 = new Point((p1.x + p2.x) / 2, (p1.y + p2.y) / 2);
            Point p5 = new Point((p2.x + p3.x) / 2, (p2.y + p3.y) / 2);
            Point p6 = new Point((p3.x + p1.x) / 2, (p3.y + p1.y) / 2);
            int[] x2 = {p4.x, p5.x, p6.x};
            int[] y2 = {p4.y, p5.y, p6.y};
            g.setColor(Color.getHSBColor((depth / 6.0f), 0.8f, 1.0f));
            g.drawPolygon(x2, y2, 3);
            //g.setColor(randomColor());
            g.fillPolygon(x2, y2, 3);
            drawTriangleRecursive(g, p6, p5, p3, depth + 1);
            drawTriangleRecursive(g, p4, p2, p5, depth + 1);
            drawTriangleRecursive(g, p1, p4, p6, depth + 1);
        }
    }

    public Color randomColor() {
        Random random = new Random();
        int r = random.nextInt(256);
        int g = random.nextInt(256);
        int b = random.nextInt(256);
        return new Color(r, g, b);
    }
}