package cn.sharesdk.loopshare.beans;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class ConfigData extends ServerData {
    private Res res;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class Res extends ServerData.Res {
        private String appLink;
        private String host;
        private int port;
        private String scheme;
        private int sslPort;
        private int timeout;
        private long timestamp;
        private boolean yyb;
    }

    public boolean a() {
        Res res = this.res;
        if (res != null) {
            return res.yyb;
        }
        return false;
    }

    public String b() {
        Res res = this.res;
        return res != null ? res.host : "";
    }

    public int c() {
        Res res = this.res;
        if (res != null) {
            return res.port;
        }
        return 80;
    }

    public String d() {
        Res res = this.res;
        return res != null ? res.scheme : "";
    }

    public String e() {
        Res res = this.res;
        if (res != null) {
            return res.appLink;
        }
        return null;
    }

    public String f() {
        Res res = this.res;
        return res != null ? res.host : "";
    }

    public int g() {
        Res res = this.res;
        if (res != null) {
            return res.port;
        }
        return 80;
    }
}
