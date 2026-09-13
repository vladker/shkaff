package com.appdev.standard.api.dto;

import com.appdev.standard.model.CloudHeaderModel;
import com.library.base.util.http.JsonResult;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class CloudHeaderDto extends JsonResult {
    private CloudHeaderModel data;

    public CloudHeaderModel getData() {
        return this.data;
    }

    public void setData(CloudHeaderModel cloudHeaderModel) {
        this.data = cloudHeaderModel;
    }
}
