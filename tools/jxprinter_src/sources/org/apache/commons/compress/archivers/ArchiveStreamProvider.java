package org.apache.commons.compress.archivers;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface ArchiveStreamProvider {
    ArchiveInputStream createArchiveInputStream(String str, InputStream inputStream, String str2);

    ArchiveOutputStream createArchiveOutputStream(String str, OutputStream outputStream, String str2);

    Set<String> getInputStreamArchiveNames();

    Set<String> getOutputStreamArchiveNames();
}
