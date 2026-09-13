package kotlinx.serialization.json.internal;

import java.util.Map;

/* JADX INFO: renamed from: kotlinx.serialization.json.internal.u, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class C1144u {
    private final Map<p072m4.r, Map<C1143t, Object>> map = AbstractC1142s.createMapForCache(16);

    public final <T> T get(p072m4.r descriptor, C1143t key) {
        kotlin.jvm.internal.E.f(descriptor, "descriptor");
        kotlin.jvm.internal.E.f(key, "key");
        Map<C1143t, Object> map = this.map.get(descriptor);
        T t6 = map != null ? (T) map.get(key) : null;
        if (t6 == null) {
            return null;
        }
        return t6;
    }

    public final <T> T getOrPut(p072m4.r descriptor, C1143t key, O3.a defaultValue) {
        kotlin.jvm.internal.E.f(descriptor, "descriptor");
        kotlin.jvm.internal.E.f(key, "key");
        kotlin.jvm.internal.E.f(defaultValue, "defaultValue");
        T t6 = (T) get(descriptor, key);
        if (t6 != null) {
            return t6;
        }
        T t7 = (T) defaultValue.invoke();
        set(descriptor, key, t7);
        return t7;
    }

    public final <T> void set(p072m4.r descriptor, C1143t key, T value) {
        kotlin.jvm.internal.E.f(descriptor, "descriptor");
        kotlin.jvm.internal.E.f(key, "key");
        kotlin.jvm.internal.E.f(value, "value");
        Map<p072m4.r, Map<C1143t, Object>> map = this.map;
        Map<C1143t, Object> mapCreateMapForCache = map.get(descriptor);
        if (mapCreateMapForCache == null) {
            mapCreateMapForCache = AbstractC1142s.createMapForCache(2);
            map.put(descriptor, mapCreateMapForCache);
        }
        mapCreateMapForCache.put(key, value);
    }
}
