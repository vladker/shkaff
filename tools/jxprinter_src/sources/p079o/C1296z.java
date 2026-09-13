package p079o;

import A3.AbstractC0157z;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import org.apache.logging.log4j.message.ParameterizedMessage;
import p050j.a;
import p055k.b;
import p073n.o;
import p096r.d;
import xyz.doikki.videoplayer.player.k;

/* JADX INFO: renamed from: o.z, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class C1296z implements Comparable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f6425a;
    public final boolean b;
    public final int c;
    public final String d;
    public String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f6426f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final C1281j f6427g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f6428h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f6429i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f6430j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f6431k = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public k f6432l;

    public C1296z(d dVar) {
        boolean z6;
        boolean z7 = false;
        this.f6429i = false;
        this.f6430j = false;
        this.f6425a = dVar;
        this.f6427g = new C1281j(dVar);
        dVar.setAccessible();
        this.d = AbstractC0157z.s(new StringBuilder("\""), dVar.f7884a, "\":");
        b bVarC = dVar.c();
        if (bVarC != null) {
            c0[] c0VarArrSerialzeFeatures = bVarC.serialzeFeatures();
            int length = c0VarArrSerialzeFeatures.length;
            int i5 = 0;
            while (true) {
                if (i5 >= length) {
                    z6 = false;
                    break;
                } else {
                    if ((c0VarArrSerialzeFeatures[i5].f6406a & c0.f6383G) != 0) {
                        z6 = true;
                        break;
                    }
                    i5++;
                }
            }
            String str = bVarC.format();
            this.f6428h = str;
            if (str.trim().length() == 0) {
                this.f6428h = null;
            }
            for (c0 c0Var : bVarC.serialzeFeatures()) {
                if (c0Var == c0.WriteEnumUsingToString) {
                    this.f6429i = true;
                } else if (c0Var == c0.WriteEnumUsingName) {
                    this.f6430j = true;
                }
            }
            this.c = c0.a(bVarC.serialzeFeatures());
            z7 = z6;
        }
        this.b = z7;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return this.f6425a.compareTo(((C1296z) obj).f6425a);
    }

    public Object getPropertyValue(Object obj) {
        d dVar = this.f6425a;
        Object obj2 = dVar.get(obj);
        String str = this.f6428h;
        if (str == null || obj2 == null || dVar.e != Date.class) {
            return obj2;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
        simpleDateFormat.setTimeZone(a.f5372a);
        return simpleDateFormat.format(obj2);
    }

    public Object getPropertyValueDirect(Object obj) {
        return this.f6425a.get(obj);
    }

    public void writePrefix(G g6) {
        b0 b0Var = g6.f6325j;
        boolean z6 = b0Var.e;
        d dVar = this.f6425a;
        if (!z6) {
            if (this.f6426f == null) {
                this.f6426f = AbstractC0157z.s(new StringBuilder(), dVar.f7884a, ParameterizedMessage.ERROR_MSG_SEPARATOR);
            }
            b0Var.write(this.f6426f);
        } else {
            if (!b0Var.d) {
                b0Var.write(this.d);
                return;
            }
            if (this.e == null) {
                this.e = AbstractC0157z.s(new StringBuilder("'"), dVar.f7884a, "':");
            }
            b0Var.write(this.e);
        }
    }

    /* JADX WARN: Code duplicated, block: B:24:0x005a  */
    public void writeValue(G g6, Object obj) {
        Q qB;
        k kVar = this.f6432l;
        String str = this.f6428h;
        d dVar = this.f6425a;
        if (kVar == null) {
            Class<?> cls = obj == null ? dVar.e : obj.getClass();
            b bVarC = dVar.c();
            if (bVarC == null || bVarC.serializeUsing() == Void.class) {
                if (str == null) {
                    qB = null;
                } else if (cls == Double.TYPE || cls == Double.class) {
                    DecimalFormat decimalFormat = new DecimalFormat(str);
                    C1293w c1293w = new C1293w();
                    c1293w.f6422a = decimalFormat;
                    qB = c1293w;
                } else if (cls == Float.TYPE || cls == Float.class) {
                    DecimalFormat decimalFormat2 = new DecimalFormat(str);
                    A a6 = new A();
                    a6.f6319a = decimalFormat2;
                    qB = a6;
                } else {
                    qB = null;
                }
                if (qB == null) {
                    qB = g6.f6324i.b(cls);
                }
            } else {
                qB = (Q) bVarC.serializeUsing().newInstance();
                this.f6431k = true;
            }
            this.f6432l = new k(qB, 4, cls, false);
        }
        k kVar2 = this.f6432l;
        int i5 = dVar.f7888i;
        if (obj == null) {
            Class cls2 = (Class) kVar2.c;
            b0 b0Var = g6.f6325j;
            boolean zIsAssignableFrom = Number.class.isAssignableFrom(cls2);
            int i6 = this.c;
            if (zIsAssignableFrom) {
                b0Var.o(i6, c0.WriteNullNumberAsZero.f6406a);
                return;
            }
            if (String.class == cls2) {
                b0Var.o(i6, c0.WriteNullStringAsEmpty.f6406a);
                return;
            }
            if (Boolean.class == cls2) {
                b0Var.o(i6, c0.WriteNullBooleanAsFalse.f6406a);
                return;
            }
            if (Collection.class.isAssignableFrom(cls2)) {
                b0Var.o(i6, c0.WriteNullListAsEmpty.f6406a);
                return;
            }
            Q q6 = (Q) kVar2.b;
            if ((c0.f6383G & b0Var.c) == 0 || !(q6 instanceof H)) {
                q6.write(g6, null, dVar.f7884a, dVar.f7885f, i5);
                return;
            } else {
                b0Var.n();
                return;
            }
        }
        if (dVar.f7893n) {
            if (this.f6430j) {
                g6.f6325j.q(((Enum) obj).name());
                return;
            } else if (this.f6429i) {
                g6.f6325j.q(((Enum) obj).toString());
                return;
            }
        }
        Class<?> cls3 = obj.getClass();
        Q qB2 = (cls3 == ((Class) kVar2.c) || this.f6431k) ? (Q) kVar2.b : g6.f6324i.b(cls3);
        if (str == null || (qB2 instanceof C1293w) || (qB2 instanceof A)) {
            if (dVar.f7895p && (qB2 instanceof H)) {
                ((H) qB2).write(g6, obj, dVar.f7884a, dVar.f7885f, i5, true);
                return;
            } else {
                qB2.write(g6, obj, dVar.f7884a, dVar.f7885f, i5);
                return;
            }
        }
        if (qB2 instanceof InterfaceC1290t) {
            ((o) ((InterfaceC1290t) qB2)).write(g6, obj, this.f6427g);
            return;
        }
        if (!(obj instanceof Date)) {
            g6.h(obj);
            return;
        }
        SimpleDateFormat simpleDateFormat = g6.f6329n;
        TimeZone timeZone = g6.f6332q;
        Locale locale = g6.f6333r;
        if (simpleDateFormat == null && g6.f6328m != null) {
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(g6.f6328m, locale);
            g6.f6329n = simpleDateFormat2;
            simpleDateFormat2.setTimeZone(timeZone);
        }
        SimpleDateFormat simpleDateFormat3 = g6.f6329n;
        if (simpleDateFormat3 == null) {
            simpleDateFormat3 = new SimpleDateFormat(str, locale);
            simpleDateFormat3.setTimeZone(timeZone);
        }
        g6.f6325j.q(simpleDateFormat3.format((Date) obj));
    }
}
