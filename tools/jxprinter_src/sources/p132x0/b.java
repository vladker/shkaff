package p132x0;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.c;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.data.e;
import com.bumptech.glide.load.data.k;
import com.bumptech.glide.o;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import p126w0.a;
import p126w0.g;
import p126w0.p;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class b implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f8839a;
    public final d b;
    public InputStream c;

    @VisibleForTesting
    public b(Uri uri, d dVar) {
        this.f8839a = uri;
        this.b = dVar;
    }

    public static b b(Context context, Uri uri, c cVar) {
        return new b(uri, new d(c.get(context).getRegistry().getImageHeaderParsers(), cVar, c.get(context).getArrayPool(), context.getContentResolver()));
    }

    private InputStream openThumbInputStream() throws Throwable {
        int orientation;
        d dVar = this.b;
        Uri uri = this.f8839a;
        InputStream inputStreamOpen = dVar.open(uri);
        if (inputStreamOpen != null) {
            InputStream inputStreamOpenInputStream = null;
            try {
                try {
                    inputStreamOpenInputStream = dVar.c.openInputStream(uri);
                    orientation = p.getOrientation((List<g>) dVar.d, inputStreamOpenInputStream, dVar.b);
                    if (inputStreamOpenInputStream != null) {
                        try {
                            inputStreamOpenInputStream.close();
                        } catch (IOException unused) {
                        }
                    }
                } catch (Throwable th) {
                    if (0 != 0) {
                        try {
                            inputStreamOpenInputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    throw th;
                }
            } catch (IOException | NullPointerException e) {
                if (Log.isLoggable("ThumbStreamOpener", 3)) {
                    Log.d("ThumbStreamOpener", "Failed to open uri: " + uri, e);
                }
                if (inputStreamOpenInputStream != null) {
                    try {
                        inputStreamOpenInputStream.close();
                    } catch (IOException unused3) {
                    }
                }
                orientation = -1;
            }
        } else {
            orientation = -1;
        }
        return orientation != -1 ? new k(inputStreamOpen, orientation) : inputStreamOpen;
    }

    @Override // com.bumptech.glide.load.data.e
    public final void a() {
        InputStream inputStream = this.c;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    @Override // com.bumptech.glide.load.data.e
    @NonNull
    public Class<InputStream> getDataClass() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.e
    @NonNull
    public a getDataSource() {
        return a.f8801a;
    }

    @Override // com.bumptech.glide.load.data.e
    public void loadData(@NonNull o oVar, @NonNull d dVar) throws Throwable {
        try {
            InputStream inputStreamOpenThumbInputStream = openThumbInputStream();
            this.c = inputStreamOpenThumbInputStream;
            dVar.onDataReady(inputStreamOpenThumbInputStream);
        } catch (FileNotFoundException e) {
            if (Log.isLoggable("MediaStoreThumbFetcher", 3)) {
                Log.d("MediaStoreThumbFetcher", "Failed to find thumbnail file", e);
            }
            dVar.onLoadFailed(e);
        }
    }

    @Override // com.bumptech.glide.load.data.e
    public final void cancel() {
    }
}
