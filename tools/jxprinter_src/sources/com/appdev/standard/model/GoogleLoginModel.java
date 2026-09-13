package com.appdev.standard.model;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class GoogleLoginModel {
    private String nickname;
    private String picture;
    private String userID;

    public String getNickname() {
        String str = this.nickname;
        return str == null ? "" : str;
    }

    public String getPicture() {
        String str = this.picture;
        return str == null ? "" : str;
    }

    public String getUserID() {
        return this.userID;
    }

    public void setNickname(String str) {
        this.nickname = str;
    }

    public void setPicture(String str) {
        this.picture = str;
    }

    public void setUserID(String str) {
        this.userID = str;
    }
}
