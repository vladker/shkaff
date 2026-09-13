package p059k3;

import io.reactivex.internal.operators.flowable.C0834z1;
import io.reactivex.y;
import p027e3.o;
import t5.b;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class G0 implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final G0 f5511a;
    public static final /* synthetic */ G0[] b;

    static {
        G0 g1 = new G0("INSTANCE", 0);
        f5511a = g1;
        b = new G0[]{g1};
    }

    public static G0 valueOf(String str) {
        return (G0) Enum.valueOf(G0.class, str);
    }

    public static G0[] values() {
        return (G0[]) b.clone();
    }

    @Override // p027e3.o
    public b apply(y yVar) {
        return new C0834z1(yVar, 3);
    }
}
