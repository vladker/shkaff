package org.apache.commons.math3.geometry.spherical.twod;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.exception.MathInternalError;
import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;
import org.apache.commons.math3.geometry.partitioning.BSPTree;
import org.apache.commons.math3.geometry.partitioning.BSPTreeVisitor;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
class PropertiesComputer implements BSPTreeVisitor<Sphere2D> {
    private final double tolerance;
    private double summedArea = 0.0d;
    private Vector3D summedBarycenter = Vector3D.ZERO;
    private final List<Vector3D> convexCellsInsidePoints = new ArrayList();

    public PropertiesComputer(double d) {
        this.tolerance = d;
    }

    private double convexCellArea(Vertex vertex) {
        Edge outgoing = vertex.getOutgoing();
        int i5 = 0;
        double d = 0.0d;
        while (true) {
            if (i5 != 0 && outgoing.getStart() == vertex) {
                return d - (((double) (i5 - 2)) * 3.141592653589793d);
            }
            Vector3D pole = outgoing.getCircle().getPole();
            Vector3D pole2 = outgoing.getEnd().getOutgoing().getCircle().getPole();
            double dAtan2 = FastMath.atan2(Vector3D.dotProduct(pole2, Vector3D.crossProduct(outgoing.getEnd().getLocation().getVector(), pole)), -Vector3D.dotProduct(pole2, pole));
            if (dAtan2 < 0.0d) {
                dAtan2 += 6.283185307179586d;
            }
            d += dAtan2;
            i5++;
            outgoing = outgoing.getEnd().getOutgoing();
        }
    }

    private Vector3D convexCellBarycenter(Vertex vertex) {
        Vector3D vector3D = Vector3D.ZERO;
        Edge outgoing = vertex.getOutgoing();
        int i5 = 0;
        Vector3D vector3D2 = vector3D;
        while (true) {
            if (i5 != 0 && outgoing.getStart() == vertex) {
                return vector3D2.normalize();
            }
            Vector3D vector3D3 = new Vector3D(1.0d, vector3D2, outgoing.getLength(), outgoing.getCircle().getPole());
            i5++;
            outgoing = outgoing.getEnd().getOutgoing();
            vector3D2 = vector3D3;
        }
    }

    public double getArea() {
        return this.summedArea;
    }

    public S2Point getBarycenter() {
        return this.summedBarycenter.getNormSq() == 0.0d ? S2Point.NaN : new S2Point(this.summedBarycenter);
    }

    public List<Vector3D> getConvexCellsInsidePoints() {
        return this.convexCellsInsidePoints;
    }

    @Override // org.apache.commons.math3.geometry.partitioning.BSPTreeVisitor
    public void visitLeafNode(BSPTree<Sphere2D> bSPTree) {
        if (((Boolean) bSPTree.getAttribute()).booleanValue()) {
            List<Vertex> boundaryLoops = new SphericalPolygonsSet((BSPTree<Sphere2D>) bSPTree.pruneAroundConvexCell(Boolean.TRUE, Boolean.FALSE, null), this.tolerance).getBoundaryLoops();
            if (boundaryLoops.size() != 1) {
                throw new MathInternalError();
            }
            double dConvexCellArea = convexCellArea(boundaryLoops.get(0));
            Vector3D vector3DConvexCellBarycenter = convexCellBarycenter(boundaryLoops.get(0));
            this.convexCellsInsidePoints.add(vector3DConvexCellBarycenter);
            this.summedArea += dConvexCellArea;
            this.summedBarycenter = new Vector3D(1.0d, this.summedBarycenter, dConvexCellArea, vector3DConvexCellBarycenter);
        }
    }

    @Override // org.apache.commons.math3.geometry.partitioning.BSPTreeVisitor
    public BSPTreeVisitor.Order visitOrder(BSPTree<Sphere2D> bSPTree) {
        return BSPTreeVisitor.Order.MINUS_SUB_PLUS;
    }

    @Override // org.apache.commons.math3.geometry.partitioning.BSPTreeVisitor
    public void visitInternalNode(BSPTree<Sphere2D> bSPTree) {
    }
}
