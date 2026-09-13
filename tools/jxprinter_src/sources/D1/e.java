package D1;

import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class e implements Comparator {
    public e(f fVar) {
    }

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        int i5 = ((H1.a) obj).e;
        int i6 = ((H1.a) obj2).e;
        if (i5 == i6) {
            return 0;
        }
        return i5 > i6 ? 1 : -1;
    }
}
