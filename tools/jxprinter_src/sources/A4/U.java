package A4;

import java.io.File;
import java.nio.file.Path;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class U {
    public final V get(String str) {
        kotlin.jvm.internal.E.f(str, "<this>");
        return get(str, false);
    }

    public final V get(String str, boolean z6) {
        kotlin.jvm.internal.E.f(str, "<this>");
        return B4.g.commonToPath(str, z6);
    }

    public final V get(File file) {
        kotlin.jvm.internal.E.f(file, "<this>");
        return get(file, false);
    }

    public final V get(File file, boolean z6) {
        kotlin.jvm.internal.E.f(file, "<this>");
        String string = file.toString();
        kotlin.jvm.internal.E.e(string, "toString()");
        return get(string, z6);
    }

    public final V get(Path path) {
        kotlin.jvm.internal.E.f(path, "<this>");
        return get(path, false);
    }

    public final V get(Path path, boolean z6) {
        kotlin.jvm.internal.E.f(path, "<this>");
        return get(path.toString(), z6);
    }
}
