package M3;

import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import kotlin.jvm.internal.B;
import kotlin.jvm.internal.D;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class v extends B implements O3.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ArrayList f490a;
    public final /* synthetic */ O3.q b;
    public final /* synthetic */ Path c;
    public final /* synthetic */ Path d;
    public final /* synthetic */ Path e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ O3.q f491f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(ArrayList arrayList, O3.q qVar, Path path, Path path2, Path path3, O3.q qVar2) {
        super(2, D.class, "copy", "copyToRecursively$copy$PathsKt__PathRecursiveFunctionsKt(Ljava/util/ArrayList;Lkotlin/jvm/functions/Function3;Ljava/nio/file/Path;Ljava/nio/file/Path;Ljava/nio/file/Path;Lkotlin/jvm/functions/Function3;Ljava/nio/file/Path;Ljava/nio/file/attribute/BasicFileAttributes;)Ljava/nio/file/FileVisitResult;", 0);
        this.f490a = arrayList;
        this.b = qVar;
        this.c = path;
        this.d = path2;
        this.e = path3;
        this.f491f = qVar2;
    }

    @Override // O3.p
    public final Object invoke(Object obj, Object obj2) {
        Path p1 = (Path) obj;
        BasicFileAttributes p6 = (BasicFileAttributes) obj2;
        E.f(p1, "p0");
        E.f(p6, "p1");
        return x.b(this.f490a, this.b, this.c, this.d, this.e, this.f491f, p1);
    }
}
