package S3;

import java.util.Random;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends a {
    private final b implStorage = new b();

    @Override // S3.a
    public Random getImpl() {
        Object obj = this.implStorage.get();
        E.e(obj, "get(...)");
        return (Random) obj;
    }
}
