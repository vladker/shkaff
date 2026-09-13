package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbtz;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class zbtz<MessageType extends zbuf<MessageType, BuilderType>, BuilderType extends zbtz<MessageType, BuilderType>> extends zbsi<MessageType, BuilderType> {
    protected zbuf zba;
    private final zbuf zbb;

    public zbtz(MessageType messagetype) {
        this.zbb = messagetype;
        if (messagetype.zbG()) {
            throw new IllegalArgumentException("Default instance must be immutable.");
        }
        this.zba = messagetype.zbt();
    }

    private static void zba(Object obj, Object obj2) {
        zbvu.zba().zbb(obj.getClass()).zbg(obj, obj2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbsi
    /* JADX INFO: renamed from: zbg, reason: merged with bridge method [inline-methods] */
    public final zbtz clone() {
        zbtz zbtzVar = (zbtz) this.zbb.zbb(5, null, null);
        zbtzVar.zba = zbl();
        return zbtzVar;
    }

    public final zbtz zbh(zbuf zbufVar) {
        if (!this.zbb.equals(zbufVar)) {
            if (!this.zba.zbG()) {
                zbo();
            }
            zba(this.zba, zbufVar);
        }
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvl
    /* JADX INFO: renamed from: zbi, reason: merged with bridge method [inline-methods] */
    public final MessageType zbk() {
        MessageType messagetype = (MessageType) zbl();
        if (zbuf.zbF(messagetype, true)) {
            return messagetype;
        }
        throw new zbwk(messagetype);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvl
    /* JADX INFO: renamed from: zbj, reason: merged with bridge method [inline-methods] */
    public MessageType zbl() {
        if (!this.zba.zbG()) {
            return (MessageType) this.zba;
        }
        this.zba.zbB();
        return (MessageType) this.zba;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvn
    public final /* bridge */ /* synthetic */ zbvm zbm() {
        throw null;
    }

    public final void zbn() {
        if (this.zba.zbG()) {
            return;
        }
        zbo();
    }

    public void zbo() {
        zbuf zbufVarZbt = this.zbb.zbt();
        zba(zbufVarZbt, this.zba);
        this.zba = zbufVarZbt;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvn
    public final boolean zbp() {
        return zbuf.zbF(this.zba, false);
    }
}
