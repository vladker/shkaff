package cn.fly.commons;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.security.NetworkSecurityPolicy;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import cn.fly.FlySDK;
import cn.fly.tools.FlyLog;
import cn.fly.tools.utils.DH;
import cn.fly.tools.utils.Data;
import cn.fly.tools.utils.ReflectHelper;
import cn.fly.tools.utils.UIHandler;
import com.alibaba.android.arouter.utils.Consts;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import org.apache.commons.compress.archivers.tar.TarConstants;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.apache.logging.log4j.util.ProcessIdUtil;

/* JADX INFO: renamed from: cn.fly.commons.r, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0396r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile String f1473a;
    private static final byte[] b = new byte[0];

    /* JADX INFO: renamed from: cn.fly.commons.r$4, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f1476a;

        static {
            int[] iArr = new int[InternationalDomain.values().length];
            f1476a = iArr;
            try {
                iArr[InternationalDomain.JP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1476a[InternationalDomain.US.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static Context a() {
        try {
            Object objB = b();
            if (objB != null) {
                return (Context) ReflectHelper.invokeInstanceMethod(objB, m.a("014Ogl.hk!hfFlli@fk)efk1fkfmDg"), new Object[0]);
            }
            return null;
        } catch (Throwable th) {
            FlyLog.getInstance().w(th);
            return null;
        }
    }

    public static Object b() {
        final ReflectHelper.a<Void, Object> aVar = new ReflectHelper.a<Void, Object>() { // from class: cn.fly.commons.r.1
            @Override // cn.fly.tools.utils.ReflectHelper.a
            public Object a(Void r6) {
                return ReflectHelper.invokeStaticMethodNoThrow(ReflectHelper.importClassNoThrow(m.a("026fgMfeflfmfkfefn;fllHfnhfZek-fkfffk3kTgehePj'fl>hf2fe"), null), m.a("021e]fiflfl*hgk]hfCek+fkfffk<kDgehe=j(flQhfAfe"), null, new Object[0]);
            }
        };
        Object objA = aVar.a(null);
        if (objA != null) {
            return objA;
        }
        final Object obj = new Object();
        final Object[] objArr = new Object[1];
        synchronized (obj) {
            UIHandler.sendEmptyMessage(0, new Handler.Callback() { // from class: cn.fly.commons.r.2
                @Override // android.os.Handler.Callback
                public boolean handleMessage(Message message) {
                    synchronized (obj) {
                        try {
                            objArr[0] = aVar.a(null);
                        } catch (Throwable th) {
                            try {
                                FlyLog.getInstance().w(th);
                            } catch (Throwable th2) {
                                obj.notify();
                                throw th2;
                            }
                        }
                        obj.notify();
                    }
                    return false;
                }
            });
            try {
                obj.wait();
            } catch (Throwable th) {
                FlyLog.getInstance().w(th);
            }
        }
        return objArr[0];
    }

    public static Object c(String str) {
        return ReflectHelper.invokeInstanceMethod(ReflectHelper.invokeStaticMethod(ReflectHelper.importClass(m.a("017CjiFfNffIfOfn(ifgYglfnilfi0gkJfkfh]h")), m.a("010JglWhkMilfi)gkJfkfhQh"), new Object[0]), m.a("004hQgkAhe"), new Object[]{str}, new Class[]{String.class});
    }

    public static Object d(String str) {
        try {
            return FlySDK.getContext().getSystemService(str);
        } catch (Throwable th) {
            FlyLog.getInstance().w(th);
            return null;
        }
    }

    public static boolean e() {
        if (DH.SyncMtd.getOSVersionInt() >= 36) {
            return true;
        }
        try {
            String systemProperties = DH.SyncMtd.getSystemProperties("ro.build.version.release_or_codename");
            return TextUtils.equals("Baklava", systemProperties) || Integer.parseInt(systemProperties) >= 16;
        } catch (Throwable unused) {
            return true;
        }
    }

    public static String d() {
        if (TextUtils.isEmpty(f1473a)) {
            synchronized (b) {
                try {
                    if (TextUtils.isEmpty(f1473a)) {
                        f1473a = new cn.fly.tools.utils.c(FlySDK.getContext()).a();
                    }
                } catch (Throwable th) {
                    FlyLog.getInstance().d("[ICE] ee " + th, new Object[0]);
                }
            }
        }
        return f1473a;
    }

    public static void a(Closeable... closeableArr) {
        for (Closeable closeable : closeableArr) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (Throwable th) {
                    FlyLog.getInstance().d(th);
                }
            }
        }
    }

    public static byte[] c() throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        DataOutputStream dataOutputStream;
        Throwable th;
        try {
            SecureRandom secureRandom = new SecureRandom();
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                try {
                    dataOutputStream.writeLong(secureRandom.nextLong());
                    dataOutputStream.writeLong(secureRandom.nextLong());
                    dataOutputStream.flush();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    a(dataOutputStream, byteArrayOutputStream);
                    return byteArray;
                } catch (Throwable th2) {
                    th = th2;
                    a(dataOutputStream, byteArrayOutputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                dataOutputStream = null;
                th = th;
                a(dataOutputStream, byteArrayOutputStream);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            byteArrayOutputStream = null;
            dataOutputStream = null;
        }
    }

    public static void a(final cn.fly.tools.utils.d<ArrayList<HashMap<String, Object>>> dVar) {
        DH.requester(FlySDK.getContext()).getMwlfo().getMbcdi().request(new DH.DHResponder() { // from class: cn.fly.commons.r.3
            @Override // cn.fly.tools.utils.DH.DHResponder
            public void onResponse(DH.DHResponse dHResponse) {
                ArrayList arrayList = new ArrayList();
                try {
                    ArrayList<HashMap<String, Object>> mwlfo = dHResponse.getMwlfo();
                    if (mwlfo != null && !mwlfo.isEmpty()) {
                        ArrayList<String> arrayListH = c.h();
                        if (arrayListH != null && !arrayListH.isEmpty()) {
                            String mbcdi = dHResponse.getMbcdi();
                            int size = mwlfo.size();
                            int i5 = 0;
                            while (i5 < size) {
                                HashMap<String, Object> map = mwlfo.get(i5);
                                i5++;
                                HashMap<String, Object> map2 = map;
                                Object obj = map2.get(m.a("0056hlgngngghn"));
                                if (obj != null && String.valueOf(obj).equals(mbcdi)) {
                                    map2.put(m.a("010Xfjfjfj_eGfiflgffm+gg"), Boolean.TRUE);
                                    mbcdi = null;
                                }
                                HashMap map3 = new HashMap();
                                int size2 = arrayListH.size();
                                int i6 = 0;
                                while (i6 < size2) {
                                    String str = arrayListH.get(i6);
                                    i6++;
                                    String str2 = str;
                                    Object obj2 = map2.get(str2);
                                    if (obj2 != null) {
                                        map3.put(str2, obj2);
                                    }
                                }
                                if (!map3.isEmpty()) {
                                    arrayList.add(map3);
                                }
                            }
                        }
                        dVar.a(null);
                        return;
                    }
                } catch (Throwable th) {
                    FlyLog.getInstance().w(th);
                }
                cn.fly.tools.utils.d dVar2 = dVar;
                if (arrayList.isEmpty()) {
                    arrayList = null;
                }
                dVar2.a(arrayList);
            }
        });
    }

    public static String a(String str) {
        return a(str, false);
    }

    public static String a(String str, boolean z6) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String strA = "";
        if (str.startsWith(m.a("007jkklmnn"))) {
            str = str.replace(m.a("007jkklmnn"), "");
        }
        if (str.startsWith("https://")) {
            str = str.replace("https://", "");
        }
        if (FlySDK.checkV6()) {
            strA = m.a("002.ffjj");
        } else {
            int i5 = AnonymousClass4.f1476a[FlySDK.getDmn().ordinal()];
            if (i5 == 1) {
                strA = "jp";
            } else if (i5 == 2) {
                strA = m.a("0025fihk");
            }
        }
        if (TextUtils.isEmpty(strA)) {
            return b(m.a("007jkklmnn") + str, z6);
        }
        if (str.startsWith(strA + Consts.DOT)) {
            return b(m.a("007jkklmnn") + str, z6);
        }
        return b(m.a("007jkklmnn") + strA + ProcessIdUtil.DEFAULT_PROCESSID + str, z6);
    }

    public static String b(String str) {
        return b(str, false);
    }

    public static String b(String str, boolean z6) {
        Uri uri;
        String scheme;
        String str2;
        try {
            if (!TextUtils.isEmpty(str)) {
                boolean zCheckFH = FlySDK.checkFH(z6);
                if (!zCheckFH) {
                    if (DH.SyncMtd.getOSVersionIntForFly() >= 23 && !NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted()) {
                    }
                }
                String strTrim = str.trim();
                if (!strTrim.startsWith(m.a("007jkklmnn")) || (uri = Uri.parse(strTrim.trim())) == null || (scheme = uri.getScheme()) == null || !scheme.equals(m.a("004jkkl"))) {
                    return strTrim;
                }
                String host = uri.getHost();
                String path = uri.getPath();
                String query = uri.getQuery();
                String strConcat = "";
                if (host != null) {
                    int port = uri.getPort();
                    StringBuilder sb = new StringBuilder();
                    sb.append(host);
                    if (port <= 0 || port == 80) {
                        str2 = "";
                    } else {
                        str2 = ParameterizedMessage.ERROR_MSG_SEPARATOR + port;
                    }
                    sb.append(str2);
                    host = sb.toString();
                    if (!zCheckFH && DH.SyncMtd.getOSVersionIntForFly() >= 24 && ((Boolean) ReflectHelper.invokeInstanceMethod(NetworkSecurityPolicy.getInstance(), m.a("0275fkhkgf+ihf,flFkh[gkDkLheflNf2ghghfk!e>in*hNflfhfkOkkhRfe"), host)).booleanValue()) {
                        return strTrim;
                    }
                }
                StringBuilder sb2 = new StringBuilder("https://");
                sb2.append(host);
                if (path == null) {
                    path = "";
                }
                sb2.append(path);
                if (query != null) {
                    strConcat = "?".concat(query);
                }
                sb2.append(strConcat);
                return sb2.toString();
            }
            return str;
        } catch (Throwable th) {
            FlyLog.getInstance().d(th);
            return str;
        }
    }

    public static void a(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        if (file.isFile()) {
            b(file);
            return;
        }
        String[] list = file.list();
        if (list != null && list.length != 0) {
            for (String str : list) {
                File file2 = new File(file, str);
                if (file2.isDirectory()) {
                    a(file2);
                } else {
                    b(file2);
                }
            }
            b(file);
            return;
        }
        b(file);
    }

    public static void b(View view) {
        Object systemServiceSafe = DH.SyncMtd.getSystemServiceSafe("input_method");
        if (systemServiceSafe == null) {
            return;
        }
        ((InputMethodManager) systemServiceSafe).toggleSoftInputFromWindow(view.getWindowToken(), 2, 0);
    }

    private static void b(File file) {
        ReflectHelper.invokeInstanceMethod(file, m.a("006 feUhihkh"), null, null, null);
    }

    public static void a(View view) {
        Object systemServiceSafe = DH.SyncMtd.getSystemServiceSafe("input_method");
        if (systemServiceSafe == null) {
            return;
        }
        ((InputMethodManager) systemServiceSafe).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static Intent a(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (DH.SyncMtd.getOSVersionIntForFly() < 33) {
            return (Intent) ReflectHelper.invokeInstanceMethod(FlySDK.getContext(), m.a("016Ffl.h7glfkhkLkhKflil.heh(fkff hDfl"), new Object[]{broadcastReceiver, intentFilter}, new Class[]{BroadcastReceiver.class, IntentFilter.class}, null);
        }
        return (Intent) ReflectHelper.invokeInstanceMethod(FlySDK.getContext(), m.a("0168fl.hHglfkhkXkhEflil-heh,fkffEh)fl"), new Object[]{broadcastReceiver, intentFilter, 4}, new Class[]{BroadcastReceiver.class, IntentFilter.class, Integer.TYPE}, null);
    }

    public static void a(BroadcastReceiver broadcastReceiver) {
        ReflectHelper.invokeInstanceMethod(FlySDK.getContext(), m.a("018EfiTg^fl hBglfkhk<khRflil5heh-fkffRhEfl"), new Object[]{broadcastReceiver}, new Class[]{BroadcastReceiver.class}, null);
    }

    public static boolean a(long j6, long j7) {
        if (j6 <= 0 || j7 <= 0) {
            return false;
        }
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return simpleDateFormat.format(new Date(j6)).equals(simpleDateFormat.format(new Date(j7)));
        } catch (Throwable th) {
            FlyLog.getInstance().d(th);
            return false;
        }
    }

    public static Object a(File file, byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream;
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    byte[] bArr2 = new byte[1024];
                    while (true) {
                        int i5 = fileInputStream.read(bArr2);
                        if (i5 != -1) {
                            byteArrayOutputStream.write(bArr2, 0, i5);
                        } else {
                            Object objA = a(bArr, byteArrayOutputStream.toByteArray());
                            a(byteArrayOutputStream, fileInputStream);
                            return objA;
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        FlyLog.getInstance().d(th);
                        a(byteArrayOutputStream, fileInputStream);
                        return null;
                    } catch (Throwable th2) {
                        a(byteArrayOutputStream, fileInputStream);
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                byteArrayOutputStream = null;
            }
        } catch (Throwable th4) {
            th = th4;
            byteArrayOutputStream = null;
            fileInputStream = null;
        }
    }

    public static Object a(byte[] bArr, byte[] bArr2) throws Throwable {
        ByteArrayInputStream byteArrayInputStream;
        Throwable th;
        ObjectInputStream objectInputStream;
        if (bArr2 == null || bArr2.length == 0) {
            return null;
        }
        try {
            byteArrayInputStream = new ByteArrayInputStream(Data.paddingDecode(bArr, bArr2));
            try {
                objectInputStream = new ObjectInputStream(byteArrayInputStream);
                try {
                    Object object = objectInputStream.readObject();
                    a(objectInputStream, byteArrayInputStream);
                    return object;
                } catch (Throwable th2) {
                    th = th2;
                    a(objectInputStream, byteArrayInputStream);
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

    public static byte[] a(byte[] bArr, Object obj) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        if (obj != null) {
            ObjectOutputStream objectOutputStream = null;
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(byteArrayOutputStream);
                    try {
                        objectOutputStream2.writeObject(obj);
                        byte[] bArrAES128Encode = Data.AES128Encode(bArr, byteArrayOutputStream.toByteArray());
                        a(objectOutputStream2, byteArrayOutputStream);
                        return bArrAES128Encode;
                    } catch (Throwable th) {
                        th = th;
                        objectOutputStream = objectOutputStream2;
                        a(objectOutputStream, byteArrayOutputStream);
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

    public static void a(File file, byte[] bArr, Object obj) {
        FileOutputStream fileOutputStream;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            byte[] bArrA = a(bArr, obj);
            if (bArrA.length > 0) {
                fileOutputStream = new FileOutputStream(file);
                try {
                    BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(fileOutputStream);
                    try {
                        bufferedOutputStream2.write(bArrA);
                        bufferedOutputStream2.flush();
                        bufferedOutputStream = bufferedOutputStream2;
                    } catch (Throwable th) {
                        th = th;
                        bufferedOutputStream = bufferedOutputStream2;
                        try {
                            FlyLog.getInstance().d(th);
                            a(bufferedOutputStream, fileOutputStream);
                            return;
                        } catch (Throwable th2) {
                            a(bufferedOutputStream, fileOutputStream);
                            throw th2;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } else {
                fileOutputStream = null;
            }
            a(bufferedOutputStream, fileOutputStream);
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
        }
    }

    public static String a(String str, int i5) {
        int i6;
        int i7 = 0;
        int i8 = 3;
        if (str.startsWith(TarConstants.VERSION_POSIX)) {
            i6 = Integer.parseInt(str.substring(2, 3));
        } else if (str.startsWith("0")) {
            i6 = Integer.parseInt(str.substring(1, 3));
        } else {
            i6 = Integer.parseInt(str.substring(0, 3));
        }
        char[] charArray = str.toCharArray();
        int[] iArr = new int[i6];
        boolean z6 = true;
        while (i8 < charArray.length) {
            char c = charArray[i8];
            if (c < 'a') {
                z6 = !z6;
            } else {
                if (z6) {
                    iArr[i7] = c - i5;
                } else {
                    int i9 = (c - i5) * 10;
                    iArr[i7] = i9;
                    i8++;
                    iArr[i7] = (charArray[i8] - i5) + i9;
                }
                int i10 = iArr[i7];
                i7++;
            }
            i8++;
        }
        return d.a(iArr);
    }
}
