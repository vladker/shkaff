package com.appdev.standard.page.bluetooth;

import S4.k;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import com.orhanobut.hawk.Hawk;
import org.greenrobot.eventbus.ThreadMode;
import p134x2.E;
import p137y.i;
import p137y.j;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class PrinterStateFrament extends com.library.base.frame.f {
    private boolean hasError = false;

    @BindView(5225)
    ImageView ivFragmentIndexPrinterState;

    @BindView(6102)
    TextView tvFragmentIndexPrinterState;

    private void applyDeviceState(j jVar) {
        if (jVar.b) {
            this.hasError = true;
            this.ivFragmentIndexPrinterState.setImageResource(p113u.f.icon_printer_error);
            this.tvFragmentIndexPrinterState.setText(getString(p113u.g.text_78));
            return;
        }
        if (jVar.f9015a) {
            this.hasError = true;
            this.ivFragmentIndexPrinterState.setImageResource(p113u.f.icon_printer_error);
            this.tvFragmentIndexPrinterState.setText(getString(p113u.g.text_79));
        } else if (jVar.d) {
            this.hasError = true;
            this.ivFragmentIndexPrinterState.setImageResource(p113u.f.icon_printer_error);
            this.tvFragmentIndexPrinterState.setText(getString(p113u.g.text_80));
        } else if (jVar.c) {
            this.hasError = true;
            this.ivFragmentIndexPrinterState.setImageResource(p113u.f.icon_printer_error);
            this.tvFragmentIndexPrinterState.setText(getString(p113u.g.text_81));
        } else {
            this.hasError = false;
            this.ivFragmentIndexPrinterState.setImageResource(p113u.f.icon_printer_normal);
            this.tvFragmentIndexPrinterState.setText(getString(p113u.g.text_82));
        }
    }

    @Override // com.library.base.frame.e
    public void initComponent() {
        registerEventBus();
        if (!E.n()) {
            this.ivFragmentIndexPrinterState.setImageResource(p113u.f.icon_printer_error);
            this.tvFragmentIndexPrinterState.setText(getString(p113u.g.text_181));
            return;
        }
        j jVar = (j) Hawk.get("LastDeviceState");
        if (jVar != null && (jVar.b || jVar.f9015a || jVar.d || jVar.c)) {
            applyDeviceState(jVar);
        } else {
            this.ivFragmentIndexPrinterState.setImageResource(p113u.f.icon_printer_normal);
            this.tvFragmentIndexPrinterState.setText(getString(p113u.g.text_82));
        }
    }

    @Override // com.library.base.frame.e
    public int layoutId() {
        return p113u.e.fragment_printer_state;
    }

    @k(threadMode = ThreadMode.MAIN)
    public void onDeviceEvent(i iVar) {
        int i5 = iVar.f9014a;
        if (i5 == 1) {
            if (this.hasError) {
                return;
            }
            this.ivFragmentIndexPrinterState.setImageResource(p113u.f.icon_printer_normal);
            this.tvFragmentIndexPrinterState.setText(getString(p113u.g.text_82));
            return;
        }
        if (i5 == 2 || i5 == 3 || i5 == 4 || i5 == 5) {
            this.hasError = false;
            this.ivFragmentIndexPrinterState.setImageResource(p113u.f.icon_printer_error);
            this.tvFragmentIndexPrinterState.setText(getString(p113u.g.text_181));
        }
    }

    @k(threadMode = ThreadMode.MAIN)
    public void onDeviceStateEvent(j jVar) {
        applyDeviceState(jVar);
    }

    @Override // com.library.base.frame.e
    public void refreshUI() {
    }
}
