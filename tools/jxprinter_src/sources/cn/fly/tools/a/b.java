package cn.fly.tools.a;

import android.content.Context;
import android.util.Base64;
import cn.fly.commons.C0396r;
import cn.fly.commons.x;
import cn.fly.tools.utils.ReflectHelper;
import cn.fly.tools.utils.ResHelper;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f1600a = x.b("014Mckehgegdegiegcgi*cCehcbgfccie");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static volatile boolean f1601j = false;
    private Method b = null;
    private Method c = null;
    private Method d = null;
    private Method e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Method f1602f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Method f1603g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Method f1604h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f1605i = false;

    public static boolean b(Context context) {
        if (!f1601j) {
            try {
                File file = new File(context.getFilesDir(), f1600a);
                if (file.exists()) {
                    f1601j = file.delete();
                }
            } catch (Throwable unused) {
            }
        }
        return f1601j;
    }

    public boolean a(Context context) {
        try {
            ResHelper.deleteFileAndFolder(new File(context.getFilesDir(), x.b("014 ckehgegdegiegcgiPcCehcbgfccge")));
        } catch (Throwable unused) {
        }
        try {
            File file = new File(context.getFilesDir(), f1600a);
            FileOutputStream fileOutputStream = null;
            if (!file.exists()) {
                byte[] bArrDecode = Base64.decode("UEsDBBQACAgIAG2HfFYAAAAAAAAAAAAAAAAUAAQATUVUQS1JTkYvTUFOSUZFU1QuTUb+ygAA803My0xLLS7RDUstKs7Mz7NSMNQz4OVySa3Q9clPTiwBCyXnJBYXpxbrpaRW8HI5F6UmlqSm6DpVWimkVACVG5rxcvFyAQBQSwcI8N6zmEcAAABJAAAAUEsDBBQACAgIAG2HfFYAAAAAAAAAAAAAAAALAAAAY2xhc3Nlcy5kZXidV11sVEUUPnPn/uy9e3e7vWC3wEILW6H8yIKgAtsgpQrVbBWkaQwlxmX3Uq52d8vubcGfGDXgz4OJSkxIRKMPNTyY+BPiDw8mxN8HH9Qn9UXRaHzQRBMf0ETjNzN3t1tpYuIm3z1nzpzzzZk5c2fnlv0TzqYt15HfaYw/tO77Qw+en+UXjNXPnf+zu48u6qczCaIpIjoxttWj6Fd2iQZJ2TuAkBHBjV5n1PqlgIJGJEyfQm5yiH6GvMtCPBAAx4Bp4CTwBPAUcBp4HngX+BL4HbBiRMuAHLAHmAAeBV4EXgZmgXPAq8BrwPvAl8AvwGXgL4DbRBlgA7AF2AnsBcaAcaABnALOAG8AF4APgc+BH4BfgD8AhnkkgC5gM7AHOAQcB04BzwIvAOeAN4GLwFfAN8CPwG8AaAiC4gCWUq5dMlpLsW6dgFjsRcBVQDewBFgKGAAHfjWJMC3Sgcumsgs9hvUyIz1lzdnb/bvFmkZ6f5u+tc1/V8Qjch22VC5OVNvFkb4P9q5oHncKElg16eFST+S7Vj5NWiclo41SGpHU6XopLSk5RlsjrYrHQsY3SBmnvJgbrH1SqraNiGukVG01gsqfInkOk9jhqrbgfA/Jfh1X+ndt+t9tetKd01dFuuBVkkmdxRX/VMqW1euAVdTFhP1uUb+Et8Fb5jkZk9NSaxVl33Gx/wwasWNOdVOMZmJoy741lP1kri9ju0LGIx+WfSsBnxU0YpmIS9Jnpmv0GJyyHwn7gLRn30Z8LEkjMctBOy789psu78GmV37rpd9IotWn9WjoeyVBov2F6epinJGkGmPI7Ijb0XxymE9GzCftmRkN+XLMJcR4BvI1dFPkea3uMk/LNsAQ46ZgWMnFDuDYyQk8Bc+N4BE18myvO6ODxwDPY+CxDJGbLXhGkZenZ0+BxzFswbPbUDwqYvVCETx7Ev5xXfpzZNLDYlTtTdAjeLp0kVy9UxcVMmQeh+JqT3r9nuV1qRmhAidbM7IyGLN9ZtlHBb9mjbianNszmsjJBnsHKi0sLyVcrVMT77Eh358Gxuj932t27JBOT18QjE5Ug8fBt0HwdXtWhoNPB98psX/AZxqW4BsywKfWwtYtwbdZj9ZORtxA2WmXIk85rvDRuMs7ebNGZzHOrVGNtsUdWnl+m27RNteglR9sh3YsZeLNFOv5fyt4dRTh/kcFLaxuXFbQkRXs/7j5v2K1vef9XL2jQor8U1y9k+J/RtThshadhVzFZbiKM1rnqA7pyvO3eW5oUiYin7l+LtuG9FH6XFwiihM2Fp2HTJ4K+trR0TzxgdEdZA4E1SDcSdrOfkoMB7uDatmvb7ynOFMkrVAgXsBDL4inWZA/yhRKtUquUs6VimHusPTPNQPztLxQLk7OBPfmitVqLSyGQa2aOxBMVIvhdN3P09IFukeP1mvHG3nqLIhhc5PF6kRuaLLYgMlrM91++B6/FM63HQjrQXUiT1e12SRd8fAkRutpM9f9I5OIzw3Vqo2wPl0Ka8h2yQIOewJ/siwyvbJrxA+P1tDHxkgbO0jsIGkHC8TGyRu/MvdF4wskP8/YzN4uiYjbihWfeGnyftJLyJHSaqU2Nu5rhH5l49jIHdPVMIBP0j/hV6bE0jWGB/fdQsYRkTHZUkgW60itLpVEpKjEiU/4IXXhcZOPIet+uW0xKNVml2tAnW2WiCF9hSnqsNAxPITkbaGoeAdqM2kPemsKUYwZVGdq9/rkKCknY1ZUn6Okmo7SG7SkEh7du3D2i+Z3qQQWzzdGwwqWA0gyKJf96uBUcHNrOcmt+seHbwFrsVryKY5Wq2FPFevFSkNOUamoKcXqfskPZvw6JRp+OFgq+Y1GgL1HXY2FR9DDo0GDjJni5DQ4ZyqtorZUuX1woFlJ2suutW69xKnPYV6Ks7XO+9wY1NniFOfXO99x7Ron4Pou4wTtYhlrwyXO+pzznJbrtJ5nVuWFRYsslzjf6sxyttIeoLSxPL95+w4rz7wOzq4DKa7BA7TCyEhzO0/ffN5Zrm1zaCvPCLfZ/doDy+eNsEWMsCI2QBpjOzPxNEsn0jzt4plMpyHT0EjT0Me6zXk+yX/5iD6j1afaVqudbPnYLVsrVt4nH3lYf91kT7JPTGafiTH7W+Anm9mfOsw+G2f2SXH16mg7s5uy+f2g0dw3BKe57whx/ja/IUya+47gKdUWZzzrVXfaTQg0e5WPuO+xlDqDxZ1X61Vjie8OHvnLu1uv4hH3QYpi5T0xpXTxjfMPUEsHCKFWFIudBgAAHA0AAFBLAQIUABQACAgIAG2HfFbw3rOYRwAAAEkAAAAUAAQAAAAAAAAAAAAAAAAAAABNRVRBLUlORi9NQU5JRkVTVC5NRv7KAABQSwECFAAUAAgICABth3xWoVYUi50GAAAcDQAACwAAAAAAAAAAAAAAAACNAAAAY2xhc3Nlcy5kZXhQSwUGAAAAAAIAAgB/AAAAYwcAAAAA", 2);
                try {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                    try {
                        fileOutputStream2.write(bArrDecode);
                        C0396r.a(fileOutputStream2);
                        file.setReadOnly();
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        C0396r.a(fileOutputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            Class cls = (Class) ReflectHelper.invokeInstanceMethod(ReflectHelper.newInstance(ReflectHelper.importClass(x.b("0217cb4cf!ccchdgckehdbeh<he*ceckekJe.dhfbch+fe")), file), x.b("009f0cjCcGcbdcOfc(eheh"), new Object[]{x.b("026b:cjceckcecbckMbch*ckeech6d5cb0e=cickejcheich dTcb4e]ci"), null}, new Class[]{String.class, ClassLoader.class});
            Method declaredMethod = cls.getDeclaredMethod(x.b("014eFdh,e ceRih+chcj[dMehejecfkdd"), String[].class);
            this.b = declaredMethod;
            declaredMethod.setAccessible(true);
            Method declaredMethod2 = cls.getDeclaredMethod(x.b("010@ch(d8cccjdgHeFejecfkdd"), Class.class, Object.class, String.class, Class[].class, Object[].class);
            this.c = declaredMethod2;
            declaredMethod2.setAccessible(true);
            Method declaredMethod3 = cls.getDeclaredMethod(x.b("010Jch4dOcccjdgEe[ejecfkdd"), String.class, Object.class, String.class, Class[].class, Object[].class);
            this.d = declaredMethod3;
            declaredMethod3.setAccessible(true);
            Method declaredMethod4 = cls.getDeclaredMethod(x.b("012deKefejddSd+ehThcdbe"), String.class);
            this.e = declaredMethod4;
            declaredMethod4.setAccessible(true);
            Method declaredMethod5 = cls.getDeclaredMethod(x.b("012de3efejddVd!eh<hcdbe"), String.class, Class[].class, Object[].class);
            this.f1602f = declaredMethod5;
            declaredMethod5.setAccessible(true);
            Method declaredMethod6 = cls.getDeclaredMethod(x.b("009(di2ehMejfbch)ef8cb"), String.class, String.class, Object.class);
            this.f1603g = declaredMethod6;
            declaredMethod6.setAccessible(true);
            Method declaredMethod7 = cls.getDeclaredMethod(x.b("007Rdi]eh ejdcRf0fc"), String.class);
            this.f1604h = declaredMethod7;
            declaredMethod7.setAccessible(true);
            this.f1605i = true;
        } catch (Throwable unused2) {
            this.f1605i = false;
        }
        return this.f1605i;
    }

    @Override // cn.fly.tools.a.a
    public Class b(String str) throws Throwable {
        Method method = this.f1604h;
        if (method != null) {
            return (Class) method.invoke(null, str);
        }
        throw new Throwable("gHC is null");
    }

    @Override // cn.fly.tools.a.a
    public <T> T a(Class cls, Object obj, String str, Class[] clsArr, Object[] objArr, Class<?> cls2) throws Throwable {
        Method method = this.c;
        if (method != null) {
            return (T) method.invoke(null, cls, obj, str, clsArr, objArr);
        }
        throw new Throwable("IHA is null");
    }

    @Override // cn.fly.tools.a.a
    public <T> T a(String str, Object obj, String str2, Class[] clsArr, Object[] objArr, Class<?> cls) throws Throwable {
        Method method = this.d;
        if (method != null) {
            return (T) method.invoke(null, str, obj, str2, clsArr, objArr);
        }
        throw new Throwable("IHABC is null");
    }

    @Override // cn.fly.tools.a.a
    public <T> T a(String str) throws Throwable {
        Method method = this.e;
        if (method != null) {
            return (T) method.invoke(null, str);
        }
        throw new Throwable("nHI is null");
    }

    @Override // cn.fly.tools.a.a
    public <T> T a(String str, String str2, Object obj, Class<?> cls) throws Throwable {
        Method method = this.f1603g;
        if (method != null) {
            return (T) method.invoke(null, str, str2, obj);
        }
        throw new Throwable("gHF is null");
    }

    @Override // cn.fly.tools.a.a
    public <T> T a(String str, Class[] clsArr, Object[] objArr) throws Throwable {
        Method method = this.f1602f;
        if (method != null) {
            return (T) method.invoke(null, str, clsArr, objArr);
        }
        throw new Throwable("nHIByParams is null");
    }
}
