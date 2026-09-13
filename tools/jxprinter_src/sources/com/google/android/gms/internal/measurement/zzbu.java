package com.google.android.gms.internal.measurement;

import androidx.exifinterface.media.a;
import kotlinx.serialization.json.internal.AbstractC1127c;
import org.apache.commons.math3.geometry.VectorFormat;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbu extends zzca {
    private final String zzc;
    private final int zzd;
    private final int zze;

    public /* synthetic */ zzbu(String str, boolean z6, int i5, zzbr zzbrVar, zzbs zzbsVar, int i6, byte[] bArr) {
        this.zzc = str;
        this.zzd = i5;
        this.zze = i6;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzca) {
            zzca zzcaVar = (zzca) obj;
            if (this.zzc.equals(zzcaVar.zza())) {
                zzcaVar.zzb();
                int i5 = this.zzd;
                int iZze = zzcaVar.zze();
                if (i5 == 0) {
                    throw null;
                }
                if (i5 == iZze) {
                    zzcaVar.zzc();
                    zzcaVar.zzd();
                    int i6 = this.zze;
                    int iZzf = zzcaVar.zzf();
                    if (i6 == 0) {
                        throw null;
                    }
                    if (iZzf == 1) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.zzc.hashCode() ^ 1000003;
        int i5 = this.zzd;
        if (i5 == 0) {
            throw null;
        }
        int i6 = (((iHashCode * 1000003) ^ 1237) * 1000003) ^ i5;
        if (this.zze != 0) {
            return (i6 * 583896283) ^ 1;
        }
        throw null;
    }

    public final String toString() {
        String str;
        int i5 = this.zzd;
        String str2 = AbstractC1127c.NULL;
        if (i5 == 1) {
            str = "ALL_CHECKS";
        } else if (i5 == 2) {
            str = "SKIP_COMPLIANCE_CHECK";
        } else if (i5 != 3) {
            str = i5 != 4 ? AbstractC1127c.NULL : "NO_CHECKS";
        } else {
            str = "SKIP_SECURITY_CHECK";
        }
        if (this.zze == 1) {
            str2 = "READ_AND_WRITE";
        }
        String str3 = this.zzc;
        StringBuilder sb = new StringBuilder(str2.length() + str.length() + a.b(73, str3) + 91 + 1);
        androidx.collection.a.y(sb, "FileComplianceOptions{fileOwner=", str3, ", hasDifferentDmaOwner=false, fileChecks=", str);
        return a.r(sb, ", dataForwardingNotAllowedResolver=null, multipleProductIdGroupsResolver=null, filePurpose=", str2, VectorFormat.DEFAULT_SUFFIX);
    }

    @Override // com.google.android.gms.internal.measurement.zzca
    public final String zza() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.measurement.zzca
    public final boolean zzb() {
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.zzca
    public final zzbr zzc() {
        return null;
    }

    @Override // com.google.android.gms.internal.measurement.zzca
    public final zzbs zzd() {
        return null;
    }

    @Override // com.google.android.gms.internal.measurement.zzca
    public final int zze() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.measurement.zzca
    public final int zzf() {
        return this.zze;
    }
}
