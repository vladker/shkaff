package com.appdev.standard.model;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class AppMaterialModel {
    private String imageUrls;
    private boolean isSelect;

    public AppMaterialModel() {
        this.isSelect = false;
    }

    public String getImageUrls() {
        return this.imageUrls;
    }

    public boolean isSelect() {
        return this.isSelect;
    }

    public void setImageUrls(String str) {
        this.imageUrls = str;
    }

    public void setSelect(boolean z6) {
        this.isSelect = z6;
    }

    public AppMaterialModel(String str, boolean z6) {
        this.imageUrls = str;
        this.isSelect = z6;
    }
}
