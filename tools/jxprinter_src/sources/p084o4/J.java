package p084o4;

import A3.C;
import java.util.Arrays;
import kotlin.jvm.internal.E;
import p060k4.b;
import p060k4.g;
import p060k4.l;
import p072m4.r;
import p078n4.j;
import p147z3.AbstractC1935o;
import p147z3.InterfaceC1934n;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class J implements b {
    private final InterfaceC1934n descriptor$delegate;
    private r overriddenDescriptor;
    private final Enum<Object>[] values;

    public J(String serialName, Enum<Object>[] values) {
        E.f(serialName, "serialName");
        E.f(values, "values");
        this.values = values;
        this.descriptor$delegate = AbstractC1935o.lazy(new g(this, serialName));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [m4.r] */
    /* JADX WARN: Type inference failed for: r0v1, types: [m4.r] */
    /* JADX WARN: Type inference failed for: r0v2, types: [o4.G0, o4.I] */
    public static r a(J j6, String str) {
        ?? i5 = j6.overriddenDescriptor;
        if (i5 == 0) {
            i5 = new I(str, j6.values.length);
            for (Enum<Object> r6 : j6.values) {
                i5.addElement(r6.name(), false);
            }
        }
        return i5;
    }

    @Override // p060k4.b, p060k4.m, p060k4.a
    public r getDescriptor() {
        return (r) this.descriptor$delegate.getValue();
    }

    public String toString() {
        return "kotlinx.serialization.internal.EnumSerializer<" + getDescriptor().getSerialName() + '>';
    }

    @Override // p060k4.b, p060k4.a
    public Enum<Object> deserialize(j decoder) {
        E.f(decoder, "decoder");
        int iDecodeEnum = decoder.decodeEnum(getDescriptor());
        if (iDecodeEnum >= 0) {
            Enum<Object>[] enumArr = this.values;
            if (iDecodeEnum < enumArr.length) {
                return enumArr[iDecodeEnum];
            }
        }
        throw new l(iDecodeEnum + " is not among valid " + getDescriptor().getSerialName() + " enum values, values size is " + this.values.length);
    }

    @Override // p060k4.b, p060k4.m
    public void serialize(p078n4.l encoder, Enum<Object> value) {
        E.f(encoder, "encoder");
        E.f(value, "value");
        int iIndexOf = C.indexOf(this.values, value);
        if (iIndexOf != -1) {
            encoder.encodeEnum(getDescriptor(), iIndexOf);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(value);
        sb.append(" is not a valid enum ");
        sb.append(getDescriptor().getSerialName());
        sb.append(", must be one of ");
        String string = Arrays.toString(this.values);
        E.e(string, "toString(...)");
        sb.append(string);
        throw new l(sb.toString());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public J(String serialName, Enum<Object>[] values, r descriptor) {
        this(serialName, values);
        E.f(serialName, "serialName");
        E.f(values, "values");
        E.f(descriptor, "descriptor");
        this.overriddenDescriptor = descriptor;
    }
}
