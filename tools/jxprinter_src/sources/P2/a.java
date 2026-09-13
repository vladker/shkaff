package P2;

import A3.AbstractC0157z;
import R2.f;
import android.util.Log;
import java.util.logging.Level;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements f, V1.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f563a;

    public /* synthetic */ a(int i5) {
        this.f563a = i5;
    }

    public static int c(Level level) {
        int iIntValue = level.intValue();
        if (iIntValue < 800) {
            return iIntValue < 500 ? 2 : 3;
        }
        if (iIntValue < 900) {
            return 4;
        }
        return iIntValue < 1000 ? 5 : 6;
    }

    public void a(Level level, String str) {
        switch (this.f563a) {
            case 2:
                System.out.println("[" + level + "] " + str);
                break;
            default:
                if (level != Level.OFF) {
                    Log.println(c(level), "EventBus", str);
                }
                break;
        }
    }

    public void b(Level level, String str, Throwable th) {
        switch (this.f563a) {
            case 2:
                System.out.println("[" + level + "] " + str);
                th.printStackTrace(System.out);
                break;
            default:
                if (level != Level.OFF) {
                    int iC = c(level);
                    StringBuilder sbX = AbstractC0157z.x(str, "\n");
                    sbX.append(Log.getStackTraceString(th));
                    Log.println(iC, "EventBus", sbX.toString());
                }
                break;
        }
    }

    @Override // V1.a
    public boolean e(int i5) {
        switch (this.f563a) {
            case 5:
                return i5 == 1;
            case 6:
                return i5 == 1;
            case 7:
                return i5 == 1;
            case 8:
                return i5 == 1;
            case 9:
                return i5 == 1;
            case 10:
                return i5 == 1;
            case 11:
                return i5 == 1;
            case 12:
                return i5 > 0;
            case 13:
                return i5 == 1;
            case 14:
                return i5 == 1;
            case 15:
                return i5 == 1;
            case 16:
                return i5 == 0;
            case 17:
                return i5 == 1;
            case 18:
                return i5 == 1;
            case 19:
                return i5 == 1;
            case 20:
                return i5 == 1;
            case 21:
                return i5 == 1;
            case 22:
                return i5 == 1 || i5 == 2;
            case 23:
                return i5 >= 0;
            case 24:
                return i5 >= 0;
            case 25:
                return i5 == 2;
            case 26:
                return i5 == 0;
            case 27:
                return i5 == 2;
            case 28:
                return i5 == 0;
            default:
                return i5 == 1;
        }
    }

    @Override // V1.a
    public double g(double[] dArr, int i5) {
        switch (this.f563a) {
            case 5:
                return Math.abs(dArr[0]);
            case 6:
                return Math.acos(dArr[0]);
            case 7:
                return Math.log(Math.sqrt((dArr[0] - 1.0d) / 2.0d) + Math.sqrt((dArr[0] + 1.0d) / 2.0d)) * 2.0d;
            case 8:
                return Math.asin(dArr[0]);
            case 9:
                double d = dArr[0];
                return Math.log(Math.sqrt((d * d) + 1.0d) + d);
            case 10:
                return Math.atan(dArr[0]);
            case 11:
                return (Math.log(dArr[0] + 1.0d) - Math.log(1.0d - dArr[0])) / 2.0d;
            case 12:
                double d6 = 0.0d;
                for (int i6 = 0; i6 < i5; i6++) {
                    d6 += dArr[i6];
                }
                return d6 / ((double) i5);
            case 13:
                return Math.ceil(dArr[0]);
            case 14:
                return Math.cos(dArr[0]);
            case 15:
                return (Math.pow(2.718281828459045d, -dArr[0]) + Math.pow(2.718281828459045d, dArr[0])) / 2.0d;
            case 16:
                return 2.718281828459045d;
            case 17:
                return Math.exp(dArr[0]);
            case 18:
                double d7 = 1.0d;
                for (int i7 = (int) dArr[0]; i7 > 1; i7--) {
                    d7 *= (double) i7;
                }
                return d7;
            case 19:
                return Math.floor(dArr[0]);
            case 20:
                return Math.log(dArr[0]) / Math.log(2.0d);
            case 21:
                return Math.log(dArr[0]);
            case 22:
                return i5 == 1 ? Math.log(dArr[0]) / Math.log(10.0d) : Math.log(dArr[0]) / Math.log(dArr[1]);
            case 23:
                if (i5 == 0) {
                    return Double.MAX_VALUE;
                }
                double d8 = -1.7976931348623157E308d;
                for (int i8 = 0; i8 < i5; i8++) {
                    double d9 = dArr[i8];
                    if (d9 > d8) {
                        d8 = d9;
                    }
                }
                return d8;
            case 24:
                if (i5 == 0) {
                    return Double.MIN_VALUE;
                }
                double d10 = Double.MAX_VALUE;
                for (int i9 = 0; i9 < i5; i9++) {
                    double d11 = dArr[i9];
                    if (d11 < d10) {
                        d10 = d11;
                    }
                }
                return d10;
            case 25:
                return dArr[0] % dArr[1];
            case 26:
                return 3.141592653589793d;
            case 27:
                return Math.pow(dArr[0], dArr[1]);
            case 28:
                return Math.random();
            default:
                double d12 = dArr[0];
                return (d12 >= 9.223372036854776E18d || d12 <= -9.223372036854776E18d) ? d12 : Math.round(d12);
        }
    }

    public String toString() {
        switch (this.f563a) {
            case 5:
                return "abs(x)";
            case 6:
                return "acos(x)";
            case 7:
                return "acosh(x)";
            case 8:
                return "asin(x)";
            case 9:
                return "asinh(x)";
            case 10:
                return "atan(x)";
            case 11:
                return "atanh(x)";
            case 12:
                return "avg(x1, x2, ..., xn)";
            case 13:
                return "ceil(x)";
            case 14:
                return "cos(x)";
            case 15:
                return "cosh(x)";
            case 16:
                return "e()";
            case 17:
                return "exp(x)";
            case 18:
                return "fact(n)";
            case 19:
                return "floor(x)";
            case 20:
                return "lg(x)";
            case 21:
                return "ln(x)";
            case 22:
                return "log(x):log(x, y)";
            case 23:
                return "max(x1, x2, ..., xn)";
            case 24:
                return "min(x1, x2, ..., xn)";
            case 25:
                return "mod(x, y)";
            case 26:
                return "pi()";
            case 27:
                return "pow(x, y)";
            case 28:
                return "rand()";
            case 29:
                return "round(x)";
            default:
                return super.toString();
        }
    }
}
