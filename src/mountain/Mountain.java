package mountain;

import fractal.Fractal;
import fractal.TurtleGraphics;

import java.util.HashMap;

public class Mountain extends Fractal {

    private static final HashMap<Side, Point> sideMidpoints = new HashMap<>();

    public Mountain() {
        super();
    }

    @Override
    public String getTitle() {
        return "Mountain fractal";
    }

    @Override
    public void draw(TurtleGraphics g) {
        Point a = new Point(80, 200);
        Point b = new Point(400, 100);
        Point c = new Point(200, 450);

        mountainLine(g, a, b, c, order, 16);
    }

    public void mountainLine(TurtleGraphics turtle, Point a, Point b, Point c, int order, double dev) {
        if (order == 0) {
            drawTriangle(turtle, a, b, c);
            return;
        }

        Point abMid = getMidpoint(new Side(a, b), dev);
        Point bcMid = getMidpoint(new Side(b, c), dev);
        Point caMid = getMidpoint(new Side(c, a), dev);

        mountainLine(turtle, a, abMid, caMid, order - 1, dev / 2);
        mountainLine(turtle, abMid, b, bcMid, order - 1, dev / 2);
        mountainLine(turtle, caMid, bcMid, c, order - 1, dev / 2);
        mountainLine(turtle, abMid, bcMid, caMid, order - 1, dev / 2);

    }

    private static void drawTriangle(TurtleGraphics turtle, Point a, Point b, Point c) {
        turtle.moveTo(a.getX(), a.getY());
        turtle.forwardTo(b.getX(), b.getY());
        turtle.forwardTo(c.getX(), c.getY());
        turtle.forwardTo(a.getX(), a.getY());
    }


    private static Point getMidpoint(Side side, double dev) {
        if (sideMidpoints.containsKey(side)) {
            return sideMidpoints.remove(side);
        }

        // Otherwise, calculate a new midpoint
        Point p1 = side.getP1();
        Point p2 = side.getP2();
        int midX = (p1.getX() + p2.getX()) / 2;
        int midY = (p1.getY() + p2.getY()) / 2 + (int) getDev(dev);

        Point midpoint = new Point(midX, midY);

        // Store the midpoint in the map
        sideMidpoints.put(side, midpoint);

        return midpoint;

    }

    private static double getDev(double dev) {
        return RandomUtilities.randFunc(dev);
    }


    private class Side {
        private final Point p1;
        private final Point p2;

        public Side(Point p1, Point p2) {
            // Ensure consistency by always storing points in the same order
            if (p1.getX() < p2.getX() || (p1.getX() == p2.getX() && p1.getY() < p2.getY())) {
                this.p1 = p1;
                this.p2 = p2;
            } else {
                this.p1 = p2;
                this.p2 = p1;
            }
        }

        public Point getP1() {
            return p1;
        }

        public Point getP2() {
            return p2;
        }

        @Override
        public int hashCode() {
            return p1.hashCode() + p2.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof Side)) return false;

            Side other = (Side) obj;

            // Two sides are equal if their endpoints match (in any order)
            return (p1.equals(other.p1) && p2.equals(other.p2)) || (p1.equals(other.p2) && p2.equals(other.p1));
        }
    }


}
