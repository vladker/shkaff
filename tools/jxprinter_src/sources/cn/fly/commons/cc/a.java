package cn.fly.commons.cc;

import android.content.Context;
import android.content.pm.PackageManager;
import cn.fly.tools.FlyHandlerThread;
import cn.fly.tools.network.NetCommunicator;
import cn.fly.tools.network.NetworkHelper;
import cn.fly.tools.utils.FlyPersistence;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final r f1367a = new r();
    private static final j b = new j();
    private static final o c = new o();
    private static final b d = new b();
    private static volatile m e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static volatile m f1368f;

    static {
        try {
            e = new m(new m.a() { // from class: cn.fly.commons.cc.a.1
                @Override // cn.fly.commons.cc.m.a
                public Object a(String str, ArrayList<Object> arrayList) {
                    try {
                        if (a.f1368f != null) {
                            return a.f1368f.a(str, arrayList);
                        }
                        return null;
                    } catch (Throwable unused) {
                        return null;
                    }
                }
            });
            f1368f = new m(new m.a() { // from class: cn.fly.commons.cc.a.2
                @Override // cn.fly.commons.cc.m.a
                public Object a(String str, ArrayList<Object> arrayList) {
                    return str + "" + arrayList;
                }
            });
            e.a("tt", null);
        } catch (Throwable unused) {
        }
    }

    public static int a() {
        return x.a();
    }

    private static boolean c() {
        try {
            return cn.fly.commons.q.f();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void a(Context context, byte[] bArr, String str, Method method) throws Throwable {
        a(x.a(bArr), context, str, method);
    }

    public static void a(Context context, String str, String str2, Method method) throws Throwable {
        a(x.a(str), context, str2, method);
    }

    public static void a(Context context, String str, String str2, HashMap<String, Object> map, HashMap<String, Object> map2) throws Throwable {
        x.c cVarA = x.a(str);
        cVarA.a("ss_dhMap", map).a("ss_dataMaps", map2);
        a(cVarA, context, str2, (Method) null);
    }

    public static LinkedList<Object> a(Object obj, Object... objArr) {
        return ((z) obj).b(objArr);
    }

    private static void a(x.c cVar, Context context, String str, Method method) throws Throwable {
        cVar.a(cn.fly.commons.o.a("012DghPjf^dj@di$didkMe<el(fi"), j.class).a(cn.fly.commons.o.a("003Uhcegfc"), e.class).a("SBSP", o.class).a(cn.fly.commons.o.a("004Ehcelglfk"), g.class).a(cn.fly.commons.o.a("015Gelfjfk7deSdcJgfWdjfc<hDdj fdEdc"), FlyHandlerThread.class).a(cn.fly.commons.o.a("0191elfjfjdjdkYd[dc)cd9fi(i$gjBfcf4diddLf.dj"), i.class).a(cn.fly.commons.o.a("017=elfjeddk%eifei=gj1fSfidk;g.ddWf!dj"), l.class).a(cn.fly.commons.o.a("019?elfjel*f8djdddi_cf,eddkGeefci*didk+e"), p.class).a(cn.fly.commons.o.a("017Uelfjeddk1eifei*ghfffi-f2djdd3f[dj"), k.class).a(cn.fly.commons.o.a("017'elfjegJfi<fgdkdjehedTdgg0ffYdc.eh"), n.class).a(cn.fly.commons.o.a("009Gelfjfk!de2dcSgfQdj"), m.class).a(cn.fly.commons.o.a("003_hceged"), NetCommunicator.class).a(cn.fly.commons.o.a("004%hcegfcgh"), NetworkHelper.NetworkTimeOut.class).a("NoVaDataException", FlyPersistence.NoValidDataException.class).a(cn.fly.commons.o.a("0032fkdkee"), cn.fly.commons.t.class).a("HGENV", b.class).a(i.class, i.class).a(k.class, k.class).a(p.class, q.class).a(n.class, n.class).a(r.class, r.class).a(j.class, j.class).a(e.class, e.class).a(g.class, h.class).a(Context.class, d.class).a(PackageManager.class, f.class).a(o.class, o.class).a(cn.fly.commons.t.class, c.class).a(b.class, b.class).a("ss_sdh", c).a("ss_opSet", b).a("ss_suls", f1367a).a(cn.fly.commons.o.a("015Rfifidh@cUdkAeif;eiOi%gl@d6djVdUdf"), context).a(cn.fly.commons.o.a("0141fifidhfi-id)dj[iXglIdTdjHdYdffi"), str).a(cn.fly.commons.o.a("012Lfifidhfi.idNdj1i>fcdidf_f"), Long.valueOf(System.currentTimeMillis())).a(cn.fly.commons.o.a("006Ffifidhdfdc)j"), method).a("ss_nrSpt", Boolean.valueOf(c())).a("ss_hgentv", d).a(cn.fly.commons.o.a("016cTdkdfdfdk1edj?dlfidcehdlUc:dc%c"));
        cVar.a();
    }
}
