package com.appdev.standard.page.scene;

import X.k;
import X.l;
import X.o;
import X.p;
import X.q;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.appdev.standard.api.SceneApi;
import com.appdev.standard.dialog.DefaultTipDialog;
import com.appdev.standard.model.MemberModel;
import com.library.base.util.http.Http;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Y;
import org.greenrobot.eventbus.ThreadMode;
import p050j.w;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class CloudSpaceMemberFragment extends com.library.base.frame.f implements o, k {
    private MemberModel deleteMemberModel;
    private l deleteMemberWorker;
    private q memberListWorker;
    private String memberType;
    private com.library.base.util.recyclerview.f quickAdapter;

    @BindView(5825)
    RecyclerView rvFragmentCloudSpaceTeam;

    @BindView(5926)
    SmartRefreshLayout srlFragmentCloudSpaceTeam;
    private int pageNum = 1;
    private int totalPageNo = 1;
    private boolean isLoadMore = false;

    /* JADX INFO: renamed from: com.appdev.standard.page.scene.CloudSpaceMemberFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class AnonymousClass1 extends com.library.base.util.recyclerview.f {
        public AnonymousClass1(Context context, int i5) {
            super(context, i5);
        }

        @Override // com.library.base.util.recyclerview.b
        public void convert(com.library.base.util.recyclerview.a aVar, final MemberModel memberModel) {
            p047i2.a.loadCirclePicture(memberModel.getAvatar(), (ImageView) aVar.a(p113u.d.iv_item_fragment_cloud_space_member_avatar), p113u.f.ic_default_avatar);
            aVar.b(p113u.d.tv_item_fragment_cloud_space_member_nickname, memberModel.getNickName());
            TextView textView = (TextView) aVar.a(p113u.d.tv_item_fragment_cloud_space_member_type);
            TextView textView2 = (TextView) aVar.a(p113u.d.tv_item_fragment_cloud_space_member_delete);
            if ("1".equals(memberModel.getType())) {
                textView.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
            System.out.println(CloudSpaceMemberFragment.this.memberType);
            if (!Y.f(CloudSpaceMemberFragment.this.memberType) && "1".equals(CloudSpaceMemberFragment.this.memberType) && ExifInterface.GPS_MEASUREMENT_2D.equals(memberModel.getType())) {
                textView2.setVisibility(0);
            } else {
                textView2.setVisibility(8);
            }
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.scene.CloudSpaceMemberFragment.1.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    DefaultTipDialog defaultTipDialog = new DefaultTipDialog(CloudSpaceMemberFragment.this.getContext());
                    defaultTipDialog.e("");
                    defaultTipDialog.c(CloudSpaceMemberFragment.this.getString(p113u.g.text_252));
                    defaultTipDialog.a(CloudSpaceMemberFragment.this.getString(p113u.g.cancel));
                    defaultTipDialog.b(CloudSpaceMemberFragment.this.getString(p113u.g.Confirm));
                    defaultTipDialog.f2608a = new com.bumptech.glide.f() { // from class: com.appdev.standard.page.scene.CloudSpaceMemberFragment.1.1.1
                        @Override // com.library.base.frame.d
                        public void onConfirm() {
                            ViewOnClickListenerC00921 viewOnClickListenerC00921 = ViewOnClickListenerC00921.this;
                            CloudSpaceMemberFragment.this.deleteMemberModel = memberModel;
                            w.e();
                            l lVar = CloudSpaceMemberFragment.this.deleteMemberWorker;
                            String teamMembersId = memberModel.getTeamMembersId();
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
            });
        }
    }

    @Override // X.k
    public void deleteMemberFailed(int i5, String str) {
        w.c();
        p042h2.d.a(str);
    }

    @Override // X.k
    public void deleteMemberSuccess() {
        w.c();
        if (this.deleteMemberModel != null) {
            int iIndexOf = this.quickAdapter.getData().indexOf(this.deleteMemberModel);
            if (iIndexOf != -1) {
                this.quickAdapter.remove(iIndexOf);
            }
            this.deleteMemberModel = null;
            S4.d.b().f(new p137y.e());
        }
    }

    @Override // com.library.base.frame.e
    public void initComponent() {
        registerEventBus();
        q qVar = new q(getContext());
        qVar.d = (SceneApi) Http.createApi(SceneApi.class);
        this.memberListWorker = qVar;
        addPresenter(qVar);
        l lVar = new l(getContext());
        this.deleteMemberWorker = lVar;
        addPresenter(lVar);
        this.quickAdapter = new AnonymousClass1(getContext(), p113u.e.item_fragment_cloud_space_member);
        this.rvFragmentCloudSpaceTeam.setLayoutManager(new LinearLayoutManager(getContext()));
        this.rvFragmentCloudSpaceTeam.setAdapter(this.quickAdapter);
    }

    @Override // com.library.base.frame.f, com.library.base.frame.e
    public void initListener() {
        this.srlFragmentCloudSpaceTeam.s(new L2.f() { // from class: com.appdev.standard.page.scene.CloudSpaceMemberFragment.2
            @Override // L2.f, L2.d
            public void onLoadMore(@NonNull I2.f fVar) {
                CloudSpaceMemberFragment.this.isLoadMore = true;
                if (CloudSpaceMemberFragment.this.pageNum == CloudSpaceMemberFragment.this.totalPageNo) {
                    CloudSpaceMemberFragment.this.srlFragmentCloudSpaceTeam.r(true);
                    return;
                }
                CloudSpaceMemberFragment.this.pageNum++;
                q qVar = CloudSpaceMemberFragment.this.memberListWorker;
                qVar.d.memberList(CloudSpaceMemberFragment.this.pageNum, 10).b(new p(qVar));
            }

            @Override // L2.f, L2.e
            public void onRefresh(@NonNull I2.f fVar) {
                CloudSpaceMemberFragment.this.isLoadMore = false;
                CloudSpaceMemberFragment.this.srlFragmentCloudSpaceTeam.r(false);
                CloudSpaceMemberFragment.this.pageNum = 1;
                q qVar = CloudSpaceMemberFragment.this.memberListWorker;
                qVar.d.memberList(CloudSpaceMemberFragment.this.pageNum, 10).b(new p(qVar));
            }
        });
    }

    @Override // com.library.base.frame.e
    public int layoutId() {
        return p113u.e.fragment_cloud_space_member;
    }

    @Override // X.o
    public void memberListFailed(int i5, String str) {
        int i6 = this.pageNum;
        if (i6 > 1) {
            this.pageNum = i6 - 1;
        }
        this.srlFragmentCloudSpaceTeam.k();
        this.srlFragmentCloudSpaceTeam.i();
        w.c();
        p042h2.d.a(str);
    }

    @Override // X.o
    public void memberListSuccess(List<MemberModel> list, int i5) {
        this.srlFragmentCloudSpaceTeam.k();
        this.srlFragmentCloudSpaceTeam.i();
        this.totalPageNo = (int) Math.ceil(((double) i5) / 10.0d);
        w.c();
        if (this.isLoadMore) {
            this.quickAdapter.addAll(list);
        } else {
            this.quickAdapter.replaceAll(list);
        }
    }

    @S4.k(threadMode = ThreadMode.MAIN)
    public void onCloudSpaceEvent(p137y.b bVar) {
        this.srlFragmentCloudSpaceTeam.h();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        String string = getArguments().getString("memberType");
        this.memberType = string;
        if ("1".equals(string)) {
            S4.d.b().f(new p137y.d("团队成员_管理员"));
        } else {
            S4.d.b().f(new p137y.d("团队成员_成员"));
        }
    }

    @Override // com.library.base.frame.e
    public void refreshUI() {
        this.srlFragmentCloudSpaceTeam.h();
    }
}
