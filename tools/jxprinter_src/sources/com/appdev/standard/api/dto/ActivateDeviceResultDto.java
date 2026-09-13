package com.appdev.standard.api.dto;

import com.library.base.util.http.JsonResult;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class ActivateDeviceResultDto extends JsonResult {
    private DataBean data;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class DataBean {
        private Integer activateResult;

        public int getActivateResult() {
            return this.activateResult.intValue();
        }

        public boolean isSuccess() {
            Integer num = this.activateResult;
            if (num != null) {
                return num.intValue() == 1 || this.activateResult.intValue() == 3;
            }
            return false;
        }

        public void setActivateResult(int i5) {
            this.activateResult = Integer.valueOf(i5);
        }
    }

    public DataBean getData() {
        return this.data;
    }
}
