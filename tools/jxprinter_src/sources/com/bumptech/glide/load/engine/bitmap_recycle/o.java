package com.bumptech.glide.load.engine.bitmap_recycle;

import L0.s;
import android.graphics.Bitmap;
import androidx.annotation.VisibleForTesting;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class o implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f2997a;
    public int b;
    public Bitmap.Config c;

    public o(p pVar) {
        this.f2997a = pVar;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.m
    public final void a() {
        this.f2997a.a(this);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof o) {
            o oVar = (o) obj;
            if (this.b == oVar.b && s.bothNullOrEqual(this.c, oVar.c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i5 = this.b * 31;
        Bitmap.Config config = this.c;
        return i5 + (config != null ? config.hashCode() : 0);
    }

    public final String toString() {
        return q.b(this.b, this.c);
    }

    @VisibleForTesting
    public o(p pVar, int i5, Bitmap.Config config) {
        this(pVar);
        this.b = i5;
        this.c = config;
    }
}
