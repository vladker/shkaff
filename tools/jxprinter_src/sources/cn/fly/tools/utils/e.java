package cn.fly.tools.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.GnssStatus;
import android.os.Handler;
import cn.fly.FlySDK;
import cn.fly.commons.CSCenter;
import cn.fly.commons.a.l;
import cn.fly.tools.FlyLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"MissingPermission"})
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static e f1956a;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Object f1957j = new Object();
    private volatile Object d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile Class<?> f1958f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f1959g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private a f1960h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private volatile Object f1961i;
    private volatile List b = new ArrayList();
    private volatile List c = new ArrayList();
    private volatile Object e = g();

    public interface a {
        void a();
    }

    private e() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object f() {
        HashMap map = new HashMap();
        final int iIdentityHashCode = System.identityHashCode(map);
        map.put(l.a("018Nel7f%je'kNgjfmVjejQehgjfePiefYfkYg3ed"), new ReflectHelper.a<Object[], Object>() { // from class: cn.fly.tools.utils.e.2
            @Override // cn.fly.tools.utils.ReflectHelper.a
            public Object a(Object[] objArr) {
                if (objArr == null || ((Integer) objArr[0]).intValue() != 4) {
                    return null;
                }
                e.this.i();
                return null;
            }
        });
        map.put("equals", new ReflectHelper.a<Object[], Object>() { // from class: cn.fly.tools.utils.e.3
            @Override // cn.fly.tools.utils.ReflectHelper.a
            public Object a(Object[] objArr) {
                if (objArr != null) {
                    Object obj = objArr[0];
                    if (obj != null) {
                        return Boolean.valueOf(obj.hashCode() == iIdentityHashCode);
                    }
                }
                return Boolean.FALSE;
            }
        });
        map.put(l.a("008ie<gjOi6feeledWg"), new ReflectHelper.a<Object[], Object>() { // from class: cn.fly.tools.utils.e.4
            @Override // cn.fly.tools.utils.ReflectHelper.a
            public Object a(Object[] objArr) {
                return Integer.valueOf(iIdentityHashCode);
            }
        });
        return ReflectHelper.createProxy((Map<String, ReflectHelper.a<Object[], Object>>) map, (Class<?>[]) new Class[]{Class.forName(l.a("026ef:edekelejedem<hXelHdejQejel_fNemje;k,gjfmWjejYehgj") + "$" + l.a("008Ogfejgj]jgfgAek"))});
    }

    private Object g() {
        HashMap map = new HashMap();
        final int iIdentityHashCode = System.identityHashCode(map);
        try {
            map.put(l.a("017^el>f@gfelPdejKejelAfNfe1ief9fkHgKed"), new ReflectHelper.a<Object[], Object>() { // from class: cn.fly.tools.utils.e.5
                @Override // cn.fly.tools.utils.ReflectHelper.a
                public Object a(Object[] objArr) {
                    Object obj;
                    if (objArr != null) {
                        try {
                            if (objArr.length > 0) {
                                FlyLog.getInstance().d("[212] oncge" + objArr[0], new Object[0]);
                                Object obj2 = objArr[0];
                                if (obj2 instanceof List) {
                                    e.this.c.addAll((List) obj2);
                                } else {
                                    e.this.c.add(objArr[0]);
                                }
                            }
                        } catch (Throwable th) {
                            try {
                                FlyLog.getInstance().d(th);
                                synchronized (obj) {
                                    return null;
                                }
                            } finally {
                                synchronized (e.f1957j) {
                                    e.f1957j.notifyAll();
                                }
                            }
                        }
                    }
                    e.this.j();
                    synchronized (e.f1957j) {
                        e.f1957j.notifyAll();
                    }
                    return null;
                }
            });
            map.put("equals", new ReflectHelper.a<Object[], Object>() { // from class: cn.fly.tools.utils.e.6
                @Override // cn.fly.tools.utils.ReflectHelper.a
                public Object a(Object[] objArr) {
                    Object obj;
                    FlyLog.getInstance().d(androidx.exifinterface.media.a.p("equals ", objArr), new Object[0]);
                    if (objArr == null || (obj = objArr[0]) == null) {
                        return Boolean.FALSE;
                    }
                    return Boolean.valueOf(obj.hashCode() == iIdentityHashCode);
                }
            });
            map.put(l.a("008ieFgj.i.feeled]g"), new ReflectHelper.a<Object[], Object>() { // from class: cn.fly.tools.utils.e.7
                @Override // cn.fly.tools.utils.ReflectHelper.a
                public Object a(Object[] objArr) {
                    FlyLog.getInstance().d(l.a("008ie6gj7iWfeeled<g"), new Object[0]);
                    return Integer.valueOf(iIdentityHashCode);
                }
            });
            return ReflectHelper.createProxy((Map<String, ReflectHelper.a<Object[], Object>>) map, (Class<?>[]) new Class[]{k()});
        } catch (Throwable th) {
            FlyLog.getInstance().d(th);
            return null;
        }
    }

    private GnssStatus.Callback h() {
        if (DH.SyncMtd.getOSVersionIntForFly() >= 31) {
            return new GnssStatus.Callback() { // from class: cn.fly.tools.utils.e.8
                @Override // android.location.GnssStatus.Callback
                public void onSatelliteStatusChanged(GnssStatus gnssStatus) {
                    super.onSatelliteStatusChanged(gnssStatus);
                    e.this.i();
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        try {
            a aVar = this.f1960h;
            if (aVar != null) {
                aVar.a();
            }
        } catch (Throwable th) {
            FlyLog.getInstance().d(th, "%s", "[cl]");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (this.e != null) {
            ReflectHelper.invokeInstanceMethod(this.d, l.a("013-ek.g@egeleeEg]flLkUed@ejg5gj"), new Object[]{this.e}, new Class[]{k()}, null);
        }
    }

    private Class<?> k() {
        if (this.f1958f == null) {
            try {
                this.f1958f = Class.forName(l.a("033efBedekelejedemQh1el6dej?ejelAf^emgfel0dejJejelBf'gfejgjFjgfgDek"));
            } catch (Throwable unused) {
            }
        }
        return this.f1958f;
    }

    public static e a() {
        if (f1956a == null) {
            synchronized (e.class) {
                try {
                    if (f1956a == null) {
                        f1956a = new e();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f1956a;
    }

    private Object b(String str) {
        if (DH.SyncMtd.getOSVersionIntForFly() <= 25) {
            return cn.fly.tools.b.e.a(FlySDK.getContext()).b(str);
        }
        try {
            return cn.fly.tools.b.i.a(FlySDK.getContext(), str);
        } catch (Throwable unused) {
            return cn.fly.tools.b.e.a(FlySDK.getContext()).b(str);
        }
    }

    private void e() {
        if (cn.fly.commons.e.g()) {
            try {
                if (DH.SyncMtd.checkPermission(l.a("039ef$edekelejedem8kg_ekegejgjgjejelKf0emgefefehjfmfmeihdfffhhjeigfhifegegdffhifh"))) {
                    if (this.d == null) {
                        this.d = DH.SyncMtd.getSystemServiceSafe(l.a("008hKel>dej+ejel:f"));
                    }
                    if (this.d == null) {
                        return;
                    }
                    if (DH.SyncMtd.getOSVersionIntForFly() < 31 && FlySDK.getContext().getApplicationInfo().targetSdkVersion < 31) {
                        l.a().b().post(new Runnable() { // from class: cn.fly.tools.utils.e.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    ReflectHelper.invokeInstanceMethod(e.this.d, l.a("020eQededje,k]gjfmNjejIehgjgfejgj8jgfgKek"), new Object[]{e.this.f()}, new Class[]{Class.forName(l.a("026efLedekelejedemRh>el6dej:ejelIf[emjeRkVgjfmFjej^ehgj") + "$" + l.a("008(gfejgj+jgfg6ek"))});
                                    FlyLog.getInstance().d("[212] rg < 31", new Object[0]);
                                } catch (Throwable th) {
                                    FlyLog.getInstance().d(th, "%s", "[cl]");
                                }
                            }
                        });
                    } else if (DH.SyncMtd.getOSVersionIntForFly() >= 31) {
                        ReflectHelper.invokeInstanceMethod(this.d, l.a("026RekVgIfkejgj5jg9ekje)f9gjgjfmJjejIehgjfe.ehhWgg*ed-fi"), new Object[]{h(), l.a().b()}, new Class[]{GnssStatus.Callback.class, Handler.class});
                        FlyLog.getInstance().d("[212] rg >= 31", new Object[0]);
                    }
                }
            } catch (Throwable th) {
                FlyLog.getInstance().d(th, "%s", "[212]");
            }
        }
    }

    public Object c() {
        return b(l.a("003+fk:k%gj"));
    }

    private void b(Context context, String str, long j6) {
        if (cn.fly.commons.e.e()) {
            try {
                cn.fly.tools.b.e.a(context).a(str, 1000L, 0.0f, this.e);
                f1957j.wait(j6);
            } catch (Throwable th) {
                FlyLog.getInstance().d(th);
            }
            j();
        }
    }

    public void a(a aVar) {
        this.f1960h = aVar;
        e();
    }

    public List a(Context context, int i5, int i6, boolean z6, boolean z7) {
        ArrayList arrayList = new ArrayList();
        if (CSCenter.getInstance().isLocationDataEnable()) {
            arrayList.addAll(a(z7));
            if (!arrayList.isEmpty()) {
                return arrayList;
            }
            synchronized (f1957j) {
                try {
                    arrayList.addAll(a(z7));
                    if (arrayList.isEmpty()) {
                        arrayList.addAll(a(context, i5, i6, z6));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return arrayList;
        }
        arrayList.add(CSCenter.getInstance().getLocation());
        return arrayList;
    }

    public Object b() {
        return this.f1961i;
    }

    private List a(Context context, int i5, int i6, boolean z6) {
        Object objB;
        Object objB2;
        ArrayList arrayList = new ArrayList();
        try {
            if (DH.SyncMtd.checkPermission(l.a("039efNedekelejedemCkg>ekegejgjgjejel'f3emgefefehjfmfmeihdfffhhjeigfhifegegdffhifh")) || DH.SyncMtd.checkPermission(l.a("041efKedekelejedemIkgJekegejgjgjejelTf!emgefefehjfmfmeifehigehkfmhjeigfhifegegdffhifh"))) {
                if (this.d == null) {
                    this.d = DH.SyncMtd.getSystemServiceSafe(l.a("008h^elQdej0ejelDf"));
                }
                if (this.d == null) {
                    return null;
                }
                synchronized (f1957j) {
                    if (i5 != 0) {
                        try {
                            if (a(this.d, l.a("003HfkSk gj"))) {
                                a(context, l.a("0033fkQk*gj"), i5 * 1000);
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    if (i6 != 0 && a(this.d, l.a("007fgj4ghelekfi"))) {
                        a(context, l.a("007fgjFghelekfi"), i6 * 1000);
                    }
                }
            }
            if (this.c.isEmpty() && z6) {
                Object objB3 = b(l.a("003;fkPk<gj"));
                if (objB3 != null) {
                    this.c.add(objB3);
                }
                if (this.c.isEmpty() && (objB2 = b(l.a("007fgj[ghelekfi"))) != null) {
                    this.c.add(objB2);
                }
                if (this.c.isEmpty() && (objB = b("passive")) != null) {
                    this.c.add(objB);
                }
            }
            if (!this.c.isEmpty()) {
                for (Object obj : this.c) {
                    if (obj != null) {
                        this.b.add(ReflectHelper.newInstance(ReflectHelper.importClass(l.a("025efSedekelejedem,hCel]dej'ejelMf(emgfel!dej)ejelHf")), obj));
                        arrayList.add(ReflectHelper.newInstance(ReflectHelper.importClass(l.a("025efOedekelejedemFhGelMdej[ejelWf emgfel<dej^ejel1f")), obj));
                    }
                }
                this.f1959g = System.currentTimeMillis();
                this.c.clear();
            }
            return arrayList;
        } catch (Throwable th2) {
            FlyLog.getInstance().d(th2);
            return arrayList;
        }
    }

    private void a(Context context, String str, long j6) {
        if (DH.SyncMtd.getOSVersionIntForFly() <= 25) {
            b(context, str, j6);
            return;
        }
        try {
            Object objA = cn.fly.tools.b.i.a(context, str, j6);
            if (objA != null) {
                this.c.add(objA);
            }
        } catch (Throwable th) {
            FlyLog.getInstance().d(androidx.exifinterface.media.a.n("[212] cur err ", th), new Object[0]);
            b(context, str, j6);
        }
    }

    private boolean a(Object obj, String str) {
        return cn.fly.commons.e.e() && ((Boolean) ReflectHelper.invokeInstanceMethodNoThrow(obj, l.a("017GejgjhmekeleeejedLg8ekhj-fe8gg6hg]ed"), Boolean.FALSE, str)).booleanValue();
    }

    private List a(boolean z6) {
        ArrayList arrayList = new ArrayList();
        if (!z6) {
            try {
                if (!this.b.isEmpty() && System.currentTimeMillis() - this.f1959g <= 180000) {
                    for (Object obj : this.b) {
                        if (obj != null) {
                            arrayList.add(ReflectHelper.newInstance(ReflectHelper.importClass(l.a("025ef2edekelejedemBh1elSdej!ejel-f:emgfel$dejWejelXf")), obj));
                        }
                    }
                    return arrayList;
                }
            } catch (Throwable th) {
                FlyLog.getInstance().d(th);
                return arrayList;
            }
        }
        this.b.clear();
        return arrayList;
    }

    public void a(Object obj) {
        if (obj != null) {
            this.f1961i = obj;
        }
    }

    public boolean a(String str) {
        if (l.a("003UfkPkBgj").equalsIgnoreCase(str) && DH.SyncMtd.checkPermission(l.a("039efQedekelejedem[kgWekegejgjgjejelIf$emgefefehjfmfmeihdfffhhjeigfhifegegdffhifh"))) {
            return true;
        }
        if (l.a("007fgj$ghelekfi").equalsIgnoreCase(str) && DH.SyncMtd.checkPermission(l.a("039ef@edekelejedemAkg<ekegejgjgjejel%f7emgefefehjfmfmeihdfffhhjeigfhifegegdffhifh"))) {
            return true;
        }
        if (l.a("007fgj_ghelekfi").equalsIgnoreCase(str) && DH.SyncMtd.checkPermission(l.a("041efDedekelejedem@kgXekegejgjgjejelWfUemgefefehjfmfmeifehigehkfmhjeigfhifegegdffhifh"))) {
            return true;
        }
        if ("passive".equalsIgnoreCase(str) && DH.SyncMtd.checkPermission(l.a("039efEedekelejedemUkg0ekegejgjgjejelYfAemgefefehjfmfmeihdfffhhjeigfhifegegdffhifh"))) {
            return true;
        }
        return "passive".equalsIgnoreCase(str) && DH.SyncMtd.checkPermission(l.a("041efOedekelejedemIkgBekegejgjgjejel-f<emgefefehjfmfmeifehigehkfmhjeigfhifegegdffhifh"));
    }
}
