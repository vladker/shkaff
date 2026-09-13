package p084o4;

import A3.AbstractC0157z;
import A3.I;
import X3.V;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.jvm.internal.E;
import p072m4.B;
import p072m4.q;
import p072m4.r;
import p072m4.z;

/* JADX INFO: renamed from: o4.h0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1312h0 implements r {
    private final r elementDescriptor;

    public AbstractC1312h0(r rVar) {
        this.elementDescriptor = rVar;
    }

    @Override // p072m4.r
    public final boolean a() {
        return q.isNullable(this);
    }

    @Override // p072m4.r
    public final int b() {
        return 1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AbstractC1312h0)) {
            return false;
        }
        AbstractC1312h0 abstractC1312h0 = (AbstractC1312h0) obj;
        return E.a(this.elementDescriptor, abstractC1312h0.elementDescriptor) && E.a(getSerialName(), abstractC1312h0.getSerialName());
    }

    @Override // p072m4.r
    public List<Annotation> getAnnotations() {
        return q.getAnnotations(this);
    }

    @Override // p072m4.r
    public List<Annotation> getElementAnnotations(int i5) {
        if (i5 >= 0) {
            return I.emptyList();
        }
        StringBuilder sbT = AbstractC0157z.t(i5, "Illegal index ", ", ");
        sbT.append(getSerialName());
        sbT.append(" expects only non-negative indices");
        throw new IllegalArgumentException(sbT.toString().toString());
    }

    public final r getElementDescriptor() {
        return this.elementDescriptor;
    }

    @Override // p072m4.r
    public int getElementIndex(String name) {
        E.f(name, "name");
        Integer intOrNull = V.toIntOrNull(name);
        if (intOrNull != null) {
            return intOrNull.intValue();
        }
        throw new IllegalArgumentException(name.concat(" is not a valid list index"));
    }

    @Override // p072m4.r
    public String getElementName(int i5) {
        return String.valueOf(i5);
    }

    @Override // p072m4.r
    public z getKind() {
        return B.INSTANCE;
    }

    @Override // p072m4.r
    public abstract /* synthetic */ String getSerialName();

    public final int hashCode() {
        return getSerialName().hashCode() + (this.elementDescriptor.hashCode() * 31);
    }

    @Override // p072m4.r
    public final boolean isElementOptional(int i5) {
        if (i5 >= 0) {
            return false;
        }
        StringBuilder sbT = AbstractC0157z.t(i5, "Illegal index ", ", ");
        sbT.append(getSerialName());
        sbT.append(" expects only non-negative indices");
        throw new IllegalArgumentException(sbT.toString().toString());
    }

    @Override // p072m4.r
    public final boolean isInline() {
        return q.isInline(this);
    }

    public String toString() {
        return getSerialName() + '(' + this.elementDescriptor + ')';
    }

    @Override // p072m4.r
    public r getElementDescriptor(int i5) {
        if (i5 >= 0) {
            return this.elementDescriptor;
        }
        StringBuilder sbT = AbstractC0157z.t(i5, "Illegal index ", ", ");
        sbT.append(getSerialName());
        sbT.append(" expects only non-negative indices");
        throw new IllegalArgumentException(sbT.toString().toString());
    }
}
