package com.appdev.standard.api.pto;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class DisposeInviteRecordPto {
    public static final int AGREE = 1;
    public static final int DISAGREE = 2;
    private String inviteRecordId;
    private int status;

    public DisposeInviteRecordPto(String str, int i5) {
        this.inviteRecordId = str;
        this.status = i5;
    }
}
