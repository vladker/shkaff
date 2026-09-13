package p089p4;

import io.flutter.embedding.android.KeyboardMap;
import kotlin.jvm.internal.E;
import kotlin.jvm.internal.U;
import kotlin.jvm.internal.X;
import kotlinx.serialization.json.internal.C;
import kotlinx.serialization.json.internal.C1149z;
import kotlinx.serialization.json.internal.g0;
import kotlinx.serialization.json.internal.j0;
import p066l4.a;
import p072m4.r;
import p084o4.W;
import p147z3.J;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class n {
    private static final r jsonUnquotedLiteralDescriptor = W.InlinePrimitiveDescriptor("kotlinx.serialization.json.JsonUnquotedLiteral", a.serializer(X.INSTANCE));

    public static final E JsonPrimitive(Boolean bool) {
        return bool == null ? x.INSTANCE : new s(bool, false, null);
    }

    /* JADX INFO: renamed from: JsonPrimitive-7apg3OU, reason: not valid java name */
    public static final E m1090JsonPrimitive7apg3OU(byte b) {
        return m1091JsonPrimitiveVKZWuLQ(J.m1247constructorimpl(((long) b) & 255));
    }

    /* JADX INFO: renamed from: JsonPrimitive-VKZWuLQ, reason: not valid java name */
    public static final E m1091JsonPrimitiveVKZWuLQ(long j6) {
        return JsonUnquotedLiteral(Long.toUnsignedString(j6));
    }

    /* JADX INFO: renamed from: JsonPrimitive-WZ4Q5Ns, reason: not valid java name */
    public static final E m1092JsonPrimitiveWZ4Q5Ns(int i5) {
        return m1091JsonPrimitiveVKZWuLQ(J.m1247constructorimpl(((long) i5) & KeyboardMap.kValueMask));
    }

    /* JADX INFO: renamed from: JsonPrimitive-xj2QHRw, reason: not valid java name */
    public static final E m1093JsonPrimitivexj2QHRw(short s6) {
        return m1091JsonPrimitiveVKZWuLQ(J.m1247constructorimpl(((long) s6) & 65535));
    }

    public static final E JsonUnquotedLiteral(String str) {
        if (str == null) {
            return x.INSTANCE;
        }
        if (str.equals(x.INSTANCE.getContent())) {
            throw new C("Creating a literal unquoted value of 'null' is forbidden. If you want to create JSON null literal, use JsonNull object, otherwise, use JsonPrimitive");
        }
        return new s(str, false, jsonUnquotedLiteralDescriptor);
    }

    public static final void a(String str, m mVar) {
        throw new IllegalArgumentException("Element " + U.a(mVar.getClass()) + " is not a " + str);
    }

    public static final boolean getBoolean(E e) {
        E.f(e, "<this>");
        Boolean booleanStrictOrNull = j0.toBooleanStrictOrNull(e.getContent());
        if (booleanStrictOrNull != null) {
            return booleanStrictOrNull.booleanValue();
        }
        throw new IllegalStateException(e + " does not represent a Boolean");
    }

    public static final Boolean getBooleanOrNull(E e) {
        E.f(e, "<this>");
        return j0.toBooleanStrictOrNull(e.getContent());
    }

    public static final String getContentOrNull(E e) {
        E.f(e, "<this>");
        if (e instanceof x) {
            return null;
        }
        return e.getContent();
    }

    public static final double getDouble(E e) {
        E.f(e, "<this>");
        return Double.parseDouble(e.getContent());
    }

    public static final Double getDoubleOrNull(E e) {
        E.f(e, "<this>");
        return X3.U.toDoubleOrNull(e.getContent());
    }

    public static final float getFloat(E e) {
        E.f(e, "<this>");
        return Float.parseFloat(e.getContent());
    }

    public static final Float getFloatOrNull(E e) {
        E.f(e, "<this>");
        return X3.U.toFloatOrNull(e.getContent());
    }

    public static final int getInt(E e) {
        E.f(e, "<this>");
        try {
            long jI = new g0(e.getContent()).i();
            if (-2147483648L <= jI && jI <= 2147483647L) {
                return (int) jI;
            }
            throw new NumberFormatException(e.getContent() + " is not an Int");
        } catch (C1149z e6) {
            throw new NumberFormatException(e6.getMessage());
        }
    }

    public static final Integer getIntOrNull(E e) {
        Long lValueOf;
        E.f(e, "<this>");
        try {
            lValueOf = Long.valueOf(new g0(e.getContent()).i());
        } catch (C1149z unused) {
            lValueOf = null;
        }
        if (lValueOf != null) {
            long jLongValue = lValueOf.longValue();
            if (-2147483648L <= jLongValue && jLongValue <= 2147483647L) {
                return Integer.valueOf((int) jLongValue);
            }
        }
        return null;
    }

    public static final C1521f getJsonArray(m mVar) {
        E.f(mVar, "<this>");
        C1521f c1521f = mVar instanceof C1521f ? (C1521f) mVar : null;
        if (c1521f != null) {
            return c1521f;
        }
        a("JsonArray", mVar);
        throw null;
    }

    public static final x getJsonNull(m mVar) {
        E.f(mVar, "<this>");
        x xVar = mVar instanceof x ? (x) mVar : null;
        if (xVar != null) {
            return xVar;
        }
        a("JsonNull", mVar);
        throw null;
    }

    public static final A getJsonObject(m mVar) {
        E.f(mVar, "<this>");
        A a6 = mVar instanceof A ? (A) mVar : null;
        if (a6 != null) {
            return a6;
        }
        a("JsonObject", mVar);
        throw null;
    }

    public static final E getJsonPrimitive(m mVar) {
        E.f(mVar, "<this>");
        E e = mVar instanceof E ? (E) mVar : null;
        if (e != null) {
            return e;
        }
        a("JsonPrimitive", mVar);
        throw null;
    }

    public static final r getJsonUnquotedLiteralDescriptor() {
        return jsonUnquotedLiteralDescriptor;
    }

    public static final long getLong(E e) {
        E.f(e, "<this>");
        try {
            return new g0(e.getContent()).i();
        } catch (C1149z e6) {
            throw new NumberFormatException(e6.getMessage());
        }
    }

    public static final Long getLongOrNull(E e) {
        E.f(e, "<this>");
        try {
            return Long.valueOf(new g0(e.getContent()).i());
        } catch (C1149z unused) {
            return null;
        }
    }

    public static final Void unexpectedJson(String key, String expected) {
        E.f(key, "key");
        E.f(expected, "expected");
        throw new IllegalArgumentException(androidx.exifinterface.media.a.m("Element ", key, " is not a ", expected));
    }

    public static final E JsonPrimitive(Number number) {
        if (number == null) {
            return x.INSTANCE;
        }
        return new s(number, false, null);
    }

    public static final E JsonPrimitive(String str) {
        if (str == null) {
            return x.INSTANCE;
        }
        return new s(str, true, null);
    }

    public static final x JsonPrimitive(Void r6) {
        return x.INSTANCE;
    }
}
