package com.google.common.graph;

import com.google.common.base.Function;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class b implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3415a;
    public final /* synthetic */ Object b;

    public /* synthetic */ b(Object obj, int i5) {
        this.f3415a = i5;
        this.b = obj;
    }

    @Override // com.google.common.base.Function
    public final Object apply(Object obj) {
        switch (this.f3415a) {
            case 0:
                return DirectedGraphConnections.lambda$incidentEdgeIterator$0(this.b, obj);
            case 1:
                return EndpointPair.ordered(this.b, obj);
            case 2:
                return DirectedGraphConnections.lambda$incidentEdgeIterator$2(this.b, (DirectedGraphConnections.NodeConnection) obj);
            default:
                return EndpointPair.unordered(this.b, obj);
        }
    }
}
