package org.apache.poi.extractor;

import java.io.File;
import java.io.InputStream;
import java.util.Iterator;
import org.apache.poi.hssf.extractor.EventBasedExcelExtractor;
import org.apache.poi.hssf.extractor.ExcelExtractor;
import org.apache.poi.hssf.extractor.OldExcelExtractor;
import org.apache.poi.hssf.model.InternalWorkbook;
import org.apache.poi.hssf.record.crypto.Biff8EncryptionKey;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.FileMagic;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class MainExtractorFactory implements ExtractorProvider {
    @Override // org.apache.poi.extractor.ExtractorProvider
    public boolean accepts(FileMagic fileMagic) {
        return FileMagic.OLE2 == fileMagic;
    }

    @Override // org.apache.poi.extractor.ExtractorProvider
    public POITextExtractor create(File file, String str) {
        return create(new POIFSFileSystem(file, true).getRoot(), str);
    }

    @Override // org.apache.poi.extractor.ExtractorProvider
    public POITextExtractor create(InputStream inputStream, String str) {
        return create(new POIFSFileSystem(inputStream).getRoot(), str);
    }

    @Override // org.apache.poi.extractor.ExtractorProvider
    public POITextExtractor create(DirectoryNode directoryNode, String str) {
        String currentUserPassword = Biff8EncryptionKey.getCurrentUserPassword();
        try {
            Biff8EncryptionKey.setCurrentUserPassword(str);
            Iterator<String> it = InternalWorkbook.WORKBOOK_DIR_ENTRY_NAMES.iterator();
            while (it.hasNext()) {
                if (directoryNode.hasEntry(it.next())) {
                    POITextExtractor eventBasedExcelExtractor = ExtractorFactory.getPreferEventExtractor() ? new EventBasedExcelExtractor(directoryNode) : new ExcelExtractor(directoryNode);
                    Biff8EncryptionKey.setCurrentUserPassword(currentUserPassword);
                    return eventBasedExcelExtractor;
                }
            }
            if (!directoryNode.hasEntry(InternalWorkbook.OLD_WORKBOOK_DIR_ENTRY_NAME)) {
                Biff8EncryptionKey.setCurrentUserPassword(currentUserPassword);
                return null;
            }
            OldExcelExtractor oldExcelExtractor = new OldExcelExtractor(directoryNode);
            Biff8EncryptionKey.setCurrentUserPassword(currentUserPassword);
            return oldExcelExtractor;
        } catch (Throwable th) {
            Biff8EncryptionKey.setCurrentUserPassword(currentUserPassword);
            throw th;
        }
    }
}
