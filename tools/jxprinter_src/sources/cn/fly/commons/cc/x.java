package cn.fly.commons.cc;

import A3.AbstractC0157z;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigInteger;
import java.net.UnknownHostException;
import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes.dex */
public class x {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected ArrayList<Object> f1385a;
        protected DataInputStream b;
        protected int c;

        public void a() {
            this.b.readShort();
        }

        public <T> T b() {
            return (T) this.f1385a.get(this.b.readShort());
        }

        public int c() {
            return this.c;
        }

        private a(ArrayList<Object> arrayList, DataInputStream dataInputStream, int i5) {
            this.f1385a = arrayList;
            this.b = dataInputStream;
            this.c = i5;
        }

        public void a(y yVar) {
            yVar.b = (String) this.f1385a.get(this.b.readShort());
            yVar.c = this.b.readShort();
        }
    }

    public static class b extends a {
        @Override // cn.fly.commons.cc.x.a
        public void a() throws IOException {
            this.b.readInt();
        }

        @Override // cn.fly.commons.cc.x.a
        public <T> T b() {
            return (T) this.f1385a.get(this.b.readInt());
        }

        private b(ArrayList<Object> arrayList, DataInputStream dataInputStream, int i5) {
            super(arrayList, dataInputStream, i5);
        }

        @Override // cn.fly.commons.cc.x.a
        public void a(y yVar) {
            yVar.b = (String) this.f1385a.get(this.b.readInt());
            yVar.c = this.b.readInt();
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private d f1386a;

        public c a(Object obj) {
            this.f1386a.a(obj);
            return this;
        }

        private c(Object obj) {
            this.f1386a = new d(obj);
        }

        public d a(String str, Object obj) {
            return this.f1386a.a(str, obj);
        }

        public d a(String str, Class<?> cls) {
            return this.f1386a.a(str, cls);
        }

        public void a() throws Throwable {
            this.f1386a.a();
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ArrayList<Object> f1387a;
        private ArrayList<Object> b;
        private HashMap<String, Object> c;
        private HashMap<String, Object> d;
        private String e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private HashMap<Class<?>, Class<? extends t<?>>> f1388f;

        private d(Object obj) {
            ArrayList<Object> arrayList = new ArrayList<>();
            this.f1387a = arrayList;
            arrayList.add(obj);
            this.b = new ArrayList<>();
            this.c = new HashMap<>();
            this.d = new HashMap<>();
            this.f1388f = new HashMap<>();
            this.c.put("t_map", this.d);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Object obj) {
            this.f1387a.add(obj);
        }

        public d a(String str, Object obj) {
            this.c.put(str, obj);
            return this;
        }

        public d a(String str, Class<?> cls) {
            w.f1384a.put(str, cls);
            return this;
        }

        public d a(String str) {
            this.e = str;
            return this;
        }

        public <T> d a(Class<T> cls, Class<? extends t<T>> cls2) {
            this.f1388f.put(cls, cls2);
            return this;
        }

        public void a() throws Throwable {
            byte[] bytes;
            InputStream byteArrayInputStream;
            ArrayList<y> arrayList = new ArrayList<>();
            String str = this.e;
            int i5 = 0;
            if (str != null) {
                bytes = str.getBytes("UTF-8");
                System.arraycopy(bytes, 0, new byte[16], 0, Math.min(bytes.length, 16));
            } else {
                bytes = null;
            }
            try {
                u uVar = new u();
                ArrayList<Object> arrayList2 = this.f1387a;
                int size = arrayList2.size();
                while (i5 < size) {
                    Object obj = arrayList2.get(i5);
                    i5++;
                    if (obj instanceof String) {
                        byteArrayInputStream = new FileInputStream((String) obj);
                    } else if (obj instanceof byte[]) {
                        byteArrayInputStream = new ByteArrayInputStream((byte[]) obj);
                    } else {
                        throw new ClassCastException("program is not string or byte array");
                    }
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    a(byteArrayInputStream, arrayList, uVar);
                    this.d.put("l_t", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
                }
                for (Map.Entry<Class<?>, Class<? extends t<?>>> entry : this.f1388f.entrySet()) {
                    uVar.a(entry.getKey(), entry.getValue());
                }
                new w(arrayList, this.b).a(this.c, uVar);
            } catch (Throwable th) {
                th = th;
                if (bytes != null) {
                    String string = th.getMessage() == null ? th.getClass().toString() : th.getMessage();
                    if (th instanceof v) {
                        th = th.getCause();
                    }
                    StringBuilder sbX = AbstractC0157z.x(string, " ");
                    sbX.append(a(th));
                    throw new v(a(bytes, sbX.toString()), th);
                }
                throw th;
            }
        }

        private String a(Throwable th) {
            if (th == null) {
                return "";
            }
            Throwable cause = th;
            while (true) {
                StringWriter stringWriter = null;
                if (cause != null) {
                    try {
                        if (cause instanceof UnknownHostException) {
                            return "";
                        }
                        cause = cause.getCause();
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } else {
                    StringWriter stringWriter2 = new StringWriter();
                    try {
                        PrintWriter printWriter = new PrintWriter(stringWriter2);
                        th.printStackTrace(printWriter);
                        printWriter.flush();
                        printWriter.close();
                        String string = stringWriter2.toString();
                        try {
                            stringWriter2.close();
                        } catch (Throwable unused) {
                        }
                        return string;
                    } catch (Throwable th3) {
                        th = th3;
                        stringWriter = stringWriter2;
                    }
                }
                th = th2;
                try {
                    if (th instanceof OutOfMemoryError) {
                        return cn.fly.commons.m.a("023Hgl0hk)gnOkfeFgjheflDfehBgnHkZflfk]gSglkhfmfmfh");
                    }
                    return th.getMessage();
                } finally {
                    if (stringWriter != null) {
                        try {
                            stringWriter.close();
                        } catch (Throwable unused2) {
                        }
                    }
                }
            }
        }

        private String a(byte[] bArr, String str) {
            Cipher cipher;
            if (bArr == null) {
                return str;
            }
            try {
                byte[] bytes = str.getBytes("UTF-8");
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, cn.fly.commons.m.a("003Khfikgn"));
                StringBuilder sb = new StringBuilder();
                sb.append(cn.fly.commons.m.a("003Bhfikgn"));
                sb.append(cn.fly.commons.m.a("003n[ikgf"));
                sb.append(cn.fly.commons.m.a("0088hl*nQinkegfgnkmin"));
                sb.append(cn.fly.commons.m.a("006f0fefefkRgPgl"));
                Provider provider = Security.getProvider(cn.fly.commons.m.a("002=hlgf"));
                if (provider != null) {
                    cipher = Cipher.getInstance(sb.toString(), provider);
                } else {
                    cipher = Cipher.getInstance(sb.toString(), cn.fly.commons.m.a("002_hlgf"));
                }
                Cipher cipher2 = cipher;
                cipher2.init(1, secretKeySpec);
                byte[] bArr2 = new byte[cipher2.getOutputSize(bytes.length)];
                cipher2.doFinal(bArr2, cipher2.update(bytes, 0, bytes.length, bArr2, 0));
                return new BigInteger(1, bArr2).toString(16);
            } catch (Throwable unused) {
                return "";
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v1, types: [cn.fly.commons.cc.x$1] */
        /* JADX WARN: Type inference failed for: r1v13 */
        /* JADX WARN: Type inference failed for: r1v2, types: [java.io.InputStream] */
        /* JADX WARN: Type inference failed for: r1v3 */
        /* JADX WARN: Type inference failed for: r1v4 */
        private void a(InputStream inputStream, ArrayList<y> arrayList, u uVar) throws Throwable {
            a aVar;
            ByteArrayInputStream byteArrayInputStream;
            ByteArrayInputStream byteArrayInputStream2;
            if (inputStream.read() != 70) {
                inputStream.close();
                return;
            }
            ?? r6 = 0;
            dataInputStream = null;
            DataInputStream dataInputStream = null;
            dataInputStream = null;
            DataInputStream dataInputStream2 = null;
            r6 = 0;
            try {
                long jCurrentTimeMillis = System.currentTimeMillis();
                int i5 = inputStream.read();
                if (i5 == 1 || i5 == 2) {
                    inputStream = new GZIPInputStream(inputStream);
                }
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 4096);
                try {
                    DataInputStream dataInputStream3 = new DataInputStream(bufferedInputStream);
                    try {
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(null);
                        int i6 = dataInputStream3.readInt();
                        for (int i7 = 0; i7 < i6; i7++) {
                            arrayList2.add(Integer.valueOf(dataInputStream3.readInt()));
                        }
                        int i8 = dataInputStream3.readInt();
                        for (int i9 = 0; i9 < i8; i9++) {
                            arrayList2.add(Long.valueOf(dataInputStream3.readLong()));
                        }
                        int i10 = dataInputStream3.readInt();
                        for (int i11 = 0; i11 < i10; i11++) {
                            arrayList2.add(Float.valueOf(dataInputStream3.readFloat()));
                        }
                        int i12 = dataInputStream3.readInt();
                        for (int i13 = 0; i13 < i12; i13++) {
                            arrayList2.add(Double.valueOf(dataInputStream3.readDouble()));
                        }
                        int i14 = dataInputStream3.readInt();
                        for (int i15 = 0; i15 < i14; i15++) {
                            arrayList2.add(Boolean.valueOf(dataInputStream3.readBoolean()));
                        }
                        int i16 = dataInputStream3.readInt();
                        if (i5 == 2) {
                            byte[] bArr = new byte[dataInputStream3.readInt()];
                            dataInputStream3.readFully(bArr);
                            try {
                                byteArrayInputStream2 = new ByteArrayInputStream(bArr);
                                try {
                                    DataInputStream dataInputStream4 = new DataInputStream(new BufferedInputStream(new GZIPInputStream(byteArrayInputStream2), 2048));
                                    for (int i17 = 0; i17 < i16; i17++) {
                                        try {
                                            arrayList2.add(dataInputStream4.readUTF());
                                        } catch (Throwable th) {
                                            th = th;
                                            dataInputStream = dataInputStream4;
                                            if (dataInputStream != null) {
                                                dataInputStream.close();
                                            } else if (byteArrayInputStream2 != null) {
                                                byteArrayInputStream2.close();
                                            }
                                            throw th;
                                        }
                                    }
                                    dataInputStream4.close();
                                } catch (Throwable th2) {
                                    th = th2;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                byteArrayInputStream2 = null;
                            }
                        } else {
                            for (int i18 = 0; i18 < i16; i18++) {
                                arrayList2.add(dataInputStream3.readUTF());
                            }
                        }
                        if (dataInputStream3.readByte() == 15) {
                            long jCurrentTimeMillis2 = System.currentTimeMillis();
                            this.d.put("lc_t", Long.valueOf(jCurrentTimeMillis2 - jCurrentTimeMillis));
                            if (dataInputStream3.readBoolean()) {
                                aVar = new b(arrayList2, dataInputStream3, arrayList.size());
                            } else {
                                aVar = new a(arrayList2, dataInputStream3, arrayList.size());
                            }
                            int i19 = dataInputStream3.readInt();
                            boolean z6 = dataInputStream3.readBoolean();
                            if (dataInputStream3.readByte() == 25) {
                                for (int i20 = 0; i20 < i19; i20++) {
                                    y yVar = new y();
                                    yVar.f1389a = dataInputStream3.readByte();
                                    if (z6) {
                                        aVar.a(yVar);
                                    }
                                    yVar.a(aVar);
                                    arrayList.add(yVar);
                                }
                                if (dataInputStream3.readByte() == 39) {
                                    long jCurrentTimeMillis3 = System.currentTimeMillis();
                                    this.d.put("lcmd_t", Long.valueOf(jCurrentTimeMillis3 - jCurrentTimeMillis2));
                                    byte[] bArr2 = new byte[dataInputStream3.readInt()];
                                    dataInputStream3.readFully(bArr2);
                                    if (i5 == 2) {
                                        try {
                                            byteArrayInputStream = new ByteArrayInputStream(bArr2);
                                            try {
                                                DataInputStream dataInputStream5 = new DataInputStream(new GZIPInputStream(byteArrayInputStream));
                                                try {
                                                    byte[] bArr3 = new byte[dataInputStream5.readInt()];
                                                    dataInputStream5.readFully(bArr3);
                                                    dataInputStream5.close();
                                                    bArr2 = bArr3;
                                                } catch (Throwable th4) {
                                                    th = th4;
                                                    dataInputStream2 = dataInputStream5;
                                                    if (dataInputStream2 != null) {
                                                        dataInputStream2.close();
                                                    } else if (byteArrayInputStream != null) {
                                                        byteArrayInputStream.close();
                                                    }
                                                    throw th;
                                                }
                                            } catch (Throwable th5) {
                                                th = th5;
                                            }
                                        } catch (Throwable th6) {
                                            th = th6;
                                            byteArrayInputStream = null;
                                        }
                                    }
                                    uVar.a(bArr2);
                                    this.d.put("mreg_t", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis3));
                                    try {
                                        dataInputStream3.close();
                                        return;
                                    } catch (Throwable unused) {
                                        return;
                                    }
                                }
                                throw new RuntimeException("data has offset in pos 3");
                            }
                            throw new RuntimeException("data has offset in pos 2");
                        }
                        throw new RuntimeException("data has offset in pos 1");
                    } catch (Throwable th7) {
                        th = th7;
                        r6 = dataInputStream3;
                        inputStream = bufferedInputStream;
                        try {
                            if (r6 != 0) {
                                r6.close();
                            } else {
                                inputStream.close();
                            }
                        } catch (Throwable unused2) {
                        }
                        throw th;
                    }
                } catch (Throwable th8) {
                    th = th8;
                }
            } catch (Throwable th9) {
                th = th9;
            }
        }
    }

    private x() {
    }

    public static int a() {
        return 70;
    }

    public static c a(String... strArr) {
        return a((Object[]) strArr);
    }

    public static c a(byte[]... bArr) {
        return a((Object[]) bArr);
    }

    private static c a(Object[] objArr) {
        if (objArr.length == 0) {
            return null;
        }
        c cVar = new c(objArr[0]);
        for (int i5 = 1; i5 < objArr.length; i5++) {
            cVar.a(objArr[i5]);
        }
        return cVar;
    }
}
