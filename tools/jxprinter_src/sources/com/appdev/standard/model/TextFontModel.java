package com.appdev.standard.model;

import org.litepal.crud.f;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class TextFontModel extends f {
    private long allSize;
    private int downPercent;
    private String fileUrl;
    private String fontlibId;
    private boolean isDowning;
    private boolean isDownload;
    private boolean isSelect;
    private String localFilePath;
    private String name;

    public TextFontModel() {
        this.isSelect = false;
        this.isDownload = false;
        this.isDowning = false;
        this.downPercent = 0;
        this.allSize = 0L;
    }

    public long getAllSize() {
        return this.allSize;
    }

    public int getDownPercent() {
        return this.downPercent;
    }

    public String getFileUrl() {
        return this.fileUrl;
    }

    public String getFontlibId() {
        return this.fontlibId;
    }

    public String getLocalFilePath() {
        return this.localFilePath;
    }

    public String getName() {
        return this.name;
    }

    public boolean isDowning() {
        return this.isDowning;
    }

    public boolean isDownload() {
        return this.isDownload;
    }

    public boolean isSelect() {
        return this.isSelect;
    }

    public void setAllSize(long j6) {
        this.allSize = j6;
    }

    public void setDownPercent(int i5) {
        this.downPercent = i5;
    }

    public void setDowning(boolean z6) {
        this.isDowning = z6;
    }

    public void setDownload(boolean z6) {
        this.isDownload = z6;
    }

    public void setFileUrl(String str) {
        this.fileUrl = str;
    }

    public void setFontlibId(String str) {
        this.fontlibId = str;
    }

    public void setLocalFilePath(String str) {
        this.localFilePath = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setSelect(boolean z6) {
        this.isSelect = z6;
    }

    public TextFontModel(String str, String str2, String str3, boolean z6) {
        this.isDownload = false;
        this.isDowning = false;
        this.downPercent = 0;
        this.allSize = 0L;
        this.name = str;
        this.fileUrl = str2;
        this.fontlibId = str3;
        this.isSelect = z6;
    }
}
