package S4;

import A3.AbstractC0157z;
import A3.InterfaceC0131a0;
import W3.InterfaceC0233q;
import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.animation.AnimationUtils;
import androidx.exifinterface.media.ExifInterface;
import com.appdev.standard.model.MaterialLibraryTypeModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.common.net.HttpHeaders;
import com.library.base.util.http.Http;
import com.orhanobut.hawk.Hawk;
import java.io.File;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.AbstractC1095i;
import p007a4.C0289m;
import p050j.r;
import p147z3.u;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final class h implements InterfaceC0131a0, J0.d, com.bumptech.glide.load.engine.cache.a, p050j.p, p050j.h, OnCompleteListener, p069m1.b, p056k0.j, X0.a, com.library.base.util.recyclerview.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f689a;
    public Object b;

    public /* synthetic */ h(int i5, boolean z6) {
        this.f689a = i5;
    }

    @Override // p050j.h
    public boolean a(r rVar, Object obj) {
        return rVar.d(obj, (String) this.b) != null;
    }

    @Override // p069m1.b
    public void b(int i5, String str, String str2) {
        String strQ;
        ((V1.b) this.b).getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        sb.append(Long.toString(jCurrentTimeMillis));
        sb.append('|');
        if (i5 == 2) {
            strQ = ExifInterface.GPS_MEASUREMENT_INTERRUPTED;
        } else if (i5 == 3) {
            strQ = "D";
        } else if (i5 == 4) {
            strQ = "I";
        } else if (i5 == 5) {
            strQ = ExifInterface.LONGITUDE_WEST;
        } else if (i5 != 6) {
            strQ = i5 < 2 ? AbstractC0157z.q(new StringBuilder("V-"), 2, i5) : AbstractC0157z.q(new StringBuilder("E+"), i5, 6);
        } else {
            strQ = ExifInterface.LONGITUDE_EAST;
        }
        sb.append(strQ);
        sb.append('|');
        sb.append(str);
        sb.append('|');
        sb.append(str2);
        System.out.println(sb.toString().toString());
    }

    @Override // com.bumptech.glide.load.engine.cache.a
    public com.bumptech.glide.load.engine.cache.c build() {
        File cacheDir = ((Context) ((p075n1.a) this.b).b).getCacheDir();
        File file = cacheDir == null ? null : new File(cacheDir, "image_manager_disk_cache");
        if (file != null && (file.isDirectory() || file.mkdirs())) {
            return new com.bumptech.glide.load.engine.cache.e(file, 262144000L);
        }
        return null;
    }

    @Override // p050j.p
    public Object c(r rVar, Object obj, Object obj2) {
        int[] iArr = (int[]) this.b;
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int i5 : iArr) {
            arrayList.add(r.b(i5, obj2));
        }
        return arrayList;
    }

    @Override // J0.d
    public void d(com.bumptech.glide.request.target.g gVar) {
        View view = gVar.getView();
        if (view != null) {
            view.clearAnimation();
            view.startAnimation(AnimationUtils.loadAnimation(view.getContext(), ((J0.f) this.b).f347a));
        }
    }

    public p032f2.a e() {
        if (((p032f2.a) this.b) == null) {
            this.b = (p032f2.a) Hawk.get("user_util_user_data", new p032f2.a());
        }
        return (p032f2.a) this.b;
    }

    @Override // X0.a
    public void f(int i5) {
        ((p114u0.e) this.b).getClass();
    }

    public boolean g() {
        if (((p032f2.a) this.b) == null) {
            try {
                this.b = (p032f2.a) Hawk.get("user_util_user_data", null);
            } catch (Exception unused) {
            }
        }
        return ((p032f2.a) this.b) != null;
    }

    public boolean h() {
        p032f2.a aVar = (p032f2.a) Hawk.get("user_util_user_data", null);
        this.b = aVar;
        if (aVar == null) {
            return false;
        }
        int i5 = aVar.f3967k;
        return i5 == 1 || i5 == 2;
    }

    public void i() {
        Http.addHeader(HttpHeaders.AUTHORIZATION, "");
        Hawk.delete("user_util_user_data");
        this.b = null;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public void onComplete(Task task) {
        C0289m c0289m = (C0289m) this.b;
        Exception exception = task.getException();
        if (exception != null) {
            c0289m.resumeWith(u.m1361constructorimpl(v.createFailure(exception)));
        } else if (task.isCanceled()) {
            c0289m.cancel(null);
        } else {
            c0289m.resumeWith(u.m1361constructorimpl(task.getResult()));
        }
    }

    @Override // p056k0.j
    public void onImagePicked(Uri uri) {
        if (uri != null) {
            ((O3.l) this.b).invoke(u.a(u.m1361constructorimpl(uri.toString())));
        }
    }

    @Override // com.library.base.util.recyclerview.e
    public void onItemClick(View view, int i5) {
        p119v.g gVar = (p119v.g) this.b;
        Iterator<Object> it = gVar.getData().iterator();
        while (it.hasNext()) {
            ((MaterialLibraryTypeModel) it.next()).setSelect(false);
        }
        MaterialLibraryTypeModel materialLibraryTypeModel = (MaterialLibraryTypeModel) gVar.getData().get(i5);
        materialLibraryTypeModel.setSelect(true);
        gVar.notifyDataSetChanged();
        p119v.f fVar = gVar.f8753a;
        if (fVar != null) {
            fVar.onSelect(materialLibraryTypeModel.getMaterialTypeId());
        }
    }

    @Override // A3.InterfaceC0131a0
    public Iterator sourceIterator() {
        switch (this.f689a) {
            case 1:
                return AbstractC1095i.iterator((Object[]) this.b);
            default:
                return ((InterfaceC0233q) this.b).iterator();
        }
    }

    public /* synthetic */ h(Object obj, int i5) {
        this.f689a = i5;
        this.b = obj;
    }

    public /* synthetic */ h(Object obj, O3.l lVar, int i5) {
        this.f689a = i5;
        this.b = obj;
    }

    public h(Context context) {
        this.f689a = 8;
        this.b = new p075n1.a(context, 7);
    }

    public h(int i5) {
        this.f689a = i5;
        switch (i5) {
            case 14:
                TimeUnit timeUnit = TimeUnit.MINUTES;
                this.b = new t4.i();
                break;
            default:
                this.b = new ArrayDeque();
                break;
        }
    }

    @Override // com.library.base.util.recyclerview.e
    public void onItemLongClick(View view, int i5) {
    }
}
