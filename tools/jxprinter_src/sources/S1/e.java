package S1;

import A3.AbstractC0157z;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class e extends RuntimeException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f622a;
    public int b;
    public int c;
    public U1.c d = null;

    public e(String str, int i5, int i6) {
        this.f622a = str;
        this.b = i5;
        this.c = i6;
    }

    @Override // java.lang.Throwable
    public final String toString() {
        String str;
        int i5 = this.b;
        String str2 = this.f622a;
        int i6 = this.c;
        U1.c cVar = this.d;
        if (cVar != null) {
            str = "\n" + cVar.toString();
        } else {
            str = "";
        }
        if (i5 == -1 && i6 == -1) {
            return androidx.collection.a.n(str2, str);
        }
        if (i5 == i6) {
            return str2 + " : [" + i6 + "]" + str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append(" : [");
        sb.append(i5);
        sb.append(", ");
        sb.append(i6);
        return AbstractC0157z.s(sb, "]", str);
    }
}
