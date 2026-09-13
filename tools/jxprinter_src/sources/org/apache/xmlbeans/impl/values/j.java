package org.apache.xmlbeans.impl.values;

import java.util.function.ToDoubleFunction;
import org.apache.xmlbeans.SimpleValue;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class j implements ToDoubleFunction {
    @Override // java.util.function.ToDoubleFunction
    public final double applyAsDouble(Object obj) {
        return ((SimpleValue) obj).getDoubleValue();
    }
}
