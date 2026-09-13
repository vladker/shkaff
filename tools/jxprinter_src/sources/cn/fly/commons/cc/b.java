package cn.fly.commons.cc;

/* JADX INFO: loaded from: classes.dex */
public class b implements t<b> {
    @Override // cn.fly.commons.cc.t
    public boolean a(b bVar, Class<b> cls, String str, Object[] objArr, boolean[] zArr, Object[] objArr2, Throwable[] thArr) {
        if (objArr == null) {
            return false;
        }
        if ("ghclz".equals(str)) {
            try {
                if (objArr.length == 1) {
                    objArr2[0] = cn.fly.tools.a.e.a().b((String) objArr[0]);
                }
            } catch (Throwable th) {
                thArr[0] = th;
            }
        } else if ("nhins".equals(str)) {
            try {
                if (objArr.length == 1) {
                    objArr2[0] = cn.fly.tools.a.e.a().a((String) objArr[0]);
                } else if (objArr.length == 3) {
                    objArr2[0] = cn.fly.tools.a.e.a().a((String) objArr[0], (Class[]) objArr[1], (Object[]) objArr[2]);
                }
            } catch (Throwable th2) {
                thArr[0] = th2;
            }
        } else if ("ghfld".equals(str)) {
            try {
                if (objArr.length == 4) {
                    objArr2[0] = cn.fly.tools.a.e.a().a((String) objArr[0], (String) objArr[1], objArr[2], (Class) objArr[3]);
                }
            } catch (Throwable th3) {
                thArr[0] = th3;
            }
        } else if ("ihacnm".equals(str)) {
            try {
                if (objArr.length == 6) {
                    objArr2[0] = cn.fly.tools.a.e.a().a((String) objArr[0], objArr[1], (String) objArr[2], (Class[]) objArr[3], (Object[]) objArr[4], (Class<?>) objArr[5]);
                }
            } catch (Throwable th4) {
                thArr[0] = th4;
            }
        } else if ("ihaclz".equals(str)) {
            try {
                if (objArr.length == 6) {
                    objArr2[0] = cn.fly.tools.a.e.a().a((Class) objArr[0], objArr[1], (String) objArr[2], (Class[]) objArr[3], (Object[]) objArr[4], (Class<?>) objArr[5]);
                }
            } catch (Throwable th5) {
                thArr[0] = th5;
            }
        } else if ("exha".equals(str)) {
            try {
                if (objArr.length == 1) {
                    objArr2[0] = Boolean.valueOf(cn.fly.tools.a.e.a().a((String[]) objArr[0]));
                }
            } catch (Throwable th6) {
                thArr[0] = th6;
            }
        } else {
            thArr[0] = new IllegalArgumentException("wrp");
        }
        return true;
    }
}
