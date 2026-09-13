package cn.fly.commons.c;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import cn.fly.tools.FlyLog;
import cn.fly.tools.utils.DH;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import kotlinx.serialization.json.internal.AbstractC1127c;

/* JADX INFO: loaded from: classes.dex */
public abstract class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final Context f1360a;
    protected final String b;
    private boolean c = false;
    private String d = null;
    private int e = 0;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f1362a;
    }

    public h(Context context) {
        this.f1360a = context;
        this.b = context.getPackageName();
    }

    private synchronized void e() {
        try {
            if (this.c) {
                return;
            }
            if (a(a()) || this.e >= 4) {
                this.c = true;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public Intent a() {
        return null;
    }

    public b b() {
        return null;
    }

    public long c() {
        return ((((long) (this.e - 1)) * 2) + 2) * 1000;
    }

    public synchronized String d() {
        e();
        return this.d;
    }

    public b a(IBinder iBinder) {
        return null;
    }

    public synchronized void a(String str) {
        if (str != null) {
            if (!Pattern.compile("^[0fF\\-]+").matcher(str).matches()) {
                this.d = str;
            }
        }
    }

    private synchronized boolean a(Intent intent) {
        boolean z6;
        z6 = true;
        this.e++;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        try {
            b bVarB = b();
            if (bVarB == null) {
                bVarB = a(this.f1360a, intent);
            }
            if (bVarB != null) {
                this.d = bVarB.f1362a;
            } else {
                z6 = false;
            }
        } catch (Throwable th) {
            FlyLog.getInstance().d(th);
        }
        long jElapsedRealtime2 = SystemClock.elapsedRealtime() - jElapsedRealtime;
        FlyLog.getInstance().d("oa use time: " + jElapsedRealtime2, new Object[0]);
        return z6;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0064 A[Catch: all -> 0x0067, DONT_GENERATE, TRY_LEAVE, TryCatch #4 {all -> 0x0067, blocks: (B:23:0x005f, B:25:0x0064), top: B:44:0x005f }] */
    /* JADX WARN: Code duplicated, block: B:31:0x0070 A[Catch: all -> 0x0073, FINALLY_INSNS, TRY_LEAVE, TryCatch #2 {all -> 0x0073, blocks: (B:29:0x006b, B:31:0x0070), top: B:40:0x006b }] */
    public String a(String str, IBinder iBinder, String str2, int i5, String... strArr) {
        Parcel parcelObtain;
        Parcel parcelObtain2;
        try {
            parcelObtain = Parcel.obtain();
            try {
                parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(str2);
                    if (strArr != null && strArr.length > 0) {
                        for (String str3 : strArr) {
                            parcelObtain.writeString(str3);
                        }
                    }
                    iBinder.transact(i5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    String string = parcelObtain2.readString();
                    try {
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    } catch (Throwable unused) {
                    }
                    return string;
                } catch (Throwable th) {
                    th = th;
                    try {
                        FlyLog.getInstance().d("getStringValue: " + str + " failed! " + th.getMessage(), new Object[0]);
                        if (parcelObtain2 != null) {
                            try {
                                parcelObtain2.recycle();
                                if (parcelObtain != null) {
                                }
                            } catch (Throwable unused2) {
                                return null;
                            }
                        } else if (parcelObtain != null) {
                        }
                        return null;
                    } finally {
                        if (parcelObtain2 != null) {
                            try {
                                parcelObtain2.recycle();
                                if (parcelObtain != null) {
                                    parcelObtain.recycle();
                                }
                            } catch (Throwable unused3) {
                            }
                        } else if (parcelObtain != null) {
                            parcelObtain.recycle();
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                parcelObtain2 = null;
            }
        } catch (Throwable th3) {
            th = th3;
            parcelObtain = null;
            parcelObtain2 = null;
        }
    }

    public class a implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f1361a;
        private final BlockingQueue<IBinder> c;

        private a() {
            this.f1361a = false;
            this.c = new LinkedBlockingQueue();
        }

        public IBinder a(long j6) {
            if (this.f1361a) {
                throw new IllegalStateException();
            }
            this.f1361a = true;
            BlockingQueue<IBinder> blockingQueue = this.c;
            if (j6 <= 0) {
                j6 = 1500;
            }
            return blockingQueue.poll(j6, TimeUnit.MILLISECONDS);
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.c.put(iBinder);
            } catch (Throwable unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x004a A[Catch: all -> 0x004d, TRY_LEAVE, TryCatch #5 {all -> 0x004d, blocks: (B:15:0x0045, B:17:0x004a), top: B:31:0x0045 }] */
    /* JADX WARN: Code duplicated, block: B:23:0x0056 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:24:0x0058 A[Catch: all -> 0x005b, TRY_LEAVE, TryCatch #4 {all -> 0x005b, blocks: (B:22:0x0053, B:24:0x0058), top: B:29:0x0053 }] */
    /* JADX WARN: Code duplicated, block: B:29:0x0053 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public int a(String str, IBinder iBinder, String str2, int i5) throws Throwable {
        Parcel parcelObtain;
        Parcel parcel;
        Parcel parcelObtain2 = null;
        try {
            parcelObtain = Parcel.obtain();
            try {
                parcelObtain2 = Parcel.obtain();
                parcelObtain.writeInterfaceToken(str2);
                iBinder.transact(i5, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                int i6 = parcelObtain2.readInt();
                try {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable unused) {
                }
                return i6;
            } catch (RemoteException unused2) {
                parcel = parcelObtain2;
                parcelObtain2 = parcelObtain;
                try {
                    FlyLog.getInstance().d("getIntValue: " + str + " failed! (remoteException)", new Object[0]);
                    if (parcel != null) {
                        try {
                            parcel.recycle();
                            if (parcelObtain2 != null) {
                                parcelObtain2.recycle();
                            }
                        } catch (Throwable unused3) {
                            return 0;
                        }
                    } else if (parcelObtain2 != null) {
                        parcelObtain2.recycle();
                    }
                    return 0;
                } catch (Throwable th) {
                    th = th;
                    parcelObtain = parcelObtain2;
                    parcelObtain2 = parcel;
                    if (parcelObtain2 != null) {
                        try {
                            parcelObtain2.recycle();
                            if (parcelObtain != null) {
                                parcelObtain.recycle();
                            }
                        } catch (Throwable unused4) {
                            throw th;
                        }
                    } else if (parcelObtain != null) {
                        parcelObtain.recycle();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                if (parcelObtain2 != null) {
                    parcelObtain2.recycle();
                    if (parcelObtain != null) {
                        parcelObtain.recycle();
                    }
                } else if (parcelObtain != null) {
                    parcelObtain.recycle();
                }
                throw th;
            }
        } catch (RemoteException unused5) {
            parcel = null;
        } catch (Throwable th3) {
            th = th3;
            parcelObtain = null;
        }
    }

    private b a(Context context, Intent intent) throws Throwable {
        boolean zBindService;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            a aVar = new a();
            try {
                if (DH.SyncMtd.getOSVersionIntForFly() >= 34) {
                    zBindService = context.bindService(intent, aVar, 513);
                } else {
                    zBindService = context.bindService(intent, aVar, 1);
                }
                if (intent == null || !zBindService) {
                    StringBuilder sb = new StringBuilder("bind service ");
                    sb.append(intent == null ? AbstractC1127c.NULL : intent.getComponent());
                    sb.append(" failed!");
                    throw new Throwable(sb.toString());
                }
                long jC = c();
                FlyLog.getInstance().d("wte " + jC, new Object[0]);
                IBinder iBinderA = aVar.a(c());
                if (iBinderA == null) {
                    throw new Throwable("get binder " + intent.getComponent() + " failed!");
                }
                b bVarA = a(iBinderA);
                try {
                    context.unbindService(aVar);
                    return bVarA;
                } catch (Throwable th) {
                    FlyLog.getInstance().d(th);
                    return bVarA;
                }
            } catch (Throwable th2) {
                try {
                    context.unbindService(aVar);
                } catch (Throwable th3) {
                    FlyLog.getInstance().d(th3);
                }
                throw th2;
            }
        }
        throw new Throwable("unable to invoke in main thread!");
    }
}
