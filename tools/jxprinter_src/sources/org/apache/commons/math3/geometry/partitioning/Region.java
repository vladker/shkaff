package org.apache.commons.math3.geometry.partitioning;

import org.apache.commons.math3.geometry.Point;
import org.apache.commons.math3.geometry.Space;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface Region<S extends Space> {

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum Location {
        INSIDE,
        OUTSIDE,
        BOUNDARY
    }

    Region<S> buildNew(BSPTree<S> bSPTree);

    Location checkPoint(Point<S> point);

    boolean contains(Region<S> region);

    Region<S> copySelf();

    Point<S> getBarycenter();

    double getBoundarySize();

    double getSize();

    BSPTree<S> getTree(boolean z6);

    SubHyperplane<S> intersection(SubHyperplane<S> subHyperplane);

    boolean isEmpty();

    boolean isEmpty(BSPTree<S> bSPTree);

    boolean isFull();

    boolean isFull(BSPTree<S> bSPTree);

    BoundaryProjection<S> projectToBoundary(Point<S> point);

    @Deprecated
    Side side(Hyperplane<S> hyperplane);
}
