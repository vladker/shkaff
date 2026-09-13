package org.apache.commons.compress.utils;

import io.flutter.embedding.android.KeyboardMap;
import java.io.InputStream;
import java.util.zip.CRC32;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class CRC32VerifyingInputStream extends ChecksumVerifyingInputStream {
    public CRC32VerifyingInputStream(InputStream inputStream, long j6, int i5) {
        this(inputStream, j6, ((long) i5) & KeyboardMap.kValueMask);
    }

    public CRC32VerifyingInputStream(InputStream inputStream, long j6, long j7) {
        super(new CRC32(), inputStream, j6, j7);
    }
}
