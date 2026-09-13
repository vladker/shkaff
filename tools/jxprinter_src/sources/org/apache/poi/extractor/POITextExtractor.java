package org.apache.poi.extractor;

import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface POITextExtractor extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    default void close() throws IOException {
        Closeable filesystem = getFilesystem();
        if (!isCloseFilesystem() || filesystem == null) {
            return;
        }
        filesystem.close();
    }

    Object getDocument();

    Closeable getFilesystem();

    POITextExtractor getMetadataTextExtractor();

    String getText();

    boolean isCloseFilesystem();

    void setCloseFilesystem(boolean z6);
}
