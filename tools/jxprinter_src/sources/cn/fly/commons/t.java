package cn.fly.commons;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import cn.fly.tools.FlyLog;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes.dex */
public class t extends Binder implements IInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private CountDownLatch f1477a;
    private volatile String b;
    private volatile boolean c = false;
    private final String d;

    public t() {
        String strB = x.b("043bJcjceckUg_chBgNcjEdCcjcick5bf?cjcfcbehUe*ciccchEbe3ckcjQc+chcbckddfgecddekdc9cffJei$cb4dg");
        this.d = strB;
        attachInterface(this, strB);
    }

    public void a(int i5, long j6, boolean z6, float f6, double d, String str) {
    }

    public boolean b() {
        return this.c;
    }

    @Override // android.os.Binder, android.os.IBinder
    public String getInterfaceDescriptor() {
        return this.d;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i5, Parcel parcel, Parcel parcel2, int i6) {
        if (i5 == 1) {
            parcel.enforceInterface(this.d);
            a(parcel.readInt(), parcel.readLong(), parcel.readInt() > 0, parcel.readFloat(), parcel.readDouble(), parcel.readString());
        } else {
            if (i5 != 2) {
                if (i5 != 1598968902) {
                    return super.onTransact(i5, parcel, parcel2, i6);
                }
                parcel2.writeString(this.d);
                return true;
            }
            parcel.enforceInterface(this.d);
            a(parcel.readInt(), parcel.readInt() > 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
        }
        parcel2.writeNoException();
        return true;
    }

    public String a() {
        return this.b;
    }

    public t a(CountDownLatch countDownLatch) {
        this.f1477a = countDownLatch;
        return this;
    }

    public void a(int i5, Bundle bundle) {
        try {
            if (bundle.containsKey(x.b("010Lcj3cJcgchcbcgdeJfc_di"))) {
                this.b = bundle.getString(x.b("010YcjXc)cgchcbcgdeAfc di"));
            } else if (bundle.containsKey(x.b("017:cj0c=cgchcbcgRf9chcech=h:cgeh0hche"))) {
                this.c = bundle.getBoolean(x.b("017Xcj1c(cgchcbcgHf.chcechQh2cgehHhche"));
            }
            CountDownLatch countDownLatch = this.f1477a;
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
        } catch (Throwable th) {
            FlyLog.getInstance().d(th);
        }
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }
}
