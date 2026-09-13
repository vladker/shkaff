package M3;

import java.nio.file.Path;
import kotlin.jvm.internal.B;
import kotlin.jvm.internal.D;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class w extends B implements O3.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ O3.q f492a;
    public final /* synthetic */ Path b;
    public final /* synthetic */ Path c;
    public final /* synthetic */ Path d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(O3.q qVar, Path path, Path path2, Path path3) {
        super(2, D.class, "error", "copyToRecursively$error$PathsKt__PathRecursiveFunctionsKt(Lkotlin/jvm/functions/Function3;Ljava/nio/file/Path;Ljava/nio/file/Path;Ljava/nio/file/Path;Ljava/nio/file/Path;Ljava/lang/Exception;)Ljava/nio/file/FileVisitResult;", 0);
        this.f492a = qVar;
        this.b = path;
        this.c = path2;
        this.d = path3;
    }

    @Override // O3.p
    public final Object invoke(Object obj, Object obj2) {
        Path p1 = (Path) obj;
        Exception p6 = (Exception) obj2;
        E.f(p1, "p0");
        E.f(p6, "p1");
        return x.c(this.f492a, this.b, this.c, this.d, p1, p6);
    }
}
