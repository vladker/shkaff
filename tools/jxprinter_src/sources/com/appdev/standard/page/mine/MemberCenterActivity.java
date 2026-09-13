package com.appdev.standard.page.mine;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import cn.bertsir.zbar.Qr.ScanResult;
import cn.bertsir.zbar.QrManager;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.appdev.constant.DefaultRouteConstant;
import com.appdev.standard.api.MineApi;
import com.appdev.standard.dialog.DefaultTipDialog;
import com.appdev.standard.dialog.PermissionTipDialog;
import com.appdev.standard.model.VipModel;
import com.appdev.standard.page.auth.PcLoginConfirmActivity;
import com.library.base.frame.MvpActivity;
import com.library.base.util.http.Http;
import com.library.base.widget.AutoNullDisplayView;
import com.orhanobut.hawk.Hawk;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Y;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import p025e0.i;
import p037g0.j;
import p037g0.k;
import p037g0.l;
import p037g0.m;
import p050j.w;
import p056k0.r;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@Route(path = DefaultRouteConstant.ACTIVITY_MEMBER_CENTER)
public class MemberCenterActivity extends MvpActivity implements i, k, p037g0.h, p037g0.e {

    @BindView(4877)
    AutoNullDisplayView audvMemberCenter;
    private Activity context;
    private p037g0.g judgeRankWorker;

    @BindView(5423)
    LinearLayout llMemberCenterBottom;

    @BindView(5424)
    LinearLayout llMemberCenterCurrent;
    private com.library.base.util.recyclerview.f quickAdapter;

    @BindView(5842)
    RecyclerView rvMemberCenterMemberData;
    private j scanQrVipWorker;
    private VipModel selectVipModel;

    @BindView(5933)
    SmartRefreshLayout srlMemberCenter;

    @BindView(6171)
    TextView tvMemberCenterCurrentMemberName;

    @BindView(6172)
    TextView tvMemberCenterCurrentMemberTime;

    @BindView(6174)
    TextView tvMemberCenterSelectMemberName;
    private p025e0.k userInfoWorker;
    private m vipListWorker;
    private int pageNum = 1;
    private int totalPageNo = 1;
    private boolean isLoadMore = false;
    private String appType = null;

    @Override // p025e0.i
    public void getUserInfoFailed(int i5, String str) {
        w.c();
        p042h2.d.a(str);
    }

    @Override // p025e0.i
    public void getUserInfoSuccess() {
        w.c();
        S4.h hVar = p042h2.e.f4031a;
        p032f2.a aVarE = hVar.e();
        if (!hVar.h()) {
            this.llMemberCenterCurrent.setVisibility(8);
            return;
        }
        this.llMemberCenterCurrent.setVisibility(0);
        this.tvMemberCenterCurrentMemberName.setText(aVarE.e);
        this.tvMemberCenterCurrentMemberTime.setText(String.format(getString(p113u.g.text_278), aVarE.f3964h));
    }

    @Override // p037g0.k
    public void getVipListFailed(int i5, String str) {
        int i6 = this.pageNum;
        if (i6 > 1) {
            this.pageNum = i6 - 1;
        }
        this.srlMemberCenter.k();
        this.srlMemberCenter.i();
        w.c();
        p042h2.d.a(str);
    }

    @Override // p037g0.k
    public void getVipListSuccess(List<VipModel> list, int i5) {
        this.srlMemberCenter.k();
        this.srlMemberCenter.i();
        this.totalPageNo = (int) Math.ceil(((double) i5) / 10.0d);
        w.c();
        if (this.isLoadMore) {
            this.quickAdapter.addAll(list);
        } else {
            this.quickAdapter.replaceAll(list);
        }
    }

    @Override // com.library.base.frame.MvpActivity, com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initComponent() {
        super.initComponent();
        this.appType = (String) Hawk.get("appType");
        this.context = this;
        p025e0.k kVar = new p025e0.k(this);
        this.userInfoWorker = kVar;
        addPresenter(kVar);
        m mVar = new m(this);
        mVar.d = (MineApi) Http.createApi(MineApi.class);
        this.vipListWorker = mVar;
        addPresenter(mVar);
        j jVar = new j(this);
        this.scanQrVipWorker = jVar;
        addPresenter(jVar);
        p037g0.g gVar = new p037g0.g(this);
        gVar.d = (MineApi) Http.createApi(MineApi.class);
        this.judgeRankWorker = gVar;
        addPresenter(gVar);
        this.quickAdapter = new com.library.base.util.recyclerview.f(this, p113u.e.item_member_center) { // from class: com.appdev.standard.page.mine.MemberCenterActivity.1
            @Override // com.library.base.util.recyclerview.b
            public void convert(com.library.base.util.recyclerview.a aVar, final VipModel vipModel) {
                String string;
                aVar.b(p113u.d.tv_item_member_center_name, vipModel.getMemberName());
                int i5 = p113u.d.tv_item_member_center_supporters_number;
                aVar.b(i5, String.format(MemberCenterActivity.this.getString(p113u.g.text_274), vipModel.getSupportersNumber()));
                aVar.b(p113u.d.tv_item_member_center_cloud_tags_number, String.format(MemberCenterActivity.this.getString(p113u.g.text_275), vipModel.getCloudTagsNumber()));
                aVar.b(p113u.d.tv_item_member_center_person_tags_number, String.format(MemberCenterActivity.this.getString(p113u.g.text_276), vipModel.getPersonalTagsNumber()));
                byte b = 0;
                ((TextView) aVar.a(i5)).setSingleLine(false);
                int i6 = p113u.d.tv_item_member_center_discount_rate;
                ((TextView) aVar.a(i6)).setSingleLine(false);
                ((TextView) aVar.a(i5)).setMaxLines(2);
                ((TextView) aVar.a(i6)).setMaxLines(2);
                TextView textView = (TextView) aVar.a(i6);
                if (vipModel.getDiscountRate().equals("100")) {
                    textView.setVisibility(8);
                } else {
                    textView.setVisibility(0);
                    textView.setText(String.format(MemberCenterActivity.this.getString(p113u.g.text_277), vipModel.getDiscountRate()));
                }
                String periodOfValidity = vipModel.getPeriodOfValidity();
                periodOfValidity.getClass();
                switch (periodOfValidity.hashCode()) {
                    case 49:
                        if (!periodOfValidity.equals("1")) {
                            b = -1;
                        }
                        break;
                    case 50:
                        b = !periodOfValidity.equals(ExifInterface.GPS_MEASUREMENT_2D) ? (byte) -1 : (byte) 1;
                        break;
                    case 51:
                        b = !periodOfValidity.equals(ExifInterface.GPS_MEASUREMENT_3D) ? (byte) -1 : (byte) 2;
                        break;
                    case 52:
                        b = !periodOfValidity.equals("4") ? (byte) -1 : (byte) 3;
                        break;
                    default:
                        b = -1;
                        break;
                }
                switch (b) {
                    case 0:
                        string = MemberCenterActivity.this.getString(p113u.g.text_313);
                        break;
                    case 1:
                        string = MemberCenterActivity.this.getString(p113u.g.text_314);
                        break;
                    case 2:
                        string = MemberCenterActivity.this.getString(p113u.g.text_315);
                        break;
                    case 3:
                        string = MemberCenterActivity.this.getString(p113u.g.text_316);
                        break;
                    default:
                        string = "";
                        break;
                }
                if (MemberCenterActivity.this.appType.equals("sanduOverseas")) {
                    aVar.b(p113u.d.tv_item_member_center_price, androidx.exifinterface.media.a.m("$", vipModel.getPrice(), PackagingURIHelper.FORWARD_SLASH_STRING, string));
                } else {
                    aVar.b(p113u.d.tv_item_member_center_price, androidx.exifinterface.media.a.m("￥", vipModel.getPrice(), PackagingURIHelper.FORWARD_SLASH_STRING, string));
                }
                View viewA = aVar.a(p113u.d.ll_item_member_center);
                if (vipModel.isSelect()) {
                    viewA.setBackgroundResource(p113u.f.ic_member_center_vip_bg_select);
                } else {
                    viewA.setBackgroundResource(p113u.f.ic_member_center_vip_bg_select_not);
                }
                ((TextView) aVar.a(p113u.d.tv_item_member_center_explain)).setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.mine.MemberCenterActivity.1.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ARouter.getInstance().build(DefaultRouteConstant.ACTIVITY_ARTICLE_VIEW).withString("url", vipModel.getVipExplain()).withString("title", MemberCenterActivity.this.getString(p113u.g.text_328)).navigation();
                    }
                });
            }
        };
        this.rvMemberCenterMemberData.setLayoutManager(new LinearLayoutManager(this));
        this.rvMemberCenterMemberData.setAdapter(this.quickAdapter);
        this.audvMemberCenter.b(p113u.f.ic_label_no_data);
        this.audvMemberCenter.setConnect(getString(p113u.g.text_282));
        this.audvMemberCenter.setButtonWhetherVisible(false);
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initData() {
        super.initData();
        w.e();
        this.userInfoWorker.a();
        this.srlMemberCenter.h();
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initListener() {
        super.initListener();
        this.srlMemberCenter.s(new L2.f() { // from class: com.appdev.standard.page.mine.MemberCenterActivity.2
            @Override // L2.f, L2.d
            public void onLoadMore(@NonNull I2.f fVar) {
                MemberCenterActivity.this.isLoadMore = true;
                if (MemberCenterActivity.this.pageNum == MemberCenterActivity.this.totalPageNo) {
                    MemberCenterActivity.this.srlMemberCenter.r(true);
                    return;
                }
                MemberCenterActivity.this.pageNum++;
                m mVar = MemberCenterActivity.this.vipListWorker;
                mVar.d.getVipList(MemberCenterActivity.this.pageNum, 10).b(new l(mVar));
            }

            @Override // L2.f, L2.e
            public void onRefresh(@NonNull I2.f fVar) {
                MemberCenterActivity.this.isLoadMore = false;
                MemberCenterActivity.this.srlMemberCenter.r(false);
                MemberCenterActivity.this.pageNum = 1;
                m mVar = MemberCenterActivity.this.vipListWorker;
                mVar.d.getVipList(MemberCenterActivity.this.pageNum, 10).b(new l(mVar));
            }
        });
        this.quickAdapter.setOnItemClickListener(new com.library.base.util.recyclerview.e() { // from class: com.appdev.standard.page.mine.MemberCenterActivity.3
            @Override // com.library.base.util.recyclerview.e
            public void onItemClick(View view, int i5) {
                Iterator<Object> it = MemberCenterActivity.this.quickAdapter.getData().iterator();
                while (it.hasNext()) {
                    ((VipModel) it.next()).setSelect(false);
                }
                ((VipModel) MemberCenterActivity.this.quickAdapter.getItem(i5)).setSelect(true);
                MemberCenterActivity.this.quickAdapter.notifyDataSetChanged();
                MemberCenterActivity.this.llMemberCenterBottom.setVisibility(0);
                MemberCenterActivity memberCenterActivity = MemberCenterActivity.this;
                memberCenterActivity.selectVipModel = (VipModel) memberCenterActivity.quickAdapter.getItem(i5);
                MemberCenterActivity memberCenterActivity2 = MemberCenterActivity.this;
                memberCenterActivity2.tvMemberCenterSelectMemberName.setText(memberCenterActivity2.selectVipModel.getMemberName());
            }

            @Override // com.library.base.util.recyclerview.e
            public void onItemLongClick(View view, int i5) {
            }
        });
    }

    @Override // p037g0.e
    public void judgeRankFailed(int i5, String str) {
        w.c();
        p042h2.d.a(str);
    }

    @Override // p037g0.e
    public void judgeRankSuccess(boolean z6) {
        w.c();
        if (z6) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("VipModel", this.selectVipModel);
            ARouter.getInstance().build(DefaultRouteConstant.ACTIVITY_MEMBER_BUY).with(bundle).navigation();
            return;
        }
        DefaultTipDialog defaultTipDialog = new DefaultTipDialog(this);
        defaultTipDialog.e(getString(p113u.g.text_124));
        defaultTipDialog.d(getString(p113u.g.text_319));
        defaultTipDialog.a(getString(p113u.g.cancel));
        defaultTipDialog.b(getString(p113u.g.text_320));
        defaultTipDialog.f2608a = new com.bumptech.glide.f() { // from class: com.appdev.standard.page.mine.MemberCenterActivity.5
            @Override // com.library.base.frame.d
            public void onConfirm() {
                Bundle bundle2 = new Bundle();
                bundle2.putSerializable("VipModel", MemberCenterActivity.this.selectVipModel);
                ARouter.getInstance().build(DefaultRouteConstant.ACTIVITY_MEMBER_BUY).with(bundle2).navigation();
            }

            @Override // com.library.base.frame.d
            public void onCancel() {
            }
        };
        defaultTipDialog.show();
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public int layoutId() {
        return p113u.e.activity_member_center;
    }

    public void onMemberCenterClick(View view) {
        if (this.selectVipModel != null) {
            w.e();
            p037g0.g gVar = this.judgeRankWorker;
            gVar.d.judgeRank(this.selectVipModel.getVipPackageId()).b(new p037g0.f(gVar));
        }
    }

    public void onMemberCenterScanClick(View view) {
        needCameraPermission(new PermissionTipDialog(this, getString(p113u.g.camera_permission)), new p026e2.a() { // from class: com.appdev.standard.page.mine.MemberCenterActivity.4
            @Override // p026e2.a
            public void onRequestPermissionFail() {
                p042h2.d.show(p113u.g.toast_3);
            }

            @Override // p026e2.a
            public void onRequestPermissionSuccess() {
                QrManager.getInstance().init(r.a(MemberCenterActivity.this.context)).startScan(MemberCenterActivity.this.context, new QrManager.OnScanResultCallback() { // from class: com.appdev.standard.page.mine.MemberCenterActivity.4.1
                    @Override // cn.bertsir.zbar.QrManager.OnScanResultCallback
                    public void onScanSuccess(ScanResult scanResult) {
                        if (!p042h2.e.f4031a.g()) {
                            p042h2.d.show(p113u.g.toast_32);
                            ARouter.getInstance().build(DefaultRouteConstant.ACTIVITY_LOGIN).navigation();
                            return;
                        }
                        if (Y.f(scanResult.getContent())) {
                            p042h2.d.show(p113u.g.toast_26);
                            return;
                        }
                        String content = scanResult.getContent();
                        if (content.startsWith("soleId")) {
                            PcLoginConfirmActivity.start(MemberCenterActivity.this.context, content);
                            return;
                        }
                        HashMap map = new HashMap();
                        map.put("qrcode", content);
                        w.e();
                        j jVar = MemberCenterActivity.this.scanQrVipWorker;
                        jVar.d.scanQRCode(map).b(new p037g0.i(jVar));
                    }
                });
            }
        });
    }

    @Override // p037g0.h
    public void scanQRCodeFailed(int i5, String str) {
        w.c();
        p042h2.d.a(str);
        if (p042h2.e.f4031a.g()) {
            return;
        }
        androidx.exifinterface.media.a.x(DefaultRouteConstant.ACTIVITY_LOGIN);
    }

    @Override // p037g0.h
    public void scanQRCodeSuccess() {
        w.c();
        p042h2.d.show(p113u.g.toast_34);
        this.userInfoWorker.a();
    }
}
