package org.apache.commons.math3.geometry.spherical.oned;

import org.apache.commons.math3.geometry.Point;
import org.apache.commons.math3.geometry.partitioning.Hyperplane;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class LimitAngle implements Hyperplane<Sphere1D> {
    private boolean direct;
    private S1Point location;
    private final double tolerance;

    public LimitAngle(S1Point s1Point, boolean z6, double d) {
        this.location = s1Point;
        this.direct = z6;
        this.tolerance = d;
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Hyperplane
    public LimitAngle copySelf() {
        return this;
    }

    public S1Point getLocation() {
        return this.location;
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Hyperplane
    public double getOffset(Point<Sphere1D> point) {
        double alpha = ((S1Point) point).getAlpha() - this.location.getAlpha();
        return this.direct ? alpha : -alpha;
    }

    public LimitAngle getReverse() {
        return new LimitAngle(this.location, !this.direct, this.tolerance);
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Hyperplane
    public double getTolerance() {
        return this.tolerance;
    }

    public boolean isDirect() {
        return this.direct;
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Hyperplane
    public Point<Sphere1D> project(Point<Sphere1D> point) {
        return this.location;
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Hyperplane
    public boolean sameOrientationAs(Hyperplane<Sphere1D> hyperplane) {
        return !(((LimitAngle) hyperplane).direct ^ this.direct);
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Hyperplane
    public SubLimitAngle wholeHyperplane() {
        return new SubLimitAngle(this, null);
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Hyperplane
    public ArcsSet wholeSpace() {
        return new ArcsSet(this.tolerance);
    }
}
