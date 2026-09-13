package cn.fly.tcp;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import cn.fly.tools.utils.ActivityTracker;

/* JADX INFO: loaded from: classes.dex */
public class c {
    public static ActivityTracker.Tracker a(final a aVar) {
        return new ActivityTracker.Tracker() { // from class: cn.fly.tcp.Tmpc$1
            private long b;
            private String c;

            @Override // cn.fly.tools.utils.ActivityTracker.Tracker
            public void onResumed(Activity activity) {
                try {
                    if (this.b == 0) {
                        this.b = SystemClock.elapsedRealtime();
                        aVar.a();
                    }
                    this.c = activity == null ? null : activity.toString();
                } catch (Throwable unused) {
                }
            }

            @Override // cn.fly.tools.utils.ActivityTracker.Tracker
            public void onStopped(Activity activity) {
                try {
                    String str = this.c;
                    if (str != null) {
                        if (!str.equals(activity == null ? null : activity.toString())) {
                            return;
                        }
                    }
                    this.b = 0L;
                    this.c = null;
                    aVar.b();
                } catch (Throwable unused) {
                }
            }

            @Override // cn.fly.tools.utils.ActivityTracker.Tracker
            public void onDestroyed(Activity activity) {
            }

            @Override // cn.fly.tools.utils.ActivityTracker.Tracker
            public void onPaused(Activity activity) {
            }

            @Override // cn.fly.tools.utils.ActivityTracker.Tracker
            public void onStarted(Activity activity) {
            }

            @Override // cn.fly.tools.utils.ActivityTracker.Tracker
            public void onCreated(Activity activity, Bundle bundle) {
            }

            @Override // cn.fly.tools.utils.ActivityTracker.Tracker
            public void onSaveInstanceState(Activity activity, Bundle bundle) {
            }
        };
    }

    public static class a {
        public void a() {
        }

        public void b() {
        }
    }
}
