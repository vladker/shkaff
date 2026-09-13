package A3;

import java.util.RandomAccess;

/* JADX INFO: renamed from: A3.q, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0149q extends AbstractC0139g implements RandomAccess {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f45a;
    public final /* synthetic */ int[] b;

    public /* synthetic */ C0149q(int[] iArr, int i5) {
        this.f45a = i5;
        this.b = iArr;
    }

    @Override // A3.AbstractC0132b
    public final int b() {
        switch (this.f45a) {
            case 0:
                break;
        }
        return this.b.length;
    }

    @Override // A3.AbstractC0132b, java.util.Collection
    public final boolean contains(Object obj) {
        switch (this.f45a) {
            case 0:
                if (!(obj instanceof Integer)) {
                    return false;
                }
                return C.contains(this.b, ((Number) obj).intValue());
            default:
                if (!(obj instanceof p147z3.G)) {
                    return false;
                }
                return C.contains(this.b, ((p147z3.G) obj).f9124a);
        }
    }

    @Override // java.util.List
    public final Object get(int i5) {
        switch (this.f45a) {
            case 0:
                return Integer.valueOf(this.b[i5]);
            default:
                return p147z3.G.a(p147z3.G.m1188constructorimpl(this.b[i5]));
        }
    }

    @Override // A3.AbstractC0139g, java.util.List
    public final int indexOf(Object obj) {
        switch (this.f45a) {
            case 0:
                if (!(obj instanceof Integer)) {
                    return -1;
                }
                return C.indexOf(this.b, ((Number) obj).intValue());
            default:
                if (!(obj instanceof p147z3.G)) {
                    return -1;
                }
                return C.indexOf(this.b, ((p147z3.G) obj).f9124a);
        }
    }

    @Override // A3.AbstractC0132b, java.util.Collection
    public final boolean isEmpty() {
        switch (this.f45a) {
            case 0:
                return this.b.length == 0;
            default:
                return this.b.length == 0;
        }
    }

    @Override // A3.AbstractC0139g, java.util.List
    public final int lastIndexOf(Object obj) {
        switch (this.f45a) {
            case 0:
                if (!(obj instanceof Integer)) {
                    return -1;
                }
                return C.lastIndexOf(this.b, ((Number) obj).intValue());
            default:
                if (!(obj instanceof p147z3.G)) {
                    return -1;
                }
                return C.lastIndexOf(this.b, ((p147z3.G) obj).f9124a);
        }
    }
}
