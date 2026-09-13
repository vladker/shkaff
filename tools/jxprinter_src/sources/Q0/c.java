package Q0;

import androidx.recyclerview.widget.DiffUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class c extends DiffUtil.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f568a;

    public c(d dVar) {
        this.f568a = dVar;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final boolean areContentsTheSame(int i5, int i6) {
        d dVar = this.f568a;
        Object obj = dVar.b.get(i5);
        Object obj2 = dVar.c.get(i6);
        if (obj != null && obj2 != null) {
            return dVar.f569a.f571f.getDiffCallback().areContentsTheSame(obj, obj2);
        }
        if (obj == null && obj2 == null) {
            return true;
        }
        throw new AssertionError();
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final boolean areItemsTheSame(int i5, int i6) {
        d dVar = this.f568a;
        Object obj = dVar.b.get(i5);
        Object obj2 = dVar.c.get(i6);
        if (obj == null || obj2 == null) {
            return obj == null && obj2 == null;
        }
        return dVar.f569a.f571f.getDiffCallback().areItemsTheSame(obj, obj2);
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public Object getChangePayload(int i5, int i6) {
        d dVar = this.f568a;
        Object obj = dVar.b.get(i5);
        Object obj2 = dVar.c.get(i6);
        if (obj == null || obj2 == null) {
            throw new AssertionError();
        }
        return dVar.f569a.f571f.getDiffCallback().getChangePayload(obj, obj2);
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final int getNewListSize() {
        return this.f568a.c.size();
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final int getOldListSize() {
        return this.f568a.b.size();
    }
}
