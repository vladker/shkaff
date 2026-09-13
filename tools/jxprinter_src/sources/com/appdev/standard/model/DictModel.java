package com.appdev.standard.model;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class DictModel {
    private String dictLabel;
    private String dictValue;
    private boolean isSelect;

    public DictModel() {
        this.isSelect = false;
    }

    public String getDictLabel() {
        return this.dictLabel;
    }

    public String getDictValue() {
        return this.dictValue;
    }

    public boolean isSelect() {
        return this.isSelect;
    }

    public void setDictLabel(String str) {
        this.dictLabel = str;
    }

    public void setDictValue(String str) {
        this.dictValue = str;
    }

    public void setSelect(boolean z6) {
        this.isSelect = z6;
    }

    public DictModel(String str, String str2, boolean z6) {
        this.dictLabel = str;
        this.dictValue = str2;
        this.isSelect = z6;
    }
}
