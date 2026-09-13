package com.appdev.standard.api.pto;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class RegisterPto {
    private int accountType;
    private String authCode;
    private String password;
    private String username;

    public RegisterPto(int i5, String str, String str2, String str3) {
        this.accountType = i5;
        this.authCode = str;
        this.password = str2;
        this.username = str3;
    }

    public int getAccountType() {
        return this.accountType;
    }

    public String getAuthCode() {
        return this.authCode;
    }

    public String getPassword() {
        return this.password;
    }

    public String getUsername() {
        return this.username;
    }

    public void setAccountType(int i5) {
        this.accountType = i5;
    }

    public void setAuthCode(String str) {
        this.authCode = str;
    }

    public void setPassword(String str) {
        this.password = str;
    }

    public void setUsername(String str) {
        this.username = str;
    }
}
