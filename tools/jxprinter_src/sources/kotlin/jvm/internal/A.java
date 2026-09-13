package kotlin.jvm.internal;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class A extends AbstractC1102p implements InterfaceC1111z, V3.g {
    private final int arity;
    private final int flags;

    public A(int i5, Object obj) {
        this(i5, obj, null, null, null, 0);
    }

    @Override // kotlin.jvm.internal.AbstractC1102p
    public V3.b computeReflected() {
        U.f5690a.getClass();
        return this;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof A) {
            A a6 = (A) obj;
            return getName().equals(a6.getName()) && getSignature().equals(a6.getSignature()) && this.flags == a6.flags && this.arity == a6.arity && E.a(getBoundReceiver(), a6.getBoundReceiver()) && E.a(getOwner(), a6.getOwner());
        }
        if (obj instanceof V3.g) {
            return obj.equals(compute());
        }
        return false;
    }

    @Override // kotlin.jvm.internal.InterfaceC1111z
    public int getArity() {
        return this.arity;
    }

    public int hashCode() {
        return getSignature().hashCode() + ((getName().hashCode() + (getOwner() == null ? 0 : getOwner().hashCode() * 31)) * 31);
    }

    @Override // V3.g
    public boolean isExternal() {
        return getReflected().isExternal();
    }

    @Override // V3.g
    public boolean isInfix() {
        return getReflected().isInfix();
    }

    @Override // V3.g
    public boolean isInline() {
        return getReflected().isInline();
    }

    @Override // V3.g
    public boolean isOperator() {
        return getReflected().isOperator();
    }

    @Override // kotlin.jvm.internal.AbstractC1102p, V3.b
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }

    public String toString() {
        V3.b bVarCompute = compute();
        if (bVarCompute != this) {
            return bVarCompute.toString();
        }
        if ("<init>".equals(getName())) {
            return "constructor (Kotlin reflection is not available)";
        }
        return "function " + getName() + " (Kotlin reflection is not available)";
    }

    public A(int i5, Object obj, Class cls, String str, String str2, int i6) {
        super(obj, cls, str, str2, (i6 & 1) == 1);
        this.arity = i5;
        this.flags = i6 >> 1;
    }

    @Override // kotlin.jvm.internal.AbstractC1102p
    public V3.g getReflected() {
        return (V3.g) super.getReflected();
    }
}
