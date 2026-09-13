package com.google.android.gms.internal.play_billing;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import org.apache.poi.util.CodePageUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzap extends zzau implements zzar {
    public zzap(IBinder iBinder) {
        super(iBinder, "com.android.vending.billing.IInAppBillingService");
    }

    @Override // com.google.android.gms.internal.play_billing.zzar
    public final int zza(int i5, String str, String str2) {
        Parcel parcelZzu = zzu();
        parcelZzu.writeInt(3);
        parcelZzu.writeString(str);
        parcelZzu.writeString(str2);
        Parcel parcelZzv = zzv(5, parcelZzu);
        int i6 = parcelZzv.readInt();
        parcelZzv.recycle();
        return i6;
    }

    @Override // com.google.android.gms.internal.play_billing.zzar
    public final int zzb(int i5, String str, String str2) {
        Parcel parcelZzu = zzu();
        parcelZzu.writeInt(i5);
        parcelZzu.writeString(str);
        parcelZzu.writeString(str2);
        Parcel parcelZzv = zzv(1, parcelZzu);
        int i6 = parcelZzv.readInt();
        parcelZzv.recycle();
        return i6;
    }

    @Override // com.google.android.gms.internal.play_billing.zzar
    public final int zzc(int i5, String str, String str2, Bundle bundle) {
        Parcel parcelZzu = zzu();
        parcelZzu.writeInt(i5);
        parcelZzu.writeString(str);
        parcelZzu.writeString(str2);
        zzaw.zzb(parcelZzu, bundle);
        Parcel parcelZzv = zzv(10, parcelZzu);
        int i6 = parcelZzv.readInt();
        parcelZzv.recycle();
        return i6;
    }

    @Override // com.google.android.gms.internal.play_billing.zzar
    public final Bundle zzd(int i5, String str, String str2, Bundle bundle) {
        Parcel parcelZzu = zzu();
        parcelZzu.writeInt(9);
        parcelZzu.writeString(str);
        parcelZzu.writeString(str2);
        zzaw.zzb(parcelZzu, bundle);
        Parcel parcelZzv = zzv(TypedValues.Custom.TYPE_COLOR, parcelZzu);
        Bundle bundle2 = (Bundle) zzaw.zza(parcelZzv, Bundle.CREATOR);
        parcelZzv.recycle();
        return bundle2;
    }

    @Override // com.google.android.gms.internal.play_billing.zzar
    public final Bundle zze(int i5, String str, String str2, Bundle bundle) {
        Parcel parcelZzu = zzu();
        parcelZzu.writeInt(9);
        parcelZzu.writeString(str);
        parcelZzu.writeString(str2);
        zzaw.zzb(parcelZzu, bundle);
        Parcel parcelZzv = zzv(12, parcelZzu);
        Bundle bundle2 = (Bundle) zzaw.zza(parcelZzv, Bundle.CREATOR);
        parcelZzv.recycle();
        return bundle2;
    }

    @Override // com.google.android.gms.internal.play_billing.zzar
    public final Bundle zzf(int i5, String str, String str2, String str3, String str4) {
        Parcel parcelZzu = zzu();
        parcelZzu.writeInt(3);
        parcelZzu.writeString(str);
        parcelZzu.writeString(str2);
        parcelZzu.writeString(str3);
        parcelZzu.writeString(null);
        Parcel parcelZzv = zzv(3, parcelZzu);
        Bundle bundle = (Bundle) zzaw.zza(parcelZzv, Bundle.CREATOR);
        parcelZzv.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.play_billing.zzar
    public final Bundle zzg(int i5, String str, String str2, String str3, String str4, Bundle bundle) {
        Parcel parcelZzu = zzu();
        parcelZzu.writeInt(i5);
        parcelZzu.writeString(str);
        parcelZzu.writeString(str2);
        parcelZzu.writeString(str3);
        parcelZzu.writeString(null);
        zzaw.zzb(parcelZzu, bundle);
        Parcel parcelZzv = zzv(8, parcelZzu);
        Bundle bundle2 = (Bundle) zzaw.zza(parcelZzv, Bundle.CREATOR);
        parcelZzv.recycle();
        return bundle2;
    }

    @Override // com.google.android.gms.internal.play_billing.zzar
    public final Bundle zzh(int i5, String str, String str2, String str3) {
        Parcel parcelZzu = zzu();
        parcelZzu.writeInt(3);
        parcelZzu.writeString(str);
        parcelZzu.writeString(str2);
        parcelZzu.writeString(str3);
        Parcel parcelZzv = zzv(4, parcelZzu);
        Bundle bundle = (Bundle) zzaw.zza(parcelZzv, Bundle.CREATOR);
        parcelZzv.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.play_billing.zzar
    public final Bundle zzi(int i5, String str, String str2, String str3, Bundle bundle) {
        Parcel parcelZzu = zzu();
        parcelZzu.writeInt(i5);
        parcelZzu.writeString(str);
        parcelZzu.writeString(str2);
        parcelZzu.writeString(str3);
        zzaw.zzb(parcelZzu, bundle);
        Parcel parcelZzv = zzv(11, parcelZzu);
        Bundle bundle2 = (Bundle) zzaw.zza(parcelZzv, Bundle.CREATOR);
        parcelZzv.recycle();
        return bundle2;
    }

    @Override // com.google.android.gms.internal.play_billing.zzar
    public final Bundle zzj(int i5, String str, String str2, Bundle bundle, Bundle bundle2) {
        Parcel parcelZzu = zzu();
        parcelZzu.writeInt(i5);
        parcelZzu.writeString(str);
        parcelZzu.writeString(str2);
        zzaw.zzb(parcelZzu, bundle);
        zzaw.zzb(parcelZzu, bundle2);
        Parcel parcelZzv = zzv(TypedValues.Custom.TYPE_FLOAT, parcelZzu);
        Bundle bundle3 = (Bundle) zzaw.zza(parcelZzv, Bundle.CREATOR);
        parcelZzv.recycle();
        return bundle3;
    }

    @Override // com.google.android.gms.internal.play_billing.zzar
    public final void zzk(int i5, String str, Bundle bundle, zzx zzxVar) {
        Parcel parcelZzu = zzu();
        parcelZzu.writeInt(21);
        parcelZzu.writeString(str);
        zzaw.zzb(parcelZzu, bundle);
        zzaw.zzc(parcelZzu, zzxVar);
        zzx(1501, parcelZzu);
    }

    @Override // com.google.android.gms.internal.play_billing.zzar
    public final void zzl(int i5, String str, Bundle bundle, zzz zzzVar) {
        Parcel parcelZzu = zzu();
        parcelZzu.writeInt(22);
        parcelZzu.writeString(str);
        zzaw.zzb(parcelZzu, bundle);
        zzaw.zzc(parcelZzu, zzzVar);
        zzx(1801, parcelZzu);
    }

    @Override // com.google.android.gms.internal.play_billing.zzar
    public final void zzm(Bundle bundle, zzac zzacVar) {
        Parcel parcelZzu = zzu();
        zzaw.zzb(parcelZzu, bundle);
        zzaw.zzc(parcelZzu, zzacVar);
        zzx(2001, parcelZzu);
    }

    @Override // com.google.android.gms.internal.play_billing.zzar
    public final void zzn(int i5, String str, Bundle bundle, zzae zzaeVar) {
        Parcel parcelZzu = zzu();
        parcelZzu.writeInt(i5);
        parcelZzu.writeString(str);
        zzaw.zzb(parcelZzu, bundle);
        zzaw.zzc(parcelZzu, zzaeVar);
        zzx(1601, parcelZzu);
    }

    @Override // com.google.android.gms.internal.play_billing.zzar
    public final void zzo(int i5, String str, Bundle bundle, zzag zzagVar) {
        Parcel parcelZzu = zzu();
        parcelZzu.writeInt(18);
        parcelZzu.writeString(str);
        zzaw.zzb(parcelZzu, bundle);
        zzaw.zzc(parcelZzu, zzagVar);
        zzw(1301, parcelZzu);
    }

    @Override // com.google.android.gms.internal.play_billing.zzar
    public final void zzp(int i5, String str, Bundle bundle, zzai zzaiVar) {
        Parcel parcelZzu = zzu();
        parcelZzu.writeInt(i5);
        parcelZzu.writeString(str);
        zzaw.zzb(parcelZzu, bundle);
        zzaw.zzc(parcelZzu, zzaiVar);
        zzx(1901, parcelZzu);
    }

    @Override // com.google.android.gms.internal.play_billing.zzar
    public final void zzq(int i5, String str, Bundle bundle, zzak zzakVar) {
        Parcel parcelZzu = zzu();
        parcelZzu.writeInt(25);
        parcelZzu.writeString(str);
        zzaw.zzb(parcelZzu, bundle);
        zzaw.zzc(parcelZzu, zzakVar);
        zzx(2101, parcelZzu);
    }

    @Override // com.google.android.gms.internal.play_billing.zzar
    public final void zzr(int i5, String str, Bundle bundle, zzam zzamVar) {
        Parcel parcelZzu = zzu();
        parcelZzu.writeInt(21);
        parcelZzu.writeString(str);
        zzaw.zzb(parcelZzu, bundle);
        zzaw.zzc(parcelZzu, zzamVar);
        zzx(1401, parcelZzu);
    }

    @Override // com.google.android.gms.internal.play_billing.zzar
    public final void zzs(int i5, String str, Bundle bundle, zzao zzaoVar) {
        Parcel parcelZzu = zzu();
        parcelZzu.writeInt(24);
        parcelZzu.writeString(str);
        zzaw.zzb(parcelZzu, bundle);
        zzaw.zzc(parcelZzu, zzaoVar);
        zzx(1701, parcelZzu);
    }

    @Override // com.google.android.gms.internal.play_billing.zzar
    public final void zzt(int i5, String str, Bundle bundle, zzat zzatVar) {
        Parcel parcelZzu = zzu();
        parcelZzu.writeInt(12);
        parcelZzu.writeString(str);
        zzaw.zzb(parcelZzu, bundle);
        zzaw.zzc(parcelZzu, zzatVar);
        zzw(CodePageUtil.CP_UTF16_BE, parcelZzu);
    }
}
