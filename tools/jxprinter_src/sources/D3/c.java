package D3;

import O3.l;
import java.util.Comparator;
import java.util.Map;
import org.apache.commons.compress.harmony.pack200.BandSet;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class c implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f220a;
    public final /* synthetic */ Object b;

    public /* synthetic */ c(Object obj, int i5) {
        this.f220a = i5;
        this.b = obj;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f220a) {
            case 0:
                for (l lVar : (l[]) this.b) {
                    int iCompareValues = g.compareValues((Comparable) lVar.invoke(obj), (Comparable) lVar.invoke(obj2));
                    if (iCompareValues != 0) {
                        return iCompareValues;
                    }
                }
                return 0;
            default:
                return BandSet.lambda$encodeWithPopulationCodec$0((Map) this.b, obj, obj2);
        }
    }
}
