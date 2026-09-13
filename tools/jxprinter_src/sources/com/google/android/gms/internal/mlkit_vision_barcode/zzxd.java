package com.google.android.gms.internal.mlkit_vision_barcode;

import org.apache.poi.hssf.record.DimensionsRecord;
import org.apache.poi.hssf.record.pivottable.ExtendedPivotTableViewFieldsRecord;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zzxd extends zzxl {
    private int zza;
    private int zzb;
    private float zzc;
    private float zzd;
    private boolean zze;
    private float zzf;
    private float zzg;
    private long zzh;
    private long zzi;
    private boolean zzj;
    private float zzk;
    private float zzl;
    private short zzm;

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzxl
    public final zzxl zza(boolean z6) {
        this.zzj = true;
        this.zzm = (short) (this.zzm | DimensionsRecord.sid);
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzxl
    public final zzxl zzb(float f6) {
        this.zzg = 0.8f;
        this.zzm = (short) (this.zzm | 64);
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzxl
    public final zzxl zzc(float f6) {
        this.zzf = 0.5f;
        this.zzm = (short) (this.zzm | 32);
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzxl
    public final zzxl zzd(float f6) {
        this.zzd = 0.8f;
        this.zzm = (short) (this.zzm | 8);
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzxl
    public final zzxl zze(int i5) {
        this.zzb = 5;
        this.zzm = (short) (this.zzm | 2);
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzxl
    public final zzxl zzf(float f6) {
        this.zzc = 0.25f;
        this.zzm = (short) (this.zzm | 4);
        return this;
    }

    public final zzxl zzg(int i5) {
        this.zza = 10;
        this.zzm = (short) (this.zzm | 1);
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzxl
    public final zzxl zzh(long j6) {
        this.zzi = 3000L;
        this.zzm = (short) (this.zzm | ExtendedPivotTableViewFieldsRecord.sid);
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzxl
    public final zzxl zzi(boolean z6) {
        this.zze = z6;
        this.zzm = (short) (this.zzm | 16);
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzxl
    public final zzxl zzj(float f6) {
        this.zzk = 0.1f;
        this.zzm = (short) (this.zzm | 1024);
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzxl
    public final zzxl zzk(long j6) {
        this.zzh = 1500L;
        this.zzm = (short) (this.zzm | 128);
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzxl
    public final zzxl zzl(float f6) {
        this.zzl = 0.05f;
        this.zzm = (short) (this.zzm | 2048);
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzxl
    public final zzxm zzm() {
        if (this.zzm == 4095) {
            return new zzxf(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, null);
        }
        StringBuilder sb = new StringBuilder();
        if ((this.zzm & 1) == 0) {
            sb.append(" recentFramesToCheck");
        }
        if ((this.zzm & 2) == 0) {
            sb.append(" recentFramesContainingPredictedArea");
        }
        if ((this.zzm & 4) == 0) {
            sb.append(" recentFramesIou");
        }
        if ((this.zzm & 8) == 0) {
            sb.append(" maxCoverage");
        }
        if ((this.zzm & 16) == 0) {
            sb.append(" useConfidenceScore");
        }
        if ((this.zzm & 32) == 0) {
            sb.append(" lowerConfidenceScore");
        }
        if ((this.zzm & 64) == 0) {
            sb.append(" higherConfidenceScore");
        }
        if ((this.zzm & 128) == 0) {
            sb.append(" zoomIntervalInMillis");
        }
        if ((this.zzm & ExtendedPivotTableViewFieldsRecord.sid) == 0) {
            sb.append(" resetIntervalInMillis");
        }
        if ((this.zzm & DimensionsRecord.sid) == 0) {
            sb.append(" enableZoomThreshold");
        }
        if ((this.zzm & 1024) == 0) {
            sb.append(" zoomInThreshold");
        }
        if ((this.zzm & 2048) == 0) {
            sb.append(" zoomOutThreshold");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }
}
