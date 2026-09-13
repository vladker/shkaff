package androidx.datastore.core.okio;

import A4.InterfaceC0170m;
import A4.InterfaceC0171n;
import E3.g;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public interface OkioSerializer<T> {
    T getDefaultValue();

    Object readFrom(InterfaceC0171n interfaceC0171n, g<? super T> gVar);

    Object writeTo(T t6, InterfaceC0170m interfaceC0170m, g<? super Q> gVar);
}
