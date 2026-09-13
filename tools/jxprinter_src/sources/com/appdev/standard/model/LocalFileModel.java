package com.appdev.standard.model;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class LocalFileModel {
    private String fileName;
    private String filePath;
    private long id = System.currentTimeMillis();
    private String time;

    public LocalFileModel(String str, String str2, String str3) {
        this.filePath = str.toString();
        this.fileName = str2;
        this.time = str3;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public long getId() {
        return this.id;
    }

    public String getTime() {
        return this.time;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public void setFilePath(String str) {
        this.filePath = str;
    }

    public void setId(long j6) {
        this.id = j6;
    }

    public void setTime(String str) {
        this.time = str;
    }
}
