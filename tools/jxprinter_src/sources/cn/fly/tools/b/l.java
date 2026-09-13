package cn.fly.tools.b;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import android.os.ResultReceiver;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import cn.fly.FlySDK;
import cn.fly.commons.C0396r;
import cn.fly.commons.n;
import cn.fly.tools.FlyLog;
import cn.fly.tools.utils.DH;
import cn.fly.tools.utils.ReflectHelper;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static volatile IBinder f1801a = null;
    private static volatile int b = Integer.MIN_VALUE;
    private static volatile int c = Integer.MIN_VALUE;

    /* JADX WARN: Code duplicated, block: B:17:0x0043 A[Catch: all -> 0x0047, PHI: r2
  0x0043: PHI (r2v5 java.util.Set<java.lang.String>) = (r2v1 java.util.Set<java.lang.String>), (r2v7 java.util.Set<java.lang.String>) binds: [B:25:0x0060, B:16:0x0041] A[DONT_GENERATE, DONT_INLINE], TryCatch #1 {all -> 0x0047, blocks: (B:15:0x003d, B:17:0x0043, B:20:0x0049, B:24:0x005c, B:7:0x0014, B:9:0x002c, B:11:0x0032, B:14:0x0039), top: B:40:0x000e, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:20:0x0049 A[Catch: all -> 0x0047, PHI: r2
  0x0049: PHI (r2v3 java.util.Set<java.lang.String>) = (r2v1 java.util.Set<java.lang.String>), (r2v7 java.util.Set<java.lang.String>) binds: [B:25:0x0060, B:16:0x0041] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #1 {all -> 0x0047, blocks: (B:15:0x003d, B:17:0x0043, B:20:0x0049, B:24:0x005c, B:7:0x0014, B:9:0x002c, B:11:0x0032, B:14:0x0039), top: B:40:0x000e, inners: #2 }] */
    /* JADX WARN: Undo finally extract visitor
    java.lang.NullPointerException: Cannot invoke "Object.hashCode()" because "this.second" is null
    	at jadx.core.utils.Pair.hashCode(Pair.java:35)
    	at java.base/java.util.HashMap.hash(HashMap.java:338)
    	at java.base/java.util.HashMap.getNode(HashMap.java:576)
    	at java.base/java.util.HashMap.containsKey(HashMap.java:602)
    	at jadx.core.dex.visitors.finaly.traverser.state.TraverserGlobalCommonState.hasBlocksBeenCached(TraverserGlobalCommonState.java:35)
    	at jadx.core.dex.visitors.finaly.traverser.handlers.MergePathActivePathTraverserHandler.handle(MergePathActivePathTraverserHandler.java:174)
    	at jadx.core.dex.visitors.finaly.traverser.handlers.AbstractActivePathTraverserHandler.process(AbstractActivePathTraverserHandler.java:19)
    	at jadx.core.dex.visitors.finaly.traverser.TraverserController.processHandlerImplementations(TraverserController.java:43)
    	at jadx.core.dex.visitors.finaly.traverser.TraverserController.advance(TraverserController.java:156)
    	at jadx.core.dex.visitors.finaly.traverser.TraverserController.process(TraverserController.java:79)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.findCommonInsns(MarkFinallyVisitor.java:404)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.extractFinally(MarkFinallyVisitor.java:284)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.processTryBlock(MarkFinallyVisitor.java:202)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.java:135)
     */
    public static Set<String> a(Context context, int i5) {
        HandlerThread handlerThread = new HandlerThread("M-H-XPL-1");
        handlerThread.start();
        Set<String> setA = null;
        try {
            try {
                if (i5 != 1) {
                    if (i5 == 4) {
                        if (!n.a("005Jbd>d0bgebbe").equalsIgnoreCase(c.a(context).d().p()) && a()) {
                            setA = a(context, handlerThread);
                        }
                    }
                    if (DH.SyncMtd.getOSVersionIntForFly() >= 18) {
                        handlerThread.quitSafely();
                    } else {
                        handlerThread.quit();
                    }
                    return setA;
                }
                setA = a(context, true, handlerThread);
                if (DH.SyncMtd.getOSVersionIntForFly() >= 18) {
                    handlerThread.quitSafely();
                } else {
                    handlerThread.quit();
                }
            } catch (Throwable th) {
                try {
                    FlyLog.getInstance().d(th);
                    if (DH.SyncMtd.getOSVersionIntForFly() < 18) {
                        handlerThread.quit();
                    }
                } catch (Throwable th2) {
                    try {
                        if (DH.SyncMtd.getOSVersionIntForFly() >= 18) {
                            handlerThread.quitSafely();
                        } else {
                            handlerThread.quit();
                        }
                    } catch (Throwable th3) {
                        FlyLog.getInstance().d(th3);
                    }
                    throw th2;
                }
            }
        } catch (Throwable th4) {
            FlyLog.getInstance().d(th4);
        }
        return setA;
    }

    private static Parcelable.Creator<?> b() {
        return (Parcelable.Creator) ReflectHelper.getStaticField(ReflectHelper.importClass(n.a("030bc!babhbibgbabjXa$bi^cgdcg(bjDh6bdbjejBba8cfRb!chPdQcc>cDcdbi")), n.a("007;cbehegdbdaefeh"));
    }

    private static int c() {
        if (c != Integer.MIN_VALUE) {
            return c;
        }
        if (DH.SyncMtd.getOSVersionIntForFly() < 17) {
            return 0;
        }
        try {
            int iIntValue = ((Integer) ReflectHelper.invokeStaticMethod(ReflectHelper.importClass(n.a("021bc[babhbibgbabjbidgbjcidg=d$bhdiWbc;ba+ed")), n.a("009RchZdgHcidgMd9bhccba"), new Object[]{Integer.valueOf(Process.myUid())}, new Class[]{Integer.TYPE})).intValue();
            c = iIntValue;
            return iIntValue;
        } catch (Throwable th) {
            FlyLog.getInstance().d(th);
            return 0;
        }
    }

    public static Set<String> a(Context context, HandlerThread handlerThread) throws Throwable {
        Throwable th;
        FileInputStream fileInputStream;
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader = null;
        if (cn.fly.commons.e.b()) {
            File file = new File(context.getFilesDir(), ".tmp11");
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, n.a("002QbgMc") + System.currentTimeMillis());
            StringBuilder sb = new StringBuilder("out");
            sb.append(System.currentTimeMillis());
            File file3 = new File(file, sb.toString());
            File file4 = new File(file, NotificationCompat.CATEGORY_ERROR + System.currentTimeMillis());
            if (file3.exists()) {
                file3.delete();
            }
            try {
                a(context, n.a("007hba>cf,bWchSd"), new String[]{n.a("004eTbgdg:g"), "packages"}, file2, file3, file4, handlerThread);
                if (file3.exists() && file3.length() > 0) {
                    HashSet hashSet = new HashSet();
                    fileInputStream = new FileInputStream(file3);
                    try {
                        inputStreamReader = new InputStreamReader(fileInputStream, "utf-8");
                        try {
                            BufferedReader bufferedReader2 = new BufferedReader(inputStreamReader);
                            try {
                                String strA = n.a("008hbaWcfWb[chBdi");
                                for (String line = bufferedReader2.readLine(); line != null; line = bufferedReader2.readLine()) {
                                    String strTrim = line.trim();
                                    if (strTrim.length() > strA.length() && strTrim.substring(0, strA.length()).equalsIgnoreCase(strA)) {
                                        String strTrim2 = strTrim.substring(strA.length()).trim();
                                        if (!TextUtils.isEmpty(strTrim2)) {
                                            hashSet.add(strTrim2);
                                        }
                                    }
                                }
                                C0396r.a(bufferedReader2, inputStreamReader, fileInputStream);
                                file2.delete();
                                file3.delete();
                                file4.delete();
                                return hashSet;
                            } catch (Throwable th2) {
                                th = th2;
                                bufferedReader = bufferedReader2;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        inputStreamReader = null;
                    }
                } else {
                    C0396r.a(null, null, null);
                    file2.delete();
                    file3.delete();
                    file4.delete();
                }
            } catch (Throwable th5) {
                th = th5;
                fileInputStream = null;
                inputStreamReader = null;
            }
            C0396r.a(bufferedReader, inputStreamReader, fileInputStream);
            file2.delete();
            file3.delete();
            file4.delete();
            throw th;
        }
        return null;
    }

    public static Set<String> a(Context context, boolean z6, HandlerThread handlerThread) throws Throwable {
        FileInputStream fileInputStream;
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader = null;
        if (cn.fly.commons.e.b()) {
            File file = new File(context.getFilesDir(), ".tmp11");
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, n.a("002@bg$c") + System.currentTimeMillis());
            StringBuilder sb = new StringBuilder("out");
            sb.append(System.currentTimeMillis());
            File file3 = new File(file, sb.toString());
            File file4 = new File(file, NotificationCompat.CATEGORY_ERROR + System.currentTimeMillis());
            if (file3.exists()) {
                file3.delete();
            }
            try {
                if (z6) {
                    a(context, n.a("007hba1cf;bUch4d"), new String[]{n.a("016@bcbeId<bhcafi6bag1bgbbbgWg bgOd^dg"), "-a", n.a("026bc?babhbibgbabjbgKcgdcg,bj:bagGbgbi9c6bjfadbccce"), "--user", "0"}, file2, file3, file4, handlerThread);
                } else {
                    a(context, n.a("007hba!cf-b-ch4d"), new String[]{n.a("016:bcbeKd7bhcafi$bag@bgbbbgXg-bg_d$dg"), "-a", n.a("026bcJbabhbibgbabjbgJcgdcgAbjBbagIbgbiQcBbjfadbccce"), "-c", n.a("032bc3babhbibgbabjbgNcgdcg5bj%abgdZchbibhcabjdcdbcicecbdiegeh"), "--user", "0"}, file2, file3, file4, handlerThread);
                }
                if (file3.exists() && file3.length() > 0) {
                    HashSet hashSet = new HashSet();
                    fileInputStream = new FileInputStream(file3);
                    try {
                        inputStreamReader = new InputStreamReader(fileInputStream, "utf-8");
                        try {
                            BufferedReader bufferedReader2 = new BufferedReader(inputStreamReader);
                            try {
                                String strA = n.a("012hba%cfVbNch^d;ceFbHbdFd3gg");
                                for (String line = bufferedReader2.readLine(); line != null; line = bufferedReader2.readLine()) {
                                    String strTrim = line.trim();
                                    if (strTrim.length() > strA.length() && strTrim.substring(0, strA.length()).equalsIgnoreCase(strA)) {
                                        String strTrim2 = strTrim.substring(strA.length()).trim();
                                        if (!TextUtils.isEmpty(strTrim2)) {
                                            hashSet.add(strTrim2);
                                        }
                                    }
                                }
                                C0396r.a(bufferedReader2, inputStreamReader, fileInputStream);
                                file2.delete();
                                file3.delete();
                                file4.delete();
                                return hashSet;
                            } catch (Throwable th) {
                                th = th;
                                bufferedReader = bufferedReader2;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        inputStreamReader = null;
                    }
                } else {
                    C0396r.a(null, null, null);
                    file2.delete();
                    file3.delete();
                    file4.delete();
                }
            } catch (Throwable th4) {
                th = th4;
                fileInputStream = null;
                inputStreamReader = null;
            }
            C0396r.a(bufferedReader, inputStreamReader, fileInputStream);
            file2.delete();
            file3.delete();
            file4.delete();
            throw th;
        }
        return null;
    }

    private static int a(Context context, String str, String[] strArr, File file, File file2, File file3, HandlerThread handlerThread) throws Throwable {
        char c6;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        Object objA;
        FileOutputStream fileOutputStream3 = null;
        try {
            IBinder iBinder = (IBinder) cn.fly.tools.a.f.a(context).a(n.a("025bc2babhbibgbabjbidgbjcj@d>bhbbbg5ad(faSbcbGch7dFbh"), (Object) null, n.a("010TchEdg.cj]d8bhbbbg]ad"), new Class[]{String.class}, new Object[]{str}, IBinder.class, (Object) null);
            if (iBinder == null || (objA = cn.fly.tools.a.f.a(context).a(n.a("024bc babhbibgbabjbidgbjcj;fdeeMcb>bee@dd3ba:cf"))) == null) {
                C0396r.a(null, null, null);
                return -1;
            }
            FileOutputStream fileOutputStream4 = new FileOutputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
                try {
                    FileOutputStream fileOutputStream5 = new FileOutputStream(file3);
                    try {
                        fileOutputStream3 = fileOutputStream5;
                        c6 = 2;
                        try {
                            fileOutputStream = fileOutputStream;
                            try {
                                cn.fly.tools.a.f.a(context).a(IBinder.class, iBinder, n.a("012@dgPfdee*cbbibdbdFbcLba"), new Class[]{FileDescriptor.class, FileDescriptor.class, FileDescriptor.class, String[].class, Class.forName(n.a("024bc]babhbibgbabjbidgbjcjIfdeeMcbHbee7dd8baQcf")), ResultReceiver.class}, new Object[]{fileOutputStream4.getFD(), fileOutputStream.getFD(), fileOutputStream3.getFD(), strArr, objA, new ResultReceiver(new Handler(handlerThread.getLooper()))}, (Class<?>) null, (Object) null);
                                C0396r.a(fileOutputStream4, fileOutputStream, fileOutputStream3);
                                return 0;
                            } catch (Throwable th) {
                                th = th;
                                fileOutputStream2 = fileOutputStream3;
                                fileOutputStream3 = fileOutputStream4;
                                Closeable[] closeableArr = new Closeable[3];
                                closeableArr[0] = fileOutputStream3;
                                closeableArr[1] = fileOutputStream;
                                closeableArr[c6] = fileOutputStream2;
                                C0396r.a(closeableArr);
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            fileOutputStream = fileOutputStream;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        fileOutputStream3 = fileOutputStream5;
                        c6 = 2;
                        fileOutputStream2 = fileOutputStream3;
                        fileOutputStream3 = fileOutputStream4;
                        Closeable[] closeableArr2 = new Closeable[3];
                        closeableArr2[0] = fileOutputStream3;
                        closeableArr2[1] = fileOutputStream;
                        closeableArr2[c6] = fileOutputStream2;
                        C0396r.a(closeableArr2);
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                }
            } catch (Throwable th5) {
                th = th5;
                c6 = 2;
                fileOutputStream = null;
                fileOutputStream2 = null;
            }
        } catch (Throwable th6) {
            th = th6;
            c6 = 2;
            fileOutputStream = null;
            fileOutputStream2 = null;
        }
        Closeable[] closeableArr3 = new Closeable[3];
        closeableArr3[0] = fileOutputStream3;
        closeableArr3[1] = fileOutputStream;
        closeableArr3[c6] = fileOutputStream2;
        C0396r.a(closeableArr3);
        throw th;
    }

    public static Object a(Context context, String str, int i5) {
        return a(context, str, i5, c(), a(context));
    }

    private static Object a(Context context, String str, int i5, int i6, int i7) {
        if (DH.SyncMtd.getOSVersionInt() < 23) {
            return null;
        }
        if (f1801a == null) {
            f1801a = (IBinder) cn.fly.tools.a.f.a(context).a(n.a("025bc=babhbibgbabjbidgbjcjDdVbhbbbg7ad>fa1bcb$ch$dCbh"), (Object) null, n.a("010^chEdg$cjWd_bhbbbg2ad"), new Class[]{String.class}, new Object[]{n.a("007hbaYcf[b0ch7d")}, IBinder.class, (Object) null);
        }
        if (f1801a == null) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(n.a("034bc[babhbibgbabjDa;biGcgdcgEbj2h$bdbjccejObaJcfWb*ch d2fa^bcb+ch<d1bh"));
            parcelObtain.writeString(str);
            parcelObtain.writeInt(i5);
            parcelObtain.writeInt(i6);
            f1801a.transact(i7, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readTypedObject(b());
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
            cn.fly.tools.a.f.a(context).b(context);
        }
    }

    private static int a(Context context) {
        if (b != Integer.MIN_VALUE) {
            return b;
        }
        try {
            b = ((Integer) cn.fly.tools.a.f.a(context).a(n.a("034bc4babhbibgbabj,a_biYcgdcgBbj9h5bdbjccej<baVcf<b_ch_dBfa'bcbLchBd?bh") + "$" + n.a("004McjKg3bedd"), n.a("026Kdaehdbcecjdbcbdaccefcebfch dgAej<ba'cfVbBch2dVcc7c cdbi"), null, Integer.TYPE, 3)).intValue();
            return b;
        } catch (Throwable th) {
            FlyLog.getInstance().d(th);
            return b;
        }
    }

    public static boolean a() {
        try {
            if (n.a("006f7be'bKde:dFbg").equalsIgnoreCase(DH.SyncMtd.getManufacturerForFly())) {
                final CountDownLatch countDownLatch = new CountDownLatch(1);
                final int[] iArr = new int[1];
                DH.requester(FlySDK.getContext()).getHmOsDetailedVer().request(new DH.DHResponder() { // from class: cn.fly.tools.b.l.1
                    @Override // cn.fly.tools.utils.DH.DHResponder
                    public void onResponse(DH.DHResponse dHResponse) {
                        String hmOsDetailedVer = dHResponse.getHmOsDetailedVer();
                        if (hmOsDetailedVer == null) {
                            hmOsDetailedVer = "";
                        }
                        iArr[0] = "3.0.0.200".compareTo(hmOsDetailedVer);
                        countDownLatch.countDown();
                    }
                });
                countDownLatch.await();
                if (iArr[0] <= 0) {
                    return false;
                }
            }
            return true;
        } catch (Throwable th) {
            FlyLog.getInstance().d(th);
            return true;
        }
    }
}
