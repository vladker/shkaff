package org.apache.commons.math3.geometry.euclidean.twod;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.math3.geometry.Point;
import org.apache.commons.math3.geometry.euclidean.oned.Euclidean1D;
import org.apache.commons.math3.geometry.euclidean.oned.Interval;
import org.apache.commons.math3.geometry.euclidean.oned.IntervalsSet;
import org.apache.commons.math3.geometry.euclidean.oned.Vector1D;
import org.apache.commons.math3.geometry.partitioning.AbstractRegion;
import org.apache.commons.math3.geometry.partitioning.AbstractSubHyperplane;
import org.apache.commons.math3.geometry.partitioning.BSPTree;
import org.apache.commons.math3.geometry.partitioning.BSPTreeVisitor;
import org.apache.commons.math3.geometry.partitioning.BoundaryAttribute;
import org.apache.commons.math3.geometry.partitioning.Hyperplane;
import org.apache.commons.math3.geometry.partitioning.NodesSet;
import org.apache.commons.math3.geometry.partitioning.Region;
import org.apache.commons.math3.geometry.partitioning.Side;
import org.apache.commons.math3.geometry.partitioning.SubHyperplane;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class PolygonsSet extends AbstractRegion<Euclidean2D, Euclidean1D> {
    private static final double DEFAULT_TOLERANCE = 1.0E-10d;
    private Vector2D[][] vertices;

    /* JADX INFO: renamed from: org.apache.commons.math3.geometry.euclidean.twod.PolygonsSet$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$math3$geometry$partitioning$Side;

        static {
            int[] iArr = new int[Side.values().length];
            $SwitchMap$org$apache$commons$math3$geometry$partitioning$Side = iArr;
            try {
                iArr[Side.PLUS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$commons$math3$geometry$partitioning$Side[Side.MINUS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class ConnectableSegment extends Segment {
        private final BSPTree<Euclidean2D> endNode;
        private ConnectableSegment next;
        private final BSPTree<Euclidean2D> node;
        private ConnectableSegment previous;
        private boolean processed;
        private final BSPTree<Euclidean2D> startNode;

        public ConnectableSegment(Vector2D vector2D, Vector2D vector2D2, Line line, BSPTree<Euclidean2D> bSPTree, BSPTree<Euclidean2D> bSPTree2, BSPTree<Euclidean2D> bSPTree3) {
            super(vector2D, vector2D2, line);
            this.node = bSPTree;
            this.startNode = bSPTree2;
            this.endNode = bSPTree3;
            this.previous = null;
            this.next = null;
            this.processed = false;
        }

        public BSPTree<Euclidean2D> getEndNode() {
            return this.endNode;
        }

        public ConnectableSegment getNext() {
            return this.next;
        }

        public BSPTree<Euclidean2D> getNode() {
            return this.node;
        }

        public ConnectableSegment getPrevious() {
            return this.previous;
        }

        public BSPTree<Euclidean2D> getStartNode() {
            return this.startNode;
        }

        public boolean isProcessed() {
            return this.processed;
        }

        public void setNext(ConnectableSegment connectableSegment) {
            this.next = connectableSegment;
        }

        public void setPrevious(ConnectableSegment connectableSegment) {
            this.previous = connectableSegment;
        }

        public void setProcessed(boolean z6) {
            this.processed = z6;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class Edge {
        private final Vertex end;
        private final Line line;
        private BSPTree<Euclidean2D> node = null;
        private final Vertex start;

        public Edge(Vertex vertex, Vertex vertex2, Line line) {
            this.start = vertex;
            this.end = vertex2;
            this.line = line;
            vertex.setOutgoing(this);
            vertex2.setIncoming(this);
        }

        public Vertex getEnd() {
            return this.end;
        }

        public Line getLine() {
            return this.line;
        }

        public BSPTree<Euclidean2D> getNode() {
            return this.node;
        }

        public Vertex getStart() {
            return this.start;
        }

        public void setNode(BSPTree<Euclidean2D> bSPTree) {
            this.node = bSPTree;
        }

        public Vertex split(Line line) {
            Vertex vertex = new Vertex(this.line.intersection(line));
            vertex.bindWith(line);
            Edge edge = new Edge(this.start, vertex, this.line);
            Edge edge2 = new Edge(vertex, this.end, this.line);
            edge.node = this.node;
            edge2.node = this.node;
            return vertex;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class Vertex {
        private final Vector2D location;
        private Edge incoming = null;
        private Edge outgoing = null;
        private final List<Line> lines = new ArrayList();

        public Vertex(Vector2D vector2D) {
            this.location = vector2D;
        }

        public void bindWith(Line line) {
            this.lines.add(line);
        }

        public Edge getIncoming() {
            return this.incoming;
        }

        public Vector2D getLocation() {
            return this.location;
        }

        public Edge getOutgoing() {
            return this.outgoing;
        }

        public void setIncoming(Edge edge) {
            this.incoming = edge;
            bindWith(edge.getLine());
        }

        public void setOutgoing(Edge edge) {
            this.outgoing = edge;
            bindWith(edge.getLine());
        }

        public Line sharedLineWith(Vertex vertex) {
            for (Line line : this.lines) {
                Iterator<Line> it = vertex.lines.iterator();
                while (it.hasNext()) {
                    if (line == it.next()) {
                        return line;
                    }
                }
            }
            return null;
        }
    }

    public PolygonsSet(double d) {
        super(d);
    }

    private static Line[] boxBoundary(double d, double d6, double d7, double d8, double d9) {
        if (d >= d6 - d9 || d7 >= d8 - d9) {
            return null;
        }
        Vector2D vector2D = new Vector2D(d, d7);
        Vector2D vector2D2 = new Vector2D(d, d8);
        Vector2D vector2D3 = new Vector2D(d6, d7);
        Vector2D vector2D4 = new Vector2D(d6, d8);
        return new Line[]{new Line(vector2D, vector2D3, d9), new Line(vector2D3, vector2D4, d9), new Line(vector2D4, vector2D2, d9), new Line(vector2D2, vector2D, d9)};
    }

    private int closeVerticesConnections(List<ConnectableSegment> list) {
        int i5 = 0;
        for (ConnectableSegment connectableSegment : list) {
            if (connectableSegment.getNext() == null && connectableSegment.getEnd() != null) {
                Vector2D end = connectableSegment.getEnd();
                ConnectableSegment connectableSegment2 = null;
                double d = Double.POSITIVE_INFINITY;
                for (ConnectableSegment connectableSegment3 : list) {
                    if (connectableSegment3.getPrevious() == null && connectableSegment3.getStart() != null) {
                        double dDistance = Vector2D.distance(end, connectableSegment3.getStart());
                        if (dDistance < d) {
                            connectableSegment2 = connectableSegment3;
                            d = dDistance;
                        }
                    }
                }
                if (d <= getTolerance()) {
                    connectableSegment.setNext(connectableSegment2);
                    connectableSegment2.setPrevious(connectableSegment);
                    i5++;
                }
            }
        }
        return i5;
    }

    private void filterSpuriousVertices(List<Segment> list) {
        int i5 = 0;
        while (i5 < list.size()) {
            Segment segment = list.get(i5);
            int size = (i5 + 1) % list.size();
            Segment segment2 = list.get(size);
            if (segment2 != null && Precision.equals(segment.getLine().getAngle(), segment2.getLine().getAngle(), Precision.EPSILON)) {
                list.set(size, new Segment(segment.getStart(), segment2.getEnd(), segment.getLine()));
                list.remove(i5);
                i5--;
            }
            i5++;
        }
    }

    private List<Segment> followLoop(ConnectableSegment connectableSegment) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(connectableSegment);
        connectableSegment.setProcessed(true);
        ConnectableSegment next = connectableSegment.getNext();
        while (next != connectableSegment && next != null) {
            arrayList.add(next);
            next.setProcessed(true);
            next = next.getNext();
        }
        if (next == null) {
            for (ConnectableSegment previous = connectableSegment.getPrevious(); previous != null; previous = previous.getPrevious()) {
                arrayList.add(0, previous);
                previous.setProcessed(true);
            }
        }
        filterSpuriousVertices(arrayList);
        if (arrayList.size() != 2 || ((Segment) arrayList.get(0)).getStart() == null) {
            return arrayList;
        }
        return null;
    }

    private ConnectableSegment getUnprocessed(List<ConnectableSegment> list) {
        for (ConnectableSegment connectableSegment : list) {
            if (!connectableSegment.isProcessed()) {
                return connectableSegment;
            }
        }
        return null;
    }

    private static void insertEdges(double d, BSPTree<Euclidean2D> bSPTree, List<Edge> list) {
        Edge edge;
        int i5 = 0;
        loop0: while (true) {
            edge = null;
            while (edge == null && i5 < list.size()) {
                int i6 = i5 + 1;
                Edge edge2 = list.get(i5);
                if (edge2.getNode() == null && bSPTree.insertCut(edge2.getLine())) {
                    edge2.setNode(bSPTree);
                    edge = edge2;
                    i5 = i6;
                } else {
                    i5 = i6;
                }
            }
            break loop0;
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
                double offset = edge.getLine().getOffset((Point<Euclidean2D>) edge3.getStart().getLocation());
                double offset2 = edge.getLine().getOffset((Point<Euclidean2D>) edge3.getEnd().getLocation());
                Side side = FastMath.abs(offset) <= d ? Side.HYPER : offset < 0.0d ? Side.MINUS : Side.PLUS;
                Side side2 = FastMath.abs(offset2) <= d ? Side.HYPER : offset2 < 0.0d ? Side.MINUS : Side.PLUS;
                int i7 = AnonymousClass1.$SwitchMap$org$apache$commons$math3$geometry$partitioning$Side[side.ordinal()];
                if (i7 != 1) {
                    if (i7 != 2) {
                        if (side2 == Side.PLUS) {
                            arrayList.add(edge3);
                        } else if (side2 == Side.MINUS) {
                            arrayList2.add(edge3);
                        }
                    } else if (side2 == Side.PLUS) {
                        Vertex vertexSplit = edge3.split(edge.getLine());
                        arrayList2.add(vertexSplit.getIncoming());
                        arrayList.add(vertexSplit.getOutgoing());
                    } else {
                        arrayList2.add(edge3);
                    }
                } else if (side2 == Side.MINUS) {
                    Vertex vertexSplit2 = edge3.split(edge.getLine());
                    arrayList2.add(vertexSplit2.getOutgoing());
                    arrayList.add(vertexSplit2.getIncoming());
                } else {
                    arrayList.add(edge3);
                }
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

    private int naturalFollowerConnections(List<ConnectableSegment> list) {
        int i5 = 0;
        for (ConnectableSegment connectableSegment : list) {
            if (connectableSegment.getNext() == null) {
                BSPTree<Euclidean2D> node = connectableSegment.getNode();
                BSPTree<Euclidean2D> endNode = connectableSegment.getEndNode();
                for (ConnectableSegment connectableSegment2 : list) {
                    if (connectableSegment2.getPrevious() == null && connectableSegment2.getNode() == endNode && connectableSegment2.getStartNode() == node) {
                        connectableSegment.setNext(connectableSegment2);
                        connectableSegment2.setPrevious(connectableSegment);
                        i5++;
                        break;
                    }
                }
            }
        }
        return i5;
    }

    private int splitEdgeConnections(List<ConnectableSegment> list) {
        int i5 = 0;
        for (ConnectableSegment connectableSegment : list) {
            if (connectableSegment.getNext() == null) {
                Hyperplane hyperplane = connectableSegment.getNode().getCut().getHyperplane();
                BSPTree<Euclidean2D> endNode = connectableSegment.getEndNode();
                for (ConnectableSegment connectableSegment2 : list) {
                    if (connectableSegment2.getPrevious() == null && connectableSegment2.getNode().getCut().getHyperplane() == hyperplane && connectableSegment2.getStartNode() == endNode) {
                        connectableSegment.setNext(connectableSegment2);
                        connectableSegment2.setPrevious(connectableSegment);
                        i5++;
                        break;
                    }
                }
            }
        }
        return i5;
    }

    private static BSPTree<Euclidean2D> verticesToTree(double d, Vector2D... vector2DArr) {
        int length = vector2DArr.length;
        if (length == 0) {
            return new BSPTree<>(Boolean.TRUE);
        }
        Vertex[] vertexArr = new Vertex[length];
        for (int i5 = 0; i5 < length; i5++) {
            vertexArr[i5] = new Vertex(vector2DArr[i5]);
        }
        ArrayList arrayList = new ArrayList(length);
        int i6 = 0;
        while (i6 < length) {
            Vertex vertex = vertexArr[i6];
            i6++;
            Vertex vertex2 = vertexArr[i6 % length];
            Line lineSharedLineWith = vertex.sharedLineWith(vertex2);
            if (lineSharedLineWith == null) {
                lineSharedLineWith = new Line(vertex.getLocation(), vertex2.getLocation(), d);
            }
            arrayList.add(new Edge(vertex, vertex2, lineSharedLineWith));
            for (int i7 = 0; i7 < length; i7++) {
                Vertex vertex3 = vertexArr[i7];
                if (vertex3 != vertex && vertex3 != vertex2 && FastMath.abs(lineSharedLineWith.getOffset((Point<Euclidean2D>) vertex3.getLocation())) <= d) {
                    vertex3.bindWith(lineSharedLineWith);
                }
            }
        }
        BSPTree<Euclidean2D> bSPTree = new BSPTree<>();
        insertEdges(d, bSPTree, arrayList);
        return bSPTree;
    }

    @Override // org.apache.commons.math3.geometry.partitioning.AbstractRegion, org.apache.commons.math3.geometry.partitioning.Region
    public /* bridge */ /* synthetic */ AbstractRegion buildNew(BSPTree bSPTree) {
        return buildNew((BSPTree<Euclidean2D>) bSPTree);
    }

    @Override // org.apache.commons.math3.geometry.partitioning.AbstractRegion
    public void computeGeometricalProperties() {
        Vector2D[][] vertices = getVertices();
        double d = 0.0d;
        if (vertices.length == 0) {
            BSPTree<Euclidean2D> tree = getTree(false);
            if (tree.getCut() == null && ((Boolean) tree.getAttribute()).booleanValue()) {
                setSize(Double.POSITIVE_INFINITY);
                setBarycenter((Point) Vector2D.NaN);
                return;
            } else {
                setSize(0.0d);
                setBarycenter((Point) new Vector2D(0.0d, 0.0d));
                return;
            }
        }
        if (vertices[0][0] == null) {
            setSize(Double.POSITIVE_INFINITY);
            setBarycenter((Point) Vector2D.NaN);
            return;
        }
        int length = vertices.length;
        int i5 = 0;
        double d6 = 0.0d;
        double d7 = 0.0d;
        double d8 = 0.0d;
        while (i5 < length) {
            Vector2D[] vector2DArr = vertices[i5];
            double x6 = vector2DArr[vector2DArr.length - 1].getX();
            double y6 = vector2DArr[vector2DArr.length - 1].getY();
            int length2 = vector2DArr.length;
            double d9 = d;
            int i6 = 0;
            while (i6 < length2) {
                Vector2D vector2D = vector2DArr[i6];
                double x7 = vector2D.getX();
                double y7 = vector2D.getY();
                double d10 = (x6 * y7) - (y6 * x7);
                d6 += d10;
                d7 = ((x6 + x7) * d10) + d7;
                d8 = ((y6 + y7) * d10) + d8;
                i6++;
                x6 = x7;
                y6 = y7;
            }
            i5++;
            d = d9;
        }
        if (d6 < d) {
            setSize(Double.POSITIVE_INFINITY);
            setBarycenter((Point) Vector2D.NaN);
        } else {
            setSize(d6 / 2.0d);
            double d11 = d6 * 3.0d;
            setBarycenter((Point) new Vector2D(d7 / d11, d8 / d11));
        }
    }

    public Vector2D[][] getVertices() {
        int i5;
        Vector2D[] vector2DArr;
        double d;
        if (this.vertices == null) {
            if (getTree(false).getCut() == null) {
                this.vertices = new Vector2D[0][];
            } else {
                SegmentsBuilder segmentsBuilder = new SegmentsBuilder(getTolerance());
                int i6 = 1;
                getTree(true).visit(segmentsBuilder);
                List<ConnectableSegment> segments = segmentsBuilder.getSegments();
                int size = segments.size() - naturalFollowerConnections(segments);
                if (size > 0) {
                    size -= splitEdgeConnections(segments);
                }
                if (size > 0) {
                    closeVerticesConnections(segments);
                }
                ArrayList arrayList = new ArrayList();
                while (true) {
                    ConnectableSegment unprocessed = getUnprocessed(segments);
                    if (unprocessed == null) {
                        break;
                    }
                    List<Segment> listFollowLoop = followLoop(unprocessed);
                    if (listFollowLoop != null) {
                        if (listFollowLoop.get(0).getStart() == null) {
                            arrayList.add(0, listFollowLoop);
                        } else {
                            arrayList.add(listFollowLoop);
                        }
                    }
                }
                this.vertices = new Vector2D[arrayList.size()][];
                int size2 = arrayList.size();
                int i7 = 0;
                int i8 = 0;
                while (i8 < size2) {
                    Object obj = arrayList.get(i8);
                    i8++;
                    List<Segment> list = (List) obj;
                    if (list.size() < 2 || (list.size() == 2 && ((Segment) list.get(0)).getStart() == null && ((Segment) list.get(i6)).getEnd() == null)) {
                        Line line = ((Segment) list.get(0)).getLine();
                        i5 = i7 + 1;
                        this.vertices[i7] = new Vector2D[]{null, line.toSpace((Point<Euclidean1D>) new Vector1D(-3.4028234663852886E38d)), line.toSpace((Point<Euclidean1D>) new Vector1D(3.4028234663852886E38d))};
                    } else {
                        if (((Segment) list.get(0)).getStart() == null) {
                            int size3 = list.size();
                            Vector2D[] vector2DArr2 = new Vector2D[size3 + 2];
                            int i9 = 0;
                            for (Segment segment : list) {
                                ArrayList arrayList2 = arrayList;
                                if (i9 == 0) {
                                    d = 2.0d;
                                    double x6 = segment.getLine().toSubSpace((Point<Euclidean2D>) segment.getEnd()).getX();
                                    vector2DArr = vector2DArr2;
                                    double dMax = x6 - FastMath.max(1.0d, FastMath.abs(x6 / 2.0d));
                                    int i10 = i9 + 1;
                                    vector2DArr[i9] = null;
                                    i9 += 2;
                                    vector2DArr[i10] = segment.getLine().toSpace((Point<Euclidean1D>) new Vector1D(dMax));
                                } else {
                                    vector2DArr = vector2DArr2;
                                    d = 2.0d;
                                }
                                int i11 = size3 + 1;
                                if (i9 < i11) {
                                    vector2DArr[i9] = segment.getEnd();
                                    i9++;
                                }
                                if (i9 == i11) {
                                    double x7 = segment.getLine().toSubSpace((Point<Euclidean2D>) segment.getStart()).getX();
                                    vector2DArr[i9] = segment.getLine().toSpace((Point<Euclidean1D>) new Vector1D(FastMath.max(1.0d, FastMath.abs(x7 / d)) + x7));
                                    i9++;
                                }
                                arrayList = arrayList2;
                                vector2DArr2 = vector2DArr;
                            }
                            arrayList = arrayList;
                            this.vertices[i7] = vector2DArr2;
                            i7++;
                        } else {
                            Vector2D[] vector2DArr3 = new Vector2D[list.size()];
                            Iterator it = list.iterator();
                            int i12 = 0;
                            while (it.hasNext()) {
                                vector2DArr3[i12] = ((Segment) it.next()).getStart();
                                i12++;
                            }
                            i5 = i7 + 1;
                            this.vertices[i7] = vector2DArr3;
                        }
                        arrayList = arrayList;
                        i6 = 1;
                    }
                    i7 = i5;
                    arrayList = arrayList;
                    i6 = 1;
                }
            }
        }
        return (Vector2D[][]) this.vertices.clone();
    }

    public PolygonsSet(BSPTree<Euclidean2D> bSPTree, double d) {
        super(bSPTree, d);
    }

    @Override // org.apache.commons.math3.geometry.partitioning.AbstractRegion, org.apache.commons.math3.geometry.partitioning.Region
    public /* bridge */ /* synthetic */ Region buildNew(BSPTree bSPTree) {
        return buildNew((BSPTree<Euclidean2D>) bSPTree);
    }

    public PolygonsSet(Collection<SubHyperplane<Euclidean2D>> collection, double d) {
        super(collection, d);
    }

    @Override // org.apache.commons.math3.geometry.partitioning.AbstractRegion, org.apache.commons.math3.geometry.partitioning.Region
    public PolygonsSet buildNew(BSPTree<Euclidean2D> bSPTree) {
        return new PolygonsSet(bSPTree, getTolerance());
    }

    public PolygonsSet(double d, double d6, double d7, double d8, double d9) {
        super(boxBoundary(d, d6, d7, d8, d9), d9);
    }

    public PolygonsSet(double d, Vector2D... vector2DArr) {
        super(verticesToTree(d, vector2DArr), d);
    }

    @Deprecated
    public PolygonsSet() {
        this(1.0E-10d);
    }

    @Deprecated
    public PolygonsSet(BSPTree<Euclidean2D> bSPTree) {
        this(bSPTree, 1.0E-10d);
    }

    @Deprecated
    public PolygonsSet(Collection<SubHyperplane<Euclidean2D>> collection) {
        this(collection, 1.0E-10d);
    }

    @Deprecated
    public PolygonsSet(double d, double d6, double d7, double d8) {
        this(d, d6, d7, d8, 1.0E-10d);
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class SegmentsBuilder implements BSPTreeVisitor<Euclidean2D> {
        private final List<ConnectableSegment> segments = new ArrayList();
        private final double tolerance;

        public SegmentsBuilder(double d) {
            this.tolerance = d;
        }

        private void addContribution(SubHyperplane<Euclidean2D> subHyperplane, BSPTree<Euclidean2D> bSPTree, Iterable<BSPTree<Euclidean2D>> iterable, boolean z6) {
            Line line = (Line) subHyperplane.getHyperplane();
            for (Interval interval : ((IntervalsSet) ((AbstractSubHyperplane) subHyperplane).getRemainingRegion()).asList()) {
                Vector2D space = Double.isInfinite(interval.getInf()) ? null : line.toSpace((Point<Euclidean1D>) new Vector1D(interval.getInf()));
                Vector2D space2 = Double.isInfinite(interval.getSup()) ? null : line.toSpace((Point<Euclidean1D>) new Vector1D(interval.getSup()));
                BSPTree<Euclidean2D> bSPTreeSelectClosest = selectClosest(space, iterable);
                BSPTree<Euclidean2D> bSPTreeSelectClosest2 = selectClosest(space2, iterable);
                if (z6) {
                    this.segments.add(new ConnectableSegment(space2, space, line.getReverse(), bSPTree, bSPTreeSelectClosest2, bSPTreeSelectClosest));
                } else {
                    this.segments.add(new ConnectableSegment(space, space2, line, bSPTree, bSPTreeSelectClosest, bSPTreeSelectClosest2));
                }
            }
        }

        private BSPTree<Euclidean2D> selectClosest(Vector2D vector2D, Iterable<BSPTree<Euclidean2D>> iterable) {
            double d = Double.POSITIVE_INFINITY;
            BSPTree<Euclidean2D> bSPTree = null;
            for (BSPTree<Euclidean2D> bSPTree2 : iterable) {
                double dAbs = FastMath.abs(bSPTree2.getCut().getHyperplane().getOffset(vector2D));
                if (dAbs < d) {
                    bSPTree = bSPTree2;
                    d = dAbs;
                }
            }
            if (d <= this.tolerance) {
                return bSPTree;
            }
            return null;
        }

        public List<ConnectableSegment> getSegments() {
            return this.segments;
        }

        @Override // org.apache.commons.math3.geometry.partitioning.BSPTreeVisitor
        public void visitInternalNode(BSPTree<Euclidean2D> bSPTree) {
            BoundaryAttribute boundaryAttribute = (BoundaryAttribute) bSPTree.getAttribute();
            NodesSet splitters = boundaryAttribute.getSplitters();
            if (boundaryAttribute.getPlusOutside() != null) {
                addContribution(boundaryAttribute.getPlusOutside(), bSPTree, splitters, false);
            }
            if (boundaryAttribute.getPlusInside() != null) {
                addContribution(boundaryAttribute.getPlusInside(), bSPTree, splitters, true);
            }
        }

        @Override // org.apache.commons.math3.geometry.partitioning.BSPTreeVisitor
        public BSPTreeVisitor.Order visitOrder(BSPTree<Euclidean2D> bSPTree) {
            return BSPTreeVisitor.Order.MINUS_SUB_PLUS;
        }

        @Override // org.apache.commons.math3.geometry.partitioning.BSPTreeVisitor
        public void visitLeafNode(BSPTree<Euclidean2D> bSPTree) {
        }
    }
}
