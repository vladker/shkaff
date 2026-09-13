package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zbtr extends zbtq {
    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbtq
    public final void zba(Object obj) {
        ((zbub) obj).zbb.zbh();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbtq
    public final void zbb(zbwy zbwyVar, Map.Entry entry) {
        zbuc zbucVar = (zbuc) entry.getKey();
        zbww zbwwVar = zbww.zba;
        switch (zbucVar.zbb.ordinal()) {
            case 0:
                zbwyVar.zbf(32149011, ((Double) entry.getValue()).doubleValue());
                break;
            case 1:
                zbwyVar.zbo(32149011, ((Float) entry.getValue()).floatValue());
                break;
            case 2:
                zbwyVar.zbt(32149011, ((Long) entry.getValue()).longValue());
                break;
            case 3:
                zbwyVar.zbL(32149011, ((Long) entry.getValue()).longValue());
                break;
            case 4:
                zbwyVar.zbr(32149011, ((Integer) entry.getValue()).intValue());
                break;
            case 5:
                zbwyVar.zbm(32149011, ((Long) entry.getValue()).longValue());
                break;
            case 6:
                zbwyVar.zbk(32149011, ((Integer) entry.getValue()).intValue());
                break;
            case 7:
                zbwyVar.zbb(32149011, ((Boolean) entry.getValue()).booleanValue());
                break;
            case 8:
                zbwyVar.zbH(32149011, (String) entry.getValue());
                break;
            case 9:
                zbwyVar.zbq(32149011, entry.getValue(), zbvu.zba().zbb(entry.getValue().getClass()));
                break;
            case 10:
                zbwyVar.zbw(32149011, entry.getValue(), zbvu.zba().zbb(entry.getValue().getClass()));
                break;
            case 11:
                zbwyVar.zbd(32149011, (zbtc) entry.getValue());
                break;
            case 12:
                zbwyVar.zbJ(32149011, ((Integer) entry.getValue()).intValue());
                break;
            case 13:
                zbwyVar.zbr(32149011, ((Integer) entry.getValue()).intValue());
                break;
            case 14:
                zbwyVar.zby(32149011, ((Integer) entry.getValue()).intValue());
                break;
            case 15:
                zbwyVar.zbA(32149011, ((Long) entry.getValue()).longValue());
                break;
            case 16:
                zbwyVar.zbC(32149011, ((Integer) entry.getValue()).intValue());
                break;
            case 17:
                zbwyVar.zbE(32149011, ((Long) entry.getValue()).longValue());
                break;
        }
    }
}
