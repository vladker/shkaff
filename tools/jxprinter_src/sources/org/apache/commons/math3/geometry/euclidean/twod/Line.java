package org.apache.commons.math3.geometry.euclidean.twod;

import java.awt.geom.AffineTransform;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.geometry.Point;
import org.apache.commons.math3.geometry.Vector;
import org.apache.commons.math3.geometry.euclidean.oned.Euclidean1D;
import org.apache.commons.math3.geometry.euclidean.oned.IntervalsSet;
import org.apache.commons.math3.geometry.euclidean.oned.OrientedPoint;
import org.apache.commons.math3.geometry.euclidean.oned.Vector1D;
import org.apache.commons.math3.geometry.partitioning.Embedding;
import org.apache.commons.math3.geometry.partitioning.Hyperplane;
import org.apache.commons.math3.geometry.partitioning.SubHyperplane;
import org.apache.commons.math3.geometry.partitioning.Transform;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathArrays;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Line implements Hyperplane<Euclidean2D>, Embedding<Euclidean2D, Euclidean1D> {
    private static final double DEFAULT_TOLERANCE = 1.0E-10d;
    private double angle;
    private double cos;
    private double originOffset;
    private Line reverse;
    private double sin;
    private final double tolerance;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class LineTransform implements Transform<Euclidean2D, Euclidean1D> {
        private double c11;
        private double c1X;
        private double c1Y;
        private double cX1;
        private double cXX;
        private double cXY;
        private double cY1;
        private double cYX;
        private double cYY;

        public LineTransform(double d, double d6, double d7, double d8, double d9, double d10) {
            this.cXX = d;
            this.cYX = d6;
            this.cXY = d7;
            this.cYY = d8;
            this.cX1 = d9;
            this.cY1 = d10;
            this.c1Y = MathArrays.linearCombination(d7, d10, -d8, d9);
            double d11 = -d6;
            this.c1X = MathArrays.linearCombination(d, d10, d11, d9);
            double dLinearCombination = MathArrays.linearCombination(d, d8, d11, d7);
            this.c11 = dLinearCombination;
            if (FastMath.abs(dLinearCombination) < 1.0E-20d) {
                throw new MathIllegalArgumentException(LocalizedFormats.NON_INVERTIBLE_TRANSFORM, new Object[0]);
            }
        }

        @Override // org.apache.commons.math3.geometry.partitioning.Transform
        public /* bridge */ /* synthetic */ Point apply(Point point) {
            return apply((Point<Euclidean2D>) point);
        }

        @Override // org.apache.commons.math3.geometry.partitioning.Transform
        public /* bridge */ /* synthetic */ Hyperplane apply(Hyperplane hyperplane) {
            return apply((Hyperplane<Euclidean2D>) hyperplane);
        }

        @Override // org.apache.commons.math3.geometry.partitioning.Transform
        public Vector2D apply(Point<Euclidean2D> point) {
            Vector2D vector2D = (Vector2D) point;
            double x6 = vector2D.getX();
            double y6 = vector2D.getY();
            return new Vector2D(MathArrays.linearCombination(this.cXX, x6, this.cXY, y6, this.cX1, 1.0d), MathArrays.linearCombination(this.cYX, x6, this.cYY, y6, this.cY1, 1.0d));
        }

        @Override // org.apache.commons.math3.geometry.partitioning.Transform
        public Line apply(Hyperplane<Euclidean2D> hyperplane) {
            Line line = (Line) hyperplane;
            double dLinearCombination = MathArrays.linearCombination(this.c1X, line.cos, this.c1Y, line.sin, this.c11, line.originOffset);
            double dLinearCombination2 = MathArrays.linearCombination(this.cXX, line.cos, this.cXY, line.sin);
            double dLinearCombination3 = MathArrays.linearCombination(this.cYX, line.cos, this.cYY, line.sin);
            double dSqrt = 1.0d / FastMath.sqrt((dLinearCombination2 * dLinearCombination2) + (dLinearCombination3 * dLinearCombination3));
            return new Line(3.141592653589793d + FastMath.atan2(-dLinearCombination3, -dLinearCombination2), dSqrt * dLinearCombination2, dSqrt * dLinearCombination3, dSqrt * dLinearCombination, line.tolerance);
        }

        @Override // org.apache.commons.math3.geometry.partitioning.Transform
        public SubHyperplane<Euclidean1D> apply(SubHyperplane<Euclidean1D> subHyperplane, Hyperplane<Euclidean2D> hyperplane, Hyperplane<Euclidean2D> hyperplane2) {
            OrientedPoint orientedPoint = (OrientedPoint) subHyperplane.getHyperplane();
            Line line = (Line) hyperplane;
            return new OrientedPoint(((Line) hyperplane2).toSubSpace((Vector<Euclidean2D>) apply((Point<Euclidean2D>) line.toSpace((Vector<Euclidean1D>) orientedPoint.getLocation()))), orientedPoint.isDirect(), line.tolerance).wholeHyperplane();
        }
    }

    @Deprecated
    public static Transform<Euclidean2D, Euclidean1D> getTransform(AffineTransform affineTransform) {
        double[] dArr = new double[6];
        affineTransform.getMatrix(dArr);
        return new LineTransform(dArr[0], dArr[1], dArr[2], dArr[3], dArr[4], dArr[5]);
    }

    private void unlinkReverse() {
        Line line = this.reverse;
        if (line != null) {
            line.reverse = null;
        }
        this.reverse = null;
    }

    public boolean contains(Vector2D vector2D) {
        return FastMath.abs(getOffset((Vector<Euclidean2D>) vector2D)) < this.tolerance;
    }

    public double distance(Vector2D vector2D) {
        return FastMath.abs(getOffset((Vector<Euclidean2D>) vector2D));
    }

    public double getAngle() {
        return MathUtils.normalizeAngle(this.angle, 3.141592653589793d);
    }

    public double getOffset(Line line) {
        return this.originOffset + (MathArrays.linearCombination(this.cos, line.cos, this.sin, line.sin) > 0.0d ? -line.originOffset : line.originOffset);
    }

    public double getOriginOffset() {
        return this.originOffset;
    }

    public Vector2D getPointAt(Vector1D vector1D, double d) {
        double x6 = vector1D.getX();
        double d6 = d - this.originOffset;
        return new Vector2D(MathArrays.linearCombination(x6, this.cos, d6, this.sin), MathArrays.linearCombination(x6, this.sin, -d6, this.cos));
    }

    public Line getReverse() {
        if (this.reverse == null) {
            double d = this.angle;
            Line line = new Line(d < 3.141592653589793d ? d + 3.141592653589793d : d - 3.141592653589793d, -this.cos, -this.sin, -this.originOffset, this.tolerance);
            this.reverse = line;
            line.reverse = this;
        }
        return this.reverse;
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Hyperplane
    public double getTolerance() {
        return this.tolerance;
    }

    public Vector2D intersection(Line line) {
        double dLinearCombination = MathArrays.linearCombination(this.sin, line.cos, -line.sin, this.cos);
        if (FastMath.abs(dLinearCombination) < this.tolerance) {
            return null;
        }
        return new Vector2D(MathArrays.linearCombination(this.cos, line.originOffset, -line.cos, this.originOffset) / dLinearCombination, MathArrays.linearCombination(this.sin, line.originOffset, -line.sin, this.originOffset) / dLinearCombination);
    }

    public boolean isParallelTo(Line line) {
        return FastMath.abs(MathArrays.linearCombination(this.sin, line.cos, -this.cos, line.sin)) < this.tolerance;
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Hyperplane
    public Point<Euclidean2D> project(Point<Euclidean2D> point) {
        return toSpace((Vector<Euclidean1D>) toSubSpace(point));
    }

    public void reset(Vector2D vector2D, Vector2D vector2D2) {
        unlinkReverse();
        double x6 = vector2D2.getX() - vector2D.getX();
        double y6 = vector2D2.getY() - vector2D.getY();
        double dHypot = FastMath.hypot(x6, y6);
        if (dHypot == 0.0d) {
            this.angle = 0.0d;
            this.cos = 1.0d;
            this.sin = 0.0d;
            this.originOffset = vector2D.getY();
            return;
        }
        this.angle = FastMath.atan2(-y6, -x6) + 3.141592653589793d;
        this.cos = x6 / dHypot;
        this.sin = y6 / dHypot;
        this.originOffset = MathArrays.linearCombination(vector2D2.getX(), vector2D.getY(), -vector2D.getX(), vector2D2.getY()) / dHypot;
    }

    public void revertSelf() {
        unlinkReverse();
        double d = this.angle;
        if (d < 3.141592653589793d) {
            this.angle = d + 3.141592653589793d;
        } else {
            this.angle = d - 3.141592653589793d;
        }
        this.cos = -this.cos;
        this.sin = -this.sin;
        this.originOffset = -this.originOffset;
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Hyperplane
    public boolean sameOrientationAs(Hyperplane<Euclidean2D> hyperplane) {
        Line line = (Line) hyperplane;
        return MathArrays.linearCombination(this.sin, line.sin, this.cos, line.cos) >= 0.0d;
    }

    public void setAngle(double d) {
        unlinkReverse();
        double dNormalizeAngle = MathUtils.normalizeAngle(d, 3.141592653589793d);
        this.angle = dNormalizeAngle;
        this.cos = FastMath.cos(dNormalizeAngle);
        this.sin = FastMath.sin(this.angle);
    }

    public void setOriginOffset(double d) {
        unlinkReverse();
        this.originOffset = d;
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Embedding
    public /* bridge */ /* synthetic */ Point toSpace(Point point) {
        return toSpace((Point<Euclidean1D>) point);
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Embedding
    public /* bridge */ /* synthetic */ Point toSubSpace(Point point) {
        return toSubSpace((Point<Euclidean2D>) point);
    }

    public void translateToPoint(Vector2D vector2D) {
        this.originOffset = MathArrays.linearCombination(this.cos, vector2D.getY(), -this.sin, vector2D.getX());
    }

    public Line(Vector2D vector2D, Vector2D vector2D2, double d) {
        reset(vector2D, vector2D2);
        this.tolerance = d;
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Hyperplane
    public Line copySelf() {
        return new Line(this);
    }

    public double getOffset(Vector<Euclidean2D> vector) {
        return getOffset((Point<Euclidean2D>) vector);
    }

    public Vector2D toSpace(Vector<Euclidean1D> vector) {
        return toSpace((Point<Euclidean1D>) vector);
    }

    public Vector1D toSubSpace(Vector<Euclidean2D> vector) {
        return toSubSpace((Point<Euclidean2D>) vector);
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Hyperplane
    public SubLine wholeHyperplane() {
        return new SubLine(this, new IntervalsSet(this.tolerance));
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Hyperplane
    public PolygonsSet wholeSpace() {
        return new PolygonsSet(this.tolerance);
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Hyperplane
    public double getOffset(Point<Euclidean2D> point) {
        Vector2D vector2D = (Vector2D) point;
        return MathArrays.linearCombination(this.sin, vector2D.getX(), -this.cos, vector2D.getY(), 1.0d, this.originOffset);
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Embedding
    public Vector2D toSpace(Point<Euclidean1D> point) {
        double x6 = ((Vector1D) point).getX();
        return new Vector2D(MathArrays.linearCombination(x6, this.cos, -this.originOffset, this.sin), MathArrays.linearCombination(x6, this.sin, this.originOffset, this.cos));
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Embedding
    public Vector1D toSubSpace(Point<Euclidean2D> point) {
        Vector2D vector2D = (Vector2D) point;
        return new Vector1D(MathArrays.linearCombination(this.cos, vector2D.getX(), this.sin, vector2D.getY()));
    }

    public static Transform<Euclidean2D, Euclidean1D> getTransform(double d, double d6, double d7, double d8, double d9, double d10) {
        return new LineTransform(d, d6, d7, d8, d9, d10);
    }

    public Line(Vector2D vector2D, double d, double d6) {
        reset(vector2D, d);
        this.tolerance = d6;
    }

    private Line(double d, double d6, double d7, double d8, double d9) {
        this.angle = d;
        this.cos = d6;
        this.sin = d7;
        this.originOffset = d8;
        this.tolerance = d9;
        this.reverse = null;
    }

    public void reset(Vector2D vector2D, double d) {
        unlinkReverse();
        double dNormalizeAngle = MathUtils.normalizeAngle(d, 3.141592653589793d);
        this.angle = dNormalizeAngle;
        this.cos = FastMath.cos(dNormalizeAngle);
        this.sin = FastMath.sin(this.angle);
        this.originOffset = MathArrays.linearCombination(this.cos, vector2D.getY(), -this.sin, vector2D.getX());
    }

    @Deprecated
    public Line(Vector2D vector2D, Vector2D vector2D2) {
        this(vector2D, vector2D2, 1.0E-10d);
    }

    @Deprecated
    public Line(Vector2D vector2D, double d) {
        this(vector2D, d, 1.0E-10d);
    }

    public Line(Line line) {
        this.angle = MathUtils.normalizeAngle(line.angle, 3.141592653589793d);
        this.cos = line.cos;
        this.sin = line.sin;
        this.originOffset = line.originOffset;
        this.tolerance = line.tolerance;
        this.reverse = null;
    }
}
