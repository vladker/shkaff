package cn.fly.commons.c;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import cn.fly.tools.FlyLog;
import cn.fly.tools.utils.DH;

/* JADX INFO: loaded from: classes.dex */
public class k extends h {
    public k(Context context) {
        super(context);
    }

    private String a(String str, String str2) {
        Bundle bundleB = b(str, str2);
        if (a(bundleB)) {
            return bundleB.getString(cn.fly.commons.a.l.a("002^ejed"));
        }
        if (bundleB != null) {
            return bundleB.getString(cn.fly.commons.a.l.a("0075egUg9gjgjVeSfkOg"));
        }
        return null;
    }

    @Override // cn.fly.commons.c.h
    public h.b b() {
        h.b bVar = new h.b();
        bVar.f1362a = a(cn.fly.commons.a.l.a("007Ofk6gj:higeffgm"), (String) null);
        return bVar;
    }

    private Bundle b(String str, String str2) {
        try {
            Uri uri = Uri.parse(cn.fly.commons.a.l.a("036dOel7fjgfjlmmdfOemUf(ehggej=eCemejed(gfjTejHj)fd1m>ejedVgfj@ejKj2fd"));
            int oSVersionIntForFly = DH.SyncMtd.getOSVersionIntForFly();
            if (oSVersionIntForFly < 17) {
                if (oSVersionIntForFly >= 11) {
                    return this.f1360a.getContentResolver().call(uri, str, str2, (Bundle) null);
                }
                return null;
            }
            ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient = this.f1360a.getContentResolver().acquireUnstableContentProviderClient(uri);
            Bundle bundleCall = contentProviderClientAcquireUnstableContentProviderClient.call(str, str2, null);
            if (oSVersionIntForFly >= 24) {
                contentProviderClientAcquireUnstableContentProviderClient.close();
                return bundleCall;
            }
            contentProviderClientAcquireUnstableContentProviderClient.release();
            return bundleCall;
        } catch (Throwable th) {
            FlyLog.getInstance().d(th);
            return null;
        }
    }

    private boolean a(Bundle bundle) {
        return bundle != null && bundle.getInt(cn.fly.commons.a.l.a("004d*eledIg"), -1) == 0;
    }
}
