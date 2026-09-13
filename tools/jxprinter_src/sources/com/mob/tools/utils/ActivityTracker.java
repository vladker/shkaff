package com.mob.tools.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.mob.tools.proguard.PublicMemberKeeper;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class ActivityTracker implements PublicMemberKeeper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ActivityTracker f3664a;
    private final Context b;

    public interface EachTracker extends PublicMemberKeeper {
        void each(Tracker tracker);
    }

    public interface Tracker extends PublicMemberKeeper {
        void onCreated(Activity activity, Bundle bundle);

        void onDestroyed(Activity activity);

        void onPaused(Activity activity);

        void onResumed(Activity activity);

        void onSaveInstanceState(Activity activity, Bundle bundle);

        void onStarted(Activity activity);

        void onStopped(Activity activity);
    }

    public static class a implements cn.fly.tools.utils.ActivityTracker.Tracker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Tracker f3665a;

        public a(Tracker tracker) {
            this.f3665a = tracker;
        }

        public static final cn.fly.tools.utils.ActivityTracker.Tracker a(Tracker tracker) {
            if (tracker != null) {
                return new a(tracker);
            }
            return null;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return Objects.equals(this.f3665a, ((a) obj).f3665a);
        }

        public int hashCode() {
            Tracker tracker = this.f3665a;
            return tracker != null ? tracker.hashCode() : super.hashCode();
        }

        @Override // cn.fly.tools.utils.ActivityTracker.Tracker
        public void onCreated(Activity activity, Bundle bundle) {
            this.f3665a.onCreated(activity, bundle);
        }

        @Override // cn.fly.tools.utils.ActivityTracker.Tracker
        public void onDestroyed(Activity activity) {
            this.f3665a.onDestroyed(activity);
        }

        @Override // cn.fly.tools.utils.ActivityTracker.Tracker
        public void onPaused(Activity activity) {
            this.f3665a.onPaused(activity);
        }

        @Override // cn.fly.tools.utils.ActivityTracker.Tracker
        public void onResumed(Activity activity) {
            this.f3665a.onResumed(activity);
        }

        @Override // cn.fly.tools.utils.ActivityTracker.Tracker
        public void onSaveInstanceState(Activity activity, Bundle bundle) {
            this.f3665a.onSaveInstanceState(activity, bundle);
        }

        @Override // cn.fly.tools.utils.ActivityTracker.Tracker
        public void onStarted(Activity activity) {
            this.f3665a.onStarted(activity);
        }

        @Override // cn.fly.tools.utils.ActivityTracker.Tracker
        public void onStopped(Activity activity) {
            this.f3665a.onStopped(activity);
        }
    }

    public ActivityTracker(Context context) {
        this.b = context;
    }

    public static synchronized ActivityTracker getInstance(Context context) {
        try {
            if (f3664a == null) {
                f3664a = new ActivityTracker(context);
            }
        } catch (Throwable th) {
            throw th;
        }
        return f3664a;
    }

    public void addTracker(Tracker tracker) {
        cn.fly.tools.utils.ActivityTracker.getInstance(this.b).addTracker(a.a(tracker));
    }

    public void removeTracker(Tracker tracker) {
        cn.fly.tools.utils.ActivityTracker.getInstance(this.b).removeTracker(a.a(tracker));
    }
}
