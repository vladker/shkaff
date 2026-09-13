package com.google.firebase.sessions;

import E3.g;
import G3.f;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
@f(c = "com.google.firebase.sessions.InstallationId$Companion", f = "InstallationId.kt", i = {0, 1}, l = {31, 39}, m = "create", n = {"firebaseInstallations", "authToken"}, s = {"L$0", "L$0"})
public final class InstallationId$Companion$create$1 extends G3.d {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ InstallationId.Companion this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InstallationId$Companion$create$1(InstallationId.Companion companion, g<? super InstallationId$Companion$create$1> gVar) {
        super(gVar);
        this.this$0 = companion;
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.create(null, this);
    }
}
