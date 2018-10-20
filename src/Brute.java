import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Brute {
    public static void main(String args[]) {
        String filename = args[0];
        In in = new In(filename);
        int n = in.readInt();
        Point[] pointsArray = new Point[n];

        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        StdDraw.show();

        for (int i = 0; i < pointsArray.length; i++) {
            int x = in.readInt();
            int y = in.readInt();
            Point point = new Point(x, y);
            pointsArray[i] = point;
            point.draw();
        }
        Arrays.sort(pointsArray);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    for (int l = k + 1; l < n; l++) {
                        Point p = pointsArray[i];
                        Point q = pointsArray[j];
                        Point r = pointsArray[k];
                        Point s = pointsArray[l];

                        if (p.slopeTo(q) == p.slopeTo(r) && p.slopeTo(r) == p.slopeTo(s)) {
                            StdOut.print(p.toString() + " ->" + q.toString() + " ->" + r.toString() + " ->" + s.toString());
                            p.drawTo(r);
                            StdOut.print("\n");
                        }
                    }
                }
            }
        }
    }
}
