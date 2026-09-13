package L3;

import java.io.File;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class k extends i.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f449a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(m mVar, File rootFile) {
        super(rootFile);
        E.f(rootFile, "rootFile");
    }

    @Override // L3.i.b
    public File step() {
        if (this.f449a) {
            return null;
        }
        this.f449a = true;
        return getRoot();
    }
}
