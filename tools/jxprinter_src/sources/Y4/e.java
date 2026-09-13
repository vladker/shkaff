package Y4;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class e extends p {
    public int b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f882a = new ArrayList();

    public p rightMostEvaluator() {
        int i5 = this.b;
        if (i5 <= 0) {
            return null;
        }
        return (p) this.f882a.get(i5 - 1);
    }
}
