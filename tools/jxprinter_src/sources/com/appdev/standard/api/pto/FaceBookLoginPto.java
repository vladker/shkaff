package com.appdev.standard.api.pto;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class FaceBookLoginPto {
    private String avatarUrl;
    private String nickName;
    private String thirdPartyId;

    public FaceBookLoginPto(String str, String str2, String str3) {
        this.avatarUrl = str;
        this.nickName = str2;
        this.thirdPartyId = str3;
    }

    public String getAvatarUrl() {
        return this.avatarUrl;
    }

    public String getNickName() {
        return this.nickName;
    }

    public String getThirdPartyId() {
        return this.thirdPartyId;
    }

    public void setAvatarUrl(String str) {
        this.avatarUrl = str;
    }

    public void setNickName(String str) {
        this.nickName = str;
    }

    public void setThirdPartyId(String str) {
        this.thirdPartyId = str;
    }
}
