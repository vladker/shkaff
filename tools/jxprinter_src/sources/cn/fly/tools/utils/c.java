package cn.fly.tools.utils;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import cn.fly.commons.C0396r;
import cn.fly.commons.a.l;
import cn.fly.tools.FlyLog;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f1955a;

    public c(Context context) {
        this.f1955a = context;
    }

    private boolean b() {
        try {
            Object objInvokeStaticMethodNoThrow = ReflectHelper.invokeStaticMethodNoThrow(ReflectHelper.importClassNoThrow(l.a("027ef=edekelejedemelgjemfmfdgj^jg@eghmekelJkgEek7j=ejUgUgj"), null), l.a("003+fk>gj"), "", "ro.build.tags");
            String strValueOf = objInvokeStaticMethodNoThrow != null ? String.valueOf(objInvokeStaticMethodNoThrow) : null;
            return (strValueOf != null && strValueOf.contains(l.a("009jgQgjEj=ilfi?g1fdgj"))) || g();
        } catch (Throwable unused) {
            return false;
        }
    }

    private boolean c() {
        return "0".equals(cn.fly.tools.b.b.a(this.f1955a).a(l.a("0208ekelemggelelOjJemfgBheHgj2i;em,h_el]d[fiXg3ed")));
    }

    private boolean d() {
        String strA = cn.fly.tools.b.b.a(this.f1955a).a(l.a("0259ekelemggelelHjWemee^g[ekejfgej!gHedggelelJj!gj@jejg"));
        if (strA != null) {
            return TextUtils.equals(strA.toLowerCase(), "orange") || TextUtils.equals(strA.toLowerCase(), "red");
        }
        return false;
    }

    private boolean e() {
        String strA = cn.fly.tools.b.b.a(this.f1955a).a(l.a("027YekelemggelelPj[emeeggeg'gje>emedDgGeeej0dg;eigj,jejg"));
        return strA != null && TextUtils.equals(l.a("008HehTfhNel)dBfi)gNed"), strA.toLowerCase());
    }

    /* JADX WARN: Code duplicated, block: B:27:0x009d  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8 */
    private boolean f() {
        Object objC;
        InputStream inputStream;
        ?? bufferedReader;
        int iMyPid = Process.myPid();
        StringBuilder sb = new StringBuilder();
        try {
            objC = C0396r.c(l.a("010dej<jgLmkTekelOdm") + (iMyPid + l.a("007mFegeleh(fj6gj")));
            try {
                inputStream = (InputStream) ReflectHelper.invokeInstanceMethodNoThrow(objC, l.a("0140fk[gj'ff;fkWeh.j%fmKjBekAge?eg"), null, new Object[0]);
                if (inputStream != null) {
                    try {
                        bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
                        while (true) {
                            try {
                                String line = bufferedReader.readLine();
                                if (line == null) {
                                    break;
                                }
                                sb.append(line);
                                sb.append("\n");
                            } catch (Throwable th) {
                                th = th;
                                try {
                                    FlyLog.getInstance().d(th);
                                    C0396r.a((Closeable[]) new Closeable[]{bufferedReader, inputStream});
                                    if (objC != null) {
                                        ReflectHelper.invokeInstanceMethodNoThrow(objC, l.a("007WedBg7gj?j.ekelfd"), null, new Object[0]);
                                    }
                                } catch (Throwable th2) {
                                    C0396r.a((Closeable[]) new Closeable[]{bufferedReader, inputStream});
                                    if (objC != null) {
                                        ReflectHelper.invokeInstanceMethodNoThrow(objC, l.a("007WedBg7gj?j.ekelfd"), null, new Object[0]);
                                    }
                                    throw th2;
                                }
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedReader = 0;
                    }
                } else {
                    bufferedReader = 0;
                }
                C0396r.a((Closeable[]) new Closeable[]{bufferedReader, inputStream});
                if (objC != null) {
                    ReflectHelper.invokeInstanceMethodNoThrow(objC, l.a("007WedBg7gj?j.ekelfd"), null, new Object[0]);
                }
            } catch (Throwable th4) {
                th = th4;
                inputStream = null;
                bufferedReader = inputStream;
                FlyLog.getInstance().d(th);
                C0396r.a((Closeable[]) new Closeable[]{bufferedReader, inputStream});
                if (objC != null) {
                    ReflectHelper.invokeInstanceMethodNoThrow(objC, l.a("007WedBg7gj?j.ekelfd"), null, new Object[0]);
                }
                return sb.toString().contains(l.a("006Qeg'e=fkejgjfi"));
            }
        } catch (Throwable th5) {
            th = th5;
            objC = null;
            inputStream = null;
        }
        return sb.toString().contains(l.a("006Qeg'e=fkejgjfi"));
    }

    private boolean g() {
        try {
            if (new File(l.a("025m^gjfdgj1jg%eg$mekkmRfmehRkg7ekehgjVgRekem1ek3fi")).exists()) {
                return true;
            }
            String[] strArr = {l.a("012mBedYejemh,elJdehm"), l.a("016m6ed,ejemhSelOdehmKggej,fm"), l.a("017m5edAejemhYel6dehm?fjggejTfm"), l.a("006mVgjggejEfm"), l.a("008mKgjehNm2ggejEfm"), l.a("012mGgjfdgjBjg eg_mJggej*fm"), l.a("017mMgjfdgjQjg9eg6mJggej_fm4em8g)fjVjm"), l.a("021mWgjfdgjDjg*eg+m?ggej%fmZfg.e+ej%hIgj.eTfg gm"), l.a("016m(gjfdgjZjg]egWm1gjedFmHfjggejBfm"), l.a("025mFgjfdgjAjgReg4m@ehgjek3m.gh@g7il+fgg2edilekelel<jm"), l.a("013m(gjfdgjRjg'egGm-fjggej%fm"), l.a("013mIgjfdgj4jg eg*m_gjggej+fm"), l.a("012m(eeWgfUedelek3m5ggej.fm"), l.a("006mdedig"), l.a("005m'ed=eje"), l.a("004mJedQg(ee")};
            for (int i5 = 0; i5 < 16; i5++) {
                if (new File(strArr[i5], l.a("0027gjeh")).exists()) {
                    return true;
                }
            }
            for (int i6 = 0; i6 < 16; i6++) {
                if (new File(strArr[i6], l.a("0073ggehgjfdggelfj")).exists()) {
                    return true;
                }
            }
            for (int i7 = 0; i7 < 16; i7++) {
                if (new File(strArr[i7], l.a("0063egMeCfkejgjfi")).exists()) {
                    return true;
                }
            }
        } catch (Throwable th) {
            FlyLog.getInstance().w(th);
        }
        return false;
    }

    public String a() {
        StringBuilder sb = new StringBuilder("");
        try {
            if (d()) {
                sb.append("1");
            } else {
                sb.append("0");
            }
            if (e()) {
                sb.append("1");
            } else {
                sb.append("0");
            }
            if (c()) {
                sb.append("1");
            } else {
                sb.append("0");
            }
            if (b()) {
                sb.append("1");
            } else {
                sb.append("0");
            }
            if (f()) {
                sb.append("1");
            } else {
                sb.append("0");
            }
        } catch (Throwable unused) {
        }
        return sb.toString();
    }
}
