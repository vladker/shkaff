package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zzfq implements zzge {
    private final zzfm zza;
    private final zzgs zzb;
    private final boolean zzc;
    private final zzdt zzd;

    private zzfq(zzgs zzgsVar, zzdt zzdtVar, zzfm zzfmVar) {
        this.zzb = zzgsVar;
        this.zzc = zzfmVar instanceof zzed;
        this.zzd = zzdtVar;
        this.zza = zzfmVar;
    }

    public static zzfq zzc(zzgs zzgsVar, zzdt zzdtVar, zzfm zzfmVar) {
        return new zzfq(zzgsVar, zzdtVar, zzfmVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
    public final int zza(Object obj) {
        int iZzb = ((zzeh) obj).zzc.zzb();
        return this.zzc ? iZzb + ((zzed) obj).zzb.zzb() : iZzb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
    public final int zzb(Object obj) {
        int iHashCode = ((zzeh) obj).zzc.hashCode();
        return this.zzc ? (iHashCode * 53) + ((zzed) obj).zzb.zza.hashCode() : iHashCode;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
    public final Object zze() {
        zzfm zzfmVar = this.zza;
        return zzfmVar instanceof zzeh ? ((zzeh) zzfmVar).zzK() : zzfmVar.zzZ().zzk();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
    public final void zzf(Object obj) {
        this.zzb.zza(obj);
        this.zzd.zza(obj);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
    public final void zzg(Object obj, Object obj2) {
        zzgg.zzp(this.zzb, obj, obj2);
        if (this.zzc) {
            zzgg.zzo(this.zzd, obj, obj2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:31:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:61:0x00b8 A[EDGE_INSN: B:61:0x00b8->B:33:0x00b8 BREAK  A[LOOP:1: B:17:0x0064->B:64:0x0064], SYNTHETIC] */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
    public final void zzh(Object obj, byte[] bArr, int i5, int i6, zzcu zzcuVar) throws zzer {
        int iZzj;
        zzeh zzehVar = (zzeh) obj;
        zzgt zzgtVarZzf = zzehVar.zzc;
        if (zzgtVarZzf == zzgt.zzc()) {
            zzgtVarZzf = zzgt.zzf();
            zzehVar.zzc = zzgtVarZzf;
        }
        zzgt zzgtVar = zzgtVarZzf;
        zzdx zzdxVarZzc = ((zzed) obj).zzc();
        zzef zzefVarZzb = null;
        while (i5 < i6) {
            int iZzj2 = zzcv.zzj(bArr, i5, zzcuVar);
            int i7 = zzcuVar.zza;
            if (i7 == 11) {
                int i8 = i6;
                zzcu zzcuVar2 = zzcuVar;
                int i9 = 0;
                zzdf zzdfVar = null;
                while (true) {
                    if (iZzj2 >= i8) {
                        iZzj = iZzj2;
                        break;
                    }
                    iZzj = zzcv.zzj(bArr, iZzj2, zzcuVar2);
                    int i10 = zzcuVar2.zza;
                    int i11 = i10 >>> 3;
                    int i12 = i10 & 7;
                    if (i11 == 2) {
                        if (i12 != 0) {
                            if (i10 != 12) {
                                break;
                                break;
                            }
                            iZzj2 = zzcv.zzp(i10, bArr, iZzj, i8, zzcuVar2);
                        } else {
                            iZzj2 = zzcv.zzj(bArr, iZzj, zzcuVar2);
                            i9 = zzcuVar2.zza;
                            zzefVarZzb = zzcuVar2.zzd.zzb(this.zza, i9);
                        }
                    } else {
                        if (i11 == 3) {
                            if (zzefVarZzb != null) {
                                iZzj2 = zzcv.zze(zzfu.zza().zzb(zzefVarZzb.zza.getClass()), bArr, iZzj, i8, zzcuVar2);
                                zzdxVarZzc.zzi(zzefVarZzb.zzb, zzcuVar2.zzc);
                            } else if (i12 == 2) {
                                iZzj2 = zzcv.zza(bArr, iZzj, zzcuVar2);
                                zzdfVar = (zzdf) zzcuVar2.zzc;
                            }
                        }
                        if (i10 != 12) {
                            break;
                        } else {
                            iZzj2 = zzcv.zzp(i10, bArr, iZzj, i8, zzcuVar2);
                        }
                    }
                }
                if (zzdfVar != null) {
                    zzgtVar.zzj((i9 << 3) | 2, zzdfVar);
                }
                i5 = iZzj;
                i6 = i8;
                zzcuVar = zzcuVar2;
            } else if ((i7 & 7) == 2) {
                zzefVarZzb = zzcuVar.zzd.zzb(this.zza, i7 >>> 3);
                if (zzefVarZzb != null) {
                    i5 = zzcv.zze(zzfu.zza().zzb(zzefVarZzb.zza.getClass()), bArr, iZzj2, i6, zzcuVar);
                    zzdxVarZzc.zzi(zzefVarZzb.zzb, zzcuVar.zzc);
                } else {
                    i5 = zzcv.zzi(i7, bArr, iZzj2, i6, zzgtVar, zzcuVar);
                }
            } else {
                i5 = zzcv.zzp(i7, bArr, iZzj2, i6, zzcuVar);
            }
        }
        if (i5 != i6) {
            throw new zzer("Failed to parse the message.");
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
    public final void zzi(Object obj, zzhh zzhhVar) {
        Iterator itZzf = ((zzed) obj).zzb.zzf();
        while (itZzf.hasNext()) {
            Map.Entry entry = (Map.Entry) itZzf.next();
            zzdw zzdwVar = (zzdw) entry.getKey();
            if (zzdwVar.zze() != zzhg.MESSAGE) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            zzdwVar.zzg();
            zzdwVar.zzf();
            if (entry instanceof zzeu) {
                zzhhVar.zzw(zzdwVar.zza(), ((zzeu) entry).zza().zzb());
            } else {
                zzhhVar.zzw(zzdwVar.zza(), entry.getValue());
            }
        }
        ((zzeh) obj).zzc.zzk(zzhhVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
    public final boolean zzj(Object obj, Object obj2) {
        if (!((zzeh) obj).zzc.equals(((zzeh) obj2).zzc)) {
            return false;
        }
        if (this.zzc) {
            return ((zzed) obj).zzb.equals(((zzed) obj2).zzb);
        }
        return true;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
    public final boolean zzk(Object obj) {
        return ((zzed) obj).zzb.zzk();
    }
}
