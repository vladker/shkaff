package org.apache.commons.math3.geometry.spherical.twod;

import java.util.List;
import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;
import org.apache.commons.math3.geometry.spherical.oned.Arc;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Edge {
    private final Circle circle;
    private Vertex end;
    private final double length;
    private final Vertex start;

    public Edge(Vertex vertex, Vertex vertex2, double d, Circle circle) {
        this.start = vertex;
        this.end = vertex2;
        this.length = d;
        this.circle = circle;
        vertex.setOutgoing(this);
        vertex2.setIncoming(this);
    }

    private Vertex addSubEdge(Vertex vertex, Vertex vertex2, double d, List<Edge> list, Circle circle) {
        if (d <= this.circle.getTolerance()) {
            return vertex;
        }
        vertex2.bindWith(circle);
        list.add(new Edge(vertex, vertex2, d, this.circle));
        return vertex2;
    }

    public Circle getCircle() {
        return this.circle;
    }

    public Vertex getEnd() {
        return this.end;
    }

    public double getLength() {
        return this.length;
    }

    public Vector3D getPointAt(double d) {
        Circle circle = this.circle;
        return circle.getPointAt(circle.getPhase(this.start.getLocation().getVector()) + d);
    }

    public Vertex getStart() {
        return this.start;
    }

    public void setNextEdge(Edge edge) {
        Vertex start = edge.getStart();
        this.end = start;
        start.setIncoming(this);
        this.end.bindWith(getCircle());
    }

    public void split(Circle circle, List<Edge> list, List<Edge> list2) {
        Vertex vertexAddSubEdge;
        double d;
        double phase = this.circle.getPhase(this.start.getLocation().getVector());
        Arc insideArc = this.circle.getInsideArc(circle);
        double dNormalizeAngle = MathUtils.normalizeAngle(insideArc.getInf(), 3.141592653589793d + phase) - phase;
        double size = insideArc.getSize() + dNormalizeAngle;
        double d6 = size - 6.283185307179586d;
        double tolerance = this.circle.getTolerance();
        Vertex vertex = this.start;
        if (d6 >= this.length - tolerance) {
            list2.add(this);
            return;
        }
        if (d6 >= 0.0d) {
            Vertex vertex2 = new Vertex(new S2Point(this.circle.getPointAt(phase + d6)));
            d = d6;
            vertexAddSubEdge = addSubEdge(vertex, vertex2, d, list2, circle);
        } else {
            vertexAddSubEdge = vertex;
            d = 0.0d;
        }
        double d7 = this.length;
        if (dNormalizeAngle >= d7 - tolerance) {
            if (d6 >= 0.0d) {
                addSubEdge(vertexAddSubEdge, this.end, d7 - d, list, circle);
                return;
            } else {
                list.add(this);
                return;
            }
        }
        double d8 = phase + dNormalizeAngle;
        Vertex vertexAddSubEdge2 = addSubEdge(vertexAddSubEdge, new Vertex(new S2Point(this.circle.getPointAt(d8))), dNormalizeAngle - d, list, circle);
        double d9 = this.length;
        if (size >= d9 - tolerance) {
            addSubEdge(vertexAddSubEdge2, this.end, d9 - dNormalizeAngle, list2, circle);
        } else {
            addSubEdge(addSubEdge(vertexAddSubEdge2, new Vertex(new S2Point(this.circle.getPointAt(d8))), dNormalizeAngle - dNormalizeAngle, list2, circle), this.end, this.length - dNormalizeAngle, list, circle);
        }
    }
}
