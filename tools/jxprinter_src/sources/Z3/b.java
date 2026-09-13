package Z3;

import X3.AbstractC0245k;
import X3.C0246l;
import java.util.Comparator;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public final c fromByteArray(byte[] byteArray) {
        E.f(byteArray, "byteArray");
        if (byteArray.length == 16) {
            return fromLongs(e.c(byteArray, 0), e.c(byteArray, 8));
        }
        throw new IllegalArgumentException("Expected exactly 16 bytes");
    }

    public final c fromLongs(long j6, long j7) {
        return (j6 == 0 && j7 == 0) ? getNIL() : new c(j6, j7);
    }

    /* JADX INFO: renamed from: fromULongs-eb3DHEI, reason: not valid java name */
    public final c m926fromULongseb3DHEI(long j6, long j7) {
        return fromLongs(j6, j7);
    }

    public final Comparator<c> getLEXICAL_ORDER() {
        return c.LEXICAL_ORDER;
    }

    public final c getNIL() {
        return c.NIL;
    }

    public final c parse(String uuidString) {
        E.f(uuidString, "uuidString");
        if (uuidString.length() != 36) {
            throw new IllegalArgumentException("Expected a 36-char string in the standard uuid format.");
        }
        long jHexToLong = AbstractC0245k.hexToLong(uuidString, 0, 8, C0246l.Companion.getDefault());
        e.a(8, uuidString);
        long jHexToLong2 = AbstractC0245k.hexToLong(uuidString, 9, 13, C0246l.Companion.getDefault());
        e.a(13, uuidString);
        long jHexToLong3 = AbstractC0245k.hexToLong(uuidString, 14, 18, C0246l.Companion.getDefault());
        e.a(18, uuidString);
        long jHexToLong4 = AbstractC0245k.hexToLong(uuidString, 19, 23, C0246l.Companion.getDefault());
        e.a(23, uuidString);
        return fromLongs((jHexToLong << 32) | (jHexToLong2 << 16) | jHexToLong3, AbstractC0245k.hexToLong(uuidString, 24, 36, C0246l.Companion.getDefault()) | (jHexToLong4 << 48));
    }

    public final c parseHex(String hexString) {
        E.f(hexString, "hexString");
        if (hexString.length() == 32) {
            return fromLongs(AbstractC0245k.hexToLong(hexString, 0, 16, C0246l.Companion.getDefault()), AbstractC0245k.hexToLong(hexString, 16, 32, C0246l.Companion.getDefault()));
        }
        throw new IllegalArgumentException("Expected a 32-char hexadecimal string.");
    }

    public final c random() {
        return d.secureRandomUuid();
    }
}
