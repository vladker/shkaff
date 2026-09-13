package cn.fly.commons.cc;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;

/* JADX INFO: loaded from: classes.dex */
public class d implements t<Context> {
    @Override // cn.fly.commons.cc.t
    public boolean a(Context context, Class<Context> cls, String str, Object[] objArr, boolean[] zArr, Object[] objArr2, Throwable[] thArr) {
        if (cn.fly.commons.o.a("016'ejMfi+elecfi(ifUdfel9f@djdddiTcf").equals(str) && objArr.length == 1) {
            Object obj = objArr[0];
            if (obj instanceof String) {
                try {
                    objArr2[0] = context.getSystemService((String) obj);
                } catch (Throwable th) {
                    objArr2[0] = null;
                    thArr[0] = th;
                }
                return true;
            }
        }
        if ("getApplicationInfo".equals(str) && objArr.length == 0) {
            objArr2[0] = context.getApplicationInfo();
            return true;
        }
        if (cn.fly.commons.o.a("018!ej fiIeddkXeifei^gj fIfidk,g@dd(f*dj").equals(str) && objArr.length == 0) {
            objArr2[0] = context.getContentResolver();
            return true;
        }
        if (cn.fly.commons.o.a("014QejTfi+gl8dc>ehRdBej9fOeg.d^df*f").equals(str) && objArr.length == 0) {
            objArr2[0] = context.getPackageName();
            return true;
        }
        if (cn.fly.commons.o.a("017?ej2fiIglPdc2eh?dHej!f$hcSded*ej;f>dj").equals(str) && objArr.length == 0) {
            objArr2[0] = context.getPackageManager();
            return true;
        }
        if (cn.fly.commons.o.a("013,fiLidKdj[iGfd_ci2didddi*i(ec").equals(str) && objArr.length == 1) {
            Object obj2 = objArr[0];
            if (obj2 instanceof Intent) {
                context.startActivity((Intent) obj2);
                return true;
            }
        }
        if (cn.fly.commons.o.a("011Vej5fiAgcdi gf0fifldidj").equals(str)) {
            objArr2[0] = context.getFilesDir();
            return true;
        }
        if (cn.fly.commons.o.a("009>ejIfi6fdfifi$fi.fi").equals(str)) {
            objArr2[0] = context.getAssets();
            return true;
        }
        if (cn.fly.commons.o.a("019chfc9ehelDfgNefgl6fYdjdfdififididk9e").equals(str) && objArr.length == 1) {
            Object obj3 = objArr[0];
            if (obj3 instanceof String) {
                objArr2[0] = Integer.valueOf(context.checkSelfPermission((String) obj3));
                return true;
            }
        }
        if (cn.fly.commons.o.a("011[ffdi,e(dcel]fDdjdddiTcf").equals(str) && objArr.length == 3) {
            objArr2[0] = Boolean.valueOf(context.bindService((Intent) objArr[0], (ServiceConnection) objArr[1], ((Integer) objArr[2]).intValue()));
            return true;
        }
        if (cn.fly.commons.o.a("013$dg3eDffdi+e]dcel+f;djdddiNcf").equals(str) && objArr.length == 1) {
            Object obj4 = objArr[0];
            if (obj4 instanceof ServiceConnection) {
                context.unbindService((ServiceConnection) obj4);
                return true;
            }
        }
        return false;
    }
}
