package org.apache.poi.hssf.usermodel;

import org.apache.poi.hssf.record.PrintSetupRecord;
import org.apache.poi.ss.usermodel.PrintSetup;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class HSSFPrintSetup implements PrintSetup {
    PrintSetupRecord printSetupRecord;

    public HSSFPrintSetup(PrintSetupRecord printSetupRecord) {
        this.printSetupRecord = printSetupRecord;
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public short getCopies() {
        return this.printSetupRecord.getCopies();
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public boolean getDraft() {
        return this.printSetupRecord.getDraft();
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public short getFitHeight() {
        return this.printSetupRecord.getFitHeight();
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public short getFitWidth() {
        return this.printSetupRecord.getFitWidth();
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public double getFooterMargin() {
        return this.printSetupRecord.getFooterMargin();
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public short getHResolution() {
        return this.printSetupRecord.getHResolution();
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public double getHeaderMargin() {
        return this.printSetupRecord.getHeaderMargin();
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public boolean getLandscape() {
        return !this.printSetupRecord.getLandscape();
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public boolean getLeftToRight() {
        return this.printSetupRecord.getLeftToRight();
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public boolean getNoColor() {
        return this.printSetupRecord.getNoColor();
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public boolean getNoOrientation() {
        return this.printSetupRecord.getNoOrientation();
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public boolean getNotes() {
        return this.printSetupRecord.getNotes();
    }

    public short getOptions() {
        return this.printSetupRecord.getOptions();
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public short getPageStart() {
        return this.printSetupRecord.getPageStart();
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public short getPaperSize() {
        return this.printSetupRecord.getPaperSize();
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public short getScale() {
        return this.printSetupRecord.getScale();
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public boolean getUsePage() {
        return this.printSetupRecord.getUsePage();
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public short getVResolution() {
        return this.printSetupRecord.getVResolution();
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public boolean getValidSettings() {
        return this.printSetupRecord.getValidSettings();
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public void setCopies(short s6) {
        this.printSetupRecord.setCopies(s6);
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public void setDraft(boolean z6) {
        this.printSetupRecord.setDraft(z6);
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public void setFitHeight(short s6) {
        this.printSetupRecord.setFitHeight(s6);
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public void setFitWidth(short s6) {
        this.printSetupRecord.setFitWidth(s6);
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public void setFooterMargin(double d) {
        this.printSetupRecord.setFooterMargin(d);
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public void setHResolution(short s6) {
        this.printSetupRecord.setHResolution(s6);
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public void setHeaderMargin(double d) {
        this.printSetupRecord.setHeaderMargin(d);
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public void setLandscape(boolean z6) {
        this.printSetupRecord.setLandscape(!z6);
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public void setLeftToRight(boolean z6) {
        this.printSetupRecord.setLeftToRight(z6);
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public void setNoColor(boolean z6) {
        this.printSetupRecord.setNoColor(z6);
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public void setNoOrientation(boolean z6) {
        this.printSetupRecord.setNoOrientation(z6);
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public void setNotes(boolean z6) {
        this.printSetupRecord.setNotes(z6);
    }

    public void setOptions(short s6) {
        this.printSetupRecord.setOptions(s6);
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public void setPageStart(short s6) {
        this.printSetupRecord.setPageStart(s6);
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public void setPaperSize(short s6) {
        this.printSetupRecord.setPaperSize(s6);
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public void setScale(short s6) {
        this.printSetupRecord.setScale(s6);
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public void setUsePage(boolean z6) {
        this.printSetupRecord.setUsePage(z6);
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public void setVResolution(short s6) {
        this.printSetupRecord.setVResolution(s6);
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public void setValidSettings(boolean z6) {
        this.printSetupRecord.setValidSettings(z6);
    }
}
