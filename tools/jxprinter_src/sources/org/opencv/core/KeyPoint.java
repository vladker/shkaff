package org.opencv.core;

import A3.AbstractC0157z;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class KeyPoint {
    public float angle;
    public int class_id;
    public int octave;
    public Point pt;
    public float response;
    public float size;

    public KeyPoint(float f6, float f7, float f8, float f9, float f10, int i5, int i6) {
        this.pt = new Point(f6, f7);
        this.size = f8;
        this.angle = f9;
        this.response = f10;
        this.octave = i5;
        this.class_id = i6;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("KeyPoint [pt=");
        sb.append(this.pt);
        sb.append(", size=");
        sb.append(this.size);
        sb.append(", angle=");
        sb.append(this.angle);
        sb.append(", response=");
        sb.append(this.response);
        sb.append(", octave=");
        sb.append(this.octave);
        sb.append(", class_id=");
        return AbstractC0157z.l("]", this.class_id, sb);
    }

    public KeyPoint() {
        this(0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0, -1);
    }

    public KeyPoint(float f6, float f7, float f8, float f9, float f10, int i5) {
        this(f6, f7, f8, f9, f10, i5, -1);
    }

    public KeyPoint(float f6, float f7, float f8, float f9, float f10) {
        this(f6, f7, f8, f9, f10, 0, -1);
    }

    public KeyPoint(float f6, float f7, float f8, float f9) {
        this(f6, f7, f8, f9, 0.0f, 0, -1);
    }

    public KeyPoint(float f6, float f7, float f8) {
        this(f6, f7, f8, -1.0f, 0.0f, 0, -1);
    }
}
