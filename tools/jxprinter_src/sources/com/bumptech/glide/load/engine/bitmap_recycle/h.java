package com.bumptech.glide.load.engine.bitmap_recycle;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class h implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f2986a;
    public int b;
    public Class c;

    public h(i iVar) {
        this.f2986a = iVar;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.m
    public final void a() {
        this.f2986a.a(this);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof h) {
            h hVar = (h) obj;
            if (this.b == hVar.b && this.c == hVar.c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i5 = this.b * 31;
        Class cls = this.c;
        return i5 + (cls != null ? cls.hashCode() : 0);
    }

    public final String toString() {
        return "Key{size=" + this.b + "array=" + this.c + '}';
    }
}
