package org.apache.commons.math3.geometry.partitioning;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.math3.geometry.Point;
import org.apache.commons.math3.geometry.Space;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
class BoundaryProjector<S extends Space, T extends Space> implements BSPTreeVisitor<S> {
    private final Point<S> original;
    private Point<S> projected = null;
    private BSPTree<S> leaf = null;
    private double offset = Double.POSITIVE_INFINITY;

    public BoundaryProjector(Point<S> point) {
        this.original = point;
    }

    private void addRegion(SubHyperplane<S> subHyperplane, List<Region<T>> list) {
        Region<T> remainingRegion;
        if (subHyperplane == null || (remainingRegion = ((AbstractSubHyperplane) subHyperplane).getRemainingRegion()) == null) {
            return;
        }
        list.add(remainingRegion);
    }

    private boolean belongsToPart(Point<S> point, Hyperplane<S> hyperplane, Region<T> region) {
        return region.checkPoint(((Embedding) hyperplane).toSubSpace(point)) != Region.Location.OUTSIDE;
    }

    private List<Region<T>> boundaryRegions(BSPTree<S> bSPTree) {
        ArrayList arrayList = new ArrayList(2);
        BoundaryAttribute boundaryAttribute = (BoundaryAttribute) bSPTree.getAttribute();
        addRegion(boundaryAttribute.getPlusInside(), arrayList);
        addRegion(boundaryAttribute.getPlusOutside(), arrayList);
        return arrayList;
    }

    private Point<S> singularProjection(Point<S> point, Hyperplane<S> hyperplane, Region<T> region) {
        Embedding embedding = (Embedding) hyperplane;
        BoundaryProjection<S> boundaryProjectionProjectToBoundary = region.projectToBoundary(embedding.toSubSpace(point));
        if (boundaryProjectionProjectToBoundary.getProjected() == null) {
            return null;
        }
        return embedding.toSpace(boundaryProjectionProjectToBoundary.getProjected());
    }

    public BoundaryProjection<S> getProjection() {
        double dCopySign = FastMath.copySign(this.offset, ((Boolean) this.leaf.getAttribute()).booleanValue() ? -1.0d : 1.0d);
        this.offset = dCopySign;
        return new BoundaryProjection<>(this.original, this.projected, dCopySign);
    }

    @Override // org.apache.commons.math3.geometry.partitioning.BSPTreeVisitor
    public void visitInternalNode(BSPTree<S> bSPTree) {
        Hyperplane<S> hyperplane = bSPTree.getCut().getHyperplane();
        double offset = hyperplane.getOffset(this.original);
        if (FastMath.abs(offset) < this.offset) {
            Point<S> pointProject = hyperplane.project(this.original);
            List<Region<T>> listBoundaryRegions = boundaryRegions(bSPTree);
            boolean z6 = false;
            for (Region<T> region : listBoundaryRegions) {
                if (!z6 && belongsToPart(pointProject, hyperplane, region)) {
                    this.projected = pointProject;
                    this.offset = FastMath.abs(offset);
                    z6 = true;
                }
            }
            if (z6) {
                return;
            }
            Iterator<Region<T>> it = listBoundaryRegions.iterator();
            while (it.hasNext()) {
                Point<S> pointSingularProjection = singularProjection(pointProject, hyperplane, it.next());
                if (pointSingularProjection != null) {
                    double dDistance = this.original.distance(pointSingularProjection);
                    if (dDistance < this.offset) {
                        this.projected = pointSingularProjection;
                        this.offset = dDistance;
                    }
                }
            }
        }
    }

    @Override // org.apache.commons.math3.geometry.partitioning.BSPTreeVisitor
    public void visitLeafNode(BSPTree<S> bSPTree) {
        if (this.leaf == null) {
            this.leaf = bSPTree;
        }
    }

    @Override // org.apache.commons.math3.geometry.partitioning.BSPTreeVisitor
    public BSPTreeVisitor.Order visitOrder(BSPTree<S> bSPTree) {
        return bSPTree.getCut().getHyperplane().getOffset(this.original) <= 0.0d ? BSPTreeVisitor.Order.MINUS_SUB_PLUS : BSPTreeVisitor.Order.PLUS_SUB_MINUS;
    }
}
