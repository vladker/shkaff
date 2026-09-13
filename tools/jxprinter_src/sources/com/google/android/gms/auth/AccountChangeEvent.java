package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.exifinterface.media.a;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import org.apache.commons.math3.geometry.VectorFormat;

/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class(creator = "AccountChangeEventCreator")
public class AccountChangeEvent extends AbstractSafeParcelable {
    public static final Parcelable.Creator<AccountChangeEvent> CREATOR = new zza();

    @SafeParcelable.VersionField(id = 1)
    private final int zze;

    @SafeParcelable.Field(id = 2)
    private final long zzf;

    @SafeParcelable.Field(id = 3)
    private final String zzg;

    @SafeParcelable.Field(id = 4)
    private final int zzh;

    @SafeParcelable.Field(id = 5)
    private final int zzi;

    @SafeParcelable.Field(id = 6)
    private final String zzj;

    @SafeParcelable.Constructor
    public AccountChangeEvent(@SafeParcelable.Param(id = 1) int i5, @SafeParcelable.Param(id = 2) long j6, @SafeParcelable.Param(id = 3) String str, @SafeParcelable.Param(id = 4) int i6, @SafeParcelable.Param(id = 5) int i7, @SafeParcelable.Param(id = 6) String str2) {
        this.zze = i5;
        this.zzf = j6;
        this.zzg = (String) Preconditions.checkNotNull(str);
        this.zzh = i6;
        this.zzi = i7;
        this.zzj = str2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AccountChangeEvent) {
            AccountChangeEvent accountChangeEvent = (AccountChangeEvent) obj;
            if (this.zze == accountChangeEvent.zze && this.zzf == accountChangeEvent.zzf && Objects.equal(this.zzg, accountChangeEvent.zzg) && this.zzh == accountChangeEvent.zzh && this.zzi == accountChangeEvent.zzi && Objects.equal(this.zzj, accountChangeEvent.zzj)) {
                return true;
            }
        }
        return false;
    }

    public String getAccountName() {
        return this.zzg;
    }

    public String getChangeData() {
        return this.zzj;
    }

    public int getChangeType() {
        return this.zzh;
    }

    public int getEventIndex() {
        return this.zzi;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zze), Long.valueOf(this.zzf), this.zzg, Integer.valueOf(this.zzh), Integer.valueOf(this.zzi), this.zzj);
    }

    public String toString() {
        String str;
        int i5 = this.zzh;
        if (i5 == 1) {
            str = "ADDED";
        } else if (i5 == 2) {
            str = "REMOVED";
        } else if (i5 != 3) {
            str = i5 != 4 ? "UNKNOWN" : "RENAMED_TO";
        } else {
            str = "RENAMED_FROM";
        }
        String str2 = this.zzg;
        String str3 = this.zzj;
        int i6 = this.zzi;
        StringBuilder sbU = a.u(a.b(str.length() + a.b(91, str2), str3), "AccountChangeEvent {accountName = ", str2, ", changeType = ", str);
        sbU.append(", changeData = ");
        sbU.append(str3);
        sbU.append(", eventIndex = ");
        sbU.append(i6);
        sbU.append(VectorFormat.DEFAULT_SUFFIX);
        return sbU.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i5) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zze);
        SafeParcelWriter.writeLong(parcel, 2, this.zzf);
        SafeParcelWriter.writeString(parcel, 3, this.zzg, false);
        SafeParcelWriter.writeInt(parcel, 4, this.zzh);
        SafeParcelWriter.writeInt(parcel, 5, this.zzi);
        SafeParcelWriter.writeString(parcel, 6, this.zzj, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public AccountChangeEvent(long j6, String str, int i5, int i6, String str2) {
        this.zze = 1;
        this.zzf = j6;
        this.zzg = (String) Preconditions.checkNotNull(str);
        this.zzh = i5;
        this.zzi = i6;
        this.zzj = str2;
    }
}
