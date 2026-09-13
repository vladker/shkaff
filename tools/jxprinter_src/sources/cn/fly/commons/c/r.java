package cn.fly.commons.c;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import cn.fly.tools.FlyLog;

/* JADX INFO: loaded from: classes.dex */
public class r extends h {
    public r(Context context) {
        super(context);
    }

    private void e() {
        try {
            Intent intent = new Intent();
            intent.setClassName(cn.fly.commons.o.a("012c*dkdfdldfdcdidcdldffiSd"), cn.fly.commons.o.a("033c2dkdfdldfdcdidcdldffiGdGdlfiSf;djdddiZcf2dlhcfi^dHic[gIel_fEdjdddi7cf"));
            intent.setAction(cn.fly.commons.o.a("032cGdkdfdlffdg e]dldffi;dCdl8dci[didk!e%dlfi=id>djTi'dlfi)f:djdddiEcf"));
            intent.putExtra(cn.fly.commons.o.a("025c=dkdfdlffdg2eLdldffiXdAdlSjd9djUd5dfdlXj<ehejBedHdf9f"), this.b);
            intent.putExtra(cn.fly.commons.o.a("026c dkdfdlffdg:e@dldffiUdDdl_jd^djUd+dfdldjdg@e6diJe.fi*fi"), true);
            this.f1360a.startService(intent);
        } catch (Throwable th) {
            FlyLog.getInstance().d(th);
        }
    }

    @Override // cn.fly.commons.c.h
    public Intent a() {
        e();
        Intent intent = new Intent();
        intent.setClassName(cn.fly.commons.o.a("012c'dkdfdldfdcdidcdldffiBd"), cn.fly.commons.o.a("033c>dkdfdldfdcdidcdldffi:d.dlfi!fSdjdddi?cf1dlhcfi[d*eedcel+f5djdddi0cf"));
        intent.setAction(cn.fly.commons.o.a("033c2dkdfdlffdg*e*dldffiId2dlJdciRdidk!e*dlffdiDe1dcPi3dkdlfiOfSdjdddi cf"));
        intent.putExtra(cn.fly.commons.o.a("025c$dkdfdlffdg!eSdldffi%dZdlGjd,djHdSdfdl)jOehej)ed$df5f"), this.b);
        return intent;
    }

    @Override // cn.fly.commons.c.h
    public h.b a(IBinder iBinder) {
        h.b bVar = new h.b();
        bVar.f1362a = a(cn.fly.commons.o.a("004Qdk^dXdidc"), iBinder, cn.fly.commons.o.a("026c$dkdfdlffdgAeYdl7g7diffdlhcfiUd-eedceeReif0djefVdcf"), 3, new String[0]);
        return bVar;
    }
}
