package A3;

import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class r extends AbstractC0139g implements RandomAccess {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f47a;
    public final /* synthetic */ long[] b;

    public /* synthetic */ r(long[] jArr, int i5) {
        this.f47a = i5;
        this.b = jArr;
    }

    @Override // A3.AbstractC0132b
    public final int b() {
        switch (this.f47a) {
            case 0:
                break;
        }
        return this.b.length;
    }

    @Override // A3.AbstractC0132b, java.util.Collection
    public final boolean contains(Object obj) {
        switch (this.f47a) {
            case 0:
                if (!(obj instanceof Long)) {
                    return false;
                }
                return C.contains(this.b, ((Number) obj).longValue());
            default:
                if (!(obj instanceof p147z3.J)) {
                    return false;
                }
                return C.contains(this.b, ((p147z3.J) obj).f9126a);
        }
    }

    @Override // java.util.List
    public final Object get(int i5) {
        switch (this.f47a) {
            case 0:
                return Long.valueOf(this.b[i5]);
            default:
                return p147z3.J.a(p147z3.J.m1247constructorimpl(this.b[i5]));
        }
    }

    @Override // A3.AbstractC0139g, java.util.List
    public final int indexOf(Object obj) {
        switch (this.f47a) {
            case 0:
                if (!(obj instanceof Long)) {
                    return -1;
                }
                return C.indexOf(this.b, ((Number) obj).longValue());
            default:
                if (!(obj instanceof p147z3.J)) {
                    return -1;
                }
                return C.indexOf(this.b, ((p147z3.J) obj).f9126a);
        }
    }

    @Override // A3.AbstractC0132b, java.util.Collection
    public final boolean isEmpty() {
        switch (this.f47a) {
            case 0:
                return this.b.length == 0;
            default:
                return this.b.length == 0;
        }
    }

    @Override // A3.AbstractC0139g, java.util.List
    public final int lastIndexOf(Object obj) {
        switch (this.f47a) {
            case 0:
                if (!(obj instanceof Long)) {
                    return -1;
                }
                return C.lastIndexOf(this.b, ((Number) obj).longValue());
            default:
                if (!(obj instanceof p147z3.J)) {
                    return -1;
                }
                return C.lastIndexOf(this.b, ((p147z3.J) obj).f9126a);
        }
    }
}
