package org.apache.commons.math3.geometry.euclidean.threed;

import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.geometry.Point;
import org.apache.commons.math3.geometry.Vector;
import org.apache.commons.math3.geometry.euclidean.oned.Euclidean1D;
import org.apache.commons.math3.geometry.euclidean.oned.Vector1D;
import org.apache.commons.math3.geometry.euclidean.twod.Euclidean2D;
import org.apache.commons.math3.geometry.euclidean.twod.PolygonsSet;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.apache.commons.math3.geometry.partitioning.Embedding;
import org.apache.commons.math3.geometry.partitioning.Hyperplane;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Plane implements Hyperplane<Euclidean3D>, Embedding<Euclidean3D, Euclidean2D> {
    private static final double DEFAULT_TOLERANCE = 1.0E-10d;
    private Vector3D origin;
    private double originOffset;
    private final double tolerance;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private Vector3D f6784u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private Vector3D f6785v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private Vector3D f6786w;

    public Plane(Vector3D vector3D, double d) {
        setNormal(vector3D);
        this.tolerance = d;
        this.originOffset = 0.0d;
        setFrame();
    }

    private void setFrame() {
        this.origin = new Vector3D(-this.originOffset, this.f6786w);
        Vector3D vector3DOrthogonal = this.f6786w.orthogonal();
        this.f6784u = vector3DOrthogonal;
        this.f6785v = Vector3D.crossProduct(this.f6786w, vector3DOrthogonal);
    }

    private void setNormal(Vector3D vector3D) {
        double norm = vector3D.getNorm();
        if (norm < 1.0E-10d) {
            throw new MathArithmeticException(LocalizedFormats.ZERO_NORM, new Object[0]);
        }
        this.f6786w = new Vector3D(1.0d / norm, vector3D);
    }

    public boolean contains(Vector3D vector3D) {
        return FastMath.abs(getOffset((Vector<Euclidean3D>) vector3D)) < this.tolerance;
    }

    public Vector3D getNormal() {
        return this.f6786w;
    }

    public double getOffset(Plane plane) {
        return this.originOffset + (sameOrientationAs(plane) ? -plane.originOffset : plane.originOffset);
    }

    public Vector3D getOrigin() {
        return this.origin;
    }

    public Vector3D getPointAt(Vector2D vector2D, double d) {
        return new Vector3D(vector2D.getX(), this.f6784u, vector2D.getY(), this.f6785v, d - this.originOffset, this.f6786w);
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Hyperplane
    public double getTolerance() {
        return this.tolerance;
    }

    public Vector3D getU() {
        return this.f6784u;
    }

    public Vector3D getV() {
        return this.f6785v;
    }

    public Vector3D intersection(Line line) {
        Vector3D direction = line.getDirection();
        double dDotProduct = this.f6786w.dotProduct(direction);
        if (FastMath.abs(dDotProduct) < 1.0E-10d) {
            return null;
        }
        Vector3D space = line.toSpace((Point<Euclidean1D>) Vector1D.ZERO);
        return new Vector3D(1.0d, space, (-(this.f6786w.dotProduct(space) + this.originOffset)) / dDotProduct, direction);
    }

    public boolean isSimilarTo(Plane plane) {
        double dAngle = Vector3D.angle(this.f6786w, plane.f6786w);
        if (dAngle >= 1.0E-10d || FastMath.abs(this.originOffset - plane.originOffset) >= this.tolerance) {
            return dAngle > 3.141592653489793d && FastMath.abs(this.originOffset + plane.originOffset) < this.tolerance;
        }
        return true;
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Hyperplane
    public Point<Euclidean3D> project(Point<Euclidean3D> point) {
        return toSpace((Vector<Euclidean2D>) toSubSpace(point));
    }

    public void reset(Vector3D vector3D, Vector3D vector3D2) {
        setNormal(vector3D2);
        this.originOffset = -vector3D.dotProduct(this.f6786w);
        setFrame();
    }

    public void revertSelf() {
        Vector3D vector3D = this.f6784u;
        this.f6784u = this.f6785v;
        this.f6785v = vector3D;
        this.f6786w = this.f6786w.negate();
        this.originOffset = -this.originOffset;
    }

    public Plane rotate(Vector3D vector3D, Rotation rotation) {
        Plane plane = new Plane(vector3D.add((Vector<Euclidean3D>) rotation.applyTo(this.origin.subtract((Vector<Euclidean3D>) vector3D))), rotation.applyTo(this.f6786w), this.tolerance);
        plane.f6784u = rotation.applyTo(this.f6784u);
        plane.f6785v = rotation.applyTo(this.f6785v);
        return plane;
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Hyperplane
    public boolean sameOrientationAs(Hyperplane<Euclidean3D> hyperplane) {
        return ((Plane) hyperplane).f6786w.dotProduct(this.f6786w) > 0.0d;
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Embedding
    public /* bridge */ /* synthetic */ Point toSpace(Point point) {
        return toSpace((Point<Euclidean2D>) point);
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Embedding
    public /* bridge */ /* synthetic */ Point toSubSpace(Point point) {
        return toSubSpace((Point<Euclidean3D>) point);
    }

    public Plane translate(Vector3D vector3D) {
        Plane plane = new Plane(this.origin.add((Vector<Euclidean3D>) vector3D), this.f6786w, this.tolerance);
        plane.f6784u = this.f6784u;
        plane.f6785v = this.f6785v;
        return plane;
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Hyperplane
    public Plane copySelf() {
        return new Plane(this);
    }

    public double getOffset(Vector<Euclidean3D> vector) {
        return getOffset((Point<Euclidean3D>) vector);
    }

    public Vector3D toSpace(Vector<Euclidean2D> vector) {
        return toSpace((Point<Euclidean2D>) vector);
    }

    public Vector2D toSubSpace(Vector<Euclidean3D> vector) {
        return toSubSpace((Point<Euclidean3D>) vector);
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Hyperplane
    public SubPlane wholeHyperplane() {
        return new SubPlane(this, new PolygonsSet(this.tolerance));
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Hyperplane
    public PolyhedronsSet wholeSpace() {
        return new PolyhedronsSet(this.tolerance);
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Hyperplane
    public double getOffset(Point<Euclidean3D> point) {
        return ((Vector3D) point).dotProduct(this.f6786w) + this.originOffset;
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Embedding
    public Vector3D toSpace(Point<Euclidean2D> point) {
        Vector2D vector2D = (Vector2D) point;
        return new Vector3D(vector2D.getX(), this.f6784u, vector2D.getY(), this.f6785v, -this.originOffset, this.f6786w);
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Embedding
    public Vector2D toSubSpace(Point<Euclidean3D> point) {
        Vector3D vector3D = (Vector3D) point;
        return new Vector2D(vector3D.dotProduct(this.f6784u), vector3D.dotProduct(this.f6785v));
    }

    public void reset(Plane plane) {
        this.originOffset = plane.originOffset;
        this.origin = plane.origin;
        this.f6784u = plane.f6784u;
        this.f6785v = plane.f6785v;
        this.f6786w = plane.f6786w;
    }

    public Plane(Vector3D vector3D, Vector3D vector3D2, double d) {
        setNormal(vector3D2);
        this.tolerance = d;
        this.originOffset = -vector3D.dotProduct(this.f6786w);
        setFrame();
    }

    public Line intersection(Plane plane) {
        Vector3D vector3DCrossProduct = Vector3D.crossProduct(this.f6786w, plane.f6786w);
        double norm = vector3DCrossProduct.getNorm();
        double d = this.tolerance;
        if (norm < d) {
            return null;
        }
        Vector3D vector3DIntersection = intersection(this, plane, new Plane(vector3DCrossProduct, d));
        return new Line(vector3DIntersection, vector3DIntersection.add((Vector<Euclidean3D>) vector3DCrossProduct), this.tolerance);
    }

    public Plane(Vector3D vector3D, Vector3D vector3D2, Vector3D vector3D3, double d) {
        this(vector3D, vector3D2.subtract((Vector<Euclidean3D>) vector3D).crossProduct(vector3D3.subtract((Vector<Euclidean3D>) vector3D)), d);
    }

    public static Vector3D intersection(Plane plane, Plane plane2, Plane plane3) {
        double x6 = plane.f6786w.getX();
        double y6 = plane.f6786w.getY();
        double z6 = plane.f6786w.getZ();
        double d = plane.originOffset;
        double x7 = plane2.f6786w.getX();
        double y7 = plane2.f6786w.getY();
        double z7 = plane2.f6786w.getZ();
        double d6 = plane2.originOffset;
        double x8 = plane3.f6786w.getX();
        double y8 = plane3.f6786w.getY();
        double z8 = plane3.f6786w.getZ();
        double d7 = plane3.originOffset;
        double d8 = (y7 * z8) - (y8 * z7);
        double d9 = (z7 * x8) - (z8 * x7);
        double d10 = (x7 * y8) - (x8 * y7);
        double d11 = (z6 * d10) + (y6 * d9) + (x6 * d8);
        if (FastMath.abs(d11) < 1.0E-10d) {
            return null;
        }
        double d12 = 1.0d / d11;
        return new Vector3D(((((-d8) * d) - (((z6 * y8) - (z8 * y6)) * d6)) - (((z7 * y6) - (z6 * y7)) * d7)) * d12, ((((-d9) * d) - (((z8 * x6) - (z6 * x8)) * d6)) - (((z6 * x7) - (z7 * x6)) * d7)) * d12, ((((-d10) * d) - (((y6 * x8) - (y8 * x6)) * d6)) - (((y7 * x6) - (y6 * x7)) * d7)) * d12);
    }

    @Deprecated
    public Plane(Vector3D vector3D) {
        this(vector3D, 1.0E-10d);
    }

    @Deprecated
    public Plane(Vector3D vector3D, Vector3D vector3D2) {
        this(vector3D, vector3D2, 1.0E-10d);
    }

    @Deprecated
    public Plane(Vector3D vector3D, Vector3D vector3D2, Vector3D vector3D3) {
        this(vector3D, vector3D2, vector3D3, 1.0E-10d);
    }

    public Plane(Plane plane) {
        this.originOffset = plane.originOffset;
        this.origin = plane.origin;
        this.f6784u = plane.f6784u;
        this.f6785v = plane.f6785v;
        this.f6786w = plane.f6786w;
        this.tolerance = plane.tolerance;
    }
}
