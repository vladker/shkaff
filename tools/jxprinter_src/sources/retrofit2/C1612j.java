package retrofit2;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: retrofit2.j, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public class C1612j {
    public List a() {
        return Collections.EMPTY_LIST;
    }

    public List<? extends AbstractC1614l> createDefaultCallAdapterFactories(Executor executor) {
        return Collections.singletonList(new C1623v(executor));
    }
}
