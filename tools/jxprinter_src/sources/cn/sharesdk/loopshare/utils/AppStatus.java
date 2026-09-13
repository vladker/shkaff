package cn.sharesdk.loopshare.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Bundle;
import android.os.Process;
import com.mob.MobSDK;
import com.mob.tools.utils.ActivityTracker;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class AppStatus {
    private static volatile AppStatus b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2301a;
    private int c = -1;
    private int d = -1;
    private ActivityTracker.Tracker e = new ActivityTracker.Tracker() { // from class: cn.sharesdk.loopshare.utils.AppStatus.1
        @Override // com.mob.tools.utils.ActivityTracker.Tracker
        public void onCreated(Activity activity, Bundle bundle) {
            OnAppStatusListener onAppStatusListener = AppStatus.this.f2302f;
            if (onAppStatusListener != null) {
                onAppStatusListener.onCreated(activity, bundle);
            }
        }

        @Override // com.mob.tools.utils.ActivityTracker.Tracker
        public void onDestroyed(Activity activity) {
            OnAppStatusListener onAppStatusListener = AppStatus.this.f2302f;
            if (onAppStatusListener != null) {
                onAppStatusListener.onDestroyed(activity);
            }
        }

        @Override // com.mob.tools.utils.ActivityTracker.Tracker
        public void onPaused(Activity activity) {
            OnAppStatusListener onAppStatusListener = AppStatus.this.f2302f;
            if (onAppStatusListener != null) {
                onAppStatusListener.onPaused(activity);
            }
        }

        @Override // com.mob.tools.utils.ActivityTracker.Tracker
        public void onResumed(Activity activity) {
            AppStatus.this.b(false);
            OnAppStatusListener onAppStatusListener = AppStatus.this.f2302f;
            if (onAppStatusListener != null) {
                onAppStatusListener.onResumed(activity);
            }
        }

        @Override // com.mob.tools.utils.ActivityTracker.Tracker
        public void onSaveInstanceState(Activity activity, Bundle bundle) {
            OnAppStatusListener onAppStatusListener = AppStatus.this.f2302f;
            if (onAppStatusListener != null) {
                onAppStatusListener.onSaveInstanceState(activity, bundle);
            }
        }

        @Override // com.mob.tools.utils.ActivityTracker.Tracker
        public void onStarted(Activity activity) {
            OnAppStatusListener onAppStatusListener = AppStatus.this.f2302f;
            if (onAppStatusListener != null) {
                onAppStatusListener.onStarted(activity);
            }
        }

        @Override // com.mob.tools.utils.ActivityTracker.Tracker
        public void onStopped(Activity activity) {
            AppStatus.this.b(true);
            OnAppStatusListener onAppStatusListener = AppStatus.this.f2302f;
            if (onAppStatusListener != null) {
                onAppStatusListener.onStopped(activity);
            }
        }
    };

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private OnAppStatusListener f2302f;

    private AppStatus() {
        ActivityTracker.getInstance(MobSDK.getContext()).addTracker(this.e);
    }

    private void d() {
        if (f.a()) {
            this.c = 0;
        } else {
            this.c = 1;
            f.a(true);
        }
    }

    public boolean b() {
        if (-1 == this.c) {
            synchronized (this) {
                try {
                    if (-1 == this.c) {
                        d();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return 1 == this.c;
    }

    public int c() {
        int i5 = this.f2301a;
        if (i5 == 0) {
            int i6 = b() ? 1 : 2;
            this.f2301a = i6;
            return i6;
        }
        if (1 != i5 && 2 != i5) {
            return i5;
        }
        this.f2301a = 3;
        return 3;
    }

    public static AppStatus a() {
        if (b == null) {
            synchronized (AppStatus.class) {
                try {
                    if (b == null) {
                        b = new AppStatus();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z6) {
        boolean z7;
        int i5 = this.d;
        if (-1 == i5) {
            boolean zA = a(MobSDK.getContext());
            boolean z8 = !zA;
            this.d = zA ? 1 : 0;
            a(z8);
            return;
        }
        if ((1 == i5) == z6 || z6 == (z7 = !a(MobSDK.getContext()))) {
            return;
        }
        this.d = z6 ? 1 : 0;
        a(z7);
    }

    public void a(boolean z6) {
        OnAppStatusListener onAppStatusListener = this.f2302f;
        if (onAppStatusListener != null) {
            onAppStatusListener.onAppStatusChanged(z6);
        }
    }

    private boolean a(Context context) {
        boolean z6 = false;
        try {
            int iMyPid = Process.myPid();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == iMyPid) {
                    if (runningAppProcessInfo.importance != 100) {
                        break;
                    }
                    z6 = true;
                    break;
                }
            }
        } catch (Throwable th) {
            MobLinkLog.getInstance().d(th);
        }
        return !z6;
    }

    public void a(OnAppStatusListener onAppStatusListener) {
        this.f2302f = onAppStatusListener;
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static abstract class OnAppStatusListener implements ActivityTracker.Tracker {
        public abstract void onAppStatusChanged(boolean z6);

        @Override // com.mob.tools.utils.ActivityTracker.Tracker
        public void onDestroyed(Activity activity) {
        }

        @Override // com.mob.tools.utils.ActivityTracker.Tracker
        public void onPaused(Activity activity) {
        }

        @Override // com.mob.tools.utils.ActivityTracker.Tracker
        public void onResumed(Activity activity) {
        }

        @Override // com.mob.tools.utils.ActivityTracker.Tracker
        public void onStarted(Activity activity) {
        }

        @Override // com.mob.tools.utils.ActivityTracker.Tracker
        public void onStopped(Activity activity) {
        }

        @Override // com.mob.tools.utils.ActivityTracker.Tracker
        public void onSaveInstanceState(Activity activity, Bundle bundle) {
        }
    }
}
