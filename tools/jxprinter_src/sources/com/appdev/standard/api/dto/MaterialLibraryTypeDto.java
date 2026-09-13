package com.appdev.standard.api.dto;

import com.appdev.standard.model.MaterialLibraryTypeModel;
import com.library.base.util.http.JsonResult;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class MaterialLibraryTypeDto extends JsonResult {
    private List<MaterialLibraryTypeModel> data;

    public List<MaterialLibraryTypeModel> getData() {
        return this.data;
    }

    public void setData(List<MaterialLibraryTypeModel> list) {
        this.data = list;
    }
}
