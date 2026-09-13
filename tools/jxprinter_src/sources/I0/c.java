package I0;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public interface c extends Future, com.bumptech.glide.request.target.k {
    @Override // com.bumptech.glide.request.target.k
    @Nullable
    /* synthetic */ d getRequest();

    @Override // com.bumptech.glide.request.target.k
    /* synthetic */ void getSize(@NonNull com.bumptech.glide.request.target.j jVar);

    @Override // com.bumptech.glide.request.target.k
    /* synthetic */ void onLoadCleared(@Nullable Drawable drawable);

    @Override // com.bumptech.glide.request.target.k
    /* synthetic */ void onLoadFailed(@Nullable Drawable drawable);

    @Override // com.bumptech.glide.request.target.k
    /* synthetic */ void onLoadStarted(@Nullable Drawable drawable);

    @Override // com.bumptech.glide.request.target.k
    /* synthetic */ void onResourceReady(@NonNull Object obj, @Nullable J0.d dVar);

    @Override // com.bumptech.glide.request.target.k
    /* synthetic */ void removeCallback(@NonNull com.bumptech.glide.request.target.j jVar);

    @Override // com.bumptech.glide.request.target.k
    /* synthetic */ void setRequest(@Nullable d dVar);
}
