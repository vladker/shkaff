package org.opencv.core;

import androidx.collection.a;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class DMatch {
    public float distance;
    public int imgIdx;
    public int queryIdx;
    public int trainIdx;

    public DMatch() {
        this(-1, -1, Float.MAX_VALUE);
    }

    public boolean lessThan(DMatch dMatch) {
        return this.distance < dMatch.distance;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DMatch [queryIdx=");
        sb.append(this.queryIdx);
        sb.append(", trainIdx=");
        sb.append(this.trainIdx);
        sb.append(", imgIdx=");
        sb.append(this.imgIdx);
        sb.append(", distance=");
        return a.q(sb, "]", this.distance);
    }

    public DMatch(int i5, int i6, float f6) {
        this.queryIdx = i5;
        this.trainIdx = i6;
        this.imgIdx = -1;
        this.distance = f6;
    }

    public DMatch(int i5, int i6, int i7, float f6) {
        this.queryIdx = i5;
        this.trainIdx = i6;
        this.imgIdx = i7;
        this.distance = f6;
    }
}
