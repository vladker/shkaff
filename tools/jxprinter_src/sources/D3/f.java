package D3;

import O3.l;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class f implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f223a;
    public final /* synthetic */ Comparator b;
    public final /* synthetic */ Comparator c;
    public final /* synthetic */ l d;

    public /* synthetic */ f(Comparator comparator, Comparator comparator2, l lVar, int i5) {
        this.f223a = i5;
        this.b = comparator;
        this.c = comparator2;
        this.d = lVar;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f223a) {
            case 0:
                int iCompare = this.b.compare(obj, obj2);
                if (iCompare != 0) {
                    return iCompare;
                }
                l lVar = this.d;
                return this.c.compare(lVar.invoke(obj), lVar.invoke(obj2));
            default:
                int iCompare2 = this.b.compare(obj, obj2);
                if (iCompare2 != 0) {
                    return iCompare2;
                }
                l lVar2 = this.d;
                return this.c.compare(lVar2.invoke(obj2), lVar2.invoke(obj));
        }
    }
}
