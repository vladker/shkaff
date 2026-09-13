package cn.fly.commons.cc;

/* JADX INFO: loaded from: classes.dex */
public class q implements t<p> {
    @Override // cn.fly.commons.cc.t
    public boolean a(p pVar, Class<p> cls, String str, Object[] objArr, boolean[] zArr, Object[] objArr2, Throwable[] thArr) {
        Object obj;
        if (!"setHandler".equals(str) || objArr.length != 1 || (obj = objArr[0]) == null || !(obj instanceof m)) {
            return false;
        }
        pVar.a((m) obj);
        return true;
    }
}
