package p072m4;

import A3.C;
import A3.C0130a;
import A3.C0133b0;
import A3.C0152u;
import A3.J;
import A3.T;
import A3.k0;
import U3.B;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.E;
import p084o4.D0;
import p084o4.H0;
import p084o4.InterfaceC1323n;
import p147z3.A;
import p147z3.AbstractC1935o;
import p147z3.InterfaceC1934n;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class s implements r, InterfaceC1323n {
    private final InterfaceC1934n _hashCode$delegate;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6172a;
    private final List<Annotation> annotations;
    private final List<Annotation>[] elementAnnotations;
    private final r[] elementDescriptors;
    private final String[] elementNames;
    private final boolean[] elementOptionality;
    private final z kind;
    private final Map<String, Integer> name2Index;
    private final String serialName;
    private final Set<String> serialNames;
    private final r[] typeParametersDescriptors;

    public s(String serialName, z kind, int i5, List<? extends r> typeParameters, C1241a builder) {
        E.f(serialName, "serialName");
        E.f(kind, "kind");
        E.f(typeParameters, "typeParameters");
        E.f(builder, "builder");
        this.serialName = serialName;
        this.kind = kind;
        this.f6172a = i5;
        this.annotations = builder.getAnnotations();
        this.serialNames = T.toHashSet(builder.getElementNames$kotlinx_serialization_core());
        String[] strArr = (String[]) builder.getElementNames$kotlinx_serialization_core().toArray(new String[0]);
        this.elementNames = strArr;
        this.elementDescriptors = D0.compactArray(builder.getElementDescriptors$kotlinx_serialization_core());
        this.elementAnnotations = (List[]) builder.getElementAnnotations$kotlinx_serialization_core().toArray(new List[0]);
        this.elementOptionality = T.toBooleanArray(builder.getElementOptionality$kotlinx_serialization_core());
        Iterable<C0133b0> iterableWithIndex = C.withIndex(strArr);
        ArrayList arrayList = new ArrayList(J.collectionSizeOrDefault(iterableWithIndex, 10));
        for (C0133b0 c0133b0 : iterableWithIndex) {
            arrayList.add(A.to(c0133b0.b, Integer.valueOf(c0133b0.f36a)));
        }
        this.name2Index = k0.toMap(arrayList);
        this.typeParametersDescriptors = D0.compactArray(typeParameters);
        this._hashCode$delegate = AbstractC1935o.lazy(new C0152u(this, 10));
    }

    public static int c(s sVar) {
        return H0.hashCodeImpl(sVar, sVar.typeParametersDescriptors);
    }

    @Override // p072m4.r
    public final boolean a() {
        return q.isNullable(this);
    }

    @Override // p072m4.r
    public final int b() {
        return this.f6172a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof s) {
            r rVar = (r) obj;
            if (E.a(getSerialName(), rVar.getSerialName()) && Arrays.equals(this.typeParametersDescriptors, ((s) obj).typeParametersDescriptors)) {
                int iB = rVar.b();
                int i5 = this.f6172a;
                if (i5 == iB) {
                    for (int i6 = 0; i6 < i5; i6++) {
                        if (E.a(getElementDescriptor(i6).getSerialName(), rVar.getElementDescriptor(i6).getSerialName()) && E.a(getElementDescriptor(i6).getKind(), rVar.getElementDescriptor(i6).getKind())) {
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    @Override // p072m4.r
    public List<Annotation> getAnnotations() {
        return this.annotations;
    }

    @Override // p072m4.r
    public List<Annotation> getElementAnnotations(int i5) {
        return this.elementAnnotations[i5];
    }

    @Override // p072m4.r
    public r getElementDescriptor(int i5) {
        return this.elementDescriptors[i5];
    }

    @Override // p072m4.r
    public int getElementIndex(String name) {
        E.f(name, "name");
        Integer num = this.name2Index.get(name);
        if (num != null) {
            return num.intValue();
        }
        return -3;
    }

    @Override // p072m4.r
    public String getElementName(int i5) {
        return this.elementNames[i5];
    }

    @Override // p072m4.r
    public z getKind() {
        return this.kind;
    }

    @Override // p072m4.r
    public String getSerialName() {
        return this.serialName;
    }

    @Override // p084o4.InterfaceC1323n
    public Set<String> getSerialNames() {
        return this.serialNames;
    }

    public final int hashCode() {
        return ((Number) this._hashCode$delegate.getValue()).intValue();
    }

    @Override // p072m4.r
    public final boolean isElementOptional(int i5) {
        return this.elementOptionality[i5];
    }

    @Override // p072m4.r
    public final boolean isInline() {
        return q.isInline(this);
    }

    public String toString() {
        return T.g(B.until(0, this.f6172a), ", ", getSerialName() + '(', ")", new C0130a(this, 17), 24);
    }
}
