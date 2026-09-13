package org.apache.commons.math3.geometry.enclosing;

import java.io.Serializable;
import org.apache.commons.math3.geometry.Point;
import org.apache.commons.math3.geometry.Space;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class EnclosingBall<S extends Space, P extends Point<S>> implements Serializable {
    private static final long serialVersionUID = 20140126;
    private final P center;
    private final double radius;
    private final P[] support;

    public EnclosingBall(P p6, double d, P... pArr) {
        this.center = p6;
        this.radius = d;
        this.support = (P[]) ((Point[]) pArr.clone());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean contains(P p6) {
        return p6.distance(this.center) <= this.radius;
    }

    public P getCenter() {
        return this.center;
    }

    public double getRadius() {
        return this.radius;
    }

    public P[] getSupport() {
        return (P[]) ((Point[]) this.support.clone());
    }

    public int getSupportSize() {
        return this.support.length;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean contains(P p6, double d) {
        return p6.distance(this.center) <= this.radius + d;
    }
}
