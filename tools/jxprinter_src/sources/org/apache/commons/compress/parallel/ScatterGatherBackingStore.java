package org.apache.commons.compress.parallel;

import java.io.Closeable;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface ScatterGatherBackingStore extends Closeable {
    void closeForWriting();

    InputStream getInputStream();

    void writeOut(byte[] bArr, int i5, int i6);
}
