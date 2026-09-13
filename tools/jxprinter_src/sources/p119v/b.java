package p119v;

import android.content.Context;
import com.appdev.standard.api.dto.InviteRecordDto;
import com.library.base.util.recyclerview.a;
import com.library.base.util.recyclerview.f;
import p113u.d;
import p113u.g;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f8750a;

    @Override // com.library.base.util.recyclerview.b
    public final void convert(a aVar, Object obj) {
        aVar.b(d.tv_content, String.format(this.f8750a.getString(g.text_111), ((InviteRecordDto.DataBean) obj).getInviteUserName()));
    }
}
