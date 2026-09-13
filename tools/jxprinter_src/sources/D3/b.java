package D3;

import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class b implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f219a;
    public final /* synthetic */ Comparator b;
    public final /* synthetic */ Comparator c;

    public /* synthetic */ b(Comparator comparator, Comparator comparator2, int i5) {
        this.f219a = i5;
        this.b = comparator;
        this.c = comparator2;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f219a) {
            case 0:
                int iCompare = this.b.compare(obj, obj2);
                return iCompare != 0 ? iCompare : this.c.compare(obj2, obj);
            default:
                int iCompare2 = this.b.compare(obj, obj2);
                return iCompare2 != 0 ? iCompare2 : this.c.compare(obj, obj2);
        }
    }
}
