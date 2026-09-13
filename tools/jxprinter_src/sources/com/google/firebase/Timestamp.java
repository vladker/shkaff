package com.google.firebase;

import A3.AbstractC0157z;
import D3.g;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RequiresApi;
import java.time.Instant;
import java.util.Date;
import kotlin.jvm.internal.AbstractC1107v;
import kotlin.jvm.internal.E;
import kotlin.jvm.internal.L;
import org.apache.xmlbeans.SchemaType;
import p147z3.A;
import p147z3.C1938s;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class Timestamp implements Comparable<Timestamp>, Parcelable {
    private final int nanoseconds;
    private final long seconds;
    public static final Companion Companion = new Companion(null);
    public static final Parcelable.Creator<Timestamp> CREATOR = new Parcelable.Creator<Timestamp>() { // from class: com.google.firebase.Timestamp$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Timestamp createFromParcel(Parcel source) {
            E.f(source, "source");
            return new Timestamp(source.readLong(), source.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Timestamp[] newArray(int i5) {
            return new Timestamp[i5];
        }
    };

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1107v abstractC1107v) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final C1938s toPreciseTime(Date date) {
            long j6 = 1000;
            long time = date.getTime() / j6;
            int time2 = (int) ((date.getTime() % j6) * ((long) SchemaType.SIZE_BIG_INTEGER));
            return time2 < 0 ? A.to(Long.valueOf(time - 1), Integer.valueOf(time2 + 1000000000)) : A.to(Long.valueOf(time), Integer.valueOf(time2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void validateRange(long j6, int i5) {
            if (i5 < 0 || i5 >= 1000000000) {
                throw new IllegalArgumentException(AbstractC0157z.k(i5, "Timestamp nanoseconds out of range: ").toString());
            }
            if (-62135596800L > j6 || j6 >= 253402300800L) {
                throw new IllegalArgumentException(androidx.collection.a.j(j6, "Timestamp seconds out of range: ").toString());
            }
        }

        public final Timestamp now() {
            return new Timestamp(new Date());
        }

        private Companion() {
        }
    }

    public Timestamp(long j6, int i5) {
        Companion.validateRange(j6, i5);
        this.seconds = j6;
        this.nanoseconds = i5;
    }

    public static final Timestamp now() {
        return Companion.now();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof Timestamp) && compareTo((Timestamp) obj) == 0;
        }
        return true;
    }

    public final int getNanoseconds() {
        return this.nanoseconds;
    }

    public final long getSeconds() {
        return this.seconds;
    }

    public int hashCode() {
        long j6 = this.seconds;
        return (((((int) j6) * 1369) + ((int) (j6 >> 32))) * 37) + this.nanoseconds;
    }

    public final Date toDate() {
        return new Date((this.seconds * ((long) 1000)) + ((long) (this.nanoseconds / SchemaType.SIZE_BIG_INTEGER)));
    }

    @RequiresApi(26)
    public final Instant toInstant() {
        Instant instantOfEpochSecond = Instant.ofEpochSecond(this.seconds, this.nanoseconds);
        E.e(instantOfEpochSecond, "ofEpochSecond(...)");
        return instantOfEpochSecond;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Timestamp(seconds=");
        sb.append(this.seconds);
        sb.append(", nanoseconds=");
        return AbstractC0157z.p(sb, this.nanoseconds, ')');
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int i5) {
        E.f(dest, "dest");
        dest.writeLong(this.seconds);
        dest.writeInt(this.nanoseconds);
    }

    @Override // java.lang.Comparable
    public int compareTo(Timestamp other) {
        E.f(other, "other");
        return g.compareValuesBy(this, other, new L() { // from class: com.google.firebase.Timestamp.compareTo.1
            @Override // kotlin.jvm.internal.L, V3.l
            public Object get(Object obj) {
                return Long.valueOf(((Timestamp) obj).getSeconds());
            }
        }, new L() { // from class: com.google.firebase.Timestamp.compareTo.2
            @Override // kotlin.jvm.internal.L, V3.l
            public Object get(Object obj) {
                return Integer.valueOf(((Timestamp) obj).getNanoseconds());
            }
        });
    }

    public Timestamp(Date date) {
        E.f(date, "date");
        Companion companion = Companion;
        C1938s preciseTime = companion.toPreciseTime(date);
        long jLongValue = ((Number) preciseTime.f9134a).longValue();
        int iIntValue = ((Number) preciseTime.b).intValue();
        companion.validateRange(jLongValue, iIntValue);
        this.seconds = jLongValue;
        this.nanoseconds = iIntValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @RequiresApi(26)
    public Timestamp(Instant time) {
        this(time.getEpochSecond(), time.getNano());
        E.f(time, "time");
    }
}
