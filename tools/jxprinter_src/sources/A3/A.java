package A3;

import W3.InterfaceC0233q;
import java.util.Iterator;
import kotlin.jvm.internal.AbstractC1095i;
import kotlin.jvm.internal.AbstractC1096j;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class A implements Iterable, P3.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f29a;
    public final /* synthetic */ Object b;

    public /* synthetic */ A(Object obj, int i5) {
        this.f29a = i5;
        this.b = obj;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        switch (this.f29a) {
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
                return (Iterator) ((O3.a) this.b).invoke();
            case 10:
                return ((InterfaceC0233q) this.b).iterator();
            default:
                return X3.b0.iterator((CharSequence) this.b);
        }
    }
}
