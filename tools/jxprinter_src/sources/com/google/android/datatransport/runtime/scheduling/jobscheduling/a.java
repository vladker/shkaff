package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.appdev.standard.dialog.E;
import com.google.firebase.crashlytics.internal.concurrency.CrashlyticsWorker;
import com.idlefish.flutterboost.containers.FlutterBoostFragment;
import io.flutter.plugins.firebase.crashlytics.FlutterFirebaseCrashlyticsPlugin;
import p102s.B;
import p113u.g;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3296a;

    public /* synthetic */ a(int i5) {
        this.f3296a = i5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3296a) {
            case 0:
                AlarmManagerSchedulerBroadcastReceiver.lambda$onReceive$0();
                break;
            case 1:
                CrashlyticsWorker.lambda$await$6();
                break;
            case 2:
                FlutterBoostFragment.lambda$onHiddenChanged$0();
                break;
            case 3:
                FlutterBoostFragment.lambda$setUserVisibleHint$1();
                break;
            case 4:
                FlutterFirebaseCrashlyticsPlugin.lambda$crash$1();
                break;
            case 5:
                E.a();
                break;
            case 6:
                p042h2.d.show(g.toast_2);
                E.a();
                break;
            case 7:
                E.a();
                break;
            case 8:
                B.a();
                break;
            default:
                B.b();
                break;
        }
    }
}
