package W3;

import A3.C0130a;
import A3.C0152u;
import java.util.ArrayList;
import java.util.Iterator;
import p147z3.C1938s;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class z extends u {
    private static final <T> InterfaceC0233q Sequence(O3.a iterator) {
        kotlin.jvm.internal.E.f(iterator, "iterator");
        return new A3.B(iterator, 11);
    }

    public static <T> InterfaceC0233q asSequence(Iterator<? extends T> it) {
        kotlin.jvm.internal.E.f(it, "<this>");
        return constrainOnce(new v(it, 0));
    }

    public static <T> InterfaceC0233q constrainOnce(InterfaceC0233q interfaceC0233q) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        return interfaceC0233q instanceof C0217a ? interfaceC0233q : new C0217a(interfaceC0233q);
    }

    public static <T> InterfaceC0233q emptySequence() {
        return C0225i.INSTANCE;
    }

    public static final <T, C, R> InterfaceC0233q flatMapIndexed(InterfaceC0233q source, O3.p transform, O3.l iterator) {
        kotlin.jvm.internal.E.f(source, "source");
        kotlin.jvm.internal.E.f(transform, "transform");
        kotlin.jvm.internal.E.f(iterator, "iterator");
        return t.sequence(new w(source, transform, iterator, null));
    }

    public static final <T> InterfaceC0233q flatten(InterfaceC0233q interfaceC0233q) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        S2.l lVar = new S2.l(1);
        return interfaceC0233q instanceof S ? ((S) interfaceC0233q).flatten$kotlin_stdlib(lVar) : new C0227k(interfaceC0233q, new S2.l(3), lVar);
    }

    public static final <T> InterfaceC0233q flattenSequenceOfIterable(InterfaceC0233q interfaceC0233q) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        S2.l lVar = new S2.l(2);
        return interfaceC0233q instanceof S ? ((S) interfaceC0233q).flatten$kotlin_stdlib(lVar) : new C0227k(interfaceC0233q, new S2.l(3), lVar);
    }

    public static <T> InterfaceC0233q generateSequence(O3.a nextFunction) {
        kotlin.jvm.internal.E.f(nextFunction, "nextFunction");
        return constrainOnce(new C0229m(nextFunction, new C0130a(nextFunction, 3)));
    }

    public static final <T> InterfaceC0233q ifEmpty(InterfaceC0233q interfaceC0233q, O3.a defaultValue) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        kotlin.jvm.internal.E.f(defaultValue, "defaultValue");
        return t.sequence(new x(interfaceC0233q, defaultValue, null));
    }

    private static final <T> InterfaceC0233q orEmpty(InterfaceC0233q interfaceC0233q) {
        return interfaceC0233q == null ? emptySequence() : interfaceC0233q;
    }

    public static final <T> InterfaceC0233q sequenceOf(T... elements) {
        kotlin.jvm.internal.E.f(elements, "elements");
        return A3.C.asSequence(elements);
    }

    public static final <T> InterfaceC0233q shuffled(InterfaceC0233q interfaceC0233q) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        return shuffled(interfaceC0233q, S3.f.Default);
    }

    public static final <T, R> C1938s unzip(InterfaceC0233q interfaceC0233q) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<Object> it = interfaceC0233q.iterator();
        while (it.hasNext()) {
            C1938s c1938s = (C1938s) it.next();
            arrayList.add(c1938s.f9134a);
            arrayList2.add(c1938s.b);
        }
        return p147z3.A.to(arrayList, arrayList2);
    }

    public static <T> InterfaceC0233q generateSequence(T t6, O3.l nextFunction) {
        kotlin.jvm.internal.E.f(nextFunction, "nextFunction");
        return t6 == null ? C0225i.INSTANCE : new C0229m(new C0152u(t6, 6), nextFunction);
    }

    public static final <T> InterfaceC0233q shuffled(InterfaceC0233q interfaceC0233q, S3.f random) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        kotlin.jvm.internal.E.f(random, "random");
        return t.sequence(new y(interfaceC0233q, random, null));
    }

    public static <T> InterfaceC0233q generateSequence(O3.a seedFunction, O3.l nextFunction) {
        kotlin.jvm.internal.E.f(seedFunction, "seedFunction");
        kotlin.jvm.internal.E.f(nextFunction, "nextFunction");
        return new C0229m(seedFunction, nextFunction);
    }
}
