package cn.fly.commons.cc;

import androidx.core.location.LocationRequestCompat;
import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import org.apache.poi.ss.usermodel.Font;

/* JADX INFO: loaded from: classes.dex */
public class aa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f1369a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Number f1370a;
        private Number b;
        private Number c;
        private Number d;
        private boolean e;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v23 */
        /* JADX WARN: Type inference failed for: r2v24, types: [java.lang.Number] */
        /* JADX WARN: Type inference failed for: r2v27 */
        /* JADX WARN: Type inference failed for: r2v28 */
        /* JADX WARN: Type inference failed for: r2v29 */
        /* JADX WARN: Type inference failed for: r2v30 */
        /* JADX WARN: Type inference failed for: r2v31 */
        /* JADX WARN: Type inference failed for: r2v32 */
        /* JADX WARN: Type inference failed for: r2v33 */
        public a(Number number, Number number2, Number number3) {
            char c;
            ?? ValueOf;
            Number numberValueOf;
            Number number4;
            Number[] numberArr = {number, number2, number3};
            int[] iArr = new int[3];
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            for (int i5 = 0; i5 < 3; i5++) {
                Number number5 = numberArr[i5];
                if (number5 != null) {
                    if (number5 instanceof Byte) {
                        iArr[i5] = 1;
                    } else if (number5 instanceof Short) {
                        iArr[i5] = 2;
                    } else if (number5 instanceof Integer) {
                        iArr[i5] = 3;
                    } else if (number5 instanceof Long) {
                        iArr[i5] = 4;
                    } else if (number5 instanceof Float) {
                        iArr[i5] = 5;
                    } else if (number5 instanceof Double) {
                        iArr[i5] = 6;
                    }
                }
            }
            int i6 = 0;
            for (int i7 = 0; i7 < 3; i7++) {
                int i8 = iArr[i7];
                if (i6 < i8) {
                    i6 = i8;
                }
            }
            if (number != null) {
                c = 3;
                switch (i6) {
                    case 1:
                        ValueOf = Byte.valueOf(Double.valueOf(String.valueOf(number)).byteValue());
                        break;
                    case 2:
                        ValueOf = Short.valueOf(Double.valueOf(String.valueOf(number)).shortValue());
                        break;
                    case 3:
                        ValueOf = Integer.valueOf(Double.valueOf(String.valueOf(number)).intValue());
                        break;
                    case 4:
                        ValueOf = Long.valueOf(Double.valueOf(String.valueOf(number)).longValue());
                        break;
                    case 5:
                        ValueOf = Float.valueOf(Double.valueOf(String.valueOf(number)).floatValue());
                        break;
                    case 6:
                        ValueOf = Double.valueOf(String.valueOf(number));
                        break;
                    default:
                        ValueOf = number;
                        break;
                }
            } else {
                c = 3;
                number4 = new Number[]{Integer.MIN_VALUE, Byte.valueOf(UnsignedBytes.MAX_POWER_OF_TWO), Short.MIN_VALUE, Integer.MIN_VALUE, Long.MIN_VALUE, Float.valueOf(Float.MIN_VALUE), Double.valueOf(Double.MIN_VALUE)}[i6];
            }
            if (number2 != null) {
                switch (i6) {
                    case 1:
                        numberValueOf = Byte.valueOf(Double.valueOf(String.valueOf(number2)).byteValue());
                        break;
                    case 2:
                        numberValueOf = Short.valueOf(Double.valueOf(String.valueOf(number2)).shortValue());
                        break;
                    case 3:
                        numberValueOf = Integer.valueOf(Double.valueOf(String.valueOf(number2)).intValue());
                        break;
                    case 4:
                        numberValueOf = Long.valueOf(Double.valueOf(String.valueOf(number2)).longValue());
                        break;
                    case 5:
                        numberValueOf = Float.valueOf(Double.valueOf(String.valueOf(number2)).floatValue());
                        break;
                    case 6:
                        numberValueOf = Double.valueOf(String.valueOf(number2));
                        break;
                    default:
                        numberValueOf = number2;
                        break;
                }
            } else {
                ValueOf = number4;
                Byte bValueOf = Byte.valueOf(Ascii.DEL);
                Short shValueOf = Short.valueOf(Font.COLOR_NORMAL);
                Long lValueOf = Long.valueOf(LocationRequestCompat.PASSIVE_INTERVAL);
                Float fValueOf = Float.valueOf(Float.MAX_VALUE);
                Double dValueOf = Double.valueOf(Double.MAX_VALUE);
                Number[] numberArr2 = new Number[7];
                numberArr2[0] = Integer.MAX_VALUE;
                numberArr2[1] = bValueOf;
                numberArr2[2] = shValueOf;
                numberArr2[c] = Integer.MAX_VALUE;
                numberArr2[4] = lValueOf;
                numberArr2[5] = fValueOf;
                numberArr2[6] = dValueOf;
                numberValueOf = numberArr2[i6];
            }
            this.f1370a = ValueOf;
            this.b = numberValueOf;
            this.c = number3;
            boolean z6 = ((Comparable) ValueOf).compareTo(numberValueOf) > 0;
            this.e = z6;
            if (this.c == null) {
                this.c = Integer.valueOf(z6 ? -1 : 1);
            }
        }

        public boolean a() {
            Object obj = this.d;
            if (obj == null) {
                obj = this.f1370a;
            }
            if (this.e) {
                return ((Comparable) obj).compareTo(this.b) >= 0;
            }
            return ((Comparable) obj).compareTo(this.b) <= 0;
        }

        public Number b() {
            if (this.d == null) {
                this.d = this.f1370a;
            }
            Number number = this.d;
            Number number2 = this.c;
            if (number2 instanceof Double) {
                this.d = Double.valueOf(this.c.doubleValue() + number.doubleValue());
                return number;
            }
            if (number2 instanceof Float) {
                this.d = Float.valueOf(this.c.floatValue() + number.floatValue());
                return number;
            }
            if (number2 instanceof Long) {
                this.d = Long.valueOf(this.c.longValue() + number.longValue());
                return number;
            }
            if (number2 instanceof Integer) {
                this.d = Integer.valueOf(this.c.intValue() + number.intValue());
                return number;
            }
            if (number2 instanceof Short) {
                this.d = Integer.valueOf(this.c.shortValue() + number.shortValue());
                return number;
            }
            this.d = Integer.valueOf(this.c.byteValue() + number.byteValue());
            return number;
        }
    }

    public aa(Number number, Number number2, Number number3) {
        this.f1369a = new a(number, number2, number3);
    }

    public a a() {
        return this.f1369a;
    }

    public boolean b(Number number) {
        return a(number);
    }

    public boolean a(Number number) {
        return ((Comparable) this.f1369a.f1370a).compareTo(number) <= 0 && ((Comparable) this.f1369a.b).compareTo(number) >= 0;
    }

    public Number[] b() {
        return new Number[]{this.f1369a.f1370a, this.f1369a.b};
    }
}
