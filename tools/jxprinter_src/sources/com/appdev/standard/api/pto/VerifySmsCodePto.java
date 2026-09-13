package com.appdev.standard.api.pto;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class VerifySmsCodePto {
    private int accountType;
    private String code;
    private int type;
    private String username;

    public VerifySmsCodePto(int i5, int i6, String str, String str2) {
        this.accountType = i5;
        this.type = i6;
        this.username = str;
        this.code = str2;
    }

    public int getAccountType() {
        return this.accountType;
    }

    public String getCode() {
        return this.code;
    }

    public int getType() {
        return this.type;
    }

    public String getUsername() {
        return this.username;
    }

    public void setAccountType(int i5) {
        this.accountType = i5;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setType(int i5) {
        this.type = i5;
    }

    public void setUsername(String str) {
        this.username = str;
    }
}
