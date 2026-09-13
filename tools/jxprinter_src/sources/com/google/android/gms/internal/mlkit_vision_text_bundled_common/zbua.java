package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class zbua extends zbtz implements zbvn {
    public zbua(zbub zbubVar) {
        super(zbubVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbtz, com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvl
    /* JADX INFO: renamed from: zbd, reason: merged with bridge method [inline-methods] */
    public final zbub zbl() {
        if (!((zbub) this.zba).zbG()) {
            return (zbub) this.zba;
        }
        ((zbub) this.zba).zbb.zbh();
        return (zbub) super.zbl();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbtz
    public final void zbo() {
        super.zbo();
        if (((zbub) this.zba).zbb != zbtu.zbe()) {
            zbub zbubVar = (zbub) this.zba;
            zbubVar.zbb = zbubVar.zbb.clone();
        }
    }
}
