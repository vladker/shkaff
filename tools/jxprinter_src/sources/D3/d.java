package D3;

import O3.l;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class d implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f221a;
    public final /* synthetic */ l b;

    public /* synthetic */ d(int i5, l lVar) {
        this.f221a = i5;
        this.b = lVar;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f221a) {
            case 0:
                l lVar = this.b;
                return g.compareValues((Comparable) lVar.invoke(obj), (Comparable) lVar.invoke(obj2));
            default:
                l lVar2 = this.b;
                return g.compareValues((Comparable) lVar2.invoke(obj2), (Comparable) lVar2.invoke(obj));
        }
    }
}
