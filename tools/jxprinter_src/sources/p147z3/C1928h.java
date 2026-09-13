package p147z3;

import java.io.Serializable;

/* JADX INFO: renamed from: z3.h, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1928h implements InterfaceC1934n, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f9131a;

    public C1928h(Object obj) {
        this.f9131a = obj;
    }

    @Override // p147z3.InterfaceC1934n
    public final Object getValue() {
        return this.f9131a;
    }

    @Override // p147z3.InterfaceC1934n
    public final boolean isInitialized() {
        return true;
    }

    public String toString() {
        return String.valueOf(this.f9131a);
    }
}
