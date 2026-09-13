package A3;

import java.util.RandomAccess;

/* JADX INFO: renamed from: A3.o, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0147o extends AbstractC0139g implements RandomAccess {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f43a;
    public final /* synthetic */ byte[] b;

    public /* synthetic */ C0147o(byte[] bArr, int i5) {
        this.f43a = i5;
        this.b = bArr;
    }

    @Override // A3.AbstractC0132b
    public final int b() {
        switch (this.f43a) {
            case 0:
                break;
        }
        return this.b.length;
    }

    @Override // A3.AbstractC0132b, java.util.Collection
    public final boolean contains(Object obj) {
        switch (this.f43a) {
            case 0:
                if (!(obj instanceof Byte)) {
                    return false;
                }
                return C.contains(this.b, ((Number) obj).byteValue());
            default:
                if (!(obj instanceof p147z3.D)) {
                    return false;
                }
                return C.contains(this.b, ((p147z3.D) obj).f9122a);
        }
    }

    @Override // java.util.List
    public final Object get(int i5) {
        switch (this.f43a) {
            case 0:
                return Byte.valueOf(this.b[i5]);
            default:
                return p147z3.D.a(p147z3.D.m1131constructorimpl(this.b[i5]));
        }
    }

    @Override // A3.AbstractC0139g, java.util.List
    public final int indexOf(Object obj) {
        switch (this.f43a) {
            case 0:
                if (!(obj instanceof Byte)) {
                    return -1;
                }
                return C.indexOf(this.b, ((Number) obj).byteValue());
            default:
                if (!(obj instanceof p147z3.D)) {
                    return -1;
                }
                return C.indexOf(this.b, ((p147z3.D) obj).f9122a);
        }
    }

    @Override // A3.AbstractC0132b, java.util.Collection
    public final boolean isEmpty() {
        switch (this.f43a) {
            case 0:
                return this.b.length == 0;
            default:
                return this.b.length == 0;
        }
    }

    @Override // A3.AbstractC0139g, java.util.List
    public final int lastIndexOf(Object obj) {
        switch (this.f43a) {
            case 0:
                if (!(obj instanceof Byte)) {
                    return -1;
                }
                return C.lastIndexOf(this.b, ((Number) obj).byteValue());
            default:
                if (!(obj instanceof p147z3.D)) {
                    return -1;
                }
                return C.lastIndexOf(this.b, ((p147z3.D) obj).f9122a);
        }
    }
}
