package p078n4;

import kotlin.jvm.internal.E;
import p060k4.m;
import p072m4.r;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class k {
    public static h beginCollection(l lVar, r descriptor, int i5) {
        E.f(descriptor, "descriptor");
        return lVar.beginStructure(descriptor);
    }

    public static <T> void encodeNullableSerializableValue(l lVar, m serializer, T t6) {
        E.f(serializer, "serializer");
        if (serializer.getDescriptor().a()) {
            lVar.encodeSerializableValue(serializer, t6);
        } else if (t6 == null) {
            lVar.encodeNull();
        } else {
            lVar.encodeNotNullMark();
            lVar.encodeSerializableValue(serializer, t6);
        }
    }

    public static <T> void encodeSerializableValue(l lVar, m serializer, T t6) {
        E.f(serializer, "serializer");
        serializer.serialize(lVar, t6);
    }

    public static void encodeNotNullMark(l lVar) {
    }
}
