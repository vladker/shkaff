package cn.sharesdk.loopshare.beans;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class LinkData extends ServerData {
    private Res res;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class Res extends ServerData.Res {
        private String domain;
        private String link;
    }

    public String a() {
        Res res = this.res;
        return res != null ? res.link : "";
    }
}
