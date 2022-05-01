package com.company;

public class Parallelogram extends Quadrilateral {
    boolean is_parallelogram() {
        double threshold = 0.00001;
        return Math.abs(sides[0] - sides[2]) < threshold && Math.abs(sides[1] - sides[3]) < threshold;
    }

    public Parallelogram(Point a, Point b, Point c, Point d) {
        super(a, b, c, d);
        sidescalc();
    }
}
