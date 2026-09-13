package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zbwq extends zbwr {
    public zbwq(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwr
    public final double zba(Object obj, long j6) {
        return Double.longBitsToDouble(this.zba.getLong(obj, j6));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwr
    public final float zbb(Object obj, long j6) {
        return Float.intBitsToFloat(this.zba.getInt(obj, j6));
    }

    /* JADX WARN: Failed to inline method: com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbws.zbi(java.lang.Object, long, boolean):void */
    /* JADX WARN: Failed to inline method: com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbws.zbj(java.lang.Object, long, boolean):void */
    /* JADX WARN: Unknown register number '(r5v0 boolean)' in method call: com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbws.zbi(java.lang.Object, long, boolean):void */
    /* JADX WARN: Unknown register number '(r5v0 boolean)' in method call: com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbws.zbj(java.lang.Object, long, boolean):void */
    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwr
    public final void zbc(Object obj, long j6, boolean z6) {
        if (zbws.zbb) {
            zbws.zbi(obj, j6, z6);
        } else {
            zbws.zbj(obj, j6, z6);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwr
    public final void zbd(Object obj, long j6, byte b) {
        if (zbws.zbb) {
            zbws.zbD(obj, j6, b);
        } else {
            zbws.zbE(obj, j6, b);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwr
    public final void zbe(Object obj, long j6, double d) {
        this.zba.putLong(obj, j6, Double.doubleToLongBits(d));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwr
    public final void zbf(Object obj, long j6, float f6) {
        this.zba.putInt(obj, j6, Float.floatToIntBits(f6));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwr
    public final boolean zbg(Object obj, long j6) {
        return zbws.zbb ? zbws.zbt(obj, j6) : zbws.zbu(obj, j6);
    }
}
