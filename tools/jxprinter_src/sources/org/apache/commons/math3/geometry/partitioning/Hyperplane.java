package org.apache.commons.math3.geometry.partitioning;

import org.apache.commons.math3.geometry.Point;
import org.apache.commons.math3.geometry.Space;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface Hyperplane<S extends Space> {
    Hyperplane<S> copySelf();

    double getOffset(Point<S> point);

    double getTolerance();

    Point<S> project(Point<S> point);

    boolean sameOrientationAs(Hyperplane<S> hyperplane);

    SubHyperplane<S> wholeHyperplane();

    Region<S> wholeSpace();
}
