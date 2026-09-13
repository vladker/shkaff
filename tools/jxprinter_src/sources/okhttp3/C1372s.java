package okhttp3;

import java.nio.charset.Charset;
import java.util.ArrayList;

/* JADX INFO: renamed from: okhttp3.s, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class C1372s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f6673a = new ArrayList();
    public final ArrayList b = new ArrayList();
    private final Charset charset;

    public C1372s(Charset charset) {
        this.charset = charset;
    }

    public final void a(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        this.f6673a.add(C1378y.canonicalize(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true, this.charset));
        this.b.add(C1378y.canonicalize(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true, this.charset));
    }

    public final void b(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        this.f6673a.add(C1378y.canonicalize(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true, this.charset));
        this.b.add(C1378y.canonicalize(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true, this.charset));
    }
}
