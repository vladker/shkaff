package org.apache.commons.math3.geometry.euclidean.oned;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import org.apache.commons.math3.geometry.Point;
import org.apache.commons.math3.geometry.partitioning.AbstractRegion;
import org.apache.commons.math3.geometry.partitioning.BSPTree;
import org.apache.commons.math3.geometry.partitioning.BoundaryProjection;
import org.apache.commons.math3.geometry.partitioning.Region;
import org.apache.commons.math3.geometry.partitioning.SubHyperplane;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class IntervalsSet extends AbstractRegion<Euclidean1D, Euclidean1D> implements Iterable<double[]> {
    private static final double DEFAULT_TOLERANCE = 1.0E-10d;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class SubIntervalsIterator implements Iterator<double[]> {
        private BSPTree<Euclidean1D> current;
        private double[] pending;

        public SubIntervalsIterator() {
            BSPTree<Euclidean1D> firstIntervalBoundary = IntervalsSet.this.getFirstIntervalBoundary();
            this.current = firstIntervalBoundary;
            if (firstIntervalBoundary == null) {
                if (((Boolean) IntervalsSet.this.getFirstLeaf(IntervalsSet.this.getTree(false)).getAttribute()).booleanValue()) {
                    this.pending = new double[]{Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY};
                    return;
                } else {
                    this.pending = null;
                    return;
                }
            }
            if (IntervalsSet.this.isIntervalEnd(firstIntervalBoundary)) {
                this.pending = new double[]{Double.NEGATIVE_INFINITY, IntervalsSet.this.getAngle(this.current)};
            } else {
                selectPending();
            }
        }

        private void selectPending() {
            BSPTree<Euclidean1D> bSPTreeNextInternalNode = this.current;
            while (bSPTreeNextInternalNode != null && !IntervalsSet.this.isIntervalStart(bSPTreeNextInternalNode)) {
                bSPTreeNextInternalNode = IntervalsSet.this.nextInternalNode(bSPTreeNextInternalNode);
            }
            if (bSPTreeNextInternalNode == null) {
                this.current = null;
                this.pending = null;
                return;
            }
            BSPTree<Euclidean1D> bSPTreeNextInternalNode2 = bSPTreeNextInternalNode;
            while (bSPTreeNextInternalNode2 != null && !IntervalsSet.this.isIntervalEnd(bSPTreeNextInternalNode2)) {
                bSPTreeNextInternalNode2 = IntervalsSet.this.nextInternalNode(bSPTreeNextInternalNode2);
            }
            if (bSPTreeNextInternalNode2 != null) {
                this.pending = new double[]{IntervalsSet.this.getAngle(bSPTreeNextInternalNode), IntervalsSet.this.getAngle(bSPTreeNextInternalNode2)};
                this.current = bSPTreeNextInternalNode2;
            } else {
                this.pending = new double[]{IntervalsSet.this.getAngle(bSPTreeNextInternalNode), Double.POSITIVE_INFINITY};
                this.current = null;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.pending != null;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Iterator
        public double[] next() {
            double[] dArr = this.pending;
            if (dArr == null) {
                throw new NoSuchElementException();
            }
            selectPending();
            return dArr;
        }
    }

    public IntervalsSet(double d) {
        super(d);
    }

    private static BSPTree<Euclidean1D> buildTree(double d, double d6, double d7) {
        if (Double.isInfinite(d) && d < 0.0d) {
            return (!Double.isInfinite(d6) || d6 <= 0.0d) ? new BSPTree<>(new OrientedPoint(new Vector1D(d6), true, d7).wholeHyperplane(), new BSPTree(Boolean.FALSE), new BSPTree(Boolean.TRUE), null) : new BSPTree<>(Boolean.TRUE);
        }
        SubOrientedPoint subOrientedPointWholeHyperplane = new OrientedPoint(new Vector1D(d), false, d7).wholeHyperplane();
        if (Double.isInfinite(d6) && d6 > 0.0d) {
            return new BSPTree<>(subOrientedPointWholeHyperplane, new BSPTree(Boolean.FALSE), new BSPTree(Boolean.TRUE), null);
        }
        SubOrientedPoint subOrientedPointWholeHyperplane2 = new OrientedPoint(new Vector1D(d6), true, d7).wholeHyperplane();
        Boolean bool = Boolean.FALSE;
        return new BSPTree<>(subOrientedPointWholeHyperplane, new BSPTree(bool), new BSPTree(subOrientedPointWholeHyperplane2, new BSPTree(bool), new BSPTree(Boolean.TRUE), null), null);
    }

    private BSPTree<Euclidean1D> childAfter(BSPTree<Euclidean1D> bSPTree) {
        return isDirect(bSPTree) ? bSPTree.getPlus() : bSPTree.getMinus();
    }

    private BSPTree<Euclidean1D> childBefore(BSPTree<Euclidean1D> bSPTree) {
        return isDirect(bSPTree) ? bSPTree.getMinus() : bSPTree.getPlus();
    }

    private Vector1D finiteOrNullPoint(double d) {
        if (Double.isInfinite(d)) {
            return null;
        }
        return new Vector1D(d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public double getAngle(BSPTree<Euclidean1D> bSPTree) {
        return ((OrientedPoint) bSPTree.getCut().getHyperplane()).getLocation().getX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [org.apache.commons.math3.geometry.euclidean.oned.IntervalsSet, org.apache.commons.math3.geometry.partitioning.AbstractRegion] */
    public BSPTree<Euclidean1D> getFirstIntervalBoundary() {
        BSPTree bSPTreeNextInternalNode;
        BSPTree tree = getTree(false);
        if (tree.getCut() == null) {
            return null;
        }
        BSPTree parent = getFirstLeaf(tree).getParent();
        while (bSPTreeNextInternalNode != null && !isIntervalStart(bSPTreeNextInternalNode) && !isIntervalEnd(bSPTreeNextInternalNode)) {
            bSPTreeNextInternalNode = parent;
            bSPTreeNextInternalNode = nextInternalNode(bSPTreeNextInternalNode);
        }
        bSPTreeNextInternalNode = parent;
        return bSPTreeNextInternalNode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BSPTree<Euclidean1D> getFirstLeaf(BSPTree<Euclidean1D> bSPTree) {
        if (bSPTree.getCut() == null) {
            return bSPTree;
        }
        BSPTree<Euclidean1D> bSPTree2 = null;
        while (bSPTree != null) {
            bSPTree2 = bSPTree;
            bSPTree = previousInternalNode(bSPTree);
        }
        return leafBefore(bSPTree2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean isAfterParent(BSPTree<Euclidean1D> bSPTree) {
        BSPTree<S> parent = bSPTree.getParent();
        return parent != 0 && bSPTree == childAfter(parent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean isBeforeParent(BSPTree<Euclidean1D> bSPTree) {
        BSPTree<S> parent = bSPTree.getParent();
        return parent != 0 && bSPTree == childBefore(parent);
    }

    private boolean isDirect(BSPTree<Euclidean1D> bSPTree) {
        return ((OrientedPoint) bSPTree.getCut().getHyperplane()).isDirect();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isIntervalEnd(BSPTree<Euclidean1D> bSPTree) {
        return ((Boolean) leafBefore(bSPTree).getAttribute()).booleanValue() && !((Boolean) leafAfter(bSPTree).getAttribute()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isIntervalStart(BSPTree<Euclidean1D> bSPTree) {
        return !((Boolean) leafBefore(bSPTree).getAttribute()).booleanValue() && ((Boolean) leafAfter(bSPTree).getAttribute()).booleanValue();
    }

    private BSPTree<Euclidean1D> leafAfter(BSPTree<Euclidean1D> bSPTree) {
        BSPTree<Euclidean1D> bSPTreeChildAfter = childAfter(bSPTree);
        while (bSPTreeChildAfter.getCut() != null) {
            bSPTreeChildAfter = childBefore(bSPTreeChildAfter);
        }
        return bSPTreeChildAfter;
    }

    private BSPTree<Euclidean1D> leafBefore(BSPTree<Euclidean1D> bSPTree) {
        BSPTree<Euclidean1D> bSPTreeChildBefore = childBefore(bSPTree);
        while (bSPTreeChildBefore.getCut() != null) {
            bSPTreeChildBefore = childAfter(bSPTreeChildBefore);
        }
        return bSPTreeChildBefore;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BSPTree<Euclidean1D> nextInternalNode(BSPTree<Euclidean1D> bSPTree) {
        if (childAfter(bSPTree).getCut() != null) {
            return leafAfter(bSPTree).getParent();
        }
        while (isAfterParent(bSPTree)) {
            bSPTree = bSPTree.getParent();
        }
        return bSPTree.getParent();
    }

    private BSPTree<Euclidean1D> previousInternalNode(BSPTree<Euclidean1D> bSPTree) {
        if (childBefore(bSPTree).getCut() != null) {
            return leafBefore(bSPTree).getParent();
        }
        while (isBeforeParent(bSPTree)) {
            bSPTree = bSPTree.getParent();
        }
        return bSPTree.getParent();
    }

    public List<Interval> asList() {
        ArrayList arrayList = new ArrayList();
        for (double[] dArr : this) {
            arrayList.add(new Interval(dArr[0], dArr[1]));
        }
        return arrayList;
    }

    @Override // org.apache.commons.math3.geometry.partitioning.AbstractRegion, org.apache.commons.math3.geometry.partitioning.Region
    public /* bridge */ /* synthetic */ AbstractRegion buildNew(BSPTree bSPTree) {
        return buildNew((BSPTree<Euclidean1D>) bSPTree);
    }

    @Override // org.apache.commons.math3.geometry.partitioning.AbstractRegion
    public void computeGeometricalProperties() {
        double size = 0.0d;
        if (getTree(false).getCut() == null) {
            setBarycenter((Point) Vector1D.NaN);
            setSize(((Boolean) getTree(false).getAttribute()).booleanValue() ? Double.POSITIVE_INFINITY : 0.0d);
            return;
        }
        double barycenter = 0.0d;
        for (Interval interval : asList()) {
            size += interval.getSize();
            barycenter += interval.getBarycenter() * interval.getSize();
        }
        setSize(size);
        if (Double.isInfinite(size)) {
            setBarycenter((Point) Vector1D.NaN);
        } else if (size >= Precision.SAFE_MIN) {
            setBarycenter((Point) new Vector1D(barycenter / size));
        } else {
            setBarycenter((Point) ((OrientedPoint) getTree(false).getCut().getHyperplane()).getLocation());
        }
    }

    public double getInf() {
        BSPTree<Euclidean1D> tree = getTree(false);
        double d = Double.POSITIVE_INFINITY;
        while (tree.getCut() != null) {
            OrientedPoint orientedPoint = (OrientedPoint) tree.getCut().getHyperplane();
            double x6 = orientedPoint.getLocation().getX();
            tree = orientedPoint.isDirect() ? tree.getMinus() : tree.getPlus();
            d = x6;
        }
        if (((Boolean) tree.getAttribute()).booleanValue()) {
            return Double.NEGATIVE_INFINITY;
        }
        return d;
    }

    public double getSup() {
        BSPTree<Euclidean1D> tree = getTree(false);
        double d = Double.NEGATIVE_INFINITY;
        while (tree.getCut() != null) {
            OrientedPoint orientedPoint = (OrientedPoint) tree.getCut().getHyperplane();
            double x6 = orientedPoint.getLocation().getX();
            tree = orientedPoint.isDirect() ? tree.getPlus() : tree.getMinus();
            d = x6;
        }
        if (((Boolean) tree.getAttribute()).booleanValue()) {
            return Double.POSITIVE_INFINITY;
        }
        return d;
    }

    @Override // java.lang.Iterable
    public Iterator<double[]> iterator() {
        return new SubIntervalsIterator();
    }

    @Override // org.apache.commons.math3.geometry.partitioning.AbstractRegion, org.apache.commons.math3.geometry.partitioning.Region
    public BoundaryProjection<Euclidean1D> projectToBoundary(Point<Euclidean1D> point) {
        double x6 = ((Vector1D) point).getX();
        double d = Double.NEGATIVE_INFINITY;
        for (double[] dArr : this) {
            double d6 = dArr[0];
            if (x6 < d6) {
                double d7 = x6 - d;
                double d8 = d6 - x6;
                return d7 < d8 ? new BoundaryProjection<>(point, finiteOrNullPoint(d), d7) : new BoundaryProjection<>(point, finiteOrNullPoint(d6), d8);
            }
            d = dArr[1];
            if (x6 <= d) {
                double d9 = d6 - x6;
                double d10 = x6 - d;
                return d9 < d10 ? new BoundaryProjection<>(point, finiteOrNullPoint(d), d10) : new BoundaryProjection<>(point, finiteOrNullPoint(d6), d9);
            }
        }
        return new BoundaryProjection<>(point, finiteOrNullPoint(d), x6 - d);
    }

    public IntervalsSet(double d, double d6, double d7) {
        super(buildTree(d, d6, d7), d7);
    }

    @Override // org.apache.commons.math3.geometry.partitioning.AbstractRegion, org.apache.commons.math3.geometry.partitioning.Region
    public /* bridge */ /* synthetic */ Region buildNew(BSPTree bSPTree) {
        return buildNew((BSPTree<Euclidean1D>) bSPTree);
    }

    public IntervalsSet(BSPTree<Euclidean1D> bSPTree, double d) {
        super(bSPTree, d);
    }

    @Override // org.apache.commons.math3.geometry.partitioning.AbstractRegion, org.apache.commons.math3.geometry.partitioning.Region
    public IntervalsSet buildNew(BSPTree<Euclidean1D> bSPTree) {
        return new IntervalsSet(bSPTree, getTolerance());
    }

    public IntervalsSet(Collection<SubHyperplane<Euclidean1D>> collection, double d) {
        super(collection, d);
    }

    @Deprecated
    public IntervalsSet() {
        this(1.0E-10d);
    }

    @Deprecated
    public IntervalsSet(double d, double d6) {
        this(d, d6, 1.0E-10d);
    }

    @Deprecated
    public IntervalsSet(BSPTree<Euclidean1D> bSPTree) {
        this(bSPTree, 1.0E-10d);
    }

    @Deprecated
    public IntervalsSet(Collection<SubHyperplane<Euclidean1D>> collection) {
        this(collection, 1.0E-10d);
    }
}
