package com.appdev.standard.api.pto;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class EditUserNamePto {
    private int accountType;
    private String code;
    private String password;
    private String userName;

    public EditUserNamePto(int i5, String str, String str2, String str3) {
        this.accountType = i5;
        this.code = str;
        this.password = str2;
        this.userName = str3;
    }

    public int getAccountType() {
        return this.accountType;
    }

    public String getCode() {
        return this.code;
    }

    public String getPassword() {
        return this.password;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setAccountType(int i5) {
        this.accountType = i5;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setPassword(String str) {
        this.password = str;
    }

    public void setUserName(String str) {
        this.userName = str;
    }
}
