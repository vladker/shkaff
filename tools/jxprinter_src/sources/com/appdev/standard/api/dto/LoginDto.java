package com.appdev.standard.api.dto;

import com.library.base.util.http.JsonResult;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class LoginDto extends JsonResult {
    private DataBean data;
    private String exist;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class DataBean {
        private String appUserId;
        private String avatar;
        private String nickName;
        private String token;
        private String userName;

        public String getAppUserId() {
            return this.appUserId;
        }

        public String getAvatar() {
            return this.avatar;
        }

        public String getNickName() {
            return this.nickName;
        }

        public String getToken() {
            return this.token;
        }

        public String getUserName() {
            return this.userName;
        }

        public void setAppUserId(String str) {
            this.appUserId = str;
        }

        public void setAvatar(String str) {
            this.avatar = str;
        }

        public void setNickName(String str) {
            this.nickName = str;
        }

        public void setToken(String str) {
            this.token = str;
        }

        public void setUserName(String str) {
            this.userName = str;
        }
    }

    public DataBean getData() {
        return this.data;
    }

    public String getExist() {
        return this.exist;
    }

    public void setData(DataBean dataBean) {
        this.data = dataBean;
    }

    public void setExist(String str) {
        this.exist = str;
    }
}
