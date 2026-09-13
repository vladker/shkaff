package kotlin.jvm.internal;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class a0 implements V3.q {
    public static final Z Companion = new Z();
    private volatile List<? extends V3.p> bounds;
    private final Object container;
    private final String name;
    private final V3.u variance;

    public a0(Object obj, String name, V3.u variance, boolean z6) {
        E.f(name, "name");
        E.f(variance, "variance");
        this.container = obj;
        this.name = name;
        this.variance = variance;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a0)) {
            return false;
        }
        a0 a0Var = (a0) obj;
        return E.a(this.container, a0Var.container) && E.a(getName(), a0Var.getName());
    }

    @Override // V3.q
    public String getName() {
        return this.name;
    }

    @Override // V3.q
    public List<V3.p> getUpperBounds() {
        List list = this.bounds;
        if (list != null) {
            return list;
        }
        List<V3.p> listListOf = A3.G.listOf(U.nullableTypeOf(Object.class));
        this.bounds = listListOf;
        return listListOf;
    }

    @Override // V3.q
    public V3.u getVariance() {
        return this.variance;
    }

    public final int hashCode() {
        Object obj = this.container;
        return getName().hashCode() + ((obj != null ? obj.hashCode() : 0) * 31);
    }

    public final void setUpperBounds(List<? extends V3.p> upperBounds) {
        E.f(upperBounds, "upperBounds");
        if (this.bounds == null) {
            this.bounds = upperBounds;
            return;
        }
        throw new IllegalStateException(("Upper bounds of type parameter '" + this + "' have already been initialized.").toString());
    }

    public String toString() {
        return Companion.toString(this);
    }
}
