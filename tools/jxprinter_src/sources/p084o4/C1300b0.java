package p084o4;

import N3.a;
import V3.c;
import V3.e;
import V3.p;
import V3.t;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.jvm.internal.E;

/* JADX INFO: renamed from: o4.b0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1300b0 implements p {
    private final p origin;

    public C1300b0(p origin) {
        E.f(origin, "origin");
        this.origin = origin;
    }

    @Override // V3.p
    public final boolean b() {
        return this.origin.b();
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        p pVar = this.origin;
        C1300b0 c1300b0 = obj instanceof C1300b0 ? (C1300b0) obj : null;
        if (!E.a(pVar, c1300b0 != null ? c1300b0.origin : null)) {
            return false;
        }
        e classifier = getClassifier();
        if (classifier instanceof c) {
            p pVar2 = obj instanceof p ? (p) obj : null;
            e classifier2 = pVar2 != null ? pVar2.getClassifier() : null;
            if (classifier2 != null && (classifier2 instanceof c)) {
                return E.a(a.getJavaClass((c) classifier), a.getJavaClass((c) classifier2));
            }
        }
        return false;
    }

    @Override // V3.p, V3.a
    public List<Annotation> getAnnotations() {
        return this.origin.getAnnotations();
    }

    @Override // V3.p
    public List<t> getArguments() {
        return this.origin.getArguments();
    }

    @Override // V3.p
    public e getClassifier() {
        return this.origin.getClassifier();
    }

    public final int hashCode() {
        return this.origin.hashCode();
    }

    public String toString() {
        return "KTypeWrapper: " + this.origin;
    }
}
