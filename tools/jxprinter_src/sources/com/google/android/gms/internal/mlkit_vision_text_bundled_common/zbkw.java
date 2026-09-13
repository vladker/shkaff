package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import com.google.firebase.analytics.FirebaseAnalytics;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zbkw extends zbkx {
    final transient int zba;
    final transient int zbb;
    final /* synthetic */ zbkx zbc;

    public zbkw(zbkx zbkxVar, int i5, int i6) {
        this.zbc = zbkxVar;
        this.zba = i5;
        this.zbb = i6;
    }

    @Override // java.util.List
    public final Object get(int i5) {
        zbkj.zba(i5, this.zbb, FirebaseAnalytics.Param.INDEX);
        return this.zbc.get(i5 + this.zba);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zbb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbkt
    public final int zbb() {
        return this.zbc.zbc() + this.zba + this.zbb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbkt
    public final int zbc() {
        return this.zbc.zbc() + this.zba;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbkt
    public final Object[] zbe() {
        return this.zbc.zbe();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbkx, java.util.List
    /* JADX INFO: renamed from: zbf, reason: merged with bridge method [inline-methods] */
    public final zbkx subList(int i5, int i6) {
        zbkj.zbd(i5, i6, this.zbb);
        int i7 = this.zba;
        return this.zbc.subList(i5 + i7, i6 + i7);
    }
}
