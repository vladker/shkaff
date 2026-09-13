package com.google.firebase.components;

import com.google.firebase.inject.Provider;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class c implements Provider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3466a;
    public final /* synthetic */ ComponentRegistrar b;

    public /* synthetic */ c(ComponentRegistrar componentRegistrar, int i5) {
        this.f3466a = i5;
        this.b = componentRegistrar;
    }

    @Override // com.google.firebase.inject.Provider
    public final Object get() {
        switch (this.f3466a) {
            case 0:
                return ComponentRuntime.lambda$toProviders$1(this.b);
            default:
                return ComponentRuntime.Builder.lambda$addComponentRegistrar$0(this.b);
        }
    }
}
