package U1;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class h extends b {
    public final String b;
    public final boolean c;

    public h(String str, boolean z6) {
        char cCharAt;
        this.b = null;
        this.c = false;
        if (str == null) {
            throw new IllegalArgumentException("name cannot be null");
        }
        if (str.length() != 0 && (((cCharAt = str.charAt(0)) < '0' || cCharAt > '9') && cCharAt != '.' && cCharAt != ',' && cCharAt != '(' && cCharAt != ')' && cCharAt != '^' && cCharAt != '*' && cCharAt != '/' && cCharAt != '+' && cCharAt != '-' && cCharAt != ' ' && cCharAt != '\t' && cCharAt != '\n')) {
            for (int i5 = 1; i5 < str.length(); i5++) {
                char cCharAt2 = str.charAt(i5);
                if (cCharAt2 != ',' && cCharAt2 != '(' && cCharAt2 != ')' && cCharAt2 != '^' && cCharAt2 != '*' && cCharAt2 != '/' && cCharAt2 != '+' && cCharAt2 != '-' && cCharAt2 != ' ' && cCharAt2 != '\t' && cCharAt2 != '\n') {
                }
            }
            this.b = str;
            this.c = z6;
            return;
        }
        throw new IllegalArgumentException("invalid name: ".concat(str));
    }
}
