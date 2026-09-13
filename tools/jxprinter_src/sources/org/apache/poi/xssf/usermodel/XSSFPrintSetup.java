package org.apache.poi.xssf.usermodel;

import org.apache.poi.ooxml.POIXMLException;
import org.apache.poi.ss.usermodel.PageOrder;
import org.apache.poi.ss.usermodel.PaperSize;
import org.apache.poi.ss.usermodel.PrintCellComments;
import org.apache.poi.ss.usermodel.PrintOrientation;
import org.apache.poi.ss.usermodel.PrintSetup;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageMargins;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STCellComments;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STOrientation;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STPageOrder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XSSFPrintSetup implements PrintSetup {
    private CTWorksheet ctWorksheet;
    private CTPageMargins pageMargins;
    private CTPageSetup pageSetup;

    public XSSFPrintSetup(CTWorksheet cTWorksheet) {
        this.ctWorksheet = cTWorksheet;
        if (cTWorksheet.isSetPageSetup()) {
            this.pageSetup = this.ctWorksheet.getPageSetup();
        } else {
            this.pageSetup = this.ctWorksheet.addNewPageSetup();
        }
        if (this.ctWorksheet.isSetPageMargins()) {
            this.pageMargins = this.ctWorksheet.getPageMargins();
        } else {
            this.pageMargins = this.ctWorksheet.addNewPageMargins();
        }
    }

    public double getBottomMargin() {
        return this.pageMargins.getBottom();
    }

    public PrintCellComments getCellComment() {
        STCellComments.Enum cellComments = this.pageSetup.getCellComments();
        return cellComments == null ? PrintCellComments.NONE : PrintCellComments.valueOf(cellComments.intValue());
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public short getCopies() {
        return (short) this.pageSetup.getCopies();
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public boolean getDraft() {
        return this.pageSetup.getDraft();
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public short getFitHeight() {
        return (short) this.pageSetup.getFitToHeight();
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public short getFitWidth() {
        return (short) this.pageSetup.getFitToWidth();
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public double getFooterMargin() {
        return this.pageMargins.getFooter();
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public short getHResolution() {
        return (short) this.pageSetup.getHorizontalDpi();
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public double getHeaderMargin() {
        return this.pageMargins.getHeader();
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public boolean getLandscape() {
        return getOrientation() == PrintOrientation.LANDSCAPE;
    }

    public double getLeftMargin() {
        return this.pageMargins.getLeft();
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public boolean getLeftToRight() {
        return getPageOrder() == PageOrder.OVER_THEN_DOWN;
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public boolean getNoColor() {
        return this.pageSetup.getBlackAndWhite();
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public boolean getNoOrientation() {
        return getOrientation() == PrintOrientation.DEFAULT;
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public boolean getNotes() {
        return getCellComment() == PrintCellComments.AS_DISPLAYED;
    }

    public PrintOrientation getOrientation() {
        STOrientation.Enum orientation = this.pageSetup.getOrientation();
        return orientation == null ? PrintOrientation.DEFAULT : PrintOrientation.valueOf(orientation.intValue());
    }

    public PageOrder getPageOrder() {
        if (this.pageSetup.getPageOrder() == null) {
            return null;
        }
        return PageOrder.valueOf(this.pageSetup.getPageOrder().intValue());
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public short getPageStart() {
        return (short) this.pageSetup.getFirstPageNumber();
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public short getPaperSize() {
        return (short) this.pageSetup.getPaperSize();
    }

    public PaperSize getPaperSizeEnum() {
        return PaperSize.values()[getPaperSize() - 1];
    }

    public double getRightMargin() {
        return this.pageMargins.getRight();
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public short getScale() {
        return (short) this.pageSetup.getScale();
    }

    public double getTopMargin() {
        return this.pageMargins.getTop();
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public boolean getUsePage() {
        return this.pageSetup.getUseFirstPageNumber();
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public short getVResolution() {
        return (short) this.pageSetup.getVerticalDpi();
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public boolean getValidSettings() {
        return this.pageSetup.getUsePrinterDefaults();
    }

    public void setBottomMargin(double d) {
        this.pageMargins.setBottom(d);
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public void setCopies(short s6) {
        this.pageSetup.setCopies(s6);
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public void setDraft(boolean z6) {
        this.pageSetup.setDraft(z6);
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public void setFitHeight(short s6) {
        this.pageSetup.setFitToHeight(s6);
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public void setFitWidth(short s6) {
        this.pageSetup.setFitToWidth(s6);
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public void setFooterMargin(double d) {
        this.pageMargins.setFooter(d);
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public void setHResolution(short s6) {
        this.pageSetup.setHorizontalDpi(s6);
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public void setHeaderMargin(double d) {
        this.pageMargins.setHeader(d);
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public void setLandscape(boolean z6) {
        if (z6) {
            setOrientation(PrintOrientation.LANDSCAPE);
        } else {
            setOrientation(PrintOrientation.PORTRAIT);
        }
    }

    public void setLeftMargin(double d) {
        this.pageMargins.setLeft(d);
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public void setLeftToRight(boolean z6) {
        if (z6) {
            setPageOrder(PageOrder.OVER_THEN_DOWN);
        } else {
            setPageOrder(PageOrder.DOWN_THEN_OVER);
        }
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public void setNoColor(boolean z6) {
        this.pageSetup.setBlackAndWhite(z6);
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public void setNoOrientation(boolean z6) {
        if (z6) {
            setOrientation(PrintOrientation.DEFAULT);
        }
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public void setNotes(boolean z6) {
        if (z6) {
            this.pageSetup.setCellComments(STCellComments.AS_DISPLAYED);
        }
    }

    public void setOrientation(PrintOrientation printOrientation) {
        this.pageSetup.setOrientation(STOrientation.Enum.forInt(printOrientation.getValue()));
    }

    public void setPageOrder(PageOrder pageOrder) {
        this.pageSetup.setPageOrder(STPageOrder.Enum.forInt(pageOrder.getValue()));
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public void setPageStart(short s6) {
        this.pageSetup.setFirstPageNumber(s6);
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public void setPaperSize(short s6) {
        this.pageSetup.setPaperSize(s6);
    }

    public void setRightMargin(double d) {
        this.pageMargins.setRight(d);
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public void setScale(short s6) {
        if (s6 < 10 || s6 > 400) {
            throw new POIXMLException("Scale value not accepted: you must choose a value between 10 and 400.");
        }
        this.pageSetup.setScale(s6);
    }

    public void setTopMargin(double d) {
        this.pageMargins.setTop(d);
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public void setUsePage(boolean z6) {
        this.pageSetup.setUseFirstPageNumber(z6);
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public void setVResolution(short s6) {
        this.pageSetup.setVerticalDpi(s6);
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public void setValidSettings(boolean z6) {
        this.pageSetup.setUsePrinterDefaults(z6);
    }

    public void setPaperSize(PaperSize paperSize) {
        setPaperSize((short) (paperSize.ordinal() + 1));
    }
}
