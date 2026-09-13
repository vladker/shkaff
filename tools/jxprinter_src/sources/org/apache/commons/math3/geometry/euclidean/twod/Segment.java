package org.apache.commons.math3.geometry.euclidean.twod;

import org.apache.commons.math3.geometry.Point;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Segment {
    private final Vector2D end;
    private final Line line;
    private final Vector2D start;

    public Segment(Vector2D vector2D, Vector2D vector2D2, Line line) {
        this.start = vector2D;
        this.end = vector2D2;
        this.line = line;
    }

    public double distance(Vector2D vector2D) {
        double x6 = this.end.getX() - this.start.getX();
        double y6 = this.end.getY() - this.start.getY();
        double y7 = (((vector2D.getY() - this.start.getY()) * y6) + ((vector2D.getX() - this.start.getX()) * x6)) / ((y6 * y6) + (x6 * x6));
        if (y7 < 0.0d || y7 > 1.0d) {
            return FastMath.min(getStart().distance((Point<Euclidean2D>) vector2D), getEnd().distance((Point<Euclidean2D>) vector2D));
        }
        return new Vector2D((x6 * y7) + this.start.getX(), (y7 * y6) + this.start.getY()).distance((Point<Euclidean2D>) vector2D);
    }

    public Vector2D getEnd() {
        return this.end;
    }

    public Line getLine() {
        return this.line;
    }

    public Vector2D getStart() {
        return this.start;
    }
}
