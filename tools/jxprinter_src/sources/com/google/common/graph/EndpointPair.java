package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Iterators;
import com.google.common.collect.UnmodifiableIterator;
import com.google.errorprone.annotations.Immutable;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@Immutable(containerOf = {"N"})
@Beta
@ElementTypesAreNonnullByDefault
public abstract class EndpointPair<N> implements Iterable<N> {
    private final N nodeU;
    private final N nodeV;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Ordered<N> extends EndpointPair<N> {
        @Override // com.google.common.graph.EndpointPair
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof EndpointPair)) {
                return false;
            }
            EndpointPair endpointPair = (EndpointPair) obj;
            return isOrdered() == endpointPair.isOrdered() && source().equals(endpointPair.source()) && target().equals(endpointPair.target());
        }

        @Override // com.google.common.graph.EndpointPair
        public int hashCode() {
            return Objects.hashCode(source(), target());
        }

        @Override // com.google.common.graph.EndpointPair
        public boolean isOrdered() {
            return true;
        }

        @Override // com.google.common.graph.EndpointPair, java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return iterator();
        }

        @Override // com.google.common.graph.EndpointPair
        public N source() {
            return nodeU();
        }

        @Override // com.google.common.graph.EndpointPair
        public N target() {
            return nodeV();
        }

        public String toString() {
            String strValueOf = String.valueOf(source());
            String strValueOf2 = String.valueOf(target());
            StringBuilder sbU = androidx.exifinterface.media.a.u(strValueOf2.length() + strValueOf.length() + 6, "<", strValueOf, " -> ", strValueOf2);
            sbU.append(">");
            return sbU.toString();
        }

        private Ordered(N n6, N n7) {
            super(n6, n7);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Unordered<N> extends EndpointPair<N> {
        @Override // com.google.common.graph.EndpointPair
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof EndpointPair)) {
                return false;
            }
            EndpointPair endpointPair = (EndpointPair) obj;
            if (isOrdered() != endpointPair.isOrdered()) {
                return false;
            }
            if (nodeU().equals(endpointPair.nodeU())) {
                return nodeV().equals(endpointPair.nodeV());
            }
            return nodeU().equals(endpointPair.nodeV()) && nodeV().equals(endpointPair.nodeU());
        }

        @Override // com.google.common.graph.EndpointPair
        public int hashCode() {
            return nodeV().hashCode() + nodeU().hashCode();
        }

        @Override // com.google.common.graph.EndpointPair
        public boolean isOrdered() {
            return false;
        }

        @Override // com.google.common.graph.EndpointPair, java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return iterator();
        }

        @Override // com.google.common.graph.EndpointPair
        public N source() {
            throw new UnsupportedOperationException("Cannot call source()/target() on a EndpointPair from an undirected graph. Consider calling adjacentNode(node) if you already have a node, or nodeU()/nodeV() if you don't.");
        }

        @Override // com.google.common.graph.EndpointPair
        public N target() {
            throw new UnsupportedOperationException("Cannot call source()/target() on a EndpointPair from an undirected graph. Consider calling adjacentNode(node) if you already have a node, or nodeU()/nodeV() if you don't.");
        }

        public String toString() {
            String strValueOf = String.valueOf(nodeU());
            String strValueOf2 = String.valueOf(nodeV());
            StringBuilder sbU = androidx.exifinterface.media.a.u(strValueOf2.length() + strValueOf.length() + 4, "[", strValueOf, ", ", strValueOf2);
            sbU.append("]");
            return sbU.toString();
        }

        private Unordered(N n6, N n7) {
            super(n6, n7);
        }
    }

    public static <N> EndpointPair<N> of(Graph<?> graph, N n6, N n7) {
        return graph.isDirected() ? ordered(n6, n7) : unordered(n6, n7);
    }

    public static <N> EndpointPair<N> ordered(N n6, N n7) {
        return new Ordered(n6, n7);
    }

    public static <N> EndpointPair<N> unordered(N n6, N n7) {
        return new Unordered(n7, n6);
    }

    public final N adjacentNode(N n6) {
        if (n6.equals(this.nodeU)) {
            return this.nodeV;
        }
        if (n6.equals(this.nodeV)) {
            return this.nodeU;
        }
        String strValueOf = String.valueOf(this);
        String strValueOf2 = String.valueOf(n6);
        throw new IllegalArgumentException(com.google.android.gms.auth.api.accounttransfer.a.j(strValueOf2.length() + strValueOf.length() + 36, "EndpointPair ", strValueOf, " does not contain node ", strValueOf2));
    }

    public abstract boolean equals(Object obj);

    public abstract int hashCode();

    public abstract boolean isOrdered();

    public final N nodeU() {
        return this.nodeU;
    }

    public final N nodeV() {
        return this.nodeV;
    }

    public abstract N source();

    public abstract N target();

    private EndpointPair(N n6, N n7) {
        this.nodeU = (N) Preconditions.checkNotNull(n6);
        this.nodeV = (N) Preconditions.checkNotNull(n7);
    }

    public static <N> EndpointPair<N> of(Network<?, ?> network, N n6, N n7) {
        return network.isDirected() ? ordered(n6, n7) : unordered(n6, n7);
    }

    @Override // java.lang.Iterable
    public final UnmodifiableIterator<N> iterator() {
        return Iterators.forArray(this.nodeU, this.nodeV);
    }
}
