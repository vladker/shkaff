package A0;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.o;
import java.io.File;
import java.io.FileNotFoundException;
import p126w0.v;
import p144z0.S;
import p144z0.T;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class j implements com.bumptech.glide.load.data.e {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String[] f14j = {"_data"};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f15a;
    public final T b;
    public final T c;
    public final Uri d;

    @Nullable
    private volatile com.bumptech.glide.load.data.e delegate;
    public final int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f16f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final v f17g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Class f18h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile boolean f19i;

    public j(Context context, T t6, T t7, Uri uri, int i5, int i6, v vVar, Class cls) {
        this.f15a = context.getApplicationContext();
        this.b = t6;
        this.c = t7;
        this.d = uri;
        this.e = i5;
        this.f16f = i6;
        this.f17g = vVar;
        this.f18h = cls;
    }

    @Nullable
    private S buildDelegateData() {
        boolean zIsExternalStorageLegacy = Environment.isExternalStorageLegacy();
        v vVar = this.f17g;
        int i5 = this.f16f;
        int i6 = this.e;
        Uri requireOriginal = this.d;
        if (zIsExternalStorageLegacy) {
            return this.b.buildLoadData(queryForFilePath(requireOriginal), i6, i5, vVar);
        }
        if (this.f15a.checkSelfPermission("android.permission.ACCESS_MEDIA_LOCATION") == 0) {
            requireOriginal = MediaStore.setRequireOriginal(requireOriginal);
        }
        return this.c.buildLoadData(requireOriginal, i6, i5, vVar);
    }

    @Nullable
    private com.bumptech.glide.load.data.e buildDelegateFetcher() {
        S sBuildDelegateData = buildDelegateData();
        if (sBuildDelegateData != null) {
            return sBuildDelegateData.c;
        }
        return null;
    }

    @NonNull
    private File queryForFilePath(Uri uri) {
        Cursor cursor = null;
        try {
            Cursor cursorQuery = this.f15a.getContentResolver().query(uri, f14j, null, null, null);
            if (cursorQuery == null || !cursorQuery.moveToFirst()) {
                throw new FileNotFoundException("Failed to media store entry for: " + uri);
            }
            String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data"));
            if (TextUtils.isEmpty(string)) {
                throw new FileNotFoundException("File path was empty in media store for: " + uri);
            }
            File file = new File(string);
            cursorQuery.close();
            return file;
        } catch (Throwable th) {
            if (0 == 0) {
                throw th;
            }
            cursor.close();
            throw th;
        }
    }

    @Override // com.bumptech.glide.load.data.e
    public final void a() {
        com.bumptech.glide.load.data.e eVar = this.delegate;
        if (eVar != null) {
            eVar.a();
        }
    }

    @Override // com.bumptech.glide.load.data.e
    public final void cancel() {
        this.f19i = true;
        com.bumptech.glide.load.data.e eVar = this.delegate;
        if (eVar != null) {
            eVar.cancel();
        }
    }

    @Override // com.bumptech.glide.load.data.e
    @NonNull
    public Class<Object> getDataClass() {
        return this.f18h;
    }

    @Override // com.bumptech.glide.load.data.e
    @NonNull
    public p126w0.a getDataSource() {
        return p126w0.a.f8801a;
    }

    @Override // com.bumptech.glide.load.data.e
    public void loadData(@NonNull o oVar, @NonNull com.bumptech.glide.load.data.d dVar) {
        try {
            com.bumptech.glide.load.data.e eVarBuildDelegateFetcher = buildDelegateFetcher();
            if (eVarBuildDelegateFetcher == null) {
                dVar.onLoadFailed(new IllegalArgumentException("Failed to build fetcher for: " + this.d));
            } else {
                this.delegate = eVarBuildDelegateFetcher;
                if (this.f19i) {
                    cancel();
                } else {
                    eVarBuildDelegateFetcher.loadData(oVar, dVar);
                }
            }
        } catch (FileNotFoundException e) {
            dVar.onLoadFailed(e);
        }
    }
}
