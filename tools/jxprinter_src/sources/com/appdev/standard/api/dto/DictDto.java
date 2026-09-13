package com.appdev.standard.api.dto;

import com.appdev.standard.model.DictModel;
import com.library.base.util.http.JsonResult;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class DictDto extends JsonResult {
    private List<DictModel> data;

    public List<DictModel> getData() {
        return this.data;
    }

    public void setData(List<DictModel> list) {
        this.data = list;
    }
}
