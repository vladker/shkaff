package p084o4;

import A3.AbstractC0151t;
import A3.AbstractC0157z;
import A3.I;
import O3.a;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.jvm.internal.E;
import p060k4.b;
import p060k4.g;
import p060k4.l;
import p072m4.C1241a;
import p072m4.r;
import p078n4.f;
import p078n4.j;
import p147z3.AbstractC1935o;
import p147z3.EnumC1936p;
import p147z3.InterfaceC1934n;
import p147z3.Q;

/* JADX INFO: renamed from: o4.y0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1345y0 implements b {
    private List<? extends Annotation> _annotations;
    private final InterfaceC1934n descriptor$delegate;
    private final Object objectInstance;

    public C1345y0(String serialName, Object objectInstance) {
        E.f(serialName, "serialName");
        E.f(objectInstance, "objectInstance");
        this.objectInstance = objectInstance;
        this._annotations = I.emptyList();
        this.descriptor$delegate = AbstractC1935o.lazy(EnumC1936p.f9133a, (a) new g(serialName, this, 4));
    }

    public static Q a(C1345y0 c1345y0, C1241a buildSerialDescriptor) {
        E.f(buildSerialDescriptor, "$this$buildSerialDescriptor");
        buildSerialDescriptor.setAnnotations(c1345y0._annotations);
        return Q.INSTANCE;
    }

    @Override // p060k4.b, p060k4.a
    public Object deserialize(j decoder) {
        int iDecodeElementIndex;
        E.f(decoder, "decoder");
        r descriptor = getDescriptor();
        f fVarBeginStructure = decoder.beginStructure(descriptor);
        if (!fVarBeginStructure.decodeSequentially() && (iDecodeElementIndex = fVarBeginStructure.decodeElementIndex(getDescriptor())) != -1) {
            throw new l(AbstractC0157z.k(iDecodeElementIndex, "Unexpected index "));
        }
        fVarBeginStructure.endStructure(descriptor);
        return this.objectInstance;
    }

    @Override // p060k4.b, p060k4.m, p060k4.a
    public r getDescriptor() {
        return (r) this.descriptor$delegate.getValue();
    }

    @Override // p060k4.b, p060k4.m
    public void serialize(p078n4.l encoder, Object value) {
        E.f(encoder, "encoder");
        E.f(value, "value");
        encoder.beginStructure(getDescriptor()).endStructure(getDescriptor());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C1345y0(String serialName, Object objectInstance, Annotation[] classAnnotations) {
        this(serialName, objectInstance);
        E.f(serialName, "serialName");
        E.f(objectInstance, "objectInstance");
        E.f(classAnnotations, "classAnnotations");
        this._annotations = AbstractC0151t.asList(classAnnotations);
    }
}
