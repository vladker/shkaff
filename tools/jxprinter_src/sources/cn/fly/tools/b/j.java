package cn.fly.tools.b;

import A3.AbstractC0157z;
import android.net.LocalServerSocket;
import android.net.LocalSocket;
import android.net.LocalSocketAddress;
import android.os.Parcelable;
import android.os.Process;
import cn.fly.commons.C0396r;
import cn.fly.commons.ac;
import cn.fly.tools.FlyLog;
import cn.fly.tools.utils.FlyPersistence;
import cn.fly.tools.utils.ReflectHelper;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Charset f1711a = Charset.forName("UTF-8");
    private final String b;
    private final int c;
    private final a d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile LocalServerSocket f1713g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile Thread f1714h;
    private final AtomicBoolean e = new AtomicBoolean(false);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile int f1712f = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private volatile ExecutorService f1715i = ac.e;

    public interface a {
        Object a(String str, ArrayList<Object> arrayList);
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f1718a;
        private final ArrayList<Object> b;

        private b(String str, ArrayList<Object> arrayList) {
            this.f1718a = str;
            this.b = arrayList;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f1719a;
        private final Object b;
        private final String c;

        private c(boolean z6, Object obj, String str) {
            this.f1719a = z6;
            this.b = obj;
            this.c = str;
        }
    }

    public j(String str, int i5, a aVar) {
        this.b = str;
        this.c = i5;
        this.d = aVar;
    }

    private synchronized boolean d() {
        if (this.f1712f != 2) {
            return this.f1712f == 1;
        }
        if (e()) {
            return false;
        }
        this.e.set(false);
        this.f1712f = 0;
        a();
        return this.f1712f == 1;
    }

    private boolean e() {
        LocalSocket localSocket = new LocalSocket();
        try {
            localSocket.connect(new LocalSocketAddress(this.b, LocalSocketAddress.Namespace.ABSTRACT));
            e(localSocket);
            return true;
        } catch (Throwable unused) {
            e(localSocket);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:31:0x007e A[Catch: all -> 0x0082, TryCatch #1 {all -> 0x0082, blocks: (B:29:0x007a, B:31:0x007e, B:34:0x0084), top: B:40:0x007a }] */
    /* JADX WARN: Code duplicated, block: B:40:0x007a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public void f() {
        while (this.f1712f == 1) {
            try {
                final LocalSocket localSocketAccept = this.f1713g.accept();
                ExecutorService executorService = this.f1715i;
                if (executorService == null || executorService.isShutdown()) {
                    FlyLog.getInstance().d("IPC acceptLoop: executor unavailable, closing connection", new Object[0]);
                    e(localSocketAccept);
                    synchronized (this) {
                        try {
                            if (this.f1712f == 1) {
                                g();
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    return;
                }
                try {
                    executorService.execute(new Runnable() { // from class: cn.fly.tools.b.j.2
                        @Override // java.lang.Runnable
                        public void run() {
                            j.this.b(localSocketAccept);
                        }
                    });
                } catch (Throwable th2) {
                    FlyLog.getInstance().w("IPC acceptLoop: failed to submit task, error=" + th2.getMessage());
                    e(localSocketAccept);
                    throw th2;
                }
            } catch (Throwable th3) {
                FlyLog.getInstance().w("IPC acceptLoop: fatal error, stopping server runtime, error=" + th3.getMessage());
                synchronized (this) {
                    try {
                        if (this.f1712f == 1) {
                            g();
                        }
                        return;
                    } catch (Throwable th4) {
                        throw th4;
                    }
                }
            }
            FlyLog.getInstance().w("IPC acceptLoop: fatal error, stopping server runtime, error=" + th3.getMessage());
            synchronized (this) {
                if (this.f1712f == 1) {
                    g();
                }
                return;
            }
        }
    }

    private synchronized void g() {
        LocalServerSocket localServerSocket = this.f1713g;
        this.f1713g = null;
        if (localServerSocket != null) {
            try {
                localServerSocket.close();
            } catch (Throwable unused) {
            }
        }
        this.f1714h = null;
        this.e.set(false);
        this.f1712f = 0;
    }

    public boolean b() {
        a();
        return this.f1712f == 2;
    }

    public boolean c() {
        a();
        return this.f1712f == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(LocalSocket localSocket) {
        try {
            localSocket.setSoTimeout(this.c);
            if (!c(localSocket)) {
                e(localSocket);
                return;
            }
            try {
                a(localSocket, a(a(f(localSocket))));
                e(localSocket);
            } catch (Throwable th) {
                FlyLog.getInstance().d("IPC handleSession: invalid request, error=" + th.getMessage(), new Object[0]);
                AnonymousClass1 anonymousClass1 = null;
                a(localSocket, new c(false, anonymousClass1, "invalid ipc request"));
                e(localSocket);
            }
        } catch (Throwable th2) {
            try {
                FlyLog.getInstance().w("IPC handleSession: error=" + th2.getMessage());
            } finally {
                e(localSocket);
            }
        }
    }

    private boolean c(LocalSocket localSocket) {
        int iD = d(localSocket);
        return iD > 0 && iD == Process.myUid();
    }

    public synchronized void a() {
        if (this.e.get()) {
            return;
        }
        try {
            this.f1713g = new LocalServerSocket(this.b);
            this.f1712f = 1;
            FlyLog.getInstance().d("IPC try started as SERVER", new Object[0]);
            this.f1714h = new cn.fly.tools.utils.j("DH-IPC") { // from class: cn.fly.tools.b.j.1
                @Override // cn.fly.tools.utils.j
                public void a() {
                    j.this.f();
                }
            };
            this.f1714h.setDaemon(true);
            this.f1714h.start();
        } catch (Throwable unused) {
            FlyLog.getInstance().d("IPC started as CLIENT", new Object[0]);
            this.f1712f = 2;
        }
        this.e.set(true);
    }

    private void e(LocalSocket localSocket) {
        if (localSocket == null) {
            return;
        }
        try {
            localSocket.close();
        } catch (Throwable unused) {
        }
    }

    private Object c(DataInputStream dataInputStream) throws IOException {
        List arrayList;
        Map map;
        byte b6 = dataInputStream.readByte();
        int i5 = 0;
        switch (b6) {
            case 0:
                return null;
            case 1:
                return Boolean.valueOf(dataInputStream.readBoolean());
            case 2:
                return Integer.valueOf(dataInputStream.readInt());
            case 3:
                return Long.valueOf(dataInputStream.readLong());
            case 4:
                return Double.valueOf(dataInputStream.readDouble());
            case 5:
                return Float.valueOf(dataInputStream.readFloat());
            case 6:
                return a(dataInputStream);
            case 7:
                return b(dataInputStream);
            case 8:
                return a(b(dataInputStream), a(dataInputStream));
            case 9:
                String strA = a(dataInputStream);
                int i6 = dataInputStream.readInt();
                if (i6 >= 0 && i6 <= 1024) {
                    Class cls = Parcelable.class;
                    if (strA != null) {
                        try {
                            cls = Class.forName(strA);
                            break;
                        } catch (Throwable unused) {
                        }
                    }
                    Object objNewInstance = Array.newInstance((Class<?>) cls, i6);
                    while (i5 < i6) {
                        if (!dataInputStream.readBoolean()) {
                            Array.set(objNewInstance, i5, null);
                        } else {
                            Array.set(objNewInstance, i5, a(b(dataInputStream), strA));
                        }
                        i5++;
                    }
                    return objNewInstance;
                }
                throw new IllegalStateException(AbstractC0157z.k(i6, "invalid array size: "));
            case 10:
                byte b7 = dataInputStream.readByte();
                int i7 = dataInputStream.readInt();
                if (i7 < 0 || i7 > 65536) {
                    throw new IllegalStateException(AbstractC0157z.k(i7, "invalid list size: "));
                }
                if (b7 == 2) {
                    arrayList = new LinkedList();
                } else {
                    arrayList = new ArrayList(i7);
                }
                while (i5 < i7) {
                    arrayList.add(c(dataInputStream));
                    i5++;
                }
                return arrayList;
            case 11:
                byte b8 = dataInputStream.readByte();
                int i8 = dataInputStream.readInt();
                if (i8 < 0 || i8 > 65536) {
                    throw new IllegalStateException(AbstractC0157z.k(i8, "invalid map size: "));
                }
                if (b8 == 2) {
                    map = new Hashtable();
                } else if (b8 == 3) {
                    map = new TreeMap();
                } else {
                    map = new HashMap(i8);
                }
                while (i5 < i8) {
                    map.put(a(dataInputStream), c(dataInputStream));
                    i5++;
                }
                return map;
            case 12:
                return c(b(dataInputStream));
            default:
                throw new IllegalStateException(AbstractC0157z.k(b6, "unknown ipc value type: "));
        }
    }

    private int d(LocalSocket localSocket) {
        if (localSocket == null) {
            return -1;
        }
        try {
            ReflectHelper.importClass("android.net.LocalSocket");
            Object objInvokeInstanceMethod = ReflectHelper.invokeInstanceMethod(localSocket, "getPeerCredentials", new Object[0]);
            if (objInvokeInstanceMethod == null) {
                return -1;
            }
            ReflectHelper.importClass("android.net.Credentials");
            Object objInvokeInstanceMethod2 = ReflectHelper.invokeInstanceMethod(objInvokeInstanceMethod, "getUid", new Object[0]);
            if (objInvokeInstanceMethod2 instanceof Integer) {
                return ((Integer) objInvokeInstanceMethod2).intValue();
            }
        } catch (Throwable unused) {
        }
        return -1;
    }

    public Object a(String str, ArrayList<Object> arrayList) throws Throwable {
        a();
        for (int i5 = 0; i5 <= 1; i5++) {
            LocalSocket localSocket = new LocalSocket();
            try {
                localSocket.connect(new LocalSocketAddress(this.b, LocalSocketAddress.Namespace.ABSTRACT));
                localSocket.setSoTimeout(this.c);
                if (c(localSocket)) {
                    a(localSocket, str, arrayList);
                    Object obj = a(localSocket).b;
                    try {
                        localSocket.close();
                    } catch (Throwable unused) {
                    }
                    return obj;
                }
                FlyLog.getInstance().d("IPC security violation: untrusted peer, uid=" + d(localSocket), new Object[0]);
                throw new Throwable("untrusted ipc peer");
            } catch (Throwable th) {
                try {
                    FlyLog.getInstance().d("IPC exception" + th.toString(), new Object[0]);
                    try {
                        localSocket.close();
                    } catch (Throwable unused2) {
                    }
                } catch (Throwable th2) {
                    try {
                        localSocket.close();
                    } catch (Throwable unused3) {
                    }
                    throw th2;
                }
            }
        }
        FlyLog.getInstance().d(AbstractC0157z.n("IPC request failed after all retries, key=", str), new Object[0]);
        if (d() && this.f1712f == 1) {
            c cVarA = a(new b(str, arrayList));
            if (cVarA.f1719a) {
                return cVarA.b;
            }
            throw new Throwable(cVarA.c == null ? "ipc failed" : cVarA.c);
        }
        throw new IllegalStateException("ipc request failed");
    }

    private int b(Object obj) {
        if (obj instanceof Hashtable) {
            return 2;
        }
        return obj instanceof TreeMap ? 3 : 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private c b(byte[] bArr) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        if (dataInputStream.readInt() == 1179209795) {
            short s6 = dataInputStream.readShort();
            boolean z6 = true;
            if (s6 == 1) {
                if (dataInputStream.readByte() == 2) {
                    String str = null;
                    Object[] objArr = 0;
                    Object[] objArr2 = 0;
                    Object[] objArr3 = 0;
                    if (dataInputStream.readBoolean()) {
                        return new c(z6, c(dataInputStream), str);
                    }
                    return new c(false, objArr2 == true ? 1 : 0, a(dataInputStream));
                }
                throw new IllegalStateException("invalid ipc message type");
            }
            throw new IllegalStateException(AbstractC0157z.k(s6, "unsupported ipc version: "));
        }
        throw new IllegalStateException("invalid ipc magic");
    }

    private byte[] f(LocalSocket localSocket) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(localSocket.getInputStream());
        int i5 = dataInputStream.readInt();
        if (i5 >= 0 && i5 <= 5242880) {
            byte[] bArr = new byte[i5];
            dataInputStream.readFully(bArr);
            return bArr;
        }
        throw new IllegalStateException(AbstractC0157z.k(i5, "invalid packet len: "));
    }

    private byte[] b(DataInputStream dataInputStream) throws IOException {
        int i5 = dataInputStream.readInt();
        if (i5 < 0) {
            return null;
        }
        if (i5 <= 5242880) {
            byte[] bArr = new byte[i5];
            dataInputStream.readFully(bArr);
            return bArr;
        }
        throw new IllegalStateException(AbstractC0157z.k(i5, "ipc bytes too large: "));
    }

    private c a(LocalSocket localSocket) throws Throwable {
        c cVarB = b(f(localSocket));
        if (cVarB.f1719a) {
            return cVarB;
        }
        throw new Throwable(cVarB.c == null ? "ipc failed" : cVarB.c);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private c a(b bVar) {
        a aVar = this.d;
        boolean z6 = false;
        String str = null;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        Object[] objArr4 = 0;
        Object[] objArr5 = 0;
        if (aVar != null && bVar != null) {
            try {
                return new c(true, aVar.a(bVar.f1718a, bVar.b), str);
            } catch (Throwable th) {
                String message = th.getMessage();
                if (message == null || message.length() == 0) {
                    message = th.getClass().getSimpleName();
                }
                return new c(z6, objArr4 == true ? 1 : 0, message);
            }
        }
        return new c(z6, objArr2 == true ? 1 : 0, "handler unavailable");
    }

    private int a(Object obj) {
        return obj instanceof LinkedList ? 2 : 1;
    }

    private void a(LocalSocket localSocket, String str, ArrayList<Object> arrayList) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        dataOutputStream.writeInt(1179209795);
        dataOutputStream.writeShort(1);
        dataOutputStream.writeByte(1);
        a(dataOutputStream, str);
        if (arrayList != null && !arrayList.isEmpty()) {
            dataOutputStream.writeInt(arrayList.size());
            int size = arrayList.size();
            int i5 = 0;
            while (i5 < size) {
                Object obj = arrayList.get(i5);
                i5++;
                a(dataOutputStream, obj);
            }
        } else {
            dataOutputStream.writeInt(0);
        }
        dataOutputStream.flush();
        a(localSocket, byteArrayOutputStream.toByteArray());
        C0396r.a(byteArrayOutputStream);
    }

    private byte[] c(Object obj) throws Throwable {
        if (obj == null) {
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = null;
        try {
            ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(byteArrayOutputStream);
            try {
                objectOutputStream2.writeObject(obj);
                objectOutputStream2.flush();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                C0396r.a(objectOutputStream2, byteArrayOutputStream);
                return byteArray;
            } catch (Throwable th) {
                th = th;
                objectOutputStream = objectOutputStream2;
                C0396r.a(objectOutputStream, byteArrayOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private void a(LocalSocket localSocket, c cVar) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        dataOutputStream.writeInt(1179209795);
        dataOutputStream.writeShort(1);
        dataOutputStream.writeByte(2);
        if (cVar != null) {
            dataOutputStream.writeBoolean(cVar.f1719a);
            if (cVar.f1719a) {
                try {
                    a(dataOutputStream, cVar.b);
                } catch (Throwable th) {
                    byteArrayOutputStream.reset();
                    dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                    dataOutputStream.writeInt(1179209795);
                    dataOutputStream.writeShort(1);
                    dataOutputStream.writeByte(2);
                    dataOutputStream.writeBoolean(false);
                    String message = th.getMessage();
                    if (message == null || message.length() == 0) {
                        message = "ipc encode failed";
                    }
                    a(dataOutputStream, message);
                }
            } else {
                a(dataOutputStream, cVar.c);
            }
            dataOutputStream.flush();
            a(localSocket, byteArrayOutputStream.toByteArray());
            C0396r.a(byteArrayOutputStream);
            return;
        }
        dataOutputStream.writeBoolean(false);
        a(dataOutputStream, "null response");
        dataOutputStream.flush();
        a(localSocket, byteArrayOutputStream.toByteArray());
    }

    private Object c(byte[] bArr) throws Throwable {
        ObjectInputStream objectInputStream;
        Throwable th;
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
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
            objectInputStream = null;
            th = th3;
        }
    }

    private b a(byte[] bArr) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        if (dataInputStream.readInt() == 1179209795) {
            short s6 = dataInputStream.readShort();
            if (s6 == 1) {
                if (dataInputStream.readByte() == 1) {
                    String strA = a(dataInputStream);
                    int i5 = dataInputStream.readInt();
                    if (i5 >= 0 && i5 <= 1024) {
                        ArrayList arrayList = new ArrayList(i5);
                        for (int i6 = 0; i6 < i5; i6++) {
                            arrayList.add(c(dataInputStream));
                        }
                        return new b(strA, arrayList);
                    }
                    throw new IllegalStateException(AbstractC0157z.k(i5, "invalid ipc param count: "));
                }
                throw new IllegalStateException("invalid ipc message type");
            }
            throw new IllegalStateException(AbstractC0157z.k(s6, "unsupported ipc version: "));
        }
        throw new IllegalStateException("invalid ipc magic");
    }

    private void a(LocalSocket localSocket, byte[] bArr) throws IOException {
        if (bArr != null) {
            if (bArr.length <= 5242880) {
                DataOutputStream dataOutputStream = new DataOutputStream(localSocket.getOutputStream());
                dataOutputStream.writeInt(bArr.length);
                dataOutputStream.write(bArr);
                dataOutputStream.flush();
                return;
            }
            throw new IllegalStateException("ipc payload too large: " + bArr.length);
        }
        throw new IllegalArgumentException("payload == null");
    }

    private void a(DataOutputStream dataOutputStream, String str) throws IOException {
        if (str == null) {
            dataOutputStream.writeInt(-1);
            return;
        }
        byte[] bytes = str.getBytes(f1711a);
        dataOutputStream.writeInt(bytes.length);
        dataOutputStream.write(bytes);
    }

    private String a(DataInputStream dataInputStream) throws IOException {
        int i5 = dataInputStream.readInt();
        if (i5 < 0) {
            return null;
        }
        if (i5 <= 262144) {
            byte[] bArr = new byte[i5];
            dataInputStream.readFully(bArr);
            return new String(bArr, f1711a);
        }
        throw new IllegalStateException(AbstractC0157z.k(i5, "ipc string too large: "));
    }

    private void a(DataOutputStream dataOutputStream, byte[] bArr) throws IOException {
        if (bArr == null) {
            dataOutputStream.writeInt(-1);
        } else {
            dataOutputStream.writeInt(bArr.length);
            dataOutputStream.write(bArr);
        }
    }

    private void a(DataOutputStream dataOutputStream, Object obj) throws IOException {
        Class<?> componentType;
        if (obj == null) {
            dataOutputStream.writeByte(0);
            return;
        }
        if (obj instanceof Boolean) {
            dataOutputStream.writeByte(1);
            dataOutputStream.writeBoolean(((Boolean) obj).booleanValue());
            return;
        }
        if (obj instanceof Integer) {
            dataOutputStream.writeByte(2);
            dataOutputStream.writeInt(((Integer) obj).intValue());
            return;
        }
        if (obj instanceof Long) {
            dataOutputStream.writeByte(3);
            dataOutputStream.writeLong(((Long) obj).longValue());
            return;
        }
        if (obj instanceof Double) {
            dataOutputStream.writeByte(4);
            dataOutputStream.writeDouble(((Double) obj).doubleValue());
            return;
        }
        if (obj instanceof Float) {
            dataOutputStream.writeByte(5);
            dataOutputStream.writeFloat(((Float) obj).floatValue());
            return;
        }
        if (obj instanceof String) {
            dataOutputStream.writeByte(6);
            a(dataOutputStream, (String) obj);
            return;
        }
        if (obj instanceof byte[]) {
            dataOutputStream.writeByte(7);
            a(dataOutputStream, (byte[]) obj);
            return;
        }
        if (obj instanceof Parcelable) {
            dataOutputStream.writeByte(8);
            Parcelable parcelable = (Parcelable) obj;
            a(dataOutputStream, parcelable.getClass().getName());
            a(dataOutputStream, a(parcelable));
            return;
        }
        Class<?> cls = obj.getClass();
        if (cls.isArray() && (componentType = cls.getComponentType()) != null && Parcelable.class.isAssignableFrom(componentType)) {
            dataOutputStream.writeByte(9);
            a(dataOutputStream, componentType.getName());
            int length = Array.getLength(obj);
            dataOutputStream.writeInt(length);
            for (int i5 = 0; i5 < length; i5++) {
                Object obj2 = Array.get(obj, i5);
                if (obj2 == null) {
                    dataOutputStream.writeBoolean(false);
                } else {
                    dataOutputStream.writeBoolean(true);
                    a(dataOutputStream, a((Parcelable) obj2));
                }
            }
            return;
        }
        if (obj instanceof List) {
            dataOutputStream.writeByte(10);
            dataOutputStream.writeByte(a(obj));
            List list = (List) obj;
            dataOutputStream.writeInt(list.size());
            Iterator it = list.iterator();
            while (it.hasNext()) {
                a(dataOutputStream, it.next());
            }
            return;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            Iterator it2 = map.keySet().iterator();
            while (it2.hasNext()) {
                if (!(it2.next() instanceof String)) {
                    FlyLog.getInstance().d("IPC writeValue: Map with non-String keys, using Java serialization", new Object[0]);
                    dataOutputStream.writeByte(12);
                    a(dataOutputStream, c(obj));
                    return;
                }
            }
            dataOutputStream.writeByte(11);
            dataOutputStream.writeByte(b(obj));
            dataOutputStream.writeInt(map.size());
            for (Object obj3 : map.keySet()) {
                a(dataOutputStream, (String) obj3);
                a(dataOutputStream, map.get(obj3));
            }
            return;
        }
        if (obj instanceof Serializable) {
            FlyLog.getInstance().d("IPC writeValue: unsupported type, using Java serialization, type=".concat(obj.getClass().getName()), new Object[0]);
            dataOutputStream.writeByte(12);
            a(dataOutputStream, c(obj));
            return;
        }
        throw new IllegalArgumentException("unsupported value for ipc: ".concat(obj.getClass().getName()));
    }

    private byte[] a(Parcelable parcelable) {
        if (parcelable == null) {
            return new byte[0];
        }
        return new FlyPersistence.b(parcelable).b();
    }

    private Object a(byte[] bArr, String str) {
        if (bArr != null && bArr.length != 0 && str != null && str.length() != 0) {
            try {
                Class<?> cls = Class.forName(str);
                if (Parcelable.class.isAssignableFrom(cls)) {
                    return new FlyPersistence.b(cls, bArr).a((Parcelable) null);
                }
                return null;
            } catch (Throwable unused) {
            }
        }
        return null;
    }
}
