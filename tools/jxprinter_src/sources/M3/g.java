package M3;

import java.nio.file.FileVisitor;
import java.nio.file.Path;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class g implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f475a;
    private O3.p onPostVisitDirectory;
    private O3.p onPreVisitDirectory;
    private O3.p onVisitFile;
    private O3.p onVisitFileFailed;

    public static void b(Object obj, String str) {
        if (obj != null) {
            throw new IllegalStateException(str.concat(" was already defined"));
        }
    }

    public final void a() {
        if (this.f475a) {
            throw new IllegalStateException("This builder was already built");
        }
    }

    public final FileVisitor<Path> build() {
        a();
        this.f475a = true;
        return new h(this.onPreVisitDirectory, this.onVisitFile, this.onVisitFileFailed, this.onPostVisitDirectory);
    }

    @Override // M3.f
    public void onPostVisitDirectory(O3.p function) {
        E.f(function, "function");
        a();
        b(this.onPostVisitDirectory, "onPostVisitDirectory");
        this.onPostVisitDirectory = function;
    }

    @Override // M3.f
    public void onPreVisitDirectory(O3.p function) {
        E.f(function, "function");
        a();
        b(this.onPreVisitDirectory, "onPreVisitDirectory");
        this.onPreVisitDirectory = function;
    }

    @Override // M3.f
    public void onVisitFile(O3.p function) {
        E.f(function, "function");
        a();
        b(this.onVisitFile, "onVisitFile");
        this.onVisitFile = function;
    }

    @Override // M3.f
    public void onVisitFileFailed(O3.p function) {
        E.f(function, "function");
        a();
        b(this.onVisitFileFailed, "onVisitFileFailed");
        this.onVisitFileFailed = function;
    }
}
