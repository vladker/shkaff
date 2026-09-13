package com.library.base.frame;

import android.os.Bundle;
import android.view.View;
import butterknife.ButterKnife;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class f extends e {
    protected List<p038g2.a> presenters;

    public void addPresenter(p038g2.a aVar) {
        if (this.presenters == null) {
            this.presenters = new ArrayList();
        }
        this.presenters.add(aVar);
        aVar.b = this;
    }

    @Override // com.library.base.frame.e, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        List<p038g2.a> list = this.presenters;
        if (list != null) {
            Iterator<p038g2.a> it = list.iterator();
            while (it.hasNext()) {
                it.next().b = this;
            }
        }
    }

    @Override // com.library.base.frame.e, androidx.fragment.app.Fragment
    public void onDestroyView() {
        List<p038g2.a> list = this.presenters;
        if (list != null) {
            Iterator<p038g2.a> it = list.iterator();
            while (it.hasNext()) {
                it.next().b = null;
            }
        }
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        ButterKnife.bind(this, view);
    }

    @Override // com.library.base.frame.e
    public void initListener() {
    }
}
