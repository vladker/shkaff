package p050j;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class m implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5387a;
    public final String b;
    public final String c;
    public final String[] d;
    public final int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f5388f;

    public m(String str, String str2, String str3, String[] strArr, boolean z6) {
        this.f5387a = str;
        this.b = str2;
        this.c = str3;
        this.d = strArr;
        this.f5388f = z6;
        int length = str2 != null ? str2.length() : 0;
        length = str3 != null ? length + str3.length() : length;
        if (strArr != null) {
            for (String str4 : strArr) {
                length += str4.length();
            }
        }
        this.e = length;
    }

    @Override // p050j.h
    public final boolean a(r rVar, Object obj) {
        int length;
        String str;
        Object objD = rVar.d(obj, this.f5387a);
        if (objD == null) {
            return false;
        }
        String string = objD.toString();
        int length2 = string.length();
        int i5 = this.e;
        boolean z6 = this.f5388f;
        if (length2 >= i5) {
            String str2 = this.b;
            if (str2 == null) {
                length = 0;
            } else if (string.startsWith(str2)) {
                length = str2.length();
            }
            String[] strArr = this.d;
            if (strArr == null) {
                str = this.c;
                if (str != null) {
                }
                return !z6;
            }
            for (String str3 : strArr) {
                int iIndexOf = string.indexOf(str3, length);
                if (iIndexOf != -1) {
                    length = iIndexOf + str3.length();
                }
            }
            str = this.c;
            if (str != null || string.endsWith(str)) {
                return !z6;
            }
        }
        return z6;
    }
}
