package p145z1;

import java.util.Map;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class h {
    private final byte[] byteArray;
    private final g position;

    public h(Map<?, ?> map) {
        E.f(map, "map");
        Object obj = map.get("src");
        E.d(obj, "null cannot be cast to non-null type kotlin.collections.Map<*, *>");
        Object obj2 = ((Map) obj).get("memory");
        E.d(obj2, "null cannot be cast to non-null type kotlin.ByteArray");
        this.byteArray = (byte[]) obj2;
        Object obj3 = map.get("position");
        E.d(obj3, "null cannot be cast to non-null type kotlin.collections.Map<*, *>");
        this.position = new g((Map) obj3);
    }

    public final byte[] getByteArray() {
        return this.byteArray;
    }

    public final g getPosition() {
        return this.position;
    }
}
