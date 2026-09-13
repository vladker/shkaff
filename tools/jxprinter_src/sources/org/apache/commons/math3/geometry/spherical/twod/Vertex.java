package org.apache.commons.math3.geometry.spherical.twod;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Vertex {
    private final S2Point location;
    private Edge incoming = null;
    private Edge outgoing = null;
    private final List<Circle> circles = new ArrayList();

    public Vertex(S2Point s2Point) {
        this.location = s2Point;
    }

    public void bindWith(Circle circle) {
        this.circles.add(circle);
    }

    public Edge getIncoming() {
        return this.incoming;
    }

    public S2Point getLocation() {
        return this.location;
    }

    public Edge getOutgoing() {
        return this.outgoing;
    }

    public void setIncoming(Edge edge) {
        this.incoming = edge;
        bindWith(edge.getCircle());
    }

    public void setOutgoing(Edge edge) {
        this.outgoing = edge;
        bindWith(edge.getCircle());
    }

    public Circle sharedCircleWith(Vertex vertex) {
        for (Circle circle : this.circles) {
            Iterator<Circle> it = vertex.circles.iterator();
            while (it.hasNext()) {
                if (circle == it.next()) {
                    return circle;
                }
            }
        }
        return null;
    }
}
