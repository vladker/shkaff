package V1;

import M0.d;
import android.app.Activity;
import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.C0491g;
import com.bumptech.glide.load.engine.N;
import com.bumptech.glide.load.engine.cache.c;
import com.bumptech.glide.load.engine.cache.l;
import com.bumptech.glide.load.resource.bitmap.InterfaceC0523s;
import com.bumptech.glide.manager.j;
import com.google.android.datatransport.Transformer;
import com.google.android.gms.internal.play_billing.zzkw;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Stack;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import p027e3.g;
import p027e3.o;
import p027e3.p;
import p027e3.q;
import p039g3.A;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements a, Transformer, d, c, InterfaceC0523s, j, p015c1.a, g, p, q, o, p027e3.d {
    public static Stack b;
    public static b c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f740a;

    public /* synthetic */ b(int i5) {
        this.f740a = i5;
    }

    public static Activity d() {
        Stack stack = b;
        if (stack == null || stack.size() == 0) {
            return null;
        }
        return (Activity) b.lastElement();
    }

    public static void f() {
        for (Activity activity : b) {
            if (activity != null) {
                activity.finish();
            }
        }
        b.clear();
    }

    public static b h() {
        if (c == null) {
            b bVar = new b(16);
            if (b == null) {
                b = new Stack();
            }
            c = bVar;
        }
        return c;
    }

    @Override // p027e3.g
    public void accept(Object obj) {
    }

    @Override // com.google.android.datatransport.Transformer, p027e3.o
    public Object apply(Object obj) {
        switch (this.f740a) {
            case 8:
                return ((zzkw) obj).zzQ();
            default:
                return obj;
        }
    }

    @Override // p015c1.a
    public String c(Object obj) {
        switch (this.f740a) {
            case 17:
                String[] strArr = (String[]) obj;
                if (strArr.length == 0) {
                    return "";
                }
                String[] strArr2 = new String[strArr.length];
                int i5 = 0;
                for (String str : strArr) {
                    if (str != null) {
                        strArr2[i5] = str;
                        i5++;
                    }
                }
                if (i5 == 0) {
                    return "";
                }
                StringBuilder sb = new StringBuilder("╔═══════════════════════════════════════════════════════════════════════════════════════════════════");
                sb.append(p057k1.c.f5473a);
                for (int i6 = 0; i6 < i5; i6++) {
                    String str2 = strArr2[i6];
                    StringBuilder sb2 = new StringBuilder(str2.length() + 10);
                    String[] strArrSplit = str2.split(p057k1.c.f5473a);
                    int length = strArrSplit.length;
                    for (int i7 = 0; i7 < length; i7++) {
                        if (i7 != 0) {
                            sb2.append(p057k1.c.f5473a);
                        }
                        String str3 = strArrSplit[i7];
                        sb2.append((char) 9553);
                        sb2.append(str3);
                    }
                    sb.append(sb2.toString());
                    if (i6 != i5 - 1) {
                        String str4 = p057k1.c.f5473a;
                        androidx.collection.a.x(sb, str4, "╟───────────────────────────────────────────────────────────────────────────────────────────────────", str4);
                    } else {
                        sb.append(p057k1.c.f5473a);
                        sb.append("╚═══════════════════════════════════════════════════════════════════════════════════════════════════");
                    }
                }
                return sb.toString();
            case 21:
                Throwable th = (Throwable) obj;
                String str5 = p063l1.a.f5782a;
                if (th == null) {
                    return "";
                }
                for (Throwable cause = th; cause != null; cause = cause.getCause()) {
                    if (cause instanceof UnknownHostException) {
                        return "";
                    }
                }
                StringWriter stringWriter = new StringWriter();
                PrintWriter printWriter = new PrintWriter(stringWriter);
                th.printStackTrace(printWriter);
                printWriter.flush();
                return stringWriter.toString();
            default:
                StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) obj;
                StringBuilder sb3 = new StringBuilder(256);
                if (stackTraceElementArr.length == 0) {
                    return null;
                }
                if (stackTraceElementArr.length == 1) {
                    return "\t─ " + stackTraceElementArr[0].toString();
                }
                int length2 = stackTraceElementArr.length;
                for (int i8 = 0; i8 < length2; i8++) {
                    if (i8 != length2 - 1) {
                        sb3.append("\t├ ");
                        sb3.append(stackTraceElementArr[i8].toString());
                        sb3.append(p057k1.c.f5473a);
                    } else {
                        sb3.append("\t└ ");
                        sb3.append(stackTraceElementArr[i8].toString());
                    }
                }
                return sb3.toString();
        }
    }

    @Override // M0.d
    public Object create() {
        switch (this.f740a) {
            case 9:
                return new N();
            default:
                try {
                    return new l(MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256));
                } catch (NoSuchAlgorithmException e) {
                    throw new RuntimeException(e);
                }
        }
    }

    @Override // V1.a
    public boolean e(int i5) {
        switch (this.f740a) {
            case 0:
                return i5 == 1;
            case 1:
                return i5 == 1;
            case 2:
                return i5 == 1;
            case 3:
                return i5 == 1;
            case 4:
                return i5 > 0;
            case 5:
                return i5 == 1;
            default:
                return i5 == 1;
        }
    }

    @Override // V1.a
    public double g(double[] dArr, int i5) {
        switch (this.f740a) {
            case 0:
                double d = dArr[0];
                if (d > 0.0d) {
                    return 1.0d;
                }
                return d < 0.0d ? -1.0d : 0.0d;
            case 1:
                return Math.sin(dArr[0]);
            case 2:
                return (Math.pow(2.718281828459045d, dArr[0]) - Math.pow(2.718281828459045d, -dArr[0])) / 2.0d;
            case 3:
                return Math.sqrt(dArr[0]);
            case 4:
                double d6 = 0.0d;
                for (int i6 = 0; i6 < i5; i6++) {
                    d6 += dArr[i6];
                }
                return d6;
            case 5:
                return Math.tan(dArr[0]);
            default:
                double dPow = Math.pow(2.718281828459045d, dArr[0] * 2.0d);
                return (dPow - 1.0d) / (dPow + 1.0d);
        }
    }

    @Override // com.bumptech.glide.load.engine.cache.c
    public File get(p126w0.q qVar) {
        return null;
    }

    @Override // p027e3.q
    public boolean test(Object obj) {
        switch (this.f740a) {
            case 24:
                return false;
            default:
                return true;
        }
    }

    public String toString() {
        switch (this.f740a) {
            case 0:
                return "sign(x)";
            case 1:
                return "sin(x)";
            case 2:
                return "sinh(x)";
            case 3:
                return "sqrt(x)";
            case 4:
                return "sum(x1, x2, ..., xn)";
            case 5:
                return "tan(x)";
            case 6:
                return "tanh(x)";
            case 22:
                return "EmptyConsumer";
            case 25:
                return "IdentityFunction";
            default:
                return super.toString();
        }
    }

    @Override // p027e3.p
    public void accept(long j6) {
    }

    @Override // p027e3.d
    public boolean test(Object obj, Object obj2) {
        return A.a(obj, obj2);
    }

    @Override // com.bumptech.glide.load.resource.bitmap.InterfaceC0523s
    public void b() {
    }

    @Override // com.bumptech.glide.load.engine.cache.c
    public void clear() {
    }

    @Override // com.bumptech.glide.load.engine.cache.c
    public void a(p126w0.q qVar, C0491g c0491g) {
    }

    @Override // com.bumptech.glide.load.resource.bitmap.InterfaceC0523s
    public void onDecodeComplete(com.bumptech.glide.load.engine.bitmap_recycle.c cVar, Bitmap bitmap) {
    }
}
