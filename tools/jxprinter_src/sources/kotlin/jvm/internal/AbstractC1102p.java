package kotlin.jvm.internal;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: kotlin.jvm.internal.p, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1102p implements V3.b, Serializable {
    public static final Object NO_RECEIVER = C1101o.f5704a;
    private final boolean isTopLevel;
    private final String name;
    private final Class owner;
    protected final Object receiver;
    private transient V3.b reflected;
    private final String signature;

    public AbstractC1102p(Object obj) {
        this(obj, null, null, null, false);
    }

    @Override // V3.b
    public Object call(Object... objArr) {
        return getReflected().call(objArr);
    }

    @Override // V3.b
    public Object callBy(Map map) {
        return getReflected().callBy(map);
    }

    public V3.b compute() {
        V3.b bVar = this.reflected;
        if (bVar != null) {
            return bVar;
        }
        V3.b bVarComputeReflected = computeReflected();
        this.reflected = bVarComputeReflected;
        return bVarComputeReflected;
    }

    public abstract V3.b computeReflected();

    @Override // V3.b, V3.a
    public List<Annotation> getAnnotations() {
        return getReflected().getAnnotations();
    }

    public Object getBoundReceiver() {
        return this.receiver;
    }

    @Override // V3.b
    public String getName() {
        return this.name;
    }

    public V3.f getOwner() {
        Class cls = this.owner;
        if (cls == null) {
            return null;
        }
        return this.isTopLevel ? U.getOrCreateKotlinPackage(cls) : U.a(cls);
    }

    @Override // V3.b
    public List<Object> getParameters() {
        return getReflected().getParameters();
    }

    public V3.b getReflected() {
        V3.b bVarCompute = compute();
        if (bVarCompute != this) {
            return bVarCompute;
        }
        throw new N3.b();
    }

    @Override // V3.b
    public V3.p getReturnType() {
        return getReflected().getReturnType();
    }

    public String getSignature() {
        return this.signature;
    }

    @Override // V3.b
    public List<V3.q> getTypeParameters() {
        return getReflected().getTypeParameters();
    }

    @Override // V3.b
    public V3.v getVisibility() {
        return getReflected().getVisibility();
    }

    @Override // V3.b
    public boolean isAbstract() {
        return getReflected().isAbstract();
    }

    @Override // V3.b
    public boolean isFinal() {
        return getReflected().isFinal();
    }

    @Override // V3.b
    public boolean isOpen() {
        return getReflected().isOpen();
    }

    @Override // V3.b
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }

    public AbstractC1102p(Object obj, Class cls, String str, String str2, boolean z6) {
        this.receiver = obj;
        this.owner = cls;
        this.name = str;
        this.signature = str2;
        this.isTopLevel = z6;
    }
}
