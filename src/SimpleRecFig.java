// Imports the Graph2D class (from the graph2D package).
import graph2D.Graph2D;
// Imports the Color class (from the java.awt package) to be able
// to change the colors of the elements that are represented.
import java.awt.Color;
/**
 * The SimpleRecFig class includes the basic elements
 * for drawing a figure recursively.
 */
public class SimpleRecFig {
    /** There are no objects of this class. */
    private SimpleRecFig() { }

    /**
     * Draws, recursively, a series of chained squares
     * in a diagonal. The number of squares is given by iniOrd.    
     * @param iniOrd int, number of squares to be drawn.
     * PRECONDITION: iniOrd >= 1
     */
    public static void recFig(int iniOrd) {
        // Dimensions of the drawing space in real coords:
        double minX = -0.1, maxX = 2.1;
        double minY = -0.1, maxY = 2.1;
        
        Graph2D gd = new Graph2D(minX, maxX, minY, maxY);
        // Title of the window where the drawing takes place:
        gd.setTitle("Recursive Figure: Chained Squares. Order: " + iniOrd); 
        
        // Figure of order iniOrd, with iniOrd squares.
        // The largest square of the figure has side length 1.0
        // and with the upper left corner at (1.0, 1.0)
        // Initial call to the recursive method:
        recFig(gd, iniOrd, 1.0, 1.0, 1.0);
    }
   
    /**
     * Draws, iteratively, a series of chained squares
     * in a diagonal. The number of squares is given by iniOrd.    
     * @param iniOrd int, number of squares to be drawn.
     * PRECONDITION: iniOrd >= 1
     */
    public static void iterFig(int iniOrd) {
        // Dimensions of the drawing space in real coords:
        double minX = -0.1, maxX = 2.1;
        double minY = -0.1, maxY = 2.1;
        
        Graph2D gd = new Graph2D(minX, maxX, minY, maxY);
        // Title of the window where the drawing takes place:
        gd.setTitle("Iterative figure: Chained Squares. Order: " + iniOrd); 
        
        // Figure of order iniOrd, with iniOrd squares.
        // The largest square of the figure has side length 1.0, 
        // and with the upper left corner at (1.0, 1.0)
        // Call to the iterative method:
        iterFig(gd, iniOrd, 1.0, 1.0, 1.0);
    }
    
    /**
     * Draws, recursively, a diagonal of ord squares with decreasing sides.
     * The largest square has side length l, and the rest of the squares
     * reduce their side length by half.
     * @param g Graph2D, the Graph2D space where the drawing is performed.
     * @param ord int, order (or number) of squares.
     * @param l double, side length of the largest square.
     * @param xSL double, x-coordinate of the upper left corner the largest square.
     * @param ySL double, y-coordinate of the upper left corner the largest square.
     * PRECONDITION: ord >= 1 
     */
    private static void recFig(Graph2D g, int ord, double l, double xSL, double ySL) {
        // Base case: ord == 1, draw the square with side length l.
        // General case: ord > 1, draw the square with side length l, and chain 
        // diagonally a subfigure of order ord - 1.
        if (ord == 1) {
            delay();
            g.drawRect(xSL, ySL, l, l, Color.BLUE, 2);
        } else {
            delay();
            g.drawRect(xSL, ySL, l, l, Color.BLUE, 2);
            recFig(g, ord - 1, l / 2, xSL - l / 2, ySL + l / 2);
        }
    }

    /**
     * Draws, iteratively, a diagonal of ord squares with decreasing sides.
     * The largest square has side length l, and the rest of the squares
     * reduce their side length by half.
     * @param g Graph2D, the Graph2D space where the drawing is performed.
     * @param ord int, order (or number) of squares.
     * @param l double, side length of the largest square.
     * @param xSL double, x-coordinate of the upper left corner the largest square.
     * @param ySL double, y-coordinate of the upper left corner the largest square.
     * PRECONDITION: ord >= 1 
     */
    private static void iterFig(Graph2D g, int ord, double l, double xSL, double ySL) {
        for (; ord >= 1; ord--) {
            g.drawRect(xSL, ySL, l, l, Color.RED, 2);
            delay();
            xSL = xSL - l / 2;
            ySL = ySL + l / 2;
            l = l / 2;
        }
    }           
    
    /** Temporarily suspends execution for 300 ms. */
    private static void delay() {
        try { Thread.sleep(300); } catch (Exception _) {
        }
    }
}
