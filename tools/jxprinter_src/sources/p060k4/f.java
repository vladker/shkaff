package p060k4;

import kotlin.jvm.internal.E;
import kotlin.jvm.internal.U;
import p078n4.l;
import p084o4.AbstractC1299b;
import p084o4.AbstractC1301c;
import p147z3.C1929i;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class f {
    public static final <T> a findPolymorphicSerializer(AbstractC1299b abstractC1299b, p078n4.f decoder, String str) {
        E.f(abstractC1299b, "<this>");
        E.f(decoder, "decoder");
        a aVarFindPolymorphicSerializerOrNull = abstractC1299b.findPolymorphicSerializerOrNull(decoder, str);
        if (aVarFindPolymorphicSerializerOrNull != null) {
            return aVarFindPolymorphicSerializerOrNull;
        }
        AbstractC1301c.throwSubtypeNotRegistered(str, abstractC1299b.getBaseClass());
        throw new C1929i();
    }

    public static final <T> m findPolymorphicSerializer(AbstractC1299b abstractC1299b, l encoder, T value) {
        E.f(abstractC1299b, "<this>");
        E.f(encoder, "encoder");
        E.f(value, "value");
        m mVarFindPolymorphicSerializerOrNull = abstractC1299b.findPolymorphicSerializerOrNull(encoder, value);
        if (mVarFindPolymorphicSerializerOrNull != null) {
            return mVarFindPolymorphicSerializerOrNull;
        }
        AbstractC1301c.throwSubtypeNotRegistered(U.a(value.getClass()), abstractC1299b.getBaseClass());
        throw new C1929i();
    }
}
