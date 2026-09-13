package M3;

import java.nio.file.Path;
import java.util.Iterator;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class l {
    private Iterator<l> contentIterator;
    private final Object key;
    private final l parent;
    private final Path path;

    public l(Path path, Object obj, l lVar) {
        E.f(path, "path");
        this.path = path;
        this.key = obj;
        this.parent = lVar;
    }

    public final Iterator<l> getContentIterator() {
        return this.contentIterator;
    }

    public final Object getKey() {
        return this.key;
    }

    public final l getParent() {
        return this.parent;
    }

    public final Path getPath() {
        return this.path;
    }

    public final void setContentIterator(Iterator<l> it) {
        this.contentIterator = it;
    }
}
