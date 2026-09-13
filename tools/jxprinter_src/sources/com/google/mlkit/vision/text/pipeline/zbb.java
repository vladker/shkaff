package com.google.mlkit.vision.text.pipeline;

import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbki;
import org.apache.commons.math3.geometry.VectorFormat;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
final class zbb extends zbo {
    private final int zba;
    private final zbki zbb;

    public zbb(int i5, zbki zbkiVar) {
        this.zba = i5;
        this.zbb = zbkiVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zbo) {
            zbo zboVar = (zbo) obj;
            if (this.zba == zboVar.zba() && this.zbb.equals(zboVar.zbb())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.zba ^ 1000003) * 1000003) ^ this.zbb.hashCode();
    }

    public final String toString() {
        return "VkpStatus{exceptionType=" + this.zba + ", remoteException=" + this.zbb.toString() + VectorFormat.DEFAULT_SUFFIX;
    }

    @Override // com.google.mlkit.vision.text.pipeline.zbo
    public final int zba() {
        return this.zba;
    }

    @Override // com.google.mlkit.vision.text.pipeline.zbo
    public final zbki zbb() {
        return this.zbb;
    }
}
