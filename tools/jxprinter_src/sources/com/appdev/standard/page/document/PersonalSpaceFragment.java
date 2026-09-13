package com.appdev.standard.page.document;

import S4.k;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.appdev.standard.dialog.DefaultTipDialog;
import com.appdev.standard.model.CommonSelectModel;
import com.idlefish.flutterboost.containers.FlutterBoostFragment;
import com.library.base.frame.f;
import java.util.Iterator;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;
import p042h2.d;
import p113u.e;
import p113u.g;
import p137y.o;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class PersonalSpaceFragment extends f {

    @BindView(4930)
    TextView btnDelete;
    private Fragment currentFragment;

    @BindView(5100)
    FrameLayout flView;

    @BindView(5266)
    ImageView ivManageSelect;

    @BindView(5433)
    LinearLayout llBottomActionBar;
    private com.library.base.util.recyclerview.f quickAdapter;

    @BindView(5847)
    RecyclerView rvFileType;

    @BindView(6181)
    TextView tvManage;
    private Fragment[] fragments = null;
    private int targetIndex = -1;
    private boolean isManageMode = false;

    private boolean checkCurrentFragmentSelection() {
        Fragment fragment = this.currentFragment;
        if (fragment instanceof MineLabelFragment) {
            return ((MineLabelFragment) fragment).isAllSelected();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initListener$0(View view) {
        if (this.currentFragment instanceof MineLabelFragment) {
            toggleManageMode();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initListener$1(View view) {
        setAllSelection(!checkCurrentFragmentSelection());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$initListener$2(View view) {
        Fragment fragment = this.currentFragment;
        if (fragment instanceof MineLabelFragment) {
            final MineLabelFragment mineLabelFragment = (MineLabelFragment) fragment;
            final List<String> selectedLabelIds = mineLabelFragment.getSelectedLabelIds();
            if (selectedLabelIds.isEmpty()) {
                d.a(getString(g.text_529));
                return;
            }
            DefaultTipDialog defaultTipDialog = new DefaultTipDialog(getContext());
            defaultTipDialog.e(getString(g.text_530));
            defaultTipDialog.c(getString(g.text_531, Integer.valueOf(selectedLabelIds.size())));
            defaultTipDialog.f2608a = new com.bumptech.glide.f() { // from class: com.appdev.standard.page.document.PersonalSpaceFragment.3
                @Override // com.library.base.frame.d
                public void onConfirm() {
                    mineLabelFragment.executeDelete(selectedLabelIds);
                }

                @Override // com.library.base.frame.d
                public void onCancel() {
                }
            };
            defaultTipDialog.show();
        }
    }

    private void refreshAllSelectUI() {
        this.ivManageSelect.setImageResource(checkCurrentFragmentSelection() ? p113u.f.ic_common_check_select : p113u.f.ic_common_check_select_not);
    }

    private void setAllSelection(boolean z6) {
        Fragment fragment = this.currentFragment;
        if (fragment instanceof MineLabelFragment) {
            ((MineLabelFragment) fragment).setAllItemsSelected(z6);
        }
    }

    private void showFragment(Fragment fragment) {
        FragmentManager childFragmentManager = getChildFragmentManager();
        if (this.currentFragment != fragment) {
            FragmentTransaction fragmentTransactionBeginTransaction = childFragmentManager.beginTransaction();
            Fragment fragment2 = this.currentFragment;
            if (fragment2 != null) {
                fragmentTransactionBeginTransaction.hide(fragment2);
            }
            this.currentFragment = fragment;
            if (fragment.isAdded()) {
                fragmentTransactionBeginTransaction.show(fragment).commit();
            } else if (fragment instanceof FlutterBoostFragment) {
                fragmentTransactionBeginTransaction.add(p113u.d.fl_personal_space_view, fragment, ((FlutterBoostFragment) fragment).getUniqueId()).show(fragment).commit();
            } else {
                fragmentTransactionBeginTransaction.add(p113u.d.fl_personal_space_view, fragment).show(fragment).commit();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void switchToIndex(int i5) {
        if (this.quickAdapter == null) {
            return;
        }
        if (this.isManageMode && i5 != 0) {
            toggleManageMode();
        }
        Iterator<Object> it = this.quickAdapter.getData().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else {
                ((CommonSelectModel) it.next()).setSelect(false);
            }
        }
        ((CommonSelectModel) this.quickAdapter.getData().get(i5)).setSelect(true);
        this.quickAdapter.notifyDataSetChanged();
        this.tvManage.setVisibility(i5 != 0 ? 8 : 0);
        try {
            showFragment(this.fragments[i5]);
        } catch (ArrayIndexOutOfBoundsException unused) {
            p051j0.a.d("DocumentFragment", "数据越界");
        }
    }

    private void toggleManageMode() {
        boolean z6 = this.isManageMode;
        this.isManageMode = !z6;
        this.tvManage.setText(getString(!z6 ? g.text_521 : g.text_520));
        this.llBottomActionBar.setVisibility(this.isManageMode ? 0 : 8);
        S4.d.b().f(new o(this.isManageMode));
    }

    @Override // com.library.base.frame.e
    public void initComponent() {
        S4.d.b().j(this);
        this.fragments = new Fragment[]{new MineLabelFragment(), new FlutterBoostFragment.CachedEngineFragmentBuilder().shouldAttachEngineToActivity(false).url("ps_file_page").uniqueId("ps_file_page").build(), new FlutterBoostFragment.CachedEngineFragmentBuilder().shouldAttachEngineToActivity(false).url("ps_excel_page").uniqueId("ps_excel_page").build(), new FlutterBoostFragment.CachedEngineFragmentBuilder().shouldAttachEngineToActivity(false).url("ps_log_page").uniqueId("ps_log_page").build()};
        this.quickAdapter = new com.library.base.util.recyclerview.f(getContext(), e.item_personal_space_content_type) { // from class: com.appdev.standard.page.document.PersonalSpaceFragment.1
            @Override // com.library.base.util.recyclerview.b
            public void convert(com.library.base.util.recyclerview.a aVar, CommonSelectModel commonSelectModel) {
                TextView textView = (TextView) aVar.a(p113u.d.tv_item_content_type_key);
                textView.setText(commonSelectModel.getKey());
                if (commonSelectModel.isSelect()) {
                    textView.setTextColor(PersonalSpaceFragment.this.getResources().getColor(p113u.a.color_FFAE00));
                } else {
                    textView.setTextColor(PersonalSpaceFragment.this.getResources().getColor(p113u.a.color_333333));
                }
            }
        };
        this.rvFileType.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        this.rvFileType.setAdapter(this.quickAdapter);
        this.quickAdapter.add(new CommonSelectModel(getString(g.text_459), true));
        this.quickAdapter.add(new CommonSelectModel(getString(g.text_460), false));
        this.quickAdapter.add(new CommonSelectModel(getString(g.text_461), false));
        this.quickAdapter.add(new CommonSelectModel(getString(g.text_462), false));
    }

    @Override // com.library.base.frame.f, com.library.base.frame.e
    public void initListener() {
        this.quickAdapter.setOnItemClickListener(new com.library.base.util.recyclerview.e() { // from class: com.appdev.standard.page.document.PersonalSpaceFragment.2
            @Override // com.library.base.util.recyclerview.e
            public void onItemClick(View view, int i5) {
                if (PersonalSpaceFragment.this.isManageMode) {
                    return;
                }
                PersonalSpaceFragment.this.switchToIndex(i5);
            }

            @Override // com.library.base.util.recyclerview.e
            public void onItemLongClick(View view, int i5) {
            }
        });
        final int i5 = 0;
        this.tvManage.setOnClickListener(new View.OnClickListener(this) { // from class: com.appdev.standard.page.document.b
            public final /* synthetic */ PersonalSpaceFragment b;

            {
                this.b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i5) {
                    case 0:
                        this.b.lambda$initListener$0(view);
                        break;
                    case 1:
                        this.b.lambda$initListener$1(view);
                        break;
                    default:
                        this.b.lambda$initListener$2(view);
                        break;
                }
            }
        });
        final int i6 = 1;
        this.ivManageSelect.setOnClickListener(new View.OnClickListener(this) { // from class: com.appdev.standard.page.document.b
            public final /* synthetic */ PersonalSpaceFragment b;

            {
                this.b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i6) {
                    case 0:
                        this.b.lambda$initListener$0(view);
                        break;
                    case 1:
                        this.b.lambda$initListener$1(view);
                        break;
                    default:
                        this.b.lambda$initListener$2(view);
                        break;
                }
            }
        });
        final int i7 = 2;
        this.btnDelete.setOnClickListener(new View.OnClickListener(this) { // from class: com.appdev.standard.page.document.b
            public final /* synthetic */ PersonalSpaceFragment b;

            {
                this.b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i7) {
                    case 0:
                        this.b.lambda$initListener$0(view);
                        break;
                    case 1:
                        this.b.lambda$initListener$1(view);
                        break;
                    default:
                        this.b.lambda$initListener$2(view);
                        break;
                }
            }
        });
    }

    @Override // com.library.base.frame.e
    public int layoutId() {
        return e.fragment_personal_space;
    }

    @k(threadMode = ThreadMode.MAIN)
    public void onCheckAllSelectEvent(p137y.c cVar) {
        refreshAllSelectUI();
    }

    @Override // com.library.base.frame.f, com.library.base.frame.e, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (S4.d.b().e(this)) {
            S4.d.b().m(this);
        }
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
}
