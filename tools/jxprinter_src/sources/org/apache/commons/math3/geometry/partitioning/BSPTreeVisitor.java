package org.apache.commons.math3.geometry.partitioning;

import org.apache.commons.math3.geometry.Space;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface BSPTreeVisitor<S extends Space> {

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum Order {
        PLUS_MINUS_SUB,
        PLUS_SUB_MINUS,
        MINUS_PLUS_SUB,
        MINUS_SUB_PLUS,
        SUB_PLUS_MINUS,
        SUB_MINUS_PLUS
    }

    void visitInternalNode(BSPTree<S> bSPTree);

    void visitLeafNode(BSPTree<S> bSPTree);

    Order visitOrder(BSPTree<S> bSPTree);
}
