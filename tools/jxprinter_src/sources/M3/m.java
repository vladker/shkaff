package M3;

import X3.W;
import X3.e0;
import java.nio.file.Path;
import java.nio.file.Paths;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class m {
    public static final m INSTANCE = new m();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Path f477a = Paths.get("", new String[0]);
    public static final Path b = Paths.get("..", new String[0]);

    public final Path tryRelativeTo(Path path, Path base) {
        Path path2;
        E.f(path, "path");
        E.f(base, "base");
        Path pathNormalize = base.normalize();
        Path pathNormalize2 = path.normalize();
        Path pathRelativize = pathNormalize.relativize(pathNormalize2);
        int iMin = Math.min(pathNormalize.getNameCount(), pathNormalize2.getNameCount());
        for (int i5 = 0; i5 < iMin; i5++) {
            Path name = pathNormalize.getName(i5);
            Path path3 = b;
            if (!E.a(name, path3)) {
                break;
            }
            if (!E.a(pathNormalize2.getName(i5), path3)) {
                throw new IllegalArgumentException("Unable to compute relative path");
            }
        }
        if (pathNormalize2.equals(pathNormalize) || !pathNormalize.equals(f477a)) {
            path2 = pathNormalize2;
            String string = pathRelativize.toString();
            String separator = pathRelativize.getFileSystem().getSeparator();
            E.e(separator, "getSeparator(...)");
            path2 = W.endsWith(string, separator, false) ? pathRelativize.getFileSystem().getPath(e0.dropLast(string, pathRelativize.getFileSystem().getSeparator().length()), new String[0]) : pathRelativize;
        }
        path2 = pathNormalize2;
        E.c(path2);
        return path2;
    }
}
