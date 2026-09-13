package B4;

import java.util.List;
import kotlin.jvm.internal.F;
import p147z3.C1938s;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class m extends F implements O3.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ClassLoader f111a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(ClassLoader classLoader) {
        super(0);
        this.f111a = classLoader;
    }

    @Override // O3.a
    public final List<C1938s> invoke() {
        return n.Companion.toClasspathRoots(this.f111a);
    }
}
