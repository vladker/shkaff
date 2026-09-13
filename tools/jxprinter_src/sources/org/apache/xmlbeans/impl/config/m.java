package org.apache.xmlbeans.impl.config;

import com.github.javaparser.ast.type.TypeParameter;
import java.util.function.Function;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class m implements Function {
    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return ((TypeParameter) obj).toString();
    }
}
