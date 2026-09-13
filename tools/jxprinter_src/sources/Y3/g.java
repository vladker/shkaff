package Y3;

import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.E;
import p147z3.C1937q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class g {
    public static final double convertDurationUnit(double d, e sourceUnit, e targetUnit) {
        E.f(sourceUnit, "sourceUnit");
        E.f(targetUnit, "targetUnit");
        long jConvert = targetUnit.getTimeUnit$kotlin_stdlib().convert(1L, sourceUnit.getTimeUnit$kotlin_stdlib());
        return jConvert > 0 ? d * jConvert : d / sourceUnit.getTimeUnit$kotlin_stdlib().convert(1L, targetUnit.getTimeUnit$kotlin_stdlib());
    }

    public static final long convertDurationUnitOverflow(long j6, e sourceUnit, e targetUnit) {
        E.f(sourceUnit, "sourceUnit");
        E.f(targetUnit, "targetUnit");
        return targetUnit.getTimeUnit$kotlin_stdlib().convert(j6, sourceUnit.getTimeUnit$kotlin_stdlib());
    }

    public static final e toDurationUnit(TimeUnit timeUnit) {
        E.f(timeUnit, "<this>");
        switch (f.f880a[timeUnit.ordinal()]) {
            case 1:
                return e.NANOSECONDS;
            case 2:
                return e.MICROSECONDS;
            case 3:
                return e.MILLISECONDS;
            case 4:
                return e.SECONDS;
            case 5:
                return e.MINUTES;
            case 6:
                return e.HOURS;
            case 7:
                return e.DAYS;
            default:
                throw new C1937q();
        }
    }

    public static final TimeUnit toTimeUnit(e eVar) {
        E.f(eVar, "<this>");
        return eVar.getTimeUnit$kotlin_stdlib();
    }

    public static final long convertDurationUnit(long j6, e sourceUnit, e targetUnit) {
        E.f(sourceUnit, "sourceUnit");
        E.f(targetUnit, "targetUnit");
        return targetUnit.getTimeUnit$kotlin_stdlib().convert(j6, sourceUnit.getTimeUnit$kotlin_stdlib());
    }
}
