package h5;

import org.apache.xmlbeans.XmlErrorCodes;
import p067m.h;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final class a extends h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4041a;

    public /* synthetic */ a(int i5) {
        this.f4041a = i5;
    }

    @Override // p067m.h
    public final String b(String str) {
        switch (this.f4041a) {
            case 0:
                if (str == null || !str.equals("[B")) {
                    return null;
                }
                return "blob";
            case 1:
                if (str == null || !(str.equals("boolean") || str.equals("java.lang.Boolean"))) {
                    return null;
                }
                return "integer";
            case 2:
                if (str == null || !str.equals("java.util.Date")) {
                    return null;
                }
                return "integer";
            case 3:
                if (str == null || !(str.equals("float") || str.equals("java.lang.Float") || str.equals(XmlErrorCodes.DOUBLE) || str.equals("java.lang.Double"))) {
                    return null;
                }
                return "real";
            case 4:
                if (str == null || !(str.equals(XmlErrorCodes.INT) || str.equals("java.lang.Integer") || str.equals(XmlErrorCodes.LONG) || str.equals("java.lang.Long") || str.equals("short") || str.equals("java.lang.Short"))) {
                    return null;
                }
                return "integer";
            default:
                if (str == null || !(str.equals("char") || str.equals("java.lang.Character") || str.equals("java.lang.String"))) {
                    return null;
                }
                return "text";
        }
    }
}
