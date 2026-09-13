package com.appdev.standard.api.dto;

import com.library.base.util.http.JsonResult;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class FeedbackTypeDto extends JsonResult {
    private List<ListBean> list;
    private boolean success;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class ListBean {
        private int key;
        private String value;

        public int getKey() {
            return this.key;
        }

        public String getValue() {
            return this.value;
        }

        public void setKey(int i5) {
            this.key = i5;
        }

        public void setValue(String str) {
            this.value = str;
        }
    }

    public List<ListBean> getList() {
        return this.list;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public void setSuccess(boolean z6) {
        this.success = z6;
    }
}
