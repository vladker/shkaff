package p061l;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class f {
    public static final f e = new f(0, null, 1443168256, 1);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final f f5769f = new f(1, null, 1509950721, 1);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final f f5770g = new f(2, null, 1124075009, 1);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final f f5771h = new f(3, null, 1107297537, 1);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final f f5772i = new f(4, null, 1392510721, 1);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final f f5773j = new f(5, null, 1224736769, 1);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final f f5774k = new f(6, null, 1174536705, 1);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final f f5775l = new f(7, null, 1241579778, 1);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final f f5776m = new f(8, null, 1141048066, 1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5777a;
    public final char[] b;
    public final int c;
    public final int d;

    public f(int i5, char[] cArr, int i6, int i7) {
        this.f5777a = i5;
        this.b = cArr;
        this.c = i6;
        this.d = i7;
    }

    public static f a(String str) {
        char c;
        char[] charArray = str.toCharArray();
        char c6 = charArray[0];
        if (c6 == 'F') {
            return f5774k;
        }
        if (c6 == 'S') {
            return f5772i;
        }
        if (c6 == 'V') {
            return e;
        }
        if (c6 == 'I') {
            return f5773j;
        }
        if (c6 == 'J') {
            return f5775l;
        }
        if (c6 == 'Z') {
            return f5769f;
        }
        if (c6 != '[') {
            switch (c6) {
                case 'B':
                    return f5771h;
                case 'C':
                    return f5770g;
                case 'D':
                    return f5776m;
                default:
                    int i5 = 1;
                    while (charArray[i5] != ';') {
                        i5++;
                    }
                    return new f(10, charArray, 1, i5 - 1);
            }
        }
        int i6 = 1;
        while (true) {
            c = charArray[i6];
            if (c != '[') {
                break;
            }
            i6++;
        }
        if (c == 'L') {
            do {
                i6++;
            } while (charArray[i6] != ';');
        }
        return new f(9, charArray, 0, i6 + 1);
    }
}
