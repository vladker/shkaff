package org.apache.poi.xssf.streaming;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.openxml4j.opc.g;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.util.NotImplemented;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class DeferredSXSSFWorkbook extends SXSSFWorkbook {
    private static final Logger LOG = LogManager.getLogger((Class<?>) DeferredSXSSFWorkbook.class);

    public DeferredSXSSFWorkbook() {
        this((XSSFWorkbook) null);
    }

    @Override // org.apache.poi.xssf.streaming.SXSSFWorkbook
    public SXSSFSheet createAndRegisterSXSSFSheet(XSSFSheet xSSFSheet) {
        try {
            DeferredSXSSFSheet deferredSXSSFSheet = new DeferredSXSSFSheet(this, xSSFSheet);
            registerSheetMapping(deferredSXSSFSheet, xSSFSheet);
            return deferredSXSSFSheet;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // org.apache.poi.xssf.streaming.SXSSFWorkbook
    @NotImplemented
    public SheetDataWriter createSheetDataWriter() {
        throw new RuntimeException("Not supported by DeferredSXSSFWorkbook");
    }

    @Override // org.apache.poi.xssf.streaming.SXSSFWorkbook
    public SXSSFWorkbook.ISheetInjector createSheetInjector(SXSSFSheet sXSSFSheet) {
        return new g((DeferredSXSSFSheet) sXSSFSheet, 3);
    }

    public DeferredSXSSFSheet getStreamingSheet(String str) {
        XSSFSheet sheet = this._wb.getSheet(str);
        DeferredSXSSFSheet deferredSXSSFSheet = (DeferredSXSSFSheet) getSXSSFSheet(sheet);
        return (deferredSXSSFSheet != null || sheet == null) ? deferredSXSSFSheet : (DeferredSXSSFSheet) createAndRegisterSXSSFSheet(sheet);
    }

    public DeferredSXSSFSheet getStreamingSheetAt(int i5) {
        XSSFSheet sheetAt = this._wb.getSheetAt(i5);
        SXSSFSheet sXSSFSheet = getSXSSFSheet(sheetAt);
        return (sXSSFSheet != null || sheetAt == null) ? (DeferredSXSSFSheet) sXSSFSheet : (DeferredSXSSFSheet) createAndRegisterSXSSFSheet(sheetAt);
    }

    public XSSFSheet getXSSFSheet(String str) {
        return this._wb.getSheet(str);
    }

    @Override // org.apache.poi.xssf.streaming.SXSSFWorkbook, org.apache.poi.ss.usermodel.Workbook
    public void removeSheetAt(int i5) {
        XSSFSheet sheetAt = this._wb.getSheetAt(i5);
        SXSSFSheet sXSSFSheet = getSXSSFSheet(sheetAt);
        this._wb.removeSheetAt(i5);
        if (sXSSFSheet != null) {
            deregisterSheetMapping(sheetAt);
            try {
                sXSSFSheet.dispose();
            } catch (IOException e) {
                LOG.atWarn().withThrowable(e).log("Failed to cleanup old sheet");
            }
        }
    }

    @Override // org.apache.poi.xssf.streaming.SXSSFWorkbook, org.apache.poi.ss.usermodel.Workbook
    public Iterator<Sheet> sheetIterator() {
        return new SXSSFWorkbook.SheetIterator();
    }

    public DeferredSXSSFWorkbook(int i5) {
        this(null, i5);
    }

    public StreamingSheetWriter createSheetDataWriter(OutputStream outputStream) {
        return new StreamingSheetWriter(outputStream);
    }

    public DeferredSXSSFWorkbook(XSSFWorkbook xSSFWorkbook) {
        this(xSSFWorkbook, 100);
    }

    public DeferredSXSSFWorkbook(XSSFWorkbook xSSFWorkbook, int i5) {
        super(xSSFWorkbook, i5, false, false);
    }

    @Override // org.apache.poi.xssf.streaming.SXSSFWorkbook, org.apache.poi.ss.usermodel.Workbook
    public DeferredSXSSFSheet createSheet() {
        return (DeferredSXSSFSheet) super.createSheet();
    }

    @Override // org.apache.poi.xssf.streaming.SXSSFWorkbook, org.apache.poi.ss.usermodel.Workbook
    public DeferredSXSSFSheet createSheet(String str) {
        return (DeferredSXSSFSheet) super.createSheet(str);
    }
}
