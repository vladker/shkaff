package androidx.datastore.core.okio;

import A4.V;
import B4.g;
import O3.a;
import kotlin.jvm.internal.F;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class OkioStorage$canonicalPath$2 extends F implements a {
    final /* synthetic */ OkioStorage<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OkioStorage$canonicalPath$2(OkioStorage<T> okioStorage) {
        super(0);
        this.this$0 = okioStorage;
    }

    @Override // O3.a
    public final V invoke() {
        V v6 = (V) ((OkioStorage) this.this$0).producePath.invoke();
        v6.getClass();
        boolean z6 = g.g(v6) != -1;
        OkioStorage<T> okioStorage = this.this$0;
        if (z6) {
            return v6.normalized();
        }
        throw new IllegalStateException(("OkioStorage requires absolute paths, but did not get an absolute path from producePath = " + ((OkioStorage) okioStorage).producePath + ", instead got " + v6).toString());
    }
}
