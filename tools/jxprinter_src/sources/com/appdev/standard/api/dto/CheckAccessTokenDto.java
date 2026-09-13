package com.appdev.standard.api.dto;

import com.library.base.util.http.JsonResult;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class CheckAccessTokenDto extends JsonResult {
    private boolean success;
    private UserBean user;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class UserBean {
        private String accessToken;
        private String avatar;
        private String createTime;
        private int id;
        private String ip;
        private String lastLoginTime;
        private String nickname;
        private String phone;
        private Object qq;
        private int status;
        private Object wechat;

        public String getAccessToken() {
            return this.accessToken;
        }

        public String getAvatar() {
            return this.avatar;
        }

        public String getCreateTime() {
            return this.createTime;
        }

        public int getId() {
            return this.id;
        }

        public String getIp() {
            return this.ip;
        }

        public String getLastLoginTime() {
            return this.lastLoginTime;
        }

        public String getNickname() {
            return this.nickname;
        }

        public String getPhone() {
            return this.phone;
        }

        public Object getQq() {
            return this.qq;
        }

        public int getStatus() {
            return this.status;
        }

        public Object getWechat() {
            return this.wechat;
        }

        public void setAccessToken(String str) {
            this.accessToken = str;
        }

        public void setAvatar(String str) {
            this.avatar = str;
        }

        public void setCreateTime(String str) {
            this.createTime = str;
        }

        public void setId(int i5) {
            this.id = i5;
        }

        public void setIp(String str) {
            this.ip = str;
        }

        public void setLastLoginTime(String str) {
            this.lastLoginTime = str;
        }

        public void setNickname(String str) {
            this.nickname = str;
        }

        public void setPhone(String str) {
            this.phone = str;
        }

        public void setQq(Object obj) {
            this.qq = obj;
        }

        public void setStatus(int i5) {
            this.status = i5;
        }

        public void setWechat(Object obj) {
            this.wechat = obj;
        }
    }

    public UserBean getUser() {
        return this.user;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean z6) {
        this.success = z6;
    }

    public void setUser(UserBean userBean) {
        this.user = userBean;
    }
}
