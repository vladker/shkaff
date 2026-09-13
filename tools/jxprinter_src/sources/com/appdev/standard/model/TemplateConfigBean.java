package com.appdev.standard.model;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class TemplateConfigBean implements Serializable {
    private int columns;
    private float hOffset;
    private int height;
    private String name;
    private int paperType;
    private String printerLabelBgUrl;
    private String printerLabelBorderUrl;
    private int rotate;
    private int spacing;
    private String templateId;
    private float vOffset;
    private int width;

    public TemplateConfigBean(String str, int i5, int i6, int i7, int i8) {
        this.hOffset = 0.0f;
        this.vOffset = 0.0f;
        this.printerLabelBgUrl = null;
        this.printerLabelBorderUrl = null;
        this.paperType = 0;
        this.rotate = 0;
        this.name = str;
        this.width = i5;
        this.height = i6;
        this.columns = i7;
        this.spacing = i8;
    }

    public int getColumns() {
        return this.columns;
    }

    public int getHeight() {
        return this.height;
    }

    public String getName() {
        return this.name;
    }

    public int getPaperType() {
        return this.paperType;
    }

    public String getPrinterLabelBgUrl() {
        return this.printerLabelBgUrl;
    }

    public String getPrinterLabelBorderUrl() {
        return this.printerLabelBorderUrl;
    }

    public int getRotate() {
        return this.rotate;
    }

    public int getSpacing() {
        return this.spacing;
    }

    public String getTemplateId() {
        return this.templateId;
    }

    public int getWidth() {
        return this.width;
    }

    public float gethOffset() {
        return this.hOffset;
    }

    public float getvOffset() {
        return this.vOffset;
    }

    public void setColumns(int i5) {
        this.columns = i5;
    }

    public void setHeight(int i5) {
        this.height = i5;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPaperType(int i5) {
        this.paperType = i5;
    }

    public void setPrinterLabelBgUrl(String str) {
        this.printerLabelBgUrl = str;
    }

    public void setPrinterLabelBorderUrl(String str) {
        this.printerLabelBorderUrl = str;
    }

    public void setRotate(int i5) {
        this.rotate = i5;
    }

    public void setSpacing(int i5) {
        this.spacing = i5;
    }

    public void setTemplateId(String str) {
        this.templateId = str;
    }

    public void setWidth(int i5) {
        this.width = i5;
    }

    public void sethOffset(float f6) {
        this.hOffset = f6;
    }

    public void setvOffset(float f6) {
        this.vOffset = f6;
    }

    public boolean unequals(TemplateConfigBean templateConfigBean) {
        return (this.name.equals(templateConfigBean.name) && this.width == templateConfigBean.width && this.height == templateConfigBean.height) ? false : true;
    }

    public TemplateConfigBean(String str, int i5, int i6, int i7, int i8, String str2, String str3) {
        this.hOffset = 0.0f;
        this.vOffset = 0.0f;
        this.printerLabelBorderUrl = null;
        this.paperType = 0;
        this.rotate = 0;
        this.name = str;
        this.width = i5;
        this.height = i6;
        this.columns = i7;
        this.spacing = i8;
        this.templateId = str2;
        this.printerLabelBgUrl = str3;
    }

    public TemplateConfigBean(String str, int i5, int i6, int i7, int i8, String str2) {
        this.hOffset = 0.0f;
        this.vOffset = 0.0f;
        this.printerLabelBorderUrl = null;
        this.paperType = 0;
        this.rotate = 0;
        this.name = str;
        this.width = i5;
        this.height = i6;
        this.columns = i7;
        this.spacing = i8;
        this.printerLabelBgUrl = str2;
    }

    public TemplateConfigBean(String str, int i5, int i6, int i7, int i8, String str2, String str3, String str4, int i9) {
        this.hOffset = 0.0f;
        this.vOffset = 0.0f;
        this.rotate = 0;
        this.name = str;
        this.width = i5;
        this.height = i6;
        this.columns = i7;
        this.spacing = i8;
        this.templateId = str2;
        this.printerLabelBgUrl = str3;
        this.printerLabelBorderUrl = str4;
        this.paperType = i9;
    }

    public TemplateConfigBean(String str, int i5, int i6, int i7, int i8, String str2, String str3, String str4, int i9, int i10) {
        this.hOffset = 0.0f;
        this.vOffset = 0.0f;
        this.name = str;
        this.width = i5;
        this.height = i6;
        this.columns = i7;
        this.spacing = i8;
        this.templateId = str2;
        this.printerLabelBgUrl = str3;
        this.printerLabelBorderUrl = str4;
        this.paperType = i9;
        this.rotate = i10;
    }
}
