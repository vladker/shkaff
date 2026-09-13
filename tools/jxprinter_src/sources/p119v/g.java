package p119v;

import android.widget.TextView;
import com.appdev.standard.model.MaterialLibraryTypeModel;
import com.library.base.util.recyclerview.a;
import com.library.base.util.recyclerview.f;
import com.orhanobut.hawk.Hawk;
import p113u.c;
import p113u.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class g extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f f8753a;

    @Override // com.library.base.util.recyclerview.b
    public final void convert(a aVar, Object obj) {
        MaterialLibraryTypeModel materialLibraryTypeModel = (MaterialLibraryTypeModel) obj;
        TextView textView = (TextView) aVar.a(d.tv_item_label_type);
        textView.setText(materialLibraryTypeModel.getMaterialName());
        if (((String) Hawk.get("current_language", "")).equals("en")) {
            textView.setGravity(2);
        }
        if (materialLibraryTypeModel.isSelect()) {
            textView.setTextColor(this.context.getResources().getColor(p113u.a.white));
            textView.setBackgroundResource(c.bg_ffae00_rad_10);
        } else {
            textView.setTextColor(this.context.getResources().getColor(p113u.a.color_FFAE00));
            textView.setBackground(null);
        }
    }
}
