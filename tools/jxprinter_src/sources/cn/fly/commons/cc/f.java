package cn.fly.commons.cc;

import android.content.Intent;
import android.content.pm.PackageManager;

/* JADX INFO: loaded from: classes.dex */
public class f implements t<PackageManager> {
    @Override // cn.fly.commons.cc.t
    public boolean a(PackageManager packageManager, Class<PackageManager> cls, String str, Object[] objArr, boolean[] zArr, Object[] objArr2, Throwable[] thArr) {
        if (cn.fly.commons.n.a("019Ebcbe?dMbhcacc:cgdcgEcjRd bhbbbg$adSdg").equals(str) && objArr.length == 2) {
            Object obj = objArr[0];
            if (obj instanceof Intent) {
                Object obj2 = objArr[1];
                if (obj2 instanceof Integer) {
                    objArr2[0] = packageManager.queryIntentServices((Intent) obj, ((Integer) obj2).intValue());
                    return true;
                }
            }
        }
        if (cn.fly.commons.n.a("025<chMdgLdc9b^be9caf+ccScgdcg?eabibhej*ba>cf.b?ch*d").equals(str) && objArr.length == 1) {
            Object obj3 = objArr[0];
            if (obj3 instanceof String) {
                objArr2[0] = packageManager.getLaunchIntentForPackage((String) obj3);
                return true;
            }
        }
        if (cn.fly.commons.n.a("015^bh)dVdgbi6eXbbLdPdb7ag+bgbbbg?gSca").equals(str) && objArr.length == 2) {
            Object obj4 = objArr[0];
            if (obj4 instanceof Integer) {
                Object obj5 = objArr[1];
                if (obj5 instanceof Integer) {
                    objArr2[0] = packageManager.resolveActivity((Intent) obj4, ((Integer) obj5).intValue());
                    return true;
                }
            }
        }
        return false;
    }
}
