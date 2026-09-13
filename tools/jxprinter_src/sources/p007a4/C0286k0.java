package p007a4;

import androidx.collection.a;

/* JADX INFO: renamed from: a4.k0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0286k0 implements B0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f951a;

    public C0286k0(boolean z6) {
        this.f951a = z6;
    }

    @Override // p007a4.B0
    public C0268c1 getList() {
        return null;
    }

    @Override // p007a4.B0
    public final boolean isActive() {
        return this.f951a;
    }

    public String toString() {
        return a.f('}', this.f951a ? "Active" : "New", new StringBuilder("Empty{"));
    }
}
