package A3;

import java.util.RandomAccess;

/* JADX INFO: renamed from: A3.p, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0148p extends AbstractC0139g implements RandomAccess {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f44a;
    public final /* synthetic */ short[] b;

    public /* synthetic */ C0148p(short[] sArr, int i5) {
        this.f44a = i5;
        this.b = sArr;
    }

    @Override // A3.AbstractC0132b
    public final int b() {
        switch (this.f44a) {
            case 0:
                break;
        }
        return this.b.length;
    }

    @Override // A3.AbstractC0132b, java.util.Collection
    public final boolean contains(Object obj) {
        switch (this.f44a) {
            case 0:
                if (!(obj instanceof Short)) {
                    return false;
                }
                return C.contains(this.b, ((Number) obj).shortValue());
            default:
                if (!(obj instanceof p147z3.N)) {
                    return false;
                }
                return C.contains(this.b, ((p147z3.N) obj).f9128a);
        }
    }

    @Override // java.util.List
    public final Object get(int i5) {
        switch (this.f44a) {
            case 0:
                return Short.valueOf(this.b[i5]);
            default:
                return p147z3.N.a(p147z3.N.m1306constructorimpl(this.b[i5]));
        }
    }

    @Override // A3.AbstractC0139g, java.util.List
    public final int indexOf(Object obj) {
        switch (this.f44a) {
            case 0:
                if (!(obj instanceof Short)) {
                    return -1;
                }
                return C.indexOf(this.b, ((Number) obj).shortValue());
            default:
                if (!(obj instanceof p147z3.N)) {
                    return -1;
                }
                return C.indexOf(this.b, ((p147z3.N) obj).f9128a);
        }
    }

    @Override // A3.AbstractC0132b, java.util.Collection
    public final boolean isEmpty() {
        switch (this.f44a) {
            case 0:
                return this.b.length == 0;
            default:
                return this.b.length == 0;
        }
    }

    @Override // A3.AbstractC0139g, java.util.List
    public final int lastIndexOf(Object obj) {
        switch (this.f44a) {
            case 0:
                if (!(obj instanceof Short)) {
                    return -1;
                }
                return C.lastIndexOf(this.b, ((Number) obj).shortValue());
            default:
                if (!(obj instanceof p147z3.N)) {
                    return -1;
                }
                return C.lastIndexOf(this.b, ((p147z3.N) obj).f9128a);
        }
    }
}
