package org.apache.commons.math3.geometry.euclidean.threed;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.geometry.Point;
import org.apache.commons.math3.geometry.Vector;
import org.apache.commons.math3.geometry.euclidean.oned.Euclidean1D;
import org.apache.commons.math3.geometry.euclidean.twod.Euclidean2D;
import org.apache.commons.math3.geometry.euclidean.twod.PolygonsSet;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.apache.commons.math3.geometry.partitioning.AbstractRegion;
import org.apache.commons.math3.geometry.partitioning.BSPTree;
import org.apache.commons.math3.geometry.partitioning.BSPTreeVisitor;
import org.apache.commons.math3.geometry.partitioning.BoundaryAttribute;
import org.apache.commons.math3.geometry.partitioning.Hyperplane;
import org.apache.commons.math3.geometry.partitioning.Region;
import org.apache.commons.math3.geometry.partitioning.RegionFactory;
import org.apache.commons.math3.geometry.partitioning.SubHyperplane;
import org.apache.commons.math3.geometry.partitioning.Transform;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class PolyhedronsSet extends AbstractRegion<Euclidean3D, Euclidean2D> {
    private static final double DEFAULT_TOLERANCE = 1.0E-10d;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class RotationTransform implements Transform<Euclidean3D, Euclidean2D> {
        private Plane cachedOriginal;
        private Transform<Euclidean2D, Euclidean1D> cachedTransform;
        private Vector3D center;
        private Rotation rotation;

        public RotationTransform(Vector3D vector3D, Rotation rotation) {
            this.center = vector3D;
            this.rotation = rotation;
        }

        @Override // org.apache.commons.math3.geometry.partitioning.Transform
        public /* bridge */ /* synthetic */ Point apply(Point point) {
            return apply((Point<Euclidean3D>) point);
        }

        @Override // org.apache.commons.math3.geometry.partitioning.Transform
        public /* bridge */ /* synthetic */ Hyperplane apply(Hyperplane hyperplane) {
            return apply((Hyperplane<Euclidean3D>) hyperplane);
        }

        @Override // org.apache.commons.math3.geometry.partitioning.Transform
        public Vector3D apply(Point<Euclidean3D> point) {
            return new Vector3D(1.0d, this.center, 1.0d, this.rotation.applyTo(((Vector3D) point).subtract((Vector<Euclidean3D>) this.center)));
        }

        @Override // org.apache.commons.math3.geometry.partitioning.Transform
        public Plane apply(Hyperplane<Euclidean3D> hyperplane) {
            return ((Plane) hyperplane).rotate(this.center, this.rotation);
        }

        @Override // org.apache.commons.math3.geometry.partitioning.Transform
        public SubHyperplane<Euclidean2D> apply(SubHyperplane<Euclidean2D> subHyperplane, Hyperplane<Euclidean3D> hyperplane, Hyperplane<Euclidean3D> hyperplane2) {
            if (hyperplane != this.cachedOriginal) {
                Plane plane = (Plane) hyperplane;
                Plane plane2 = (Plane) hyperplane2;
                Vector3D origin = plane.getOrigin();
                Vector3D space = plane.toSpace((Point<Euclidean2D>) new Vector2D(1.0d, 0.0d));
                Vector3D space2 = plane.toSpace((Point<Euclidean2D>) new Vector2D(0.0d, 1.0d));
                Vector2D subSpace = plane2.toSubSpace((Point<Euclidean3D>) apply((Point<Euclidean3D>) origin));
                Vector2D subSpace2 = plane2.toSubSpace((Point<Euclidean3D>) apply((Point<Euclidean3D>) space));
                Vector2D subSpace3 = plane2.toSubSpace((Point<Euclidean3D>) apply((Point<Euclidean3D>) space2));
                this.cachedOriginal = plane;
                this.cachedTransform = org.apache.commons.math3.geometry.euclidean.twod.Line.getTransform(subSpace2.getX() - subSpace.getX(), subSpace2.getY() - subSpace.getY(), subSpace3.getX() - subSpace.getX(), subSpace3.getY() - subSpace.getY(), subSpace.getX(), subSpace.getY());
            }
            return ((org.apache.commons.math3.geometry.euclidean.twod.SubLine) subHyperplane).applyTransform(this.cachedTransform);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class TranslationTransform implements Transform<Euclidean3D, Euclidean2D> {
        private Plane cachedOriginal;
        private Transform<Euclidean2D, Euclidean1D> cachedTransform;
        private Vector3D translation;

        public TranslationTransform(Vector3D vector3D) {
            this.translation = vector3D;
        }

        @Override // org.apache.commons.math3.geometry.partitioning.Transform
        public /* bridge */ /* synthetic */ Point apply(Point point) {
            return apply((Point<Euclidean3D>) point);
        }

        @Override // org.apache.commons.math3.geometry.partitioning.Transform
        public /* bridge */ /* synthetic */ Hyperplane apply(Hyperplane hyperplane) {
            return apply((Hyperplane<Euclidean3D>) hyperplane);
        }

        @Override // org.apache.commons.math3.geometry.partitioning.Transform
        public Vector3D apply(Point<Euclidean3D> point) {
            return new Vector3D(1.0d, (Vector3D) point, 1.0d, this.translation);
        }

        @Override // org.apache.commons.math3.geometry.partitioning.Transform
        public Plane apply(Hyperplane<Euclidean3D> hyperplane) {
            return ((Plane) hyperplane).translate(this.translation);
        }

        @Override // org.apache.commons.math3.geometry.partitioning.Transform
        public SubHyperplane<Euclidean2D> apply(SubHyperplane<Euclidean2D> subHyperplane, Hyperplane<Euclidean3D> hyperplane, Hyperplane<Euclidean3D> hyperplane2) {
            if (hyperplane != this.cachedOriginal) {
                Plane plane = (Plane) hyperplane;
                Vector2D subSpace = ((Plane) hyperplane2).toSubSpace((Point<Euclidean3D>) apply((Point<Euclidean3D>) plane.getOrigin()));
                this.cachedOriginal = plane;
                this.cachedTransform = org.apache.commons.math3.geometry.euclidean.twod.Line.getTransform(1.0d, 0.0d, 0.0d, 1.0d, subSpace.getX(), subSpace.getY());
            }
            return ((org.apache.commons.math3.geometry.euclidean.twod.SubLine) subHyperplane).applyTransform(this.cachedTransform);
        }
    }

    public PolyhedronsSet(double d) {
        super(d);
    }

    private SubHyperplane<Euclidean3D> boundaryFacet(Vector3D vector3D, BSPTree<Euclidean3D> bSPTree) {
        Vector2D subSpace = ((Plane) bSPTree.getCut().getHyperplane()).toSubSpace((Point<Euclidean3D>) vector3D);
        BoundaryAttribute boundaryAttribute = (BoundaryAttribute) bSPTree.getAttribute();
        if (boundaryAttribute.getPlusOutside() != null && ((SubPlane) boundaryAttribute.getPlusOutside()).getRemainingRegion().checkPoint(subSpace) == Region.Location.INSIDE) {
            return boundaryAttribute.getPlusOutside();
        }
        if (boundaryAttribute.getPlusInside() == null || ((SubPlane) boundaryAttribute.getPlusInside()).getRemainingRegion().checkPoint(subSpace) != Region.Location.INSIDE) {
            return null;
        }
        return boundaryAttribute.getPlusInside();
    }

    private static BSPTree<Euclidean3D> buildBoundary(double d, double d6, double d7, double d8, double d9, double d10, double d11) {
        if (d >= d6 - d11 || d7 >= d8 - d11 || d9 >= d10 - d11) {
            return new BSPTree<>(Boolean.FALSE);
        }
        return new RegionFactory().buildConvex(new Plane(new Vector3D(d, 0.0d, 0.0d), Vector3D.MINUS_I, d11), new Plane(new Vector3D(d6, 0.0d, 0.0d), Vector3D.PLUS_I, d11), new Plane(new Vector3D(0.0d, d7, 0.0d), Vector3D.MINUS_J, d11), new Plane(new Vector3D(0.0d, d8, 0.0d), Vector3D.PLUS_J, d11), new Plane(new Vector3D(0.0d, 0.0d, d9), Vector3D.MINUS_K, d11), new Plane(new Vector3D(0.0d, 0.0d, d10), Vector3D.PLUS_K, d11)).getTree(false);
    }

    private static int[][] findReferences(List<Vector3D> list, List<int[]> list2) {
        int[] iArr = new int[list.size()];
        int iMax = 0;
        for (int[] iArr2 : list2) {
            if (iArr2.length < 3) {
                throw new NumberIsTooSmallException(LocalizedFormats.WRONG_NUMBER_OF_POINTS, 3, Integer.valueOf(iArr2.length), true);
            }
            for (int i5 : iArr2) {
                int i6 = iArr[i5] + 1;
                iArr[i5] = i6;
                iMax = FastMath.max(iMax, i6);
            }
        }
        int[][] iArr3 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, list.size(), iMax);
        for (int[] iArr4 : iArr3) {
            Arrays.fill(iArr4, -1);
        }
        for (int i7 = 0; i7 < list2.size(); i7++) {
            for (int i8 : list2.get(i7)) {
                int i9 = 0;
                while (i9 < iMax && iArr3[i8][i9] >= 0) {
                    i9++;
                }
                iArr3[i8][i9] = i7;
            }
        }
        return iArr3;
    }

    private SubHyperplane<Euclidean3D> recurseFirstIntersection(BSPTree<Euclidean3D> bSPTree, Vector3D vector3D, Line line) {
        Vector3D vector3DIntersection;
        SubHyperplane<Euclidean3D> subHyperplaneBoundaryFacet;
        SubHyperplane<Euclidean3D> subHyperplaneBoundaryFacet2;
        SubHyperplane<S> cut = bSPTree.getCut();
        if (cut == 0) {
            return null;
        }
        BSPTree<Euclidean3D> minus = bSPTree.getMinus();
        BSPTree<Euclidean3D> plus = bSPTree.getPlus();
        Plane plane = (Plane) cut.getHyperplane();
        double offset = plane.getOffset((Point<Euclidean3D>) vector3D);
        boolean z6 = FastMath.abs(offset) < getTolerance();
        if (offset >= 0.0d) {
            plus = minus;
            minus = plus;
        }
        if (z6 && (subHyperplaneBoundaryFacet2 = boundaryFacet(vector3D, bSPTree)) != null) {
            return subHyperplaneBoundaryFacet2;
        }
        SubHyperplane<Euclidean3D> subHyperplaneRecurseFirstIntersection = recurseFirstIntersection(minus, vector3D, line);
        if (subHyperplaneRecurseFirstIntersection != null) {
            return subHyperplaneRecurseFirstIntersection;
        }
        return (z6 || (vector3DIntersection = plane.intersection(line)) == null || line.getAbscissa(vector3DIntersection) <= line.getAbscissa(vector3D) || (subHyperplaneBoundaryFacet = boundaryFacet(vector3DIntersection, bSPTree)) == null) ? recurseFirstIntersection(plus, vector3D, line) : subHyperplaneBoundaryFacet;
    }

    private static int[][] successors(List<Vector3D> list, List<int[]> list2, int[][] iArr) {
        int i5;
        int[][] iArr2 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, list.size(), iArr[0].length);
        for (int[] iArr3 : iArr2) {
            Arrays.fill(iArr3, -1);
        }
        for (int i6 = 0; i6 < list.size(); i6++) {
            for (int i7 = 0; i7 < iArr2[i6].length && (i5 = iArr[i6][i7]) >= 0; i7++) {
                int[] iArr4 = list2.get(i5);
                int i8 = 0;
                while (i8 < iArr4.length && iArr4[i8] != i6) {
                    i8++;
                }
                iArr2[i6][i7] = iArr4[(i8 + 1) % iArr4.length];
                for (int i9 = 0; i9 < i7; i9++) {
                    int[] iArr5 = iArr2[i6];
                    if (iArr5[i9] == iArr5[i7]) {
                        Vector3D vector3D = list.get(i6);
                        Vector3D vector3D2 = list.get(iArr2[i6][i7]);
                        throw new MathIllegalArgumentException(LocalizedFormats.FACET_ORIENTATION_MISMATCH, Double.valueOf(vector3D.getX()), Double.valueOf(vector3D.getY()), Double.valueOf(vector3D.getZ()), Double.valueOf(vector3D2.getX()), Double.valueOf(vector3D2.getY()), Double.valueOf(vector3D2.getZ()));
                    }
                }
            }
        }
        return iArr2;
    }

    @Override // org.apache.commons.math3.geometry.partitioning.AbstractRegion, org.apache.commons.math3.geometry.partitioning.Region
    public /* bridge */ /* synthetic */ AbstractRegion buildNew(BSPTree bSPTree) {
        return buildNew((BSPTree<Euclidean3D>) bSPTree);
    }

    @Override // org.apache.commons.math3.geometry.partitioning.AbstractRegion
    public void computeGeometricalProperties() {
        getTree(true).visit(new FacetsContributionVisitor());
        if (getSize() < 0.0d) {
            setSize(Double.POSITIVE_INFINITY);
            setBarycenter((Point) Vector3D.NaN);
        } else {
            setSize(getSize() / 3.0d);
            setBarycenter((Point) new Vector3D(1.0d / (getSize() * 4.0d), (Vector3D) getBarycenter()));
        }
    }

    public SubHyperplane<Euclidean3D> firstIntersection(Vector3D vector3D, Line line) {
        return recurseFirstIntersection(getTree(true), vector3D, line);
    }

    public PolyhedronsSet rotate(Vector3D vector3D, Rotation rotation) {
        return (PolyhedronsSet) applyTransform(new RotationTransform(vector3D, rotation));
    }

    public PolyhedronsSet translate(Vector3D vector3D) {
        return (PolyhedronsSet) applyTransform(new TranslationTransform(vector3D));
    }

    public PolyhedronsSet(BSPTree<Euclidean3D> bSPTree, double d) {
        super(bSPTree, d);
    }

    @Override // org.apache.commons.math3.geometry.partitioning.AbstractRegion, org.apache.commons.math3.geometry.partitioning.Region
    public /* bridge */ /* synthetic */ Region buildNew(BSPTree bSPTree) {
        return buildNew((BSPTree<Euclidean3D>) bSPTree);
    }

    public PolyhedronsSet(Collection<SubHyperplane<Euclidean3D>> collection, double d) {
        super(collection, d);
    }

    @Override // org.apache.commons.math3.geometry.partitioning.AbstractRegion, org.apache.commons.math3.geometry.partitioning.Region
    public PolyhedronsSet buildNew(BSPTree<Euclidean3D> bSPTree) {
        return new PolyhedronsSet(bSPTree, getTolerance());
    }

    public PolyhedronsSet(List<Vector3D> list, List<int[]> list2, double d) {
        super(buildBoundary(list, list2, d), d);
    }

    public PolyhedronsSet(double d, double d6, double d7, double d8, double d9, double d10, double d11) {
        super(buildBoundary(d, d6, d7, d8, d9, d10, d11), d11);
    }

    @Deprecated
    public PolyhedronsSet() {
        this(1.0E-10d);
    }

    @Deprecated
    public PolyhedronsSet(BSPTree<Euclidean3D> bSPTree) {
        this(bSPTree, 1.0E-10d);
    }

    @Deprecated
    public PolyhedronsSet(Collection<SubHyperplane<Euclidean3D>> collection) {
        this(collection, 1.0E-10d);
    }

    @Deprecated
    public PolyhedronsSet(double d, double d6, double d7, double d8, double d9, double d10) {
        this(d, d6, d7, d8, d9, d10, 1.0E-10d);
    }

    private static List<SubHyperplane<Euclidean3D>> buildBoundary(List<Vector3D> list, List<int[]> list2, double d) {
        int i5 = 0;
        while (i5 < list.size() - 1) {
            Vector3D vector3D = list.get(i5);
            i5++;
            for (int i6 = i5; i6 < list.size(); i6++) {
                if (Vector3D.distance(vector3D, list.get(i6)) <= d) {
                    throw new MathIllegalArgumentException(LocalizedFormats.CLOSE_VERTICES, Double.valueOf(vector3D.getX()), Double.valueOf(vector3D.getY()), Double.valueOf(vector3D.getZ()));
                }
            }
        }
        int[][] iArrSuccessors = successors(list, list2, findReferences(list, list2));
        int i7 = 0;
        while (i7 < list.size()) {
            for (int i8 : iArrSuccessors[i7]) {
                if (i8 >= 0) {
                    boolean z6 = false;
                    for (int i9 : iArrSuccessors[i8]) {
                        z6 = z6 || i9 == i7;
                    }
                    if (!z6) {
                        Vector3D vector3D2 = list.get(i7);
                        Vector3D vector3D3 = list.get(i8);
                        throw new MathIllegalArgumentException(LocalizedFormats.EDGE_CONNECTED_TO_ONE_FACET, Double.valueOf(vector3D2.getX()), Double.valueOf(vector3D2.getY()), Double.valueOf(vector3D2.getZ()), Double.valueOf(vector3D3.getX()), Double.valueOf(vector3D3.getY()), Double.valueOf(vector3D3.getZ()));
                    }
                }
            }
            i7++;
        }
        ArrayList arrayList = new ArrayList();
        for (int[] iArr : list2) {
            Plane plane = new Plane(list.get(iArr[0]), list.get(iArr[1]), list.get(iArr[2]), d);
            Vector2D[] vector2DArr = new Vector2D[iArr.length];
            for (int i10 = 0; i10 < iArr.length; i10++) {
                Vector3D vector3D4 = list.get(iArr[i10]);
                if (plane.contains(vector3D4)) {
                    vector2DArr[i10] = plane.toSubSpace((Vector<Euclidean3D>) vector3D4);
                } else {
                    throw new MathIllegalArgumentException(LocalizedFormats.OUT_OF_PLANE, Double.valueOf(vector3D4.getX()), Double.valueOf(vector3D4.getY()), Double.valueOf(vector3D4.getZ()));
                }
            }
            arrayList.add(new SubPlane(plane, new PolygonsSet(d, vector2DArr)));
        }
        return arrayList;
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class FacetsContributionVisitor implements BSPTreeVisitor<Euclidean3D> {
        public FacetsContributionVisitor() {
            PolyhedronsSet.this.setSize(0.0d);
            PolyhedronsSet.this.setBarycenter((Point) new Vector3D(0.0d, 0.0d, 0.0d));
        }

        /* JADX WARN: Multi-variable type inference failed */
        private void addContribution(SubHyperplane<Euclidean3D> subHyperplane, boolean z6) {
            Region<Euclidean2D> remainingRegion = ((SubPlane) subHyperplane).getRemainingRegion();
            double size = remainingRegion.getSize();
            if (Double.isInfinite(size)) {
                PolyhedronsSet.this.setSize(Double.POSITIVE_INFINITY);
                PolyhedronsSet.this.setBarycenter((Point) Vector3D.NaN);
                return;
            }
            Plane plane = (Plane) subHyperplane.getHyperplane();
            Vector3D space = plane.toSpace((Point<Euclidean2D>) remainingRegion.getBarycenter());
            double dDotProduct = space.dotProduct(plane.getNormal()) * size;
            if (z6) {
                dDotProduct = -dDotProduct;
            }
            double d = dDotProduct;
            PolyhedronsSet polyhedronsSet = PolyhedronsSet.this;
            polyhedronsSet.setSize(polyhedronsSet.getSize() + d);
            PolyhedronsSet.this.setBarycenter((Point) new Vector3D(1.0d, (Vector3D) PolyhedronsSet.this.getBarycenter(), d, space));
        }

        @Override // org.apache.commons.math3.geometry.partitioning.BSPTreeVisitor
        public void visitInternalNode(BSPTree<Euclidean3D> bSPTree) {
            BoundaryAttribute boundaryAttribute = (BoundaryAttribute) bSPTree.getAttribute();
            if (boundaryAttribute.getPlusOutside() != null) {
                addContribution(boundaryAttribute.getPlusOutside(), false);
            }
            if (boundaryAttribute.getPlusInside() != null) {
                addContribution(boundaryAttribute.getPlusInside(), true);
            }
        }

        @Override // org.apache.commons.math3.geometry.partitioning.BSPTreeVisitor
        public BSPTreeVisitor.Order visitOrder(BSPTree<Euclidean3D> bSPTree) {
            return BSPTreeVisitor.Order.MINUS_SUB_PLUS;
        }

        @Override // org.apache.commons.math3.geometry.partitioning.BSPTreeVisitor
        public void visitLeafNode(BSPTree<Euclidean3D> bSPTree) {
        }
    }
}
