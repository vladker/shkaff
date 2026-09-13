package com.appdev.standard.model;

import A3.AbstractC0157z;
import android.graphics.Bitmap;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class PrintTaskElementModel {
    private Bitmap bitmap;
    private int leftMargin;
    private int topMargin;

    public PrintTaskElementModel(Bitmap bitmap, int i5, int i6) {
        this.bitmap = bitmap;
        this.leftMargin = i5;
        this.topMargin = i6;
    }

    public Bitmap getBitmap() {
        return this.bitmap;
    }

    public int getLeftMargin() {
        return this.leftMargin;
    }

    public int getTopMargin() {
        return this.topMargin;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public void setLeftMargin(int i5) {
        this.leftMargin = i5;
    }

    public void setTopMargin(int i5) {
        this.topMargin = i5;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PrintTaskElementModel{, leftMargin=");
        sb.append(this.leftMargin);
        sb.append(", topMargin=");
        return AbstractC0157z.p(sb, this.topMargin, '}');
    }
}
