package androidx.datastore;

import A4.InterfaceC0170m;
import A4.InterfaceC0171n;
import E3.g;
import F3.i;
import androidx.datastore.core.Serializer;
import androidx.datastore.core.okio.OkioSerializer;
import kotlin.jvm.internal.E;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class OkioSerializerWrapper<T> implements OkioSerializer<T> {
    private final Serializer<T> delegate;

    public OkioSerializerWrapper(Serializer<T> delegate) {
        E.f(delegate, "delegate");
        this.delegate = delegate;
    }

    @Override // androidx.datastore.core.okio.OkioSerializer
    public T getDefaultValue() {
        return this.delegate.getDefaultValue();
    }

    @Override // androidx.datastore.core.okio.OkioSerializer
    public Object readFrom(InterfaceC0171n interfaceC0171n, g<? super T> gVar) {
        return this.delegate.readFrom(interfaceC0171n.inputStream(), gVar);
    }

    @Override // androidx.datastore.core.okio.OkioSerializer
    public Object writeTo(T t6, InterfaceC0170m interfaceC0170m, g<? super Q> gVar) {
        Object objWriteTo = this.delegate.writeTo(t6, interfaceC0170m.outputStream(), gVar);
        return objWriteTo == i.getCOROUTINE_SUSPENDED() ? objWriteTo : Q.INSTANCE;
    }
}
