package com.appdev.standard.page.scene;

import X.k;
import X.l;
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
import com.appdev.standard.api.SceneApi;
import com.appdev.standard.api.pto.AddMemberPto;
import com.appdev.standard.dialog.DefaultEdittextDialog;
import com.appdev.standard.dialog.DefaultTipDialog;
import com.appdev.standard.dialog.InterfaceC0455h;
import com.appdev.standard.model.CloudHeaderModel;
import com.appdev.standard.model.CommonSelectModel;
import com.library.base.util.http.Http;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.jvm.internal.Y;
import org.greenrobot.eventbus.ThreadMode;
import p025e0.i;
import p050j.w;
import p137y.o;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class SceneFragment extends com.library.base.frame.f implements X.d, k, X.a, i {
    private X.c addMemberWorker;
    private CloudHeaderModel cloudHeaderModel;
    private X.e cloudHeaderWorker;
    private Fragment currentFragment;
    private l deleteMemberWorker;

    @BindView(5105)
    FrameLayout flSceneView;
    private Fragment[] fragments = null;
    private boolean isGotoCloud = false;
    private boolean isManageMode = false;

    @BindView(5496)
    LinearLayout llSceneAdd;

    @BindView(5497)
    LinearLayout llSceneLogOutTeam;

    @BindView(5498)
    LinearLayout llSceneSelect;

    @BindView(5499)
    LinearLayout llSceneTeamMembersAdd;
    private com.library.base.util.recyclerview.f quickAdapter;

    @BindView(5851)
    RecyclerView rvSceneType;

    @BindView(6160)
    TextView tvManageButton;
    private p025e0.k userInfoWorker;

    /* JADX INFO: Access modifiers changed from: private */
    public void changeFragment(int i5) {
        Iterator<Object> it = this.quickAdapter.getData().iterator();
        while (it.hasNext()) {
            ((CommonSelectModel) it.next()).setSelect(false);
        }
        ((CommonSelectModel) this.quickAdapter.getData().get(i5)).setSelect(true);
        this.quickAdapter.notifyDataSetChanged();
        try {
            this.currentFragment = this.fragments[i5];
            FragmentTransaction fragmentTransactionBeginTransaction = getChildFragmentManager().beginTransaction();
            int i6 = p113u.d.fl_scene_view;
            Fragment fragment = this.currentFragment;
            fragmentTransactionBeginTransaction.replace(i6, fragment, fragment.getClass().getName());
            fragmentTransactionBeginTransaction.commit();
        } catch (ArrayIndexOutOfBoundsException unused) {
            p051j0.a.d("SceneFragment", "数据越界");
        }
    }

    private void updateManageButton() {
        String string = getString(this.isManageMode ? p113u.g.text_521 : p113u.g.text_520);
        TextView textView = this.tvManageButton;
        if (textView != null) {
            textView.setText(string);
        }
    }

    @Override // X.a
    public void addMemberFailed(int i5, String str) {
        w.c();
        p042h2.d.a(str);
    }

    @Override // X.a
    public void addMemberSuccess(boolean z6) {
        w.c();
        if (z6) {
            S4.d.b().f(new p137y.b());
            p042h2.d.show(p113u.g.toast_70);
            S4.d.b().f(new p137y.e());
        }
    }

    @Override // X.d
    public void cloudHeaderFailed(int i5, String str) {
        w.c();
    }

    @Override // X.d
    public void cloudHeaderSuccess(CloudHeaderModel cloudHeaderModel) {
        w.c();
        this.cloudHeaderModel = cloudHeaderModel;
    }

    @Override // X.k
    public void deleteMemberFailed(int i5, String str) {
        w.c();
        p042h2.d.a(str);
    }

    @Override // X.k
    public void deleteMemberSuccess() {
        this.userInfoWorker.a();
        w.c();
        changeFragment(0);
    }

    @Override // p025e0.i
    public void getUserInfoFailed(int i5, String str) {
        w.c();
        this.isGotoCloud = false;
    }

    @Override // p025e0.i
    public void getUserInfoSuccess() {
        w.c();
        if (this.isGotoCloud) {
            if (p042h2.e.f4031a.h()) {
                changeFragment(2);
            } else {
                DefaultTipDialog defaultTipDialog = new DefaultTipDialog(getContext());
                defaultTipDialog.e("");
                defaultTipDialog.c(getString(p113u.g.text_248));
                defaultTipDialog.b(getString(p113u.g.text_256));
                defaultTipDialog.f2608a = new com.bumptech.glide.f() { // from class: com.appdev.standard.page.scene.SceneFragment.5
                    @Override // com.library.base.frame.d
                    public void onConfirm() {
                        androidx.exifinterface.media.a.x(DefaultRouteConstant.ACTIVITY_MEMBER_CENTER);
                    }

                    @Override // com.library.base.frame.d
                    public void onCancel() {
                    }
                };
                defaultTipDialog.show();
            }
        }
        this.isGotoCloud = false;
    }

    @Override // com.library.base.frame.e
    public void initComponent() {
        registerEventBus();
        l lVar = new l(getContext());
        this.deleteMemberWorker = lVar;
        addPresenter(lVar);
        X.e eVar = new X.e(getContext());
        this.cloudHeaderWorker = eVar;
        addPresenter(eVar);
        X.c cVar = new X.c(getContext());
        cVar.d = (SceneApi) Http.createApi(SceneApi.class);
        this.addMemberWorker = cVar;
        addPresenter(cVar);
        p025e0.k kVar = new p025e0.k(getContext());
        this.userInfoWorker = kVar;
        addPresenter(kVar);
        this.cloudHeaderWorker.a();
        this.fragments = new Fragment[]{new IndustryLabelFragment(), new SquareLabelFragment(), new CloudSpaceFragment()};
        this.quickAdapter = new com.library.base.util.recyclerview.f(getContext(), p113u.e.item_document_type) { // from class: com.appdev.standard.page.scene.SceneFragment.1
            @Override // com.library.base.util.recyclerview.b
            public void convert(com.library.base.util.recyclerview.a aVar, CommonSelectModel commonSelectModel) {
                TextView textView = (TextView) aVar.a(p113u.d.tv_item_document_type_key);
                textView.setText(commonSelectModel.getKey());
                View viewA = aVar.a(p113u.d.view_item_document_type_underline);
                if (commonSelectModel.isSelect()) {
                    viewA.setBackground(SceneFragment.this.getResources().getDrawable(p113u.c.bg_fdd300_rad_10));
                    textView.setTextColor(SceneFragment.this.getResources().getColor(p113u.a.color_333333));
                } else {
                    viewA.setBackground(null);
                    textView.setTextColor(SceneFragment.this.getResources().getColor(p113u.a.color_999999));
                }
            }
        };
        this.rvSceneType.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        this.rvSceneType.setAdapter(this.quickAdapter);
        this.quickAdapter.add(new CommonSelectModel(getString(p113u.g.text_294), "行业模板", true));
        this.quickAdapter.add(new CommonSelectModel(getString(p113u.g.text_295), "广场", false));
        this.quickAdapter.add(new CommonSelectModel(getString(p113u.g.text_296), "团队空间", false));
    }

    @Override // com.library.base.frame.f, com.library.base.frame.e
    public void initListener() {
        this.quickAdapter.setOnItemClickListener(new com.library.base.util.recyclerview.e() { // from class: com.appdev.standard.page.scene.SceneFragment.2
            @Override // com.library.base.util.recyclerview.e
            public void onItemClick(View view, int i5) {
                if (!((CommonSelectModel) SceneFragment.this.quickAdapter.getData().get(i5)).getValue().equals("团队空间")) {
                    SceneFragment.this.changeFragment(i5);
                } else {
                    if (!p042h2.e.f4031a.g()) {
                        androidx.exifinterface.media.a.x(DefaultRouteConstant.ACTIVITY_LOGIN);
                        return;
                    }
                    SceneFragment.this.isGotoCloud = true;
                    w.e();
                    SceneFragment.this.userInfoWorker.a();
                }
            }

            @Override // com.library.base.util.recyclerview.e
            public void onItemLongClick(View view, int i5) {
            }
        });
    }

    @Override // com.library.base.frame.e
    public int layoutId() {
        return p113u.e.fragment_scene;
    }

    @S4.k(threadMode = ThreadMode.MAIN)
    public void onCloudSpaceEvent(p137y.d dVar) {
        String str = dVar.f9011a;
        str.getClass();
        switch (str) {
            case "团队成员_管理员":
                this.llSceneAdd.setVisibility(8);
                this.llSceneSelect.setVisibility(8);
                this.llSceneTeamMembersAdd.setVisibility(0);
                this.llSceneLogOutTeam.setVisibility(8);
                break;
            case "团队成员_成员":
                this.llSceneAdd.setVisibility(8);
                this.llSceneSelect.setVisibility(8);
                this.llSceneTeamMembersAdd.setVisibility(8);
                this.llSceneLogOutTeam.setVisibility(0);
                break;
            case "广场":
                this.llSceneAdd.setVisibility(0);
                this.llSceneSelect.setVisibility(8);
                this.llSceneTeamMembersAdd.setVisibility(8);
                this.llSceneLogOutTeam.setVisibility(8);
                break;
            case "云标签":
                this.llSceneAdd.setVisibility(8);
                this.llSceneSelect.setVisibility(0);
                this.llSceneTeamMembersAdd.setVisibility(8);
                this.llSceneLogOutTeam.setVisibility(8);
                break;
            default:
                this.llSceneAdd.setVisibility(8);
                this.llSceneSelect.setVisibility(8);
                this.llSceneTeamMembersAdd.setVisibility(8);
                this.llSceneLogOutTeam.setVisibility(8);
                break;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (getArguments() != null) {
            String string = getArguments().getString(Constants.KEY);
            if (!Y.f(string) && "CloudSpace".equals(string)) {
                changeFragment(2);
                setArguments(null);
            } else {
                if (Y.f(string) || !"IndustryLabel".equals(string)) {
                    return;
                }
                changeFragment(0);
                setArguments(null);
            }
        }
    }

    @OnClick({5496})
    public void onSceneAddClick(View view) {
        androidx.exifinterface.media.a.x(DefaultRouteConstant.ACTIVITY_CREATE_LABEL);
    }

    @OnClick({5497})
    public void onSceneLogOutTeamClick(View view) {
        if (this.cloudHeaderModel == null) {
            w.e();
            p042h2.d.show(p113u.g.toast_69);
            this.cloudHeaderWorker.a();
            return;
        }
        DefaultTipDialog defaultTipDialog = new DefaultTipDialog(getContext());
        defaultTipDialog.e(getString(p113u.g.text_192));
        defaultTipDialog.c(getString(p113u.g.text_253));
        defaultTipDialog.a(getString(p113u.g.cancel));
        defaultTipDialog.b(getString(p113u.g.Confirm));
        defaultTipDialog.f2608a = new com.bumptech.glide.f() { // from class: com.appdev.standard.page.scene.SceneFragment.4
            @Override // com.library.base.frame.d
            public void onConfirm() {
                w.e();
                l lVar = SceneFragment.this.deleteMemberWorker;
                String teamMembersId = SceneFragment.this.cloudHeaderModel.getTeamMembersId();
                lVar.getClass();
                HashMap map = new HashMap();
                map.put("teamMembersId", teamMembersId);
                lVar.d.deleteMember(map).b(new A.c(lVar, 27));
            }

            @Override // com.library.base.frame.d
            public void onCancel() {
            }
        };
        defaultTipDialog.show();
    }

    @OnClick({5498})
    public void onSceneSelectClick(View view) {
        this.isManageMode = !this.isManageMode;
        updateManageButton();
        S4.d.b().f(new o(this.isManageMode));
    }

    @OnClick({5499})
    public void onSceneTeamMembersAddClick(View view) {
        if (this.cloudHeaderModel == null) {
            w.e();
            p042h2.d.show(p113u.g.toast_69);
            this.cloudHeaderWorker.a();
        } else {
            DefaultEdittextDialog defaultEdittextDialog = new DefaultEdittextDialog(getContext());
            defaultEdittextDialog.e(getString(p113u.g.text_191));
            defaultEdittextDialog.a(getString(p113u.g.cancel));
            defaultEdittextDialog.b(getString(p113u.g.Confirm));
            defaultEdittextDialog.f2607a = new InterfaceC0455h() { // from class: com.appdev.standard.page.scene.SceneFragment.3
                @Override // com.appdev.standard.dialog.InterfaceC0455h
                public void onConfirm(String str) {
                    w.e();
                    X.c cVar = SceneFragment.this.addMemberWorker;
                    cVar.d.addMember(new AddMemberPto(SceneFragment.this.cloudHeaderModel.getTeamId(), str)).b(new X.b(cVar));
                }

                @Override // com.appdev.standard.dialog.InterfaceC0455h
                public void onCancel() {
                }
            };
            defaultEdittextDialog.show();
        }
    }

    @Override // com.library.base.frame.e
    public void refreshUI() {
        if (this.currentFragment == null) {
            this.currentFragment = this.fragments[0];
        }
        FragmentTransaction fragmentTransactionBeginTransaction = getChildFragmentManager().beginTransaction();
        int i5 = p113u.d.fl_scene_view;
        Fragment fragment = this.currentFragment;
        fragmentTransactionBeginTransaction.replace(i5, fragment, fragment.getClass().getName());
        fragmentTransactionBeginTransaction.commit();
    }
}
