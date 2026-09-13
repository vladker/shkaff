package com.appdev.standard.api.dto;

import com.appdev.standard.model.AppMaterialModel;
import com.library.base.util.http.JsonResult;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class AppMaterialDto extends JsonResult {
    private List<AppMaterialModel> data;

    public List<AppMaterialModel> getData() {
        return this.data;
    }

    public void setData(List<AppMaterialModel> list) {
        this.data = list;
    }
}
