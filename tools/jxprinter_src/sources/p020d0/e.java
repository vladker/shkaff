package p020d0;

import android.content.Context;
import com.appdev.standard.api.MainApi;
import com.appdev.standard.api.pto.EditRecordNamePto;
import com.library.base.util.http.Http;
import p038g2.a;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class e extends a {
    public final MainApi d;

    public e(Context context) {
        super(context);
        this.d = (MainApi) Http.createApi(MainApi.class);
    }

    public final void a(EditRecordNamePto editRecordNamePto) {
        this.d.editRecordName(editRecordNamePto).b(new d(this, 0));
    }
}
