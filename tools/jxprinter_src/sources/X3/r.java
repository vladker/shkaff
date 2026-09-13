package X3;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class r {
    private static final C0246l HexFormat(O3.l builderAction) {
        kotlin.jvm.internal.E.f(builderAction, "builderAction");
        C0246l.a aVar = new C0246l.a();
        builderAction.invoke(aVar);
        return aVar.build();
    }

    public static final boolean a(String str) {
        for (int i5 = 0; i5 < str.length(); i5++) {
            char cCharAt = str.charAt(i5);
            if (kotlin.jvm.internal.E.h(cCharAt, 128) >= 0 || Character.isLetter(cCharAt)) {
                return true;
            }
        }
        return false;
    }
}
