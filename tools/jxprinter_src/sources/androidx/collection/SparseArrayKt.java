package androidx.collection;

import A3.e0;
import O3.p;
import java.util.Iterator;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class SparseArrayKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.collection.SparseArrayKt$valueIterator$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class C03181<T> implements Iterator<T>, P3.a {
        final /* synthetic */ SparseArrayCompat<T> $this_valueIterator;
        private int index;

        public C03181(SparseArrayCompat<T> sparseArrayCompat) {
            this.$this_valueIterator = sparseArrayCompat;
        }

        public final int getIndex() {
            return this.index;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.index < this.$this_valueIterator.size();
        }

        @Override // java.util.Iterator
        public T next() {
            SparseArrayCompat<T> sparseArrayCompat = this.$this_valueIterator;
            int i5 = this.index;
            this.index = i5 + 1;
            return sparseArrayCompat.valueAt(i5);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final void setIndex(int i5) {
            this.index = i5;
        }
    }

    public static final <T> boolean contains(SparseArrayCompat<T> sparseArrayCompat, int i5) {
        E.f(sparseArrayCompat, "<this>");
        return sparseArrayCompat.containsKey(i5);
    }

    public static final <T> void forEach(SparseArrayCompat<T> sparseArrayCompat, p action) {
        E.f(sparseArrayCompat, "<this>");
        E.f(action, "action");
        int size = sparseArrayCompat.size();
        for (int i5 = 0; i5 < size; i5++) {
            action.invoke(Integer.valueOf(sparseArrayCompat.keyAt(i5)), sparseArrayCompat.valueAt(i5));
        }
    }

    public static final <T> T getOrDefault(SparseArrayCompat<T> sparseArrayCompat, int i5, T t6) {
        E.f(sparseArrayCompat, "<this>");
        return sparseArrayCompat.get(i5, t6);
    }

    public static final <T> T getOrElse(SparseArrayCompat<T> sparseArrayCompat, int i5, O3.a defaultValue) {
        E.f(sparseArrayCompat, "<this>");
        E.f(defaultValue, "defaultValue");
        T t6 = sparseArrayCompat.get(i5);
        return t6 == null ? (T) defaultValue.invoke() : t6;
    }

    public static final <T> int getSize(SparseArrayCompat<T> sparseArrayCompat) {
        E.f(sparseArrayCompat, "<this>");
        return sparseArrayCompat.size();
    }

    public static final <T> boolean isNotEmpty(SparseArrayCompat<T> sparseArrayCompat) {
        E.f(sparseArrayCompat, "<this>");
        return !sparseArrayCompat.isEmpty();
    }

    public static final <T> e0 keyIterator(final SparseArrayCompat<T> sparseArrayCompat) {
        E.f(sparseArrayCompat, "<this>");
        return new e0() { // from class: androidx.collection.SparseArrayKt.keyIterator.1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < sparseArrayCompat.size();
            }

            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // A3.e0
            public int nextInt() {
                SparseArrayCompat<T> sparseArrayCompat2 = sparseArrayCompat;
                int i5 = this.index;
                this.index = i5 + 1;
                return sparseArrayCompat2.keyAt(i5);
            }

            public final void setIndex(int i5) {
                this.index = i5;
            }
        };
    }

    public static final <T> SparseArrayCompat<T> plus(SparseArrayCompat<T> sparseArrayCompat, SparseArrayCompat<T> other) {
        E.f(sparseArrayCompat, "<this>");
        E.f(other, "other");
        SparseArrayCompat<T> sparseArrayCompat2 = new SparseArrayCompat<>(other.size() + sparseArrayCompat.size());
        sparseArrayCompat2.putAll(sparseArrayCompat);
        sparseArrayCompat2.putAll(other);
        return sparseArrayCompat2;
    }

    public static final /* synthetic */ boolean remove(SparseArrayCompat sparseArrayCompat, int i5, Object obj) {
        E.f(sparseArrayCompat, "<this>");
        return sparseArrayCompat.remove(i5, obj);
    }

    public static final <T> void set(SparseArrayCompat<T> sparseArrayCompat, int i5, T t6) {
        E.f(sparseArrayCompat, "<this>");
        sparseArrayCompat.put(i5, t6);
    }

    public static final <T> Iterator<T> valueIterator(SparseArrayCompat<T> sparseArrayCompat) {
        E.f(sparseArrayCompat, "<this>");
        return new C03181(sparseArrayCompat);
    }
}
