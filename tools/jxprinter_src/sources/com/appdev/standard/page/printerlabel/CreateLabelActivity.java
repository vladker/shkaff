package com.appdev.standard.page.printerlabel;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.appdev.constant.DefaultRouteConstant;
import com.appdev.standard.model.TemplateConfigBean;
import com.library.base.frame.MvpActivity;
import com.orhanobut.hawk.Hawk;
import java.util.Random;
import kotlin.jvm.internal.Y;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@Route(path = DefaultRouteConstant.ACTIVITY_CREATE_LABEL)
public class CreateLabelActivity extends MvpActivity {
    private String createLabelColumns;
    private String createLabelHeight;
    private String createLabelName;
    private String createLabelSpacing;
    private String createLabelWidth;

    @BindView(5046)
    EditText etCreateLabelColumns;

    @BindView(5047)
    EditText etCreateLabelHeight;

    @BindView(5048)
    EditText etCreateLabelName;

    @BindView(5049)
    EditText etCreateLabelSpacing;

    @BindView(5050)
    EditText etCreateLabelWidth;

    @BindView(5208)
    ImageView ivCreateLabelIcon;

    @BindView(5362)
    LinearLayout llCreateLabelMoreSettingDetails;
    private boolean moreSettingDisplay = false;

    @BindView(6052)
    TextView tvCreateLabelContent;

    @BindView(6274)
    TextView tvTitle;

    @Override // com.library.base.frame.MvpActivity, com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initComponent() {
        super.initComponent();
        this.tvTitle.setText(getString(p113u.g.create_label));
        String str = (String) Hawk.get("defaultLabelSizeWidth", "40");
        String str2 = (String) Hawk.get("defaultLabelSizeHeight", "30");
        this.etCreateLabelWidth.setText(str);
        this.etCreateLabelHeight.setText(str2);
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initData() {
        super.initData();
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initListener() {
        super.initListener();
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public int layoutId() {
        return p113u.e.activity_create_label;
    }

    public void onCreateLabelMoreSettingClick(View view) {
        boolean z6 = this.moreSettingDisplay;
        this.moreSettingDisplay = !z6;
        if (z6) {
            this.llCreateLabelMoreSettingDetails.setVisibility(8);
            this.tvCreateLabelContent.setText(p113u.g.expand);
            this.ivCreateLabelIcon.setImageResource(p113u.f.ic_common_down_more);
        } else {
            this.llCreateLabelMoreSettingDetails.setVisibility(0);
            this.tvCreateLabelContent.setText(p113u.g.retract);
            this.ivCreateLabelIcon.setImageResource(p113u.f.ic_common_up_more);
        }
    }

    public void onCreateLabelNextClick(View view) {
        this.createLabelName = androidx.exifinterface.media.a.f(this.etCreateLabelName);
        this.createLabelWidth = androidx.exifinterface.media.a.f(this.etCreateLabelWidth);
        this.createLabelHeight = androidx.exifinterface.media.a.f(this.etCreateLabelHeight);
        this.createLabelColumns = androidx.exifinterface.media.a.f(this.etCreateLabelColumns);
        this.createLabelSpacing = androidx.exifinterface.media.a.f(this.etCreateLabelSpacing);
        if (Y.f(this.createLabelWidth) || Y.f(this.createLabelHeight)) {
            p042h2.d.show(p113u.g.please_enter_width_and_height);
            return;
        }
        Hawk.put("defaultLabelSizeWidth", this.createLabelWidth);
        Hawk.put("defaultLabelSizeHeight", this.createLabelHeight);
        TemplateConfigBean templateConfigBean = new TemplateConfigBean(Y.f(this.createLabelName) ? getString(p113u.g.text_400) : this.createLabelName, Integer.parseInt(this.createLabelWidth), Integer.parseInt(this.createLabelHeight), (Y.f(this.createLabelColumns) || Integer.parseInt(this.createLabelColumns) <= 0) ? 1 : Integer.parseInt(this.createLabelColumns), (Y.f(this.createLabelSpacing) || Integer.parseInt(this.createLabelSpacing) < 0) ? 2 : Integer.parseInt(this.createLabelSpacing));
        Bundle bundle = new Bundle();
        bundle.putSerializable("data_template_config", templateConfigBean);
        bundle.putString("personLabelId", String.valueOf(new Random().nextInt(Videoio.CAP_PVAPI) + 100) + System.currentTimeMillis() + String.valueOf(new Random().nextInt(Videoio.CAP_PVAPI) + 100));
        bundle.putString("cloudLabelId", String.valueOf(new Random().nextInt(Videoio.CAP_PVAPI) + 100) + System.currentTimeMillis() + String.valueOf(new Random().nextInt(Videoio.CAP_PVAPI) + 100));
        ARouter.getInstance().build(DefaultRouteConstant.ACTIVITY_PRINTER_TEMPLATE_EDIT).with(bundle).navigation();
        finish();
    }
}
