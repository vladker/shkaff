package com.appdev.standard.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.appdev.standard.page.BootActivity;
import com.library.base.util.http.Http;
import kotlin.jvm.internal.Y;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class ServerSwitchDialog extends Dialog implements p143z.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p143z.b f2628a;

    @BindView(4919)
    TextView mBtnCancel;

    @BindView(4920)
    TextView mBtnConfirm;

    @BindView(5078)
    EditText mEtServerIp;

    @BindView(5079)
    EditText mEtServerPort;

    @BindView(6067)
    TextView mTvDialogTitle;

    public ServerSwitchDialog(@NonNull Context context) {
        super(context, p113u.h.Dialog);
        this.f2628a = null;
        setContentView(p113u.e.dialog_server_switch);
        ButterKnife.bind(this);
        this.f2628a = new p143z.b(context);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f2628a.b = this;
    }

    @OnClick({4919, 4920})
    public void onBtnClick(View view) {
        if (view.getId() == p113u.d.btn_cancel) {
            dismiss();
            return;
        }
        if (view.getId() == p113u.d.btn_confirm) {
            String strF = androidx.exifinterface.media.a.f(this.mEtServerIp);
            String strF2 = androidx.exifinterface.media.a.f(this.mEtServerPort);
            boolean zF = Y.f(strF);
            p143z.b bVar = this.f2628a;
            if (zF) {
                Object obj = bVar.b;
                if (obj != null) {
                    p042h2.d.a(bVar.getString(p113u.g.Please_enter_the_server_IP_address));
                    return;
                }
                return;
            }
            if (Y.f(strF2)) {
                Object obj2 = bVar.b;
                if (obj2 != null) {
                    p042h2.d.a(bVar.getString(p113u.g.Please_enter_the_server_port));
                    return;
                }
                return;
            }
            bVar.getClass();
            Http.initHttp("http://" + strF + ParameterizedMessage.ERROR_MSG_SEPARATOR + strF2 + "/api/");
            Object obj3 = bVar.b;
            if (obj3 != null) {
                ServerSwitchDialog serverSwitchDialog = (ServerSwitchDialog) ((p143z.a) obj3);
                serverSwitchDialog.dismiss();
                p042h2.d.show(p113u.g.Switch_server_successful);
                Intent intent = new Intent(serverSwitchDialog.getContext(), (Class<?>) BootActivity.class);
                intent.setFlags(268468224);
                serverSwitchDialog.getContext().startActivity(intent);
            }
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onDetachedFromWindow() {
        this.f2628a.b = null;
        super.onDetachedFromWindow();
    }
}
