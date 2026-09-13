package L3;

import java.io.File;
import java.io.IOException;
import kotlin.jvm.internal.E;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class s implements O3.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f453a;
    public final /* synthetic */ O3.p b;

    public /* synthetic */ s(O3.p pVar, int i5) {
        this.f453a = i5;
        this.b = pVar;
    }

    @Override // O3.p
    public final Object invoke(Object obj, Object obj2) throws y {
        switch (this.f453a) {
            case 0:
                File f6 = (File) obj;
                IOException e = (IOException) obj2;
                E.f(f6, "f");
                E.f(e, "e");
                if (this.b.invoke(f6, e) != x.f455a) {
                    return Q.INSTANCE;
                }
                throw new y(f6);
            default:
                Integer num = (Integer) obj;
                num.intValue();
                this.b.invoke(num, obj2);
                return obj2;
        }
    }
}
