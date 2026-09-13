package org.apache.commons.math3.geometry.spherical.oned;

import org.apache.commons.math3.geometry.Point;
import org.apache.commons.math3.geometry.Space;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathUtils;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class S1Point implements Point<Sphere1D> {
    public static final S1Point NaN = new S1Point(Double.NaN, Vector2D.NaN);
    private static final long serialVersionUID = 20131218;
    private final double alpha;
    private final Vector2D vector;

    public S1Point(double d) {
        this(MathUtils.normalizeAngle(d, 3.141592653589793d), new Vector2D(FastMath.cos(d), FastMath.sin(d)));
    }

    @Override // org.apache.commons.math3.geometry.Point
    public double distance(Point<Sphere1D> point) {
        return distance(this, (S1Point) point);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof S1Point) {
            S1Point s1Point = (S1Point) obj;
            if (s1Point.isNaN()) {
                return isNaN();
            }
            if (this.alpha == s1Point.alpha) {
                return true;
            }
        }
        return false;
    }

    public double getAlpha() {
        return this.alpha;
    }

    @Override // org.apache.commons.math3.geometry.Point
    public Space getSpace() {
        return Sphere1D.getInstance();
    }

    public Vector2D getVector() {
        return this.vector;
    }

    public int hashCode() {
        return isNaN() ? Videoio.CAP_PROP_XI_LUT_INDEX : MathUtils.hash(this.alpha) * 1759;
    }

    @Override // org.apache.commons.math3.geometry.Point
    public boolean isNaN() {
        return Double.isNaN(this.alpha);
    }

    private S1Point(double d, Vector2D vector2D) {
        this.alpha = d;
        this.vector = vector2D;
    }

    public static double distance(S1Point s1Point, S1Point s1Point2) {
        return Vector2D.angle(s1Point.vector, s1Point2.vector);
    }
}
