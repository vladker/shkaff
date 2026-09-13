package org.apache.poi.hpsf;

import java.io.File;
import java.io.OutputStream;
import java.util.ArrayList;
import org.apache.poi.POIDocument;
import org.apache.poi.poifs.filesystem.EntryUtils;
import org.apache.poi.poifs.filesystem.FilteringDirectoryNode;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class HPSFPropertiesOnlyDocument extends POIDocument {
    public HPSFPropertiesOnlyDocument(POIFSFileSystem pOIFSFileSystem) {
        super(pOIFSFileSystem);
    }

    @Override // org.apache.poi.POIDocument
    public void write() {
        POIFSFileSystem fileSystem = getDirectory().getFileSystem();
        validateInPlaceWritePossible();
        writeProperties(fileSystem, null);
        fileSystem.writeFilesystem();
    }

    @Override // org.apache.poi.POIDocument
    public void write(File file) {
        POIFSFileSystem pOIFSFileSystemCreate = POIFSFileSystem.create(file);
        try {
            write(pOIFSFileSystemCreate);
            pOIFSFileSystemCreate.writeFilesystem();
            pOIFSFileSystemCreate.close();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (pOIFSFileSystemCreate != null) {
                    try {
                        pOIFSFileSystemCreate.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    @Override // org.apache.poi.POIDocument
    public void write(OutputStream outputStream) {
        POIFSFileSystem pOIFSFileSystem = new POIFSFileSystem();
        try {
            write(pOIFSFileSystem);
            pOIFSFileSystem.writeFilesystem(outputStream);
            pOIFSFileSystem.close();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    pOIFSFileSystem.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    private void write(POIFSFileSystem pOIFSFileSystem) {
        ArrayList arrayList = new ArrayList(2);
        writeProperties(pOIFSFileSystem, arrayList);
        EntryUtils.copyNodes(new FilteringDirectoryNode(getDirectory(), arrayList), new FilteringDirectoryNode(pOIFSFileSystem.getRoot(), arrayList));
    }
}
