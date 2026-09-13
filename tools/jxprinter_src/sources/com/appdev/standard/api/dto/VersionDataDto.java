package com.appdev.standard.api.dto;

import com.library.base.util.http.JsonResult;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class VersionDataDto extends JsonResult {
    private DataBean data;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class DataBean {
        private String firmwareByte;
        private String title;
        private String version;

        public String getFirmwareByte() {
            return this.firmwareByte;
        }

        public String getTitle() {
            return this.title;
        }

        public String getVersion() {
            return this.version;
        }

        public void setFirmwareByte(String str) {
            this.firmwareByte = str;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public void setVersion(String str) {
            this.version = str;
        }
    }

    public DataBean getData() {
        return this.data;
    }

    public void setData(DataBean dataBean) {
        this.data = dataBean;
    }
}
