package com.appdev.standard.model;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class MaterialLibraryTypeModel {
    private boolean isSelect;
    private String materialName;
    private long materialTypeId;

    public MaterialLibraryTypeModel(String str) {
        this.materialName = str;
        this.isSelect = false;
    }

    public String getMaterialName() {
        return this.materialName;
    }

    public long getMaterialTypeId() {
        return this.materialTypeId;
    }

    public boolean isSelect() {
        return this.isSelect;
    }

    public void setMaterialName(String str) {
        this.materialName = str;
    }

    public void setMaterialTypeId(long j6) {
        this.materialTypeId = j6;
    }

    public void setSelect(boolean z6) {
        this.isSelect = z6;
    }

    public MaterialLibraryTypeModel(String str, boolean z6) {
        this.materialName = str;
        this.isSelect = z6;
    }
}
