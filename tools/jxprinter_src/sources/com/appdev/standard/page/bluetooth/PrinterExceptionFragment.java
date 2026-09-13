package com.appdev.standard.page.bluetooth;

import S4.k;
import android.widget.LinearLayout;
import butterknife.BindView;
import com.orhanobut.hawk.Hawk;
import org.greenrobot.eventbus.ThreadMode;
import p137y.j;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class PrinterExceptionFragment extends com.library.base.frame.f {

    @BindView(5475)
    LinearLayout ll_cutter_error;

    @BindView(5477)
    LinearLayout ll_open_the_lid;

    @BindView(5478)
    LinearLayout ll_out_of_paper;

    @BindView(5479)
    LinearLayout ll_over_heart;

    @BindView(5476)
    LinearLayout ll_printer_exception;

    @Override // com.library.base.frame.e
    public void initComponent() {
        registerEventBus();
        this.ll_printer_exception.setVisibility(8);
        this.ll_out_of_paper.setVisibility(8);
        this.ll_open_the_lid.setVisibility(8);
        this.ll_over_heart.setVisibility(8);
        this.ll_cutter_error.setVisibility(8);
        j jVar = (j) Hawk.get("LastDeviceState", null);
        if (jVar != null) {
            onDeviceStateEvent(jVar);
        }
    }

    @Override // com.library.base.frame.e
    public int layoutId() {
        return p113u.e.fragment_printer_exception;
    }

    @k(threadMode = ThreadMode.MAIN)
    public void onDeviceStateEvent(j jVar) {
        if (jVar.b) {
            this.ll_printer_exception.setVisibility(0);
            this.ll_out_of_paper.setVisibility(0);
            return;
        }
        if (jVar.f9015a) {
            this.ll_printer_exception.setVisibility(0);
            this.ll_open_the_lid.setVisibility(0);
            return;
        }
        if (jVar.d) {
            this.ll_printer_exception.setVisibility(0);
            this.ll_over_heart.setVisibility(0);
        } else {
            if (jVar.c) {
                this.ll_printer_exception.setVisibility(0);
                this.ll_cutter_error.setVisibility(0);
                return;
            }
            this.ll_printer_exception.setVisibility(8);
            this.ll_out_of_paper.setVisibility(8);
            this.ll_open_the_lid.setVisibility(8);
            this.ll_over_heart.setVisibility(8);
            this.ll_cutter_error.setVisibility(8);
        }
    }

    @Override // com.library.base.frame.e
    public void refreshUI() {
    }
}
