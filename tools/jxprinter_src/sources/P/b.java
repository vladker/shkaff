package P;

import com.appdev.standard.api.dto.BiaoqianDto;
import com.library.base.util.http.CallBack;
import com.library.base.util.http.JsonResult;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class b extends CallBack {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f557a;

    public b(c cVar) {
        this.f557a = cVar;
    }

    @Override // com.library.base.util.http.CallBack
    public final void success(JsonResult jsonResult) {
        ArrayList arrayList = new ArrayList();
        Iterator<BiaoqianDto.DataBean> it = ((BiaoqianDto) jsonResult).getData().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getImgUrl());
        }
        Object obj = this.f557a.b;
        if (obj != null) {
            ((a) obj).getMaterialLibraryDataSuccess(arrayList);
        }
    }

    @Override // com.library.base.util.http.CallBack
    public final void fail(int i5, String str) {
    }
}
