package B4;

import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class p implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f113a;

    public /* synthetic */ p(int i5) {
        this.f113a = i5;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f113a) {
            case 0:
                return D3.g.compareValues(((o) obj).getCanonicalPath(), ((o) obj2).getCanonicalPath());
            default:
                return ((Comparable) obj).compareTo(obj2);
        }
    }
}
