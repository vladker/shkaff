package p127w1;

import X1.c;
import android.graphics.Typeface;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f8815a = -1;
    public static final HashMap b = new HashMap();

    public static Typeface getFont(String str) {
        return (Typeface) b.get(str);
    }

    public static String registerFont(String str) {
        String strValueOf = c.open(Files.newInputStream(Paths.get(str, new String[0]), new OpenOption[0])).e;
        if (strValueOf == null) {
            int i5 = f8815a + 1;
            f8815a = i5;
            strValueOf = String.valueOf(i5);
        }
        HashMap map = b;
        if (map.containsKey(strValueOf)) {
            return strValueOf;
        }
        map.put(strValueOf, Typeface.createFromFile(new File(str)));
        return strValueOf;
    }
}
