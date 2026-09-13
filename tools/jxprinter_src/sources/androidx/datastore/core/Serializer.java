package androidx.datastore.core;

import E3.g;
import java.io.InputStream;
import java.io.OutputStream;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public interface Serializer<T> {
    T getDefaultValue();

    Object readFrom(InputStream inputStream, g<? super T> gVar);

    Object writeTo(T t6, OutputStream outputStream, g<? super Q> gVar);
}
