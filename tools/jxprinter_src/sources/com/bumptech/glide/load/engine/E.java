package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import java.security.MessageDigest;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class E implements p126w0.q {
    public final Object b;
    public final int c;
    public final int d;
    public final Class e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Class f2951f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final p126w0.q f2952g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map f2953h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final p126w0.v f2954i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f2955j;

    public E(Object obj, p126w0.q qVar, int i5, int i6, Map map, Class cls, Class cls2, p126w0.v vVar) {
        this.b = L0.q.checkNotNull(obj);
        this.f2952g = (p126w0.q) L0.q.checkNotNull(qVar, "Signature must not be null");
        this.c = i5;
        this.d = i6;
        this.f2953h = (Map) L0.q.checkNotNull(map);
        this.e = (Class) L0.q.checkNotNull(cls, "Resource class must not be null");
        this.f2951f = (Class) L0.q.checkNotNull(cls2, "Transcode class must not be null");
        this.f2954i = (p126w0.v) L0.q.checkNotNull(vVar);
    }

    @Override // p126w0.q
    public final boolean equals(Object obj) {
        if (obj instanceof E) {
            E e = (E) obj;
            if (this.b.equals(e.b) && this.f2952g.equals(e.f2952g) && this.d == e.d && this.c == e.c && this.f2953h.equals(e.f2953h) && this.e.equals(e.e) && this.f2951f.equals(e.f2951f) && this.f2954i.equals(e.f2954i)) {
                return true;
            }
        }
        return false;
    }

    @Override // p126w0.q
    public final int hashCode() {
        if (this.f2955j == 0) {
            int iHashCode = this.b.hashCode();
            this.f2955j = iHashCode;
            int iHashCode2 = ((((this.f2952g.hashCode() + (iHashCode * 31)) * 31) + this.c) * 31) + this.d;
            this.f2955j = iHashCode2;
            int iHashCode3 = this.f2953h.hashCode() + (iHashCode2 * 31);
            this.f2955j = iHashCode3;
            int iHashCode4 = this.e.hashCode() + (iHashCode3 * 31);
            this.f2955j = iHashCode4;
            int iHashCode5 = this.f2951f.hashCode() + (iHashCode4 * 31);
            this.f2955j = iHashCode5;
            this.f2955j = this.f2954i.b.hashCode() + (iHashCode5 * 31);
        }
        return this.f2955j;
    }

    public final String toString() {
        return "EngineKey{model=" + this.b + ", width=" + this.c + ", height=" + this.d + ", resourceClass=" + this.e + ", transcodeClass=" + this.f2951f + ", signature=" + this.f2952g + ", hashCode=" + this.f2955j + ", transformations=" + this.f2953h + ", options=" + this.f2954i + '}';
    }

    @Override // p126w0.q
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }
}
