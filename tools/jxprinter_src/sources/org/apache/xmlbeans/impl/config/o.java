package org.apache.xmlbeans.impl.config;

import java.io.File;
import java.nio.file.Path;
import java.util.function.Function;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class o implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7359a;

    public /* synthetic */ o(int i5) {
        this.f7359a = i5;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f7359a) {
            case 0:
                return InterfaceExtensionImpl.MethodSignatureImpl.replaceInner((String) obj);
            case 1:
                return Parser.lambda$new$1((File) obj);
            case 2:
                return Parser.fileToURL((File) obj);
            case 3:
                return ((Path) obj).toAbsolutePath();
            default:
                return ((File) obj).toPath();
        }
    }
}
