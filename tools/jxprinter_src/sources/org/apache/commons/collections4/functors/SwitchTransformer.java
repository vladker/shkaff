package org.apache.commons.collections4.functors;

import java.io.Serializable;
import java.util.Map;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.Transformer;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class SwitchTransformer<I, O> implements Transformer<I, O>, Serializable {
    private static final long serialVersionUID = -6404460890903469332L;
    private final Transformer<? super I, ? extends O> iDefault;
    private final Predicate<? super I>[] iPredicates;
    private final Transformer<? super I, ? extends O>[] iTransformers;

    private SwitchTransformer(boolean z6, Predicate<? super I>[] predicateArr, Transformer<? super I, ? extends O>[] transformerArr, Transformer<? super I, ? extends O> transformer) {
        this.iPredicates = z6 ? FunctorUtils.copy(predicateArr) : predicateArr;
        this.iTransformers = z6 ? FunctorUtils.copy(transformerArr) : transformerArr;
        this.iDefault = transformer == null ? ConstantTransformer.nullTransformer() : transformer;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <I, O> Transformer<I, O> switchTransformer(Predicate<? super I>[] predicateArr, Transformer<? super I, ? extends O>[] transformerArr, Transformer<? super I, ? extends O> transformer) {
        FunctorUtils.validate(predicateArr);
        FunctorUtils.validate(transformerArr);
        if (predicateArr.length != transformerArr.length) {
            throw new IllegalArgumentException("The predicate and transformer arrays must be the same size");
        }
        if (predicateArr.length == 0) {
            return transformer == 0 ? ConstantTransformer.nullTransformer() : transformer;
        }
        return new SwitchTransformer(predicateArr, transformerArr, transformer);
    }

    public Transformer<? super I, ? extends O> getDefaultTransformer() {
        return this.iDefault;
    }

    public Predicate<? super I>[] getPredicates() {
        return FunctorUtils.copy(this.iPredicates);
    }

    public Transformer<? super I, ? extends O>[] getTransformers() {
        return FunctorUtils.copy(this.iTransformers);
    }

    @Override // org.apache.commons.collections4.Transformer
    public O transform(I i5) {
        int i6 = 0;
        while (true) {
            Predicate<? super I>[] predicateArr = this.iPredicates;
            if (i6 >= predicateArr.length) {
                return this.iDefault.transform(i5);
            }
            if (predicateArr[i6].evaluate(i5)) {
                return this.iTransformers[i6].transform(i5);
            }
            i6++;
        }
    }

    public SwitchTransformer(Predicate<? super I>[] predicateArr, Transformer<? super I, ? extends O>[] transformerArr, Transformer<? super I, ? extends O> transformer) {
        this(true, predicateArr, transformerArr, transformer);
    }

    public static <I, O> Transformer<I, O> switchTransformer(Map<? extends Predicate<? super I>, ? extends Transformer<? super I, ? extends O>> map) {
        if (map != null) {
            if (map.size() == 0) {
                return ConstantTransformer.nullTransformer();
            }
            Transformer<? super I, ? extends O> transformerRemove = map.remove(null);
            int size = map.size();
            if (size == 0) {
                return transformerRemove == null ? ConstantTransformer.nullTransformer() : transformerRemove;
            }
            Transformer[] transformerArr = new Transformer[size];
            Predicate[] predicateArr = new Predicate[size];
            int i5 = 0;
            for (Map.Entry<? extends Predicate<? super I>, ? extends Transformer<? super I, ? extends O>> entry : map.entrySet()) {
                predicateArr[i5] = entry.getKey();
                transformerArr[i5] = entry.getValue();
                i5++;
            }
            return new SwitchTransformer(false, predicateArr, transformerArr, transformerRemove);
        }
        throw new NullPointerException("The predicate and transformer map must not be null");
    }
}
