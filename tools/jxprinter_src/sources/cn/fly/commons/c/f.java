package cn.fly.commons.c;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Parcel;
import android.text.TextUtils;
import cn.fly.commons.t;
import cn.fly.commons.x;
import cn.fly.tools.FlyLog;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class f extends h {
    public f(Context context) {
        super(context);
    }

    @Override // cn.fly.commons.c.h
    public Intent a() {
        Intent intent = new Intent();
        intent.setAction(x.b("028b[cjceck(gMch0gLcj_dEcjcickchcbckej:d_fgNcPddcbdkYe>ciccch]be"));
        intent.setPackage(x.b("014bTcjceckVgJch]g]cjWd8cjcickchcb"));
        return intent;
    }

    @Override // cn.fly.commons.c.h
    public h.b a(IBinder iBinder) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        t tVar = new t();
        tVar.a(countDownLatch);
        long jCurrentTimeMillis = System.currentTimeMillis();
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(x.b("042bQcjceckHg=ch)g@cjHdNcjcick3bf^cjcfcbehKe)ciccch'be1ckcj2c5chcbckddfgecddekdkNe=ciccch*be"));
            parcelObtain.writeStrongBinder(tVar);
            iBinder.transact(2, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            countDownLatch.await(2000L, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            try {
                FlyLog.getInstance().d(th);
            } catch (Throwable th2) {
                try {
                    parcelObtain.recycle();
                    parcelObtain2.recycle();
                } catch (Throwable unused) {
                }
                throw th2;
            }
        }
        try {
            parcelObtain.recycle();
            parcelObtain2.recycle();
        } catch (Throwable unused2) {
        }
        FlyLog.getInstance().d("hord is null ? " + TextUtils.isEmpty(tVar.a()) + " cost " + (System.currentTimeMillis() - jCurrentTimeMillis), new Object[0]);
        if (TextUtils.isEmpty(tVar.a())) {
            return null;
        }
        h.b bVar = new h.b();
        bVar.f1362a = tVar.a();
        return bVar;
    }
}
