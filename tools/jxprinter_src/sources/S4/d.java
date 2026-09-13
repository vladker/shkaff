package S4;

import android.os.Looper;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.logging.Level;
import org.greenrobot.eventbus.android.AndroidComponentsImpl;
import p050j.w;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final class d {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static volatile d f672q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final e f673r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final HashMap f674s;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f675a;
    public final HashMap b;
    public final ConcurrentHashMap c;
    public final S1.a d = new S1.a(2);
    public final P2.a e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final g f676f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final a f677g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Q0.b f678h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final o f679i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ExecutorService f680j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f681k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f682l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f683m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f684n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f685o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final P2.a f686p;

    static {
        e eVar = new e();
        eVar.f687a = e.b;
        f673r = eVar;
        f674s = new HashMap();
    }

    public d() {
        e eVar = f673r;
        eVar.getClass();
        AndroidComponentsImpl androidComponentsImpl = AndroidComponentsImpl.c;
        this.f686p = androidComponentsImpl != null ? androidComponentsImpl.f7463a : new P2.a(2);
        this.f675a = new HashMap();
        this.b = new HashMap();
        this.c = new ConcurrentHashMap();
        P2.a aVar = androidComponentsImpl != null ? androidComponentsImpl.b : null;
        this.e = aVar;
        this.f676f = aVar != null ? new g(this, Looper.getMainLooper()) : null;
        this.f677g = new a(this);
        this.f678h = new Q0.b(this);
        this.f679i = new o();
        this.f681k = true;
        this.f682l = true;
        this.f683m = true;
        this.f684n = true;
        this.f685o = true;
        this.f680j = eVar.f687a;
    }

    public static void a(ArrayList arrayList, Class[] clsArr) {
        for (Class cls : clsArr) {
            if (!arrayList.contains(cls)) {
                arrayList.add(cls);
                a(arrayList, cls.getInterfaces());
            }
        }
    }

    public static d b() {
        d dVar;
        d dVar2 = f672q;
        if (dVar2 != null) {
            return dVar2;
        }
        synchronized (d.class) {
            try {
                dVar = f672q;
                if (dVar == null) {
                    dVar = new d();
                    f672q = dVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return dVar;
    }

    private void postSingleEvent(Object obj, c cVar) {
        boolean zG;
        List list;
        Class<?> cls = obj.getClass();
        if (this.f685o) {
            HashMap map = f674s;
            synchronized (map) {
                try {
                    List list2 = (List) map.get(cls);
                    list = list2;
                    if (list2 == null) {
                        ArrayList arrayList = new ArrayList();
                        for (Class<?> superclass = cls; superclass != null; superclass = superclass.getSuperclass()) {
                            arrayList.add(superclass);
                            a(arrayList, superclass.getInterfaces());
                        }
                        f674s.put(cls, arrayList);
                        list = arrayList;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            int size = list.size();
            zG = false;
            for (int i5 = 0; i5 < size; i5++) {
                zG |= g(obj, cVar, (Class) list.get(i5));
            }
        } else {
            zG = g(obj, cVar, cls);
        }
        if (zG) {
            return;
        }
        if (this.f682l) {
            this.f686p.a(Level.FINE, "No subscribers registered for event " + cls);
        }
        if (!this.f684n || cls == h.class || cls == l.class) {
            return;
        }
        f(new h(obj, 0));
    }

    public final void c(i iVar) {
        Object obj = iVar.f690a;
        p pVar = iVar.b;
        iVar.f690a = null;
        iVar.b = null;
        iVar.c = null;
        ArrayList arrayList = i.d;
        synchronized (arrayList) {
            try {
                if (arrayList.size() < 10000) {
                    arrayList.add(iVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (pVar.c) {
            d(pVar, obj);
        }
    }

    public final void d(p pVar, Object obj) {
        try {
            pVar.b.f693a.invoke(pVar.f698a, obj);
        } catch (IllegalAccessException e) {
            throw new IllegalStateException("Unexpected exception", e);
        } catch (InvocationTargetException e6) {
            Throwable cause = e6.getCause();
            boolean z6 = obj instanceof l;
            boolean z7 = this.f681k;
            P2.a aVar = this.f686p;
            if (!z6) {
                if (z7) {
                    aVar.b(Level.SEVERE, "Could not dispatch event: " + obj.getClass() + " to subscribing class " + pVar.f698a.getClass(), cause);
                }
                if (this.f683m) {
                    f(new l(cause, obj, pVar.f698a));
                    return;
                }
                return;
            }
            if (z7) {
                Level level = Level.SEVERE;
                aVar.b(level, "SubscriberExceptionEvent subscriber " + pVar.f698a.getClass() + " threw an exception", cause);
                l lVar = (l) obj;
                aVar.b(level, "Initial event " + lVar.b + " caused exception in " + lVar.c, lVar.f692a);
            }
        }
    }

    public final synchronized boolean e(Object obj) {
        return this.b.containsKey(obj);
    }

    public final void f(Object obj) {
        c cVar = (c) this.d.get();
        ArrayList arrayList = cVar.f671a;
        arrayList.add(obj);
        if (cVar.b) {
            return;
        }
        cVar.c = this.e == null || Looper.getMainLooper() == Looper.myLooper();
        cVar.b = true;
        while (!arrayList.isEmpty()) {
            try {
                postSingleEvent(arrayList.remove(0), cVar);
            } catch (Throwable th) {
                cVar.b = false;
                cVar.c = false;
                throw th;
            }
        }
        cVar.b = false;
        cVar.c = false;
    }

    public final boolean g(Object obj, c cVar, Class cls) {
        CopyOnWriteArrayList<p> copyOnWriteArrayList;
        synchronized (this) {
            copyOnWriteArrayList = (CopyOnWriteArrayList) this.f675a.get(cls);
        }
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        for (p pVar : copyOnWriteArrayList) {
            cVar.d = obj;
            i(pVar, obj, cVar.c);
        }
        return true;
    }

    public final void h(Object obj) {
        synchronized (this.c) {
            this.c.put(obj.getClass(), obj);
        }
        f(obj);
    }

    public final void i(p pVar, Object obj, boolean z6) {
        g gVar = this.f676f;
        int i5 = b.f670a[pVar.b.b.ordinal()];
        if (i5 == 1) {
            d(pVar, obj);
            return;
        }
        if (i5 == 2) {
            if (z6) {
                d(pVar, obj);
                return;
            } else {
                gVar.a(pVar, obj);
                return;
            }
        }
        if (i5 == 3) {
            if (gVar != null) {
                gVar.a(pVar, obj);
                return;
            } else {
                d(pVar, obj);
                return;
            }
        }
        if (i5 != 4) {
            if (i5 != 5) {
                throw new IllegalStateException("Unknown thread mode: " + pVar.b.b);
            }
            Q0.b bVar = this.f678h;
            bVar.getClass();
            ((j) bVar.b).a(i.a(pVar, obj));
            ((d) bVar.c).f680j.execute(bVar);
            return;
        }
        if (!z6) {
            d(pVar, obj);
            return;
        }
        a aVar = this.f677g;
        aVar.getClass();
        i iVarA = i.a(pVar, obj);
        synchronized (aVar) {
            try {
                aVar.f669a.a(iVarA);
                if (!aVar.c) {
                    aVar.c = true;
                    aVar.b.f680j.execute(aVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void j(Object obj) {
        int i5;
        n nVar;
        Method[] methods;
        k kVar;
        boolean zA;
        if (w.d()) {
            try {
                AndroidComponentsImpl androidComponentsImpl = AndroidComponentsImpl.c;
            } catch (ClassNotFoundException unused) {
                throw new RuntimeException("It looks like you are using EventBus on Android, make sure to add the \"eventbus\" Android library to your dependencies.");
            }
        }
        Class<?> cls = obj.getClass();
        this.f679i.getClass();
        ConcurrentHashMap concurrentHashMap = o.f697a;
        List list = (List) concurrentHashMap.get(cls);
        List list2 = list;
        if (list == null) {
            synchronized (o.b) {
                int i6 = 0;
                while (true) {
                    if (i6 >= 4) {
                        nVar = new n();
                        break;
                    }
                    try {
                        n[] nVarArr = o.b;
                        nVar = nVarArr[i6];
                        if (nVar != null) {
                            nVarArr[i6] = null;
                            break;
                        }
                        i6++;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            nVar.e = cls;
            nVar.f696f = false;
            while (true) {
                Class cls2 = nVar.e;
                if (cls2 == null) {
                    ArrayList arrayList = new ArrayList(nVar.f695a);
                    nVar.f695a.clear();
                    nVar.b.clear();
                    nVar.c.clear();
                    nVar.d.setLength(0);
                    nVar.e = null;
                    nVar.f696f = false;
                    synchronized (o.b) {
                        for (i5 = 0; i5 < 4; i5++) {
                            try {
                                n[] nVarArr2 = o.b;
                                if (nVarArr2[i5] == null) {
                                    nVarArr2[i5] = nVar;
                                    break;
                                }
                            } catch (Throwable th2) {
                                throw th2;
                            }
                        }
                    }
                    if (arrayList.isEmpty()) {
                        throw new f("Subscriber " + cls + " and its super classes have no public methods with the @Subscribe annotation");
                    }
                    concurrentHashMap.put(cls, arrayList);
                    list2 = arrayList;
                    break;
                }
                int i7 = 1;
                try {
                    try {
                        methods = cls2.getDeclaredMethods();
                    } catch (LinkageError e) {
                        throw new f(androidx.collection.a.n("Could not inspect methods of ".concat(nVar.e.getName()), ". Please make this class visible to EventBus annotation processor to avoid reflection."), e);
                    }
                } catch (Throwable unused2) {
                    methods = nVar.e.getMethods();
                    nVar.f696f = true;
                }
                int length = methods.length;
                int i8 = 0;
                while (i8 < length) {
                    Method method = methods[i8];
                    int modifiers = method.getModifiers();
                    if ((modifiers & 1) != 0 && (modifiers & 5192) == 0) {
                        Class<?>[] parameterTypes = method.getParameterTypes();
                        if (parameterTypes.length == i7 && (kVar = (k) method.getAnnotation(k.class)) != null) {
                            Class<?> cls3 = parameterTypes[0];
                            HashMap map = nVar.b;
                            Object objPut = map.put(cls3, method);
                            if (objPut == null) {
                                zA = true;
                            } else {
                                if (objPut instanceof Method) {
                                    if (!nVar.a(cls3, (Method) objPut)) {
                                        throw new IllegalStateException();
                                    }
                                    map.put(cls3, nVar);
                                }
                                zA = nVar.a(cls3, method);
                            }
                            if (zA) {
                                nVar.f695a.add(new m(method, cls3, kVar.threadMode(), kVar.priority(), kVar.sticky()));
                            }
                        }
                    }
                    i8++;
                    i7 = 1;
                }
                if (nVar.f696f) {
                    nVar.e = null;
                } else {
                    Class superclass = nVar.e.getSuperclass();
                    nVar.e = superclass;
                    String name = superclass.getName();
                    if (name.startsWith("java.") || name.startsWith("javax.") || name.startsWith("android.") || name.startsWith("androidx.")) {
                        nVar.e = null;
                    }
                }
            }
        }
        synchronized (this) {
            try {
                Iterator it = list2.iterator();
                while (it.hasNext()) {
                    l(obj, (m) it.next());
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    public final void k(p137y.p pVar) {
        synchronized (this.c) {
            try {
                Class<?> cls = pVar.getClass();
                if (pVar.equals(this.c.get(cls))) {
                    this.c.remove(cls);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void l(Object obj, m mVar) {
        Object value;
        Class cls = mVar.c;
        p pVar = new p(obj, mVar);
        HashMap map = this.f675a;
        CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) map.get(cls);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList();
            map.put(cls, copyOnWriteArrayList);
        } else if (copyOnWriteArrayList.contains(pVar)) {
            throw new f("Subscriber " + obj.getClass() + " already registered to event " + cls);
        }
        int size = copyOnWriteArrayList.size();
        for (int i5 = 0; i5 <= size; i5++) {
            if (i5 == size || mVar.d > ((p) copyOnWriteArrayList.get(i5)).b.d) {
                copyOnWriteArrayList.add(i5, pVar);
                break;
            }
        }
        HashMap map2 = this.b;
        List arrayList = (List) map2.get(obj);
        if (arrayList == null) {
            arrayList = new ArrayList();
            map2.put(obj, arrayList);
        }
        arrayList.add(cls);
        if (mVar.e) {
            boolean z6 = this.f685o;
            P2.a aVar = this.e;
            ConcurrentHashMap concurrentHashMap = this.c;
            if (!z6) {
                Object obj2 = concurrentHashMap.get(cls);
                if (obj2 != null) {
                    i(pVar, obj2, aVar == null || Looper.getMainLooper() == Looper.myLooper());
                    return;
                }
                return;
            }
            for (Map.Entry entry : concurrentHashMap.entrySet()) {
                if (cls.isAssignableFrom((Class) entry.getKey()) && (value = entry.getValue()) != null) {
                    i(pVar, value, aVar == null || Looper.getMainLooper() == Looper.myLooper());
                }
            }
        }
    }

    public final synchronized void m(Object obj) {
        try {
            List list = (List) this.b.get(obj);
            if (list != null) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    List list2 = (List) this.f675a.get((Class) it.next());
                    if (list2 != null) {
                        int size = list2.size();
                        int i5 = 0;
                        while (i5 < size) {
                            p pVar = (p) list2.get(i5);
                            if (pVar.f698a == obj) {
                                pVar.c = false;
                                list2.remove(i5);
                                i5--;
                                size--;
                            }
                            i5++;
                        }
                    }
                }
                this.b.remove(obj);
            } else {
                this.f686p.a(Level.WARNING, "Subscriber to unregister was not registered before: " + obj.getClass());
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final String toString() {
        return "EventBus[indexCount=0, eventInheritance=" + this.f685o + "]";
    }
}
