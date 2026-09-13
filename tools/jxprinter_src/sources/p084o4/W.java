package p084o4;

import kotlin.jvm.internal.E;
import p060k4.b;
import p072m4.r;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class W {
    public static final <T> r InlinePrimitiveDescriptor(String name, b primitiveSerializer) {
        E.f(name, "name");
        E.f(primitiveSerializer, "primitiveSerializer");
        return new U(name, new V(primitiveSerializer));
    }
}
