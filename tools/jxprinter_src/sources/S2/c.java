package S2;

import A3.AbstractC0157z;
import A3.I;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class c {
    public static final b Companion = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f635a;
    private final byte[] chunk;
    private final String error;

    public c(byte[] bArr, boolean z6, String str) {
        this.chunk = bArr;
        this.f635a = z6;
        this.error = str;
    }

    public final byte[] component1() {
        return this.chunk;
    }

    public final String component3() {
        return this.error;
    }

    public final c copy(byte[] bArr, boolean z6, String str) {
        return new c(bArr, z6, str);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return j.INSTANCE.deepEquals(toList(), ((c) obj).toList());
    }

    public final byte[] getChunk() {
        return this.chunk;
    }

    public final String getError() {
        return this.error;
    }

    public final int hashCode() {
        return toList().hashCode();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final List<Object> toList() {
        return I.listOf((Object[]) new Serializable[]{this.chunk, Boolean.valueOf(this.f635a), this.error});
    }

    public String toString() {
        String string = Arrays.toString(this.chunk);
        String str = this.error;
        StringBuilder sb = new StringBuilder("UriContentChunkResult(chunk=");
        sb.append(string);
        sb.append(", done=");
        sb.append(this.f635a);
        sb.append(", error=");
        return AbstractC0157z.s(sb, str, ")");
    }
}
