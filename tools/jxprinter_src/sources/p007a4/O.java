package p007a4;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class O {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f942a;

    static {
        int[] iArr = new int[P.values().length];
        try {
            P p6 = P.f943a;
            iArr[0] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr[P.ATOMIC.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            P p7 = P.f943a;
            iArr[3] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            P p8 = P.f943a;
            iArr[1] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        f942a = iArr;
    }
}
