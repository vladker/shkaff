package p073n;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import p050j.a;
import p050j.d;
import p067m.b;
import p067m.g;
import p067m.h;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public abstract class c extends f {
    @Override // p073n.f, p073n.p
    public final Object b(b bVar, Type type, Object obj) {
        return c(bVar, type, obj, null);
    }

    @Override // p073n.f
    public final Object c(b bVar, Type type, Object obj, String str) {
        Object objH;
        SimpleDateFormat simpleDateFormat;
        Object obj2;
        Object time;
        g gVar = bVar.e;
        int i5 = gVar.f6092a;
        if (i5 == 2) {
            Object objValueOf = Long.valueOf(gVar.longValue());
            gVar.n(16);
            objH = objValueOf;
        } else {
            Object obj3 = null;
            if (i5 == 4) {
                String strJ = gVar.J();
                if (str != null) {
                    try {
                        simpleDateFormat = new SimpleDateFormat(str);
                    } catch (IllegalArgumentException unused) {
                        if (str.equals("yyyy-MM-ddTHH:mm:ss.SSS")) {
                            str = "yyyy-MM-dd'T'HH:mm:ss.SSS";
                            simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
                        } else if (str.equals("yyyy-MM-ddTHH:mm:ss")) {
                            str = "yyyy-MM-dd'T'HH:mm:ss";
                            simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                        } else {
                            simpleDateFormat = null;
                        }
                    }
                    try {
                        obj3 = simpleDateFormat.parse(strJ);
                    } catch (ParseException unused2) {
                        if (str.equals("yyyy-MM-dd'T'HH:mm:ss.SSS") && strJ.length() == 19) {
                            try {
                                obj3 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(strJ);
                            } catch (ParseException unused3) {
                            }
                        }
                    }
                }
                if (obj3 == null) {
                    gVar.n(16);
                    if (gVar.i(p067m.c.AllowISO8601DateFormat.f6089a)) {
                        g gVar2 = new g(strJ);
                        if (gVar2.Q(true)) {
                            obj2 = strJ;
                            time = strJ;
                            time = gVar2.f6097j.getTime();
                        }
                        obj2 = strJ;
                        time = strJ;
                        gVar2.close();
                        obj2 = time;
                    }
                    obj2 = strJ;
                    objH = obj2;
                } else {
                    objH = obj3;
                }
            } else if (i5 == 8) {
                gVar.m();
                objH = obj3;
            } else if (i5 == 12) {
                gVar.m();
                if (gVar.f6092a != 4) {
                    throw new d("syntax error");
                }
                if (a.c.equals(gVar.J())) {
                    gVar.m();
                    bVar.a(17);
                    Type typeA = bVar.b.a(null, gVar.J());
                    if (typeA != null) {
                        type = typeA;
                    }
                    bVar.a(4);
                    bVar.a(16);
                }
                gVar.o();
                if (gVar.f6092a != 2) {
                    throw new d("syntax error : ".concat(h.a(gVar.f6092a)));
                }
                long jLongValue = gVar.longValue();
                gVar.m();
                Object objValueOf2 = Long.valueOf(jLongValue);
                bVar.a(13);
                objH = objValueOf2;
            } else if (bVar.f6071j == 2) {
                bVar.f6071j = 0;
                bVar.a(16);
                if (gVar.f6092a != 4) {
                    throw new d("syntax error");
                }
                if (!"val".equals(gVar.J())) {
                    throw new d("syntax error");
                }
                gVar.m();
                bVar.a(17);
                Object objH2 = bVar.h(null);
                bVar.a(13);
                objH = objH2;
            } else {
                objH = bVar.h(null);
            }
        }
        return d(bVar, type, objH);
    }

    public abstract Object d(b bVar, Type type, Object obj);
}
