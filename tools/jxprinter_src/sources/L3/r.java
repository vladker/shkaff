package L3;

import java.io.File;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class r extends q {
    public static final i walk(File file, n direction) {
        E.f(file, "<this>");
        E.f(direction, "direction");
        return new i(file, direction);
    }

    public static final i walkBottomUp(File file) {
        E.f(file, "<this>");
        return walk(file, n.b);
    }

    public static final i walkTopDown(File file) {
        E.f(file, "<this>");
        return walk(file, n.f451a);
    }
}
