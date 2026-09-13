package org.apache.commons.collections4.functors;

import org.apache.commons.collections4.Transformer;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class CloneTransformer<T> implements Transformer<T, T> {
    public static final Transformer INSTANCE = new CloneTransformer();

    private CloneTransformer() {
    }

    public static <T> Transformer<T, T> cloneTransformer() {
        return INSTANCE;
    }

    @Override // org.apache.commons.collections4.Transformer
    public T transform(T t6) {
        if (t6 == null) {
            return null;
        }
        return (T) PrototypeFactory.prototypeFactory(t6).create();
    }
}
