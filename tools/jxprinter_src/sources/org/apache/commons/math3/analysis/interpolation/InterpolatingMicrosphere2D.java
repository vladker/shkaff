package org.apache.commons.math3.analysis.interpolation;

import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class InterpolatingMicrosphere2D extends InterpolatingMicrosphere {
    private static final int DIMENSION = 2;

    public InterpolatingMicrosphere2D(int i5, double d, double d6, double d7) {
        super(2, i5, d, d6, d7);
        for (int i6 = 0; i6 < i5; i6++) {
            double d8 = (((double) i6) * 6.283185307179586d) / ((double) i5);
            add(new double[]{FastMath.cos(d8), FastMath.sin(d8)}, false);
        }
    }

    @Override // org.apache.commons.math3.analysis.interpolation.InterpolatingMicrosphere
    public InterpolatingMicrosphere2D copy() {
        return new InterpolatingMicrosphere2D(this);
    }

    public InterpolatingMicrosphere2D(InterpolatingMicrosphere2D interpolatingMicrosphere2D) {
        super(interpolatingMicrosphere2D);
    }
}
