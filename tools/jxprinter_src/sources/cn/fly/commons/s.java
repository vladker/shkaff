package cn.fly.commons;

import android.os.Process;
import cn.fly.tools.FlyLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/* JADX INFO: loaded from: classes.dex */
public class s {
    public static boolean a() {
        return b() || c() || d();
    }

    public static boolean b() {
        File[] fileArrListFiles;
        String[] strArr = {cn.fly.commons.a.l.a("028m[ed.ejemh-el=dehmjNeg-kmLfgekejedXe.ilgj2gBekeeLgGek"), cn.fly.commons.a.l.a("031mQedUejemhCel8dehmj=eg+kmGek=gDemfgekejedSe7emgjEgAekeeUg_ek"), cn.fly.commons.a.l.a("030mPed;ejemh<el0dehmj9egXkmRfgekejed5e!ilQeXfk$gfjHemgjel"), cn.fly.commons.a.l.a("034mIed:ejemh]el4dehmj8egRkmh$ejggfgekejedGe5ilfk=eSedfk=gj_emgjel")};
        for (int i5 = 0; i5 < 4; i5++) {
            if (new File(strArr[i5]).exists()) {
                return true;
            }
        }
        try {
            File file = new File(cn.fly.commons.a.l.a("015mGedLejemhYelPdehmjUeg*k"));
            if (!file.exists() || !file.isDirectory() || (fileArrListFiles = file.listFiles()) == null) {
                return false;
            }
            for (File file2 : fileArrListFiles) {
                if (file2.getName().startsWith(cn.fly.commons.a.l.a("012Ofgekejed:e'ilfk9e=edfk-gj"))) {
                    return true;
                }
            }
        } catch (Throwable th) {
            FlyLog.getInstance().d(th);
        }
        return false;
    }

    public static boolean c() throws Throwable {
        BufferedReader bufferedReader;
        Throwable th;
        FileInputStream fileInputStream;
        String line;
        BufferedReader bufferedReader2 = null;
        try {
            File file = new File(cn.fly.commons.a.l.a("006mk7ekel8dm") + Process.myPid() + cn.fly.commons.a.l.a("005m5eg-ek:gj"));
            if (!file.exists() || file.length() <= 0) {
                fileInputStream = null;
            } else {
                fileInputStream = new FileInputStream(file);
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                    do {
                        try {
                            line = bufferedReader.readLine();
                            if (line == null) {
                                bufferedReader2 = bufferedReader;
                            }
                        } catch (Exception unused) {
                            bufferedReader2 = bufferedReader;
                            C0396r.a(bufferedReader2, fileInputStream);
                            return false;
                        } catch (Throwable th2) {
                            th = th2;
                            C0396r.a(bufferedReader, fileInputStream);
                            throw th;
                        }
                    } while (!line.contains(cn.fly.commons.a.l.a("005*fgekejed7e")));
                    C0396r.a(bufferedReader, fileInputStream);
                    return true;
                } catch (Exception unused2) {
                } catch (Throwable th3) {
                    bufferedReader = null;
                    th = th3;
                }
            }
            C0396r.a(bufferedReader2, fileInputStream);
            return false;
        } catch (Exception unused3) {
            fileInputStream = null;
        } catch (Throwable th4) {
            bufferedReader = null;
            th = th4;
            fileInputStream = null;
        }
    }

    public static boolean d() throws Throwable {
        Socket socket = null;
        try {
            Socket socket2 = new Socket(cn.fly.commons.a.l.a("009hEel?dehi!elgjNj"), new int[]{27042, 27043}[0]);
            try {
                boolean zIsConnected = socket2.isConnected();
                try {
                    socket2.close();
                } catch (Exception unused) {
                }
                return zIsConnected;
            } catch (Exception unused2) {
                socket = socket2;
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (Exception unused3) {
                    }
                }
                return false;
            } catch (Throwable th) {
                th = th;
                socket = socket2;
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (Exception unused4) {
                    }
                }
                throw th;
            }
        } catch (Exception unused5) {
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
