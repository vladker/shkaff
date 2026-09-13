package org.apache.commons.math3.geometry.partitioning;

import org.apache.commons.math3.geometry.Space;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
class BoundaryBuilder<S extends Space> implements BSPTreeVisitor<S> {
    /* JADX WARN: Code duplicated, block: B:7:0x0043  */
    @Override // org.apache.commons.math3.geometry.partitioning.BSPTreeVisitor
    public void visitInternalNode(BSPTree<S> bSPTree) {
        SubHyperplane<S> subHyperplaneInsideTouching;
        NodesSet nodesSet;
        Characterization characterization = new Characterization(bSPTree.getPlus(), bSPTree.getCut().copySelf());
        SubHyperplane<S> subHyperplaneOutsideTouching = null;
        if (characterization.touchOutside()) {
            Characterization characterization2 = new Characterization(bSPTree.getMinus(), characterization.outsideTouching());
            if (characterization2.touchInside()) {
                subHyperplaneInsideTouching = characterization2.insideTouching();
                nodesSet = new NodesSet();
                nodesSet.addAll(characterization2.getInsideSplitters());
                nodesSet.addAll(characterization.getOutsideSplitters());
            } else {
                subHyperplaneInsideTouching = null;
                nodesSet = null;
            }
        } else {
            subHyperplaneInsideTouching = null;
            nodesSet = null;
        }
        if (characterization.touchInside()) {
            Characterization characterization3 = new Characterization(bSPTree.getMinus(), characterization.insideTouching());
            if (characterization3.touchOutside()) {
                subHyperplaneOutsideTouching = characterization3.outsideTouching();
                if (nodesSet == null) {
                    nodesSet = new NodesSet();
                }
                nodesSet.addAll(characterization3.getOutsideSplitters());
                nodesSet.addAll(characterization.getInsideSplitters());
            }
        }
        if (nodesSet != null) {
            for (BSPTree<S> parent = bSPTree.getParent(); parent != null; parent = parent.getParent()) {
                nodesSet.add(parent);
            }
        }
        bSPTree.setAttribute(new BoundaryAttribute(subHyperplaneInsideTouching, subHyperplaneOutsideTouching, nodesSet));
    }

    @Override // org.apache.commons.math3.geometry.partitioning.BSPTreeVisitor
    public BSPTreeVisitor.Order visitOrder(BSPTree<S> bSPTree) {
        return BSPTreeVisitor.Order.PLUS_MINUS_SUB;
    }

    @Override // org.apache.commons.math3.geometry.partitioning.BSPTreeVisitor
    public void visitLeafNode(BSPTree<S> bSPTree) {
    }
}
