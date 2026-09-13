package org.apache.poi;

import java.io.File;
import java.io.OutputStream;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class POIReadOnlyDocument extends POIDocument {
    public POIReadOnlyDocument(DirectoryNode directoryNode) {
        super(directoryNode);
    }

    private static void notImplemented() {
        throw new IllegalStateException("Writing is not yet implemented for this Document Format");
    }

    @Override // org.apache.poi.POIDocument
    public void write() {
        notImplemented();
    }

    public POIReadOnlyDocument(POIFSFileSystem pOIFSFileSystem) {
        super(pOIFSFileSystem);
    }

    @Override // org.apache.poi.POIDocument
    public void write(File file) {
        notImplemented();
    }

    @Override // org.apache.poi.POIDocument
    public void write(OutputStream outputStream) {
        notImplemented();
    }
}
