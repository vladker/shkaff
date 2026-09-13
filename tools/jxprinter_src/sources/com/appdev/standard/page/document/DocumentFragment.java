package com.appdev.standard.page.document;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;
import com.appdev.constant.DefaultRouteConstant;
import com.appdev.standard.model.CommonSelectModel;
import com.library.base.frame.f;
import java.util.Iterator;
import p113u.d;
import p113u.e;
import p113u.g;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class DocumentFragment extends f {
    private Fragment currentFragment;

    @BindView(5096)
    FrameLayout flDocumentView;

    @BindView(5369)
    LinearLayout llDocumentAdd;
    private com.library.base.util.recyclerview.f quickAdapter;

    @BindView(5820)
    RecyclerView rvDocumentType;
    private Fragment[] fragments = null;
    private int targetIndex = -1;

    /* JADX INFO: Access modifiers changed from: private */
    public void switchToIndex(int i5) {
        com.library.base.util.recyclerview.f fVar = this.quickAdapter;
        if (fVar == null) {
            return;
        }
        Iterator<Object> it = fVar.getData().iterator();
        while (it.hasNext()) {
            ((CommonSelectModel) it.next()).setSelect(false);
        }
        ((CommonSelectModel) this.quickAdapter.getData().get(i5)).setSelect(true);
        this.quickAdapter.notifyDataSetChanged();
        try {
            FragmentTransaction fragmentTransactionBeginTransaction = getChildFragmentManager().beginTransaction();
            Fragment fragment = this.currentFragment;
            if (fragment != null) {
                fragmentTransactionBeginTransaction.hide(fragment);
            }
            Fragment fragment2 = this.fragments[i5];
            this.currentFragment = fragment2;
            if (fragment2.isAdded()) {
                fragmentTransactionBeginTransaction.show(this.currentFragment);
            } else {
                int i6 = d.fl_document_view;
                Fragment fragment3 = this.currentFragment;
                fragmentTransactionBeginTransaction.add(i6, fragment3, fragment3.getClass().getName()).show(this.currentFragment);
            }
            fragmentTransactionBeginTransaction.commit();
        } catch (ArrayIndexOutOfBoundsException unused) {
            p051j0.a.d("DocumentFragment", "数据越界");
        }
    }

    @Override // com.library.base.frame.e
    public void initComponent() {
        this.fragments = new Fragment[]{new PersonalSpaceFragment(), new CollectLabelFragment(), new PublishLabelFragment()};
        this.quickAdapter = new com.library.base.util.recyclerview.f(getContext(), e.item_document_type) { // from class: com.appdev.standard.page.document.DocumentFragment.1
            @Override // com.library.base.util.recyclerview.b
            public void convert(com.library.base.util.recyclerview.a aVar, CommonSelectModel commonSelectModel) {
                TextView textView = (TextView) aVar.a(d.tv_item_document_type_key);
                textView.setText(commonSelectModel.getKey());
                View viewA = aVar.a(d.view_item_document_type_underline);
                if (commonSelectModel.isSelect()) {
                    viewA.setBackground(DocumentFragment.this.getResources().getDrawable(p113u.c.bg_fdd300_rad_10));
                    textView.setTextColor(DocumentFragment.this.getResources().getColor(p113u.a.color_333333));
                } else {
                    viewA.setBackground(null);
                    textView.setTextColor(DocumentFragment.this.getResources().getColor(p113u.a.color_999999));
                }
            }
        };
        this.rvDocumentType.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        this.rvDocumentType.setAdapter(this.quickAdapter);
        this.quickAdapter.add(new CommonSelectModel(getString(g.text_290), true));
        this.quickAdapter.add(new CommonSelectModel(getString(g.text_291), false));
        this.quickAdapter.add(new CommonSelectModel(getString(g.text_292), false));
    }

    @Override // com.library.base.frame.f, com.library.base.frame.e
    public void initListener() {
        this.quickAdapter.setOnItemClickListener(new com.library.base.util.recyclerview.e() { // from class: com.appdev.standard.page.document.DocumentFragment.2
            @Override // com.library.base.util.recyclerview.e
            public void onItemClick(View view, int i5) {
                DocumentFragment.this.switchToIndex(i5);
            }

            @Override // com.library.base.util.recyclerview.e
            public void onItemLongClick(View view, int i5) {
            }
        });
    }

    @Override // com.library.base.frame.e
    public int layoutId() {
        return e.fragment_document;
    }

    @OnClick({5369})
    public void onDocumentAddClick(View view) {
        androidx.exifinterface.media.a.x(DefaultRouteConstant.ACTIVITY_CREATE_LABEL);
    }

    @Override // com.library.base.frame.e
    public void refreshUI() {
        if (this.currentFragment == null || this.targetIndex != -1) {
            int i5 = this.targetIndex;
            if (i5 != -1) {
                this.targetIndex = -1;
            } else {
                i5 = 0;
            }
            switchToIndex(i5);
        }
    }

    public void switchToMinePersonSpace() {
        this.targetIndex = 0;
    }
}
