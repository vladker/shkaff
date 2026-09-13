package kotlin.jvm.internal;

import A3.C0130a;
import java.lang.annotation.Annotation;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class d0 implements V3.p {
    public static final b0 Companion = new b0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5697a;
    private final List<V3.t> arguments;
    private final V3.e classifier;
    private final V3.p platformTypeUpperBound;

    public d0(V3.e classifier, List<V3.t> arguments, V3.p pVar, int i5) {
        E.f(classifier, "classifier");
        E.f(arguments, "arguments");
        this.classifier = classifier;
        this.arguments = arguments;
        this.platformTypeUpperBound = pVar;
        this.f5697a = i5;
    }

    public final String a(boolean z6) {
        String name;
        V3.e classifier = getClassifier();
        V3.c cVar = classifier instanceof V3.c ? (V3.c) classifier : null;
        Class javaClass = cVar != null ? N3.a.getJavaClass(cVar) : null;
        if (javaClass == null) {
            name = getClassifier().toString();
        } else if ((this.f5697a & 4) != 0) {
            name = "kotlin.Nothing";
        } else if (javaClass.isArray()) {
            if (javaClass.equals(boolean[].class)) {
                name = "kotlin.BooleanArray";
            } else if (javaClass.equals(char[].class)) {
                name = "kotlin.CharArray";
            } else if (javaClass.equals(byte[].class)) {
                name = "kotlin.ByteArray";
            } else if (javaClass.equals(short[].class)) {
                name = "kotlin.ShortArray";
            } else if (javaClass.equals(int[].class)) {
                name = "kotlin.IntArray";
            } else if (javaClass.equals(float[].class)) {
                name = "kotlin.FloatArray";
            } else if (javaClass.equals(long[].class)) {
                name = "kotlin.LongArray";
            } else {
                name = javaClass.equals(double[].class) ? "kotlin.DoubleArray" : "kotlin.Array";
            }
        } else if (z6 && javaClass.isPrimitive()) {
            V3.e classifier2 = getClassifier();
            E.d(classifier2, "null cannot be cast to non-null type kotlin.reflect.KClass<*>");
            name = N3.a.getJavaObjectType((V3.c) classifier2).getName();
        } else {
            name = javaClass.getName();
        }
        String strO = androidx.collection.a.o(name, getArguments().isEmpty() ? "" : A3.T.g(getArguments(), ", ", "<", ">", new C0130a(this, 15), 24), b() ? "?" : "");
        V3.p pVar = this.platformTypeUpperBound;
        if (!(pVar instanceof d0)) {
            return strO;
        }
        String strA = ((d0) pVar).a(true);
        if (E.a(strA, strO)) {
            return strO;
        }
        if (E.a(strA, strO + '?')) {
            return strO + '!';
        }
        return "(" + strO + ".." + strA + ')';
    }

    @Override // V3.p
    public final boolean b() {
        return (this.f5697a & 1) != 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof d0)) {
            return false;
        }
        d0 d0Var = (d0) obj;
        return E.a(getClassifier(), d0Var.getClassifier()) && E.a(getArguments(), d0Var.getArguments()) && E.a(this.platformTypeUpperBound, d0Var.platformTypeUpperBound) && this.f5697a == d0Var.f5697a;
    }

    @Override // V3.p, V3.a
    public List<Annotation> getAnnotations() {
        return A3.I.emptyList();
    }

    @Override // V3.p
    public List<V3.t> getArguments() {
        return this.arguments;
    }

    @Override // V3.p
    public V3.e getClassifier() {
        return this.classifier;
    }

    public final V3.p getPlatformTypeUpperBound$kotlin_stdlib() {
        return this.platformTypeUpperBound;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f5697a) + ((getArguments().hashCode() + (getClassifier().hashCode() * 31)) * 31);
    }

    public String toString() {
        return a(false) + " (Kotlin reflection is not available)";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public d0(V3.e classifier, List<V3.t> arguments, boolean z6) {
        this(classifier, arguments, null, z6 ? 1 : 0);
        E.f(classifier, "classifier");
        E.f(arguments, "arguments");
    }

    public static /* synthetic */ void getFlags$kotlin_stdlib$annotations() {
    }

    public static /* synthetic */ void getPlatformTypeUpperBound$kotlin_stdlib$annotations() {
    }
}
