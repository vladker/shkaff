package retrofit2;

import A3.AbstractC0157z;
import androidx.browser.trusted.sharing.ShareTarget;
import com.google.common.net.HttpHeaders;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.C1375v;
import okhttp3.C1376w;
import okhttp3.C1378y;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final class p0 {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final Pattern f8137s = Pattern.compile("\\{([a-zA-Z][a-zA-Z0-9_-]*)\\}");

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final Pattern f8138t = Pattern.compile("[a-zA-Z][a-zA-Z0-9_-]*");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u0 f8139a;
    public final Class b;
    public final Method c;
    okhttp3.B contentType;
    public final Annotation[] d;
    public final Annotation[][] e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Type[] f8140f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f8141g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f8142h;
    C1376w headers;
    String httpMethod;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f8143i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f8144j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f8145k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f8146l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f8147m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f8148n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f8149o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f8150p;
    i0[] parameterHandlers;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f8151q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f8152r;
    String relativeUrl;
    Set<String> relativeUrlParamNames;

    public p0(u0 u0Var, Class cls, Method method) {
        this.f8139a = u0Var;
        this.b = cls;
        this.c = method;
        this.d = method.getAnnotations();
        this.f8140f = method.getGenericParameterTypes();
        this.e = method.getParameterAnnotations();
    }

    public static Class a(Class cls) {
        if (Boolean.TYPE == cls) {
            return Boolean.class;
        }
        if (Byte.TYPE == cls) {
            return Byte.class;
        }
        if (Character.TYPE == cls) {
            return Character.class;
        }
        if (Double.TYPE == cls) {
            return Double.class;
        }
        if (Float.TYPE == cls) {
            return Float.class;
        }
        if (Integer.TYPE == cls) {
            return Integer.class;
        }
        if (Long.TYPE == cls) {
            return Long.class;
        }
        return Short.TYPE == cls ? Short.class : cls;
    }

    private i0 parseParameter(int i5, Type type, Annotation[] annotationArr, boolean z6) {
        i0 i0Var;
        Method method = this.c;
        if (annotationArr != null) {
            i0Var = null;
            for (Annotation annotation : annotationArr) {
                i0 parameterAnnotation = parseParameterAnnotation(i5, type, annotationArr, annotation);
                if (parameterAnnotation != null) {
                    if (i0Var != null) {
                        throw B0.h(method, i5, "Multiple Retrofit annotations found, only one allowed.", new Object[0]);
                    }
                    i0Var = parameterAnnotation;
                }
            }
        } else {
            i0Var = null;
        }
        if (i0Var != null) {
            return i0Var;
        }
        if (z6) {
            try {
                if (B0.e(type) == E3.g.class) {
                    this.f8152r = true;
                    return null;
                }
            } catch (NoClassDefFoundError unused) {
            }
        }
        throw B0.h(method, i5, "No Retrofit annotation found.", new Object[0]);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private i0 parseParameterAnnotation(int i5, Type type, Annotation[] annotationArr, Annotation annotation) {
        boolean z6 = annotation instanceof A5.y;
        Method method = this.c;
        if (z6) {
            d(i5, type);
            if (this.f8148n) {
                throw B0.h(method, i5, "Multiple @Url method annotations found.", new Object[0]);
            }
            if (this.f8144j) {
                throw B0.h(method, i5, "@Path parameters may not be used with @Url.", new Object[0]);
            }
            if (this.f8145k) {
                throw B0.h(method, i5, "A @Url parameter must not come after a @Query.", new Object[0]);
            }
            if (this.f8146l) {
                throw B0.h(method, i5, "A @Url parameter must not come after a @QueryName.", new Object[0]);
            }
            if (this.f8147m) {
                throw B0.h(method, i5, "A @Url parameter must not come after a @QueryMap.", new Object[0]);
            }
            if (this.relativeUrl != null) {
                throw B0.h(method, i5, "@Url cannot be used with @%s URL", this.httpMethod);
            }
            this.f8148n = true;
            if (type == C1378y.class || type == String.class || type == URI.class || ((type instanceof Class) && "android.net.Uri".equals(((Class) type).getName()))) {
                return new g0(method, i5);
            }
            throw B0.h(method, i5, "@Url must be okhttp3.HttpUrl, String, java.net.URI, or android.net.Uri type.", new Object[0]);
        }
        boolean z7 = annotation instanceof A5.s;
        u0 u0Var = this.f8139a;
        if (z7) {
            d(i5, type);
            if (this.f8145k) {
                throw B0.h(method, i5, "A @Path parameter must not come after a @Query.", new Object[0]);
            }
            if (this.f8146l) {
                throw B0.h(method, i5, "A @Path parameter must not come after a @QueryName.", new Object[0]);
            }
            if (this.f8147m) {
                throw B0.h(method, i5, "A @Path parameter must not come after a @QueryMap.", new Object[0]);
            }
            if (this.f8148n) {
                throw B0.h(method, i5, "@Path parameters may not be used with @Url.", new Object[0]);
            }
            if (this.relativeUrl == null) {
                throw B0.h(method, i5, "@Path can only be used with relative url on @%s", this.httpMethod);
            }
            this.f8144j = true;
            A5.s sVar = (A5.s) annotation;
            String strValue = sVar.value();
            if (!f8138t.matcher(strValue).matches()) {
                throw B0.h(method, i5, "@Path parameter name must match %s. Found: %s", f8137s.pattern(), strValue);
            }
            if (this.relativeUrlParamNames.contains(strValue)) {
                return new C1604b0(method, i5, strValue, u0Var.c(type, annotationArr), sVar.encoded());
            }
            throw B0.h(method, i5, "URL \"%s\" does not contain \"{%s}\".", this.relativeUrl, strValue);
        }
        if (annotation instanceof A5.t) {
            d(i5, type);
            A5.t tVar = (A5.t) annotation;
            String strValue2 = tVar.value();
            boolean zEncoded = tVar.encoded();
            Class clsE = B0.e(type);
            this.f8145k = true;
            if (!Iterable.class.isAssignableFrom(clsE)) {
                return clsE.isArray() ? new S(new c0(strValue2, u0Var.c(a(clsE.getComponentType()), annotationArr), zEncoded)) : new c0(strValue2, u0Var.c(type, annotationArr), zEncoded);
            }
            if (type instanceof ParameterizedType) {
                return new Q(new c0(strValue2, u0Var.c(B0.d(0, (ParameterizedType) type), annotationArr), zEncoded));
            }
            throw B0.h(method, i5, clsE.getSimpleName() + " must include generic type (e.g., " + clsE.getSimpleName() + "<String>)", new Object[0]);
        }
        if (annotation instanceof A5.v) {
            d(i5, type);
            boolean zEncoded2 = ((A5.v) annotation).encoded();
            Class clsE2 = B0.e(type);
            this.f8146l = true;
            if (!Iterable.class.isAssignableFrom(clsE2)) {
                return clsE2.isArray() ? new S(new e0(u0Var.c(a(clsE2.getComponentType()), annotationArr), zEncoded2)) : new e0(u0Var.c(type, annotationArr), zEncoded2);
            }
            if (type instanceof ParameterizedType) {
                return new Q(new e0(u0Var.c(B0.d(0, (ParameterizedType) type), annotationArr), zEncoded2));
            }
            throw B0.h(method, i5, clsE2.getSimpleName() + " must include generic type (e.g., " + clsE2.getSimpleName() + "<String>)", new Object[0]);
        }
        if (annotation instanceof A5.u) {
            d(i5, type);
            Class clsE3 = B0.e(type);
            this.f8147m = true;
            if (!Map.class.isAssignableFrom(clsE3)) {
                throw B0.h(method, i5, "@QueryMap parameter type must be Map.", new Object[0]);
            }
            Type typeF = B0.f(type, clsE3);
            if (!(typeF instanceof ParameterizedType)) {
                throw B0.h(method, i5, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
            }
            ParameterizedType parameterizedType = (ParameterizedType) typeF;
            Type typeD = B0.d(0, parameterizedType);
            if (String.class == typeD) {
                return new d0(method, i5, u0Var.c(B0.d(1, parameterizedType), annotationArr), ((A5.u) annotation).encoded());
            }
            throw B0.h(method, i5, "@QueryMap keys must be of type String: " + typeD, new Object[0]);
        }
        if (annotation instanceof A5.i) {
            d(i5, type);
            A5.i iVar = (A5.i) annotation;
            String strValue3 = iVar.value();
            Class clsE4 = B0.e(type);
            if (!Iterable.class.isAssignableFrom(clsE4)) {
                return clsE4.isArray() ? new S(new W(strValue3, u0Var.c(a(clsE4.getComponentType()), annotationArr), iVar.allowUnsafeNonAsciiValues())) : new W(strValue3, u0Var.c(type, annotationArr), iVar.allowUnsafeNonAsciiValues());
            }
            if (type instanceof ParameterizedType) {
                return new Q(new W(strValue3, u0Var.c(B0.d(0, (ParameterizedType) type), annotationArr), iVar.allowUnsafeNonAsciiValues()));
            }
            throw B0.h(method, i5, clsE4.getSimpleName() + " must include generic type (e.g., " + clsE4.getSimpleName() + "<String>)", new Object[0]);
        }
        if (annotation instanceof A5.j) {
            if (type == C1376w.class) {
                return new Y(method, i5);
            }
            d(i5, type);
            Class clsE5 = B0.e(type);
            if (!Map.class.isAssignableFrom(clsE5)) {
                throw B0.h(method, i5, "@HeaderMap parameter type must be Map or Headers.", new Object[0]);
            }
            Type typeF2 = B0.f(type, clsE5);
            if (!(typeF2 instanceof ParameterizedType)) {
                throw B0.h(method, i5, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
            }
            ParameterizedType parameterizedType2 = (ParameterizedType) typeF2;
            Type typeD2 = B0.d(0, parameterizedType2);
            if (String.class == typeD2) {
                return new X(method, i5, u0Var.c(B0.d(1, parameterizedType2), annotationArr), ((A5.j) annotation).allowUnsafeNonAsciiValues());
            }
            throw B0.h(method, i5, "@HeaderMap keys must be of type String: " + typeD2, new Object[0]);
        }
        if (annotation instanceof A5.c) {
            d(i5, type);
            if (!this.f8150p) {
                throw B0.h(method, i5, "@Field parameters can only be used with form encoding.", new Object[0]);
            }
            A5.c cVar = (A5.c) annotation;
            String strValue4 = cVar.value();
            boolean zEncoded3 = cVar.encoded();
            this.f8141g = true;
            Class clsE6 = B0.e(type);
            if (!Iterable.class.isAssignableFrom(clsE6)) {
                return clsE6.isArray() ? new S(new U(strValue4, u0Var.c(a(clsE6.getComponentType()), annotationArr), zEncoded3)) : new U(strValue4, u0Var.c(type, annotationArr), zEncoded3);
            }
            if (type instanceof ParameterizedType) {
                return new Q(new U(strValue4, u0Var.c(B0.d(0, (ParameterizedType) type), annotationArr), zEncoded3));
            }
            throw B0.h(method, i5, clsE6.getSimpleName() + " must include generic type (e.g., " + clsE6.getSimpleName() + "<String>)", new Object[0]);
        }
        if (annotation instanceof A5.d) {
            d(i5, type);
            if (!this.f8150p) {
                throw B0.h(method, i5, "@FieldMap parameters can only be used with form encoding.", new Object[0]);
            }
            Class clsE7 = B0.e(type);
            if (!Map.class.isAssignableFrom(clsE7)) {
                throw B0.h(method, i5, "@FieldMap parameter type must be Map.", new Object[0]);
            }
            Type typeF3 = B0.f(type, clsE7);
            if (!(typeF3 instanceof ParameterizedType)) {
                throw B0.h(method, i5, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
            }
            ParameterizedType parameterizedType3 = (ParameterizedType) typeF3;
            Type typeD3 = B0.d(0, parameterizedType3);
            if (String.class == typeD3) {
                InterfaceC1621t interfaceC1621tC = u0Var.c(B0.d(1, parameterizedType3), annotationArr);
                this.f8141g = true;
                return new V(method, i5, interfaceC1621tC, ((A5.d) annotation).encoded());
            }
            throw B0.h(method, i5, "@FieldMap keys must be of type String: " + typeD3, new Object[0]);
        }
        boolean z8 = annotation instanceof A5.q;
        Annotation[] annotationArr2 = this.d;
        if (z8) {
            d(i5, type);
            if (!this.f8151q) {
                throw B0.h(method, i5, "@Part parameters can only be used with multipart encoding.", new Object[0]);
            }
            A5.q qVar = (A5.q) annotation;
            this.f8142h = true;
            String strValue5 = qVar.value();
            Class clsE8 = B0.e(type);
            if (strValue5.isEmpty()) {
                boolean zIsAssignableFrom = Iterable.class.isAssignableFrom(clsE8);
                f0 f0Var = f0.f8126a;
                if (!zIsAssignableFrom) {
                    if (clsE8.isArray()) {
                        if (okhttp3.D.class.isAssignableFrom(clsE8.getComponentType())) {
                            return new S(f0Var);
                        }
                        throw B0.h(method, i5, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                    }
                    if (okhttp3.D.class.isAssignableFrom(clsE8)) {
                        return f0Var;
                    }
                    throw B0.h(method, i5, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                }
                if (type instanceof ParameterizedType) {
                    if (okhttp3.D.class.isAssignableFrom(B0.e(B0.d(0, (ParameterizedType) type)))) {
                        return new Q(f0Var);
                    }
                    throw B0.h(method, i5, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                }
                throw B0.h(method, i5, clsE8.getSimpleName() + " must include generic type (e.g., " + clsE8.getSimpleName() + "<String>)", new Object[0]);
            }
            C1376w c1376wE = C1376w.e(HttpHeaders.CONTENT_DISPOSITION, AbstractC0157z.o("form-data; name=\"", strValue5, "\""), "Content-Transfer-Encoding", qVar.encoding());
            if (!Iterable.class.isAssignableFrom(clsE8)) {
                if (!clsE8.isArray()) {
                    if (okhttp3.D.class.isAssignableFrom(clsE8)) {
                        throw B0.h(method, i5, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                    }
                    return new Z(method, i5, c1376wE, u0Var.nextRequestBodyConverter(null, type, annotationArr, annotationArr2));
                }
                Class clsA = a(clsE8.getComponentType());
                if (okhttp3.D.class.isAssignableFrom(clsA)) {
                    throw B0.h(method, i5, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                }
                return new S(new Z(method, i5, c1376wE, u0Var.nextRequestBodyConverter(null, clsA, annotationArr, annotationArr2)));
            }
            if (type instanceof ParameterizedType) {
                Type typeD4 = B0.d(0, (ParameterizedType) type);
                if (okhttp3.D.class.isAssignableFrom(B0.e(typeD4))) {
                    throw B0.h(method, i5, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                }
                return new Q(new Z(method, i5, c1376wE, u0Var.nextRequestBodyConverter(null, typeD4, annotationArr, annotationArr2)));
            }
            throw B0.h(method, i5, clsE8.getSimpleName() + " must include generic type (e.g., " + clsE8.getSimpleName() + "<String>)", new Object[0]);
        }
        if (annotation instanceof A5.r) {
            d(i5, type);
            if (!this.f8151q) {
                throw B0.h(method, i5, "@PartMap parameters can only be used with multipart encoding.", new Object[0]);
            }
            this.f8142h = true;
            Class clsE9 = B0.e(type);
            if (!Map.class.isAssignableFrom(clsE9)) {
                throw B0.h(method, i5, "@PartMap parameter type must be Map.", new Object[0]);
            }
            Type typeF4 = B0.f(type, clsE9);
            if (!(typeF4 instanceof ParameterizedType)) {
                throw B0.h(method, i5, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
            }
            ParameterizedType parameterizedType4 = (ParameterizedType) typeF4;
            Type typeD5 = B0.d(0, parameterizedType4);
            if (String.class != typeD5) {
                throw B0.h(method, i5, "@PartMap keys must be of type String: " + typeD5, new Object[0]);
            }
            Type typeD6 = B0.d(1, parameterizedType4);
            if (okhttp3.D.class.isAssignableFrom(B0.e(typeD6))) {
                throw B0.h(method, i5, "@PartMap values cannot be MultipartBody.Part. Use @Part List<Part> or a different value type instead.", new Object[0]);
            }
            return new C1602a0(method, i5, u0Var.nextRequestBodyConverter(null, typeD6, annotationArr, annotationArr2), ((A5.r) annotation).encoding());
        }
        if (annotation instanceof A5.a) {
            d(i5, type);
            if (this.f8150p || this.f8151q) {
                throw B0.h(method, i5, "@Body parameters cannot be used with form or multi-part encoding.", new Object[0]);
            }
            if (this.f8143i) {
                throw B0.h(method, i5, "Multiple @Body method annotations found.", new Object[0]);
            }
            try {
                InterfaceC1621t interfaceC1621tNextRequestBodyConverter = u0Var.nextRequestBodyConverter(null, type, annotationArr, annotationArr2);
                this.f8143i = true;
                return new T(method, i5, interfaceC1621tNextRequestBodyConverter);
            } catch (RuntimeException e) {
                throw B0.i(method, e, i5, "Unable to create @Body converter for %s", type);
            }
        }
        if (!(annotation instanceof A5.x)) {
            return null;
        }
        d(i5, type);
        Class clsE10 = B0.e(type);
        for (int i6 = i5 - 1; i6 >= 0; i6--) {
            i0 i0Var = this.parameterHandlers[i6];
            if ((i0Var instanceof h0) && ((h0) i0Var).f8129a.equals(clsE10)) {
                StringBuilder sb = new StringBuilder("@Tag type ");
                androidx.collection.a.w(clsE10, sb, " is duplicate of ");
                sb.append(j0.f8130a.a(method, i6));
                sb.append(" and would always overwrite its value.");
                throw B0.h(method, i5, sb.toString(), new Object[0]);
            }
        }
        return new h0(clsE10);
    }

    public final q0 b() {
        Annotation[] annotationArr = this.d;
        int length = annotationArr.length;
        int i5 = 0;
        while (true) {
            Method method = this.c;
            if (i5 >= length) {
                if (this.httpMethod == null) {
                    throw B0.methodError(method, null, "HTTP method annotation is required (e.g., @GET, @POST, etc.).", new Object[0]);
                }
                if (!this.f8149o) {
                    if (this.f8151q) {
                        throw B0.methodError(method, null, "Multipart can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                    }
                    if (this.f8150p) {
                        throw B0.methodError(method, null, "FormUrlEncoded can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                    }
                }
                Annotation[][] annotationArr2 = this.e;
                int length2 = annotationArr2.length;
                this.parameterHandlers = new i0[length2];
                int i6 = length2 - 1;
                int i7 = 0;
                while (i7 < length2) {
                    this.parameterHandlers[i7] = parseParameter(i7, this.f8140f[i7], annotationArr2[i7], i7 == i6);
                    i7++;
                }
                if (this.relativeUrl == null && !this.f8148n) {
                    throw B0.methodError(method, null, "Missing either @%s URL or @Url parameter.", this.httpMethod);
                }
                boolean z6 = this.f8150p;
                if (!z6 && !this.f8151q && !this.f8149o && this.f8143i) {
                    throw B0.methodError(method, null, "Non-body HTTP method cannot contain @Body.", new Object[0]);
                }
                if (z6 && !this.f8141g) {
                    throw B0.methodError(method, null, "Form-encoded method must contain at least one @Field.", new Object[0]);
                }
                if (!this.f8151q || this.f8142h) {
                    return new q0(this);
                }
                throw B0.methodError(method, null, "Multipart method must contain at least one @Part.", new Object[0]);
            }
            Annotation annotation = annotationArr[i5];
            if (annotation instanceof A5.b) {
                c("DELETE", ((A5.b) annotation).value(), false);
            } else if (annotation instanceof A5.f) {
                c(ShareTarget.METHOD_GET, ((A5.f) annotation).value(), false);
            } else if (annotation instanceof A5.g) {
                c("HEAD", ((A5.g) annotation).value(), false);
            } else if (annotation instanceof A5.n) {
                c("PATCH", ((A5.n) annotation).value(), true);
            } else if (annotation instanceof A5.o) {
                c(ShareTarget.METHOD_POST, ((A5.o) annotation).value(), true);
            } else if (annotation instanceof A5.p) {
                c("PUT", ((A5.p) annotation).value(), true);
            } else if (annotation instanceof A5.m) {
                c("OPTIONS", ((A5.m) annotation).value(), false);
            } else if (annotation instanceof A5.h) {
                A5.h hVar = (A5.h) annotation;
                c(hVar.method(), hVar.path(), hVar.hasBody());
            } else if (annotation instanceof A5.k) {
                A5.k kVar = (A5.k) annotation;
                String[] strArrValue = kVar.value();
                if (strArrValue.length == 0) {
                    throw B0.methodError(method, null, "@Headers annotation is empty.", new Object[0]);
                }
                boolean zAllowUnsafeNonAsciiValues = kVar.allowUnsafeNonAsciiValues();
                C1375v c1375v = new C1375v();
                for (String str : strArrValue) {
                    int iIndexOf = str.indexOf(58);
                    if (iIndexOf == -1 || iIndexOf == 0 || iIndexOf == str.length() - 1) {
                        throw B0.methodError(method, null, "@Headers value must be in the form \"Name: Value\". Found: \"%s\"", str);
                    }
                    String strSubstring = str.substring(0, iIndexOf);
                    String strTrim = str.substring(iIndexOf + 1).trim();
                    if (HttpHeaders.CONTENT_TYPE.equalsIgnoreCase(strSubstring)) {
                        try {
                            this.contentType = okhttp3.B.a(strTrim);
                        } catch (IllegalArgumentException e) {
                            throw B0.methodError(method, e, "Malformed content type: %s", strTrim);
                        }
                    } else if (zAllowUnsafeNonAsciiValues) {
                        C1376w.a(strSubstring);
                        c1375v.b(strSubstring, strTrim);
                    } else {
                        c1375v.a(strSubstring, strTrim);
                    }
                }
                this.headers = new C1376w(c1375v);
            } else if (annotation instanceof A5.l) {
                if (this.f8150p) {
                    throw B0.methodError(method, null, "Only one encoding annotation is allowed.", new Object[0]);
                }
                this.f8151q = true;
            } else if (!(annotation instanceof A5.e)) {
                continue;
            } else {
                if (this.f8151q) {
                    throw B0.methodError(method, null, "Only one encoding annotation is allowed.", new Object[0]);
                }
                this.f8150p = true;
            }
            i5++;
        }
    }

    public final void c(String str, String str2, boolean z6) {
        String str3 = this.httpMethod;
        Method method = this.c;
        if (str3 != null) {
            throw B0.methodError(method, null, "Only one HTTP method is allowed. Found: %s and %s.", str3, str);
        }
        this.httpMethod = str;
        this.f8149o = z6;
        if (str2.isEmpty()) {
            return;
        }
        int iIndexOf = str2.indexOf(63);
        Pattern pattern = f8137s;
        if (iIndexOf != -1 && iIndexOf < str2.length() - 1) {
            String strSubstring = str2.substring(iIndexOf + 1);
            if (pattern.matcher(strSubstring).find()) {
                throw B0.methodError(method, null, "URL query string \"%s\" must not have replace block. For dynamic query parameters use @Query.", strSubstring);
            }
        }
        this.relativeUrl = str2;
        Matcher matcher = pattern.matcher(str2);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        while (matcher.find()) {
            linkedHashSet.add(matcher.group(1));
        }
        this.relativeUrlParamNames = linkedHashSet;
    }

    public final void d(int i5, Type type) {
        if (B0.hasUnresolvableType(type)) {
            throw B0.h(this.c, i5, "Parameter type must not include a type variable or wildcard: %s", type);
        }
    }
}
