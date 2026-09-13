package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Factory;
import org.apache.commons.collections4.Transformer;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class FactoryTransformer<I, O> implements Transformer<I, O>, Serializable {
    private static final long serialVersionUID = -6817674502475353160L;
    private final Factory<? extends O> iFactory;

    public FactoryTransformer(Factory<? extends O> factory) {
        this.iFactory = factory;
    }

    public static <I, O> Transformer<I, O> factoryTransformer(Factory<? extends O> factory) {
        if (factory != null) {
            return new FactoryTransformer(factory);
        }
        throw new NullPointerException("Factory must not be null");
    }

    public Factory<? extends O> getFactory() {
        return this.iFactory;
    }

    @Override // org.apache.commons.collections4.Transformer
    public O transform(I i5) {
        return this.iFactory.create();
    }
}
