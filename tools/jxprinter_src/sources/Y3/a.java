package Y3;

import A3.AbstractC0157z;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    /* JADX INFO: renamed from: getDays-UwyO8pc$annotations, reason: not valid java name */
    public static /* synthetic */ void m888getDaysUwyO8pc$annotations(double d) {
    }

    /* JADX INFO: renamed from: getHours-UwyO8pc$annotations, reason: not valid java name */
    public static /* synthetic */ void m891getHoursUwyO8pc$annotations(double d) {
    }

    /* JADX INFO: renamed from: getMicroseconds-UwyO8pc$annotations, reason: not valid java name */
    public static /* synthetic */ void m894getMicrosecondsUwyO8pc$annotations(double d) {
    }

    /* JADX INFO: renamed from: getMilliseconds-UwyO8pc$annotations, reason: not valid java name */
    public static /* synthetic */ void m897getMillisecondsUwyO8pc$annotations(double d) {
    }

    /* JADX INFO: renamed from: getMinutes-UwyO8pc$annotations, reason: not valid java name */
    public static /* synthetic */ void m900getMinutesUwyO8pc$annotations(double d) {
    }

    /* JADX INFO: renamed from: getNanoseconds-UwyO8pc$annotations, reason: not valid java name */
    public static /* synthetic */ void m903getNanosecondsUwyO8pc$annotations(double d) {
    }

    /* JADX INFO: renamed from: getSeconds-UwyO8pc$annotations, reason: not valid java name */
    public static /* synthetic */ void m906getSecondsUwyO8pc$annotations(double d) {
    }

    public final double convert(double d, e sourceUnit, e targetUnit) {
        E.f(sourceUnit, "sourceUnit");
        E.f(targetUnit, "targetUnit");
        return g.convertDurationUnit(d, sourceUnit, targetUnit);
    }

    /* JADX INFO: renamed from: parse-UwyO8pc, reason: not valid java name */
    public final long m909parseUwyO8pc(String value) {
        E.f(value, "value");
        try {
            return d.a(value, false);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(AbstractC0157z.o("Invalid duration string format: '", value, "'."), e);
        }
    }

    /* JADX INFO: renamed from: parseIsoString-UwyO8pc, reason: not valid java name */
    public final long m910parseIsoStringUwyO8pc(String value) {
        E.f(value, "value");
        try {
            return d.a(value, true);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(AbstractC0157z.o("Invalid ISO duration string format: '", value, "'."), e);
        }
    }

    /* JADX INFO: renamed from: parseIsoStringOrNull-FghU774, reason: not valid java name */
    public final b m911parseIsoStringOrNullFghU774(String value) {
        E.f(value, "value");
        try {
            return new b(d.a(value, true));
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: parseOrNull-FghU774, reason: not valid java name */
    public final b m912parseOrNullFghU774(String value) {
        E.f(value, "value");
        try {
            return new b(d.a(value, false));
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: getDays-UwyO8pc$annotations, reason: not valid java name */
    public static /* synthetic */ void m889getDaysUwyO8pc$annotations(int i5) {
    }

    /* JADX INFO: renamed from: getHours-UwyO8pc$annotations, reason: not valid java name */
    public static /* synthetic */ void m892getHoursUwyO8pc$annotations(int i5) {
    }

    /* JADX INFO: renamed from: getMicroseconds-UwyO8pc$annotations, reason: not valid java name */
    public static /* synthetic */ void m895getMicrosecondsUwyO8pc$annotations(int i5) {
    }

    /* JADX INFO: renamed from: getMilliseconds-UwyO8pc$annotations, reason: not valid java name */
    public static /* synthetic */ void m898getMillisecondsUwyO8pc$annotations(int i5) {
    }

    /* JADX INFO: renamed from: getMinutes-UwyO8pc$annotations, reason: not valid java name */
    public static /* synthetic */ void m901getMinutesUwyO8pc$annotations(int i5) {
    }

    /* JADX INFO: renamed from: getNanoseconds-UwyO8pc$annotations, reason: not valid java name */
    public static /* synthetic */ void m904getNanosecondsUwyO8pc$annotations(int i5) {
    }

    /* JADX INFO: renamed from: getSeconds-UwyO8pc$annotations, reason: not valid java name */
    public static /* synthetic */ void m907getSecondsUwyO8pc$annotations(int i5) {
    }

    /* JADX INFO: renamed from: getDays-UwyO8pc$annotations, reason: not valid java name */
    public static /* synthetic */ void m890getDaysUwyO8pc$annotations(long j6) {
    }

    /* JADX INFO: renamed from: getHours-UwyO8pc$annotations, reason: not valid java name */
    public static /* synthetic */ void m893getHoursUwyO8pc$annotations(long j6) {
    }

    /* JADX INFO: renamed from: getMicroseconds-UwyO8pc$annotations, reason: not valid java name */
    public static /* synthetic */ void m896getMicrosecondsUwyO8pc$annotations(long j6) {
    }

    /* JADX INFO: renamed from: getMilliseconds-UwyO8pc$annotations, reason: not valid java name */
    public static /* synthetic */ void m899getMillisecondsUwyO8pc$annotations(long j6) {
    }

    /* JADX INFO: renamed from: getMinutes-UwyO8pc$annotations, reason: not valid java name */
    public static /* synthetic */ void m902getMinutesUwyO8pc$annotations(long j6) {
    }

    /* JADX INFO: renamed from: getNanoseconds-UwyO8pc$annotations, reason: not valid java name */
    public static /* synthetic */ void m905getNanosecondsUwyO8pc$annotations(long j6) {
    }

    /* JADX INFO: renamed from: getSeconds-UwyO8pc$annotations, reason: not valid java name */
    public static /* synthetic */ void m908getSecondsUwyO8pc$annotations(long j6) {
    }
}
