package U2;

import java.util.Arrays;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f723a;
    public final boolean b;
    private final p049i4.b chunkResultLock;
    private final String error;
    private final p049i4.b nextChunkLock;
    private final byte[] readChunk;

    public f(long j6, boolean z6, p049i4.b nextChunkLock, p049i4.b chunkResultLock, byte[] bArr, String str) {
        E.f(nextChunkLock, "nextChunkLock");
        E.f(chunkResultLock, "chunkResultLock");
        this.f723a = j6;
        this.b = z6;
        this.nextChunkLock = nextChunkLock;
        this.chunkResultLock = chunkResultLock;
        this.readChunk = bArr;
        this.error = str;
    }

    public static /* synthetic */ f a(f fVar, byte[] bArr, String str, int i5) {
        long j6 = fVar.f723a;
        boolean z6 = (i5 & 2) != 0 ? fVar.b : true;
        p049i4.b bVar = fVar.nextChunkLock;
        p049i4.b bVar2 = fVar.chunkResultLock;
        if ((i5 & 32) != 0) {
            str = fVar.error;
        }
        return fVar.copy(j6, z6, bVar, bVar2, bArr, str);
    }

    public final p049i4.b component3() {
        return this.nextChunkLock;
    }

    public final p049i4.b component4() {
        return this.chunkResultLock;
    }

    public final byte[] component5() {
        return this.readChunk;
    }

    public final String component6() {
        return this.error;
    }

    public final f copy(long j6, boolean z6, p049i4.b nextChunkLock, p049i4.b chunkResultLock, byte[] bArr, String str) {
        E.f(nextChunkLock, "nextChunkLock");
        E.f(chunkResultLock, "chunkResultLock");
        return new f(j6, z6, nextChunkLock, chunkResultLock, bArr, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!f.class.equals(obj != null ? obj.getClass() : null)) {
            return false;
        }
        E.d(obj, "null cannot be cast to non-null type com.talesbarreto.uri_content.model.UriContentRequest");
        f fVar = (f) obj;
        if (this.f723a != fVar.f723a || this.b != fVar.b || !E.a(this.nextChunkLock, fVar.nextChunkLock) || !E.a(this.chunkResultLock, fVar.chunkResultLock)) {
            return false;
        }
        byte[] bArr = this.readChunk;
        if (bArr != null) {
            byte[] bArr2 = fVar.readChunk;
            if (bArr2 == null || !Arrays.equals(bArr, bArr2)) {
                return false;
            }
        } else if (fVar.readChunk != null) {
            return false;
        }
        return E.a(this.error, fVar.error);
    }

    public final p049i4.b getChunkResultLock() {
        return this.chunkResultLock;
    }

    public final String getError() {
        return this.error;
    }

    public final p049i4.b getNextChunkLock() {
        return this.nextChunkLock;
    }

    public final byte[] getReadChunk() {
        return this.readChunk;
    }

    public final int hashCode() {
        int iHashCode = (this.chunkResultLock.hashCode() + ((this.nextChunkLock.hashCode() + ((Boolean.hashCode(this.b) + (Long.hashCode(this.f723a) * 31)) * 31)) * 31)) * 31;
        byte[] bArr = this.readChunk;
        int iHashCode2 = (iHashCode + (bArr != null ? Arrays.hashCode(bArr) : 0)) * 31;
        String str = this.error;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        p049i4.b bVar = this.nextChunkLock;
        p049i4.b bVar2 = this.chunkResultLock;
        String string = Arrays.toString(this.readChunk);
        String str = this.error;
        StringBuilder sb = new StringBuilder("UriContentRequest(bufferSize=");
        sb.append(this.f723a);
        sb.append(", done=");
        sb.append(this.b);
        sb.append(", nextChunkLock=");
        sb.append(bVar);
        sb.append(", chunkResultLock=");
        sb.append(bVar2);
        androidx.collection.a.y(sb, ", readChunk=", string, ", error=", str);
        sb.append(")");
        return sb.toString();
    }
}
