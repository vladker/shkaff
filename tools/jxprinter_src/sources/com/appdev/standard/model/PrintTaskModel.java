package com.appdev.standard.model;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class PrintTaskModel {
    private int direction;
    private int labelHeight;
    private int labelWidth;
    private List<PrintTaskElementModel> printTaskElementModels;
    private int printCount = 1;
    private boolean isSame = true;

    public int getDirection() {
        return this.direction;
    }

    public int getLabelHeight() {
        return this.labelHeight;
    }

    public int getLabelWidth() {
        return this.labelWidth;
    }

    public int getPrintCount() {
        return this.printCount;
    }

    public List<PrintTaskElementModel> getPrintTaskElementModels() {
        return this.printTaskElementModels;
    }

    public boolean isSame() {
        return this.isSame;
    }

    public void setDirection(int i5) {
        this.direction = i5;
    }

    public void setLabelHeight(int i5) {
        this.labelHeight = i5;
    }

    public void setLabelWidth(int i5) {
        this.labelWidth = i5;
    }

    public void setPrintCount(int i5) {
        this.printCount = i5;
    }

    public void setPrintTaskElementModels(List<PrintTaskElementModel> list) {
        this.printTaskElementModels = list;
    }

    public void setSame(boolean z6) {
        this.isSame = z6;
    }

    public String toString() {
        return "PrintTaskModel{printTaskElementModels=" + this.printTaskElementModels + ", labelWidth=" + this.labelWidth + ", labelHeight=" + this.labelHeight + ", direction=" + this.direction + ", printCount=" + this.printCount + ", isSame=" + this.isSame + '}';
    }
}
