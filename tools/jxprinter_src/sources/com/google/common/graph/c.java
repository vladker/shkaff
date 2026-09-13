package com.google.common.graph;

import com.google.common.base.Function;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class c implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3416a;
    public final /* synthetic */ Network b;

    public /* synthetic */ c(Network network, int i5) {
        this.f3416a = i5;
        this.b = network;
    }

    @Override // com.google.common.base.Function
    public final Object apply(Object obj) {
        switch (this.f3416a) {
            case 0:
                return ImmutableNetwork.lambda$sourceNodeFn$0(this.b, obj);
            default:
                return ImmutableNetwork.lambda$targetNodeFn$1(this.b, obj);
        }
    }
}
