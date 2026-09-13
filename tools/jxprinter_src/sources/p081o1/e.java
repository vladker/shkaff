package p081o1;

import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class e {
    public static final Charset b = Charset.forName("UTF-16");
    public static final Charset c = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f6439a;

    @Deprecated
    public e(String str) {
        this.f6439a = str.getBytes(b);
    }

    @Deprecated
    public static e utf16(String str) {
        return new e(str);
    }
}
