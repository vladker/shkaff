package cn.sharesdk.loopshare.beans;

import com.mob.tools.proguard.PrivateMemberKeeper;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ServerData implements PrivateMemberKeeper {
    private String error;
    private int status;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class Res implements PrivateMemberKeeper {
    }

    public static int a(int i5) {
        return i5;
    }

    public boolean a_() {
        return a(this);
    }

    public int h() {
        return a(this.status);
    }

    public String i() {
        return a(this.error);
    }

    public static String a(String str) {
        return str == null ? "" : str;
    }

    public static boolean a(ServerData serverData) {
        return serverData != null && 200 == serverData.h();
    }
}
