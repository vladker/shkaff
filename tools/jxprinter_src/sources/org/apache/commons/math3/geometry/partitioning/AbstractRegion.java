package org.apache.commons.math3.geometry.partitioning;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;
import org.apache.commons.math3.geometry.Point;
import org.apache.commons.math3.geometry.Space;
import org.apache.commons.math3.geometry.Vector;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractRegion<S extends Space, T extends Space> implements Region<S> {
    private Point<S> barycenter;
    private double size;
    private final double tolerance;
    private BSPTree<S> tree;

    /* JADX INFO: renamed from: org.apache.commons.math3.geometry.partitioning.AbstractRegion$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$math3$geometry$partitioning$Side;

        static {
            int[] iArr = new int[Side.values().length];
            $SwitchMap$org$apache$commons$math3$geometry$partitioning$Side = iArr;
            try {
                iArr[Side.PLUS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$commons$math3$geometry$partitioning$Side[Side.MINUS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$commons$math3$geometry$partitioning$Side[Side.BOTH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public AbstractRegion(double d) {
        this.tree = new BSPTree<>(Boolean.TRUE);
        this.tolerance = d;
    }

    private void insertCuts(BSPTree<S> bSPTree, Collection<SubHyperplane<S>> collection) {
        Hyperplane<S> hyperplane;
        Iterator<SubHyperplane<S>> it = collection.iterator();
        loop0: while (true) {
            hyperplane = null;
            do {
                if (hyperplane != null || !it.hasNext()) {
                    break loop0;
                } else {
                    hyperplane = it.next().getHyperplane();
                }
            } while (bSPTree.insertCut(hyperplane.copySelf()));
        }
        if (it.hasNext()) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            while (it.hasNext()) {
                SubHyperplane<S> next = it.next();
                SubHyperplane.SplitSubHyperplane<S> splitSubHyperplaneSplit = next.split(hyperplane);
                int i5 = AnonymousClass3.$SwitchMap$org$apache$commons$math3$geometry$partitioning$Side[splitSubHyperplaneSplit.getSide().ordinal()];
                if (i5 == 1) {
                    arrayList.add(next);
                } else if (i5 == 2) {
                    arrayList2.add(next);
                } else if (i5 == 3) {
                    arrayList.add(splitSubHyperplaneSplit.getPlus());
                    arrayList2.add(splitSubHyperplaneSplit.getMinus());
                }
            }
            insertCuts(bSPTree.getPlus(), arrayList);
            insertCuts(bSPTree.getMinus(), arrayList2);
        }
    }

    private SubHyperplane<S> recurseIntersection(BSPTree<S> bSPTree, SubHyperplane<S> subHyperplane) {
        if (bSPTree.getCut() == null) {
            if (((Boolean) bSPTree.getAttribute()).booleanValue()) {
                return subHyperplane.copySelf();
            }
            return null;
        }
        SubHyperplane.SplitSubHyperplane<S> splitSubHyperplaneSplit = subHyperplane.split(bSPTree.getCut().getHyperplane());
        if (splitSubHyperplaneSplit.getPlus() == null) {
            return splitSubHyperplaneSplit.getMinus() != null ? recurseIntersection(bSPTree.getMinus(), subHyperplane) : recurseIntersection(bSPTree.getPlus(), recurseIntersection(bSPTree.getMinus(), subHyperplane));
        }
        if (splitSubHyperplaneSplit.getMinus() == null) {
            return recurseIntersection(bSPTree.getPlus(), subHyperplane);
        }
        SubHyperplane<S> subHyperplaneRecurseIntersection = recurseIntersection(bSPTree.getPlus(), splitSubHyperplaneSplit.getPlus());
        SubHyperplane<S> subHyperplaneRecurseIntersection2 = recurseIntersection(bSPTree.getMinus(), splitSubHyperplaneSplit.getMinus());
        if (subHyperplaneRecurseIntersection == null) {
            return subHyperplaneRecurseIntersection2;
        }
        return subHyperplaneRecurseIntersection2 == null ? subHyperplaneRecurseIntersection : subHyperplaneRecurseIntersection.reunite(subHyperplaneRecurseIntersection2);
    }

    private BSPTree<S> recurseTransform(BSPTree<S> bSPTree, Transform<S, T> transform, Map<BSPTree<S>, BSPTree<S>> map) {
        BSPTree<S> bSPTree2;
        if (bSPTree.getCut() == null) {
            bSPTree2 = new BSPTree<>(bSPTree.getAttribute());
        } else {
            AbstractSubHyperplane<S, T> abstractSubHyperplaneApplyTransform = ((AbstractSubHyperplane) bSPTree.getCut()).applyTransform(transform);
            BoundaryAttribute boundaryAttribute = (BoundaryAttribute) bSPTree.getAttribute();
            if (boundaryAttribute != null) {
                boundaryAttribute = new BoundaryAttribute(boundaryAttribute.getPlusOutside() == null ? null : ((AbstractSubHyperplane) boundaryAttribute.getPlusOutside()).applyTransform(transform), boundaryAttribute.getPlusInside() != null ? ((AbstractSubHyperplane) boundaryAttribute.getPlusInside()).applyTransform(transform) : null, new NodesSet());
            }
            bSPTree2 = new BSPTree<>(abstractSubHyperplaneApplyTransform, recurseTransform(bSPTree.getPlus(), transform, map), recurseTransform(bSPTree.getMinus(), transform, map), boundaryAttribute);
        }
        map.put(bSPTree, bSPTree2);
        return bSPTree2;
    }

    public AbstractRegion<S, T> applyTransform(Transform<S, T> transform) {
        BoundaryAttribute boundaryAttribute;
        HashMap map = new HashMap();
        BSPTree<S> bSPTreeRecurseTransform = recurseTransform(getTree(false), transform, map);
        for (Map.Entry entry : map.entrySet()) {
            if (((BSPTree) entry.getKey()).getCut() != null && (boundaryAttribute = (BoundaryAttribute) ((BSPTree) entry.getKey()).getAttribute()) != null) {
                BoundaryAttribute boundaryAttribute2 = (BoundaryAttribute) ((BSPTree) entry.getValue()).getAttribute();
                Iterator<BSPTree<S>> it = boundaryAttribute.getSplitters().iterator();
                while (it.hasNext()) {
                    boundaryAttribute2.getSplitters().add((BSPTree) map.get(it.next()));
                }
            }
        }
        return buildNew((BSPTree) bSPTreeRecurseTransform);
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Region
    public abstract AbstractRegion<S, T> buildNew(BSPTree<S> bSPTree);

    public Region.Location checkPoint(Vector<S> vector) {
        return checkPoint((Point) vector);
    }

    public abstract void computeGeometricalProperties();

    @Override // org.apache.commons.math3.geometry.partitioning.Region
    public boolean contains(Region<S> region) {
        return new RegionFactory().difference(region, this).isEmpty();
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Region
    public Point<S> getBarycenter() {
        if (this.barycenter == null) {
            computeGeometricalProperties();
        }
        return this.barycenter;
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Region
    public double getBoundarySize() {
        BoundarySizeVisitor boundarySizeVisitor = new BoundarySizeVisitor();
        getTree(true).visit(boundarySizeVisitor);
        return boundarySizeVisitor.getSize();
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Region
    public double getSize() {
        if (this.barycenter == null) {
            computeGeometricalProperties();
        }
        return this.size;
    }

    public double getTolerance() {
        return this.tolerance;
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Region
    public BSPTree<S> getTree(boolean z6) {
        if (z6 && this.tree.getCut() != null && this.tree.getAttribute() == null) {
            this.tree.visit(new BoundaryBuilder());
        }
        return this.tree;
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Region
    public SubHyperplane<S> intersection(SubHyperplane<S> subHyperplane) {
        return recurseIntersection(this.tree, subHyperplane);
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Region
    public boolean isEmpty() {
        return isEmpty(this.tree);
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Region
    public boolean isFull() {
        return isFull(this.tree);
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Region
    public BoundaryProjection<S> projectToBoundary(Point<S> point) {
        BoundaryProjector boundaryProjector = new BoundaryProjector(point);
        getTree(true).visit(boundaryProjector);
        return boundaryProjector.getProjection();
    }

    public void setBarycenter(Vector<S> vector) {
        setBarycenter((Point) vector);
    }

    public void setSize(double d) {
        this.size = d;
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Region
    @Deprecated
    public Side side(Hyperplane<S> hyperplane) {
        InsideFinder insideFinder = new InsideFinder(this);
        insideFinder.recurseSides(this.tree, hyperplane.wholeHyperplane());
        if (insideFinder.plusFound()) {
            return insideFinder.minusFound() ? Side.BOTH : Side.PLUS;
        }
        return insideFinder.minusFound() ? Side.MINUS : Side.HYPER;
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Region
    public Region.Location checkPoint(Point<S> point) {
        return checkPoint(this.tree, point);
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Region
    public AbstractRegion<S, T> copySelf() {
        return buildNew((BSPTree) this.tree.copySelf());
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Region
    public boolean isEmpty(BSPTree<S> bSPTree) {
        if (bSPTree.getCut() == null) {
            return !((Boolean) bSPTree.getAttribute()).booleanValue();
        }
        return isEmpty(bSPTree.getMinus()) && isEmpty(bSPTree.getPlus());
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Region
    public boolean isFull(BSPTree<S> bSPTree) {
        if (bSPTree.getCut() == null) {
            return ((Boolean) bSPTree.getAttribute()).booleanValue();
        }
        return isFull(bSPTree.getMinus()) && isFull(bSPTree.getPlus());
    }

    public void setBarycenter(Point<S> point) {
        this.barycenter = point;
    }

    public Region.Location checkPoint(BSPTree<S> bSPTree, Vector<S> vector) {
        return checkPoint((BSPTree) bSPTree, (Point) vector);
    }

    public AbstractRegion(BSPTree<S> bSPTree, double d) {
        this.tree = bSPTree;
        this.tolerance = d;
    }

    public Region.Location checkPoint(BSPTree<S> bSPTree, Point<S> point) {
        BSPTree<S> cell = bSPTree.getCell(point, this.tolerance);
        if (cell.getCut() == null) {
            return ((Boolean) cell.getAttribute()).booleanValue() ? Region.Location.INSIDE : Region.Location.OUTSIDE;
        }
        Region.Location locationCheckPoint = checkPoint(cell.getMinus(), point);
        return locationCheckPoint == checkPoint(cell.getPlus(), point) ? locationCheckPoint : Region.Location.BOUNDARY;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public AbstractRegion(Collection<SubHyperplane<S>> collection, double d) {
        this.tolerance = d;
        if (collection.size() == 0) {
            this.tree = new BSPTree<>(Boolean.TRUE);
            return;
        }
        TreeSet treeSet = new TreeSet(new Comparator<SubHyperplane<S>>() { // from class: org.apache.commons.math3.geometry.partitioning.AbstractRegion.1
            @Override // java.util.Comparator
            public int compare(SubHyperplane<S> subHyperplane, SubHyperplane<S> subHyperplane2) {
                if (subHyperplane2.getSize() < subHyperplane.getSize()) {
                    return -1;
                }
                return subHyperplane == subHyperplane2 ? 0 : 1;
            }
        });
        treeSet.addAll(collection);
        BSPTree<S> bSPTree = new BSPTree<>();
        this.tree = bSPTree;
        insertCuts(bSPTree, treeSet);
        this.tree.visit(new BSPTreeVisitor<S>() { // from class: org.apache.commons.math3.geometry.partitioning.AbstractRegion.2
            @Override // org.apache.commons.math3.geometry.partitioning.BSPTreeVisitor
            public void visitLeafNode(BSPTree<S> bSPTree2) {
                if (bSPTree2.getParent() == null || bSPTree2 == bSPTree2.getParent().getMinus()) {
                    bSPTree2.setAttribute(Boolean.TRUE);
                } else {
                    bSPTree2.setAttribute(Boolean.FALSE);
                }
            }

            @Override // org.apache.commons.math3.geometry.partitioning.BSPTreeVisitor
            public BSPTreeVisitor.Order visitOrder(BSPTree<S> bSPTree2) {
                return BSPTreeVisitor.Order.PLUS_SUB_MINUS;
            }

            @Override // org.apache.commons.math3.geometry.partitioning.BSPTreeVisitor
            public void visitInternalNode(BSPTree<S> bSPTree2) {
            }
        });
    }

    public AbstractRegion(Hyperplane<S>[] hyperplaneArr, double d) {
        this.tolerance = d;
        if (hyperplaneArr != null && hyperplaneArr.length != 0) {
            BSPTree<S> tree = hyperplaneArr[0].wholeSpace().getTree(false);
            this.tree = tree;
            tree.setAttribute(Boolean.TRUE);
            for (Hyperplane<S> hyperplane : hyperplaneArr) {
                if (tree.insertCut(hyperplane)) {
                    tree.setAttribute(null);
                    tree.getPlus().setAttribute(Boolean.FALSE);
                    tree = tree.getMinus();
                    tree.setAttribute(Boolean.TRUE);
                }
            }
            return;
        }
        this.tree = new BSPTree<>(Boolean.FALSE);
    }
}
