package I2;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public interface e {
    @NonNull
    b getRefreshContent();

    @NonNull
    f getRefreshLayout();

    e requestDefaultTranslationContentFor(@NonNull a aVar, boolean z6);

    e requestDrawBackgroundFor(@NonNull a aVar, int i5);

    e requestNeedTouchEventFor(@NonNull a aVar, boolean z6);

    e requestRemeasureHeightFor(@NonNull a aVar);

    e setState(@NonNull J2.b bVar);
}
