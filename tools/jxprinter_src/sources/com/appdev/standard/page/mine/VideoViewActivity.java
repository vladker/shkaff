package com.appdev.standard.page.mine;

import C5.j;
import C5.k;
import android.content.res.AssetFileDescriptor;
import android.widget.TextView;
import butterknife.BindView;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.appdev.constant.DefaultRouteConstant;
import com.library.base.frame.MvpActivity;
import java.io.IOException;
import xyz.doikki.videoplayer.player.VideoView;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@Route(path = DefaultRouteConstant.ACTIVITY_VIDEO_VIEW)
public class VideoViewActivity extends MvpActivity {

    @Autowired(name = "fileName")
    String fileName;

    @Autowired(name = "title")
    String title;

    @BindView(6274)
    TextView tvTitle;

    @BindView(6316)
    VideoView vvMain;

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.library.base.frame.MvpActivity, com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initComponent() {
        super.initComponent();
        this.tvTitle.setText(getString(p113u.g.text_231));
        B5.e eVar = new B5.e(this);
        String str = this.title;
        C5.b bVar = new C5.b(eVar.getContext());
        AssetFileDescriptor assetFileDescriptorOpenFd = null;
        C5.d dVar = new C5.d(eVar.getContext(), null);
        C5.h hVar = new C5.h(eVar.getContext());
        hVar.setOnClickListener(new C5.g(hVar, 1));
        j jVar = new j(eVar.getContext());
        jVar.setTitle(str);
        eVar.a(bVar, dVar, hVar, jVar);
        eVar.a(new k(eVar.getContext()));
        eVar.a(new C5.f(eVar.getContext()));
        eVar.setCanChangePosition(true);
        this.vvMain.setVideoController(eVar);
        try {
            assetFileDescriptorOpenFd = getResources().getAssets().openFd(this.fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.vvMain.setAssetFileDescriptor(assetFileDescriptorOpenFd);
        this.vvMain.start();
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initListener() {
        super.initListener();
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public int layoutId() {
        return p113u.e.activity_video_view;
    }

    @Override // com.library.base.frame.MvpActivity, com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.vvMain.i();
        super.onDestroy();
    }
}
