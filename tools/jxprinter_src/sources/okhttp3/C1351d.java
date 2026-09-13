package okhttp3;

import com.google.common.net.HttpHeaders;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: okhttp3.d, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class C1351d {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final C1351d f6557m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f6558a;
    public final boolean b;
    public final int c;
    public final int d;
    public final boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f6559f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f6560g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f6561h;
    String headerValue;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f6562i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f6563j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f6564k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f6565l;

    static {
        p069m1.a aVar = new p069m1.a();
        aVar.f6117a = -1;
        aVar.b = true;
        long seconds = TimeUnit.SECONDS.toSeconds(Integer.MAX_VALUE);
        aVar.f6117a = seconds <= 2147483647L ? (int) seconds : Integer.MAX_VALUE;
        f6557m = new C1351d(aVar);
    }

    private C1351d(boolean z6, boolean z7, int i5, int i6, boolean z8, boolean z9, boolean z10, int i7, int i8, boolean z11, boolean z12, boolean z13, String str) {
        this.f6558a = z6;
        this.b = z7;
        this.c = i5;
        this.d = i6;
        this.e = z8;
        this.f6559f = z9;
        this.f6560g = z10;
        this.f6561h = i7;
        this.f6562i = i8;
        this.f6563j = z11;
        this.f6564k = z12;
        this.f6565l = z13;
        this.headerValue = str;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0044  */
    /* JADX WARN: Code duplicated, block: B:34:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:37:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:39:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:41:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:42:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:44:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:45:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:47:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:48:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:50:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:51:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:53:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:54:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:56:0x0103  */
    /* JADX WARN: Code duplicated, block: B:57:0x0106  */
    /* JADX WARN: Code duplicated, block: B:59:0x010e  */
    /* JADX WARN: Code duplicated, block: B:60:0x0118  */
    /* JADX WARN: Code duplicated, block: B:62:0x0120  */
    /* JADX WARN: Code duplicated, block: B:63:0x0128  */
    /* JADX WARN: Code duplicated, block: B:65:0x0131  */
    /* JADX WARN: Code duplicated, block: B:66:0x0134  */
    /* JADX WARN: Code duplicated, block: B:68:0x013c  */
    /* JADX WARN: Code duplicated, block: B:69:0x013f  */
    /* JADX WARN: Code duplicated, block: B:71:0x0147  */
    /* JADX WARN: Code duplicated, block: B:89:0x0149 A[SYNTHETIC] */
    public static C1351d a(C1376w c1376w) {
        int i5;
        int iE;
        String strTrim;
        int iE2;
        String strTrim2;
        char cCharAt;
        C1376w c1376w2 = c1376w;
        int iF = c1376w2.f();
        int i6 = 0;
        boolean z6 = true;
        String str = null;
        boolean z7 = false;
        boolean z8 = false;
        int iC = -1;
        int iC2 = -1;
        boolean z9 = false;
        boolean z10 = false;
        boolean z11 = false;
        int iC3 = -1;
        int iC4 = -1;
        boolean z12 = false;
        boolean z13 = false;
        boolean z14 = false;
        while (i6 < iF) {
            String strC = c1376w2.c(i6);
            String strG = c1376w2.g(i6);
            if (strC.equalsIgnoreCase(HttpHeaders.CACHE_CONTROL)) {
                if (str == null) {
                    str = strG;
                }
                for (i5 = 0; i5 < strG.length(); i5 = iE2) {
                    iE = p118u4.e.e(i5, strG, "=,;");
                    strTrim = strG.substring(i5, iE).trim();
                    if (iE != strG.length() || strG.charAt(iE) == ',' || strG.charAt(iE) == ';') {
                        iE2 = iE + 1;
                        strTrim2 = null;
                    } else {
                        while (true) {
                            iE++;
                            if (iE >= strG.length() || ((cCharAt = strG.charAt(iE)) != ' ' && cCharAt != '\t')) {
                                break;
                            }
                        }
                        if (iE >= strG.length() || strG.charAt(iE) != '\"') {
                            iE2 = p118u4.e.e(iE, strG, ",;");
                            strTrim2 = strG.substring(iE, iE2).trim();
                        } else {
                            int i7 = iE + 1;
                            int iE3 = p118u4.e.e(i7, strG, "\"");
                            strTrim2 = strG.substring(i7, iE3);
                            iE2 = iE3 + 1;
                        }
                    }
                    if ("no-cache".equalsIgnoreCase(strTrim)) {
                        z7 = true;
                    } else if ("no-store".equalsIgnoreCase(strTrim)) {
                        z8 = true;
                    } else {
                        if ("max-age".equalsIgnoreCase(strTrim)) {
                            iC = p118u4.e.c(-1, strTrim2);
                        } else if ("s-maxage".equalsIgnoreCase(strTrim)) {
                            iC2 = p118u4.e.c(-1, strTrim2);
                        } else if ("private".equalsIgnoreCase(strTrim)) {
                            z9 = true;
                        } else if ("public".equalsIgnoreCase(strTrim)) {
                            z10 = true;
                        } else if ("must-revalidate".equalsIgnoreCase(strTrim)) {
                            z11 = true;
                        } else if ("max-stale".equalsIgnoreCase(strTrim)) {
                            iC3 = p118u4.e.c(Integer.MAX_VALUE, strTrim2);
                        } else if ("min-fresh".equalsIgnoreCase(strTrim)) {
                            iC4 = p118u4.e.c(-1, strTrim2);
                        } else if ("only-if-cached".equalsIgnoreCase(strTrim)) {
                            z12 = true;
                        } else if ("no-transform".equalsIgnoreCase(strTrim)) {
                            z13 = true;
                        } else if ("immutable".equalsIgnoreCase(strTrim)) {
                            z14 = true;
                        }
                    }
                }
                i6++;
                c1376w2 = c1376w;
            } else {
                if (strC.equalsIgnoreCase(HttpHeaders.PRAGMA)) {
                }
                i6++;
                c1376w2 = c1376w;
            }
            z6 = false;
            while (i5 < strG.length()) {
                iE = p118u4.e.e(i5, strG, "=,;");
                strTrim = strG.substring(i5, iE).trim();
                if (iE != strG.length()) {
                    iE2 = iE + 1;
                    strTrim2 = null;
                } else {
                    iE2 = iE + 1;
                    strTrim2 = null;
                }
                if ("no-cache".equalsIgnoreCase(strTrim)) {
                    z7 = true;
                } else if ("no-store".equalsIgnoreCase(strTrim)) {
                    z8 = true;
                } else {
                    if ("max-age".equalsIgnoreCase(strTrim)) {
                        iC = p118u4.e.c(-1, strTrim2);
                    } else if ("s-maxage".equalsIgnoreCase(strTrim)) {
                        iC2 = p118u4.e.c(-1, strTrim2);
                    } else if ("private".equalsIgnoreCase(strTrim)) {
                        z9 = true;
                    } else if ("public".equalsIgnoreCase(strTrim)) {
                        z10 = true;
                    } else if ("must-revalidate".equalsIgnoreCase(strTrim)) {
                        z11 = true;
                    } else if ("max-stale".equalsIgnoreCase(strTrim)) {
                        iC3 = p118u4.e.c(Integer.MAX_VALUE, strTrim2);
                    } else if ("min-fresh".equalsIgnoreCase(strTrim)) {
                        iC4 = p118u4.e.c(-1, strTrim2);
                    } else if ("only-if-cached".equalsIgnoreCase(strTrim)) {
                        z12 = true;
                    } else if ("no-transform".equalsIgnoreCase(strTrim)) {
                        z13 = true;
                    } else if ("immutable".equalsIgnoreCase(strTrim)) {
                        z14 = true;
                    }
                }
            }
            i6++;
            c1376w2 = c1376w;
        }
        return new C1351d(z7, z8, iC, iC2, z9, z10, z11, iC3, iC4, z12, z13, z14, !z6 ? null : str);
    }

    public final String toString() {
        String string;
        String str = this.headerValue;
        if (str != null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        if (this.f6558a) {
            sb.append("no-cache, ");
        }
        if (this.b) {
            sb.append("no-store, ");
        }
        int i5 = this.c;
        if (i5 != -1) {
            sb.append("max-age=");
            sb.append(i5);
            sb.append(", ");
        }
        int i6 = this.d;
        if (i6 != -1) {
            sb.append("s-maxage=");
            sb.append(i6);
            sb.append(", ");
        }
        if (this.e) {
            sb.append("private, ");
        }
        if (this.f6559f) {
            sb.append("public, ");
        }
        if (this.f6560g) {
            sb.append("must-revalidate, ");
        }
        int i7 = this.f6561h;
        if (i7 != -1) {
            sb.append("max-stale=");
            sb.append(i7);
            sb.append(", ");
        }
        int i8 = this.f6562i;
        if (i8 != -1) {
            sb.append("min-fresh=");
            sb.append(i8);
            sb.append(", ");
        }
        if (this.f6563j) {
            sb.append("only-if-cached, ");
        }
        if (this.f6564k) {
            sb.append("no-transform, ");
        }
        if (this.f6565l) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            string = "";
        } else {
            sb.delete(sb.length() - 2, sb.length());
            string = sb.toString();
        }
        this.headerValue = string;
        return string;
    }

    public C1351d(p069m1.a aVar) {
        aVar.getClass();
        this.f6558a = false;
        this.b = false;
        this.c = -1;
        this.d = -1;
        this.e = false;
        this.f6559f = false;
        this.f6560g = false;
        this.f6561h = aVar.f6117a;
        this.f6562i = -1;
        this.f6563j = aVar.b;
        this.f6564k = false;
        this.f6565l = false;
    }
}
