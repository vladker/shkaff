package com.google.firebase.components;

import com.google.firebase.crashlytics.CrashlyticsRegistrar;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class a implements ComponentFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3464a;
    public final /* synthetic */ Object b;

    public /* synthetic */ a(Object obj, int i5) {
        this.f3464a = i5;
        this.b = obj;
    }

    @Override // com.google.firebase.components.ComponentFactory
    public final Object create(ComponentContainer componentContainer) {
        switch (this.f3464a) {
            case 0:
                return Component.lambda$of$2(this.b, componentContainer);
            case 1:
                return Component.lambda$intoSet$4(this.b, componentContainer);
            case 2:
                return Component.lambda$intoSet$3(this.b, componentContainer);
            case 3:
                return Component.lambda$of$0(this.b, componentContainer);
            case 4:
                return Component.lambda$of$1(this.b, componentContainer);
            default:
                return ((CrashlyticsRegistrar) this.b).buildCrashlytics(componentContainer);
        }
    }
}
