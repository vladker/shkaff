package org.apache.commons.compress.compressors;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface CompressorStreamProvider {
    CompressorInputStream createCompressorInputStream(String str, InputStream inputStream, boolean z6);

    CompressorOutputStream createCompressorOutputStream(String str, OutputStream outputStream);

    Set<String> getInputStreamCompressorNames();

    Set<String> getOutputStreamCompressorNames();
}
