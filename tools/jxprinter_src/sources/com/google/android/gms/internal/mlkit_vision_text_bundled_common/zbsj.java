package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import A3.AbstractC0157z;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbsi;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbsj;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zbsj<MessageType extends zbsj<MessageType, BuilderType>, BuilderType extends zbsi<MessageType, BuilderType>> implements zbvm {
    protected int zba = 0;

    public int zbj(zbvx zbvxVar) {
        throw null;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvm
    public final zbtc zbk() {
        try {
            int iZbo = zbo();
            zbtc zbtcVar = zbtc.zbb;
            byte[] bArr = new byte[iZbo];
            zbth zbthVar = new zbth(bArr, 0, iZbo);
            zbL(zbthVar);
            return zbsy.zba(zbthVar, bArr);
        } catch (IOException e) {
            throw new RuntimeException(AbstractC0157z.o("Serializing ", getClass().getName(), " to a ByteString threw an IOException (should never happen)."), e);
        }
    }

    public final byte[] zbl() {
        try {
            int iZbo = zbo();
            byte[] bArr = new byte[iZbo];
            zbth zbthVar = new zbth(bArr, 0, iZbo);
            zbL(zbthVar);
            zbthVar.zbF();
            return bArr;
        } catch (IOException e) {
            throw new RuntimeException(AbstractC0157z.o("Serializing ", getClass().getName(), " to a byte array threw an IOException (should never happen)."), e);
        }
    }
}
