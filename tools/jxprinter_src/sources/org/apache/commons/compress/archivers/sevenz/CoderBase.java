package org.apache.commons.compress.archivers.sevenz;

import java.io.InputStream;
import java.io.OutputStream;
import org.apache.commons.compress.utils.ByteUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
abstract class CoderBase {
    private final Class<?>[] acceptableOptions;

    public CoderBase(Class<?>... clsArr) {
        this.acceptableOptions = clsArr;
    }

    public static int numberOptionOrDefault(Object obj, int i5) {
        return obj instanceof Number ? ((Number) obj).intValue() : i5;
    }

    public boolean canAcceptOptions(Object obj) {
        for (Class<?> cls : this.acceptableOptions) {
            if (cls.isInstance(obj)) {
                return true;
            }
        }
        return false;
    }

    public abstract InputStream decode(String str, InputStream inputStream, long j6, Coder coder, byte[] bArr, int i5);

    public OutputStream encode(OutputStream outputStream, Object obj) {
        throw new UnsupportedOperationException("Method doesn't support writing");
    }

    public byte[] getOptionsAsProperties(Object obj) {
        return ByteUtils.EMPTY_BYTE_ARRAY;
    }

    public Object getOptionsFromCoder(Coder coder, InputStream inputStream) {
        return null;
    }
}
