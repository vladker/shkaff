package org.apache.commons.compress.archivers.zip;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface ZipEncoding {
    boolean canEncode(String str);

    String decode(byte[] bArr);

    ByteBuffer encode(String str);
}
