package p023d4;

import A3.G;
import A3.T;
import androidx.core.location.LocationRequestCompat;
import androidx.exifinterface.media.a;
import java.util.List;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import p018c4.O;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class m2 implements h2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f3891a;
    public final long b;

    public m2(long j6, long j7) {
        this.f3891a = j6;
        this.b = j7;
        if (j6 < 0) {
            throw new IllegalArgumentException(a.k("stopTimeout(", j6, " ms) cannot be negative").toString());
        }
        if (j7 < 0) {
            throw new IllegalArgumentException(a.k("replayExpiration(", j7, " ms) cannot be negative").toString());
        }
    }

    @Override // p023d4.h2
    public InterfaceC0612o command(n2 n2Var) {
        return AbstractC0618q.distinctUntilChanged(AbstractC0618q.dropWhile(AbstractC0618q.transformLatest(n2Var, new l2(this, null)), new O(2, null, 2)));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof m2)) {
            return false;
        }
        m2 m2Var = (m2) obj;
        return this.f3891a == m2Var.f3891a && this.b == m2Var.b;
    }

    @IgnoreJRERequirement
    public int hashCode() {
        return Long.hashCode(this.b) + (Long.hashCode(this.f3891a) * 31);
    }

    public String toString() {
        List listCreateListBuilder = G.createListBuilder(2);
        long j6 = this.f3891a;
        if (j6 > 0) {
            listCreateListBuilder.add("stopTimeout=" + j6 + "ms");
        }
        long j7 = this.b;
        if (j7 < LocationRequestCompat.PASSIVE_INTERVAL) {
            listCreateListBuilder.add("replayExpiration=" + j7 + "ms");
        }
        return androidx.collection.a.f(')', T.g(G.build(listCreateListBuilder), null, null, null, null, 63), new StringBuilder("SharingStarted.WhileSubscribed("));
    }
}
