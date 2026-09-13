package com.appdev.standard.page.printerlabel;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import com.appdev.standard.page.printerlabel.widget.QuantitySelectorWidget;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class PicturePrintActivity_ViewBinding implements Unbinder {
    private PicturePrintActivity target;

    @UiThread
    public PicturePrintActivity_ViewBinding(PicturePrintActivity picturePrintActivity) {
        this(picturePrintActivity, picturePrintActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        PicturePrintActivity picturePrintActivity = this.target;
        if (picturePrintActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        picturePrintActivity.tvTitle = null;
        picturePrintActivity.rvPicturePrintData = null;
        picturePrintActivity.qswPdfPrintPrintWidth = null;
        picturePrintActivity.qswPdfPrintPrintHeight = null;
        picturePrintActivity.rbPicturePrintScaleTypeFitXY = null;
        picturePrintActivity.rbPicturePrintScaleTypeCenterInside = null;
        picturePrintActivity.rbPicturePrintNoMirror = null;
        picturePrintActivity.rbPicturePrintMirror = null;
        picturePrintActivity.rbPicturePrintText = null;
        picturePrintActivity.rbPicturePrintImageText = null;
        picturePrintActivity.rbPicturePrintAuto = null;
        picturePrintActivity.qswPicturePrintPrintCount = null;
        picturePrintActivity.qswPicturePrintPrintStart = null;
        picturePrintActivity.qswPicturePrintPrintEnd = null;
        picturePrintActivity.llRange = null;
        picturePrintActivity.rbPicturePrintRotate0 = null;
        picturePrintActivity.rbPicturePrintRotate90 = null;
        picturePrintActivity.llRotate = null;
        picturePrintActivity.ivNoMirror = null;
        picturePrintActivity.ivMirror = null;
    }

    @UiThread
    public PicturePrintActivity_ViewBinding(PicturePrintActivity picturePrintActivity, View view) {
        this.target = picturePrintActivity;
        picturePrintActivity.tvTitle = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_title, "field 'tvTitle'", TextView.class);
        picturePrintActivity.rvPicturePrintData = (RecyclerView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.rv_picture_print_data, "field 'rvPicturePrintData'", RecyclerView.class);
        picturePrintActivity.qswPdfPrintPrintWidth = (QuantitySelectorWidget) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.qsw_pdf_print_print_width, "field 'qswPdfPrintPrintWidth'", QuantitySelectorWidget.class);
        picturePrintActivity.qswPdfPrintPrintHeight = (QuantitySelectorWidget) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.qsw_pdf_print_print_height, "field 'qswPdfPrintPrintHeight'", QuantitySelectorWidget.class);
        picturePrintActivity.rbPicturePrintScaleTypeFitXY = (RadioButton) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.rb_picture_print_scale_type_fitXY, "field 'rbPicturePrintScaleTypeFitXY'", RadioButton.class);
        picturePrintActivity.rbPicturePrintScaleTypeCenterInside = (RadioButton) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.rb_picture_print_scale_type_centerInside, "field 'rbPicturePrintScaleTypeCenterInside'", RadioButton.class);
        picturePrintActivity.rbPicturePrintNoMirror = (RadioButton) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.rb_picture_print_no_mirror, "field 'rbPicturePrintNoMirror'", RadioButton.class);
        picturePrintActivity.rbPicturePrintMirror = (RadioButton) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.rb_picture_print_mirror, "field 'rbPicturePrintMirror'", RadioButton.class);
        picturePrintActivity.rbPicturePrintText = (RadioButton) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.rb_picture_print_text_mode, "field 'rbPicturePrintText'", RadioButton.class);
        picturePrintActivity.rbPicturePrintImageText = (RadioButton) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.rb_picture_print_image_text_mode, "field 'rbPicturePrintImageText'", RadioButton.class);
        picturePrintActivity.rbPicturePrintAuto = (RadioButton) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.rb_picture_print_auto_mode, "field 'rbPicturePrintAuto'", RadioButton.class);
        picturePrintActivity.qswPicturePrintPrintCount = (QuantitySelectorWidget) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.qsw_picture_print_print_count, "field 'qswPicturePrintPrintCount'", QuantitySelectorWidget.class);
        picturePrintActivity.qswPicturePrintPrintStart = (QuantitySelectorWidget) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.qsw_picture_print_print_start, "field 'qswPicturePrintPrintStart'", QuantitySelectorWidget.class);
        picturePrintActivity.qswPicturePrintPrintEnd = (QuantitySelectorWidget) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.qsw_picture_print_print_end, "field 'qswPicturePrintPrintEnd'", QuantitySelectorWidget.class);
        picturePrintActivity.llRange = (LinearLayout) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.ll_range, "field 'llRange'", LinearLayout.class);
        picturePrintActivity.rbPicturePrintRotate0 = (RadioButton) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.rb_picture_print_rotate_0, "field 'rbPicturePrintRotate0'", RadioButton.class);
        picturePrintActivity.rbPicturePrintRotate90 = (RadioButton) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.rb_picture_print_rotate_90, "field 'rbPicturePrintRotate90'", RadioButton.class);
        picturePrintActivity.llRotate = (LinearLayout) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.ll_rotate, "field 'llRotate'", LinearLayout.class);
        picturePrintActivity.ivNoMirror = (ImageView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.iv_pic_print_no_mirror, "field 'ivNoMirror'", ImageView.class);
        picturePrintActivity.ivMirror = (ImageView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.iv_pic_print_mirror, "field 'ivMirror'", ImageView.class);
    }
}
