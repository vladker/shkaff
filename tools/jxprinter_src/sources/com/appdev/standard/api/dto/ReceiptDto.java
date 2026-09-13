package com.appdev.standard.api.dto;

import com.appdev.standard.model.ReceiptModel;
import com.library.base.util.http.JsonResult;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class ReceiptDto extends JsonResult {
    private DataBean data;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class DataBean {
        private List<ReceiptModel> rows;
        private String total;

        public List<ReceiptModel> getRows() {
            return this.rows;
        }

        public String getTotal() {
            return this.total;
        }

        public void setRows(List<ReceiptModel> list) {
            this.rows = list;
        }

        public void setTotal(String str) {
            this.total = str;
        }
    }

    public DataBean getData() {
        return this.data;
    }

    public void setData(DataBean dataBean) {
        this.data = dataBean;
    }
}
