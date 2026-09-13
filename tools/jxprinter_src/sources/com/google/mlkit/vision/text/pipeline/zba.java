package com.google.mlkit.vision.text.pipeline;

import androidx.collection.a;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbkx;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbok;
import org.apache.commons.math3.geometry.VectorFormat;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
final class zba extends zbn {
    private final zbo zba;
    private final zbok zbb;
    private final zbkx zbc;
    private final boolean zbd;

    public zba(zbo zboVar, zbok zbokVar, zbkx zbkxVar, boolean z6) {
        this.zba = zboVar;
        this.zbb = zbokVar;
        if (zbkxVar == null) {
            throw new NullPointerException("Null lineBoxParcels");
        }
        this.zbc = zbkxVar;
        this.zbd = z6;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zbn) {
            zbn zbnVar = (zbn) obj;
            if (this.zba.equals(zbnVar.zbc()) && this.zbb.equals(zbnVar.zbb()) && this.zbc.equals(zbnVar.zba()) && this.zbd == zbnVar.zbd()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((this.zba.hashCode() ^ 1000003) * 1000003) ^ this.zbb.hashCode()) * 1000003) ^ this.zbc.hashCode()) * 1000003) ^ (true != this.zbd ? 1237 : 1231);
    }

    public final String toString() {
        zbkx zbkxVar = this.zbc;
        zbok zbokVar = this.zbb;
        String string = this.zba.toString();
        String string2 = zbokVar.toString();
        String string3 = zbkxVar.toString();
        StringBuilder sbU = a.u("VkpResults{status=", string, ", textParcel=", string2, ", lineBoxParcels=");
        sbU.append(string3);
        sbU.append(", fromColdCall=");
        sbU.append(this.zbd);
        sbU.append(VectorFormat.DEFAULT_SUFFIX);
        return sbU.toString();
    }

    @Override // com.google.mlkit.vision.text.pipeline.zbn
    public final zbkx zba() {
        return this.zbc;
    }

    @Override // com.google.mlkit.vision.text.pipeline.zbn
    public final zbok zbb() {
        return this.zbb;
    }

    @Override // com.google.mlkit.vision.text.pipeline.zbn
    public final zbo zbc() {
        return this.zba;
    }

    @Override // com.google.mlkit.vision.text.pipeline.zbn
    public final boolean zbd() {
        return this.zbd;
    }
}
