package org.apache.poi.hssf.usermodel;

import java.io.File;
import java.io.InputStream;
import org.apache.poi.hssf.record.crypto.Biff8EncryptionKey;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.FileMagic;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookProvider;
import org.apache.poi.util.Internal;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
public class HSSFWorkbookFactory implements WorkbookProvider {
    public static HSSFWorkbook createWorkbook(POIFSFileSystem pOIFSFileSystem) {
        return new HSSFWorkbook(pOIFSFileSystem);
    }

    @Override // org.apache.poi.ss.usermodel.WorkbookProvider
    public boolean accepts(FileMagic fileMagic) {
        return FileMagic.OLE2 == fileMagic;
    }

    @Override // org.apache.poi.ss.usermodel.WorkbookProvider
    public HSSFWorkbook create() {
        return new HSSFWorkbook();
    }

    @Override // org.apache.poi.ss.usermodel.WorkbookProvider
    public HSSFWorkbook create(DirectoryNode directoryNode, String str) {
        boolean z6;
        if (str != null) {
            Biff8EncryptionKey.setCurrentUserPassword(str);
            z6 = true;
        } else {
            z6 = false;
        }
        try {
            return new HSSFWorkbook(directoryNode, true);
        } finally {
            if (z6) {
                Biff8EncryptionKey.setCurrentUserPassword(null);
            }
        }
    }

    @Override // org.apache.poi.ss.usermodel.WorkbookProvider
    public Workbook create(InputStream inputStream) {
        return create(inputStream, (String) null);
    }

    @Override // org.apache.poi.ss.usermodel.WorkbookProvider
    public Workbook create(InputStream inputStream, String str) {
        return create(new POIFSFileSystem(inputStream).getRoot(), str);
    }

    @Override // org.apache.poi.ss.usermodel.WorkbookProvider
    public Workbook create(File file, String str, boolean z6) {
        boolean z7;
        if (str != null) {
            Biff8EncryptionKey.setCurrentUserPassword(str);
            z7 = true;
        } else {
            z7 = false;
        }
        try {
            POIFSFileSystem pOIFSFileSystem = new POIFSFileSystem(file, z6);
            try {
                HSSFWorkbook hSSFWorkbook = new HSSFWorkbook(pOIFSFileSystem, true);
                if (z7) {
                    Biff8EncryptionKey.setCurrentUserPassword(null);
                }
                return hSSFWorkbook;
            } catch (RuntimeException e) {
                pOIFSFileSystem.close();
                throw e;
            }
        } catch (Throwable th) {
            if (z7) {
                Biff8EncryptionKey.setCurrentUserPassword(null);
            }
            throw th;
        }
    }
}
