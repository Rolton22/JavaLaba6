package com.company;

import java.util.List;

public class Quadrilateral {
    private Point[] vert;
    float[] sides;
    private float[] diags;
    private float per;
    float squar;

    public boolean is_exist() {
        if (vert.length == 4)
            return true;
        return false;
    }

    public Quadrilateral(Point a, Point b, Point c, Point d) {
        vert = new Point[]{a, b, c, d};
    }

    public Quadrilateral() {
    }

    private float lengthcalc(Point a, Point b) {
        return (float) Math.sqrt(Math.pow(b.x - a.x, 2) + Math.pow(b.y - a.y, 2));
    }

    public void sidescalc() {
        sides = new float[4];
        sides[0] = lengthcalc(vert[0], vert[1]);
        sides[1] = lengthcalc(vert[0], vert[2]);
        sides[2] = lengthcalc(vert[3], vert[2]);
        sides[3] = lengthcalc(vert[3], vert[1]);
    }

    public String sidescout() {
        if (sides == null) {
            if (is_exist())
                sidescalc();
            else {
                return ("Вершины не заданы");

            }
        }
        return ("Quadrilateral sides: " + sides[0] + " " + sides[1] + " " + sides[2] + " " + sides[3]);
    }

    public void diagscalc() {
        diags = new float[2];
        diags[0] = lengthcalc(vert[0], vert[3]);
        diags[1] = lengthcalc(vert[1], vert[2]);
    }

    public String diagscout() {
        if (diags == null) {
            if (is_exist())
                diagscalc();
            else {
                return ("Вершины не заданы");

            }
        }
        return ("Quadrilateral diags: " + diags[0] + " " + diags[1]);
    }

    public void percalc() {
        if (sides == null && is_exist())
            sidescalc();
        per = sides[0] + sides[1] + sides[2] + sides[3];
    }

    public String percout() {
        if (per == 0 && is_exist())
            percalc();
        return ("Perimeter = " + per);
    }

    public float squarcalc() {
        if (!(is_exist()))
            return -1;
        if (sides == null)
            sidescalc();
        if (diags == null)
            diagscalc();
        float tophalf, bottomhalf, toparea, bottomarea;

        tophalf = Halfper(sides[0], sides[1], diags[1]);
        bottomhalf = Halfper(sides[2], sides[3], diags[1]);

        toparea = (float) Math.sqrt(tophalf * (tophalf - sides[0]) * (tophalf - sides[1]) * (tophalf - diags[1]));
        bottomarea = (float) Math.sqrt(bottomhalf * (bottomhalf - sides[2]) * (bottomhalf - sides[3]) * (bottomhalf - diags[1]));
        squar = toparea + bottomarea;
        return squar;
    }

    public String squarcout() {
        if (squar == 0 && is_exist())
            squarcalc();
        return ("Square = " + squar);
    }

    private float Halfper(float a, float b, float c) {
        return (a + b + c) / 2;
    }

    public String vertcout() {
        if (!is_exist())
            return "Вершины не заданы ";
        return (" " + vert[0] + " " + vert[1] + " " + vert[2] + " " + vert[3]);
    }

    @Override
    public String toString() {
        return new String(vertcout() + percout() + "\n" + squarcout() + "\n" + diagscout() + "\n" + sidescout());
    }
}
