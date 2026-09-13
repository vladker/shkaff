package p046i0;

import org.apache.commons.compress.archivers.tar.TarConstants;
import p113u.g;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public enum b {
    /* JADX INFO: Fake field, exist only in values array */
    PAPER_TYPE_0(TarConstants.VERSION_POSIX, g.text_340),
    /* JADX INFO: Fake field, exist only in values array */
    PAPER_TYPE_1("01", g.text_341),
    /* JADX INFO: Fake field, exist only in values array */
    PAPER_TYPE_2("02", g.text_342),
    /* JADX INFO: Fake field, exist only in values array */
    PAPER_TYPE_3("03", g.text_444);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4044a;
    public final int b;

    b(String str, int i5) {
        this.f4044a = str;
        this.b = i5;
    }
}
