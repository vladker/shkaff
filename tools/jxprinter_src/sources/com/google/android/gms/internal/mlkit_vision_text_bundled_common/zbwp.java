package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zbwp extends zbwr {
    public zbwp(Unsafe unsafe) {
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

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwr
    public final void zbc(Object obj, long j6, boolean z6) {
        if (zbws.zbb) {
            zbws.zbD(obj, j6, z6 ? (byte) 1 : (byte) 0);
        } else {
            zbws.zbE(obj, j6, z6 ? (byte) 1 : (byte) 0);
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
