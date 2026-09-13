package cn.fly.commons.cc;

import android.database.ContentObserver;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class k extends ContentObserver implements t<k> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private m f1374a;

    public k() {
        super(null);
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z6) {
        if (this.f1374a != null) {
            ArrayList<Object> arrayList = new ArrayList<>(1);
            arrayList.add(Boolean.valueOf(z6));
            this.f1374a.a("onChange", arrayList);
        }
    }

    public void a(m mVar) {
        this.f1374a = mVar;
    }

    @Override // cn.fly.commons.cc.t
    public boolean a(k kVar, Class<k> cls, String str, Object[] objArr, boolean[] zArr, Object[] objArr2, Throwable[] thArr) {
        Object obj;
        if (!"setHandler".equals(str) || objArr.length != 1 || (obj = objArr[0]) == null || !(obj instanceof m)) {
            return false;
        }
        kVar.a((m) obj);
        return true;
    }
}
