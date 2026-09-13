package com.google.android.gms.internal.play_billing;

import A3.AbstractC0157z;
import androidx.collection.a;
import com.google.android.gms.internal.play_billing.zzez;
import com.google.android.gms.internal.play_billing.zzfa;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzfa<MessageType extends zzfa<MessageType, BuilderType>, BuilderType extends zzez<MessageType, BuilderType>> implements zzhr {
    protected transient int zza = 0;

    public static void zzk(Iterable iterable, List list) {
        int size = ((Collection) iterable).size();
        if (list instanceof ArrayList) {
            ((ArrayList) list).ensureCapacity(list.size() + size);
        } else if (list instanceof zzhz) {
            ((zzhz) list).zzf(list.size() + size);
        }
        int size2 = list.size();
        List list2 = (List) iterable;
        int size3 = list2.size();
        for (int i5 = 0; i5 < size3; i5++) {
            Object obj = list2.get(i5);
            if (obj == null) {
                String strI = a.i(list.size() - size2, "Element at index ", " is null.");
                int size4 = list.size();
                while (true) {
                    size4--;
                    if (size4 < size2) {
                        throw new NullPointerException(strI);
                    }
                    list.remove(size4);
                }
            } else {
                list.add(obj);
            }
        }
    }

    public final byte[] zzQ() {
        try {
            int iZzn = zzn();
            byte[] bArr = new byte[iZzn];
            zzfu zzfuVar = new zzfu(bArr, 0, iZzn);
            zzD(zzfuVar);
            zzfuVar.zzA();
            return bArr;
        } catch (IOException e) {
            throw new RuntimeException(AbstractC0157z.o("Serializing ", getClass().getName(), " to a byte array threw an IOException (should never happen)."), e);
        }
    }

    public int zzi(zzib zzibVar) {
        throw null;
    }

    @Override // com.google.android.gms.internal.play_billing.zzhr
    public final zzfp zzj() {
        try {
            int iZzn = zzn();
            zzfp zzfpVar = zzfp.zza;
            byte[] bArr = new byte[iZzn];
            zzfu zzfuVar = new zzfu(bArr, 0, iZzn);
            zzD(zzfuVar);
            return zzfl.zza(zzfuVar, bArr);
        } catch (IOException e) {
            throw new RuntimeException(AbstractC0157z.o("Serializing ", getClass().getName(), " to a ByteString threw an IOException (should never happen)."), e);
        }
    }
}
