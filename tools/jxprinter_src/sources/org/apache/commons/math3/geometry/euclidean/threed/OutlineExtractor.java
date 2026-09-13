package org.apache.commons.math3.geometry.euclidean.threed;

import androidx.collection.a;
import java.util.ArrayList;
import org.apache.commons.math3.geometry.Point;
import org.apache.commons.math3.geometry.euclidean.twod.Euclidean2D;
import org.apache.commons.math3.geometry.euclidean.twod.PolygonsSet;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.apache.commons.math3.geometry.partitioning.AbstractSubHyperplane;
import org.apache.commons.math3.geometry.partitioning.BSPTree;
import org.apache.commons.math3.geometry.partitioning.BSPTreeVisitor;
import org.apache.commons.math3.geometry.partitioning.BoundaryAttribute;
import org.apache.commons.math3.geometry.partitioning.RegionFactory;
import org.apache.commons.math3.geometry.partitioning.SubHyperplane;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class OutlineExtractor {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private Vector3D f6781u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private Vector3D f6782v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private Vector3D f6783w;

    public OutlineExtractor(Vector3D vector3D, Vector3D vector3D2) {
        this.f6781u = vector3D;
        this.f6782v = vector3D2;
        this.f6783w = Vector3D.crossProduct(vector3D, vector3D2);
    }

    private boolean pointIsBetween(Vector2D[] vector2DArr, int i5, int i6) {
        Vector2D vector2D = vector2DArr[((i6 + i5) - 1) % i5];
        Vector2D vector2D2 = vector2DArr[i6];
        Vector2D vector2D3 = vector2DArr[(i6 + 1) % i5];
        double x6 = vector2D2.getX() - vector2D.getX();
        double y6 = vector2D2.getY() - vector2D.getY();
        double x7 = vector2D3.getX() - vector2D2.getX();
        double y7 = vector2D3.getY() - vector2D2.getY();
        return FastMath.abs((x6 * y7) - (x7 * y6)) <= FastMath.sqrt(a.B(y7, y7, x7 * x7, (y6 * y6) + (x6 * x6))) * 1.0E-6d && (x6 * x7) + (y6 * y7) >= 0.0d;
    }

    public Vector2D[][] getOutline(PolyhedronsSet polyhedronsSet) {
        BoundaryProjector boundaryProjector = new BoundaryProjector(polyhedronsSet.getTolerance());
        polyhedronsSet.getTree(true).visit(boundaryProjector);
        Vector2D[][] vertices = boundaryProjector.getProjected().getVertices();
        for (int i5 = 0; i5 < vertices.length; i5++) {
            Vector2D[] vector2DArr = vertices[i5];
            int length = vector2DArr.length;
            int i6 = 0;
            while (i6 < length) {
                if (pointIsBetween(vector2DArr, length, i6)) {
                    int i7 = i6;
                    while (i7 < length - 1) {
                        int i8 = i7 + 1;
                        vector2DArr[i7] = vector2DArr[i8];
                        i7 = i8;
                    }
                    length--;
                } else {
                    i6++;
                }
            }
            if (length != vector2DArr.length) {
                Vector2D[] vector2DArr2 = new Vector2D[length];
                vertices[i5] = vector2DArr2;
                System.arraycopy(vector2DArr, 0, vector2DArr2, 0, length);
            }
        }
        return vertices;
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class BoundaryProjector implements BSPTreeVisitor<Euclidean3D> {
        private PolygonsSet projected;
        private final double tolerance;

        public BoundaryProjector(double d) {
            this.projected = new PolygonsSet((BSPTree<Euclidean2D>) new BSPTree(Boolean.FALSE), d);
            this.tolerance = d;
        }

        private void addContribution(SubHyperplane<Euclidean3D> subHyperplane, boolean z6) {
            Vector2D vector2D;
            AbstractSubHyperplane abstractSubHyperplane = (AbstractSubHyperplane) subHyperplane;
            Plane plane = (Plane) subHyperplane.getHyperplane();
            double dDotProduct = plane.getNormal().dotProduct(OutlineExtractor.this.f6783w);
            if (FastMath.abs(dDotProduct) > 0.001d) {
                Vector2D[][] vertices = ((PolygonsSet) abstractSubHyperplane.getRemainingRegion()).getVertices();
                int i5 = 0;
                int i6 = 1;
                if ((dDotProduct < 0.0d) ^ z6) {
                    Vector2D[][] vector2DArr = new Vector2D[vertices.length][];
                    for (int i7 = 0; i7 < vertices.length; i7++) {
                        Vector2D[] vector2DArr2 = vertices[i7];
                        Vector2D[] vector2DArr3 = new Vector2D[vector2DArr2.length];
                        if (vector2DArr2[0] == null) {
                            vector2DArr3[0] = null;
                            for (int i8 = 1; i8 < vector2DArr2.length; i8++) {
                                vector2DArr3[i8] = vector2DArr2[vector2DArr2.length - i8];
                            }
                        } else {
                            int i9 = 0;
                            while (i9 < vector2DArr2.length) {
                                int i10 = i9 + 1;
                                vector2DArr3[i9] = vector2DArr2[vector2DArr2.length - i10];
                                i9 = i10;
                            }
                        }
                        vector2DArr[i7] = vector2DArr3;
                    }
                    vertices = vector2DArr;
                }
                ArrayList arrayList = new ArrayList();
                int length = vertices.length;
                int i11 = 0;
                while (i11 < length) {
                    Vector2D[] vector2DArr4 = vertices[i11];
                    int i12 = vector2DArr4[i5] != null ? i6 : i5;
                    int length2 = i12 != 0 ? vector2DArr4.length - i6 : i6;
                    Vector3D space = plane.toSpace((Point<Euclidean2D>) vector2DArr4[length2]);
                    int length3 = (length2 + 1) % vector2DArr4.length;
                    int i13 = length;
                    Vector2D vector2D2 = new Vector2D(space.dotProduct(OutlineExtractor.this.f6781u), space.dotProduct(OutlineExtractor.this.f6782v));
                    int i14 = length2;
                    int i15 = length3;
                    while (i15 < vector2DArr4.length) {
                        Vector3D space2 = plane.toSpace((Point<Euclidean2D>) vector2DArr4[i15]);
                        Vector2D vector2D3 = new Vector2D(space2.dotProduct(OutlineExtractor.this.f6781u), space2.dotProduct(OutlineExtractor.this.f6782v));
                        org.apache.commons.math3.geometry.euclidean.twod.Line line = new org.apache.commons.math3.geometry.euclidean.twod.Line(vector2D2, vector2D3, this.tolerance);
                        SubHyperplane subHyperplaneWholeHyperplane = line.wholeHyperplane();
                        if (i12 != 0 || i14 != 1) {
                            subHyperplaneWholeHyperplane = subHyperplaneWholeHyperplane.split(new org.apache.commons.math3.geometry.euclidean.twod.Line(vector2D2, line.getAngle() + 1.5707963267948966d, this.tolerance)).getPlus();
                        }
                        if (i12 == 0 && i15 == vector2DArr4.length - 1) {
                            vector2D = vector2D3;
                        } else {
                            vector2D = vector2D3;
                            subHyperplaneWholeHyperplane = subHyperplaneWholeHyperplane.split(new org.apache.commons.math3.geometry.euclidean.twod.Line(vector2D, line.getAngle() + 1.5707963267948966d, this.tolerance)).getMinus();
                        }
                        arrayList.add(subHyperplaneWholeHyperplane);
                        int i16 = i15;
                        i15++;
                        i14 = i16;
                        vector2D2 = vector2D;
                    }
                    i11++;
                    length = i13;
                    i6 = 1;
                    i5 = 0;
                }
                this.projected = (PolygonsSet) new RegionFactory().union(this.projected, new PolygonsSet(arrayList, this.tolerance));
            }
        }

        public PolygonsSet getProjected() {
            return this.projected;
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
