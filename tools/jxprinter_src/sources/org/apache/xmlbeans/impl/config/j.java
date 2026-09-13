package org.apache.xmlbeans.impl.config;

import java.net.URL;
import java.util.Objects;
import java.util.function.Predicate;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class j implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7357a;

    public /* synthetic */ j(int i5) {
        this.f7357a = i5;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        Object obj2;
        switch (this.f7357a) {
            case 0:
                obj2 = (InterfaceExtensionImpl.MethodSignatureImpl) obj;
                break;
            default:
                obj2 = (URL) obj;
                break;
        }
        return Objects.nonNull(obj2);
    }
}
