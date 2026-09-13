package org.apache.poi.sl.usermodel;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.logging.log4j.LogManager;
import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.FileMagic;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.util.IOUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface ObjectData {
    default byte[] getBytes() throws IOException {
        InputStream inputStream = getInputStream();
        try {
            byte[] byteArray = IOUtils.toByteArray(inputStream);
            if (inputStream != null) {
                inputStream.close();
            }
            return byteArray;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    default DirectoryEntry getDirectory() throws IOException {
        InputStream inputStream = getInputStream();
        try {
            DirectoryNode root = new POIFSFileSystem(inputStream).getRoot();
            if (inputStream != null) {
                inputStream.close();
            }
            return root;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    String getFileName();

    InputStream getInputStream();

    String getOLE2ClassName();

    OutputStream getOutputStream();

    default boolean hasDirectoryEntry() {
        try {
            InputStream inputStreamPrepareToCheckMagic = FileMagic.prepareToCheckMagic(getInputStream());
            try {
                boolean z6 = FileMagic.valueOf(inputStreamPrepareToCheckMagic) == FileMagic.OLE2;
                if (inputStreamPrepareToCheckMagic == null) {
                    return z6;
                }
                inputStreamPrepareToCheckMagic.close();
                return z6;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (inputStreamPrepareToCheckMagic != null) {
                        try {
                            inputStreamPrepareToCheckMagic.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        } catch (IOException e) {
            LogManager.getLogger((Class<?>) ObjectData.class).atWarn().withThrowable(e).log("Can't determine filemagic of ole stream");
            return false;
        }
    }
}
