package org.apache.poi.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.FileAttribute;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class DefaultTempFileCreationStrategy implements TempFileCreationStrategy {
    public static final String DELETE_FILES_ON_EXIT = "poi.delete.tmp.files.on.exit";
    public static final String POIFILES = "poifiles";
    private File dir;

    public DefaultTempFileCreationStrategy() {
        this(null);
    }

    private void createPOIFilesDirectory() throws IOException {
        if (this.dir == null) {
            String property = System.getProperty(TempFile.JAVA_IO_TMPDIR);
            if (property == null) {
                throw new IOException("Systems temporary directory not defined - set the -Djava.io.tmpdir jvm property!");
            }
            this.dir = new File(property, POIFILES);
        }
        createTempDirectory(this.dir);
    }

    private synchronized void createTempDirectory(File file) {
        try {
            if (!file.exists() && !file.mkdirs()) {
                throw new IOException("Could not create temporary directory '" + file + "'");
            }
            if (!file.isDirectory()) {
                throw new IOException("Could not create temporary directory. '" + file + "' exists but is not a directory.");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // org.apache.poi.util.TempFileCreationStrategy
    public File createTempFile(String str, String str2) throws IOException {
        createPOIFilesDirectory();
        File file = Files.createTempFile(this.dir.toPath(), str, str2, new FileAttribute[0]).toFile();
        if (System.getProperty(DELETE_FILES_ON_EXIT) != null) {
            file.deleteOnExit();
        }
        return file;
    }

    public DefaultTempFileCreationStrategy(File file) {
        this.dir = file;
    }

    @Override // org.apache.poi.util.TempFileCreationStrategy
    public File createTempDirectory(String str) throws IOException {
        createPOIFilesDirectory();
        long jNextLong = RandomSingleton.getInstance().nextLong();
        File file = this.dir;
        StringBuilder sbR = androidx.collection.a.r(str);
        sbR.append(Long.toString(jNextLong));
        File file2 = new File(file, sbR.toString());
        createTempDirectory(file2);
        file2.deleteOnExit();
        return file2;
    }
}
