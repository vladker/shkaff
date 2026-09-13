package com.google.common.graph;

import com.google.common.base.Function;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class d implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3417a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ d(Object obj, Object obj2, int i5) {
        this.f3417a = i5;
        this.c = obj;
        this.b = obj2;
    }

    @Override // com.google.common.base.Function
    public final Object apply(Object obj) {
        switch (this.f3417a) {
            case 0:
                return ImmutableNetwork.lambda$adjacentNodeFn$2((Network) this.c, this.b, obj);
            default:
                return ImmutableValueGraph.lambda$connectionsOf$0((ValueGraph) this.c, this.b, obj);
        }
    }
}
