package Z3;

import O3.p;
import X3.W;
import java.io.Serializable;
import java.util.Comparator;
import kotlin.jvm.internal.E;
import p147z3.J;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class c implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f899a;
    public final long b;
    public static final b Companion = new b();
    private static final c NIL = new c(0, 0);
    private static final Comparator<c> LEXICAL_ORDER = new I4.a(2);

    public c(long j6, long j7) {
        this.f899a = j6;
        this.b = j7;
    }

    private final <T> T toLongs(p action) {
        E.f(action, "action");
        return (T) action.invoke(Long.valueOf(this.f899a), Long.valueOf(this.b));
    }

    private final <T> T toULongs(p action) {
        E.f(action, "action");
        return (T) action.invoke(J.a(J.m1247constructorimpl(this.f899a)), J.a(J.m1247constructorimpl(this.b)));
    }

    private final Object writeReplace() {
        return d.serializedUuid(this);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f899a == cVar.f899a && this.b == cVar.b;
    }

    public final int hashCode() {
        long j6 = this.f899a ^ this.b;
        return ((int) j6) ^ ((int) (j6 >> 32));
    }

    public final byte[] toByteArray() {
        byte[] bArr = new byte[16];
        for (int i5 = 0; i5 < 8; i5++) {
            bArr[i5] = (byte) (this.f899a >>> ((7 - i5) * 8));
        }
        for (int i6 = 0; i6 < 8; i6++) {
            bArr[8 + i6] = (byte) (this.b >>> ((7 - i6) * 8));
        }
        return bArr;
    }

    public final String toHexString() {
        byte[] bArr = new byte[32];
        e.b(this.b, bArr, 16, 8);
        e.b(this.f899a, bArr, 0, 8);
        return W.decodeToString(bArr);
    }

    public String toString() {
        byte[] bArr = new byte[36];
        long j6 = this.b;
        e.b(j6, bArr, 24, 6);
        bArr[23] = 45;
        e.b(j6 >>> 48, bArr, 19, 2);
        bArr[18] = 45;
        long j7 = this.f899a;
        e.b(j7, bArr, 14, 2);
        bArr[13] = 45;
        e.b(j7 >>> 16, bArr, 9, 2);
        bArr[8] = 45;
        e.b(j7 >>> 32, bArr, 0, 4);
        return W.decodeToString(bArr);
    }

    public static /* synthetic */ void getLeastSignificantBits$annotations() {
    }

    public static /* synthetic */ void getMostSignificantBits$annotations() {
    }
}
