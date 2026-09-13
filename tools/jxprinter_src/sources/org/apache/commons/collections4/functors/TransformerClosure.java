package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Closure;
import org.apache.commons.collections4.Transformer;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class TransformerClosure<E> implements Closure<E>, Serializable {
    private static final long serialVersionUID = -5194992589193388969L;
    private final Transformer<? super E, ?> iTransformer;

    public TransformerClosure(Transformer<? super E, ?> transformer) {
        this.iTransformer = transformer;
    }

    public static <E> Closure<E> transformerClosure(Transformer<? super E, ?> transformer) {
        return transformer == null ? NOPClosure.nopClosure() : new TransformerClosure(transformer);
    }

    @Override // org.apache.commons.collections4.Closure
    public void execute(E e) {
        this.iTransformer.transform(e);
    }

    public Transformer<? super E, ?> getTransformer() {
        return this.iTransformer;
    }
}
