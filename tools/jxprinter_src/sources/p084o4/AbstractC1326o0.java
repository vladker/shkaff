package p084o4;

import A3.AbstractC0157z;
import A3.I;
import X3.V;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.jvm.internal.E;
import p072m4.C;
import p072m4.q;
import p072m4.r;
import p072m4.z;

/* JADX INFO: renamed from: o4.o0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1326o0 implements r {
    private final r keyDescriptor;
    private final String serialName;
    private final r valueDescriptor;

    public AbstractC1326o0(String str, r rVar, r rVar2) {
        this.serialName = str;
        this.keyDescriptor = rVar;
        this.valueDescriptor = rVar2;
    }

    @Override // p072m4.r
    public final boolean a() {
        return q.isNullable(this);
    }

    @Override // p072m4.r
    public final int b() {
        return 2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AbstractC1326o0)) {
            return false;
        }
        AbstractC1326o0 abstractC1326o0 = (AbstractC1326o0) obj;
        return E.a(getSerialName(), abstractC1326o0.getSerialName()) && E.a(this.keyDescriptor, abstractC1326o0.keyDescriptor) && E.a(this.valueDescriptor, abstractC1326o0.valueDescriptor);
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

    @Override // p072m4.r
    public r getElementDescriptor(int i5) {
        if (i5 < 0) {
            StringBuilder sbT = AbstractC0157z.t(i5, "Illegal index ", ", ");
            sbT.append(getSerialName());
            sbT.append(" expects only non-negative indices");
            throw new IllegalArgumentException(sbT.toString().toString());
        }
        int i6 = i5 % 2;
        if (i6 == 0) {
            return this.keyDescriptor;
        }
        if (i6 == 1) {
            return this.valueDescriptor;
        }
        throw new IllegalStateException("Unreached");
    }

    @Override // p072m4.r
    public int getElementIndex(String name) {
        E.f(name, "name");
        Integer intOrNull = V.toIntOrNull(name);
        if (intOrNull != null) {
            return intOrNull.intValue();
        }
        throw new IllegalArgumentException(name.concat(" is not a valid map index"));
    }

    @Override // p072m4.r
    public String getElementName(int i5) {
        return String.valueOf(i5);
    }

    public final r getKeyDescriptor() {
        return this.keyDescriptor;
    }

    @Override // p072m4.r
    public z getKind() {
        return C.INSTANCE;
    }

    @Override // p072m4.r
    public String getSerialName() {
        return this.serialName;
    }

    public final r getValueDescriptor() {
        return this.valueDescriptor;
    }

    public final int hashCode() {
        return this.valueDescriptor.hashCode() + ((this.keyDescriptor.hashCode() + (getSerialName().hashCode() * 31)) * 31);
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
        return getSerialName() + '(' + this.keyDescriptor + ", " + this.valueDescriptor + ')';
    }
}
