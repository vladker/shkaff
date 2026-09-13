package p089p4;

import X3.e0;
import io.reactivex.internal.operators.observable.C0953x2;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ v f7769a = new v();
    private static final w SnakeCase = new C0953x2(8);
    private static final w KebabCase = new C0953x2(7);

    public static final String a(String str, char c) {
        StringBuilder sb = new StringBuilder(str.length() * 2);
        Character chValueOf = null;
        int i5 = 0;
        for (int i6 = 0; i6 < str.length(); i6++) {
            char cCharAt = str.charAt(i6);
            if (Character.isUpperCase(cCharAt)) {
                if (i5 == 0 && sb.length() > 0 && e0.last(sb) != c) {
                    sb.append(c);
                }
                if (chValueOf != null) {
                    sb.append(chValueOf.charValue());
                }
                i5++;
                chValueOf = Character.valueOf(Character.toLowerCase(cCharAt));
            } else {
                if (chValueOf != null) {
                    if (i5 > 1 && Character.isLetter(cCharAt)) {
                        sb.append(c);
                    }
                    sb.append(chValueOf.charValue());
                    chValueOf = null;
                    i5 = 0;
                }
                sb.append(cCharAt);
            }
        }
        if (chValueOf != null) {
            sb.append(chValueOf.charValue());
        }
        String string = sb.toString();
        E.e(string, "toString(...)");
        return string;
    }

    public final w getKebabCase() {
        return KebabCase;
    }

    public final w getSnakeCase() {
        return SnakeCase;
    }

    public static /* synthetic */ void getKebabCase$annotations() {
    }

    public static /* synthetic */ void getSnakeCase$annotations() {
    }
}
