package p014c0;

import android.content.Context;
import android.net.Uri;
import androidx.browser.trusted.sharing.ShareTarget;
import com.appdev.standard.api.CommonApi;
import com.library.base.util.http.Http;
import com.library.base.util.http.RequestBodyFactory;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.io.File;
import kotlin.jvm.internal.Y;
import okhttp3.B;
import okhttp3.D;
import okhttp3.Q;
import p038g2.a;
import p051j0.i;
import p113u.g;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class e extends a {
    public final CommonApi d;

    public e(Context context) {
        super(context);
        this.d = null;
        this.d = (CommonApi) Http.createApi(CommonApi.class);
        new RequestBodyFactory();
    }

    public final void a(String str) {
        String strC;
        Q qCreate;
        Context context = this.c;
        if (Y.f(str)) {
            Object obj = this.b;
            if (obj != null) {
                ((a) obj).uploadImageFailed(1, getString(g.The_image_path_cannot_be_empty));
                return;
            }
            return;
        }
        if (str.startsWith("content://")) {
            try {
                Uri uri = Uri.parse(str);
                byte[] bArrK = i.k(context, uri);
                strC = i.c(context, uri);
                qCreate = Q.create(B.parse(ShareTarget.ENCODING_TYPE_MULTIPART), bArrK);
            } catch (Exception unused) {
                Object obj2 = this.b;
                if (obj2 != null) {
                    ((a) obj2).uploadImageFailed(2, getString(g.Failed_to_upload_picture_please_try_again));
                    return;
                }
                return;
            }
        } else {
            File file = new File(str);
            Q qCreate2 = Q.create(B.parse(ShareTarget.ENCODING_TYPE_MULTIPART), file);
            String name = file.getName();
            qCreate = qCreate2;
            strC = name;
        }
        this.d.uploadImage(D.createFormData(Constants.FILE, strC, qCreate)).b(new b(this));
    }
}
