package org.apache.xmlbeans.impl.config;

import java.nio.file.Path;
import java.util.function.Predicate;

/* JADX INFO: renamed from: org.apache.xmlbeans.impl.config.a, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C1439a implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7351a;
    public final /* synthetic */ Comparable b;

    public /* synthetic */ C1439a(Comparable comparable, int i5) {
        this.f7351a = i5;
        this.b = comparable;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        switch (this.f7351a) {
            case 0:
                return BindingConfigImpl.lambda$getInterfaceExtensions$2((String) this.b, (InterfaceExtensionImpl) obj);
            case 1:
                return BindingConfigImpl.lambda$getPrePostExtension$4((String) this.b, (PrePostExtensionImpl) obj);
            default:
                return ((Path) this.b).startsWith((Path) obj);
        }
    }
}
