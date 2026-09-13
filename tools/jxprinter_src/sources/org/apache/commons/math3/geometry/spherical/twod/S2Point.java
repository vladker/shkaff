package org.apache.commons.math3.geometry.spherical.twod;

import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.geometry.Point;
import org.apache.commons.math3.geometry.Space;
import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathUtils;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class S2Point implements Point<Sphere2D> {
    private static final long serialVersionUID = 20131218;
    private final double phi;
    private final double theta;
    private final Vector3D vector;
    public static final S2Point PLUS_I = new S2Point(0.0d, 1.5707963267948966d, Vector3D.PLUS_I);
    public static final S2Point PLUS_J = new S2Point(1.5707963267948966d, 1.5707963267948966d, Vector3D.PLUS_J);
    public static final S2Point PLUS_K = new S2Point(0.0d, 0.0d, Vector3D.PLUS_K);
    public static final S2Point MINUS_I = new S2Point(3.141592653589793d, 1.5707963267948966d, Vector3D.MINUS_I);
    public static final S2Point MINUS_J = new S2Point(4.71238898038469d, 1.5707963267948966d, Vector3D.MINUS_J);
    public static final S2Point MINUS_K = new S2Point(0.0d, 3.141592653589793d, Vector3D.MINUS_K);
    public static final S2Point NaN = new S2Point(Double.NaN, Double.NaN, Vector3D.NaN);

    public S2Point(double d, double d6) {
        this(d, d6, vector(d, d6));
    }

    private static Vector3D vector(double d, double d6) {
        if (d6 < 0.0d || d6 > 3.141592653589793d) {
            throw new OutOfRangeException(Double.valueOf(d6), 0, Double.valueOf(3.141592653589793d));
        }
        double dCos = FastMath.cos(d);
        double dSin = FastMath.sin(d);
        double dCos2 = FastMath.cos(d6);
        double dSin2 = FastMath.sin(d6);
        return new Vector3D(dCos * dSin2, dSin * dSin2, dCos2);
    }

    @Override // org.apache.commons.math3.geometry.Point
    public double distance(Point<Sphere2D> point) {
        return distance(this, (S2Point) point);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof S2Point) {
            S2Point s2Point = (S2Point) obj;
            if (s2Point.isNaN()) {
                return isNaN();
            }
            if (this.theta == s2Point.theta && this.phi == s2Point.phi) {
                return true;
            }
        }
        return false;
    }

    public double getPhi() {
        return this.phi;
    }

    @Override // org.apache.commons.math3.geometry.Point
    public Space getSpace() {
        return Sphere2D.getInstance();
    }

    public double getTheta() {
        return this.theta;
    }

    public Vector3D getVector() {
        return this.vector;
    }

    public int hashCode() {
        if (isNaN()) {
            return Videoio.CAP_PROP_XI_LUT_INDEX;
        }
        return (MathUtils.hash(this.phi) + (MathUtils.hash(this.theta) * 37)) * 134;
    }

    @Override // org.apache.commons.math3.geometry.Point
    public boolean isNaN() {
        return Double.isNaN(this.theta) || Double.isNaN(this.phi);
    }

    public S2Point negate() {
        return new S2Point(-this.theta, 3.141592653589793d - this.phi, this.vector.negate());
    }

    public S2Point(Vector3D vector3D) {
        this(FastMath.atan2(vector3D.getY(), vector3D.getX()), Vector3D.angle(Vector3D.PLUS_K, vector3D), vector3D.normalize());
    }

    public static double distance(S2Point s2Point, S2Point s2Point2) {
        return Vector3D.angle(s2Point.vector, s2Point2.vector);
    }

    private S2Point(double d, double d6, Vector3D vector3D) {
        this.theta = d;
        this.phi = d6;
        this.vector = vector3D;
    }
}
