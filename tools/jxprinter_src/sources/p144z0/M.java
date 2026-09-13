package p144z0;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.data.e;
import com.bumptech.glide.o;
import java.io.File;
import java.io.FileNotFoundException;
import p126w0.a;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class M implements e {
    public static final String[] c = {"_data"};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f9059a;
    public final Uri b;

    public M(Context context, Uri uri) {
        this.f9059a = context;
        this.b = uri;
    }

    @Override // com.bumptech.glide.load.data.e
    @NonNull
    public Class<File> getDataClass() {
        return File.class;
    }

    @Override // com.bumptech.glide.load.data.e
    @NonNull
    public a getDataSource() {
        return a.f8801a;
    }

    @Override // com.bumptech.glide.load.data.e
    public void loadData(@NonNull o oVar, @NonNull d dVar) {
        Cursor cursorQuery = this.f9059a.getContentResolver().query(this.b, c, null, null, null);
        String string = null;
        if (cursorQuery != null) {
            try {
                string = cursorQuery.moveToFirst() ? cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data")) : null;
                cursorQuery.close();
            } catch (Throwable th) {
                cursorQuery.close();
                throw th;
            }
        }
        if (!TextUtils.isEmpty(string)) {
            dVar.onDataReady(new File(string));
            return;
        }
        dVar.onLoadFailed(new FileNotFoundException("Failed to find file path for: " + this.b));
    }

    @Override // com.bumptech.glide.load.data.e
    public final void a() {
    }

    @Override // com.bumptech.glide.load.data.e
    public final void cancel() {
    }
}
