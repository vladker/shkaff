package com.appdev.standard.api.dto;

import com.library.base.util.http.JsonResult;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class UserInfoDto extends JsonResult {
    private DataBean data;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class DataBean {
        private String avatar;
        private String cloudTagsNumber;
        private String endTime;
        private int member;
        private String memberName;
        private String nickName;
        private String personalTags;
        private int systemParameter;
        private String usedCloudTagsNumber;
        private String usedPersonalTagsNumber;
        private String userName;
        private boolean vip;

        public String getAvatar() {
            return this.avatar;
        }

        public String getCloudTagsNumber() {
            return this.cloudTagsNumber;
        }

        public String getEndTime() {
            return this.endTime;
        }

        public int getMember() {
            return this.member;
        }

        public String getMemberName() {
            return this.memberName;
        }

        public String getNickName() {
            return this.nickName;
        }

        public String getPersonalTags() {
            return this.personalTags;
        }

        public int getSystemParameter() {
            return this.systemParameter;
        }

        public String getUsedCloudTagsNumber() {
            return this.usedCloudTagsNumber;
        }

        public String getUsedPersonalTagsNumber() {
            return this.usedPersonalTagsNumber;
        }

        public String getUserName() {
            return this.userName;
        }

        public boolean isVip() {
            return this.vip;
        }

        public void setAvatar(String str) {
            this.avatar = str;
        }

        public void setCloudTagsNumber(String str) {
            this.cloudTagsNumber = str;
        }

        public void setEndTime(String str) {
            this.endTime = str;
        }

        public void setMember(int i5) {
            this.member = i5;
        }

        public void setMemberName(String str) {
            this.memberName = str;
        }

        public void setNickName(String str) {
            this.nickName = str;
        }

        public void setPersonalTags(String str) {
            this.personalTags = str;
        }

        public void setSystemParameter(int i5) {
            this.systemParameter = i5;
        }

        public void setUsedCloudTagsNumber(String str) {
            this.usedCloudTagsNumber = str;
        }

        public void setUsedPersonalTagsNumber(String str) {
            this.usedPersonalTagsNumber = str;
        }

        public void setUserName(String str) {
            this.userName = str;
        }

        public void setVip(boolean z6) {
            this.vip = z6;
        }
    }

    public DataBean getData() {
        return this.data;
    }

    public void setData(DataBean dataBean) {
        this.data = dataBean;
    }
}
