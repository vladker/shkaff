package com.appdev.standard.api.pto;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class AddMemberPto {
    private String teamId;
    private String userName;

    public AddMemberPto(String str, String str2) {
        this.teamId = str;
        this.userName = str2;
    }

    public String getTeamId() {
        return this.teamId;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setTeamId(String str) {
        this.teamId = str;
    }

    public void setUserName(String str) {
        this.userName = str;
    }
}
