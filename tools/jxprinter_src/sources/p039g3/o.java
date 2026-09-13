package p039g3;

import androidx.core.location.LocationRequestCompat;
import p027e3.g;
import t5.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class o implements g {
    @Override // p027e3.g
    public void accept(d dVar) {
        dVar.request(LocationRequestCompat.PASSIVE_INTERVAL);
    }
}
