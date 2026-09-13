package com.google.android.material.shape;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class TriangleEdgeTreatment extends EdgeTreatment {
    private final boolean inside;
    private final float size;

    public TriangleEdgeTreatment(float f6, boolean z6) {
        this.size = f6;
        this.inside = z6;
    }

    @Override // com.google.android.material.shape.EdgeTreatment
    public void getEdgePath(float f6, float f7, float f8, @NonNull ShapePath shapePath) {
        if (!this.inside) {
            float f9 = this.size;
            shapePath.lineTo(f7 - (f9 * f8), 0.0f, f7, (-f9) * f8);
            shapePath.lineTo((this.size * f8) + f7, 0.0f, f6, 0.0f);
        } else {
            shapePath.lineTo(f7 - (this.size * f8), 0.0f);
            float f10 = this.size;
            shapePath.lineTo(f7, f10 * f8, (f10 * f8) + f7, 0.0f);
            shapePath.lineTo(f6, 0.0f);
        }
    }
}
