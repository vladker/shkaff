package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class UnionVector extends BaseVector {
    public UnionVector __assign(int i5, int i6, ByteBuffer byteBuffer) {
        __reset(i5, i6, byteBuffer);
        return this;
    }

    public Table get(Table table, int i5) {
        return Table.__union(table, __element(i5), this.bb);
    }
}
