package com.company;

public class Main {

    public static void main(String[] args) {
        int N = 5;
        int M = 10;
        float meanarea = 0;
        int minparsq = 0;
        int maxparsq = 0;
        Quadrilateral[] quadrilaterals = new Quadrilateral[N];
        Parallelogram[] parallelograms = new Parallelogram[M];
        for (int i = 0; i < N; i++) {
            quadrilaterals[i] = new Quadrilateral(
                    new Point((float) (Math.random() * 11), (float) (Math.random() * 11)),
                    new Point((float) (Math.random() * 11), (float) (Math.random() * 11)),
                    new Point((float) (Math.random() * 11), (float) (Math.random() * 11)),
                    new Point((float) (Math.random() * 11), (float) (Math.random() * 11)));


            meanarea += quadrilaterals[i].squarcalc();

            //quadrilaterals[i].squarcout();
            //quadrilaterals[i].vertcout();
        }
        System.out.println("Average area of a quadrilaterals = " + meanarea / N);

        for (int i = 0; i < M; i++) {
            Point q = new Point((float) (Math.random() * 11), (float) (Math.random() * 11));
            Point w = new Point((float) (Math.random() * 11), (float) (Math.random() * 11));
            Point offset = new Point((float) (Math.random() * 6), (float) (Math.random() * 6));
            parallelograms[i] = new Parallelogram(q, w, new Point(q.x + offset.x, q.y + offset.y), new Point(w.x + offset.x, w.y + offset.y));
            float temp = parallelograms[i].squarcalc();
            if (temp < parallelograms[minparsq].squar) {
                minparsq = i;
            }
            if (temp > parallelograms[maxparsq].squar) {
                maxparsq = i;
            }

        }
        System.out.println("min Square = " + parallelograms[minparsq].squar + "\nmax Square = " + parallelograms[maxparsq].squar);
        System.out.println("Пример четырехугольника (3) ");
        System.out.println(quadrilaterals[3]);
    }
}
