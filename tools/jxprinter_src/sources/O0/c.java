package O0;

import android.view.View;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f548a;
    public final /* synthetic */ e b;
    public final /* synthetic */ BaseViewHolder c;

    public /* synthetic */ c(e eVar, BaseViewHolder baseViewHolder, int i5) {
        this.f548a = i5;
        this.b = eVar;
        this.c = baseViewHolder;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View v6) {
        switch (this.f548a) {
            case 0:
                int adapterPosition = this.c.getAdapterPosition();
                if (adapterPosition != -1) {
                    e eVar = this.b;
                    int headerLayoutCount = adapterPosition - eVar.getHeaderLayoutCount();
                    E.b(v6, "v");
                    eVar.setOnItemClick(v6, headerLayoutCount);
                    break;
                }
                break;
            default:
                int adapterPosition2 = this.c.getAdapterPosition();
                if (adapterPosition2 != -1) {
                    e eVar2 = this.b;
                    int headerLayoutCount2 = adapterPosition2 - eVar2.getHeaderLayoutCount();
                    E.b(v6, "v");
                    eVar2.setOnItemChildClick(v6, headerLayoutCount2);
                    break;
                }
                break;
        }
    }
}
