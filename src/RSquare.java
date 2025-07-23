// Imports the Graph2D class (from the graph2D package).
import graph2D.Graph2D;
// Imports the Color class (from the java.awt package) to be able
// to change the colors of the elements that are represented.
import java.awt.Color;
/**
 * Drawing of "Recursive Square" figures.
 * From "Introduction to Programming in Java",
 * Sedgewick & Wayne, Princeton.
 */
public class RSquare {    
    /** There are no objects of this class. */
    private RSquare() { }
    
    /** Draws in the gd window a solid gray square 
     *  with a blue border, centered at (cX, cY) with side length l.
     */
    public static void drawCentSquare(Graph2D gd, 
                                      double cX, double cY, double l) {
        //delay();                                           
        // Calculation of the upper left corner (luX, luY) of the square
        // from its center (cX, cY) and side length l:
        double luX = cX - l/2; // TO COMPLETE
        double luY = cY + l/2; // TO COMPLETE      
        // Drawing a solid gray rectangle, with sides l x l, 
        // and whose upper left corner is at (luX, luY):
        gd.fillRect(luX, luY, l, l, Color.LIGHT_GRAY, 2);
        // Drawing a blue rectangle, with sides l x l, 
        // and whose upper left corner is at (luX, luY):
        gd.drawRect(luX, luY, l, l, Color.BLUE, 2);
    }
    
    /** Temporarily suspends execution for 100 ms. */
    private static void delay() {
        try { Thread.sleep(100); } catch (Exception _) {
        }
    }
    
    /** Draws in the gd window an RSquare-A of order n >= 1, 
     *  centered at (cX, cY) with a central square of side length l.
     */
    public static void rSquareA(Graph2D gd, int n, 
                                double cX, double cY, double l) {
        if(n == 0){
            return;
        }
        rSquareA(gd, n-1, cX - l/2, cY + l/2, l/2);
        rSquareA(gd, n-1, cX - l/2, cY - l/2, l/2);
        rSquareA(gd, n-1, cX + l/2, cY + l/2, l/2);
        rSquareA(gd, n-1, cX + l/2, cY - l/2, l/2);
        drawCentSquare(gd, cX, cY, l);
    }
    
    /** Draws an RSquare-A of order n >= 1, 
     *  with length 1.0 and centered at (0, 0). 
     */
    public static void rSquareA(int n) {
        rSquareA(new Graph2D(), n, 0, 0, 1);
    }
    
    /** Draws in the gd window an RSquare-B of order n >= 1, 
     *  centered at (cX, cY) with a central square of side length l.
     */
    public static void rSquareB(Graph2D gd, int n, 
                                double cX, double cY, double l) {
        if(n == 0){
            return;
        }
        drawCentSquare(gd, cX, cY, l);
        rSquareB(gd, n-1, cX - l/2, cY + l/2, l/2);
        rSquareB(gd, n-1, cX - l/2, cY - l/2, l/2);
        rSquareB(gd, n-1, cX + l/2, cY + l/2, l/2);
        rSquareB(gd, n-1, cX + l/2, cY - l/2, l/2);
    }     
    
    /** Draws an RSquare-B of order n >= 1, 
     *  with length 1.0 and centered at (0, 0). 
     */
    public static void rSquareB(int n) {
        rSquareB(new Graph2D(), n, 0, 0, 1);              
    }    
}