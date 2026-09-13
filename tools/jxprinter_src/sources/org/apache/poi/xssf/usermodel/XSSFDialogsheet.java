package org.apache.poi.xssf.usermodel;

import org.apache.poi.ss.usermodel.Sheet;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDialogsheet;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTHeaderFooter;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageBreak;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageMargins;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPrintOptions;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetFormatPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetProtection;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetViews;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XSSFDialogsheet extends XSSFSheet implements Sheet {
    protected CTDialogsheet dialogsheet;

    public XSSFDialogsheet(XSSFSheet xSSFSheet) {
        super(xSSFSheet.getPackagePart());
        this.dialogsheet = CTDialogsheet.Factory.newInstance();
        this.worksheet = CTWorksheet.Factory.newInstance();
    }

    @Override // org.apache.poi.xssf.usermodel.XSSFSheet, org.apache.poi.ss.usermodel.Sheet
    public XSSFRow createRow(int i5) {
        return null;
    }

    public boolean getDialog() {
        return true;
    }

    public CTPageBreak getDialogColumnBreaks() {
        return null;
    }

    public CTHeaderFooter getDialogHeaderFooter() {
        if (this.dialogsheet.getHeaderFooter() == null) {
            this.dialogsheet.setHeaderFooter(CTHeaderFooter.Factory.newInstance());
        }
        return this.dialogsheet.getHeaderFooter();
    }

    public CTPageMargins getDialogPageMargins() {
        if (this.dialogsheet.getPageMargins() == null) {
            this.dialogsheet.setPageMargins(CTPageMargins.Factory.newInstance());
        }
        return this.dialogsheet.getPageMargins();
    }

    public CTPrintOptions getDialogPrintOptions() {
        if (this.dialogsheet.getPrintOptions() == null) {
            this.dialogsheet.setPrintOptions(CTPrintOptions.Factory.newInstance());
        }
        return this.dialogsheet.getPrintOptions();
    }

    public CTSheetProtection getDialogProtection() {
        if (this.dialogsheet.getSheetProtection() == null) {
            this.dialogsheet.setSheetProtection(CTSheetProtection.Factory.newInstance());
        }
        return this.dialogsheet.getSheetProtection();
    }

    public CTPageBreak getDialogRowBreaks() {
        return null;
    }

    public CTSheetFormatPr getDialogSheetFormatPr() {
        if (this.dialogsheet.getSheetFormatPr() == null) {
            this.dialogsheet.setSheetFormatPr(CTSheetFormatPr.Factory.newInstance());
        }
        return this.dialogsheet.getSheetFormatPr();
    }

    public CTSheetPr getDialogSheetPr() {
        if (this.dialogsheet.getSheetPr() == null) {
            this.dialogsheet.setSheetPr(CTSheetPr.Factory.newInstance());
        }
        return this.dialogsheet.getSheetPr();
    }

    public CTSheetViews getDialogSheetViews() {
        if (this.dialogsheet.getSheetViews() == null) {
            this.dialogsheet.setSheetViews(CTSheetViews.Factory.newInstance());
            this.dialogsheet.getSheetViews().addNewSheetView();
        }
        return this.dialogsheet.getSheetViews();
    }
}
