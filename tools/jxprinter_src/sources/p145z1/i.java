package p145z1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9108a;
    public final int b;
    private final f formatOption;
    private final List<h> images;

    public i(Map<?, ?> map) {
        E.f(map, "map");
        Object obj = map.get("fmt");
        E.d(obj, "null cannot be cast to non-null type kotlin.collections.Map<*, *>");
        this.formatOption = new f((Map) obj);
        Object obj2 = map.get("w");
        E.d(obj2, "null cannot be cast to non-null type kotlin.Int");
        this.f9108a = ((Integer) obj2).intValue();
        Object obj3 = map.get("h");
        E.d(obj3, "null cannot be cast to non-null type kotlin.Int");
        this.b = ((Integer) obj3).intValue();
        ArrayList arrayList = new ArrayList();
        Object obj4 = map.get("images");
        E.d(obj4, "null cannot be cast to non-null type kotlin.collections.List<*>");
        for (Object obj5 : (List) obj4) {
            if (obj5 instanceof Map) {
                arrayList.add(new h((Map) obj5));
            }
        }
        this.images = arrayList;
    }

    public final f getFormatOption() {
        return this.formatOption;
    }

    public final List<h> getImages() {
        return this.images;
    }
}
