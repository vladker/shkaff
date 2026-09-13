package org.apache.commons.collections4.list;

import A3.AbstractC0157z;
import com.alibaba.android.arouter.utils.Consts;
import java.util.AbstractList;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.apache.commons.collections4.OrderedIterator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class TreeList<E> extends AbstractList<E> {
    private AVLNode<E> root;
    private int size;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class TreeListIterator<E> implements ListIterator<E>, OrderedIterator<E> {
        private AVLNode<E> current;
        private int currentIndex;
        private int expectedModCount;
        private AVLNode<E> next;
        private int nextIndex;
        private final TreeList<E> parent;

        public TreeListIterator(TreeList<E> treeList, int i5) {
            this.parent = treeList;
            this.expectedModCount = ((AbstractList) treeList).modCount;
            this.next = ((TreeList) treeList).root == null ? null : ((TreeList) treeList).root.get(i5);
            this.nextIndex = i5;
            this.currentIndex = -1;
        }

        @Override // java.util.ListIterator
        public void add(E e) {
            checkModCount();
            this.parent.add(this.nextIndex, e);
            this.current = null;
            this.currentIndex = -1;
            this.nextIndex++;
            this.expectedModCount++;
        }

        public void checkModCount() {
            if (((AbstractList) this.parent).modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.nextIndex < this.parent.size();
        }

        @Override // java.util.ListIterator, org.apache.commons.collections4.OrderedIterator
        public boolean hasPrevious() {
            return this.nextIndex > 0;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public E next() {
            checkModCount();
            if (!hasNext()) {
                throw new NoSuchElementException(AbstractC0157z.l(Consts.DOT, this.nextIndex, new StringBuilder("No element at index ")));
            }
            if (this.next == null) {
                this.next = ((TreeList) this.parent).root.get(this.nextIndex);
            }
            E value = this.next.getValue();
            AVLNode<E> aVLNode = this.next;
            this.current = aVLNode;
            int i5 = this.nextIndex;
            this.nextIndex = i5 + 1;
            this.currentIndex = i5;
            this.next = aVLNode.next();
            return value;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.nextIndex;
        }

        @Override // java.util.ListIterator, org.apache.commons.collections4.OrderedIterator
        public E previous() {
            checkModCount();
            if (!hasPrevious()) {
                throw new NoSuchElementException("Already at start of list.");
            }
            AVLNode<E> aVLNode = this.next;
            if (aVLNode == null) {
                this.next = ((TreeList) this.parent).root.get(this.nextIndex - 1);
            } else {
                this.next = aVLNode.previous();
            }
            E value = this.next.getValue();
            this.current = this.next;
            int i5 = this.nextIndex - 1;
            this.nextIndex = i5;
            this.currentIndex = i5;
            return value;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return nextIndex() - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            checkModCount();
            int i5 = this.currentIndex;
            if (i5 == -1) {
                throw new IllegalStateException();
            }
            this.parent.remove(i5);
            int i6 = this.nextIndex;
            if (i6 != this.currentIndex) {
                this.nextIndex = i6 - 1;
            }
            this.next = null;
            this.current = null;
            this.currentIndex = -1;
            this.expectedModCount++;
        }

        @Override // java.util.ListIterator
        public void set(E e) {
            checkModCount();
            AVLNode<E> aVLNode = this.current;
            if (aVLNode == null) {
                throw new IllegalStateException();
            }
            aVLNode.setValue(e);
        }
    }

    public TreeList() {
    }

    private void checkInterval(int i5, int i6, int i7) {
        if (i5 < i6 || i5 > i7) {
            StringBuilder sbT = AbstractC0157z.t(i5, "Invalid index:", ", size=");
            sbT.append(size());
            throw new IndexOutOfBoundsException(sbT.toString());
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i5, E e) {
        ((AbstractList) this).modCount++;
        checkInterval(i5, 0, size());
        AVLNode<E> aVLNode = this.root;
        if (aVLNode == null) {
            this.root = new AVLNode<>(i5, e, null, null);
        } else {
            this.root = aVLNode.insert(i5, e);
        }
        this.size++;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends E> collection) {
        if (collection.isEmpty()) {
            return false;
        }
        ((AbstractList) this).modCount = collection.size() + ((AbstractList) this).modCount;
        AVLNode<E> aVLNode = new AVLNode<>(collection);
        AVLNode<E> aVLNode2 = this.root;
        if (aVLNode2 != null) {
            aVLNode = aVLNode2.addAll(aVLNode, this.size);
        }
        this.root = aVLNode;
        this.size = collection.size() + this.size;
        return true;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        ((AbstractList) this).modCount++;
        this.root = null;
        this.size = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i5) {
        checkInterval(i5, 0, size() - 1);
        return this.root.get(i5).getValue();
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        AVLNode<E> aVLNode = this.root;
        if (aVLNode == null) {
            return -1;
        }
        return aVLNode.indexOf(obj, ((AVLNode) aVLNode).relativePosition);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<E> iterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<E> listIterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractList, java.util.List
    public E remove(int i5) {
        ((AbstractList) this).modCount++;
        checkInterval(i5, 0, size() - 1);
        E e = get(i5);
        this.root = this.root.remove(i5);
        this.size--;
        return e;
    }

    @Override // java.util.AbstractList, java.util.List
    public E set(int i5, E e) {
        checkInterval(i5, 0, size() - 1);
        AVLNode<E> aVLNode = this.root.get(i5);
        E e6 = (E) ((AVLNode) aVLNode).value;
        aVLNode.setValue(e);
        return e6;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.size;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        Object[] objArr = new Object[size()];
        AVLNode<E> aVLNode = this.root;
        if (aVLNode != null) {
            aVLNode.toArray(objArr, ((AVLNode) aVLNode).relativePosition);
        }
        return objArr;
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class AVLNode<E> {
        private int height;
        private AVLNode<E> left;
        private boolean leftIsPrevious;
        private int relativePosition;
        private AVLNode<E> right;
        private boolean rightIsNext;
        private E value;

        /* JADX INFO: Access modifiers changed from: private */
        public AVLNode<E> addAll(AVLNode<E> aVLNode, int i5) {
            AVLNode<E> aVLNodeMax = max();
            AVLNode<E> aVLNodeMin = aVLNode.min();
            if (aVLNode.height > this.height) {
                AVLNode<E> aVLNodeRemoveMax = removeMax();
                ArrayDeque arrayDeque = new ArrayDeque();
                int i6 = 0;
                i6 = aVLNode.relativePosition + i5;
                AVLNode<E> aVLNode2 = aVLNode;
                while (aVLNode2 != null && aVLNode2.height > getHeight(aVLNodeRemoveMax)) {
                    arrayDeque.push(aVLNode2);
                    aVLNode2 = aVLNode2.left;
                    if (aVLNode2 != null) {
                        i6 = aVLNode2.relativePosition + i6;
                    }
                }
                aVLNodeMax.setLeft(aVLNodeRemoveMax, null);
                aVLNodeMax.setRight(aVLNode2, aVLNodeMin);
                if (aVLNodeRemoveMax != null) {
                    aVLNodeRemoveMax.max().setRight(null, aVLNodeMax);
                    aVLNodeRemoveMax.relativePosition -= i5 - 1;
                }
                if (aVLNode2 != null) {
                    aVLNode2.min().setLeft(null, aVLNodeMax);
                    aVLNode2.relativePosition = (i6 - i5) + 1;
                }
                aVLNodeMax.relativePosition = (i5 - 1) - i6;
                aVLNode.relativePosition += i5;
                while (!arrayDeque.isEmpty()) {
                    AVLNode aVLNode3 = (AVLNode) arrayDeque.pop();
                    aVLNode3.setLeft(aVLNodeMax, null);
                    aVLNodeMax = aVLNode3.balance();
                }
                return aVLNodeMax;
            }
            AVLNode<E> aVLNodeRemoveMin = aVLNode.removeMin();
            ArrayDeque arrayDeque2 = new ArrayDeque();
            int i7 = this.relativePosition;
            int i8 = 0;
            AVLNode<E> aVLNode4 = this;
            while (aVLNode4 != null && aVLNode4.height > getHeight(aVLNodeRemoveMin)) {
                arrayDeque2.push(aVLNode4);
                aVLNode4 = aVLNode4.right;
                if (aVLNode4 != null) {
                    int i9 = i7;
                    i7 = aVLNode4.relativePosition + i7;
                    i8 = i9;
                } else {
                    i8 = i7;
                }
            }
            aVLNodeMin.setRight(aVLNodeRemoveMin, null);
            aVLNodeMin.setLeft(aVLNode4, aVLNodeMax);
            if (aVLNodeRemoveMin != null) {
                aVLNodeRemoveMin.min().setLeft(null, aVLNodeMin);
                aVLNodeRemoveMin.relativePosition++;
            }
            if (aVLNode4 != null) {
                aVLNode4.max().setRight(null, aVLNodeMin);
                aVLNode4.relativePosition = i7 - i5;
            }
            aVLNodeMin.relativePosition = i5 - i8;
            while (!arrayDeque2.isEmpty()) {
                AVLNode aVLNode5 = (AVLNode) arrayDeque2.pop();
                aVLNode5.setRight(aVLNodeMin, null);
                aVLNodeMin = aVLNode5.balance();
            }
            return aVLNodeMin;
        }

        private AVLNode<E> balance() {
            int iHeightRightMinusLeft = heightRightMinusLeft();
            if (iHeightRightMinusLeft == -2) {
                if (this.left.heightRightMinusLeft() > 0) {
                    setLeft(this.left.rotateLeft(), null);
                }
                return rotateRight();
            }
            if (iHeightRightMinusLeft == -1 || iHeightRightMinusLeft == 0 || iHeightRightMinusLeft == 1) {
                return this;
            }
            if (iHeightRightMinusLeft != 2) {
                throw new RuntimeException("tree inconsistent!");
            }
            if (this.right.heightRightMinusLeft() < 0) {
                setRight(this.right.rotateRight(), null);
            }
            return rotateLeft();
        }

        private int getHeight(AVLNode<E> aVLNode) {
            if (aVLNode == null) {
                return -1;
            }
            return aVLNode.height;
        }

        private AVLNode<E> getLeftSubTree() {
            if (this.leftIsPrevious) {
                return null;
            }
            return this.left;
        }

        private int getOffset(AVLNode<E> aVLNode) {
            if (aVLNode == null) {
                return 0;
            }
            return aVLNode.relativePosition;
        }

        private AVLNode<E> getRightSubTree() {
            if (this.rightIsNext) {
                return null;
            }
            return this.right;
        }

        private int heightRightMinusLeft() {
            return getHeight(getRightSubTree()) - getHeight(getLeftSubTree());
        }

        private AVLNode<E> insertOnLeft(int i5, E e) {
            if (getLeftSubTree() == null) {
                setLeft(new AVLNode<>(-1, e, this, this.left), null);
            } else {
                setLeft(this.left.insert(i5, e), null);
            }
            int i6 = this.relativePosition;
            if (i6 >= 0) {
                this.relativePosition = i6 + 1;
            }
            AVLNode<E> aVLNodeBalance = balance();
            recalcHeight();
            return aVLNodeBalance;
        }

        private AVLNode<E> insertOnRight(int i5, E e) {
            if (getRightSubTree() == null) {
                setRight(new AVLNode<>(1, e, this.right, this), null);
            } else {
                setRight(this.right.insert(i5, e), null);
            }
            int i6 = this.relativePosition;
            if (i6 < 0) {
                this.relativePosition = i6 - 1;
            }
            AVLNode<E> aVLNodeBalance = balance();
            recalcHeight();
            return aVLNodeBalance;
        }

        private AVLNode<E> max() {
            return getRightSubTree() == null ? this : this.right.max();
        }

        private AVLNode<E> min() {
            return getLeftSubTree() == null ? this : this.left.min();
        }

        private void recalcHeight() {
            this.height = Math.max(getLeftSubTree() == null ? -1 : getLeftSubTree().height, getRightSubTree() != null ? getRightSubTree().height : -1) + 1;
        }

        private AVLNode<E> removeMax() {
            if (getRightSubTree() == null) {
                return removeSelf();
            }
            setRight(this.right.removeMax(), this.right.right);
            int i5 = this.relativePosition;
            if (i5 < 0) {
                this.relativePosition = i5 + 1;
            }
            recalcHeight();
            return balance();
        }

        private AVLNode<E> removeMin() {
            if (getLeftSubTree() == null) {
                return removeSelf();
            }
            setLeft(this.left.removeMin(), this.left.left);
            int i5 = this.relativePosition;
            if (i5 > 0) {
                this.relativePosition = i5 - 1;
            }
            recalcHeight();
            return balance();
        }

        private AVLNode<E> removeSelf() {
            if (getRightSubTree() == null && getLeftSubTree() == null) {
                return null;
            }
            if (getRightSubTree() == null) {
                int i5 = this.relativePosition;
                if (i5 > 0) {
                    this.left.relativePosition += i5;
                }
                this.left.max().setRight(null, this.right);
                return this.left;
            }
            if (getLeftSubTree() == null) {
                AVLNode<E> aVLNode = this.right;
                int i6 = aVLNode.relativePosition;
                int i7 = this.relativePosition;
                aVLNode.relativePosition = (i7 - (i7 < 0 ? 0 : 1)) + i6;
                aVLNode.min().setLeft(null, this.left);
                return this.right;
            }
            if (heightRightMinusLeft() > 0) {
                AVLNode<E> aVLNodeMin = this.right.min();
                this.value = aVLNodeMin.value;
                if (this.leftIsPrevious) {
                    this.left = aVLNodeMin.left;
                }
                this.right = this.right.removeMin();
                int i8 = this.relativePosition;
                if (i8 < 0) {
                    this.relativePosition = i8 + 1;
                }
            } else {
                AVLNode<E> aVLNodeMax = this.left.max();
                this.value = aVLNodeMax.value;
                if (this.rightIsNext) {
                    this.right = aVLNodeMax.right;
                }
                AVLNode<E> aVLNode2 = this.left;
                AVLNode<E> aVLNode3 = aVLNode2.left;
                AVLNode<E> aVLNodeRemoveMax = aVLNode2.removeMax();
                this.left = aVLNodeRemoveMax;
                if (aVLNodeRemoveMax == null) {
                    this.left = aVLNode3;
                    this.leftIsPrevious = true;
                }
                int i9 = this.relativePosition;
                if (i9 > 0) {
                    this.relativePosition = i9 - 1;
                }
            }
            recalcHeight();
            return this;
        }

        private AVLNode<E> rotateLeft() {
            AVLNode<E> aVLNode = this.right;
            AVLNode<E> leftSubTree = getRightSubTree().getLeftSubTree();
            int offset = this.relativePosition + getOffset(aVLNode);
            int i5 = -aVLNode.relativePosition;
            int offset2 = getOffset(aVLNode) + getOffset(leftSubTree);
            setRight(leftSubTree, aVLNode);
            aVLNode.setLeft(this, null);
            setOffset(aVLNode, offset);
            setOffset(this, i5);
            setOffset(leftSubTree, offset2);
            return aVLNode;
        }

        private AVLNode<E> rotateRight() {
            AVLNode<E> aVLNode = this.left;
            AVLNode<E> rightSubTree = getLeftSubTree().getRightSubTree();
            int offset = this.relativePosition + getOffset(aVLNode);
            int i5 = -aVLNode.relativePosition;
            int offset2 = getOffset(aVLNode) + getOffset(rightSubTree);
            setLeft(rightSubTree, aVLNode);
            aVLNode.setRight(this, null);
            setOffset(aVLNode, offset);
            setOffset(this, i5);
            setOffset(rightSubTree, offset2);
            return aVLNode;
        }

        private void setLeft(AVLNode<E> aVLNode, AVLNode<E> aVLNode2) {
            boolean z6 = aVLNode == null;
            this.leftIsPrevious = z6;
            if (z6) {
                aVLNode = aVLNode2;
            }
            this.left = aVLNode;
            recalcHeight();
        }

        private int setOffset(AVLNode<E> aVLNode, int i5) {
            if (aVLNode == null) {
                return 0;
            }
            int offset = getOffset(aVLNode);
            aVLNode.relativePosition = i5;
            return offset;
        }

        private void setRight(AVLNode<E> aVLNode, AVLNode<E> aVLNode2) {
            boolean z6 = aVLNode == null;
            this.rightIsNext = z6;
            if (z6) {
                aVLNode = aVLNode2;
            }
            this.right = aVLNode;
            recalcHeight();
        }

        public AVLNode<E> get(int i5) {
            int i6 = i5 - this.relativePosition;
            if (i6 == 0) {
                return this;
            }
            AVLNode<E> leftSubTree = i6 < 0 ? getLeftSubTree() : getRightSubTree();
            if (leftSubTree == null) {
                return null;
            }
            return leftSubTree.get(i6);
        }

        public E getValue() {
            return this.value;
        }

        public int indexOf(Object obj, int i5) {
            if (getLeftSubTree() != null) {
                AVLNode<E> aVLNode = this.left;
                int iIndexOf = aVLNode.indexOf(obj, aVLNode.relativePosition + i5);
                if (iIndexOf != -1) {
                    return iIndexOf;
                }
            }
            E e = this.value;
            if (e != null ? e.equals(obj) : e == obj) {
                return i5;
            }
            if (getRightSubTree() == null) {
                return -1;
            }
            AVLNode<E> aVLNode2 = this.right;
            return aVLNode2.indexOf(obj, i5 + aVLNode2.relativePosition);
        }

        public AVLNode<E> insert(int i5, E e) {
            int i6 = i5 - this.relativePosition;
            return i6 <= 0 ? insertOnLeft(i6, e) : insertOnRight(i6, e);
        }

        public AVLNode<E> next() {
            AVLNode<E> aVLNode;
            return (this.rightIsNext || (aVLNode = this.right) == null) ? this.right : aVLNode.min();
        }

        public AVLNode<E> previous() {
            AVLNode<E> aVLNode;
            return (this.leftIsPrevious || (aVLNode = this.left) == null) ? this.left : aVLNode.max();
        }

        public AVLNode<E> remove(int i5) {
            int i6 = i5 - this.relativePosition;
            if (i6 == 0) {
                return removeSelf();
            }
            if (i6 > 0) {
                setRight(this.right.remove(i6), this.right.right);
                int i7 = this.relativePosition;
                if (i7 < 0) {
                    this.relativePosition = i7 + 1;
                }
            } else {
                setLeft(this.left.remove(i6), this.left.left);
                int i8 = this.relativePosition;
                if (i8 > 0) {
                    this.relativePosition = i8 - 1;
                }
            }
            recalcHeight();
            return balance();
        }

        public void setValue(E e) {
            this.value = e;
        }

        public void toArray(Object[] objArr, int i5) {
            objArr[i5] = this.value;
            if (getLeftSubTree() != null) {
                AVLNode<E> aVLNode = this.left;
                aVLNode.toArray(objArr, aVLNode.relativePosition + i5);
            }
            if (getRightSubTree() != null) {
                AVLNode<E> aVLNode2 = this.right;
                aVLNode2.toArray(objArr, i5 + aVLNode2.relativePosition);
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("AVLNode(");
            sb.append(this.relativePosition);
            sb.append(',');
            sb.append(this.left != null);
            sb.append(',');
            sb.append(this.value);
            sb.append(',');
            sb.append(getRightSubTree() != null);
            sb.append(", faedelung ");
            sb.append(this.rightIsNext);
            sb.append(" )");
            return sb.toString();
        }

        private AVLNode(int i5, E e, AVLNode<E> aVLNode, AVLNode<E> aVLNode2) {
            this.relativePosition = i5;
            this.value = e;
            this.rightIsNext = true;
            this.leftIsPrevious = true;
            this.right = aVLNode;
            this.left = aVLNode2;
        }

        private AVLNode(Collection<? extends E> collection) {
            this(collection.iterator(), 0, collection.size() - 1, 0, null, null);
        }

        private AVLNode(Iterator<? extends E> it, int i5, int i6, int i7, AVLNode<E> aVLNode, AVLNode<E> aVLNode2) {
            AVLNode<E> aVLNode3;
            Iterator<? extends E> it2;
            int iB = AbstractC0157z.b(i6, i5, 2, i5);
            if (i5 < iB) {
                it2 = it;
                aVLNode3 = this;
                aVLNode3.left = new AVLNode<>(it2, i5, iB - 1, iB, aVLNode, this);
            } else {
                aVLNode3 = this;
                it2 = it;
                aVLNode3.leftIsPrevious = true;
                aVLNode3.left = aVLNode;
            }
            aVLNode3.value = it2.next();
            aVLNode3.relativePosition = iB - i7;
            if (iB < i6) {
                aVLNode3.right = new AVLNode<>(it2, iB + 1, i6, iB, aVLNode3, aVLNode2);
            } else {
                aVLNode3.rightIsNext = true;
                aVLNode3.right = aVLNode2;
            }
            recalcHeight();
        }
    }

    public TreeList(Collection<? extends E> collection) {
        if (collection.isEmpty()) {
            return;
        }
        this.root = new AVLNode<>(collection);
        this.size = collection.size();
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<E> listIterator(int i5) {
        checkInterval(i5, 0, size());
        return new TreeListIterator(this, i5);
    }
}
