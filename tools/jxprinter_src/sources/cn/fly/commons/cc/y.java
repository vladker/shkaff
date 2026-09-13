package cn.fly.commons.cc;

import A3.AbstractC0157z;
import com.alibaba.android.arouter.utils.Consts;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import kotlinx.serialization.json.internal.AbstractC1127c;

/* JADX INFO: loaded from: classes.dex */
public class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1389a;
    public String b;
    public int c;
    public String d;
    public String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f1390f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f1391g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f1392h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f1393i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f1394j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f1395k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f1396l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Object[] f1397m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f1398n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String[] f1399o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f1400p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Object f1401q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f1402r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f1403s;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f1404a;
        public s b;
        public List<Object> c;
        public boolean d;
        public boolean e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public ArrayList<y> f1405f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public ArrayList<Object> f1406g;

        public Object a() {
            return this.b.a();
        }

        public Object b(String str) {
            return this.b.a(str);
        }

        public void a(Object obj) {
            this.b.a(obj);
        }

        public void b(String str, Object obj) {
            this.b.a(str, obj);
        }

        public Class<?> a(String str) {
            return this.b.b(str);
        }

        public void a(String str, Class<?> cls) {
            this.b.a(str, cls);
        }

        public void a(String str, Object obj) {
            this.b.b(str, obj);
        }
    }

    public y(int i5) {
        this.f1389a = i5;
    }

    public void a(x.a aVar) {
        int i5 = 0;
        switch (this.f1389a) {
            case 1:
                this.f1392h = (String) aVar.b();
                aVar.a();
                break;
            case 2:
                this.f1401q = aVar.b();
                break;
            case 3:
                this.f1392h = (String) aVar.b();
                break;
            case 4:
                this.f1395k = ((Integer) aVar.b()).intValue();
                break;
            case 5:
                this.f1395k = ((Integer) aVar.b()).intValue();
                break;
            case 6:
                this.f1403s = ((Integer) aVar.b()).intValue();
                break;
            case 7:
                this.f1402r = ((Integer) aVar.b()).intValue();
                break;
            case 9:
                this.f1392h = (String) aVar.b();
                break;
            case 10:
                this.d = (String) aVar.b();
                this.e = (String) aVar.b();
                break;
            case 11:
                this.f1396l = (String) aVar.b();
                break;
            case 12:
                this.f1400p = (String) aVar.b();
                this.f1393i = ((Integer) aVar.b()).intValue();
                break;
            case 13:
                this.f1398n = (String) aVar.b();
                this.f1396l = (String) aVar.b();
                break;
            case 14:
                this.f1398n = (String) aVar.b();
                this.f1400p = (String) aVar.b();
                this.f1393i = ((Integer) aVar.b()).intValue();
                break;
            case 16:
                this.f1393i = ((Integer) aVar.b()).intValue();
                break;
            case 17:
                this.f1398n = (String) aVar.b();
                break;
            case 18:
                this.f1398n = (String) aVar.b();
                this.f1393i = ((Integer) aVar.b()).intValue();
                break;
            case 19:
                this.f1392h = (String) aVar.b();
                break;
            case 20:
                this.f1390f = (String) aVar.b();
                break;
            case 21:
                this.f1390f = (String) aVar.b();
                int iIntValue = ((Integer) aVar.b()).intValue();
                this.f1391g = iIntValue;
                this.f1391g = aVar.c() + iIntValue;
                break;
            case 22:
                this.f1390f = (String) aVar.b();
                int iIntValue2 = ((Integer) aVar.b()).intValue();
                this.f1391g = iIntValue2;
                this.f1391g = aVar.c() + iIntValue2;
                break;
            case 24:
                this.f1396l = (String) aVar.b();
                break;
            case 26:
                this.f1398n = (String) aVar.b();
                this.f1396l = (String) aVar.b();
                break;
            case 27:
                this.f1398n = (String) aVar.b();
                break;
            case 29:
                this.f1392h = (String) aVar.b();
                this.f1393i = ((Integer) aVar.b()).intValue();
                int iIntValue3 = ((Integer) aVar.b()).intValue();
                this.f1394j = iIntValue3;
                this.f1394j = aVar.c() + iIntValue3;
                break;
            case 31:
                this.f1392h = (String) aVar.b();
                this.f1393i = ((Integer) aVar.b()).intValue();
                break;
            case 32:
                this.f1393i = ((Integer) aVar.b()).intValue();
                break;
            case 35:
                this.d = (String) aVar.b();
                this.e = (String) aVar.b();
                break;
            case 36:
                int iIntValue4 = ((Integer) aVar.b()).intValue();
                this.f1399o = new String[iIntValue4];
                while (i5 < iIntValue4) {
                    this.f1399o[i5] = (String) aVar.b();
                    aVar.a();
                    i5++;
                }
                break;
            case 37:
                int iIntValue5 = ((Integer) aVar.b()).intValue();
                this.f1397m = new Object[iIntValue5];
                while (i5 < iIntValue5) {
                    this.f1397m[i5] = aVar.b();
                    i5++;
                }
                break;
            case 38:
                int iIntValue6 = ((Integer) aVar.b()).intValue();
                this.f1399o = new String[iIntValue6];
                while (i5 < iIntValue6) {
                    this.f1399o[i5] = (String) aVar.b();
                    i5++;
                }
                break;
        }
    }

    public void b(Object obj, s sVar) throws Throwable {
        Field declaredField;
        Object objA = sVar.a();
        if (obj instanceof Map) {
            ((Map) obj).put(this.f1396l, objA);
            return;
        }
        for (Class<?> superclass = obj.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
            try {
                declaredField = superclass.getDeclaredField(this.f1396l);
            } catch (Throwable unused) {
                declaredField = null;
            }
            if (declaredField != null && !Modifier.isStatic(declaredField.getModifiers())) {
                declaredField.setAccessible(true);
                declaredField.set(obj, objA);
                return;
            }
        }
        y yVar = new y(12);
        yVar.b = this.b;
        yVar.c = this.c;
        StringBuilder sb = new StringBuilder("set");
        sb.append(Character.toUpperCase(this.f1396l.charAt(0)));
        yVar.f1400p = androidx.exifinterface.media.a.j(this.f1396l, 1, sb);
        yVar.f1393i = 1;
        yVar.a(obj, new Object[]{objA}, sVar);
    }

    public y() {
    }

    public void b(Class<?> cls, s sVar) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException {
        Field declaredField;
        Object objA = sVar.a();
        while (cls != null) {
            try {
                declaredField = cls.getDeclaredField(this.f1396l);
            } catch (Throwable unused) {
                declaredField = null;
            }
            if (declaredField != null && Modifier.isStatic(declaredField.getModifiers())) {
                declaredField.setAccessible(true);
                declaredField.set(null, objA);
                return;
            }
            cls = cls.getSuperclass();
        }
        y yVar = new y(14);
        yVar.b = this.b;
        yVar.c = this.c;
        yVar.f1398n = this.f1398n;
        StringBuilder sb = new StringBuilder("set");
        sb.append(Character.toUpperCase(this.f1396l.charAt(0)));
        yVar.f1400p = androidx.exifinterface.media.a.j(this.f1396l, 1, sb);
        yVar.f1393i = 1;
        yVar.a(cls, new Object[]{objA}, sVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:453:0x09cd  */
    /* JADX WARN: Code duplicated, block: B:455:0x09d9  */
    /* JADX WARN: Code duplicated, block: B:457:0x09e6  */
    /* JADX WARN: Code duplicated, block: B:459:0x09ea  */
    /* JADX WARN: Code duplicated, block: B:463:0x09f9 A[LOOP:13: B:461:0x09f6->B:463:0x09f9, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:466:0x0a06  */
    /* JADX WARN: Code duplicated, block: B:468:0x0a0e  */
    public void a(a aVar) throws Throwable {
        Object bigInteger;
        Object objValueOf;
        InputStream byteArrayInputStream;
        boolean z6;
        OutputStream fileOutputStream;
        boolean z7;
        byte[] bArr;
        int i5;
        File file;
        int length;
        int iIntValue;
        Object objSubstring;
        Object zVar;
        int i6 = 0;
        int i7 = 0;
        try {
            switch (this.f1389a) {
                case 1:
                    aVar.b(this.f1392h, aVar.a());
                    return;
                case 2:
                    aVar.a(this.f1401q);
                    return;
                case 3:
                    aVar.a(aVar.b(this.f1392h));
                    return;
                case 4:
                    Object objA = aVar.a();
                    Object objA2 = aVar.a();
                    switch (this.f1395k) {
                        case 12:
                            if (objA == null) {
                                if (objA2 == null) {
                                    aVar.a(Boolean.TRUE);
                                    return;
                                } else {
                                    aVar.a(Boolean.FALSE);
                                    return;
                                }
                            }
                            if ((objA instanceof Number) && (objA2 instanceof Number)) {
                                aVar.a(Boolean.valueOf(((Number) objA).doubleValue() == ((Number) objA2).doubleValue()));
                                return;
                            } else {
                                aVar.a(Boolean.valueOf(objA.equals(objA2)));
                                return;
                            }
                        case 13:
                            if (objA == null) {
                                if (objA2 == null) {
                                    aVar.a(Boolean.FALSE);
                                    return;
                                } else {
                                    aVar.a(Boolean.TRUE);
                                    return;
                                }
                            }
                            if ((objA instanceof Number) && (objA2 instanceof Number)) {
                                aVar.a(Boolean.valueOf(((Number) objA).doubleValue() != ((Number) objA2).doubleValue()));
                                return;
                            } else {
                                aVar.a(Boolean.valueOf(!objA.equals(objA2)));
                                return;
                            }
                        case 14:
                            if ((objA instanceof Number) && (objA2 instanceof Number)) {
                                aVar.a(Boolean.valueOf(((Number) objA).doubleValue() < ((Number) objA2).doubleValue()));
                                return;
                            } else {
                                aVar.a(Boolean.valueOf(((Comparable) objA).compareTo(objA2) < 0));
                                return;
                            }
                        case 15:
                            if ((objA instanceof Number) && (objA2 instanceof Number)) {
                                aVar.a(Boolean.valueOf(((Number) objA).doubleValue() > ((Number) objA2).doubleValue()));
                                return;
                            } else {
                                aVar.a(Boolean.valueOf(((Comparable) objA).compareTo(objA2) > 0));
                                return;
                            }
                        case 16:
                            if ((objA instanceof Number) && (objA2 instanceof Number)) {
                                aVar.a(Boolean.valueOf(((Number) objA).doubleValue() <= ((Number) objA2).doubleValue()));
                                return;
                            } else {
                                aVar.a(Boolean.valueOf(((Comparable) objA).compareTo(objA2) <= 0));
                                return;
                            }
                        case 17:
                            if ((objA instanceof Number) && (objA2 instanceof Number)) {
                                aVar.a(Boolean.valueOf(((Number) objA).doubleValue() >= ((Number) objA2).doubleValue()));
                                return;
                            } else {
                                aVar.a(Boolean.valueOf(((Comparable) objA).compareTo(objA2) >= 0));
                                return;
                            }
                        case 18:
                            if (String.class.equals(objA2)) {
                                aVar.a(objA == null ? null : String.valueOf(objA));
                                return;
                            }
                            if (Number.class.equals(objA2)) {
                                String strValueOf = String.valueOf(objA);
                                if (strValueOf.contains(Consts.DOT)) {
                                    try {
                                        try {
                                            objValueOf = Float.valueOf(Float.parseFloat(strValueOf));
                                        } catch (Throwable unused) {
                                            objValueOf = Double.valueOf(Double.parseDouble(strValueOf));
                                        }
                                    } catch (Throwable unused2) {
                                        bigInteger = new BigDecimal(strValueOf);
                                        objValueOf = bigInteger;
                                    }
                                    break;
                                } else {
                                    try {
                                        try {
                                            objValueOf = Integer.valueOf(Integer.parseInt(strValueOf));
                                        } catch (Throwable unused3) {
                                            bigInteger = new BigInteger(strValueOf);
                                            objValueOf = bigInteger;
                                        }
                                    } catch (Throwable unused4) {
                                        objValueOf = Long.valueOf(Long.parseLong(strValueOf));
                                    }
                                    break;
                                }
                                aVar.a(objValueOf);
                                return;
                            }
                            if (!Double.class.equals(objA2) && !Double.TYPE.equals(objA2)) {
                                if (!Float.class.equals(objA2) && !Float.TYPE.equals(objA2)) {
                                    if (!Integer.class.equals(objA2) && !Integer.TYPE.equals(objA2)) {
                                        if (!Long.class.equals(objA2) && !Long.TYPE.equals(objA2)) {
                                            if (!Short.class.equals(objA2) && !Short.TYPE.equals(objA2)) {
                                                if (!Character.class.equals(objA2) && !Character.TYPE.equals(objA2)) {
                                                    if (!Byte.class.equals(objA2) && !Byte.TYPE.equals(objA2)) {
                                                        if (!Boolean.class.equals(objA2)) {
                                                            if (BigInteger.class.equals(objA2)) {
                                                                aVar.a(new BigInteger(String.valueOf(objA)));
                                                                return;
                                                            } else if (BigDecimal.class.equals(objA2)) {
                                                                aVar.a(new BigDecimal(String.valueOf(objA)));
                                                                return;
                                                            } else {
                                                                aVar.a(((Class) objA2).cast(objA));
                                                                return;
                                                            }
                                                        }
                                                        if (objA == null) {
                                                            aVar.a(Boolean.FALSE);
                                                            return;
                                                        }
                                                        if (objA instanceof Number) {
                                                            aVar.a(Boolean.valueOf(Double.valueOf(objA.toString()).doubleValue() == 0.0d));
                                                            return;
                                                        }
                                                        if (objA instanceof String) {
                                                            aVar.a(Boolean.valueOf(((String) objA).trim().toLowerCase().equals(cn.fly.commons.x.b("004hEcicf=e"))));
                                                            return;
                                                        } else if (objA instanceof Boolean) {
                                                            aVar.a(objA);
                                                            return;
                                                        } else {
                                                            aVar.a(Boolean.TRUE);
                                                            return;
                                                        }
                                                    }
                                                    aVar.a(Byte.valueOf(Double.valueOf(String.valueOf(objA)).byteValue()));
                                                    return;
                                                }
                                                if (objA instanceof Integer) {
                                                    aVar.a(Character.valueOf((char) ((Integer) objA).intValue()));
                                                    return;
                                                }
                                                if (objA instanceof Long) {
                                                    aVar.a(Character.valueOf((char) ((Long) objA).longValue()));
                                                    return;
                                                }
                                                if (objA instanceof Short) {
                                                    aVar.a(Character.valueOf((char) ((Short) objA).shortValue()));
                                                    return;
                                                }
                                                if (objA instanceof Byte) {
                                                    aVar.a(Character.valueOf((char) ((Byte) objA).byteValue()));
                                                    return;
                                                }
                                                if (objA instanceof Double) {
                                                    aVar.a(Character.valueOf((char) ((Double) objA).doubleValue()));
                                                    return;
                                                } else {
                                                    if (objA instanceof Float) {
                                                        aVar.a(Character.valueOf((char) ((Float) objA).floatValue()));
                                                        return;
                                                    }
                                                    StringBuilder sb = new StringBuilder("Bad operator at line: ");
                                                    sb.append(this.b);
                                                    sb.append("(");
                                                    throw new RuntimeException(AbstractC0157z.l(")", this.c, sb));
                                                }
                                            }
                                            aVar.a(Short.valueOf(Double.valueOf(String.valueOf(objA)).shortValue()));
                                            return;
                                        }
                                        aVar.a(Long.valueOf(Double.valueOf(String.valueOf(objA)).longValue()));
                                        return;
                                    }
                                    aVar.a(Integer.valueOf(Double.valueOf(String.valueOf(objA)).intValue()));
                                    return;
                                }
                                aVar.a(Float.valueOf(Double.valueOf(String.valueOf(objA)).floatValue()));
                                return;
                            }
                            aVar.a(Double.valueOf(String.valueOf(objA)));
                            return;
                        case 19:
                            aVar.a(Boolean.valueOf(((Class) objA2).isInstance(objA)));
                            return;
                        case 20:
                            if (objA instanceof Collection) {
                                if (objA2 instanceof Collection) {
                                    ((Collection) objA).addAll((Collection) objA2);
                                    return;
                                } else {
                                    ((Collection) objA).add(objA2);
                                    return;
                                }
                            }
                            if ((objA instanceof Map) && (objA2 instanceof Map)) {
                                ((Map) objA).putAll((Map) objA2);
                                return;
                            }
                            if (objA2 instanceof String) {
                                byteArrayInputStream = new ByteArrayInputStream(((String) objA2).getBytes("utf-8"));
                            } else if (objA2 instanceof byte[]) {
                                byteArrayInputStream = new ByteArrayInputStream((byte[]) objA2);
                            } else if (objA2 instanceof File) {
                                byteArrayInputStream = new FileInputStream((File) objA2);
                            } else {
                                if (objA2 instanceof InputStream) {
                                    byteArrayInputStream = (InputStream) objA2;
                                    z6 = false;
                                } else if (objA2 instanceof Serializable) {
                                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                                    objectOutputStream.writeObject(objA2);
                                    objectOutputStream.flush();
                                    objectOutputStream.close();
                                    byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                                } else {
                                    StringBuilder sb2 = new StringBuilder("Bad operator at line: ");
                                    sb2.append(this.b);
                                    sb2.append("(");
                                    throw new RuntimeException(AbstractC0157z.l(")", this.c, sb2));
                                }
                                if (objA instanceof File) {
                                    file = (File) objA;
                                    if (!file.getParentFile().exists()) {
                                        file.getParentFile().mkdirs();
                                    }
                                    fileOutputStream = new FileOutputStream(file, true);
                                    z7 = z6;
                                } else if (objA instanceof OutputStream) {
                                    fileOutputStream = (OutputStream) objA;
                                    z7 = false;
                                } else {
                                    StringBuilder sb3 = new StringBuilder("Bad operator at line: ");
                                    sb3.append(this.b);
                                    sb3.append("(");
                                    throw new RuntimeException(AbstractC0157z.l(")", this.c, sb3));
                                }
                                bArr = new byte[1024];
                                for (i5 = byteArrayInputStream.read(bArr); i5 != -1; i5 = byteArrayInputStream.read(bArr)) {
                                    fileOutputStream.write(bArr, 0, i5);
                                }
                                fileOutputStream.flush();
                                if (z7) {
                                    byteArrayInputStream.close();
                                }
                                fileOutputStream.close();
                                return;
                            }
                            z6 = true;
                            if (objA instanceof File) {
                                file = (File) objA;
                                if (!file.getParentFile().exists()) {
                                    file.getParentFile().mkdirs();
                                }
                                fileOutputStream = new FileOutputStream(file, true);
                                z7 = z6;
                            } else if (objA instanceof OutputStream) {
                                fileOutputStream = (OutputStream) objA;
                                z7 = false;
                            } else {
                                StringBuilder sb4 = new StringBuilder("Bad operator at line: ");
                                sb4.append(this.b);
                                sb4.append("(");
                                throw new RuntimeException(AbstractC0157z.l(")", this.c, sb4));
                            }
                            bArr = new byte[1024];
                            while (i5 != -1) {
                                fileOutputStream.write(bArr, 0, i5);
                            }
                            fileOutputStream.flush();
                            if (z7) {
                                byteArrayInputStream.close();
                            }
                            fileOutputStream.close();
                            return;
                        case 21:
                            if (objA == null) {
                                objA = AbstractC1127c.NULL;
                            }
                            if (objA2 == null) {
                                objA2 = AbstractC1127c.NULL;
                            }
                            if ((objA instanceof Number) && (objA2 instanceof Number)) {
                                if ((objA instanceof Double) || (objA2 instanceof Double)) {
                                    aVar.a(Double.valueOf(((Number) objA2).doubleValue() + ((Number) objA).doubleValue()));
                                    return;
                                }
                                if ((objA instanceof Float) || (objA2 instanceof Float)) {
                                    aVar.a(Float.valueOf(((Number) objA2).floatValue() + ((Number) objA).floatValue()));
                                    return;
                                }
                                if ((objA instanceof Long) || (objA2 instanceof Long)) {
                                    aVar.a(Long.valueOf(((Number) objA2).longValue() + ((Number) objA).longValue()));
                                    return;
                                }
                                if ((objA instanceof Integer) || (objA2 instanceof Integer)) {
                                    aVar.a(Integer.valueOf(((Number) objA2).intValue() + ((Number) objA).intValue()));
                                    return;
                                } else if ((objA instanceof Short) || (objA2 instanceof Short)) {
                                    aVar.a(Integer.valueOf(((Number) objA2).shortValue() + ((Number) objA).shortValue()));
                                    return;
                                } else {
                                    aVar.a(Integer.valueOf(((Number) objA2).byteValue() + ((Number) objA).byteValue()));
                                    return;
                                }
                            }
                            aVar.a(String.valueOf(objA).concat(String.valueOf(objA2)));
                            return;
                        case 22:
                            if ((objA instanceof Number) && (objA2 instanceof Number)) {
                                if (!(objA instanceof Double) && !(objA2 instanceof Double)) {
                                    if (!(objA instanceof Float) && !(objA2 instanceof Float)) {
                                        if (!(objA instanceof Long) && !(objA2 instanceof Long)) {
                                            if (!(objA instanceof Integer) && !(objA2 instanceof Integer)) {
                                                if (!(objA instanceof Short) && !(objA2 instanceof Short)) {
                                                    aVar.a(Integer.valueOf(((Number) objA).byteValue() - ((Number) objA2).byteValue()));
                                                    return;
                                                } else {
                                                    aVar.a(Integer.valueOf(((Number) objA).shortValue() - ((Number) objA2).shortValue()));
                                                    return;
                                                }
                                            }
                                            aVar.a(Integer.valueOf(((Number) objA).intValue() - ((Number) objA2).intValue()));
                                            return;
                                        }
                                        aVar.a(Long.valueOf(((Number) objA).longValue() - ((Number) objA2).longValue()));
                                        return;
                                    }
                                    aVar.a(Float.valueOf(((Number) objA).floatValue() - ((Number) objA2).floatValue()));
                                    return;
                                }
                                aVar.a(Double.valueOf(((Number) objA).doubleValue() - ((Number) objA2).doubleValue()));
                                return;
                            }
                            StringBuilder sb5 = new StringBuilder("Bad operator at line: ");
                            sb5.append(this.b);
                            sb5.append("(");
                            throw new RuntimeException(AbstractC0157z.l(")", this.c, sb5));
                        case 23:
                            if ((objA instanceof Number) && (objA2 instanceof Number)) {
                                if ((objA instanceof Double) || (objA2 instanceof Double)) {
                                    aVar.a(Double.valueOf(((Number) objA2).doubleValue() * ((Number) objA).doubleValue()));
                                    return;
                                }
                                if ((objA instanceof Float) || (objA2 instanceof Float)) {
                                    aVar.a(Float.valueOf(((Number) objA2).floatValue() * ((Number) objA).floatValue()));
                                    return;
                                }
                                if ((objA instanceof Long) || (objA2 instanceof Long)) {
                                    aVar.a(Long.valueOf(((Number) objA2).longValue() * ((Number) objA).longValue()));
                                    return;
                                }
                                if ((objA instanceof Integer) || (objA2 instanceof Integer)) {
                                    aVar.a(Integer.valueOf(((Number) objA2).intValue() * ((Number) objA).intValue()));
                                    return;
                                } else if ((objA instanceof Short) || (objA2 instanceof Short)) {
                                    aVar.a(Integer.valueOf(((Number) objA2).shortValue() * ((Number) objA).shortValue()));
                                    return;
                                } else {
                                    aVar.a(Integer.valueOf(((Number) objA2).byteValue() * ((Number) objA).byteValue()));
                                    return;
                                }
                            }
                            StringBuilder sb6 = new StringBuilder("Bad operator at line: ");
                            sb6.append(this.b);
                            sb6.append("(");
                            throw new RuntimeException(AbstractC0157z.l(")", this.c, sb6));
                        case 24:
                            if ((objA instanceof Number) && (objA2 instanceof Number)) {
                                if (!(objA instanceof Double) && !(objA2 instanceof Double)) {
                                    if (!(objA instanceof Float) && !(objA2 instanceof Float)) {
                                        if (!(objA instanceof Long) && !(objA2 instanceof Long)) {
                                            if (!(objA instanceof Integer) && !(objA2 instanceof Integer)) {
                                                if (!(objA instanceof Short) && !(objA2 instanceof Short)) {
                                                    aVar.a(Integer.valueOf(((Number) objA).byteValue() / ((Number) objA2).byteValue()));
                                                    return;
                                                } else {
                                                    aVar.a(Integer.valueOf(((Number) objA).shortValue() / ((Number) objA2).shortValue()));
                                                    return;
                                                }
                                            }
                                            aVar.a(Integer.valueOf(((Number) objA).intValue() / ((Number) objA2).intValue()));
                                            return;
                                        }
                                        aVar.a(Long.valueOf(((Number) objA).longValue() / ((Number) objA2).longValue()));
                                        return;
                                    }
                                    aVar.a(Float.valueOf(((Number) objA).floatValue() / ((Number) objA2).floatValue()));
                                    return;
                                }
                                aVar.a(Double.valueOf(((Number) objA).doubleValue() / ((Number) objA2).doubleValue()));
                                return;
                            }
                            StringBuilder sb7 = new StringBuilder("Bad operator at line: ");
                            sb7.append(this.b);
                            sb7.append("(");
                            throw new RuntimeException(AbstractC0157z.l(")", this.c, sb7));
                        case 25:
                            if ((objA instanceof Number) && (objA2 instanceof Number)) {
                                if (!(objA instanceof Double) && !(objA2 instanceof Double)) {
                                    if (!(objA instanceof Float) && !(objA2 instanceof Float)) {
                                        if (!(objA instanceof Long) && !(objA2 instanceof Long)) {
                                            if (!(objA instanceof Integer) && !(objA2 instanceof Integer)) {
                                                if (!(objA instanceof Short) && !(objA2 instanceof Short)) {
                                                    aVar.a(Integer.valueOf(((Number) objA).byteValue() % ((Number) objA2).byteValue()));
                                                    return;
                                                } else {
                                                    aVar.a(Integer.valueOf(((Number) objA).shortValue() % ((Number) objA2).shortValue()));
                                                    return;
                                                }
                                            }
                                            aVar.a(Integer.valueOf(((Number) objA).intValue() % ((Number) objA2).intValue()));
                                            return;
                                        }
                                        aVar.a(Long.valueOf(((Number) objA).longValue() % ((Number) objA2).longValue()));
                                        return;
                                    }
                                    aVar.a(Float.valueOf(((Number) objA).floatValue() % ((Number) objA2).floatValue()));
                                    return;
                                }
                                aVar.a(Double.valueOf(((Number) objA).doubleValue() % ((Number) objA2).doubleValue()));
                                return;
                            }
                            StringBuilder sb8 = new StringBuilder("Bad operator at line: ");
                            sb8.append(this.b);
                            sb8.append("(");
                            throw new RuntimeException(AbstractC0157z.l(")", this.c, sb8));
                        default:
                            StringBuilder sb9 = new StringBuilder("Bad operator at line: ");
                            sb9.append(this.b);
                            sb9.append("(");
                            throw new RuntimeException(AbstractC0157z.l(")", this.c, sb9));
                    }
                case 5:
                    Object objA3 = aVar.a();
                    if (this.f1395k == 26) {
                        aVar.a(Boolean.valueOf(!((Boolean) objA3).booleanValue()));
                        return;
                    }
                    StringBuilder sb10 = new StringBuilder("Bad operator at line: ");
                    sb10.append(this.b);
                    sb10.append("(");
                    throw new RuntimeException(AbstractC0157z.l(")", this.c, sb10));
                case 6:
                    ArrayList arrayList = new ArrayList();
                    if (this.f1403s == 1) {
                        Object objA4 = aVar.a();
                        if (objA4 != null && objA4.getClass().isArray()) {
                            int length2 = Array.getLength(objA4);
                            for (int i8 = 0; i8 < length2; i8++) {
                                arrayList.add(Array.get(objA4, i8));
                            }
                        } else {
                            arrayList.add(objA4);
                        }
                    } else {
                        for (int i9 = 0; i9 < this.f1403s; i9++) {
                            arrayList.add(aVar.a());
                        }
                    }
                    aVar.a(arrayList);
                    return;
                case 7:
                    HashMap map = new HashMap();
                    for (int i10 = 0; i10 < this.f1402r; i10++) {
                        map.put(aVar.a(), aVar.a());
                    }
                    aVar.a(map);
                    return;
                case 8:
                    Object objA5 = aVar.a();
                    Object objA6 = aVar.a();
                    if (objA5 instanceof List) {
                        List list = (List) objA5;
                        if (objA6 instanceof aa) {
                            Number[] numberArrB = ((aa) objA6).b();
                            int iIntValue2 = numberArrB[0].intValue();
                            if (iIntValue2 < 0) {
                                iIntValue2 += list.size();
                            }
                            int iIntValue3 = numberArrB[1].intValue();
                            if (iIntValue3 < 0) {
                                iIntValue3 += list.size();
                            }
                            objSubstring = list.subList(iIntValue2, iIntValue3);
                        } else {
                            int iIntValue4 = ((Integer) objA6).intValue();
                            if (iIntValue4 < 0) {
                                iIntValue4 += list.size();
                            }
                            objSubstring = list.get(iIntValue4);
                        }
                    } else if (objA5 instanceof Map) {
                        objSubstring = ((Map) objA5).get(objA6);
                    } else if (objA5.getClass().isArray()) {
                        if (objA6 instanceof aa) {
                            int length3 = Array.getLength(objA5);
                            Number[] numberArrB2 = ((aa) objA6).b();
                            int iIntValue5 = numberArrB2[0].intValue();
                            if (iIntValue5 < 0) {
                                iIntValue5 += length3;
                            }
                            int iIntValue6 = numberArrB2[1].intValue();
                            if (iIntValue6 < 0) {
                                iIntValue6 += length3;
                            }
                            int i11 = iIntValue6 - iIntValue5;
                            Object objNewInstance = Array.newInstance(objA5.getClass().getComponentType(), i11);
                            System.arraycopy(objA5, iIntValue5, objNewInstance, 0, i11);
                            objSubstring = objNewInstance;
                        } else {
                            int iIntValue7 = ((Integer) objA6).intValue();
                            if (iIntValue7 < 0) {
                                iIntValue7 += Array.getLength(objA5);
                            }
                            objSubstring = Array.get(objA5, iIntValue7);
                        }
                    } else if (objA5 instanceof String) {
                        String str = (String) objA5;
                        if (objA6 instanceof aa) {
                            Number[] numberArrB3 = ((aa) objA6).b();
                            iIntValue = numberArrB3[0].intValue();
                            length = numberArrB3[1].intValue();
                        } else {
                            length = str.length();
                            iIntValue = ((Integer) objA6).intValue();
                        }
                        if (iIntValue < 0) {
                            iIntValue += str.length();
                        }
                        if (length < 0) {
                            length += str.length();
                        }
                        objSubstring = str.substring(iIntValue, length);
                    } else {
                        throw new IllegalArgumentException(objA5.getClass().getName().concat(" is not entry"));
                    }
                    aVar.a(objSubstring);
                    return;
                case 9:
                    aVar.a(aVar.a(this.f1392h));
                    return;
                case 10:
                    aVar.a(this.e, Class.forName(this.d));
                    return;
                case 11:
                    a(aVar.a(), aVar.b);
                    return;
                case 12:
                    Object objA7 = aVar.a();
                    Object[] objArr = new Object[this.f1393i];
                    for (int i12 = 0; i12 < this.f1393i; i12++) {
                        objArr[i12] = aVar.a();
                    }
                    a(objA7, objArr, aVar.b);
                    return;
                case 13:
                    a(aVar.a(this.f1398n), aVar.b);
                    return;
                case 14:
                    Class<?> clsA = aVar.a(this.f1398n);
                    Object[] objArr2 = new Object[this.f1393i];
                    for (int i13 = 0; i13 < this.f1393i; i13++) {
                        objArr2[i13] = aVar.a();
                    }
                    a(clsA, objArr2, aVar.b);
                    return;
                case 15:
                    Object objA8 = aVar.a();
                    y yVar = new y(11);
                    yVar.b = this.b;
                    yVar.c = this.c;
                    yVar.f1396l = (String) aVar.a();
                    yVar.a(objA8, aVar.b);
                    return;
                case 16:
                    Object objA9 = aVar.a();
                    y yVar2 = new y(12);
                    yVar2.b = this.b;
                    yVar2.c = this.c;
                    yVar2.f1400p = (String) aVar.a();
                    yVar2.f1393i = this.f1393i;
                    Object[] objArr3 = new Object[this.f1393i];
                    for (int i14 = 0; i14 < this.f1393i; i14++) {
                        objArr3[i14] = aVar.a();
                    }
                    yVar2.a(objA9, objArr3, aVar.b);
                    return;
                case 17:
                    Class<?> clsA2 = aVar.a(this.f1398n);
                    y yVar3 = new y(13);
                    yVar3.b = this.b;
                    yVar3.c = this.c;
                    yVar3.f1396l = (String) aVar.a();
                    yVar3.a(clsA2, aVar.b);
                    return;
                case 18:
                    Class<?> clsA3 = aVar.a(this.f1398n);
                    y yVar4 = new y(14);
                    yVar4.b = this.b;
                    yVar4.c = this.c;
                    yVar4.f1398n = this.f1398n;
                    yVar4.f1400p = (String) aVar.a();
                    yVar4.f1393i = this.f1393i;
                    Object[] objArr4 = new Object[this.f1393i];
                    for (int i15 = 0; i15 < this.f1393i; i15++) {
                        objArr4[i15] = aVar.a();
                    }
                    yVar4.a(clsA3, objArr4, aVar.b);
                    return;
                case 19:
                    aVar.a(this.f1392h, aVar.a());
                    return;
                case 20:
                default:
                    return;
                case 21:
                    if (((Boolean) aVar.a()).booleanValue()) {
                        return;
                    }
                    aVar.f1404a = this.f1391g;
                    return;
                case 22:
                    aVar.f1404a = this.f1391g;
                    return;
                case 23:
                    Object objA10 = aVar.a();
                    Object objA11 = aVar.a();
                    Object objA12 = aVar.a();
                    if (objA10 instanceof List) {
                        List list2 = (List) objA10;
                        int iIntValue8 = ((Integer) objA11).intValue();
                        if (iIntValue8 < 0) {
                            iIntValue8 += list2.size();
                        }
                        list2.set(iIntValue8, objA12);
                        return;
                    }
                    if (objA10 instanceof Map) {
                        ((Map) objA10).put(objA11, objA12);
                        return;
                    } else {
                        if (objA10.getClass().isArray()) {
                            int iIntValue9 = ((Integer) objA11).intValue();
                            if (iIntValue9 < 0) {
                                iIntValue9 += Array.getLength(objA10);
                            }
                            Array.set(objA10, iIntValue9, objA12);
                            return;
                        }
                        throw new IllegalArgumentException(objA10.getClass().getName().concat(" is not entry"));
                    }
                case 24:
                    b(aVar.a(), aVar.b);
                    return;
                case 25:
                    Object objA13 = aVar.a();
                    y yVar5 = new y(24);
                    yVar5.b = this.b;
                    yVar5.c = this.c;
                    yVar5.f1396l = (String) aVar.a();
                    yVar5.b(objA13, aVar.b);
                    return;
                case 26:
                    b(aVar.a(this.f1398n), aVar.b);
                    return;
                case 27:
                    Class<?> clsA4 = aVar.a(this.f1398n);
                    y yVar6 = new y(26);
                    yVar6.b = this.b;
                    yVar6.c = this.c;
                    yVar6.f1396l = (String) aVar.a();
                    yVar6.b(clsA4, aVar.b);
                    return;
                case 28:
                    List<Object> list3 = aVar.c;
                    if (list3 != null) {
                        list3.add(aVar.a());
                    }
                    aVar.d = true;
                    aVar.e = true;
                    return;
                case 29:
                    int i16 = aVar.f1404a;
                    int i17 = this.f1394j;
                    if (i17 > 0) {
                        aVar.f1404a = i17;
                    } else {
                        int i18 = i16 + 1;
                        int i19 = 1;
                        i17 = i16;
                        while (i19 > 0) {
                            int i20 = aVar.f1405f.get(i18).f1389a;
                            if (i20 == 29) {
                                i19++;
                            } else if (i20 == 30) {
                                i19--;
                            }
                            if (i19 == 0) {
                                aVar.f1404a = i18;
                                i17 = i18;
                            }
                            i18++;
                        }
                    }
                    int i21 = i17;
                    int i22 = i16 + 1;
                    if (i22 == i21) {
                        zVar = z.a(this.f1392h, this.f1393i, aVar.f1405f, aVar.f1406g, i22, i21, aVar.b);
                    } else {
                        zVar = new z(this.f1392h, this.f1393i, aVar.f1405f, aVar.f1406g, i22, i21, aVar.b);
                    }
                    String str2 = this.f1392h;
                    if (str2 != null) {
                        aVar.b(str2, zVar);
                        return;
                    } else {
                        aVar.a(zVar);
                        return;
                    }
                case 30:
                    aVar.e = true;
                    return;
                case 31:
                    Object objB = aVar.b(this.f1392h);
                    if (objB instanceof z) {
                        z zVar2 = (z) objB;
                        Object[] objArr5 = new Object[this.f1393i];
                        for (int i23 = 0; i23 < this.f1393i; i23++) {
                            objArr5[i23] = aVar.a();
                        }
                        LinkedList<Object> linkedListB = zVar2.b(objArr5);
                        if (linkedListB.size() > 0) {
                            aVar.a(linkedListB.get(0));
                            return;
                        }
                        return;
                    }
                    if (objB instanceof Method) {
                        aVar.b.a((Method) objB, this.f1393i);
                        return;
                    }
                    StringBuilder sb11 = new StringBuilder();
                    sb11.append(this.f1392h);
                    sb11.append(" at line: ");
                    sb11.append(this.b);
                    sb11.append("(");
                    throw new NoSuchMethodException(AbstractC0157z.l(")", this.c, sb11));
                case 32:
                    Object objA14 = aVar.a();
                    if (objA14 instanceof z) {
                        z zVar3 = (z) objA14;
                        Object[] objArr6 = new Object[this.f1393i];
                        for (int i24 = 0; i24 < this.f1393i; i24++) {
                            objArr6[i24] = aVar.a();
                        }
                        LinkedList<Object> linkedListB2 = zVar3.b(objArr6);
                        if (linkedListB2.size() > 0) {
                            aVar.a(linkedListB2.get(0));
                            return;
                        }
                        return;
                    }
                    if (objA14 instanceof Method) {
                        aVar.b.a((Method) objA14, this.f1393i);
                        return;
                    }
                    StringBuilder sb12 = new StringBuilder("at line: ");
                    sb12.append(this.b);
                    sb12.append("(");
                    throw new RuntimeException(AbstractC0157z.l(")", this.c, sb12));
                case 33:
                    aVar.b = aVar.b.b();
                    return;
                case 34:
                    aVar.b = aVar.b.c();
                    return;
                case 35:
                    aVar.a(this.e, aVar.a(this.d));
                    return;
                case 36:
                    while (true) {
                        String[] strArr = this.f1399o;
                        if (i7 >= strArr.length) {
                            return;
                        }
                        aVar.b(strArr[i7], aVar.a());
                        i7++;
                    }
                    break;
                case 37:
                    while (true) {
                        Object[] objArr7 = this.f1397m;
                        if (i6 >= objArr7.length) {
                            return;
                        }
                        aVar.a(objArr7[i6]);
                        i6++;
                    }
                    break;
                case 38:
                    for (String str3 : this.f1399o) {
                        aVar.a(aVar.b(str3));
                    }
                    return;
            }
        } catch (Throwable unused5) {
        }
    }

    public void a(Object obj, s sVar) throws Throwable {
        Field declaredField;
        if (obj instanceof Map) {
            sVar.a(((Map) obj).get(this.f1396l));
            return;
        }
        if (cn.fly.commons.x.b("006fedGdi5hg").equals(this.f1396l) && obj.getClass().isArray()) {
            sVar.a(Integer.valueOf(Array.getLength(obj)));
            return;
        }
        for (Class<?> superclass = obj.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
            try {
                declaredField = superclass.getDeclaredField(this.f1396l);
            } catch (Throwable unused) {
                declaredField = null;
            }
            if (declaredField != null && !Modifier.isStatic(declaredField.getModifiers())) {
                declaredField.setAccessible(true);
                sVar.a(declaredField.get(obj));
                return;
            }
        }
        y yVar = new y(12);
        yVar.b = this.b;
        yVar.c = this.c;
        StringBuilder sb = new StringBuilder();
        sb.append(cn.fly.commons.x.b("003!diKeh"));
        sb.append(Character.toUpperCase(this.f1396l.charAt(0)));
        yVar.f1400p = androidx.exifinterface.media.a.j(this.f1396l, 1, sb);
        yVar.f1393i = 0;
        yVar.a(obj, new Object[0], sVar);
    }

    public void a(Class<?> cls, s sVar) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException {
        Field declaredField;
        while (true) {
            if (cls != null) {
                if (Constants.CLASS.equals(this.f1396l)) {
                    sVar.a(cls);
                    return;
                }
                if (cls.equals(x.class) && cn.fly.commons.x.b("0075cc1e0ciehchcjVd").equals(this.f1396l)) {
                    sVar.a((Object) 70);
                    return;
                }
                if (cls.isEnum()) {
                    Object[] enumConstants = cls.getEnumConstants();
                    if (enumConstants != null) {
                        for (Object obj : enumConstants) {
                            if (((Enum) obj).name().equals(this.f1396l)) {
                                sVar.a(obj);
                                return;
                            }
                        }
                    } else {
                        continue;
                    }
                } else {
                    try {
                        declaredField = cls.getDeclaredField(this.f1396l);
                    } catch (Throwable unused) {
                        declaredField = null;
                    }
                    if (declaredField != null && Modifier.isStatic(declaredField.getModifiers())) {
                        declaredField.setAccessible(true);
                        sVar.a(declaredField.get(null));
                        return;
                    }
                    cls = cls.getSuperclass();
                }
            } else {
                y yVar = new y(14);
                yVar.b = this.b;
                yVar.c = this.c;
                yVar.f1398n = this.f1398n;
                StringBuilder sb = new StringBuilder();
                sb.append(cn.fly.commons.x.b("003VdiDeh"));
                sb.append(Character.toUpperCase(this.f1396l.charAt(0)));
                yVar.f1400p = androidx.exifinterface.media.a.j(this.f1396l, 1, sb);
                yVar.f1393i = 1;
                yVar.a(cls, new Object[0], sVar);
                return;
            }
        }
    }

    public void a(Class<?> cls, Object[] objArr, s sVar) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException {
        int i5;
        Map map;
        Object obj;
        List arrayList;
        int i6 = 0;
        if ("new".equals(this.f1400p)) {
            if (List.class.isAssignableFrom(cls) && objArr.length == 1 && (obj = objArr[0]) != null && obj.getClass().isArray()) {
                int length = Array.getLength(objArr[0]);
                if (cls.equals(List.class)) {
                    arrayList = new ArrayList(length);
                } else {
                    arrayList = (List) cls.newInstance();
                }
                for (int i7 = 0; i7 < length; i7++) {
                    arrayList.add(Array.get(objArr[0], i7));
                }
                sVar.a(arrayList);
                return;
            }
            if (Map.class.isAssignableFrom(cls) && objArr.length == 1 && objArr[0] != null) {
                if (cls.equals(Map.class)) {
                    map = new HashMap();
                } else {
                    map = (Map) cls.newInstance();
                }
                Object obj2 = objArr[0];
                if (obj2 instanceof Map) {
                    map.putAll((Map) obj2);
                } else {
                    Class<?> cls2 = Class.forName("org.json.JSONObject");
                    a(map, a(objArr[0], cls2), cls2, Class.forName("org.json.JSONArray"));
                }
                sVar.a(map);
                return;
            }
            if (cls.equals(aa.class)) {
                if (objArr.length == 2) {
                    sVar.a(new aa((Number) objArr[0], (Number) objArr[1], null));
                    return;
                } else {
                    if (objArr.length == 3) {
                        sVar.a(new aa((Number) objArr[0], (Number) objArr[1], (Number) objArr[2]));
                        return;
                    }
                    StringBuilder sb = new StringBuilder("method name: new at line: ");
                    sb.append(this.b);
                    sb.append("(");
                    throw new NoSuchMethodException(AbstractC0157z.l(")", this.c, sb));
                }
            }
            boolean[][] zArr = new boolean[2][];
            Constructor constructorA = sVar.g().a(cls, objArr, zArr);
            if (constructorA != null) {
                Object[] objArrA = !zArr[1][0] ? sVar.g().a(sVar, constructorA.getParameterTypes(), objArr, zArr[0]) : objArr;
                constructorA.setAccessible(true);
                sVar.a(constructorA.newInstance(objArrA));
                return;
            }
            for (Constructor<?> constructor : cls.getDeclaredConstructors()) {
                Class<?>[] parameterTypes = constructor.getParameterTypes();
                boolean[] zArr2 = new boolean[1];
                boolean[] zArrA = sVar.g().a(parameterTypes, objArr, zArr2);
                if (zArrA != null) {
                    Object[] objArrA2 = !zArr2[0] ? sVar.g().a(sVar, parameterTypes, objArr, zArrA) : objArr;
                    constructor.setAccessible(true);
                    sVar.a(constructor.newInstance(objArrA2));
                    return;
                }
            }
            StringBuilder sb2 = new StringBuilder("method name: new at line: ");
            sb2.append(this.b);
            sb2.append("(");
            throw new NoSuchMethodException(AbstractC0157z.l(")", this.c, sb2));
        }
        if ("fromJson".equals(this.f1400p) && Map.class.isAssignableFrom(cls) && objArr.length == 1 && objArr[0] != null) {
            this.f1400p = "new";
            a(cls, objArr, sVar);
            return;
        }
        if (cls.equals(Array.class)) {
            if (this.f1400p.equals(cn.fly.commons.x.b("011deTefddFd*eh'hcdbe")) && objArr.length == 2) {
                Object obj3 = objArr[1];
                if (obj3 instanceof Integer) {
                    sVar.a(Array.newInstance((Class<?>) objArr[0], ((Integer) obj3).intValue()));
                    return;
                }
            }
            if ("copy".equals(this.f1400p)) {
                int i8 = this.f1393i;
                if (i8 == 5) {
                    System.arraycopy(objArr[0], Integer.parseInt(String.valueOf(objArr[1])), objArr[2], Integer.parseInt(String.valueOf(objArr[3])), Integer.parseInt(String.valueOf(objArr[44])));
                    return;
                }
                if (i8 == 2) {
                    Object obj4 = objArr[0];
                    System.arraycopy(obj4, 0, objArr[1], 0, Math.min(Array.getLength(obj4), Array.getLength(objArr[1])));
                    return;
                } else {
                    StringBuilder sb3 = new StringBuilder("method name: copy at line: ");
                    sb3.append(this.b);
                    sb3.append("(");
                    throw new NoSuchMethodException(AbstractC0157z.l(")", this.c, sb3));
                }
            }
        } else if ("quit".equals(this.f1400p) && cls.equals(x.class)) {
            sVar.e();
            return;
        }
        if (sVar.g().a((Object) null, cls, this.f1400p, objArr, sVar)) {
            return;
        }
        Class<?> superclass = cls;
        while (true) {
            Class<?> cls3 = Void.TYPE;
            if (superclass != null) {
                boolean[][] zArr3 = new boolean[2][];
                Method methodA = sVar.g().a(superclass, this.f1400p, true, objArr, zArr3);
                if (methodA != null) {
                    Object[] objArrA3 = !zArr3[1][0] ? sVar.g().a(sVar, methodA.getParameterTypes(), objArr, zArr3[0]) : objArr;
                    methodA.setAccessible(true);
                    if (methodA.getReturnType() == cls3) {
                        methodA.invoke(null, objArrA3);
                        return;
                    } else {
                        sVar.a(methodA.invoke(null, objArrA3));
                        return;
                    }
                }
                superclass = superclass.getSuperclass();
            } else {
                for (Class<?> superclass2 = cls; superclass2 != null; superclass2 = superclass2.getSuperclass()) {
                    Method[] declaredMethods = superclass2.getDeclaredMethods();
                    int length2 = declaredMethods.length;
                    int i9 = i6;
                    while (i9 < length2) {
                        Method method = declaredMethods[i9];
                        if (method.getName().equals(this.f1400p) && Modifier.isStatic(method.getModifiers())) {
                            Class<?>[] parameterTypes2 = method.getParameterTypes();
                            boolean[] zArr4 = new boolean[1];
                            i5 = i6;
                            boolean[] zArrA2 = sVar.g().a(parameterTypes2, objArr, zArr4);
                            if (zArrA2 != null) {
                                Object[] objArrA4 = !zArr4[i5] ? sVar.g().a(sVar, parameterTypes2, objArr, zArrA2) : objArr;
                                method.setAccessible(true);
                                if (method.getReturnType() == cls3) {
                                    method.invoke(null, objArrA4);
                                    return;
                                } else {
                                    sVar.a(method.invoke(null, objArrA4));
                                    return;
                                }
                            }
                        } else {
                            i5 = i6;
                        }
                        i9++;
                        i6 = i5;
                    }
                }
                StringBuilder sb4 = new StringBuilder("method name: ");
                sb4.append(this.f1400p);
                sb4.append(" at line: ");
                sb4.append(this.b);
                sb4.append("(");
                throw new NoSuchMethodException(AbstractC0157z.l(")", this.c, sb4));
            }
        }
    }

    private Object a(Object obj, Class<?> cls) {
        if (obj instanceof ByteArrayOutputStream) {
            return a(((ByteArrayOutputStream) obj).toByteArray(), cls);
        }
        if (obj instanceof byte[]) {
            return a(new String((byte[]) obj, "utf-8"), cls);
        }
        if (!(obj instanceof StringBuffer) && !(obj instanceof StringBuilder)) {
            if (obj instanceof String) {
                return cls.getConstructor(String.class).newInstance(obj);
            }
            if (obj.getClass().equals(cls)) {
                return obj;
            }
            StringBuilder sb = new StringBuilder("Failed to cast ");
            sb.append(obj);
            sb.append(" to be ");
            androidx.collection.a.w(cls, sb, " at line: ");
            sb.append(this.b);
            sb.append("(");
            throw new ClassCastException(AbstractC0157z.l(")", this.c, sb));
        }
        return a(obj.toString(), cls);
    }

    private void a(Map map, Object obj, Class<?> cls, Class<?> cls2) throws IllegalAccessException, NoSuchFieldException {
        Field declaredField = cls.getDeclaredField("nameValuePairs");
        declaredField.setAccessible(true);
        Map map2 = (Map) declaredField.get(obj);
        Field declaredField2 = cls.getDeclaredField("NULL");
        declaredField2.setAccessible(true);
        Object obj2 = declaredField2.get(null);
        for (Map.Entry entry : map2.entrySet()) {
            map.put(entry.getKey(), a(entry.getValue(), obj2, cls, cls2));
        }
    }

    private Object a(Object obj, Object obj2, Class<?> cls, Class<?> cls2) throws IllegalAccessException, NoSuchFieldException {
        if (obj == null || obj2.equals(obj)) {
            return null;
        }
        if (obj.getClass().equals(cls)) {
            HashMap map = new HashMap();
            a((Map) map, obj, cls, cls2);
            return map;
        }
        if (!obj.getClass().equals(cls2)) {
            return obj;
        }
        Field declaredField = cls2.getDeclaredField("values");
        declaredField.setAccessible(true);
        List list = (List) declaredField.get(obj);
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(a(it.next(), obj2, cls, cls2));
        }
        return arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:301:0x0595  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v0, types: [cn.fly.commons.cc.y] */
    /* JADX WARN: Type inference failed for: r17v0, types: [cn.fly.commons.cc.s] */
    /* JADX WARN: Type inference failed for: r1v160 */
    /* JADX WARN: Type inference failed for: r1v161 */
    /* JADX WARN: Type inference failed for: r1v36, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r1v42, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v44, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r1v45, types: [java.util.ArrayList] */
    public void a(Object obj, Object[] objArr, s sVar) throws Throwable {
        byte[] bArr;
        String[] strArr;
        z zVar;
        String strValueOf;
        Object obj2;
        Class<?>[] parameterTypes;
        boolean[] zArr;
        boolean[] zArrA;
        Object obj3;
        Class[] clsArr;
        int i5 = 0;
        if (obj instanceof Map) {
            Map map = (Map) obj;
            Object obj4 = map.get(this.f1400p);
            if (obj4 != null) {
                if (obj4 instanceof z) {
                    LinkedList<Object> linkedListB = ((z) obj4).b(objArr);
                    if (linkedListB.size() > 0) {
                        sVar.a(linkedListB.get(0));
                        return;
                    }
                    return;
                }
                if (obj4 instanceof Method) {
                    sVar.a((Method) obj4, objArr);
                    return;
                }
            } else {
                if ((cn.fly.commons.x.b("005i2cicjdhdb").equals(this.f1400p) || cn.fly.commons.x.b("011*cf7d,eh'c.de?e)fkcicjdhdb").equals(this.f1400p)) && objArr.length == 1 && (obj3 = objArr[0]) != null) {
                    if (obj3 instanceof Class) {
                        clsArr = new Class[]{(Class) obj3};
                    } else if (obj3 instanceof List) {
                        List list = (List) obj3;
                        clsArr = (Class[]) list.toArray(new Class[list.size()]);
                    } else {
                        StringBuilder sb = new StringBuilder("method name: ");
                        sb.append(this.f1400p);
                        sb.append(" at line: ");
                        sb.append(this.b);
                        sb.append("(");
                        throw new NoSuchMethodException(AbstractC0157z.l(")", this.c, sb));
                    }
                    sVar.a(sVar.a(obj, cn.fly.commons.x.b("005i7cicjdhdb").equals(this.f1400p), clsArr));
                    return;
                }
                if ("iterator".equals(this.f1400p) && objArr.length == 0) {
                    sVar.a(map.entrySet().iterator());
                    return;
                } else if ("toJson".equals(this.f1400p) && objArr.length == 0) {
                    sVar.a(Class.forName("org.json.JSONObject").getDeclaredConstructor(Map.class).newInstance(obj));
                    return;
                }
            }
        } else if (obj instanceof z) {
            z zVar2 = (z) obj;
            if (cn.fly.commons.x.b("004he<eh1h").equals(this.f1400p)) {
                sVar.a(zVar2.a(objArr));
                return;
            } else if (cn.fly.commons.x.b("008b)cfcicidbchSd,di").equals(this.f1400p)) {
                sVar.a(zVar2.a(sVar, this.b, this.c));
                return;
            }
        } else if (obj instanceof Method) {
            if (cn.fly.commons.x.b("004heVeh0h").equals(this.f1400p)) {
                z.a aVar = new z.a();
                s sVarB = sVar.b();
                try {
                    sVarB.a((Method) obj, objArr);
                    aVar.b = sVarB.a();
                } catch (Throwable th) {
                    aVar.f1409a = th;
                }
                sVar.a(aVar);
                return;
            }
            if (cn.fly.commons.x.b("013[ehOeh-ecZbbeXehehcheeUfe").equals(this.f1400p) && objArr.length == 1) {
                ((Method) obj).setAccessible(((Boolean) objArr[0]).booleanValue());
                return;
            }
        } else if (obj instanceof Collection) {
            Collection collection = (Collection) obj;
            int size = collection.size();
            if ("toArray".equals(this.f1400p) && objArr.length == 1 && (obj2 = objArr[0]) != null && (obj2 instanceof Class)) {
                Object objNewInstance = Array.newInstance((Class<?>) obj2, size);
                Iterator it = collection.iterator();
                while (it.hasNext()) {
                    Array.set(objNewInstance, i5, it.next());
                    i5++;
                }
                sVar.a(objNewInstance);
                return;
            }
            if ("filter".equals(this.f1400p) && objArr.length == 1 && (objArr[0] instanceof String)) {
                ArrayList arrayList = new ArrayList();
                String str = (String) objArr[0];
                for (Object obj5 : collection) {
                    if ((obj5 instanceof String) && ((String) obj5).matches(str)) {
                        arrayList.add(obj5);
                    }
                }
                sVar.a(arrayList);
                return;
            }
            if ("replace".equals(this.f1400p) && objArr.length == 2 && (objArr[0] instanceof String) && (objArr[1] instanceof String)) {
                ArrayList arrayList2 = new ArrayList();
                String str2 = (String) objArr[0];
                String str3 = (String) objArr[1];
                for (Object obj6 : collection) {
                    if (obj6 instanceof String) {
                        arrayList2.add(((String) obj6).replace(str2, str3));
                    } else {
                        arrayList2.add(obj6);
                    }
                }
                sVar.a(arrayList2);
                return;
            }
        } else if (obj.getClass().isArray()) {
            if ("iterator".equals(this.f1400p) && objArr.length == 0) {
                ArrayList arrayList3 = new ArrayList();
                int length = Array.getLength(obj);
                while (i5 < length) {
                    arrayList3.add(Array.get(obj, i5));
                    i5++;
                }
                sVar.a(arrayList3.iterator());
                return;
            }
            if ("toList".equals(this.f1400p) && objArr.length == 0) {
                ArrayList arrayList4 = new ArrayList();
                int length2 = Array.getLength(obj);
                while (i5 < length2) {
                    arrayList4.add(Array.get(obj, i5));
                    i5++;
                }
                sVar.a(arrayList4);
                return;
            }
            if (obj.getClass().getComponentType() == Byte.TYPE) {
                if (cn.fly.commons.x.b("003Jcecbgh").equals(this.f1400p) && objArr.length == 0) {
                    byte[] bArr2 = (byte[]) obj;
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr2, 0, bArr2.length);
                    String strA = a(byteArrayInputStream);
                    byteArrayInputStream.close();
                    sVar.a(strA);
                    return;
                }
                if ("hex".equals(this.f1400p) && objArr.length == 0) {
                    sVar.a(a((byte[]) obj));
                    return;
                } else if ("sha".equals(this.f1400p) && objArr.length == 1) {
                    MessageDigest messageDigest = MessageDigest.getInstance((String) objArr[0]);
                    messageDigest.update((byte[]) obj);
                    sVar.a(messageDigest.digest());
                    return;
                }
            }
        } else if (Iterator.class.isAssignableFrom(obj.getClass())) {
            if ("hasNext".equals(this.f1400p)) {
                sVar.a(Boolean.valueOf(((Iterator) obj).hasNext()));
                return;
            } else if ("next".equals(this.f1400p)) {
                sVar.a(((Iterator) obj).next());
                return;
            } else if ("remove".equals(this.f1400p)) {
                ((Iterator) obj).remove();
                return;
            }
        } else if (obj instanceof aa.a) {
            if ("hasNext".equals(this.f1400p) && objArr.length == 0) {
                sVar.a(Boolean.valueOf(((aa.a) obj).a()));
                return;
            } else if ("next".equals(this.f1400p) && objArr.length == 0) {
                sVar.a(((aa.a) obj).b());
                return;
            }
        } else if (obj instanceof aa) {
            if ("iterator".equals(this.f1400p) && objArr.length == 0) {
                sVar.a(((aa) obj).a());
                return;
            }
            if ("isInRange".equals(this.f1400p) && objArr.length == 1) {
                sVar.a(Boolean.valueOf(((aa) obj).a((Number) objArr[0])));
                return;
            }
            if ("contains".equals(this.f1400p) && objArr.length == 1) {
                sVar.a(Boolean.valueOf(((aa) obj).b((Number) objArr[0])));
                return;
            } else if ("boundary".equals(this.f1400p) && objArr.length == 0) {
                sVar.a(((aa) obj).b());
                return;
            }
        } else if (obj instanceof String) {
            if ("getBytes".equals(this.f1400p)) {
                if (objArr.length == 0) {
                    sVar.a(((String) obj).getBytes());
                    return;
                } else if (objArr.length == 1) {
                    Object obj7 = objArr[0];
                    if (obj7 instanceof String) {
                        sVar.a(((String) obj).getBytes((String) obj7));
                        return;
                    }
                }
            } else if ("input".equals(this.f1400p)) {
                if (objArr.length == 0) {
                    sVar.a(new FileInputStream((String) obj));
                    return;
                } else if (objArr.length == 1 && (objArr[0] instanceof z)) {
                    FileInputStream fileInputStream = new FileInputStream((String) obj);
                    ((z) objArr[0]).b(fileInputStream);
                    fileInputStream.close();
                    return;
                }
            } else if ("output".equals(this.f1400p)) {
                if (objArr.length == 0) {
                    sVar.a(new FileOutputStream((String) obj));
                    return;
                } else if (objArr.length == 1 && (objArr[0] instanceof z)) {
                    FileOutputStream fileOutputStream = new FileOutputStream((String) obj);
                    ((z) objArr[0]).b(fileOutputStream);
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    return;
                }
            } else {
                File file = null;
                String strValueOf2 = null;
                String strValueOf3 = null;
                FileInputStream fileInputStream2 = null;
                arrayList = 0;
                ?? arrayList5 = 0;
                file = null;
                if (cn.fly.commons.x.b("012XciYecQcbfbcicjcefbch_fe").equals(this.f1400p)) {
                    if (objArr.length == 0) {
                        strValueOf2 = "utf-8";
                    } else if (objArr.length == 1) {
                        strValueOf2 = String.valueOf(objArr[0]);
                    }
                    if (strValueOf2 != null) {
                        FileInputStream fileInputStream3 = new FileInputStream((String) obj);
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        byte[] bArr3 = new byte[4096];
                        for (int i6 = fileInputStream3.read(bArr3); i6 != -1; i6 = fileInputStream3.read(bArr3)) {
                            byteArrayOutputStream.write(bArr3, 0, i6);
                        }
                        fileInputStream3.close();
                        byteArrayOutputStream.flush();
                        byteArrayOutputStream.close();
                        sVar.a(new String(byteArrayOutputStream.toByteArray(), strValueOf2));
                        return;
                    }
                } else if (cn.fly.commons.x.b("0117efcich1he%ebcjfbch'fe").equals(this.f1400p)) {
                    if (objArr.length == 1) {
                        strValueOf3 = String.valueOf(objArr[0]);
                        strValueOf = "utf-8";
                    } else if (objArr.length == 2) {
                        strValueOf3 = String.valueOf(objArr[0]);
                        strValueOf = String.valueOf(objArr[1]);
                    } else {
                        strValueOf = null;
                    }
                    if (strValueOf3 != null) {
                        FileOutputStream fileOutputStream2 = new FileOutputStream(strValueOf3);
                        fileOutputStream2.write(((String) obj).getBytes(strValueOf));
                        fileOutputStream2.flush();
                        fileOutputStream2.close();
                        return;
                    }
                } else if (cn.fly.commons.x.b("009Aci$ecAcbedch[de6eh").equals(this.f1400p)) {
                    String str4 = "utf-8";
                    if (objArr.length == 0) {
                        zVar = null;
                        fileInputStream2 = new FileInputStream((String) obj);
                    } else if (objArr.length == 1) {
                        Object obj8 = objArr[0];
                        if (obj8 instanceof String) {
                            fileInputStream2 = new FileInputStream((String) obj);
                            str4 = (String) objArr[0];
                            zVar = null;
                        } else if (obj8 instanceof z) {
                            fileInputStream2 = new FileInputStream((String) obj);
                            zVar = (z) objArr[0];
                        } else {
                            zVar = null;
                        }
                    } else if (objArr.length == 2 && (objArr[0] instanceof String) && (objArr[1] instanceof z)) {
                        fileInputStream2 = new FileInputStream((String) obj);
                        str4 = (String) objArr[0];
                        zVar = (z) objArr[1];
                    } else {
                        zVar = null;
                    }
                    if (fileInputStream2 != null) {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream2, str4));
                        String line = bufferedReader.readLine();
                        if (zVar == null) {
                            ArrayList arrayList6 = new ArrayList();
                            while (line != null) {
                                arrayList6.add(line);
                                line = bufferedReader.readLine();
                            }
                            sVar.a(arrayList6);
                        } else {
                            while (line != null) {
                                zVar.b(line);
                                line = bufferedReader.readLine();
                            }
                        }
                        bufferedReader.close();
                        return;
                    }
                } else if (cn.fly.commons.x.b("010.efcichUhe,edch3de:eh").equals(this.f1400p)) {
                    String str5 = "utf-8";
                    if (objArr.length >= 1) {
                        if (objArr.length == 2) {
                            Object obj9 = objArr[1];
                            if (obj9 instanceof String) {
                                str5 = (String) obj9;
                            }
                        }
                        Object obj10 = objArr[0];
                        if (obj10 instanceof String) {
                            arrayList5 = new ArrayList();
                            arrayList5.add(objArr[0]);
                        } else if (obj10 instanceof Collection) {
                            arrayList5 = (Collection) obj10;
                        } else if (obj10.getClass().isArray()) {
                            arrayList5 = new ArrayList();
                            int length3 = Array.getLength(objArr[0]);
                            for (int i7 = 0; i7 < length3; i7++) {
                                arrayList5.add(Array.get(objArr[0], i7));
                            }
                        }
                    }
                    if (arrayList5 != 0) {
                        FileOutputStream fileOutputStream3 = new FileOutputStream((String) obj);
                        Iterator it2 = arrayList5.iterator();
                        while (it2.hasNext()) {
                            fileOutputStream3.write((it2.next() + "\r\n").getBytes(str5));
                        }
                        fileOutputStream3.flush();
                        fileOutputStream3.close();
                        return;
                    }
                } else if (cn.fly.commons.x.b("004e$dhDeb").equals(this.f1400p)) {
                    if (objArr.length == 0) {
                        sVar.a(Runtime.getRuntime().exec((String) obj));
                        return;
                    }
                    if (objArr.length == 1 || objArr.length == 2) {
                        Object obj11 = objArr[0];
                        if (obj11 instanceof String[]) {
                            strArr = (String[]) obj11;
                        } else if (obj11 instanceof List) {
                            List list2 = (List) obj11;
                            int size2 = list2.size();
                            String[] strArr2 = new String[size2];
                            for (int i8 = 0; i8 < size2; i8++) {
                                Object obj12 = list2.get(i8);
                                strArr2[i8] = obj12 == null ? null : String.valueOf(obj12);
                            }
                            strArr = strArr2;
                        } else {
                            strArr = null;
                        }
                        if (objArr.length == 2) {
                            Object obj13 = objArr[1];
                            if (obj13 instanceof File) {
                                file = (File) obj13;
                            }
                        }
                        if (strArr != null) {
                            sVar.a(Runtime.getRuntime().exec((String) obj, strArr, file));
                            return;
                        }
                    }
                } else if (cn.fly.commons.x.b("007WdecicjceejKe;dh").equals(this.f1400p) && objArr.length == 0) {
                    String strConcat = (String) obj;
                    int length4 = strConcat.length();
                    if (length4 % 2 == 1) {
                        length4++;
                        bArr = new byte[length4 / 2];
                        strConcat = "0".concat(strConcat);
                    } else {
                        bArr = new byte[length4 / 2];
                    }
                    int i9 = 0;
                    while (i5 < length4) {
                        int i10 = i5 + 2;
                        bArr[i9] = (byte) Integer.parseInt(strConcat.substring(i5, i10), 16);
                        i9++;
                        i5 = i10;
                    }
                    sVar.a(bArr);
                    return;
                }
            }
        } else if (obj instanceof InputStream) {
            if (cn.fly.commons.x.b("017hZcjekTchc!dd:diMcf=h.dkNhHciYec!ce").equals(this.f1400p) && objArr.length == 0) {
                sVar.a(new DataInputStream((InputStream) obj));
                return;
            }
            if (cn.fly.commons.x.b("021hPcjeicfdede,eJciJe5cbdd1diZcf?h dkHhLciDec+ce").equals(this.f1400p) && objArr.length == 0) {
                sVar.a(new BufferedInputStream((InputStream) obj));
                return;
            }
            if (cn.fly.commons.x.b("017h*cjhchiddfkddRdi;cf h[dk>h5ciLec8ce").equals(this.f1400p) && objArr.length == 0) {
                sVar.a(new GZIPInputStream((InputStream) obj));
                return;
            } else if (cn.fly.commons.x.b("019h>cjfgeegf1ebh<ddOdi%cfKhTdk>hUciDec=ce").equals(this.f1400p) && objArr.length == 0) {
                sVar.a(new ObjectInputStream((InputStream) obj));
                return;
            } else if (cn.fly.commons.x.b("0038cecbgh").equals(this.f1400p) && objArr.length == 0) {
                a((InputStream) obj);
            }
        } else if (obj instanceof OutputStream) {
            if (cn.fly.commons.x.b("018h9cjekVchc0fgcf,hi]cf*hYdk=hHci^ecPce").equals(this.f1400p) && objArr.length == 0) {
                sVar.a(new DataOutputStream((OutputStream) obj));
                return;
            }
            if (cn.fly.commons.x.b("022h5cjeicfdede5eCci_e:cbfgcfChiXcfLhNdkDh]ci?ecAce").equals(this.f1400p) && objArr.length == 0) {
                sVar.a(new BufferedOutputStream((OutputStream) obj));
                return;
            }
            if (cn.fly.commons.x.b("018h<cjhchiddfkfgcf?hi2cf!hBdk2h:ciGec?ce").equals(this.f1400p) && objArr.length == 0) {
                sVar.a(new GZIPOutputStream((OutputStream) obj));
                return;
            } else if (cn.fly.commons.x.b("020hAcjfgeegfGebh'fgcf7hiQcf2hWdkZh ci3ecDce").equals(this.f1400p) && objArr.length == 0) {
                sVar.a(new ObjectOutputStream((OutputStream) obj));
                return;
            }
        } else if (obj instanceof Class) {
            if (cn.fly.commons.x.b("006,chceDi$cjci:h").equals(this.f1400p)) {
                if (objArr.length == 0) {
                    Class cls = (Class) obj;
                    sVar.a(cls.getSimpleName(), cls);
                    return;
                } else if (objArr.length == 1) {
                    Object obj14 = objArr[0];
                    if (obj14 instanceof String) {
                        sVar.a((String) obj14, (Class) obj);
                        return;
                    }
                }
            }
        } else if (obj instanceof Throwable) {
            if (cn.fly.commons.x.b("005hg+cicjef").equals(this.f1400p) && objArr.length == 0) {
                throw ((Throwable) obj);
            }
        } else if (obj instanceof BufferedReader) {
            if ("filter".equals(this.f1400p) && objArr.length > 0) {
                Object obj15 = objArr[0];
                if (obj15 instanceof String) {
                    String str6 = (String) obj15;
                    boolean z6 = objArr.length == 2 && Boolean.TRUE.equals(objArr[1]);
                    ArrayList arrayList7 = new ArrayList();
                    BufferedReader bufferedReader2 = (BufferedReader) obj;
                    String line2 = bufferedReader2.readLine();
                    while (line2 != null) {
                        if (line2.matches(str6)) {
                            if (z6) {
                                line2 = line2.trim();
                            }
                            arrayList7.add(line2);
                        }
                        line2 = bufferedReader2.readLine();
                    }
                    sVar.a(arrayList7);
                    return;
                }
            }
        } else if (AccessibleObject.class.isAssignableFrom(obj.getClass()) && cn.fly.commons.x.b("013Ieh4eh7ec;bbe9ehehchee-fe").equals(this.f1400p) && objArr.length == 1) {
            ((AccessibleObject) obj).setAccessible(((Boolean) objArr[0]).booleanValue());
            return;
        }
        if (cn.fly.commons.x.b("004f,cjLb$dg").equals(this.f1400p) && objArr.length > 0 && (objArr[0] instanceof z)) {
            synchronized (obj) {
                try {
                    z zVar3 = (z) objArr[0];
                    int length5 = objArr.length - 1;
                    Object[] objArr2 = new Object[length5];
                    if (objArr.length > 1) {
                        System.arraycopy(objArr, 1, objArr2, 0, length5);
                    }
                    LinkedList<Object> linkedListB2 = zVar3.b(objArr2);
                    if (!linkedListB2.isEmpty()) {
                        sVar.a(linkedListB2.get(0));
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return;
        }
        if (sVar.g().a(obj, obj.getClass(), this.f1400p, objArr, (s) sVar)) {
            return;
        }
        for (Class<?> superclass = r2; superclass != null; superclass = superclass.getSuperclass()) {
            boolean[][] zArr2 = new boolean[2][];
            Method methodA = sVar.g().a(superclass, this.f1400p, false, objArr, zArr2);
            if (methodA != null) {
                Object[] objArrA = !zArr2[1][0] ? sVar.g().a(sVar, methodA.getParameterTypes(), objArr, zArr2[0]) : objArr;
                methodA.setAccessible(true);
                if (methodA.getReturnType() == Void.TYPE) {
                    methodA.invoke(obj, objArrA);
                    return;
                } else {
                    sVar.a(methodA.invoke(obj, objArrA));
                    return;
                }
            }
        }
        for (Class<?> superclass2 = r2; superclass2 != null; superclass2 = superclass2.getSuperclass()) {
            for (Method method : superclass2.getDeclaredMethods()) {
                if (method.getName().equals(this.f1400p) && !Modifier.isStatic(method.getModifiers()) && (zArrA = sVar.g().a((parameterTypes = method.getParameterTypes()), objArr, (zArr = new boolean[1]))) != null) {
                    Object[] objArrA2 = !zArr[0] ? sVar.g().a(sVar, parameterTypes, objArr, zArrA) : objArr;
                    method.setAccessible(true);
                    if (method.getReturnType() == Void.TYPE) {
                        method.invoke(obj, objArrA2);
                        return;
                    } else {
                        sVar.a(method.invoke(obj, objArrA2));
                        return;
                    }
                }
            }
        }
        StringBuilder sb2 = new StringBuilder("method name: ");
        sb2.append(this.f1400p);
        sb2.append(" at line: ");
        sb2.append(this.b);
        sb2.append("(");
        throw new NoSuchMethodException(AbstractC0157z.l(")", this.c, sb2));
    }

    private String a(InputStream inputStream) throws NoSuchAlgorithmException, IOException {
        if (inputStream == null) {
            return null;
        }
        byte[] bArr = new byte[1024];
        MessageDigest messageDigest = MessageDigest.getInstance(cn.fly.commons.x.b("0033gbekgh"));
        int i5 = inputStream.read(bArr);
        while (i5 != -1) {
            messageDigest.update(bArr, 0, i5);
            i5 = inputStream.read(bArr);
        }
        return a(messageDigest.digest());
    }

    private String a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArr) {
            stringBuffer.append(String.format("%02x", Byte.valueOf(b)));
        }
        return stringBuffer.toString();
    }
}
