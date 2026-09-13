package cn.fly.tools.utils;

import A3.AbstractC0157z;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import android.text.TextUtils;
import cn.fly.FlySDK;
import cn.fly.commons.C0396r;
import cn.fly.commons.m;
import cn.fly.commons.v;
import cn.fly.tools.FlyLog;
import cn.fly.tools.proguard.EverythingKeeper;
import com.alibaba.android.arouter.utils.Consts;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes.dex */
public class FlyPersistence {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f1883h = Process.myPid();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static volatile HashSet<String> f1884i = new HashSet<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final i f1885a;
    private final ScheduledExecutorService b;
    private final Map<String, j> c = new HashMap();
    private final ReentrantReadWriteLock d;
    private final ReentrantReadWriteLock.WriteLock e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ReentrantReadWriteLock.ReadLock f1886f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final f f1887g;

    public static final class KVEntry<T> implements EverythingKeeper, Serializable {
        private static final long serialVersionUID = -1538971823189206429L;
        private String key;
        private T value;

        public KVEntry(String str, T t6) {
            this.key = str;
            this.value = t6;
        }

        public String getKey() {
            return this.key;
        }

        public T getValue() {
            return this.value;
        }

        public void setKey(String str) {
            this.key = str;
        }

        public void setValue(T t6) {
            this.value = t6;
        }
    }

    public static class NoValidDataException extends Exception {
        public NoValidDataException() {
            this(m.a("019HgifmkhffCfi7fkfekhfe>fkf5khghfmfi!g,fe"));
        }

        public NoValidDataException(String str) {
            super(str);
        }
    }

    public static final class SerializableParcel<T extends Parcelable> implements EverythingKeeper, Serializable {
        private static final long serialVersionUID = -2769878423373647357L;
        private Class<T> clazz;
        private byte[] data;

        public SerializableParcel(Parcelable parcelable) {
            this.clazz = (Class<T>) parcelable.getClass();
            this.data = parcelable2Byte(parcelable);
        }

        private T byte2Parcelable(byte[] bArr, Class<T> cls, T t6) {
            if (bArr != null && bArr.length != 0) {
                try {
                    Parcel parcelObtain = Parcel.obtain();
                    parcelObtain.unmarshall(bArr, 0, bArr.length);
                    parcelObtain.setDataPosition(0);
                    return (T) ((Parcelable.Creator) cls.getDeclaredField(m.a("007Tgfilikhfheijil")).get(null)).createFromParcel(parcelObtain);
                } catch (Throwable th) {
                    FlyLog.getInstance().d(th);
                }
            }
            return t6;
        }

        private byte[] parcelable2Byte(Parcelable parcelable) {
            if (parcelable == null) {
                return new byte[0];
            }
            Parcel parcelObtain = Parcel.obtain();
            parcelable.writeToParcel(parcelObtain, 0);
            return parcelObtain.marshall();
        }

        private void setClazz(Class cls) {
            this.clazz = cls;
        }

        private void setData(byte[] bArr) {
            this.data = bArr;
        }

        public Class getClazz() {
            return this.clazz;
        }

        public byte[] getData() {
            return this.data;
        }

        public T getParcel(T t6) {
            return (T) byte2Parcelable(this.data, this.clazz, t6);
        }
    }

    public static final class a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f1889a;
        private T b;

        public a(String str, T t6) {
            this.f1889a = str;
            this.b = t6;
        }

        public HashMap<Byte, Object> b() {
            HashMap<Byte, Object> map = new HashMap<>();
            map.put((byte) 0, this.f1889a);
            map.put((byte) 1, this.b);
            return map;
        }

        public T a() {
            return this.b;
        }

        public static <T> a<T> a(HashMap<Byte, Object> map) {
            if (map != null) {
                return new a<>((String) map.get((byte) 0), map.get((byte) 1));
            }
            return null;
        }
    }

    public static final class b<T extends Parcelable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Class<T> f1890a;
        private byte[] b;

        public b(Parcelable parcelable) {
            this.f1890a = (Class<T>) parcelable.getClass();
            this.b = b(parcelable);
        }

        public Class a() {
            return this.f1890a;
        }

        public byte[] b() {
            return this.b;
        }

        public HashMap<Byte, Object> c() {
            HashMap<Byte, Object> map = new HashMap<>();
            map.put((byte) 0, this.f1890a);
            map.put((byte) 1, this.b);
            return map;
        }

        private byte[] b(Parcelable parcelable) {
            if (parcelable == null) {
                return new byte[0];
            }
            Parcel parcelObtain = Parcel.obtain();
            try {
                parcelable.writeToParcel(parcelObtain, 0);
                return parcelObtain.marshall();
            } finally {
                parcelObtain.recycle();
            }
        }

        public T a(T t6) {
            return (T) a(this.b, this.f1890a, t6);
        }

        public static <T extends Parcelable> b<T> a(HashMap<Byte, Object> map) {
            if (map != null) {
                return new b<>((Class) map.get((byte) 0), (byte[]) map.get((byte) 1));
            }
            return null;
        }

        public b(Class<T> cls, byte[] bArr) {
            this.f1890a = cls;
            this.b = bArr;
        }

        private T a(byte[] bArr, Class<T> cls, T t6) {
            if (bArr == null || bArr.length == 0) {
                return t6;
            }
            Parcel parcelObtain = Parcel.obtain();
            try {
                parcelObtain.unmarshall(bArr, 0, bArr.length);
                parcelObtain.setDataPosition(0);
                Field declaredField = cls.getDeclaredField(m.a("007'gfilikhfheijil"));
                declaredField.setAccessible(true);
                T tCast = cls.cast(((Parcelable.Creator) declaredField.get(null)).createFromParcel(parcelObtain));
                parcelObtain.recycle();
                return tCast;
            } catch (Throwable th) {
                try {
                    FlyLog.getInstance().d("Failed to convert bytes to Parcelable", th);
                    return t6;
                } finally {
                    parcelObtain.recycle();
                }
            }
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f1891a;
        private Object b;
        private long c;

        private c(long j6, Object obj, long j7) {
            this.f1891a = j6;
            this.b = obj;
            this.c = j7;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a() {
            long j6 = this.f1891a;
            return j6 != 0 && j6 <= System.currentTimeMillis();
        }
    }

    public class d implements Runnable {
        private int b;

        private d() {
            this.b = 0;
        }

        @Override // java.lang.Runnable
        public void run() {
            ScheduledExecutorService scheduledExecutorService;
            TimeUnit timeUnit;
            ArrayList arrayList;
            Throwable th;
            try {
                try {
                    FlyPersistence.this.e.lock();
                    ArrayList arrayList2 = null;
                    try {
                        if (!FlyPersistence.this.c.isEmpty()) {
                            arrayList = new ArrayList(FlyPersistence.this.c.values());
                            try {
                                FlyPersistence.this.c.clear();
                                if (!arrayList.isEmpty()) {
                                    FlyPersistence.this.f1885a.b().lock();
                                }
                                arrayList2 = arrayList;
                            } catch (Throwable th2) {
                                th = th2;
                                try {
                                    FlyPersistence.b(th, FlyPersistence.this.f1885a.f1909l);
                                    try {
                                        FlyPersistence.this.e.unlock();
                                    } catch (Throwable th3) {
                                        FlyPersistence.b(th3, FlyPersistence.this.f1885a.f1909l);
                                    }
                                    arrayList2 = arrayList;
                                } catch (Throwable th4) {
                                    try {
                                        FlyPersistence.this.e.unlock();
                                    } catch (Throwable th5) {
                                        FlyPersistence.b(th5, FlyPersistence.this.f1885a.f1909l);
                                    }
                                    throw th4;
                                }
                            }
                        }
                        try {
                            FlyPersistence.this.e.unlock();
                        } catch (Throwable th6) {
                            FlyPersistence.b(th6, FlyPersistence.this.f1885a.f1909l);
                        }
                    } catch (Throwable th7) {
                        arrayList = null;
                        th = th7;
                    }
                    if (arrayList2 != null && !arrayList2.isEmpty()) {
                        try {
                            List<j> listA = FlyPersistence.this.f1885a.a(arrayList2);
                            if (!listA.isEmpty()) {
                                FlyPersistence.this.e.lock();
                                try {
                                    for (j jVar : listA) {
                                        FlyPersistence.this.c.put(jVar.f1926a, jVar);
                                    }
                                    FlyPersistence.this.e.unlock();
                                } catch (Throwable th8) {
                                    FlyPersistence.this.e.unlock();
                                    throw th8;
                                }
                            }
                            FlyPersistence.this.f1885a.b().unlock();
                        } catch (Throwable th9) {
                            FlyPersistence.this.f1885a.b().unlock();
                            throw th9;
                        }
                    }
                    try {
                        int i5 = this.b + 1;
                        this.b = i5;
                        if (i5 >= 10) {
                            this.b = 0;
                            FlyPersistence.this.f1885a.f();
                        }
                    } catch (Throwable th10) {
                        this.b = 0;
                        FlyPersistence.b(th10, FlyPersistence.this.f1885a.f1909l);
                    }
                    scheduledExecutorService = FlyPersistence.this.b;
                    timeUnit = TimeUnit.MILLISECONDS;
                } catch (Throwable th11) {
                    try {
                        FlyPersistence.b(th11, FlyPersistence.this.f1885a.f1909l);
                        scheduledExecutorService = FlyPersistence.this.b;
                        timeUnit = TimeUnit.MILLISECONDS;
                    } catch (Throwable th12) {
                        try {
                            FlyPersistence.this.b.schedule(this, 3000L, TimeUnit.MILLISECONDS);
                        } catch (Throwable th13) {
                            FlyPersistence.b(th13, FlyPersistence.this.f1885a.f1909l);
                        }
                        throw th12;
                    }
                }
                scheduledExecutorService.schedule(this, 3000L, timeUnit);
            } catch (Throwable th14) {
                FlyPersistence.b(th14, FlyPersistence.this.f1885a.f1909l);
            }
        }
    }

    public static class e<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f1893a;

        public e(String str) {
            this.f1893a = str;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public T a(Object obj) {
            return obj;
        }

        public String a() {
            return this.f1893a;
        }
    }

    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private byte[] f1894a;
        private final boolean b;

        private static Object b(byte[] bArr) throws Throwable {
            ByteArrayInputStream byteArrayInputStream;
            Throwable th;
            ObjectInputStream objectInputStream;
            try {
                byteArrayInputStream = new ByteArrayInputStream(bArr);
                try {
                    objectInputStream = new ObjectInputStream(byteArrayInputStream);
                    try {
                        Object object = objectInputStream.readObject();
                        C0396r.a(objectInputStream, byteArrayInputStream);
                        return object;
                    } catch (Throwable th2) {
                        th = th2;
                        C0396r.a(objectInputStream, byteArrayInputStream);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    objectInputStream = null;
                }
            } catch (Throwable th4) {
                byteArrayInputStream = null;
                th = th4;
                objectInputStream = null;
            }
        }

        private f(String str) {
            if (TextUtils.isEmpty(str)) {
                this.b = false;
                return;
            }
            this.b = true;
            try {
                this.f1894a = str.getBytes("utf-8");
            } catch (Throwable unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Object a(byte[] bArr, Object obj) {
            try {
                return a(bArr);
            } catch (Throwable th) {
                FlyLog.getInstance().d(th);
                return obj;
            }
        }

        private Object a(byte[] bArr) {
            if (bArr == null || bArr.length == 0) {
                return null;
            }
            if (this.b) {
                if (bArr.length % 16 == 0) {
                    try {
                        return b(Data.paddingDecode(this.f1894a, bArr));
                    } catch (Throwable unused) {
                        FlyPersistence.d("decode fail ", "ENCIPER");
                        return b(bArr);
                    }
                }
                return b(bArr);
            }
            return b(bArr);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public byte[] a(Object obj) throws Throwable {
            ByteArrayOutputStream byteArrayOutputStream;
            if (obj != null) {
                ObjectOutputStream objectOutputStream = null;
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(byteArrayOutputStream);
                        try {
                            objectOutputStream2.writeObject(obj);
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            if (!this.b) {
                                C0396r.a(objectOutputStream2, byteArrayOutputStream);
                                return byteArray;
                            }
                            byte[] bArrAES128Encode = Data.AES128Encode(this.f1894a, byteArray);
                            C0396r.a(objectOutputStream2, byteArrayOutputStream);
                            return bArrAES128Encode;
                        } catch (Throwable th) {
                            th = th;
                            objectOutputStream = objectOutputStream2;
                            C0396r.a(objectOutputStream, byteArrayOutputStream);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    byteArrayOutputStream = null;
                }
            } else {
                return new byte[0];
            }
        }
    }

    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final byte[] f1895a;

        public g(byte[] bArr) {
            this.f1895a = bArr;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || g.class != obj.getClass()) {
                return false;
            }
            return Arrays.equals(this.f1895a, ((g) obj).f1895a);
        }

        public int hashCode() {
            return Arrays.hashCode(this.f1895a);
        }
    }

    public static final class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f1896a;
        private volatile LinkedHashMap<g, c> b;
        private volatile AtomicLong c;
        private long d;
        private long e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final AtomicLong f1897f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private double f1898g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private double f1899h;

        private h(int i5, long j6, long j7, double d, double d6) {
            this.f1897f = new AtomicLong(0L);
            this.f1896a = i5;
            this.c = new AtomicLong(j7);
            this.e = j6;
            this.d = j7;
            this.f1898g = d;
            this.f1899h = d6;
            this.b = new LinkedHashMap<g, c>(i5, 0.75f, true) { // from class: cn.fly.tools.utils.FlyPersistence.h.1
                @Override // java.util.LinkedHashMap
                public boolean removeEldestEntry(Map.Entry<g, c> entry) {
                    boolean z6 = size() > h.this.f1896a;
                    if (z6) {
                        h.this.f1897f.addAndGet(-entry.getValue().c);
                    }
                    return z6;
                }
            };
        }

        private void c() {
            while (this.f1897f.get() > this.c.get() && !this.b.isEmpty()) {
                try {
                    Iterator<Map.Entry<g, c>> it = this.b.entrySet().iterator();
                    if (it.hasNext()) {
                        Map.Entry<g, c> next = it.next();
                        if (next != null && next.getValue() != null) {
                            this.f1897f.addAndGet(-next.getValue().c);
                        }
                        it.remove();
                    }
                } catch (Throwable th) {
                    FlyPersistence.b(th, "LRU");
                    return;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(g gVar) {
            c cVarRemove = this.b.remove(gVar);
            if (cVarRemove != null) {
                this.f1897f.addAndGet(-cVarRemove.c);
            }
        }

        private boolean b(long j6, long j7, double d, double d6) {
            if (j6 <= 0) {
                j6 = this.d;
            }
            if (j7 <= 0) {
                j7 = this.e;
            }
            if (j7 < j6) {
                j6 = this.d;
                j7 = this.e;
            }
            if (d <= 0.0d || d >= 1.0d) {
                d = this.f1898g;
            }
            if (d6 <= 0.0d || d6 >= 1.0d) {
                d6 = this.f1899h;
            }
            if (d < d6) {
                d = this.f1898g;
                d6 = this.f1899h;
            }
            return (this.d == j6 && this.e == j7 && this.f1898g == d && this.f1899h == d6) ? false : true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public c a(g gVar) {
            return this.b.get(gVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(g gVar, c cVar) {
            this.f1897f.addAndGet(cVar.c);
            c cVarPut = this.b.put(gVar, cVar);
            if (cVarPut != null) {
                this.f1897f.addAndGet(-cVarPut.c);
            }
            c();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            this.b.clear();
            this.f1897f.set(0L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(long j6, long j7, double d, double d6) {
            if (b(j6, j7, d, d6)) {
                this.d = j6;
                this.e = j7;
                this.f1898g = d;
                this.f1899h = d6;
                b();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            try {
                DH.requester(FlySDK.getContext()).getRuntimeMemory(true).request(new DH.DHResponder() { // from class: cn.fly.tools.utils.FlyPersistence.h.2
                    @Override // cn.fly.tools.utils.DH.DHResponder
                    public void onResponse(DH.DHResponse dHResponse) {
                        try {
                            long j6 = h.this.c.get();
                            HashMap<String, Long> runtimeMemory = dHResponse.getRuntimeMemory();
                            long jLongValue = runtimeMemory.get(m.a("005k9fm9kfi")).longValue();
                            long jLongValue2 = runtimeMemory.get(m.a("003Bfh,fDgk")).longValue();
                            long jLongValue3 = runtimeMemory.get(m.a("004Fghfl@hh")).longValue();
                            if (jLongValue2 > 0 && jLongValue > 0 && jLongValue3 > 0) {
                                double d = (jLongValue - jLongValue3) / jLongValue2;
                                if (d > h.this.f1898g && h.this.c.get() != h.this.d) {
                                    j6 = h.this.d;
                                    FlyPersistence.c("lim max to " + h.this.d, "LRU");
                                } else if (d < h.this.f1899h && h.this.c.get() != h.this.e) {
                                    j6 = h.this.e;
                                    FlyPersistence.d("add max to " + h.this.e, "LRU");
                                }
                                if (j6 != h.this.c.get()) {
                                    h.this.a(j6);
                                }
                            }
                        } catch (Throwable th) {
                            FlyPersistence.b(th, "LRU");
                        }
                    }
                });
            } catch (Throwable th) {
                FlyPersistence.b(th, "LRU");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(long j6) {
            this.c.set(j6);
            if (this.f1897f.get() > j6) {
                c();
            }
        }
    }

    public static class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        RandomAccessFile f1902a;
        FileChannel b;
        private final ReentrantReadWriteLock c;
        private final ReentrantReadWriteLock.WriteLock d;
        private final ReentrantReadWriteLock.ReadLock e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private File f1903f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private volatile RandomAccessFile f1904g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private volatile long f1905h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private volatile LinkedList<a> f1906i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private volatile HashMap<g, a> f1907j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final Context f1908k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private final String f1909l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private final File f1910m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private final f f1911n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private final h f1912o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private int f1913p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private volatile boolean f1914q;

        public static class a implements Comparable<a> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private int f1923a;
            private byte b;
            private byte[] c;
            private long d;
            private long e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private long f1924f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private long f1925g;

            public a(int i5) {
                this.f1923a = i5;
                this.f1925g = (((long) i5) * 41) + 1024;
            }

            public boolean e() {
                return d() != 0 && d() <= System.currentTimeMillis();
            }

            public void f() {
                this.b = (byte) 1;
                this.c = null;
                this.f1924f = -1L;
                this.d = 0L;
                this.e = 0L;
            }

            public long b() {
                return this.d;
            }

            public long c() {
                return this.e;
            }

            public long d() {
                return this.f1924f;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void b(long j6) {
                this.e = j6;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void c(long j6) {
                this.f1924f = j6;
            }

            public long a() {
                return this.f1925g;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void a(byte b) {
                this.b = b;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void a(byte[] bArr) {
                this.c = bArr;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void a(long j6) {
                this.d = j6;
            }

            public void a(byte b, byte[] bArr, long j6, long j7) {
                this.b = b;
                this.c = bArr;
                this.e = j6;
                this.f1924f = j7;
            }

            @Override // java.lang.Comparable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compareTo(a aVar) {
                return Long.compare(b(), aVar.b());
            }
        }

        public i(Context context, String str, f fVar) {
            ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
            this.c = reentrantReadWriteLock;
            this.d = reentrantReadWriteLock.writeLock();
            this.e = reentrantReadWriteLock.readLock();
            this.f1913p = 0;
            this.f1914q = false;
            this.f1908k = context;
            this.f1909l = str;
            this.f1910m = v.a(v.f1481h + str);
            this.f1911n = fVar;
            this.f1912o = new h(60, cn.fly.tools.utils.h.a(context).b("key_lru_min", 307200L), cn.fly.tools.utils.h.a(context).b("key_lru_max", 4194304L), cn.fly.tools.utils.h.a(context).b("key_lru_re", 0.7d), cn.fly.tools.utils.h.a(context).b("key_lru_ie", 0.5d));
            n();
            g();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void l() throws IOException {
            if (new Random().nextInt(10) < 1) {
                h();
            }
            this.f1905h = System.currentTimeMillis();
            this.f1904g.seek(0L);
            this.f1904g.writeLong(this.f1905h);
        }

        private long m() throws IOException {
            this.f1904g.seek(0L);
            return this.f1904g.readLong();
        }

        private void n() {
            try {
                cn.fly.commons.c.a(new cn.fly.commons.c.b() { // from class: cn.fly.tools.utils.FlyPersistence.i.7
                    @Override // cn.fly.commons.c.b
                    public void a() {
                        i.this.d.lock();
                        try {
                            FlyPersistence.d("ol it", i.this.f1909l);
                            String str = (String) cn.fly.commons.c.a("mpmj", "307200,4194304,0.7,0.5");
                            long j6 = 307200;
                            long j7 = 4194304;
                            double d = 0.7d;
                            double d6 = 0.5d;
                            if (!TextUtils.isEmpty(str)) {
                                String[] strArrSplit = str.split(",", 4);
                                if (strArrSplit.length == 4) {
                                    try {
                                        j6 = Long.parseLong(strArrSplit[0].trim());
                                    } catch (Throwable unused) {
                                    }
                                    try {
                                        j7 = Long.parseLong(strArrSplit[1].trim());
                                    } catch (Throwable unused2) {
                                    }
                                    try {
                                        d = Double.parseDouble(strArrSplit[2].trim());
                                    } catch (Throwable unused3) {
                                    }
                                    try {
                                        d6 = Double.parseDouble(strArrSplit[3].trim());
                                    } catch (Throwable unused4) {
                                    }
                                }
                            }
                            i.this.f1912o.a(j6, j7, d, d6);
                            if (j6 > 0 && j7 > 0 && j7 > j6) {
                                cn.fly.tools.utils.h.a(i.this.f1908k).a("key_lru_min", j6);
                                cn.fly.tools.utils.h.a(i.this.f1908k).a("key_lru_max", j7);
                            }
                            if (d > 0.0d && d < 1.0d && d6 > 0.0d && d6 < 1.0d && d > d6) {
                                cn.fly.tools.utils.h.a(i.this.f1908k).a("key_lru_re", d);
                                cn.fly.tools.utils.h.a(i.this.f1908k).a("key_lru_ie", d6);
                            }
                        } catch (Throwable th) {
                            try {
                                FlyPersistence.b(th, i.this.a());
                            } finally {
                                i.this.d.unlock();
                            }
                        }
                    }
                }, new boolean[0]);
            } catch (Throwable th) {
                FlyPersistence.b(th, a());
            }
        }

        private long d(long j6) {
            try {
                this.f1904g.seek(j6 + 33);
                return this.f1904g.readLong();
            } catch (Throwable th) {
                FlyPersistence.b(th, a());
                return 0L;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public byte[] f(a aVar) throws IOException {
            this.f1904g.seek(aVar.b());
            byte[] bArr = new byte[(int) aVar.e];
            this.f1904g.readFully(bArr);
            return bArr;
        }

        private void g() {
            this.d.lock();
            try {
                try {
                    if (this.b == null) {
                        RandomAccessFile randomAccessFile = new RandomAccessFile(this.f1910m, m.a("0027flhi"));
                        this.f1902a = randomAccessFile;
                        this.b = randomAccessFile.getChannel();
                        this.f1914q = true;
                    }
                } catch (Throwable th) {
                    FlyPersistence.b(th, this.f1909l);
                    this.f1914q = false;
                }
                FlyPersistence.f1884i.add(this.f1909l);
                a(new Runnable() { // from class: cn.fly.tools.utils.FlyPersistence.i.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (i.this.f1908k != null) {
                                i.this.f1903f = new File(FlyPersistence.a(i.this.f1908k), i.this.f1909l);
                                if (!i.this.f1903f.getParentFile().exists()) {
                                    i.this.f1903f.getParentFile().mkdirs();
                                }
                                if (i.this.f1903f.exists() && i.this.f1903f.length() < 43008) {
                                    FlyPersistence.c("Del dirty, size: " + i.this.f1903f.length() + ", min: 43008", i.this.f1909l);
                                    i.this.f1903f.delete();
                                }
                                if (!i.this.f1903f.exists()) {
                                    i.this.f1903f.createNewFile();
                                    i.this.f1904g = new RandomAccessFile(i.this.f1903f, m.a("002*flhi"));
                                    i.this.b(1024);
                                    return;
                                }
                                i.this.f1904g = new RandomAccessFile(i.this.f1903f, m.a("002^flhi"));
                                i.this.j();
                                FlyPersistence.d("ava sz " + i.this.f1906i.size() + " useds " + i.this.f1907j.size(), i.this.f1909l);
                            }
                        } catch (Throwable th2) {
                            FlyPersistence.b(th2, i.this.f1909l);
                        }
                    }
                });
            } finally {
                this.d.unlock();
            }
        }

        private void h() throws IOException {
            long jC;
            FlyPersistence.d(" [trim] try ", this.f1909l);
            long size = (((long) (this.f1906i.size() + this.f1907j.size())) * 41) + 1024;
            long length = this.f1904g.length();
            Iterator<a> it = this.f1907j.values().iterator();
            double dC = 0.0d;
            while (it.hasNext()) {
                dC += it.next().c();
            }
            long j6 = length - size;
            if (dC / j6 <= 0.5d) {
                ArrayList<a> arrayListI = i();
                int size2 = arrayListI.size();
                int i5 = 0;
                long j7 = size;
                while (i5 < size2) {
                    a aVar = arrayListI.get(i5);
                    i5++;
                    a aVar2 = aVar;
                    if (aVar2.e()) {
                        e(aVar2);
                    } else {
                        if (aVar2.b() == j7) {
                            jC = aVar2.c();
                        } else if (aVar2.b() > j7) {
                            a(aVar2, j7);
                            jC = aVar2.c();
                        }
                        j7 += jC;
                    }
                }
                this.f1904g.setLength(j7);
                FlyPersistence.d(" [trim] real over  before dataBlockSize " + j6 + " cur " + (j7 - size), this.f1909l);
            }
        }

        private ArrayList<a> i() {
            ArrayList<a> arrayList = new ArrayList<>(this.f1907j.values());
            Collections.sort(arrayList);
            return arrayList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean j() throws IOException {
            boolean[] zArr = {false};
            long jM = m();
            if (jM != this.f1905h) {
                this.d.lock();
                try {
                    this.f1912o.a();
                    this.f1905h = jM;
                    this.f1906i = new LinkedList<>();
                    this.f1907j = new HashMap<>();
                    int iC = c();
                    for (int i5 = 0; i5 < iC; i5++) {
                        a aVar = new a(i5);
                        if (b(aVar) == 1) {
                            this.f1906i.add(aVar);
                        } else {
                            a(aVar);
                            this.f1907j.put(new g(aVar.c), aVar);
                        }
                    }
                    FlyPersistence.d("update lstt " + this.f1905h + " a " + this.f1906i.size() + " u " + this.f1907j.size(), this.f1909l);
                    zArr[0] = true;
                } finally {
                    this.d.unlock();
                }
            }
            return zArr[0];
        }

        private void k() throws IOException {
            int iC = c();
            int i5 = iC + 1024;
            FlyPersistence.d(androidx.collection.a.h(iC, i5, "[exp] old ", " new "), this.f1909l);
            long j6 = (((long) i5) * 41) + 1024;
            if ((((long) (this.f1906i.size() + this.f1907j.size())) * 41) + 1024 < j6) {
                ArrayList<a> arrayListI = i();
                int size = arrayListI.size();
                int i6 = 0;
                while (i6 < size) {
                    a aVar = arrayListI.get(i6);
                    i6++;
                    a aVar2 = aVar;
                    if (aVar2.b() >= j6) {
                        break;
                    }
                    long jB = aVar2.b() + aVar2.c();
                    if (aVar2.e()) {
                        e(aVar2);
                    } else {
                        a(aVar2, this.f1904g.length());
                    }
                    if (jB >= j6) {
                        break;
                    }
                }
            }
            this.f1904g.seek(j6);
            for (int i7 = iC - 1; i7 < i5; i7++) {
                a aVar3 = new a(i7);
                this.f1906i.add(aVar3);
                a(aVar3.f1925g, (byte) 1);
            }
            FlyPersistence.d("[exp] ovr", this.f1909l);
            a(i5);
        }

        public List<byte[]> e() {
            this.d.lock();
            final ArrayList arrayList = new ArrayList();
            try {
                a(new Runnable() { // from class: cn.fly.tools.utils.FlyPersistence.i.5
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            i.this.j();
                            if (i.this.f1907j != null) {
                                Iterator it = i.this.f1907j.values().iterator();
                                while (it.hasNext()) {
                                    arrayList.add(i.this.f((a) it.next()));
                                }
                            }
                        } catch (Throwable th) {
                            FlyPersistence.b(th, i.this.a());
                        }
                    }
                });
                return arrayList;
            } finally {
                this.d.unlock();
            }
        }

        private long c(long j6) {
            try {
                this.f1904g.seek(j6 + 25);
                return this.f1904g.readLong();
            } catch (Throwable th) {
                FlyPersistence.b(th, a());
                return -1L;
            }
        }

        public ReentrantReadWriteLock.WriteLock b() {
            return this.d;
        }

        private long b(long j6) {
            try {
                this.f1904g.seek(j6 + 17);
                return this.f1904g.readLong();
            } catch (Throwable th) {
                FlyPersistence.b(th, a());
                return -1L;
            }
        }

        public boolean d() {
            this.d.lock();
            final boolean[] zArr = new boolean[1];
            try {
                a(new Runnable() { // from class: cn.fly.tools.utils.FlyPersistence.i.3
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            for (a aVar : i.this.f1907j.values()) {
                                i.this.f1904g.seek(aVar.a());
                                i.this.f1904g.writeByte(1);
                                aVar.f();
                            }
                            i.this.f1906i.addAll(i.this.f1907j.values());
                            i.this.f1907j.clear();
                            i.this.f1904g.setLength((((long) i.this.f1906i.size()) * 41) + 1024);
                            zArr[0] = true;
                            i.this.l();
                            FlyPersistence.d("Clear done, new size: ", i.this.f1909l);
                        } catch (Throwable th) {
                            FlyPersistence.b(th, i.this.f1909l);
                        }
                    }
                });
                return zArr[0];
            } finally {
                this.d.unlock();
            }
        }

        public void f() {
            this.d.lock();
            try {
                this.f1912o.b();
            } finally {
                this.d.unlock();
            }
        }

        public int c() {
            try {
                this.f1904g.seek(8L);
                return this.f1904g.readInt();
            } catch (Throwable th) {
                FlyPersistence.b(th, this.f1909l);
                return 0;
            }
        }

        private void e(a aVar) throws IOException {
            this.f1907j.remove(new g(aVar.c));
            this.f1904g.seek(aVar.a());
            this.f1904g.writeByte(1);
            this.f1906i.add(aVar);
            aVar.f();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(int i5) throws IOException {
            this.f1906i = new LinkedList<>();
            this.f1907j = new HashMap<>();
            a(0, i5);
            a(i5);
            this.f1905h = System.currentTimeMillis();
            this.f1904g.seek(0L);
            this.f1904g.writeLong(this.f1905h);
            FlyPersistence.d("new a " + this.f1906i.size() + " u " + this.f1907j.size(), this.f1909l);
        }

        private void c(int i5) {
            if (i5 >= 0) {
                int iC = c();
                if (i5 >= iC) {
                    throw new IndexOutOfBoundsException(b(i5, iC));
                }
                return;
            }
            throw new IllegalArgumentException(AbstractC0157z.k(i5, "index : "));
        }

        public String a() {
            return this.f1909l;
        }

        /* JADX WARN: Code duplicated, block: B:40:0x002b A[DONT_GENERATE, EXC_TOP_SPLITTER, PHI: r1
  0x002b: PHI (r1v3 java.nio.channels.FileLock) = (r1v2 java.nio.channels.FileLock), (r1v4 java.nio.channels.FileLock) binds: [B:20:0x0039, B:15:0x0029] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
        private void a(Runnable runnable) {
            if (this.f1914q) {
                int i5 = this.f1913p;
                if (i5 > 0) {
                    this.f1913p = i5 + 1;
                    try {
                        runnable.run();
                        return;
                    } finally {
                        this.f1913p--;
                    }
                }
                this.f1913p = 1;
                FileLock fileLockLock = null;
                try {
                    fileLockLock = this.b.lock();
                    runnable.run();
                    if (fileLockLock != null) {
                    }
                } catch (Throwable th) {
                    try {
                        FlyPersistence.b(th, a());
                    } finally {
                        if (fileLockLock != null) {
                            try {
                                fileLockLock.release();
                            } catch (Throwable unused) {
                            }
                        }
                        this.f1913p = 0;
                    }
                }
                return;
            }
            runnable.run();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(a aVar) {
            this.d.lock();
            try {
                e(aVar);
                l();
            } finally {
                this.d.unlock();
            }
        }

        public byte b(a aVar) {
            try {
                this.f1904g.seek(aVar.f1925g);
                return this.f1904g.readByte();
            } catch (Throwable th) {
                FlyPersistence.b(th, this.f1909l);
                return (byte) 0;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean c(a aVar) {
            try {
                byte[] bArr = new byte[41];
                bArr[0] = 0;
                System.arraycopy(aVar.c, 0, bArr, 1, 16);
                a(aVar.d, bArr, 17);
                a(aVar.e, bArr, 25);
                a(aVar.f1924f, bArr, 33);
                this.f1904g.seek(aVar.f1925g);
                this.f1904g.write(bArr);
                return true;
            } catch (Throwable th) {
                FlyPersistence.b(th, this.f1909l);
                return false;
            }
        }

        private String b(int i5, int i6) {
            return androidx.collection.a.h(i5, i6, "Index: ", ", Size: ");
        }

        public void a(a aVar) {
            try {
                c(aVar.f1923a);
                this.f1904g.seek(aVar.a());
                aVar.a(this.f1904g.readByte());
                aVar.a(a(aVar.f1925g));
                aVar.a(b(aVar.f1925g));
                aVar.b(c(aVar.f1925g));
                aVar.c(d(aVar.f1925g));
            } catch (Throwable th) {
                FlyPersistence.b(th, this.f1909l);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean b(g gVar) {
            try {
                j();
                a aVar = this.f1907j.get(gVar);
                if (aVar != null) {
                    d(aVar);
                }
                this.f1912o.b(gVar);
                return true;
            } catch (Throwable th) {
                FlyPersistence.b(th, a());
                return false;
            }
        }

        private byte[] a(long j6) throws IOException {
            byte[] bArr = new byte[16];
            this.f1904g.seek(j6 + 1);
            this.f1904g.read(bArr, 0, 16);
            return bArr;
        }

        private void a(a aVar, long j6) throws IOException {
            byte[] bArr = new byte[(int) aVar.e];
            this.f1904g.seek(aVar.d);
            this.f1904g.readFully(bArr);
            this.f1904g.seek(j6);
            this.f1904g.write(bArr);
            this.f1904g.seek(aVar.f1925g + 17);
            this.f1904g.writeLong(j6);
            aVar.a(j6);
            this.f1907j.put(new g(aVar.c), aVar);
        }

        public void a(int i5) {
            if (i5 > 0) {
                try {
                    this.f1904g.seek(8L);
                    this.f1904g.writeInt(i5);
                    return;
                } catch (Throwable th) {
                    try {
                        FlyPersistence.b(th, this.f1909l);
                        return;
                    } catch (Throwable th2) {
                        FlyPersistence.b(th2, this.f1909l);
                        return;
                    }
                }
            }
            throw new IllegalArgumentException(AbstractC0157z.k(i5, "indexNum : "));
        }

        private void a(int i5, int i6) {
            while (i5 < i6) {
                a aVar = new a(i5);
                this.f1906i.add(aVar);
                a(aVar.f1925g, (byte) 1);
                i5++;
            }
        }

        public void a(long j6, byte b) {
            try {
                this.f1904g.seek(j6);
                this.f1904g.writeByte(b);
            } catch (Throwable unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(a aVar, j jVar) throws Throwable {
            FileOutputStream fileOutputStream;
            byte[] bArrA = this.f1911n.a(new a(jVar.a(), jVar.c()).b());
            long length = this.f1904g.length();
            BufferedOutputStream bufferedOutputStream = null;
            try {
                fileOutputStream = new FileOutputStream(this.f1904g.getFD());
                try {
                    BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(fileOutputStream);
                    try {
                        this.f1904g.seek(length);
                        bufferedOutputStream2.write(bArrA);
                        bufferedOutputStream2.flush();
                        fileOutputStream.getFD().sync();
                        C0396r.a(bufferedOutputStream2, fileOutputStream);
                        aVar.a((byte) 0, jVar.d, bArrA.length, jVar.c);
                        aVar.d = length;
                        c(aVar);
                    } catch (Throwable th) {
                        th = th;
                        bufferedOutputStream = bufferedOutputStream2;
                        C0396r.a(bufferedOutputStream, fileOutputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a a(g gVar) throws IOException {
            a aVar = this.f1907j.get(gVar);
            if (aVar != null) {
                return aVar;
            }
            if (this.f1906i.isEmpty()) {
                k();
            }
            a aVarRemoveFirst = this.f1906i.removeFirst();
            aVarRemoveFirst.a((byte) 0);
            this.f1907j.put(gVar, aVarRemoveFirst);
            return aVarRemoveFirst;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public List<j> a(final List<j> list) {
            this.d.lock();
            final ArrayList arrayList = new ArrayList();
            try {
                a(new Runnable() { // from class: cn.fly.tools.utils.FlyPersistence.i.2
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Type inference failed for: r16v0 */
                    /* JADX WARN: Type inference failed for: r16v1 */
                    /* JADX WARN: Type inference failed for: r16v11 */
                    /* JADX WARN: Type inference failed for: r16v2 */
                    @Override // java.lang.Runnable
                    public void run() {
                        ?? r16;
                        FileOutputStream fileOutputStream;
                        boolean z6;
                        try {
                            long jCurrentTimeMillis = System.currentTimeMillis();
                            i.this.j();
                            boolean z7 = true;
                            if (list.size() > 1) {
                                LinkedList<a> linkedList = new LinkedList();
                                int size = list.size();
                                byte[][] bArr = new byte[size][];
                                int size2 = list.size();
                                int i5 = 0;
                                while (i5 < size2) {
                                    j jVar = (j) list.get(i5);
                                    g gVar = new g(jVar.d);
                                    byte[] bArrA = i.this.f1911n.a(new a(jVar.a(), jVar.c()).b());
                                    a aVarA = i.this.a(gVar);
                                    aVarA.a((byte) 0, jVar.d, bArrA.length, jVar.c);
                                    i.this.f1912o.a(new g(jVar.f()), new c(jVar.c, jVar.b, bArrA.length));
                                    linkedList.add(aVarA);
                                    bArr[i5] = bArrA;
                                    i5++;
                                    z7 = z7;
                                }
                                boolean z8 = z7;
                                long length = i.this.f1904g.length();
                                BufferedOutputStream bufferedOutputStream = null;
                                try {
                                    fileOutputStream = new FileOutputStream(i.this.f1904g.getFD());
                                    try {
                                        BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(fileOutputStream);
                                        try {
                                            i.this.f1904g.seek(i.this.f1904g.length());
                                            int i6 = 0;
                                            while (i6 < size) {
                                                byte[] bArr2 = bArr[i6];
                                                int length2 = bArr2.length;
                                                z6 = z8 ? 1 : 0;
                                                try {
                                                    bufferedOutputStream2.write(bArr2, 0, length2);
                                                    i6++;
                                                    z8 = z6 ? 1 : 0;
                                                } catch (Throwable th) {
                                                    th = th;
                                                    bufferedOutputStream = bufferedOutputStream2;
                                                    r16 = z6;
                                                    try {
                                                        FlyPersistence.b(th, i.this.f1909l);
                                                        FlyPersistence.c("sta err sz " + list.size(), i.this.f1909l);
                                                        for (a aVar : linkedList) {
                                                            if (aVar.b == 0) {
                                                                i.this.d(aVar);
                                                            }
                                                        }
                                                        arrayList.addAll(list);
                                                        Closeable[] closeableArr = new Closeable[2];
                                                        closeableArr[0] = bufferedOutputStream;
                                                        closeableArr[r16] = fileOutputStream;
                                                        C0396r.a(closeableArr);
                                                        linkedList.clear();
                                                        i.this.l();
                                                        FlyPersistence.d(" all cost " + (System.currentTimeMillis() - jCurrentTimeMillis) + " size " + list.size(), i.this.f1909l);
                                                    } catch (Throwable th2) {
                                                        Closeable[] closeableArr2 = new Closeable[2];
                                                        closeableArr2[0] = bufferedOutputStream;
                                                        closeableArr2[r16] = fileOutputStream;
                                                        C0396r.a(closeableArr2);
                                                        throw th2;
                                                    }
                                                }
                                            }
                                            z6 = z8 ? 1 : 0;
                                            bufferedOutputStream2.flush();
                                            fileOutputStream.getFD().sync();
                                            Closeable[] closeableArr3 = new Closeable[2];
                                            closeableArr3[0] = bufferedOutputStream2;
                                            closeableArr3[z6 ? 1 : 0] = fileOutputStream;
                                            C0396r.a(closeableArr3);
                                            for (int i7 = 0; i7 < size2; i7++) {
                                                a aVar2 = (a) linkedList.get(i7);
                                                aVar2.d = length;
                                                if (i.this.c(aVar2)) {
                                                    length += (long) bArr[i7].length;
                                                } else {
                                                    i.this.d(aVar2);
                                                    arrayList.add(list.get(i7));
                                                }
                                            }
                                        } catch (Throwable th3) {
                                            th = th3;
                                            z6 = z8;
                                        }
                                    } catch (Throwable th4) {
                                        th = th4;
                                        r16 = z8 ? 1 : 0;
                                    }
                                } catch (Throwable th5) {
                                    th = th5;
                                    r16 = z8 ? 1 : 0;
                                    fileOutputStream = null;
                                }
                                linkedList.clear();
                            } else {
                                j jVar2 = (j) list.get(0);
                                a aVarA2 = i.this.a(new g(jVar2.d));
                                try {
                                    i.this.a(aVarA2, jVar2);
                                } catch (Throwable th6) {
                                    FlyPersistence.d("set fail " + th6, i.this.f1909l);
                                    i.this.d(aVarA2);
                                    arrayList.add(jVar2);
                                }
                            }
                            i.this.l();
                            FlyPersistence.d(" all cost " + (System.currentTimeMillis() - jCurrentTimeMillis) + " size " + list.size(), i.this.f1909l);
                        } catch (Throwable th7) {
                            FlyPersistence.b(th7, i.this.f1909l);
                        }
                    }
                });
                return arrayList;
            } finally {
                this.d.unlock();
            }
        }

        private void a(long j6, byte[] bArr, int i5) {
            for (int i6 = i5 + 7; i6 >= i5; i6--) {
                bArr[i6] = (byte) (255 & j6);
                j6 >>= 8;
            }
        }

        public <T> T a(final g gVar, e<T> eVar) {
            a aVarA;
            final byte[][] bArr = new byte[1][];
            final long[] jArr = new long[1];
            final int[] iArr = new int[1];
            final Object[] objArr = new Object[1];
            this.d.lock();
            try {
                a(new Runnable() { // from class: cn.fly.tools.utils.FlyPersistence.i.4
                    @Override // java.lang.Runnable
                    public void run() {
                        c cVarA;
                        try {
                            if (!i.this.j() && (cVarA = i.this.f1912o.a(gVar)) != null && cVarA.b != null) {
                                if (cVarA.a()) {
                                    i.this.a(gVar, false);
                                    iArr[0] = 2;
                                } else {
                                    iArr[0] = 4;
                                    objArr[0] = cVarA.b;
                                }
                            }
                            a aVar = (a) i.this.f1907j.get(gVar);
                            if (aVar == null) {
                                iArr[0] = 1;
                                return;
                            }
                            if (aVar.e()) {
                                i.this.d(aVar);
                                iArr[0] = 2;
                            } else {
                                jArr[0] = aVar.f1924f;
                                bArr[0] = i.this.f(aVar);
                                iArr[0] = 3;
                            }
                        } catch (Throwable th) {
                            FlyPersistence.b(th, i.this.f1909l);
                        }
                    }
                });
                int i5 = iArr[0];
                if (i5 == 4) {
                    T t6 = (T) objArr[0];
                    this.d.unlock();
                    return t6;
                }
                if (i5 == 3) {
                    Object objA = this.f1911n.a(bArr[0], (Object) null);
                    if (objA instanceof KVEntry) {
                        KVEntry kVEntry = (KVEntry) objA;
                        aVarA = new a(kVEntry.getKey(), kVEntry.getValue());
                    } else {
                        aVarA = a.a((HashMap<Byte, Object>) objA);
                    }
                    if (aVarA != null) {
                        T tA = eVar.a(aVarA.a());
                        this.f1912o.a(gVar, new c(jArr[0], tA, bArr[0].length));
                        this.d.unlock();
                        return tA;
                    }
                    throw new NoValidDataException();
                }
                throw new NoValidDataException();
            } catch (Throwable th) {
                this.d.unlock();
                throw th;
            }
        }

        public boolean a(final g gVar, boolean z6) {
            this.d.lock();
            final boolean[] zArr = new boolean[1];
            try {
                if (z6) {
                    a(new Runnable() { // from class: cn.fly.tools.utils.FlyPersistence.i.6
                        @Override // java.lang.Runnable
                        public void run() {
                            zArr[0] = i.this.b(gVar);
                        }
                    });
                } else {
                    zArr[0] = b(gVar);
                }
                this.d.unlock();
                return zArr[0];
            } catch (Throwable th) {
                this.d.unlock();
                throw th;
            }
        }
    }

    public static class j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f1926a;
        private Object b;
        private long c;
        private byte[] d;

        public j(String str, Object obj, long j6) {
            this.f1926a = str;
            this.b = obj;
            this.c = j6;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public byte[] f() {
            return this.d;
        }

        public Object b() {
            return this.b;
        }

        public Object c() {
            return this.b;
        }

        public long d() {
            return this.c;
        }

        public boolean e() {
            return d() != 0 && d() <= System.currentTimeMillis();
        }

        public String a() {
            return this.f1926a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(byte[] bArr) {
            this.d = bArr;
        }
    }

    public FlyPersistence(Context context, final String str, String str2) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.d = reentrantReadWriteLock;
        this.e = reentrantReadWriteLock.writeLock();
        this.f1886f = reentrantReadWriteLock.readLock();
        f fVar = new f(str2);
        this.f1887g = fVar;
        this.f1885a = new i(context, str, fVar);
        if (str != null && str.startsWith(Consts.DOT) && str.length() > 1) {
            str = str.substring(1);
        }
        ScheduledExecutorService scheduledExecutorServiceNewSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor(new ThreadFactory() { // from class: cn.fly.tools.utils.FlyPersistence.1
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, "M-PL-MP-" + str);
            }
        });
        this.b = scheduledExecutorServiceNewSingleThreadScheduledExecutor;
        scheduledExecutorServiceNewSingleThreadScheduledExecutor.schedule(new d(), 3000L, TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(String str, String str2) {
        a(str, false, str2);
    }

    public static boolean b(Context context, String str) {
        String str2;
        boolean zDelete;
        if (!f1884i.contains(str)) {
            File file = new File(a(context), str);
            if (file.exists()) {
                zDelete = file.delete();
                str2 = zDelete ? "succ" : "fail";
            } else {
                zDelete = true;
                str2 = "not exist";
            }
        } else {
            str2 = "oped";
            zDelete = false;
        }
        FlyLog.getInstance().d(androidx.exifinterface.media.a.m("[CKCMP] try del mpf '", str, "': ", str2), new Object[0]);
        return zDelete;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(String str, String str2) {
        a(str, true, str2);
    }

    public static boolean a(Context context, String str) {
        File file = new File(a(context), str);
        return file.exists() && file.length() > 0;
    }

    public static File a(Context context) {
        return new File(context.getFilesDir(), m.a("004-in3hTflhk"));
    }

    public void a(j jVar) {
        if (jVar != null) {
            String strA = jVar.a();
            long jD = jVar.d();
            if (!TextUtils.isEmpty(strA) && jD >= 0) {
                jVar.a(Data.rawMD5(strA));
                this.e.lock();
                try {
                    this.c.put(strA, jVar);
                } catch (Throwable th) {
                    try {
                        b(th, this.f1885a.f1909l);
                    } finally {
                        this.e.unlock();
                    }
                }
                return;
            }
            throw new IllegalArgumentException("Key: " + strA + ", expAt: " + jD);
        }
        throw new IllegalArgumentException("dataEntry is null");
    }

    public boolean a(String str) {
        if (!TextUtils.isEmpty(str)) {
            byte[] bArrRawMD5 = Data.rawMD5(str);
            boolean[] zArr = {false};
            String[] strArr = {"f"};
            this.e.lock();
            try {
                if (!this.c.isEmpty() && this.c.containsKey(str)) {
                    this.c.remove(str);
                    zArr[0] = true;
                    strArr[0] = "m";
                }
            } catch (Throwable th) {
                try {
                    b(th, this.f1885a.f1909l);
                } catch (Throwable th2) {
                    this.e.unlock();
                    throw th2;
                }
            }
            this.e.unlock();
            zArr[0] = this.f1885a.a(new g(bArrRawMD5), true);
            StringBuilder sbY = AbstractC0157z.y("rmv: ", str, ", from: ");
            sbY.append(strArr[0]);
            sbY.append(", succ is ");
            sbY.append(zArr[0]);
            d(sbY.toString(), this.f1885a.f1909l);
            return zArr[0];
        }
        throw new IllegalArgumentException(AbstractC0157z.n("Key: ", str));
    }

    public HashMap<String, Object> b() {
        a aVarA;
        Object objA;
        Map map;
        List arrayList;
        HashMap map2 = new HashMap();
        this.f1886f.lock();
        try {
            if (!this.c.isEmpty()) {
                Iterator<Map.Entry<String, j>> it = this.c.entrySet().iterator();
                while (it.hasNext()) {
                    j value = it.next().getValue();
                    if (!value.e()) {
                        map2.put(value.a(), value.b());
                    }
                }
            }
        } catch (Throwable th) {
            try {
                b(th, this.f1885a.f1909l);
            } catch (Throwable th2) {
                this.f1886f.unlock();
                throw th2;
            }
        }
        this.f1886f.unlock();
        HashMap<String, Object> map3 = new HashMap<>();
        HashMap map4 = new HashMap();
        List<byte[]> listE = this.f1885a.e();
        if (listE.size() > 0) {
            Iterator<byte[]> it2 = listE.iterator();
            while (it2.hasNext()) {
                Object objA2 = this.f1887g.a(it2.next(), (Object) null);
                if (objA2 instanceof KVEntry) {
                    KVEntry kVEntry = (KVEntry) objA2;
                    aVarA = new a(kVEntry.getKey(), kVEntry.getValue());
                } else {
                    aVarA = a.a((HashMap<Byte, Object>) objA2);
                }
                Object objA3 = aVarA.a();
                if (objA3 != null) {
                    try {
                        objA = ((b) objA3).a((Parcelable) null);
                    } catch (Throwable unused) {
                        objA = null;
                    }
                } else {
                    objA = null;
                }
                if (objA3 != null && objA == null) {
                    try {
                        b[] bVarArr = (b[]) objA3;
                        if (bVarArr.length > 0) {
                            Parcelable[] parcelableArr = (Parcelable[]) Array.newInstance((Class<?>) bVarArr[0].a(), bVarArr.length);
                            for (int i5 = 0; i5 < parcelableArr.length; i5++) {
                                parcelableArr[i5] = bVarArr[i5].a((Parcelable) null);
                            }
                            objA = parcelableArr;
                        }
                    } catch (Throwable unused2) {
                    }
                }
                if (objA3 != null && objA == null) {
                    try {
                        List list = (List) objA3;
                        if (!list.isEmpty()) {
                            if (!(list instanceof ArrayList) && (list instanceof LinkedList)) {
                                arrayList = new LinkedList();
                            } else {
                                arrayList = new ArrayList();
                            }
                            Iterator it3 = list.iterator();
                            while (it3.hasNext()) {
                                arrayList.add(((b) it3.next()).a((Parcelable) null));
                            }
                            objA = arrayList;
                        }
                    } catch (Throwable unused3) {
                    }
                }
                if (objA3 != null && objA == null) {
                    try {
                        Map map5 = (Map) objA3;
                        if (!map5.isEmpty()) {
                            if (map5 instanceof HashMap) {
                                map = new HashMap();
                            } else if (map5 instanceof Hashtable) {
                                map = new Hashtable();
                            } else if (map5 instanceof TreeMap) {
                                map = new TreeMap();
                            } else {
                                map = new HashMap();
                            }
                            for (Map.Entry entry : map5.entrySet()) {
                                map.put(entry.getKey(), ((b) entry.getValue()).a((Parcelable) null));
                            }
                            objA = map;
                        }
                    } catch (Throwable unused4) {
                    }
                }
                if (objA != null) {
                    objA3 = objA;
                }
                map4.put(aVarA.f1889a, objA3);
            }
        }
        map3.putAll(map4);
        map3.putAll(map2);
        d("GetA done: " + map3.size(), this.f1885a.f1909l);
        return map3;
    }

    public boolean a() {
        d("cln", this.f1885a.f1909l);
        this.e.lock();
        try {
            if (!this.c.isEmpty()) {
                this.c.clear();
            }
        } catch (Throwable th) {
            try {
                b(th, this.f1885a.f1909l);
            } finally {
                this.e.unlock();
            }
        }
        return this.f1885a.d();
    }

    public <T> T a(e<T> eVar) throws NoValidDataException {
        if (eVar != null) {
            String strA = eVar.a();
            if (!TextUtils.isEmpty(strA)) {
                this.f1886f.lock();
                try {
                    try {
                        if (!this.c.isEmpty() && this.c.containsKey(strA)) {
                            j jVar = this.c.get(strA);
                            if (!jVar.e()) {
                                T t6 = (T) jVar.b();
                                this.f1886f.unlock();
                                return t6;
                            }
                            this.c.remove(strA);
                            d("Get done, exp-m: " + strA, this.f1885a.f1909l);
                            throw new NoValidDataException();
                        }
                    } catch (Throwable th) {
                        this.f1886f.unlock();
                        throw th;
                    }
                } catch (NoValidDataException e6) {
                    throw e6;
                } catch (Throwable th2) {
                    b(th2, this.f1885a.f1909l);
                }
                this.f1886f.unlock();
                try {
                    return (T) this.f1885a.a(new g(Data.rawMD5(strA)), eVar);
                } catch (Throwable unused) {
                    throw new NoValidDataException();
                }
            }
            throw new IllegalArgumentException(AbstractC0157z.n("Key: ", strA));
        }
        throw new IllegalArgumentException("deserializer is null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Throwable th, String str) {
        a(th, true, str);
    }

    private static void a(Throwable th, boolean z6, String str) {
        if (z6) {
            String strL = AbstractC0157z.l("]", f1883h, new StringBuilder("[MPF]["));
            if (str != null) {
                strL = androidx.exifinterface.media.a.A(strL, "[", str, "]");
            }
            FlyLog.getInstance().d(th, strL, new Object[0]);
        }
    }

    private static void a(String str, boolean z6, String str2) {
        if (z6) {
            String strL = AbstractC0157z.l("]", f1883h, new StringBuilder("[MPF]["));
            if (str2 != null) {
                strL = androidx.exifinterface.media.a.A(strL, "[", str2, "]");
            }
            FlyLog.getInstance().d(androidx.collection.a.n(strL, str), new Object[0]);
        }
    }
}
