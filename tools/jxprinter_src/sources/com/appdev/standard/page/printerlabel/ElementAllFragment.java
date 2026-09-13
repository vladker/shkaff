package com.appdev.standard.page.printerlabel;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.FragmentActivity;
import butterknife.OnClick;
import com.appdev.constant.DefaultRouteConstant;
import com.appdev.standard.dialog.C0462o;
import com.appdev.standard.dialog.DefaultTipDialog;
import com.appdev.standard.dialog.InterfaceC0461n;
import com.appdev.standard.dialog.PermissionTipDialog;
import com.appdev.standard.page.LocalFlutterBoostActivity;
import com.idlefish.flutterboost.FlutterBoost;
import com.idlefish.flutterboost.containers.FlutterActivityLaunchConfigs;
import com.idlefish.flutterboost.containers.FlutterBoostActivity;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.xmlbeans.XmlErrorCodes;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class ElementAllFragment extends com.library.base.frame.f implements p014c0.a {
    private ActivityResultLauncher<Intent> importExcelLauncher;
    private p014c0.e uploadImageWorker = null;
    private p056k0.i mediaPicker = new p056k0.i();
    private p056k0.b resultReceiver = new p056k0.b();

    /* JADX INFO: renamed from: com.appdev.standard.page.printerlabel.ElementAllFragment$6, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class AnonymousClass6 implements p026e2.a {
        public AnonymousClass6() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onRequestPermissionSuccess$0(ActivityResult activityResult, String str) {
            if (activityResult != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("path", str);
                    jSONObject.put("type", 1);
                    S4.d.b().f(new p137y.a(6, jSONObject));
                } catch (Exception e) {
                    p051j0.a.e("ElementAllFragment", "", e);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onRequestPermissionSuccess$1(ActivityResult activityResult) {
            String str;
            if (activityResult.getResultCode() != -1 || (str = (String) ((HashMap) activityResult.getData().getSerializableExtra(FlutterActivityLaunchConfigs.ACTIVITY_RESULT_KEY)).get("image")) == null) {
                return;
            }
            new Handler(Looper.getMainLooper()).postDelayed(new x(activityResult, str, 0), 200L);
        }

        @Override // p026e2.a
        public void onRequestPermissionFail() {
            p042h2.d.show(p113u.g.toast_3);
        }

        @Override // p026e2.a
        public void onRequestPermissionSuccess() {
            try {
                HashMap map = new HashMap();
                map.put("title", ElementAllFragment.this.getString(p113u.g.text_236));
                ElementAllFragment.this.resultReceiver.startActivityForResult(new FlutterBoostActivity.CachedEngineIntentBuilder(LocalFlutterBoostActivity.class).backgroundMode(io.flutter.embedding.android.FlutterActivityLaunchConfigs.BackgroundMode.transparent).destroyEngineWithActivity(false).url("take_photo").urlParams(map).build(ElementAllFragment.this.getActivity()), new y(0));
            } catch (Exception e) {
                p051j0.a.e("ElementAllFragment", "", e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void lambda$onViewCreated$0(ActivityResult activityResult) {
        if (activityResult.getResultCode() == -1) {
            HashMap map = (HashMap) activityResult.getData().getSerializableExtra(FlutterActivityLaunchConfigs.ACTIVITY_RESULT_KEY);
            String str = (String) map.get("fileUrl");
            String str2 = (String) map.get("fileName");
            Boolean bool = (Boolean) map.get("showTableHeader");
            List list = (List) map.get(XmlErrorCodes.LIST);
            S4.d dVarB = S4.d.b();
            p137y.q qVar = new p137y.q();
            qVar.f9020a = str2;
            qVar.b = str;
            qVar.c = list;
            qVar.d = bool;
            dVarB.f(qVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$selectPicture$1(Uri uri) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("path", uri.toString());
            jSONObject.put("type", 1);
            S4.d.b().f(new p137y.a(6, jSONObject));
        } catch (Exception e) {
            p051j0.a.e("ElementAllFragment", "", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$selectPicture$2(Uri uri) {
        if (uri != null) {
            new Handler(Looper.getMainLooper()).postDelayed(new w(uri, 0), 200L);
        }
    }

    public void camera() {
        getFrameActivity().needCameraPermission(new PermissionTipDialog(getFrameActivity(), getString(p113u.g.camera_permission)), new AnonymousClass6());
    }

    @Override // com.library.base.frame.e
    public void initComponent() {
        p014c0.e eVar = new p014c0.e(getContext());
        this.uploadImageWorker = eVar;
        addPresenter(eVar);
    }

    @Override // com.library.base.frame.e
    public int layoutId() {
        return p113u.e.fragment_element_all;
    }

    @OnClick({5372})
    public void onElementBarcodeAddClick(View view) {
        S4.d.b().f(new p137y.a(7));
    }

    @OnClick({5374})
    public void onElementExcelImportClick(View view) {
        try {
            this.importExcelLauncher.launch(new FlutterBoostActivity.CachedEngineIntentBuilder(LocalFlutterBoostActivity.class).backgroundMode(io.flutter.embedding.android.FlutterActivityLaunchConfigs.BackgroundMode.transparent).destroyEngineWithActivity(false).url("label_excel_list").urlParams(new HashMap()).build(FlutterBoost.instance().currentActivity()));
        } catch (Exception e) {
            p051j0.a.e("ElementAllFragment", "", e);
        }
    }

    @OnClick({5375})
    public void onElementIconAddClick(View view) {
        if (getContext() instanceof FragmentActivity) {
            C0462o c0462o = new C0462o("label_icon", 350, new HashMap(), new InterfaceC0461n() { // from class: com.appdev.standard.page.printerlabel.ElementAllFragment.2
                @Override // com.appdev.standard.dialog.InterfaceC0461n
                public void onClick(String str, Map<String, Object> map) {
                    if (map == null || !map.containsKey("url")) {
                        return;
                    }
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("path", map.get("url").toString());
                        jSONObject.put("type", 0);
                        S4.d.b().f(new p137y.a(6, jSONObject));
                    } catch (Exception e) {
                        p051j0.a.e("ElementAllFragment", "", e);
                    }
                }
            });
            c0462o.f2651f = false;
            c0462o.show(((FragmentActivity) getContext()).getSupportFragmentManager(), "flutter");
        }
    }

    @OnClick({5376})
    public void onElementLineAddClick(View view) {
        S4.d.b().f(new p137y.a(1));
    }

    @OnClick({5377})
    public void onElementMaterialAddClick(View view) {
        if (getContext() instanceof FragmentActivity) {
            C0462o c0462o = new C0462o("label_material", 350, new HashMap(), new InterfaceC0461n() { // from class: com.appdev.standard.page.printerlabel.ElementAllFragment.3
                @Override // com.appdev.standard.dialog.InterfaceC0461n
                public void onClick(String str, Map<String, Object> map) {
                    if (map == null || !map.containsKey("url")) {
                        return;
                    }
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("path", map.get("url").toString());
                        jSONObject.put("type", 1);
                        S4.d.b().f(new p137y.a(6, jSONObject));
                    } catch (Exception e) {
                        p051j0.a.e("ElementAllFragment", "", e);
                    }
                }
            });
            c0462o.f2651f = false;
            c0462o.show(((FragmentActivity) getContext()).getSupportFragmentManager(), "flutter");
        }
    }

    @OnClick({5378})
    public void onElementPictureAddClick(View view) {
        if (getContext() instanceof FragmentActivity) {
            new C0462o("label_select_image", 220, new HashMap(), new InterfaceC0461n() { // from class: com.appdev.standard.page.printerlabel.ElementAllFragment.1
                @Override // com.appdev.standard.dialog.InterfaceC0461n
                public void onClick(String str, Map<String, Object> map) {
                    if (str.equals("album")) {
                        ElementAllFragment.this.selectPicture();
                    } else if (str.equals("camera")) {
                        ElementAllFragment.this.camera();
                    }
                }
            }).show(((FragmentActivity) getContext()).getSupportFragmentManager(), "flutter");
        }
    }

    @OnClick({5379})
    public void onElementQrcodeAddClick(View view) {
        S4.d.b().f(new p137y.a(8));
    }

    @OnClick({5380})
    public void onElementShapeAddClick(View view) {
        S4.d.b().f(new p137y.a(2));
    }

    @OnClick({5381})
    public void onElementSymbolsClick(View view) {
        if (getContext() instanceof FragmentActivity) {
            new C0462o("label_symbols", 186, new HashMap(), new InterfaceC0461n() { // from class: com.appdev.standard.page.printerlabel.ElementAllFragment.4
                @Override // com.appdev.standard.dialog.InterfaceC0461n
                public void onClick(String str, Map<String, Object> map) {
                    if (map == null || !map.containsKey("symbol")) {
                        return;
                    }
                    S4.d.b().f(new p137y.a(5, map.get("symbol").toString()));
                }
            }).show(((FragmentActivity) getContext()).getSupportFragmentManager(), "flutter");
        }
    }

    @OnClick({5382})
    public void onElementTableAddClick(View view) {
        S4.h hVar = p042h2.e.f4031a;
        if (hVar.g() && hVar.h()) {
            S4.d.b().f(new p137y.a(9));
            return;
        }
        DefaultTipDialog defaultTipDialog = new DefaultTipDialog(getContext());
        defaultTipDialog.e("");
        defaultTipDialog.c(getString(p113u.g.text_246));
        defaultTipDialog.a(getString(p113u.g.text_254));
        defaultTipDialog.b(getString(p113u.g.text_255));
        defaultTipDialog.f2608a = new com.bumptech.glide.f() { // from class: com.appdev.standard.page.printerlabel.ElementAllFragment.5
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

    @OnClick({5383})
    public void onElementTextAddClick(View view) {
        S4.d.b().f(new p137y.a(5));
    }

    @OnClick({5384})
    public void onElementTimeAddClick(View view) {
        S4.d.b().f(new p137y.a(10));
    }

    @Override // com.library.base.frame.f, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.mediaPicker.attachToActivity(this);
        this.resultReceiver.attachToActivity(this);
        this.importExcelLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new y(6));
    }

    public void selectPicture() {
        p051j0.a.k("TAG", "getFrameActivity()=" + getFrameActivity());
        if (getFrameActivity() == null) {
            return;
        }
        this.mediaPicker.pick(new y(5));
    }

    @Override // p014c0.a
    public void uploadImageFailed(int i5, String str) {
        p050j.w.c();
        p042h2.d.a(str);
    }

    @Override // p014c0.a
    public void uploadImageSuccess(String str, String str2) {
        p050j.w.c();
        S4.d.b().f(new p137y.a(6, str));
    }

    @Override // com.library.base.frame.e
    public void refreshUI() {
    }
}
