package org.apache.poi.poifs.filesystem;

import java.io.File;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.poifs.nio.FileBackedDataSource;
import org.apache.poi.util.TempFile;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class TempFilePOIFSFileSystem extends POIFSFileSystem {
    private static Logger LOG = LogManager.getLogger((Class<?>) TempFilePOIFSFileSystem.class);
    File tempFile;

    @Override // org.apache.poi.poifs.filesystem.POIFSFileSystem, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        File file = this.tempFile;
        if (file != null && file.exists() && !this.tempFile.delete()) {
            LOG.atDebug().log("temp file was already deleted (probably due to previous call to close this resource)");
        }
        super.close();
    }

    @Override // org.apache.poi.poifs.filesystem.POIFSFileSystem
    public void createNewDataSource() {
        try {
            this.tempFile = TempFile.createTempFile("poifs", ".tmp");
            this._data = new FileBackedDataSource(this.tempFile, false);
        } catch (IOException e) {
            throw new RuntimeException("Failed to create data source", e);
        }
    }
}
