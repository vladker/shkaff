package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import java.security.MessageDigest;

/* JADX INFO: renamed from: com.bumptech.glide.load.engine.f, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class C0490f implements p126w0.q {
    public final p126w0.q b;
    public final p126w0.q c;

    public C0490f(p126w0.q qVar, p126w0.q qVar2) {
        this.b = qVar;
        this.c = qVar2;
    }

    @Override // p126w0.q
    public final boolean equals(Object obj) {
        if (obj instanceof C0490f) {
            C0490f c0490f = (C0490f) obj;
            if (this.b.equals(c0490f.b) && this.c.equals(c0490f.c)) {
                return true;
            }
        }
        return false;
    }

    @Override // p126w0.q
    public final int hashCode() {
        return this.c.hashCode() + (this.b.hashCode() * 31);
    }

    public final String toString() {
        return "DataCacheKey{sourceKey=" + this.b + ", signature=" + this.c + '}';
    }

    @Override // p126w0.q
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        this.b.updateDiskCacheKey(messageDigest);
        this.c.updateDiskCacheKey(messageDigest);
    }
}
