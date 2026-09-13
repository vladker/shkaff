package p060k4;

import A3.AbstractC0151t;
import A3.C0152u;
import A3.I;
import O3.a;
import S2.l;
import V3.c;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.jvm.internal.E;
import kotlin.jvm.internal.X;
import p072m4.C1241a;
import p072m4.r;
import p072m4.w;
import p072m4.x;
import p084o4.AbstractC1299b;
import p147z3.AbstractC1935o;
import p147z3.EnumC1936p;
import p147z3.InterfaceC1934n;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class e extends AbstractC1299b {
    private List<? extends Annotation> _annotations;
    private final c baseClass;
    private final InterfaceC1934n descriptor$delegate;

    public e(c baseClass) {
        E.f(baseClass, "baseClass");
        this.baseClass = baseClass;
        this._annotations = I.emptyList();
        this.descriptor$delegate = AbstractC1935o.lazy(EnumC1936p.f9133a, (a) new C0152u(this, 8));
    }

    public static Q a(e eVar, C1241a buildSerialDescriptor) {
        E.f(buildSerialDescriptor, "$this$buildSerialDescriptor");
        buildSerialDescriptor.element("type", p066l4.a.serializer(X.INSTANCE).getDescriptor(), I.emptyList(), false);
        buildSerialDescriptor.element("value", w.buildSerialDescriptor("kotlinx.serialization.Polymorphic<" + eVar.getBaseClass().getSimpleName() + '>', x.INSTANCE, new r[0], new l(16)), I.emptyList(), false);
        buildSerialDescriptor.setAnnotations(eVar._annotations);
        return Q.INSTANCE;
    }

    @Override // p084o4.AbstractC1299b
    public c getBaseClass() {
        return this.baseClass;
    }

    @Override // p084o4.AbstractC1299b, p060k4.b, p060k4.m, p060k4.a
    public r getDescriptor() {
        return (r) this.descriptor$delegate.getValue();
    }

    public String toString() {
        return "kotlinx.serialization.PolymorphicSerializer(baseClass: " + getBaseClass() + ')';
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public e(c baseClass, Annotation[] classAnnotations) {
        this(baseClass);
        E.f(baseClass, "baseClass");
        E.f(classAnnotations, "classAnnotations");
        this._annotations = AbstractC0151t.asList(classAnnotations);
    }
}
