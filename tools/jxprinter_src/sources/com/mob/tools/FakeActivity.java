package com.mob.tools;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.mob.tools.proguard.EverythingKeeper;
import com.mob.tools.utils.DH;
import com.mob.tools.utils.ReflectHelper;
import com.mob.tools.utils.ResHelper;
import com.mob.tools.utils.UIHandler;
import java.lang.reflect.Method;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public class FakeActivity implements EverythingKeeper {
    private static Class<? extends Activity> shellClass;
    protected Activity activity;
    private View contentView;
    private HashMap<String, Object> result;
    private FakeActivity resultReceiver;

    public static void registerExecutor(String str, Object obj) {
        Class<? extends Activity> cls = shellClass;
        if (cls == null) {
            MobUIShell.a(str, obj);
            return;
        }
        try {
            Method method = cls.getMethod("registerExecutor", String.class, Object.class);
            method.setAccessible(true);
            method.invoke(null, str, obj);
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
        }
    }

    public static void setShell(Class<? extends Activity> cls) {
        shellClass = cls;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showActivity(final Context context, final Intent intent) {
        if (context instanceof Activity) {
            context.startActivity(intent);
        } else {
            DH.requester(context).getTopActivity().request(new DH.DHResponder() { // from class: com.mob.tools.FakeActivity.2
                @Override // com.mob.tools.utils.DH.DHResponder
                public void onResponse(DH.DHResponse dHResponse) {
                    Activity topActivity = dHResponse.getTopActivity();
                    if (topActivity != null) {
                        topActivity.startActivity(intent);
                    } else {
                        intent.addFlags(268435456);
                        context.startActivity(intent);
                    }
                }
            });
        }
    }

    public boolean disableScreenCapture() {
        Activity activity = this.activity;
        if (activity == null) {
            return false;
        }
        activity.getWindow().setFlags(8192, 8192);
        return true;
    }

    public <T extends View> T findViewById(int i5) {
        Activity activity = this.activity;
        if (activity == null) {
            return null;
        }
        return (T) activity.findViewById(i5);
    }

    public <T extends View> T findViewByResName(View view, String str) {
        int idRes;
        Activity activity = this.activity;
        if (activity != null && (idRes = ResHelper.getIdRes(activity, str)) > 0) {
            return (T) view.findViewById(idRes);
        }
        return null;
    }

    public final void finish() {
        Activity activity = this.activity;
        if (activity != null) {
            activity.finish();
        }
    }

    public View getContentView() {
        return this.contentView;
    }

    public Context getContext() {
        return this.activity;
    }

    public int getOrientation() {
        return this.activity.getResources().getConfiguration().orientation;
    }

    public FakeActivity getParent() {
        return this.resultReceiver;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    public boolean onFinish() {
        return false;
    }

    public boolean onKeyEvent(int i5, KeyEvent keyEvent) {
        return false;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return false;
    }

    public void requestFullScreen(boolean z6) {
        Activity activity = this.activity;
        if (activity == null) {
            return;
        }
        if (z6) {
            activity.getWindow().addFlags(1024);
            this.activity.getWindow().clearFlags(2048);
        } else {
            activity.getWindow().addFlags(2048);
            this.activity.getWindow().clearFlags(1024);
        }
        this.activity.getWindow().getDecorView().requestLayout();
    }

    public void requestLandscapeOrientation() {
        setRequestedOrientation(0);
    }

    public void requestPermissions(String[] strArr, int i5) {
        Activity activity = this.activity;
        if (activity == null) {
            return;
        }
        ReflectHelper.invokeInstanceMethod(activity, "requestPermissions", new Object[]{strArr, Integer.valueOf(i5)}, new Class[]{String.class, Integer.TYPE}, null);
    }

    public void requestPortraitOrientation() {
        setRequestedOrientation(1);
    }

    public void requestSensorLandscapeOrientation() {
        setRequestedOrientation(6);
    }

    public void requestSensorPortraitOrientation() {
        setRequestedOrientation(7);
    }

    public void runOnUIThread(final Runnable runnable) {
        UIHandler.sendEmptyMessage(0, new Handler.Callback() { // from class: com.mob.tools.FakeActivity.3
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                runnable.run();
                return false;
            }
        });
    }

    public void sendResult() {
        FakeActivity fakeActivity = this.resultReceiver;
        if (fakeActivity != null) {
            fakeActivity.onResult(this.result);
        }
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public void setContentView(View view) {
        this.contentView = view;
    }

    public void setContentViewLayoutResName(String str) {
        int layoutRes;
        Activity activity = this.activity;
        if (activity != null && (layoutRes = ResHelper.getLayoutRes(activity, str)) > 0) {
            this.activity.setContentView(layoutRes);
        }
    }

    public void setRequestedOrientation(int i5) {
        if (this.activity != null && getContext().getApplicationInfo().targetSdkVersion < 27) {
            this.activity.setRequestedOrientation(i5);
        }
    }

    public final void setResult(HashMap<String, Object> map) {
        this.result = map;
    }

    public void show(Context context, Intent intent) {
        showForResult(context, intent, null);
    }

    public void showForResult(final Context context, Intent intent, FakeActivity fakeActivity) {
        final Intent intent2;
        String strA;
        this.resultReceiver = fakeActivity;
        if (shellClass != null) {
            intent2 = new Intent(context, shellClass);
            strA = null;
            try {
                Method method = shellClass.getMethod("registerExecutor", Object.class);
                method.setAccessible(true);
                strA = (String) method.invoke(null, this);
            } catch (Throwable th) {
                MobLog.getInstance().w(th);
            }
        } else {
            intent2 = new Intent(context, (Class<?>) MobUIShell.class);
            strA = MobUIShell.a(this);
        }
        intent2.putExtra("launch_time", strA);
        intent2.putExtra("executor_name", getClass().getName());
        if (intent != null) {
            intent2.putExtras(intent);
        }
        if (Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId()) {
            showActivity(context, intent2);
        } else {
            UIHandler.sendEmptyMessage(0, new Handler.Callback() { // from class: com.mob.tools.FakeActivity.1
                @Override // android.os.Handler.Callback
                public boolean handleMessage(Message message) {
                    FakeActivity.this.showActivity(context, intent2);
                    return false;
                }
            });
        }
    }

    public void startActivity(Intent intent) {
        startActivityForResult(intent, -1);
    }

    public void startActivityForResult(Intent intent, int i5) {
        Activity activity = this.activity;
        if (activity == null) {
            return;
        }
        activity.startActivityForResult(intent, i5);
    }

    public void runOnUIThread(final Runnable runnable, long j6) {
        UIHandler.sendEmptyMessageDelayed(0, j6, new Handler.Callback() { // from class: com.mob.tools.FakeActivity.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                runnable.run();
                return false;
            }
        });
    }

    public <T extends View> T findViewByResName(String str) {
        int idRes;
        Activity activity = this.activity;
        if (activity != null && (idRes = ResHelper.getIdRes(activity, str)) > 0) {
            return (T) findViewById(idRes);
        }
        return null;
    }

    public void onCreate() {
    }

    public void onDestroy() {
    }

    public void onPause() {
    }

    public void onRestart() {
    }

    public void onResume() {
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onNewIntent(Intent intent) {
    }

    public void onResult(HashMap<String, Object> map) {
    }

    public int onSetTheme(int i5, boolean z6) {
        return i5;
    }

    public void beforeStartActivityForResult(Intent intent, int i5, Bundle bundle) {
    }

    public void onActivityResult(int i5, int i6, Intent intent) {
    }

    public void onRequestPermissionsResult(int i5, String[] strArr, int[] iArr) {
    }
}
