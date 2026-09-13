package cn.bertsir.zbar.Qr;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class ScanResult {
    public static final int CODE_BAR = 2;
    public static final int CODE_QR = 1;
    public String content;
    public int type;

    public String getContent() {
        return this.content;
    }

    public int getType() {
        return this.type;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setType(int i5) {
        this.type = i5;
    }
}
