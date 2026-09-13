package org.apache.poi.xssf.streaming;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class DeferredSXSSFSheet extends SXSSFSheet {
    private RowGeneratorFunction rowGenerator;

    public DeferredSXSSFSheet(DeferredSXSSFWorkbook deferredSXSSFWorkbook, XSSFSheet xSSFSheet) {
        super(deferredSXSSFWorkbook, xSSFSheet, deferredSXSSFWorkbook.getRandomAccessWindowSize());
    }

    @Override // org.apache.poi.xssf.streaming.SXSSFSheet
    public InputStream getWorksheetXMLInputStream() {
        throw new RuntimeException("Not supported by DeferredSXSSFSheet");
    }

    public void setRowGenerator(RowGeneratorFunction rowGeneratorFunction) {
        this.rowGenerator = rowGeneratorFunction;
    }

    public void writeRows(OutputStream outputStream) {
        this._writer = ((DeferredSXSSFWorkbook) this._workbook).createSheetDataWriter(outputStream);
        try {
            try {
                RowGeneratorFunction rowGeneratorFunction = this.rowGenerator;
                if (rowGeneratorFunction != null) {
                    rowGeneratorFunction.generateRows(this);
                }
                flushRows(0);
                this._writer.close();
                outputStream.flush();
            } catch (Exception e) {
                throw new IOException("Error generating Excel rows", e);
            }
        } catch (Throwable th) {
            flushRows(0);
            this._writer.close();
            outputStream.flush();
            throw th;
        }
    }
}
