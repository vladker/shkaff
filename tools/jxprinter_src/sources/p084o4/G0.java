package p084o4;

import A3.C0130a;
import A3.I;
import A3.T;
import A3.k0;
import O3.a;
import U3.B;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.E;
import p060k4.b;
import p072m4.A;
import p072m4.q;
import p072m4.r;
import p072m4.z;
import p147z3.AbstractC1935o;
import p147z3.EnumC1936p;
import p147z3.InterfaceC1934n;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class G0 implements r, InterfaceC1323n {
    private final InterfaceC1934n _hashCode$delegate;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6453a;
    public int b;
    private final InterfaceC1934n childSerializers$delegate;
    private List<Annotation> classAnnotations;
    private final boolean[] elementsOptionality;
    private final O generatedSerializer;
    private Map<String, Integer> indices;
    private final String[] names;
    private final List<Annotation>[] propertiesAnnotations;
    private final String serialName;
    private final InterfaceC1934n typeParameterDescriptors$delegate;

    public G0(String serialName, O o6, int i5) {
        E.f(serialName, "serialName");
        this.serialName = serialName;
        this.generatedSerializer = o6;
        this.f6453a = i5;
        this.b = -1;
        String[] strArr = new String[i5];
        for (int i6 = 0; i6 < i5; i6++) {
            strArr[i6] = "[UNINITIALIZED]";
        }
        this.names = strArr;
        int i7 = this.f6453a;
        this.propertiesAnnotations = new List[i7];
        this.elementsOptionality = new boolean[i7];
        this.indices = k0.emptyMap();
        EnumC1936p enumC1936p = EnumC1936p.f9133a;
        final int i8 = 0;
        this.childSerializers$delegate = AbstractC1935o.lazy(enumC1936p, new a(this) { // from class: o4.F0
            public final /* synthetic */ G0 b;

            {
                this.b = this;
            }

            @Override // O3.a
            public final Object invoke() {
                switch (i8) {
                    case 0:
                        return G0.d(this.b);
                    case 1:
                        return G0.c(this.b);
                    default:
                        G0 g1 = this.b;
                        return Integer.valueOf(H0.hashCodeImpl(g1, g1.getTypeParameterDescriptors$kotlinx_serialization_core()));
                }
            }
        });
        final int i9 = 1;
        this.typeParameterDescriptors$delegate = AbstractC1935o.lazy(enumC1936p, new a(this) { // from class: o4.F0
            public final /* synthetic */ G0 b;

            {
                this.b = this;
            }

            @Override // O3.a
            public final Object invoke() {
                switch (i9) {
                    case 0:
                        return G0.d(this.b);
                    case 1:
                        return G0.c(this.b);
                    default:
                        G0 g1 = this.b;
                        return Integer.valueOf(H0.hashCodeImpl(g1, g1.getTypeParameterDescriptors$kotlinx_serialization_core()));
                }
            }
        });
        final int i10 = 2;
        this._hashCode$delegate = AbstractC1935o.lazy(enumC1936p, new a(this) { // from class: o4.F0
            public final /* synthetic */ G0 b;

            {
                this.b = this;
            }

            @Override // O3.a
            public final Object invoke() {
                switch (i10) {
                    case 0:
                        return G0.d(this.b);
                    case 1:
                        return G0.c(this.b);
                    default:
                        G0 g1 = this.b;
                        return Integer.valueOf(H0.hashCodeImpl(g1, g1.getTypeParameterDescriptors$kotlinx_serialization_core()));
                }
            }
        });
    }

    public static r[] c(G0 g1) {
        ArrayList arrayList;
        b[] bVarArrTypeParametersSerializers;
        O o6 = g1.generatedSerializer;
        if (o6 == null || (bVarArrTypeParametersSerializers = o6.typeParametersSerializers()) == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList(bVarArrTypeParametersSerializers.length);
            for (b bVar : bVarArrTypeParametersSerializers) {
                arrayList.add(bVar.getDescriptor());
            }
        }
        return D0.compactArray(arrayList);
    }

    public static b[] d(G0 g1) {
        b[] bVarArrChildSerializers;
        O o6 = g1.generatedSerializer;
        return (o6 == null || (bVarArrChildSerializers = o6.childSerializers()) == null) ? I0.EMPTY_SERIALIZER_ARRAY : bVarArrChildSerializers;
    }

    @Override // p072m4.r
    public final boolean a() {
        return q.isNullable(this);
    }

    public final void addElement(String name, boolean z6) {
        E.f(name, "name");
        String[] strArr = this.names;
        int i5 = this.b + 1;
        this.b = i5;
        strArr[i5] = name;
        this.elementsOptionality[i5] = z6;
        this.propertiesAnnotations[i5] = null;
        if (i5 == this.f6453a - 1) {
            HashMap map = new HashMap();
            int length = this.names.length;
            for (int i6 = 0; i6 < length; i6++) {
                map.put(this.names[i6], Integer.valueOf(i6));
            }
            this.indices = map;
        }
    }

    @Override // p072m4.r
    public final int b() {
        return this.f6453a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof G0) {
            r rVar = (r) obj;
            if (E.a(getSerialName(), rVar.getSerialName()) && Arrays.equals(getTypeParameterDescriptors$kotlinx_serialization_core(), ((G0) obj).getTypeParameterDescriptors$kotlinx_serialization_core())) {
                int iB = rVar.b();
                int i5 = this.f6453a;
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
        List<Annotation> list = this.classAnnotations;
        return list == null ? I.emptyList() : list;
    }

    @Override // p072m4.r
    public List<Annotation> getElementAnnotations(int i5) {
        List<Annotation> list = this.propertiesAnnotations[i5];
        return list == null ? I.emptyList() : list;
    }

    @Override // p072m4.r
    public r getElementDescriptor(int i5) {
        return ((b[]) this.childSerializers$delegate.getValue())[i5].getDescriptor();
    }

    @Override // p072m4.r
    public int getElementIndex(String name) {
        E.f(name, "name");
        Integer num = this.indices.get(name);
        if (num != null) {
            return num.intValue();
        }
        return -3;
    }

    @Override // p072m4.r
    public String getElementName(int i5) {
        return this.names[i5];
    }

    @Override // p072m4.r
    public z getKind() {
        return A.INSTANCE;
    }

    @Override // p072m4.r
    public String getSerialName() {
        return this.serialName;
    }

    @Override // p084o4.InterfaceC1323n
    public Set<String> getSerialNames() {
        return this.indices.keySet();
    }

    public final r[] getTypeParameterDescriptors$kotlinx_serialization_core() {
        return (r[]) this.typeParameterDescriptors$delegate.getValue();
    }

    public int hashCode() {
        return ((Number) this._hashCode$delegate.getValue()).intValue();
    }

    @Override // p072m4.r
    public final boolean isElementOptional(int i5) {
        return this.elementsOptionality[i5];
    }

    @Override // p072m4.r
    public boolean isInline() {
        return q.isInline(this);
    }

    public final void pushAnnotation(Annotation annotation) {
        E.f(annotation, "annotation");
        List<Annotation> arrayList = this.propertiesAnnotations[this.b];
        if (arrayList == null) {
            arrayList = new ArrayList<>(1);
            this.propertiesAnnotations[this.b] = arrayList;
        }
        arrayList.add(annotation);
    }

    public final void pushClassAnnotation(Annotation a6) {
        E.f(a6, "a");
        if (this.classAnnotations == null) {
            this.classAnnotations = new ArrayList(1);
        }
        List<Annotation> list = this.classAnnotations;
        E.c(list);
        list.add(a6);
    }

    public String toString() {
        return T.g(B.until(0, this.f6453a), ", ", getSerialName() + '(', ")", new C0130a(this, 19), 24);
    }
}
