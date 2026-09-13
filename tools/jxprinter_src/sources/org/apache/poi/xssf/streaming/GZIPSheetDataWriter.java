package org.apache.poi.xssf.streaming;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.apache.poi.util.Removal;
import org.apache.poi.util.TempFile;
import org.apache.poi.xssf.model.SharedStringsTable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class GZIPSheetDataWriter extends SheetDataWriter {
    public GZIPSheetDataWriter() {
    }

    @Override // org.apache.poi.xssf.streaming.SheetDataWriter
    @Removal(version = "6.0.0")
    @Deprecated
    public File createTempFile() {
        return TempFile.createTempFile("poi-sxssf-sheet-xml", ".gz");
    }

    @Override // org.apache.poi.xssf.streaming.SheetDataWriter
    public InputStream decorateInputStream(FileInputStream fileInputStream) {
        return new GZIPInputStream(fileInputStream);
    }

    @Override // org.apache.poi.xssf.streaming.SheetDataWriter
    public OutputStream decorateOutputStream(FileOutputStream fileOutputStream) {
        return new GZIPOutputStream(fileOutputStream);
    }

    public GZIPSheetDataWriter(SharedStringsTable sharedStringsTable) {
        super(sharedStringsTable);
    }
}
