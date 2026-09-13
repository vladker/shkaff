package org.apache.poi.openxml4j.opc.internal;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.StreamHelper;
import org.w3c.dom.Document;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class ZipContentTypeManager extends ContentTypeManager {
    private static final Logger LOG = LogManager.getLogger((Class<?>) ZipContentTypeManager.class);

    public ZipContentTypeManager(InputStream inputStream, OPCPackage oPCPackage) {
        super(inputStream, oPCPackage);
    }

    @Override // org.apache.poi.openxml4j.opc.internal.ContentTypeManager
    public boolean saveImpl(Document document, OutputStream outputStream) {
        ZipArchiveOutputStream zipArchiveOutputStream = outputStream instanceof ZipArchiveOutputStream ? (ZipArchiveOutputStream) outputStream : new ZipArchiveOutputStream(outputStream);
        try {
            zipArchiveOutputStream.putArchiveEntry(new ZipArchiveEntry(ContentTypeManager.CONTENT_TYPES_PART_NAME));
            try {
                return StreamHelper.saveXmlInStream(document, zipArchiveOutputStream);
            } finally {
                zipArchiveOutputStream.closeArchiveEntry();
            }
        } catch (IOException e) {
            LOG.atError().withThrowable(e).log("Cannot write: [Content_Types].xml in Zip !");
            return false;
        }
    }
}
