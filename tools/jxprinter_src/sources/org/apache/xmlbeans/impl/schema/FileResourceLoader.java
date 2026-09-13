package org.apache.xmlbeans.impl.schema;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.apache.xmlbeans.ResourceLoader;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class FileResourceLoader implements ResourceLoader {
    private File _directory;
    private ZipFile _zipfile;

    public FileResourceLoader(File file) {
        if (file.isDirectory()) {
            this._directory = file;
        } else {
            this._zipfile = new ZipFile(file);
        }
    }

    @Override // org.apache.xmlbeans.ResourceLoader
    public void close() {
        ZipFile zipFile = this._zipfile;
        if (zipFile != null) {
            try {
                zipFile.close();
            } catch (IOException unused) {
            }
            this._zipfile = null;
        }
    }

    @Override // org.apache.xmlbeans.ResourceLoader
    public InputStream getResourceAsStream(String str) {
        try {
            ZipFile zipFile = this._zipfile;
            if (zipFile == null) {
                return new FileInputStream(new File(this._directory, str));
            }
            ZipEntry entry = zipFile.getEntry(str);
            if (entry == null) {
                return null;
            }
            return this._zipfile.getInputStream(entry);
        } catch (IOException unused) {
            return null;
        }
    }
}
