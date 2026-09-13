package cn.fly.commons;

import android.os.Message;
import android.text.TextUtils;
import cn.fly.FlySDK;
import cn.fly.tools.FlyLog;
import cn.fly.tools.network.NetCommunicator;
import cn.fly.tools.utils.ResHelper;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f1428a = cn.fly.commons.a.l.a("004Xemedgj9h");
    private static h b;
    private NetCommunicator c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f1429f;
    private SimpleDateFormat d = new SimpleDateFormat(cn.fly.commons.a.l.a("0255fdfdfdfdilididilededjgglglDlTegegAl_gjgjemfmfmfmjghe"));
    private HashMap<String, Object> e = new HashMap<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f1430g = cn.fly.commons.a.l.a("008@gjggekeiSfe[eg g");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Runnable f1431h = new cn.fly.tools.utils.i() { // from class: cn.fly.commons.h.1
        @Override // cn.fly.tools.utils.i
        public void a() {
            if (c.d()) {
                h.this.b();
            }
        }
    };

    private h() {
        this.f1429f = null;
        this.f1429f = UUID.randomUUID().toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        boolean zA;
        File[] fileArrListFiles;
        if (this.e.size() > 0) {
            zA = a(this.e);
            if (!zA) {
                c(this.e);
            }
            this.e.clear();
        } else {
            zA = true;
        }
        if (zA) {
            File fileD = d();
            if (!fileD.exists() || !fileD.isDirectory() || (fileArrListFiles = fileD.listFiles()) == null || fileArrListFiles.length <= 0) {
                return;
            }
            for (File file : fileArrListFiles) {
                if (a((HashMap<String, Object>) ResHelper.readObjectFromFile(file.getAbsolutePath())) && !file.delete()) {
                    file.delete();
                }
            }
        }
    }

    private void c() {
        if (this.c == null) {
            this.c = new NetCommunicator(1024, "ab0a0a6473d1891d388773574764b239d4ad80cb2fd3a83d81d03901c1548c13fee7c9692c326e6682b239d4c5d0021d1b607642c47ec29f10b0602908c3e6c9", "23c3c8cb41c47dd288cc7f4c218fbc7c839a34e0a0d1b2130e87b7914936b120a2d6570ee7ac66282328d50f2acfd82f2259957c89baea32547758db05de9cd7c6822304c8e45742f24bbbe41c1e12f09e18c6fab4d078065f2e5aaed94c900c66e8bbf8a120eefa7bd1fb52114d529250084f5f6f369ed4ce9645978dd30c51");
        }
    }

    private File d() {
        return new File(ResHelper.getDataCache(FlySDK.getContext()), f1428a);
    }

    public static synchronized h a() {
        try {
            if (b == null) {
                b = new h();
            }
        } catch (Throwable th) {
            throw th;
        }
        return b;
    }

    private void c(HashMap<String, Object> map) {
        File[] fileArrListFiles;
        try {
            File fileD = d();
            if (!fileD.exists() || !fileD.isDirectory()) {
                fileD.delete();
                fileD.mkdirs();
            }
            StringBuilder sb = new StringBuilder();
            String str = f1428a;
            sb.append(str);
            sb.append("_0");
            File file = new File(fileD, sb.toString());
            if (file.exists() && (fileArrListFiles = fileD.listFiles()) != null && fileArrListFiles.length > 0) {
                file = new File(fileD, str + "_0");
                int i5 = 0;
                while (file.exists()) {
                    i5++;
                    file = new File(fileD, f1428a + "_" + i5);
                }
            }
            ResHelper.saveObjectToFile(file.getPath(), map);
        } catch (Throwable th) {
            FlyLog.getInstance().d(th);
        }
    }

    public synchronized void a(int i5, int i6, Throwable th, String str) {
        a(i5, i6, th, null, str);
    }

    public synchronized void a(int i5, int i6, String str, String str2) {
        a(i5, i6, null, str, str2);
    }

    private synchronized void a(int i5, int i6, Throwable th, String str, String str2) {
        Object obj;
        try {
            if (th == null) {
                FlyLog.getInstance().d(str, new Object[0]);
            } else {
                FlyLog.getInstance().d(th);
            }
            if (f.a()) {
                return;
            }
            final Message message = new Message();
            message.what = 1;
            message.arg1 = 1;
            Long lValueOf = Long.valueOf(System.currentTimeMillis());
            if (th == null) {
                obj = th;
                obj = str;
            }
            obj = th;
            message.obj = new Object[]{lValueOf, obj, Integer.valueOf(i5), Integer.valueOf(i6), str2};
            ac.b.execute(new cn.fly.tools.utils.i() { // from class: cn.fly.commons.h.2
                @Override // cn.fly.tools.utils.i
                public void a() {
                    h.this.a(message);
                }
            });
        } catch (Throwable th2) {
            throw th2;
        }
    }

    private boolean b(HashMap<String, Object> map) {
        if (map != null && !map.isEmpty()) {
            HashMap<String, Object> mapE = q.e();
            mapE.put(cn.fly.commons.a.l.a("006g2ekekelekgj"), map);
            c();
            HashMap map2 = (HashMap) this.c.requestWithoutEncode(false, NetCommunicator.getCommonDefaultHeaders(), mapE, j.a().a("dtc") + "/v2/sdrl", true);
            if (map2 != null && !map2.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Message message) {
        String strValueOf;
        if (this.e.size() > 10) {
            c(this.e);
            this.e.clear();
        }
        Object[] objArr = (Object[]) message.obj;
        this.e.put(cn.fly.commons.a.l.a("002Ugjed"), this.f1429f);
        ArrayList arrayList = (ArrayList) this.e.get(cn.fly.commons.a.l.a("004h8ejgj3j"));
        if (arrayList == null) {
            arrayList = new ArrayList();
        }
        HashMap map = new HashMap();
        map.put(cn.fly.commons.a.l.a("002dj"), objArr[0]);
        Object obj = objArr[1];
        if (obj instanceof Throwable) {
            strValueOf = a((Throwable) obj);
        } else {
            strValueOf = String.valueOf(obj);
        }
        if (!TextUtils.isEmpty(strValueOf)) {
            strValueOf = strValueOf.replaceAll("\r\n\t", " ").replaceAll("\n\t", " ").replaceAll("\n", " ");
        }
        map.put(cn.fly.commons.a.l.a("002Aegfk"), "[" + this.d.format(objArr[0]) + "][" + objArr[2] + "][" + objArr[3] + "][" + objArr[4] + "] " + strValueOf);
        map.put(cn.fly.commons.a.l.a("002gj"), objArr[2]);
        map.put(cn.fly.commons.a.l.a("002kFel"), objArr[3]);
        map.put(this.f1430g, objArr[4]);
        arrayList.add(map);
        this.e.put(cn.fly.commons.a.l.a("004h]ejgj1j"), arrayList);
        if (f.a()) {
            return;
        }
        ac.b.execute(this.f1431h);
    }

    private boolean a(HashMap<String, Object> map) {
        try {
            return b(map);
        } catch (Throwable th) {
            FlyLog.getInstance().d(th);
            try {
                return b(map);
            } catch (Throwable th2) {
                FlyLog.getInstance().d(th2);
                return false;
            }
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
                        C0396r.a(null);
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
                    String string = stringWriter2.toString();
                    C0396r.a(stringWriter2);
                    return string;
                } catch (Throwable th3) {
                    th = th3;
                    stringWriter = stringWriter2;
                }
            }
            th = th2;
            try {
                if (th instanceof OutOfMemoryError) {
                    String strA = cn.fly.commons.a.l.a("023NfkTgj*fm,jed0figdek$edgDfmYj=ekej[f^fkjgeleleg");
                    C0396r.a(stringWriter);
                    return strA;
                }
                String message = th.getMessage();
                C0396r.a(stringWriter);
                return message;
            } catch (Throwable th4) {
                C0396r.a(stringWriter);
                throw th4;
            }
        }
    }
}
