package M3;

import java.nio.file.FileSystemException;
import java.nio.file.Path;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class i extends FileSystemException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(Path file, Path path, String str) {
        super(file.toString(), path != null ? path.toString() : null, str);
        E.f(file, "file");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public i(Path file) {
        this(file, null, null);
        E.f(file, "file");
    }
}
