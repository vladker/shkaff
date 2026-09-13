package com.appdev.standard.api.dto;

import com.library.base.util.http.JsonResult;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class CheckAppVersionDto extends JsonResult {
    private ModelBean model;
    private boolean success;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class ModelBean {
        private String apkOrLink;
        private int id;
        private int platform;
        private String version;

        public String getApkOrLink() {
            return this.apkOrLink;
        }

        public int getId() {
            return this.id;
        }

        public int getPlatform() {
            return this.platform;
        }

        public String getVersion() {
            return this.version;
        }

        public int getVersionInt() {
            String str = this.version;
            if (str != null && str.matches("^\\d{0,11}$")) {
                return Integer.valueOf(str).intValue();
            }
            return -1;
        }

        public void setApkOrLink(String str) {
            this.apkOrLink = str;
        }

        public void setId(int i5) {
            this.id = i5;
        }

        public void setPlatform(int i5) {
            this.platform = i5;
        }

        public void setVersion(String str) {
            this.version = str;
        }
    }

    public ModelBean getModel() {
        return this.model;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setModel(ModelBean modelBean) {
        this.model = modelBean;
    }

    public void setSuccess(boolean z6) {
        this.success = z6;
    }
}
