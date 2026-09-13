package D3;

import O3.l;
import O3.p;
import java.util.Comparator;
import p147z3.InterfaceC1927g;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class e implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f222a;
    public final /* synthetic */ Comparator b;
    public final /* synthetic */ InterfaceC1927g c;

    public /* synthetic */ e(Comparator comparator, InterfaceC1927g interfaceC1927g, int i5) {
        this.f222a = i5;
        this.b = comparator;
        this.c = interfaceC1927g;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f222a) {
            case 0:
                l lVar = (l) this.c;
                return this.b.compare(lVar.invoke(obj), lVar.invoke(obj2));
            case 1:
                l lVar2 = (l) this.c;
                return this.b.compare(lVar2.invoke(obj2), lVar2.invoke(obj));
            case 2:
                int iCompare = this.b.compare(obj, obj2);
                if (iCompare != 0) {
                    return iCompare;
                }
                l lVar3 = (l) this.c;
                return g.compareValues((Comparable) lVar3.invoke(obj), (Comparable) lVar3.invoke(obj2));
            case 3:
                int iCompare2 = this.b.compare(obj, obj2);
                if (iCompare2 != 0) {
                    return iCompare2;
                }
                l lVar4 = (l) this.c;
                return g.compareValues((Comparable) lVar4.invoke(obj2), (Comparable) lVar4.invoke(obj));
            default:
                int iCompare3 = this.b.compare(obj, obj2);
                return iCompare3 != 0 ? iCompare3 : ((Number) ((p) this.c).invoke(obj, obj2)).intValue();
        }
    }
}
