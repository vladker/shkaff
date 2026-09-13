package com.appdev.standard.api.dto;

import com.appdev.standard.model.FeedbackDetailModel;
import com.library.base.util.http.JsonResult;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class FeedbackDetailDto extends JsonResult {
    private List<FeedbackDetailModel> data;

    public List<FeedbackDetailModel> getData() {
        return this.data;
    }

    public void setData(List<FeedbackDetailModel> list) {
        this.data = list;
    }
}
