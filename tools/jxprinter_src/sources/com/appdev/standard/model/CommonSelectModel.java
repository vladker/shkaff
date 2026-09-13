package com.appdev.standard.model;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class CommonSelectModel {
    private boolean isSelect;
    private String key;
    private String value;

    public CommonSelectModel(String str) {
        this.isSelect = false;
        this.key = str;
    }

    public String getKey() {
        return this.key;
    }

    public String getValue() {
        return this.value;
    }

    public boolean isSelect() {
        return this.isSelect;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setSelect(boolean z6) {
        this.isSelect = z6;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public CommonSelectModel(String str, boolean z6) {
        this.key = str;
        this.isSelect = z6;
    }

    public CommonSelectModel(String str, String str2) {
        this.isSelect = false;
        this.key = str;
        this.value = str2;
    }

    public CommonSelectModel(String str, String str2, boolean z6) {
        this.key = str;
        this.value = str2;
        this.isSelect = z6;
    }
}
