package com.appdev.standard.api.dto;

import com.library.base.util.http.JsonResult;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class UploadImageDto extends JsonResult {
    private DataBean data;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class DataBean {
        private String fileName;
        private String newFileName;
        private String originalFilename;
        private String url;

        public String getFileName() {
            return this.fileName;
        }

        public String getNewFileName() {
            return this.newFileName;
        }

        public String getOriginalFilename() {
            return this.originalFilename;
        }

        public String getUrl() {
            return this.url;
        }

        public void setFileName(String str) {
            this.fileName = str;
        }

        public void setNewFileName(String str) {
            this.newFileName = str;
        }

        public void setOriginalFilename(String str) {
            this.originalFilename = str;
        }

        public void setUrl(String str) {
            this.url = str;
        }
    }

    public DataBean getData() {
        return this.data;
    }

    public void setData(DataBean dataBean) {
        this.data = dataBean;
    }
}
