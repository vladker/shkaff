package kotlin.jvm.internal;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class O extends AbstractC1102p implements V3.o {
    private final boolean syntheticJavaProperty;

    public O(Object obj) {
        super(obj);
        this.syntheticJavaProperty = false;
    }

    @Override // kotlin.jvm.internal.AbstractC1102p
    public V3.b compute() {
        return this.syntheticJavaProperty ? this : super.compute();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof O) {
            O o6 = (O) obj;
            return getOwner().equals(o6.getOwner()) && getName().equals(o6.getName()) && getSignature().equals(o6.getSignature()) && E.a(getBoundReceiver(), o6.getBoundReceiver());
        }
        if (obj instanceof V3.o) {
            return obj.equals(compute());
        }
        return false;
    }

    public abstract /* synthetic */ V3.h getGetter();

    public int hashCode() {
        return getSignature().hashCode() + ((getName().hashCode() + (getOwner().hashCode() * 31)) * 31);
    }

    @Override // V3.o
    public boolean isConst() {
        return getReflected().isConst();
    }

    @Override // V3.o
    public boolean isLateinit() {
        return getReflected().isLateinit();
    }

    public String toString() {
        V3.b bVarCompute = compute();
        if (bVarCompute != this) {
            return bVarCompute.toString();
        }
        return "property " + getName() + " (Kotlin reflection is not available)";
    }

    @Override // kotlin.jvm.internal.AbstractC1102p
    public V3.o getReflected() {
        if (this.syntheticJavaProperty) {
            throw new UnsupportedOperationException("Kotlin reflection is not yet supported for synthetic Java properties. Please follow/upvote https://youtrack.jetbrains.com/issue/KT-55980");
        }
        return (V3.o) super.getReflected();
    }

    public O(Object obj, Class cls, String str, String str2, int i5) {
        super(obj, cls, str, str2, (i5 & 1) == 1);
        this.syntheticJavaProperty = (i5 & 2) == 2;
    }
}
