package org.apache.xmlbeans.impl.config;

import java.util.function.IntFunction;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class p implements IntFunction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7360a;

    public /* synthetic */ p(int i5) {
        this.f7360a = i5;
    }

    @Override // java.util.function.IntFunction
    public final Object apply(int i5) {
        switch (this.f7360a) {
            case 0:
                return InterfaceExtensionImpl.MethodSignatureImpl.lambda$new$1(i5);
            case 1:
                return InterfaceExtensionImpl.MethodSignatureImpl.lambda$new$3(i5);
            case 2:
                return InterfaceExtensionImpl.MethodSignatureImpl.lambda$new$5(i5);
            case 3:
                return Parser.lambda$new$0(i5);
            case 4:
                return BindingConfigImpl.lambda$getInterfaceExtensions$3(i5);
            case 5:
                return InterfaceExtensionImpl.lambda$validateMethod$5(i5);
            case 6:
                return InterfaceExtensionImpl.lambda$validateMethod$6(i5);
            case 7:
                return InterfaceExtensionImpl.lambda$paramStrings$9(i5);
            default:
                return InterfaceExtensionImpl.lambda$validateMethods$3(i5);
        }
    }
}
