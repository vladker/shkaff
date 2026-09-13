package androidx.datastore.core;

import java.io.File;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class FileMoves_androidKt {
    public static final boolean atomicMoveTo(File file, File toFile) {
        E.f(file, "<this>");
        E.f(toFile, "toFile");
        return Api26Impl.INSTANCE.move(file, toFile);
    }
}
