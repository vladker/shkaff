package p073n;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import p050j.d;
import p067m.b;
import p079o.G;
import p079o.Q;
import p096r.j;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class q implements Q, p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f6207a = new q();

    @Override // p073n.p
    public final int a() {
        return 12;
    }

    @Override // p073n.p
    public final Object b(b bVar, Type type, Object obj) {
        if (type == OptionalInt.class) {
            Integer numK = j.k(bVar.l(null, Integer.class));
            return numK == null ? OptionalInt.empty() : OptionalInt.of(numK.intValue());
        }
        if (type == OptionalLong.class) {
            Long lM = j.m(bVar.l(null, Long.class));
            return lM == null ? OptionalLong.empty() : OptionalLong.of(lM.longValue());
        }
        if (type == OptionalDouble.class) {
            Double dI = j.i(bVar.l(null, Double.class));
            return dI == null ? OptionalDouble.empty() : OptionalDouble.of(dI.doubleValue());
        }
        if (!j.f7924h) {
            try {
                j.f7925i = Class.forName("java.util.Optional");
            } catch (Exception unused) {
            } finally {
                j.f7924h = true;
            }
        }
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            if (parameterizedType.getRawType() == j.f7925i) {
                type = parameterizedType.getActualTypeArguments()[0];
            }
        }
        Object objL = bVar.l(null, type);
        return objL == null ? Optional.empty() : Optional.of(objL);
    }

    @Override // p079o.Q, p079o.InterfaceC1290t
    public void write(G g6, Object obj, Object obj2, Type type, int i5) {
        if (obj == null) {
            g6.f6325j.n();
            return;
        }
        if (obj instanceof Optional) {
            Optional optional = (Optional) obj;
            g6.h(optional.isPresent() ? optional.get() : null);
            return;
        }
        if (obj instanceof OptionalDouble) {
            OptionalDouble optionalDouble = (OptionalDouble) obj;
            if (optionalDouble.isPresent()) {
                g6.h(Double.valueOf(optionalDouble.getAsDouble()));
                return;
            } else {
                g6.f6325j.n();
                return;
            }
        }
        if (obj instanceof OptionalInt) {
            OptionalInt optionalInt = (OptionalInt) obj;
            if (optionalInt.isPresent()) {
                g6.f6325j.l(optionalInt.getAsInt());
                return;
            } else {
                g6.f6325j.n();
                return;
            }
        }
        if (!(obj instanceof OptionalLong)) {
            throw new d("not support optional : " + obj.getClass());
        }
        OptionalLong optionalLong = (OptionalLong) obj;
        if (optionalLong.isPresent()) {
            g6.f6325j.m(optionalLong.getAsLong());
        } else {
            g6.f6325j.n();
        }
    }
}
