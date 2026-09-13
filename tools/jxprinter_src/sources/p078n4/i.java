package p078n4;

import kotlin.jvm.internal.E;
import p060k4.a;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class i {
    public static <T> T decodeNullableSerializableValue(j jVar, a deserializer) {
        E.f(deserializer, "deserializer");
        return (deserializer.getDescriptor().a() || jVar.decodeNotNullMark()) ? (T) jVar.decodeSerializableValue(deserializer) : (T) jVar.decodeNull();
    }

    public static <T> T decodeSerializableValue(j jVar, a deserializer) {
        E.f(deserializer, "deserializer");
        return (T) deserializer.deserialize(jVar);
    }
}
