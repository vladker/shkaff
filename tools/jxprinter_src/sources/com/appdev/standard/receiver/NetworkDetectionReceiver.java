package com.appdev.standard.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import p051j0.a;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class NetworkDetectionReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2839a = getClass().getSimpleName();

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        NetworkInfo networkInfo;
        if (!"android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction()) || (networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo")) == null) {
            return;
        }
        NetworkInfo.State state = NetworkInfo.State.CONNECTED;
        NetworkInfo.State state2 = networkInfo.getState();
        String str = "WIFI网络";
        String str2 = this.f2839a;
        if (state != state2 || !networkInfo.isAvailable()) {
            int type = networkInfo.getType();
            if (type == 0) {
                str = "手机网络数据";
            } else if (type != 1) {
                str = "";
            }
            a.k(str2, str.concat("断开"));
            return;
        }
        if (networkInfo.getType() == 1 || networkInfo.getType() == 0) {
            int type2 = networkInfo.getType();
            if (type2 == 0) {
                str = "手机网络数据";
            } else if (type2 != 1) {
                str = "";
            }
            a.k(str2, str.concat("连上"));
        }
    }
}
