package cn.fly.commons.cc;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import org.apache.xmlbeans.XmlErrorCodes;

/* JADX INFO: loaded from: classes.dex */
public class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final HashMap<String, Class<?>> f1383a;
    private final HashMap<String, HashMap<String, String[][]>> b = new HashMap<>();
    private final HashMap<Class<?>, t<?>> c = new HashMap<>();

    static {
        HashMap<String, Class<?>> map = new HashMap<>();
        f1383a = map;
        map.put(cn.fly.commons.o.a("003!di*ei"), Integer.TYPE);
        map.put(cn.fly.commons.o.a("006$dcdkdgff$gf"), Double.TYPE);
        map.put(XmlErrorCodes.LONG, Long.TYPE);
        map.put(cn.fly.commons.o.a("005CefIgUdk4di"), Float.TYPE);
        map.put("boolean", Boolean.TYPE);
        map.put("short", Short.TYPE);
        map.put("byte", Byte.TYPE);
        map.put(cn.fly.commons.o.a("004chd>dj"), Character.TYPE);
        map.put("void", Void.TYPE);
    }

    public u() {
        a(z.a.class, z.a.class);
    }

    private boolean b(Class<?> cls, Class<?> cls2) {
        if (cls == Byte.TYPE && cls2 == Byte.class) {
            return true;
        }
        if (cls == Short.TYPE && (cls2 == Short.class || cls2 == Byte.class || cls2 == Character.class)) {
            return true;
        }
        if (cls == Character.TYPE && (cls2 == Character.class || cls2 == Short.class || cls2 == Byte.class)) {
            return true;
        }
        if (cls == Integer.TYPE && (cls2 == Integer.class || cls2 == Short.class || cls2 == Byte.class || cls2 == Character.class)) {
            return true;
        }
        if (cls == Long.TYPE && (cls2 == Long.class || cls2 == Integer.class || cls2 == Short.class || cls2 == Byte.class || cls2 == Character.class)) {
            return true;
        }
        if (cls == Float.TYPE && (cls2 == Float.class || cls2 == Long.class || cls2 == Integer.class || cls2 == Short.class || cls2 == Byte.class || cls2 == Character.class)) {
            return true;
        }
        if (cls == Double.TYPE && (cls2 == Double.class || cls2 == Float.class || cls2 == Long.class || cls2 == Integer.class || cls2 == Short.class || cls2 == Byte.class || cls2 == Character.class)) {
            return true;
        }
        return cls == Boolean.TYPE && cls2 == Boolean.class;
    }

    public void a(byte[] bArr) throws IOException {
        ArrayList arrayList = new ArrayList();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(bArr), "utf-8"));
        try {
            try {
                HashMap<String, String[][]> map = null;
                for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                    String strSubstring = line.substring(0, 2);
                    String strSubstring2 = line.substring(2);
                    if (":P".equals(strSubstring)) {
                        arrayList.addAll(Arrays.asList(strSubstring2.split("#")));
                    } else if (":C".equals(strSubstring)) {
                        String str = (String) arrayList.get(Integer.parseInt(strSubstring2));
                        map = this.b.get(str);
                        if (map == null) {
                            map = new HashMap<>();
                            this.b.put(str, map);
                        }
                    } else {
                        String[] strArrSplit = strSubstring2.split("#");
                        String str2 = (String) arrayList.get(Integer.parseInt(strArrSplit[0]));
                        String[][] strArr = new String[Integer.parseInt(strArrSplit[1])][];
                        for (int i5 = 2; i5 < strArrSplit.length; i5++) {
                            String str3 = strArrSplit[i5].startsWith("+") ? "+" : null;
                            if (strArrSplit[i5].length() > 1) {
                                String[] strArrSplit2 = strArrSplit[i5].substring(1).split(",");
                                String[] strArr2 = new String[strArrSplit2.length + 1];
                                strArr2[0] = str3;
                                int i6 = 0;
                                while (i6 < strArrSplit2.length) {
                                    int i7 = i6 + 1;
                                    strArr2[i7] = (String) arrayList.get(Integer.parseInt(strArrSplit2[i6]));
                                    i6 = i7;
                                }
                                strArr[i5 - 2] = strArr2;
                            } else {
                                strArr[i5 - 2] = new String[]{str3};
                            }
                        }
                        map.put(str2, strArr);
                    }
                }
                bufferedReader.close();
            } finally {
                bufferedReader.close();
            }
        } catch (Throwable unused) {
            this.b.clear();
        }
    }

    public void a(Class<?> cls, Class<? extends t<?>> cls2) {
        try {
            t<?> tVarNewInstance = cls2.getDeclaredConstructor(null).newInstance(null);
            if (this.c.get(cls) == null) {
                this.c.put(cls, tVarNewInstance);
            }
        } catch (Throwable unused) {
        }
    }

    public boolean a(Object obj, Class<?> cls, String str, Object[] objArr, s sVar) throws Throwable {
        t<?> tVar = null;
        for (Class<?> superclass = cls; tVar == null && superclass != null && superclass != Object.class; superclass = superclass.getSuperclass()) {
            tVar = this.c.get(superclass);
        }
        if (tVar == null) {
            return false;
        }
        boolean[] zArr = new boolean[1];
        Object[] objArr2 = new Object[1];
        Throwable[] thArr = new Throwable[1];
        boolean zA = tVar.a(obj, cls, str, objArr, zArr, objArr2, thArr);
        if (zA) {
            Throwable th = thArr[0];
            if (th == null) {
                if (!zArr[0]) {
                    sVar.a(objArr2[0]);
                    return zA;
                }
            } else {
                throw th;
            }
        }
        return zA;
    }

    public boolean[] a(Class<?>[] clsArr, Object[] objArr, boolean[] zArr) {
        zArr[0] = true;
        if (clsArr.length != objArr.length) {
            return null;
        }
        boolean[] zArr2 = new boolean[clsArr.length];
        for (int i5 = 0; i5 < objArr.length; i5++) {
            Object obj = objArr[i5];
            if (obj != null) {
                Class<?> cls = clsArr[i5];
                if (cls.isInterface() && (obj instanceof z)) {
                    zArr2[i5] = true;
                    zArr[0] = false;
                } else {
                    Class<?> cls2 = obj.getClass();
                    if (!b(cls, cls2) && !cls.isAssignableFrom(cls2)) {
                        return null;
                    }
                    zArr2[i5] = false;
                }
            }
        }
        return zArr2;
    }

    public Object[] a(s sVar, Class<?>[] clsArr, Object[] objArr, boolean[] zArr) {
        Object[] objArr2 = new Object[zArr.length];
        for (int i5 = 0; i5 < zArr.length; i5++) {
            Object obj = objArr[i5];
            if (obj != null) {
                if (zArr[i5]) {
                    objArr2[i5] = sVar.a(obj, true, clsArr[i5]);
                } else {
                    objArr2[i5] = obj;
                }
            }
        }
        return objArr2;
    }

    /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
        java.util.NoSuchElementException
        	at java.base/java.util.TreeMap.key(TreeMap.java:1637)
        	at java.base/java.util.TreeMap.lastKey(TreeMap.java:309)
        	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
        	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
        	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
        */
    public java.lang.reflect.Constructor a(java.lang.Class<?> r12, java.lang.Object[] r13, boolean[][] r14) {
        /*
            r11 = this;
            java.util.HashMap<java.lang.String, java.util.HashMap<java.lang.String, java.lang.String[][]>> r0 = r11.b
            java.lang.String r1 = r12.getName()
            java.lang.Object r0 = r0.get(r1)
            java.util.HashMap r0 = (java.util.HashMap) r0
            if (r0 == 0) goto L52
            java.lang.String r1 = "006Giedi4eWdi]iRig"
            java.lang.String r1 = cn.fly.commons.o.a(r1)
            java.lang.Object r0 = r0.get(r1)
            java.lang.String[][] r0 = (java.lang.String[][]) r0
            if (r0 == 0) goto L52
            int r1 = r0.length
            r2 = 0
            r3 = r2
        L1f:
            if (r3 >= r1) goto L52
            r4 = r0[r3]
            int r5 = r4.length
            r6 = 1
            int r5 = r5 - r6
            int r7 = r13.length
            if (r5 != r7) goto L4f
            int r5 = r13.length
            java.lang.Class[] r7 = new java.lang.Class[r5]
            r8 = r2
        L2d:
            if (r8 >= r5) goto L3e
            int r9 = r8 + 1
            r10 = r4[r9]
            java.lang.Class r10 = r11.a(r10)
            r7[r8] = r10
            if (r10 != 0) goto L3c
            goto L4f
        L3c:
            r8 = r9
            goto L2d
        L3e:
            boolean[] r4 = new boolean[r6]
            boolean[] r5 = r11.a(r7, r13, r4)
            if (r5 == 0) goto L4f
            r14[r2] = r5
            r14[r6] = r4
            java.lang.reflect.Constructor r12 = r12.getDeclaredConstructor(r7)
            return r12
        L4f:
            int r3 = r3 + 1
            goto L1f
        L52:
            r12 = 0
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.fly.commons.cc.u.a(java.lang.Class, java.lang.Object[], boolean[][]):java.lang.reflect.Constructor");
    }

    /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
        java.util.NoSuchElementException
        	at java.base/java.util.TreeMap.key(TreeMap.java:1637)
        	at java.base/java.util.TreeMap.lastKey(TreeMap.java:309)
        	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
        	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
        	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
        */
    public java.lang.reflect.Method a(java.lang.Class<?> r15, java.lang.String r16, boolean r17, java.lang.Object[] r18, boolean[][] r19) {
        /*
            r14 = this;
            r0 = r16
            r1 = r18
            java.util.HashMap<java.lang.String, java.util.HashMap<java.lang.String, java.lang.String[][]>> r2 = r14.b
            java.lang.String r3 = r15.getName()
            java.lang.Object r2 = r2.get(r3)
            java.util.HashMap r2 = (java.util.HashMap) r2
            if (r2 == 0) goto L5c
            java.lang.Object r2 = r2.get(r0)
            java.lang.String[][] r2 = (java.lang.String[][]) r2
            if (r2 == 0) goto L5c
            int r3 = r2.length
            r4 = 0
            r5 = r4
        L1d:
            if (r5 >= r3) goto L5c
            r6 = r2[r5]
            r7 = r6[r4]
            r8 = 1
            if (r7 == 0) goto L2a
            r9 = r8
        L27:
            r7 = r17
            goto L2c
        L2a:
            r9 = r4
            goto L27
        L2c:
            if (r7 != r9) goto L59
            int r9 = r6.length
            int r9 = r9 - r8
            int r10 = r1.length
            if (r9 != r10) goto L59
            int r9 = r1.length
            java.lang.Class[] r10 = new java.lang.Class[r9]
            r11 = r4
        L37:
            if (r11 >= r9) goto L48
            int r12 = r11 + 1
            r13 = r6[r12]
            java.lang.Class r13 = r14.a(r13)
            r10[r11] = r13
            if (r13 != 0) goto L46
            goto L59
        L46:
            r11 = r12
            goto L37
        L48:
            boolean[] r6 = new boolean[r8]
            boolean[] r9 = r14.a(r10, r1, r6)
            if (r9 == 0) goto L59
            r19[r4] = r9
            r19[r8] = r6
            java.lang.reflect.Method r15 = r15.getDeclaredMethod(r0, r10)
            return r15
        L59:
            int r5 = r5 + 1
            goto L1d
        L5c:
            r15 = 0
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.fly.commons.cc.u.a(java.lang.Class, java.lang.String, boolean, java.lang.Object[], boolean[][]):java.lang.reflect.Method");
    }

    private Class<?> a(String str) {
        Class<?> cls = f1383a.get(str);
        if (cls != null) {
            return cls;
        }
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }
}
