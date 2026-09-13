package org.apache.logging.log4j.util;

import java.io.Serializable;
import java.text.DecimalFormat;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Timer implements Serializable, StringBuilderFormattable {
    private static long NANO_PER_HOUR = 0;
    private static long NANO_PER_MINUTE = 0;
    private static long NANO_PER_SECOND = 1000000000;
    private static final long serialVersionUID = 9175191792439630013L;
    private long elapsedTime;
    private final int iterations;
    private final String name;
    private ThreadLocal<Long> startTime;
    private Status status;

    /* JADX INFO: renamed from: org.apache.logging.log4j.util.Timer$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$logging$log4j$util$Timer$Status;

        static {
            int[] iArr = new int[Status.values().length];
            $SwitchMap$org$apache$logging$log4j$util$Timer$Status = iArr;
            try {
                iArr[Status.Started.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$logging$log4j$util$Timer$Status[Status.Paused.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$logging$log4j$util$Timer$Status[Status.Stopped.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum Status {
        Started,
        Stopped,
        Paused
    }

    static {
        long j6 = 1000000000 * 60;
        NANO_PER_MINUTE = j6;
        NANO_PER_HOUR = j6 * 60;
    }

    public Timer(String str) {
        this(str, 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Timer)) {
            return false;
        }
        Timer timer = (Timer) obj;
        if (this.elapsedTime != timer.elapsedTime || this.startTime != timer.startTime) {
            return false;
        }
        String str = this.name;
        if (str == null ? timer.name != null : !str.equals(timer.name)) {
            return false;
        }
        Status status = this.status;
        Status status2 = timer.status;
        return status == null ? status2 == null : status.equals(status2);
    }

    @Override // org.apache.logging.log4j.util.StringBuilderFormattable
    public void formatTo(StringBuilder sb) {
        sb.append("Timer ");
        sb.append(this.name);
        int i5 = AnonymousClass2.$SwitchMap$org$apache$logging$log4j$util$Timer$Status[this.status.ordinal()];
        if (i5 == 1) {
            sb.append(" started");
            return;
        }
        if (i5 == 2) {
            sb.append(" paused");
            return;
        }
        if (i5 != 3) {
            sb.append(Chars.SPACE);
            sb.append(this.status);
            return;
        }
        long j6 = this.elapsedTime;
        long j7 = NANO_PER_HOUR;
        long j8 = j6 / j7;
        long j9 = j6 % j7;
        long j10 = NANO_PER_MINUTE;
        long j11 = j9 / j10;
        long j12 = j9 % j10;
        long j13 = NANO_PER_SECOND;
        long j14 = j12 / j13;
        long j15 = j12 % j13;
        String strK = j8 > 0 ? androidx.exifinterface.media.a.k("", j8, " hours ") : "";
        if (j11 > 0 || j8 > 0) {
            strK = strK + j11 + " minutes ";
        }
        DecimalFormat decimalFormat = new DecimalFormat("#0");
        StringBuilder sbR = androidx.collection.a.r(strK);
        sbR.append(decimalFormat.format(j14));
        sbR.append('.');
        String string = sbR.toString();
        DecimalFormat decimalFormat2 = new DecimalFormat("000000000");
        StringBuilder sbR2 = androidx.collection.a.r(string);
        sbR2.append(decimalFormat2.format(j15));
        sbR2.append(" seconds");
        String string2 = sbR2.toString();
        sb.append(" stopped. Elapsed time: ");
        sb.append(string2);
        int i6 = this.iterations;
        if (i6 > 0) {
            long j16 = this.elapsedTime / ((long) i6);
            long j17 = NANO_PER_HOUR;
            long j18 = j16 / j17;
            long j19 = j16 % j17;
            long j20 = NANO_PER_MINUTE;
            long j21 = j19 / j20;
            long j22 = j19 % j20;
            long j23 = NANO_PER_SECOND;
            long j24 = j22 / j23;
            long j25 = j22 % j23;
            String strK2 = j18 > 0 ? androidx.exifinterface.media.a.k("", j18, " hours ") : "";
            if (j21 > 0 || j18 > 0) {
                strK2 = strK2 + j21 + " minutes ";
            }
            DecimalFormat decimalFormat3 = new DecimalFormat("#0");
            StringBuilder sbR3 = androidx.collection.a.r(strK2);
            sbR3.append(decimalFormat3.format(j24));
            sbR3.append('.');
            String string3 = sbR3.toString();
            DecimalFormat decimalFormat4 = new DecimalFormat("000000000");
            StringBuilder sbR4 = androidx.collection.a.r(string3);
            sbR4.append(decimalFormat4.format(j25));
            sbR4.append(" seconds");
            String string4 = sbR4.toString();
            sb.append(" Average per iteration: ");
            sb.append(string4);
        }
    }

    public long getElapsedNanoTime() {
        return this.elapsedTime;
    }

    public long getElapsedTime() {
        return this.elapsedTime / 1000000;
    }

    public String getName() {
        return this.name;
    }

    public Status getStatus() {
        return this.status;
    }

    public int hashCode() {
        String str = this.name;
        int iHashCode = (str != null ? str.hashCode() : 0) * 29;
        Status status = this.status;
        int iHashCode2 = iHashCode + (status != null ? status.hashCode() : 0);
        long jLongValue = this.startTime.get().longValue();
        int i5 = ((iHashCode2 * 29) + ((int) (jLongValue ^ (jLongValue >>> 32)))) * 29;
        long j6 = this.elapsedTime;
        return i5 + ((int) (j6 ^ (j6 >>> 32)));
    }

    public synchronized void pause() {
        this.elapsedTime = (System.nanoTime() - this.startTime.get().longValue()) + this.elapsedTime;
        this.startTime.set(0L);
        this.status = Status.Paused;
    }

    public synchronized void resume() {
        this.startTime.set(Long.valueOf(System.nanoTime()));
        this.status = Status.Started;
    }

    public synchronized void start() {
        this.startTime.set(Long.valueOf(System.nanoTime()));
        this.elapsedTime = 0L;
        this.status = Status.Started;
    }

    public synchronized void startOrResume() {
        try {
            if (this.status == Status.Stopped) {
                start();
            } else {
                resume();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized String stop() {
        this.elapsedTime = (System.nanoTime() - this.startTime.get().longValue()) + this.elapsedTime;
        this.startTime.set(0L);
        this.status = Status.Stopped;
        return toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        formatTo(sb);
        return sb.toString();
    }

    public Timer(String str, int i5) {
        this.startTime = new ThreadLocal<Long>() { // from class: org.apache.logging.log4j.util.Timer.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.lang.ThreadLocal
            public Long initialValue() {
                return 0L;
            }
        };
        this.name = str;
        this.status = Status.Stopped;
        this.iterations = i5 <= 0 ? 0 : i5;
    }
}
