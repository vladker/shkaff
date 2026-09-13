package A3;

import java.util.ArrayList;
import kotlin.jvm.internal.AbstractC1095i;
import kotlin.jvm.internal.AbstractC1096j;
import p072m4.AbstractC1242b;
import p072m4.C1244d;

/* JADX INFO: renamed from: A3.u, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C0152u implements O3.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f49a;
    public final /* synthetic */ Object b;

    public /* synthetic */ C0152u(Object obj, int i5) {
        this.f49a = i5;
        this.b = obj;
    }

    @Override // O3.a
    public final Object invoke() {
        switch (this.f49a) {
            case 0:
                return AbstractC1096j.iterator((double[]) this.b);
            case 1:
                return AbstractC1096j.iterator((char[]) this.b);
            case 2:
                return AbstractC1096j.iterator((float[]) this.b);
            case 3:
                return AbstractC1096j.iterator((boolean[]) this.b);
            case 4:
                return AbstractC1095i.iterator((Object[]) this.b);
            case 5:
                return ((Iterable) this.b).iterator();
            case 6:
                return this.b;
            case 7:
                return X3.b0.iterator((CharSequence) this.b);
            case 8:
                p060k4.e eVar = (p060k4.e) this.b;
                return AbstractC1242b.withContext(p072m4.w.buildSerialDescriptor("kotlinx.serialization.Polymorphic", C1244d.INSTANCE, new p072m4.r[0], new C0130a(eVar, 14)), eVar.getBaseClass());
            case 9:
                return ((V3.p) ((ArrayList) this.b).get(0)).getClassifier();
            default:
                return Integer.valueOf(p072m4.s.c((p072m4.s) this.b));
        }
    }
}
