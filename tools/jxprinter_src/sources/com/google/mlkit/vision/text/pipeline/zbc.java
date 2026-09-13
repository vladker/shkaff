package com.google.mlkit.vision.text.pipeline;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
final class zbc extends VkpTextRecognizerOptions.Builder {
    private String zba;
    private String zbb;
    private String zbc;
    private boolean zbd;
    private byte zbe;

    @Override // com.google.mlkit.vision.text.pipeline.VkpTextRecognizerOptions.Builder
    public final VkpTextRecognizerOptions build() {
        String str;
        String str2;
        String str3;
        if (this.zbe == 1 && (str = this.zba) != null && (str2 = this.zbb) != null && (str3 = this.zbc) != null) {
            return new zbe(str, str2, str3, this.zbd, null);
        }
        StringBuilder sb = new StringBuilder();
        if (this.zba == null) {
            sb.append(" configLabel");
        }
        if (this.zbb == null) {
            sb.append(" modelDir");
        }
        if (this.zbc == null) {
            sb.append(" languageHint");
        }
        if (this.zbe == 0) {
            sb.append(" enableLowLatencyInBackground");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }

    @Override // com.google.mlkit.vision.text.pipeline.VkpTextRecognizerOptions.Builder
    public final VkpTextRecognizerOptions.Builder setConfigLabel(String str) {
        if (str == null) {
            throw new NullPointerException("Null configLabel");
        }
        this.zba = str;
        return this;
    }

    @Override // com.google.mlkit.vision.text.pipeline.VkpTextRecognizerOptions.Builder
    public final VkpTextRecognizerOptions.Builder setEnableLowLatencyInBackground(boolean z6) {
        this.zbd = z6;
        this.zbe = (byte) 1;
        return this;
    }

    @Override // com.google.mlkit.vision.text.pipeline.VkpTextRecognizerOptions.Builder
    public final VkpTextRecognizerOptions.Builder setLanguageHint(String str) {
        if (str == null) {
            throw new NullPointerException("Null languageHint");
        }
        this.zbc = str;
        return this;
    }

    @Override // com.google.mlkit.vision.text.pipeline.VkpTextRecognizerOptions.Builder
    public final VkpTextRecognizerOptions.Builder setModelDir(String str) {
        if (str == null) {
            throw new NullPointerException("Null modelDir");
        }
        this.zbb = str;
        return this;
    }
}
