package com.google.mlkit.vision.text.pipeline;

import org.apache.commons.math3.geometry.VectorFormat;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
final class zbe extends VkpTextRecognizerOptions {
    private final String zba;
    private final String zbb;
    private final String zbc;
    private final boolean zbd;

    public /* synthetic */ zbe(String str, String str2, String str3, boolean z6, zbd zbdVar) {
        this.zba = str;
        this.zbb = str2;
        this.zbc = str3;
        this.zbd = z6;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof VkpTextRecognizerOptions) {
            VkpTextRecognizerOptions vkpTextRecognizerOptions = (VkpTextRecognizerOptions) obj;
            if (this.zba.equals(vkpTextRecognizerOptions.zba()) && this.zbb.equals(vkpTextRecognizerOptions.zbc()) && this.zbc.equals(vkpTextRecognizerOptions.zbb()) && this.zbd == vkpTextRecognizerOptions.zbd()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((this.zba.hashCode() ^ 1000003) * 1000003) ^ this.zbb.hashCode()) * 1000003) ^ this.zbc.hashCode()) * 1000003) ^ (true != this.zbd ? 1237 : 1231);
    }

    public final String toString() {
        return "VkpTextRecognizerOptions{configLabel=" + this.zba + ", modelDir=" + this.zbb + ", languageHint=" + this.zbc + ", enableLowLatencyInBackground=" + this.zbd + VectorFormat.DEFAULT_SUFFIX;
    }

    @Override // com.google.mlkit.vision.text.pipeline.VkpTextRecognizerOptions
    public final String zba() {
        return this.zba;
    }

    @Override // com.google.mlkit.vision.text.pipeline.VkpTextRecognizerOptions
    public final String zbb() {
        return this.zbc;
    }

    @Override // com.google.mlkit.vision.text.pipeline.VkpTextRecognizerOptions
    public final String zbc() {
        return this.zbb;
    }

    @Override // com.google.mlkit.vision.text.pipeline.VkpTextRecognizerOptions
    public final boolean zbd() {
        return this.zbd;
    }
}
