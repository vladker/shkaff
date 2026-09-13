package org.apache.poi.hssf.eventusermodel;

import java.io.InputStream;
import java.util.Iterator;
import java.util.Set;
import org.apache.poi.hssf.model.InternalWorkbook;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.hssf.record.RecordFactoryInputStream;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.DocumentInputStream;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class HSSFEventFactory {
    private short genericProcessEvents(HSSFRequest hSSFRequest, InputStream inputStream) {
        short sProcessRecord = 0;
        RecordFactoryInputStream recordFactoryInputStream = new RecordFactoryInputStream(inputStream, false);
        do {
            Record recordNextRecord = recordFactoryInputStream.nextRecord();
            if (recordNextRecord == null) {
                return sProcessRecord;
            }
            sProcessRecord = hSSFRequest.processRecord(recordNextRecord);
        } while (sProcessRecord == 0);
        return sProcessRecord;
    }

    public short abortableProcessEvents(HSSFRequest hSSFRequest, InputStream inputStream) {
        return genericProcessEvents(hSSFRequest, inputStream);
    }

    public short abortableProcessWorkbookEvents(HSSFRequest hSSFRequest, POIFSFileSystem pOIFSFileSystem) {
        return abortableProcessWorkbookEvents(hSSFRequest, pOIFSFileSystem.getRoot());
    }

    public void processEvents(HSSFRequest hSSFRequest, InputStream inputStream) {
        try {
            genericProcessEvents(hSSFRequest, inputStream);
        } catch (HSSFUserException unused) {
        }
    }

    public void processWorkbookEvents(HSSFRequest hSSFRequest, POIFSFileSystem pOIFSFileSystem) {
        processWorkbookEvents(hSSFRequest, pOIFSFileSystem.getRoot());
    }

    public short abortableProcessWorkbookEvents(HSSFRequest hSSFRequest, DirectoryNode directoryNode) {
        DocumentInputStream documentInputStreamCreateDocumentInputStream = directoryNode.createDocumentInputStream("Workbook");
        try {
            short sAbortableProcessEvents = abortableProcessEvents(hSSFRequest, documentInputStreamCreateDocumentInputStream);
            if (documentInputStreamCreateDocumentInputStream != null) {
                documentInputStreamCreateDocumentInputStream.close();
            }
            return sAbortableProcessEvents;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (documentInputStreamCreateDocumentInputStream != null) {
                    try {
                        documentInputStreamCreateDocumentInputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    public void processWorkbookEvents(HSSFRequest hSSFRequest, DirectoryNode directoryNode) {
        String next;
        Set<String> entryNames = directoryNode.getEntryNames();
        Iterator<String> it = InternalWorkbook.WORKBOOK_DIR_ENTRY_NAMES.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!entryNames.contains(next));
        if (next == null) {
            next = InternalWorkbook.WORKBOOK_DIR_ENTRY_NAMES.get(0);
        }
        DocumentInputStream documentInputStreamCreateDocumentInputStream = directoryNode.createDocumentInputStream(next);
        try {
            processEvents(hSSFRequest, documentInputStreamCreateDocumentInputStream);
            if (documentInputStreamCreateDocumentInputStream != null) {
                documentInputStreamCreateDocumentInputStream.close();
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (documentInputStreamCreateDocumentInputStream != null) {
                    try {
                        documentInputStreamCreateDocumentInputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }
}
