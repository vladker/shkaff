package com.google.common.graph;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@ElementTypesAreNonnullByDefault
interface GraphConnections<N, V> {
    void addPredecessor(N n6, V v6);

    @CanIgnoreReturnValue
    V addSuccessor(N n6, V v6);

    Set<N> adjacentNodes();

    Iterator<EndpointPair<N>> incidentEdgeIterator(N n6);

    Set<N> predecessors();

    void removePredecessor(N n6);

    @CanIgnoreReturnValue
    V removeSuccessor(N n6);

    Set<N> successors();

    V value(N n6);
}
