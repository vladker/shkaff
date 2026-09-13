package org.apache.commons.math3.geometry.spherical.twod;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.math3.geometry.enclosing.EnclosingBall;
import org.apache.commons.math3.geometry.enclosing.WelzlEncloser;
import org.apache.commons.math3.geometry.euclidean.threed.Rotation;
import org.apache.commons.math3.geometry.euclidean.threed.RotationConvention;
import org.apache.commons.math3.geometry.euclidean.threed.SphereGenerator;
import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;
import org.apache.commons.math3.geometry.partitioning.AbstractRegion;
import org.apache.commons.math3.geometry.partitioning.BSPTree;
import org.apache.commons.math3.geometry.partitioning.BoundaryProjection;
import org.apache.commons.math3.geometry.partitioning.Region;
import org.apache.commons.math3.geometry.partitioning.RegionFactory;
import org.apache.commons.math3.geometry.partitioning.SubHyperplane;
import org.apache.commons.math3.geometry.spherical.oned.Sphere1D;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class SphericalPolygonsSet extends AbstractRegion<Sphere2D, Sphere1D> {
    private List<Vertex> loops;

    public SphericalPolygonsSet(double d) {
        super(d);
    }

    private static S2Point[] createRegularPolygonVertices(Vector3D vector3D, Vector3D vector3D2, double d, int i5) {
        S2Point[] s2PointArr = new S2Point[i5];
        Vector3D vector3DCrossProduct = Vector3D.crossProduct(vector3D, vector3D2);
        RotationConvention rotationConvention = RotationConvention.VECTOR_OPERATOR;
        s2PointArr[0] = new S2Point(new Rotation(vector3DCrossProduct, d, rotationConvention).applyTo(vector3D));
        Rotation rotation = new Rotation(vector3D, 6.283185307179586d / ((double) i5), rotationConvention);
        for (int i6 = 1; i6 < i5; i6++) {
            s2PointArr[i6] = new S2Point(rotation.applyTo(s2PointArr[i6 - 1].getVector()));
        }
        return s2PointArr;
    }

    private List<Vector3D> getInsidePoints() {
        PropertiesComputer propertiesComputer = new PropertiesComputer(getTolerance());
        getTree(true).visit(propertiesComputer);
        return propertiesComputer.getConvexCellsInsidePoints();
    }

    private List<Vector3D> getOutsidePoints() {
        SphericalPolygonsSet sphericalPolygonsSet = (SphericalPolygonsSet) new RegionFactory().getComplement(this);
        PropertiesComputer propertiesComputer = new PropertiesComputer(getTolerance());
        sphericalPolygonsSet.getTree(true).visit(propertiesComputer);
        return propertiesComputer.getConvexCellsInsidePoints();
    }

    private static void insertEdges(double d, BSPTree<Sphere2D> bSPTree, List<Edge> list) {
        Edge edge;
        int i5;
        int i6 = 0;
        loop0: while (true) {
            edge = null;
            while (true) {
                if (edge != null || i6 >= list.size()) {
                    break loop0;
                }
                i5 = i6 + 1;
                Edge edge2 = list.get(i6);
                if (!bSPTree.insertCut(edge2.getCircle())) {
                    break;
                }
                edge = edge2;
                i6 = i5;
            }
            i6 = i5;
        }
        if (edge == null) {
            BSPTree<S> parent = bSPTree.getParent();
            if (parent == 0 || bSPTree == parent.getMinus()) {
                bSPTree.setAttribute(Boolean.TRUE);
                return;
            } else {
                bSPTree.setAttribute(Boolean.FALSE);
                return;
            }
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Edge edge3 : list) {
            if (edge3 != edge) {
                edge3.split(edge.getCircle(), arrayList, arrayList2);
            }
        }
        if (arrayList.isEmpty()) {
            bSPTree.getPlus().setAttribute(Boolean.FALSE);
        } else {
            insertEdges(d, bSPTree.getPlus(), arrayList);
        }
        if (arrayList2.isEmpty()) {
            bSPTree.getMinus().setAttribute(Boolean.TRUE);
        } else {
            insertEdges(d, bSPTree.getMinus(), arrayList2);
        }
    }

    private static BSPTree<Sphere2D> verticesToTree(double d, S2Point... s2PointArr) {
        int length = s2PointArr.length;
        if (length == 0) {
            return new BSPTree<>(Boolean.TRUE);
        }
        Vertex[] vertexArr = new Vertex[length];
        for (int i5 = 0; i5 < length; i5++) {
            vertexArr[i5] = new Vertex(s2PointArr[i5]);
        }
        ArrayList arrayList = new ArrayList(length);
        Vertex vertex = vertexArr[length - 1];
        int i6 = 0;
        while (i6 < length) {
            Vertex vertex2 = vertexArr[i6];
            Circle circleSharedCircleWith = vertex.sharedCircleWith(vertex2);
            if (circleSharedCircleWith == null) {
                circleSharedCircleWith = new Circle(vertex.getLocation(), vertex2.getLocation(), d);
            }
            Circle circle = circleSharedCircleWith;
            arrayList.add(new Edge(vertex, vertex2, Vector3D.angle(vertex.getLocation().getVector(), vertex2.getLocation().getVector()), circle));
            for (int i7 = 0; i7 < length; i7++) {
                Vertex vertex3 = vertexArr[i7];
                if (vertex3 != vertex && vertex3 != vertex2 && FastMath.abs(circle.getOffset(vertex3.getLocation())) <= d) {
                    vertex3.bindWith(circle);
                }
            }
            i6++;
            vertex = vertex2;
        }
        BSPTree<Sphere2D> bSPTree = new BSPTree<>();
        insertEdges(d, bSPTree, arrayList);
        return bSPTree;
    }

    @Override // org.apache.commons.math3.geometry.partitioning.AbstractRegion, org.apache.commons.math3.geometry.partitioning.Region
    public /* bridge */ /* synthetic */ AbstractRegion buildNew(BSPTree bSPTree) {
        return buildNew((BSPTree<Sphere2D>) bSPTree);
    }

    @Override // org.apache.commons.math3.geometry.partitioning.AbstractRegion
    public void computeGeometricalProperties() {
        BSPTree<Sphere2D> tree = getTree(true);
        if (tree.getCut() != null) {
            PropertiesComputer propertiesComputer = new PropertiesComputer(getTolerance());
            tree.visit(propertiesComputer);
            setSize(propertiesComputer.getArea());
            setBarycenter(propertiesComputer.getBarycenter());
            return;
        }
        if (tree.getCut() == null && ((Boolean) tree.getAttribute()).booleanValue()) {
            setSize(12.566370614359172d);
            setBarycenter(new S2Point(0.0d, 0.0d));
        } else {
            setSize(0.0d);
            setBarycenter(S2Point.NaN);
        }
    }

    public List<Vertex> getBoundaryLoops() {
        if (this.loops == null) {
            if (getTree(false).getCut() == null) {
                this.loops = Collections.EMPTY_LIST;
            } else {
                BSPTree<Sphere2D> tree = getTree(true);
                EdgesBuilder edgesBuilder = new EdgesBuilder(tree, getTolerance());
                tree.visit(edgesBuilder);
                List<Edge> edges = edgesBuilder.getEdges();
                this.loops = new ArrayList();
                while (!edges.isEmpty()) {
                    Edge outgoing = edges.get(0);
                    Vertex start = outgoing.getStart();
                    this.loops.add(start);
                    do {
                        Iterator<Edge> it = edges.iterator();
                        while (it.hasNext()) {
                            if (it.next() == outgoing) {
                                it.remove();
                                break;
                            }
                        }
                        outgoing = outgoing.getEnd().getOutgoing();
                    } while (outgoing.getStart() != start);
                }
            }
        }
        return Collections.unmodifiableList(this.loops);
    }

    public EnclosingBall<Sphere2D, S2Point> getEnclosingCap() {
        if (isEmpty()) {
            return new EnclosingBall<>(S2Point.PLUS_K, Double.NEGATIVE_INFINITY, new S2Point[0]);
        }
        if (isFull()) {
            return new EnclosingBall<>(S2Point.PLUS_K, Double.POSITIVE_INFINITY, new S2Point[0]);
        }
        BSPTree<Sphere2D> tree = getTree(false);
        if (isEmpty(tree.getMinus()) && isFull(tree.getPlus())) {
            return new EnclosingBall<>(new S2Point(((Circle) tree.getCut().getHyperplane()).getPole()).negate(), 1.5707963267948966d, new S2Point[0]);
        }
        if (isFull(tree.getMinus()) && isEmpty(tree.getPlus())) {
            return new EnclosingBall<>(new S2Point(((Circle) tree.getCut().getHyperplane()).getPole()), 1.5707963267948966d, new S2Point[0]);
        }
        List<Vector3D> insidePoints = getInsidePoints();
        for (Vertex vertex : getBoundaryLoops()) {
            int i5 = 0;
            Vertex end = vertex;
            while (true) {
                if (i5 == 0 || end != vertex) {
                    i5++;
                    insidePoints.add(end.getLocation().getVector());
                    end = end.getOutgoing().getEnd();
                }
            }
        }
        EnclosingBall enclosingBallEnclose = new WelzlEncloser(getTolerance(), new SphereGenerator()).enclose(insidePoints);
        Vector3D[] vector3DArr = (Vector3D[]) enclosingBallEnclose.getSupport();
        double radius = enclosingBallEnclose.getRadius();
        double norm = ((Vector3D) enclosingBallEnclose.getCenter()).getNorm();
        if (norm >= getTolerance()) {
            S2Point[] s2PointArr = new S2Point[vector3DArr.length];
            for (int i6 = 0; i6 < vector3DArr.length; i6++) {
                s2PointArr[i6] = new S2Point(vector3DArr[i6]);
            }
            return new EnclosingBall<>(new S2Point((Vector3D) enclosingBallEnclose.getCenter()), FastMath.acos((((norm * norm) + 1.0d) - (radius * radius)) / (norm * 2.0d)), s2PointArr);
        }
        EnclosingBall<Sphere2D, S2Point> enclosingBall = new EnclosingBall<>(S2Point.PLUS_K, Double.POSITIVE_INFINITY, new S2Point[0]);
        Iterator<Vector3D> it = getOutsidePoints().iterator();
        while (it.hasNext()) {
            S2Point s2Point = new S2Point(it.next());
            BoundaryProjection<Sphere2D> boundaryProjectionProjectToBoundary = projectToBoundary(s2Point);
            if (3.141592653589793d - boundaryProjectionProjectToBoundary.getOffset() < enclosingBall.getRadius()) {
                enclosingBall = new EnclosingBall<>(s2Point.negate(), 3.141592653589793d - boundaryProjectionProjectToBoundary.getOffset(), (S2Point) boundaryProjectionProjectToBoundary.getProjected());
            }
        }
        return enclosingBall;
    }

    public SphericalPolygonsSet(Vector3D vector3D, double d) {
        super(new BSPTree(new Circle(vector3D, d).wholeHyperplane(), new BSPTree(Boolean.FALSE), new BSPTree(Boolean.TRUE), null), d);
    }

    @Override // org.apache.commons.math3.geometry.partitioning.AbstractRegion, org.apache.commons.math3.geometry.partitioning.Region
    public /* bridge */ /* synthetic */ Region buildNew(BSPTree bSPTree) {
        return buildNew((BSPTree<Sphere2D>) bSPTree);
    }

    public SphericalPolygonsSet(Vector3D vector3D, Vector3D vector3D2, double d, int i5, double d6) {
        this(d6, createRegularPolygonVertices(vector3D, vector3D2, d, i5));
    }

    @Override // org.apache.commons.math3.geometry.partitioning.AbstractRegion, org.apache.commons.math3.geometry.partitioning.Region
    public SphericalPolygonsSet buildNew(BSPTree<Sphere2D> bSPTree) {
        return new SphericalPolygonsSet(bSPTree, getTolerance());
    }

    public SphericalPolygonsSet(BSPTree<Sphere2D> bSPTree, double d) {
        super(bSPTree, d);
    }

    public SphericalPolygonsSet(Collection<SubHyperplane<Sphere2D>> collection, double d) {
        super(collection, d);
    }

    public SphericalPolygonsSet(double d, S2Point... s2PointArr) {
        super(verticesToTree(d, s2PointArr), d);
    }
}
