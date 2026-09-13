package org.apache.commons.math3.geometry.euclidean.threed;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Segment {
    private final Vector3D end;
    private final Line line;
    private final Vector3D start;

    public Segment(Vector3D vector3D, Vector3D vector3D2, Line line) {
        this.start = vector3D;
        this.end = vector3D2;
        this.line = line;
    }

    public Vector3D getEnd() {
        return this.end;
    }

    public Line getLine() {
        return this.line;
    }

    public Vector3D getStart() {
        return this.start;
    }
}
