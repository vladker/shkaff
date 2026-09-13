package A3;

import W3.InterfaceC0233q;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.AbstractC1095i;
import kotlin.jvm.internal.AbstractC1096j;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class B implements InterfaceC0233q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f31a;
    public final /* synthetic */ Object b;

    public /* synthetic */ B(Object obj, int i5) {
        this.f31a = i5;
        this.b = obj;
    }

    @Override // W3.InterfaceC0233q
    public final Iterator iterator() {
        switch (this.f31a) {
            case 0:
                return AbstractC1095i.iterator((Object[]) this.b);
            case 1:
                return AbstractC1096j.iterator((byte[]) this.b);
            case 2:
                return AbstractC1096j.iterator((short[]) this.b);
            case 3:
                return AbstractC1096j.iterator((int[]) this.b);
            case 4:
                return AbstractC1096j.iterator((long[]) this.b);
            case 5:
                return AbstractC1096j.iterator((float[]) this.b);
            case 6:
                return AbstractC1096j.iterator((double[]) this.b);
            case 7:
                return AbstractC1096j.iterator((boolean[]) this.b);
            case 8:
                return AbstractC1096j.iterator((char[]) this.b);
            case 9:
                return ((Iterable) this.b).iterator();
            case 10:
                return W3.t.iterator((O3.p) this.b);
            case 11:
                return (Iterator) ((O3.a) this.b).invoke();
            default:
                List mutableList = W3.L.toMutableList((InterfaceC0233q) this.b);
                N.sort(mutableList);
                return mutableList.iterator();
        }
    }
}
