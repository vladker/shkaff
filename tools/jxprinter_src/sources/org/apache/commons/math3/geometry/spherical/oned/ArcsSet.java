package org.apache.commons.math3.geometry.spherical.oned;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.MathInternalError;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.geometry.Point;
import org.apache.commons.math3.geometry.partitioning.AbstractRegion;
import org.apache.commons.math3.geometry.partitioning.BSPTree;
import org.apache.commons.math3.geometry.partitioning.BoundaryProjection;
import org.apache.commons.math3.geometry.partitioning.Region;
import org.apache.commons.math3.geometry.partitioning.Side;
import org.apache.commons.math3.geometry.partitioning.SubHyperplane;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathUtils;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class ArcsSet extends AbstractRegion<Sphere1D, Sphere1D> implements Iterable<double[]> {

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class InconsistentStateAt2PiWrapping extends MathIllegalArgumentException {
        private static final long serialVersionUID = 20140107;

        public InconsistentStateAt2PiWrapping() {
            super(LocalizedFormats.INCONSISTENT_STATE_AT_2_PI_WRAPPING, new Object[0]);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class Split {
        private final ArcsSet minus;
        private final ArcsSet plus;

        public ArcsSet getMinus() {
            return this.minus;
        }

        public ArcsSet getPlus() {
            return this.plus;
        }

        public Side getSide() {
            if (this.plus != null) {
                return this.minus != null ? Side.BOTH : Side.PLUS;
            }
            return this.minus != null ? Side.MINUS : Side.HYPER;
        }

        private Split(ArcsSet arcsSet, ArcsSet arcsSet2) {
            this.plus = arcsSet;
            this.minus = arcsSet2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class SubArcsIterator implements Iterator<double[]> {
        private BSPTree<Sphere1D> current;
        private final BSPTree<Sphere1D> firstStart;
        private double[] pending;

        public SubArcsIterator() {
            BSPTree<Sphere1D> firstArcStart = ArcsSet.this.getFirstArcStart();
            this.firstStart = firstArcStart;
            this.current = firstArcStart;
            if (firstArcStart != null) {
                selectPending();
            } else if (((Boolean) ArcsSet.this.getFirstLeaf(ArcsSet.this.getTree(false)).getAttribute()).booleanValue()) {
                this.pending = new double[]{0.0d, 6.283185307179586d};
            } else {
                this.pending = null;
            }
        }

        private void selectPending() {
            BSPTree<Sphere1D> bSPTreeNextInternalNode = this.current;
            while (bSPTreeNextInternalNode != null && !ArcsSet.this.isArcStart(bSPTreeNextInternalNode)) {
                bSPTreeNextInternalNode = ArcsSet.this.nextInternalNode(bSPTreeNextInternalNode);
            }
            if (bSPTreeNextInternalNode == null) {
                this.current = null;
                this.pending = null;
                return;
            }
            BSPTree<Sphere1D> bSPTreeNextInternalNode2 = bSPTreeNextInternalNode;
            while (bSPTreeNextInternalNode2 != null && !ArcsSet.this.isArcEnd(bSPTreeNextInternalNode2)) {
                bSPTreeNextInternalNode2 = ArcsSet.this.nextInternalNode(bSPTreeNextInternalNode2);
            }
            if (bSPTreeNextInternalNode2 != null) {
                this.pending = new double[]{ArcsSet.this.getAngle(bSPTreeNextInternalNode), ArcsSet.this.getAngle(bSPTreeNextInternalNode2)};
                this.current = bSPTreeNextInternalNode2;
                return;
            }
            BSPTree<Sphere1D> bSPTreePreviousInternalNode = this.firstStart;
            while (bSPTreePreviousInternalNode != null && !ArcsSet.this.isArcEnd(bSPTreePreviousInternalNode)) {
                bSPTreePreviousInternalNode = ArcsSet.this.previousInternalNode(bSPTreePreviousInternalNode);
            }
            if (bSPTreePreviousInternalNode == null) {
                throw new MathInternalError();
            }
            this.pending = new double[]{ArcsSet.this.getAngle(bSPTreeNextInternalNode), ArcsSet.this.getAngle(bSPTreePreviousInternalNode) + 6.283185307179586d};
            this.current = null;
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

    public ArcsSet(double d) {
        super(d);
    }

    private void addArcLimit(BSPTree<Sphere1D> bSPTree, double d, boolean z6) {
        LimitAngle limitAngle = new LimitAngle(new S1Point(d), !z6, getTolerance());
        BSPTree<S> cell = bSPTree.getCell(limitAngle.getLocation(), getTolerance());
        if (cell.getCut() != null) {
            throw new MathInternalError();
        }
        cell.insertCut(limitAngle);
        cell.setAttribute(null);
        cell.getPlus().setAttribute(Boolean.FALSE);
        cell.getMinus().setAttribute(Boolean.TRUE);
    }

    private static BSPTree<Sphere1D> buildTree(double d, double d6, double d7) {
        if (!Precision.equals(d, d6, 0)) {
            double d8 = d6 - d;
            if (d8 < 6.283185307179586d) {
                if (d > d6) {
                    throw new NumberIsTooLargeException(LocalizedFormats.ENDPOINTS_NOT_AN_INTERVAL, Double.valueOf(d), Double.valueOf(d6), true);
                }
                double dNormalizeAngle = MathUtils.normalizeAngle(d, 3.141592653589793d);
                double d9 = d8 + dNormalizeAngle;
                SubLimitAngle subLimitAngleWholeHyperplane = new LimitAngle(new S1Point(dNormalizeAngle), false, d7).wholeHyperplane();
                if (d9 <= 6.283185307179586d) {
                    SubLimitAngle subLimitAngleWholeHyperplane2 = new LimitAngle(new S1Point(d9), true, d7).wholeHyperplane();
                    Boolean bool = Boolean.FALSE;
                    return new BSPTree<>(subLimitAngleWholeHyperplane, new BSPTree(bool), new BSPTree(subLimitAngleWholeHyperplane2, new BSPTree(bool), new BSPTree(Boolean.TRUE), null), null);
                }
                SubLimitAngle subLimitAngleWholeHyperplane3 = new LimitAngle(new S1Point(d9 - 6.283185307179586d), true, d7).wholeHyperplane();
                BSPTree bSPTree = new BSPTree(Boolean.FALSE);
                Boolean bool2 = Boolean.TRUE;
                return new BSPTree<>(subLimitAngleWholeHyperplane, new BSPTree(subLimitAngleWholeHyperplane3, bSPTree, new BSPTree(bool2), null), new BSPTree(bool2), null);
            }
        }
        return new BSPTree<>(Boolean.TRUE);
    }

    private void check2PiConsistency() {
        BSPTree<Sphere1D> tree = getTree(false);
        if (tree.getCut() == null) {
            return;
        }
        Boolean bool = (Boolean) getFirstLeaf(tree).getAttribute();
        Boolean bool2 = (Boolean) getLastLeaf(tree).getAttribute();
        if (bool2.booleanValue() ^ bool.booleanValue()) {
            throw new InconsistentStateAt2PiWrapping();
        }
    }

    private BSPTree<Sphere1D> childAfter(BSPTree<Sphere1D> bSPTree) {
        return isDirect(bSPTree) ? bSPTree.getPlus() : bSPTree.getMinus();
    }

    private BSPTree<Sphere1D> childBefore(BSPTree<Sphere1D> bSPTree) {
        return isDirect(bSPTree) ? bSPTree.getMinus() : bSPTree.getPlus();
    }

    private ArcsSet createSplitPart(List<Double> list) {
        if (list.isEmpty()) {
            return null;
        }
        int i5 = 0;
        while (i5 < list.size()) {
            int size = (i5 + 1) % list.size();
            double dDoubleValue = list.get(i5).doubleValue();
            if (FastMath.abs(MathUtils.normalizeAngle(list.get(size).doubleValue(), dDoubleValue) - dDoubleValue) <= getTolerance()) {
                if (size > 0) {
                    list.remove(size);
                    list.remove(i5);
                    i5--;
                } else {
                    double dDoubleValue2 = list.remove(list.size() - 1).doubleValue();
                    double dDoubleValue3 = list.remove(0).doubleValue();
                    if (list.isEmpty()) {
                        if (dDoubleValue2 - dDoubleValue3 > 3.141592653589793d) {
                            return new ArcsSet((BSPTree<Sphere1D>) new BSPTree(Boolean.TRUE), getTolerance());
                        }
                        return null;
                    }
                    list.add(Double.valueOf(list.remove(0).doubleValue() + 6.283185307179586d));
                }
            }
            i5++;
        }
        BSPTree<Sphere1D> bSPTree = new BSPTree<>(Boolean.FALSE);
        for (int i6 = 0; i6 < list.size() - 1; i6 += 2) {
            addArcLimit(bSPTree, list.get(i6).doubleValue(), true);
            addArcLimit(bSPTree, list.get(i6 + 1).doubleValue(), false);
        }
        if (bSPTree.getCut() == null) {
            return null;
        }
        return new ArcsSet(bSPTree, getTolerance());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public double getAngle(BSPTree<Sphere1D> bSPTree) {
        return ((LimitAngle) bSPTree.getCut().getHyperplane()).getLocation().getAlpha();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [org.apache.commons.math3.geometry.partitioning.AbstractRegion, org.apache.commons.math3.geometry.spherical.oned.ArcsSet] */
    public BSPTree<Sphere1D> getFirstArcStart() {
        BSPTree bSPTreeNextInternalNode;
        BSPTree tree = getTree(false);
        if (tree.getCut() == null) {
            return null;
        }
        BSPTree parent = getFirstLeaf(tree).getParent();
        while (bSPTreeNextInternalNode != null && !isArcStart(bSPTreeNextInternalNode)) {
            bSPTreeNextInternalNode = parent;
            bSPTreeNextInternalNode = nextInternalNode(bSPTreeNextInternalNode);
        }
        bSPTreeNextInternalNode = parent;
        return bSPTreeNextInternalNode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BSPTree<Sphere1D> getFirstLeaf(BSPTree<Sphere1D> bSPTree) {
        if (bSPTree.getCut() == null) {
            return bSPTree;
        }
        BSPTree<Sphere1D> bSPTree2 = null;
        while (bSPTree != null) {
            bSPTree2 = bSPTree;
            bSPTree = previousInternalNode(bSPTree);
        }
        return leafBefore(bSPTree2);
    }

    private BSPTree<Sphere1D> getLastLeaf(BSPTree<Sphere1D> bSPTree) {
        if (bSPTree.getCut() == null) {
            return bSPTree;
        }
        BSPTree<Sphere1D> bSPTree2 = null;
        while (bSPTree != null) {
            bSPTree2 = bSPTree;
            bSPTree = nextInternalNode(bSPTree);
        }
        return leafAfter(bSPTree2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean isAfterParent(BSPTree<Sphere1D> bSPTree) {
        BSPTree<S> parent = bSPTree.getParent();
        return parent != 0 && bSPTree == childAfter(parent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isArcEnd(BSPTree<Sphere1D> bSPTree) {
        return ((Boolean) leafBefore(bSPTree).getAttribute()).booleanValue() && !((Boolean) leafAfter(bSPTree).getAttribute()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isArcStart(BSPTree<Sphere1D> bSPTree) {
        return !((Boolean) leafBefore(bSPTree).getAttribute()).booleanValue() && ((Boolean) leafAfter(bSPTree).getAttribute()).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean isBeforeParent(BSPTree<Sphere1D> bSPTree) {
        BSPTree<S> parent = bSPTree.getParent();
        return parent != 0 && bSPTree == childBefore(parent);
    }

    private boolean isDirect(BSPTree<Sphere1D> bSPTree) {
        return ((LimitAngle) bSPTree.getCut().getHyperplane()).isDirect();
    }

    private BSPTree<Sphere1D> leafAfter(BSPTree<Sphere1D> bSPTree) {
        BSPTree<Sphere1D> bSPTreeChildAfter = childAfter(bSPTree);
        while (bSPTreeChildAfter.getCut() != null) {
            bSPTreeChildAfter = childBefore(bSPTreeChildAfter);
        }
        return bSPTreeChildAfter;
    }

    private BSPTree<Sphere1D> leafBefore(BSPTree<Sphere1D> bSPTree) {
        BSPTree<Sphere1D> bSPTreeChildBefore = childBefore(bSPTree);
        while (bSPTreeChildBefore.getCut() != null) {
            bSPTreeChildBefore = childAfter(bSPTreeChildBefore);
        }
        return bSPTreeChildBefore;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BSPTree<Sphere1D> nextInternalNode(BSPTree<Sphere1D> bSPTree) {
        if (childAfter(bSPTree).getCut() != null) {
            return leafAfter(bSPTree).getParent();
        }
        while (isAfterParent(bSPTree)) {
            bSPTree = bSPTree.getParent();
        }
        return bSPTree.getParent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BSPTree<Sphere1D> previousInternalNode(BSPTree<Sphere1D> bSPTree) {
        if (childBefore(bSPTree).getCut() != null) {
            return leafBefore(bSPTree).getParent();
        }
        while (isBeforeParent(bSPTree)) {
            bSPTree = bSPTree.getParent();
        }
        return bSPTree.getParent();
    }

    public List<Arc> asList() {
        ArrayList arrayList = new ArrayList();
        for (double[] dArr : this) {
            arrayList.add(new Arc(dArr[0], dArr[1], getTolerance()));
        }
        return arrayList;
    }

    @Override // org.apache.commons.math3.geometry.partitioning.AbstractRegion, org.apache.commons.math3.geometry.partitioning.Region
    public /* bridge */ /* synthetic */ AbstractRegion buildNew(BSPTree bSPTree) {
        return buildNew((BSPTree<Sphere1D>) bSPTree);
    }

    @Override // org.apache.commons.math3.geometry.partitioning.AbstractRegion
    public void computeGeometricalProperties() {
        double d = 0.0d;
        if (getTree(false).getCut() == null) {
            setBarycenter(S1Point.NaN);
            setSize(((Boolean) getTree(false).getAttribute()).booleanValue() ? 6.283185307179586d : 0.0d);
            return;
        }
        double d6 = 0.0d;
        for (double[] dArr : this) {
            double d7 = dArr[1];
            double d8 = dArr[0];
            double d9 = d7 - d8;
            d += d9;
            d6 += (d8 + d7) * d9;
        }
        setSize(d);
        if (Precision.equals(d, 6.283185307179586d, 0)) {
            setBarycenter(S1Point.NaN);
        } else if (d >= Precision.SAFE_MIN) {
            setBarycenter(new S1Point(d6 / (d * 2.0d)));
        } else {
            setBarycenter(((LimitAngle) getTree(false).getCut().getHyperplane()).getLocation());
        }
    }

    @Override // java.lang.Iterable
    public Iterator<double[]> iterator() {
        return new SubArcsIterator();
    }

    @Override // org.apache.commons.math3.geometry.partitioning.AbstractRegion, org.apache.commons.math3.geometry.partitioning.Region
    public BoundaryProjection<Sphere1D> projectToBoundary(Point<Sphere1D> point) {
        double alpha = ((S1Point) point).getAlpha();
        double d = Double.NaN;
        boolean z6 = false;
        double d6 = Double.NaN;
        for (double[] dArr : this) {
            if (Double.isNaN(d6)) {
                d6 = dArr[0];
            }
            if (!z6) {
                double d7 = dArr[0];
                if (alpha >= d7) {
                    double d8 = dArr[1];
                    if (alpha <= d8) {
                        double d9 = d7 - alpha;
                        double d10 = alpha - d8;
                        return d9 < d10 ? new BoundaryProjection<>(point, new S1Point(dArr[1]), d10) : new BoundaryProjection<>(point, new S1Point(dArr[0]), d9);
                    }
                } else {
                    if (!Double.isNaN(d)) {
                        double d11 = alpha - d;
                        double d12 = dArr[0] - alpha;
                        return d11 < d12 ? new BoundaryProjection<>(point, new S1Point(d), d11) : new BoundaryProjection<>(point, new S1Point(dArr[0]), d12);
                    }
                    z6 = true;
                }
            }
            d = dArr[1];
        }
        if (Double.isNaN(d)) {
            return new BoundaryProjection<>(point, null, 6.283185307179586d);
        }
        if (z6) {
            double d13 = alpha - (d - 6.283185307179586d);
            double d14 = d6 - alpha;
            return d13 < d14 ? new BoundaryProjection<>(point, new S1Point(d), d13) : new BoundaryProjection<>(point, new S1Point(d6), d14);
        }
        double d15 = alpha - d;
        double d16 = (6.283185307179586d + d6) - alpha;
        return d15 < d16 ? new BoundaryProjection<>(point, new S1Point(d), d15) : new BoundaryProjection<>(point, new S1Point(d6), d16);
    }

    @Deprecated
    public Side side(Arc arc) {
        return split(arc).getSide();
    }

    public Split split(Arc arc) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        double inf = arc.getInf() + 3.141592653589793d;
        double sup = arc.getSup() - arc.getInf();
        for (double[] dArr : this) {
            double dNormalizeAngle = MathUtils.normalizeAngle(dArr[0], inf) - arc.getInf();
            double d = dArr[0];
            double d6 = d - dNormalizeAngle;
            double d7 = dArr[1] - d6;
            if (dNormalizeAngle < sup) {
                arrayList.add(Double.valueOf(d));
                if (d7 > sup) {
                    double d8 = sup + d6;
                    arrayList.add(Double.valueOf(d8));
                    arrayList2.add(Double.valueOf(d8));
                    if (d7 > 6.283185307179586d) {
                        double d9 = d6 + 6.283185307179586d;
                        arrayList2.add(Double.valueOf(d9));
                        arrayList.add(Double.valueOf(d9));
                        arrayList.add(Double.valueOf(dArr[1]));
                    } else {
                        arrayList2.add(Double.valueOf(dArr[1]));
                    }
                } else {
                    arrayList.add(Double.valueOf(dArr[1]));
                }
            } else {
                arrayList2.add(Double.valueOf(d));
                if (d7 > 6.283185307179586d) {
                    double d10 = d6 + 6.283185307179586d;
                    arrayList2.add(Double.valueOf(d10));
                    arrayList.add(Double.valueOf(d10));
                    double d11 = sup + 6.283185307179586d;
                    if (d7 > d11) {
                        double d12 = d11 + d6;
                        arrayList.add(Double.valueOf(d12));
                        arrayList2.add(Double.valueOf(d12));
                        arrayList2.add(Double.valueOf(dArr[1]));
                    } else {
                        arrayList.add(Double.valueOf(dArr[1]));
                    }
                } else {
                    arrayList2.add(Double.valueOf(dArr[1]));
                }
            }
        }
        return new Split(createSplitPart(arrayList));
    }

    public ArcsSet(double d, double d6, double d7) {
        super(buildTree(d, d6, d7), d7);
    }

    @Override // org.apache.commons.math3.geometry.partitioning.AbstractRegion, org.apache.commons.math3.geometry.partitioning.Region
    public /* bridge */ /* synthetic */ Region buildNew(BSPTree bSPTree) {
        return buildNew((BSPTree<Sphere1D>) bSPTree);
    }

    public ArcsSet(BSPTree<Sphere1D> bSPTree, double d) {
        super(bSPTree, d);
        check2PiConsistency();
    }

    @Override // org.apache.commons.math3.geometry.partitioning.AbstractRegion, org.apache.commons.math3.geometry.partitioning.Region
    public ArcsSet buildNew(BSPTree<Sphere1D> bSPTree) {
        return new ArcsSet(bSPTree, getTolerance());
    }

    public ArcsSet(Collection<SubHyperplane<Sphere1D>> collection, double d) {
        super(collection, d);
        check2PiConsistency();
    }
}
