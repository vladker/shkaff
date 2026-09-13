package cn.fly.tools;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import cn.fly.commons.n;
import cn.fly.tools.utils.DH;
import cn.fly.tools.utils.ReflectHelper;
import com.alibaba.android.arouter.utils.Consts;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.apache.logging.log4j.util.ProcessIdUtil;

/* JADX INFO: loaded from: classes.dex */
public class FlyUIShell extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static HashMap<String, FakeActivity> f1593a = new HashMap<>();
    private FakeActivity b;

    static {
        FlyLog.getInstance().d("===============================", new Object[0]);
        FlyLog.getInstance().d(n.a("009^fabidddabibi.eKdggd") + "2026-07-23".replace("-0", ProcessIdUtil.DEFAULT_PROCESSID).replace(ProcessIdUtil.DEFAULT_PROCESSID, Consts.DOT), new Object[0]);
        FlyLog.getInstance().d("===============================", new Object[0]);
    }

    public static String a(Object obj) {
        return a(String.valueOf(System.currentTimeMillis()), obj);
    }

    private boolean b() {
        if (this.b == null) {
            Intent intent = getIntent();
            Uri data = intent.getData();
            if (data != null && n.a("005Obdbiddbebg").equals(data.getScheme())) {
                FakeActivity fakeActivityA = a(data.getHost());
                this.b = fakeActivityA;
                if (fakeActivityA != null) {
                    FlyLog.getInstance().i("MUIShell found executor: " + this.b.getClass());
                    this.b.setActivity(this);
                    return true;
                }
            }
            try {
                String stringExtra = intent.getStringExtra(n.a("011ebXbe:caf$bfEgObgbd=d"));
                String stringExtra2 = intent.getStringExtra(n.a("013dOcgSdaLbe7g<bibhbf.cbZbdEd"));
                FakeActivity fakeActivityRemove = f1593a.remove(stringExtra);
                this.b = fakeActivityRemove;
                if (fakeActivityRemove == null) {
                    FakeActivity fakeActivityRemove2 = f1593a.remove(intent.getScheme());
                    this.b = fakeActivityRemove2;
                    if (fakeActivityRemove2 == null) {
                        FakeActivity fakeActivityA2 = a();
                        this.b = fakeActivityA2;
                        if (fakeActivityA2 == null) {
                            FlyLog.getInstance().w(new RuntimeException(androidx.exifinterface.media.a.m("Executor lost! launchTime = ", stringExtra, ", executorName: ", stringExtra2)));
                            return false;
                        }
                    }
                }
                FlyLog.getInstance().i("MUIShell found executor: " + this.b.getClass());
                this.b.setActivity(this);
            } catch (Throwable th) {
                FlyLog.getInstance().w(th);
                return false;
            }
        }
        return true;
    }

    private boolean c() {
        if (DH.SyncMtd.getOSVersionIntForFly() > 27) {
            return false;
        }
        try {
            Field declaredField = Activity.class.getDeclaredField(n.a("0139bddb>agNbgbbbg@gWcaccXc%cdbi"));
            declaredField.setAccessible(true);
            ((ActivityInfo) declaredField.get(this)).screenOrientation = -1;
            declaredField.setAccessible(false);
            return true;
        } catch (Exception e) {
            FlyLog.getInstance().w(e, "Fix orientation for 8.0 encountered exception", new Object[0]);
            return false;
        }
    }

    private boolean d() {
        boolean z6 = false;
        if (DH.SyncMtd.getOSVersionIntForFly() > 27) {
            return false;
        }
        try {
            TypedArray typedArrayObtainStyledAttributes = this.b.activity.obtainStyledAttributes((int[]) Class.forName("com.android.internal.R$styleable").getField("Window").get(null));
            Method method = ActivityInfo.class.getMethod(n.a("023%bgdgdabhRbc-dgWe2be(adcg%efbheaMeFbi=bg%bgKcNch"), TypedArray.class);
            method.setAccessible(true);
            boolean zBooleanValue = ((Boolean) method.invoke(null, typedArrayObtainStyledAttributes)).booleanValue();
            try {
                method.setAccessible(false);
                return zBooleanValue;
            } catch (Exception e) {
                e = e;
                z6 = zBooleanValue;
                FlyLog.getInstance().w(e);
                return z6;
            }
        } catch (Exception e6) {
            e = e6;
        }
    }

    @Override // android.app.Activity
    public void finish() {
        FakeActivity fakeActivity = this.b;
        if (fakeActivity == null || !fakeActivity.onFinish()) {
            super.finish();
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int i5, int i6, Intent intent) {
        FakeActivity fakeActivity = this.b;
        if (fakeActivity != null) {
            fakeActivity.onActivityResult(i5, i6, intent);
        }
        super.onActivityResult(i5, i6, intent);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        FakeActivity fakeActivity = this.b;
        if (fakeActivity != null) {
            fakeActivity.onConfigurationChanged(configuration);
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        if (!b()) {
            super.onCreate(bundle);
            finish();
            return;
        }
        FlyLog.getInstance().d(this.b.getClass().getSimpleName().concat(" onCreate"), new Object[0]);
        if (DH.SyncMtd.getOSVersionIntForFly() == 26 && d()) {
            c();
        }
        if (DH.SyncMtd.getOSVersionIntForFly() >= 21) {
            this.b.activity.getWindow().addFlags(Integer.MIN_VALUE);
            if (DH.SyncMtd.getOSVersionIntForFly() < 35) {
                try {
                    ReflectHelper.invokeInstanceMethod(this.b.activity.getWindow(), "setStatusBarColor", new Object[]{0}, new Class[]{Integer.TYPE});
                } catch (Throwable unused) {
                }
            }
        }
        super.onCreate(bundle);
        this.b.onCreate();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        boolean zOnCreateOptionsMenu = super.onCreateOptionsMenu(menu);
        FakeActivity fakeActivity = this.b;
        return fakeActivity != null ? fakeActivity.onCreateOptionsMenu(menu) : zOnCreateOptionsMenu;
    }

    @Override // android.app.Activity
    public void onDestroy() {
        FakeActivity fakeActivity = this.b;
        if (fakeActivity != null) {
            fakeActivity.sendResult();
            FlyLog.getInstance().d(this.b.getClass().getSimpleName().concat(" onDestroy"), new Object[0]);
            this.b.onDestroy();
        }
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i5, KeyEvent keyEvent) {
        try {
            FakeActivity fakeActivity = this.b;
            if (fakeActivity != null ? fakeActivity.onKeyEvent(i5, keyEvent) : false) {
                return true;
            }
            return super.onKeyDown(i5, keyEvent);
        } catch (Throwable th) {
            FlyLog.getInstance().w(th);
            return false;
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i5, KeyEvent keyEvent) {
        try {
            FakeActivity fakeActivity = this.b;
            if (fakeActivity != null ? fakeActivity.onKeyEvent(i5, keyEvent) : false) {
                return true;
            }
            return super.onKeyUp(i5, keyEvent);
        } catch (Throwable th) {
            FlyLog.getInstance().w(th);
            return false;
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        FakeActivity fakeActivity = this.b;
        if (fakeActivity == null) {
            super.onNewIntent(intent);
        } else {
            fakeActivity.onNewIntent(intent);
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        boolean zOnOptionsItemSelected = super.onOptionsItemSelected(menuItem);
        FakeActivity fakeActivity = this.b;
        return fakeActivity != null ? fakeActivity.onOptionsItemSelected(menuItem) : zOnOptionsItemSelected;
    }

    @Override // android.app.Activity
    public void onPause() {
        if (this.b != null) {
            FlyLog.getInstance().d(this.b.getClass().getSimpleName().concat(" onPause"), new Object[0]);
            this.b.onPause();
        }
        super.onPause();
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i5, String[] strArr, int[] iArr) {
        FakeActivity fakeActivity = this.b;
        if (fakeActivity != null) {
            fakeActivity.onRequestPermissionsResult(i5, strArr, iArr);
        }
    }

    @Override // android.app.Activity
    public void onRestart() {
        if (this.b != null) {
            FlyLog.getInstance().d(this.b.getClass().getSimpleName().concat(" onRestart"), new Object[0]);
            this.b.onRestart();
        }
        super.onRestart();
    }

    @Override // android.app.Activity
    public void onResume() {
        if (this.b != null) {
            FlyLog.getInstance().d(this.b.getClass().getSimpleName().concat(" onResume"), new Object[0]);
            this.b.onResume();
        }
        super.onResume();
    }

    @Override // android.app.Activity
    public void onStart() {
        if (this.b != null) {
            FlyLog.getInstance().d(this.b.getClass().getSimpleName().concat(" onStart"), new Object[0]);
            this.b.onStart();
        }
        super.onStart();
    }

    @Override // android.app.Activity
    public void onStop() {
        if (this.b != null) {
            FlyLog.getInstance().d(this.b.getClass().getSimpleName().concat(" onStop"), new Object[0]);
            this.b.onStop();
        }
        super.onStop();
    }

    @Override // android.app.Activity
    public void setContentView(int i5) {
        setContentView(LayoutInflater.from(this).inflate(i5, (ViewGroup) null));
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int i5) {
        if (DH.SyncMtd.getOSVersionIntForFly() == 26 && d()) {
            return;
        }
        super.setRequestedOrientation(i5);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final void setTheme(int i5) {
        if (b()) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            int i6 = 0;
            while (i6 < stackTrace.length) {
                if (stackTrace[i6].toString().startsWith(n.a("030$fe9bJbb<bBbj:ebcYchbjdaGfIbh dbXbabjchFdg*cj8gba=cfdabh!bad")) && (i6 = i6 + 2) < stackTrace.length) {
                    int iOnSetTheme = this.b.onSetTheme(i5, stackTrace[i6].toString().startsWith(n.a("048bc+babhbibgbabj7bhh?bjdb4ag bgbbbgWgMcadaUf!bh.db(babjZhd0bhcdbibhbddc)b%be^caf@db(agAbgbbbgUg3ca")));
                    if (iOnSetTheme > 0) {
                        super.setTheme(iOnSetTheme);
                        return;
                    }
                    return;
                }
                i6++;
            }
        }
        super.setTheme(i5);
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i5) {
        FakeActivity fakeActivity = this.b;
        if (fakeActivity != null) {
            fakeActivity.beforeStartActivityForResult(intent, i5, null);
        }
        super.startActivityForResult(intent, i5);
    }

    public static String a(String str, Object obj) {
        f1593a.put(str, (FakeActivity) obj);
        return str;
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        if (view == null) {
            return;
        }
        super.setContentView(view);
        FakeActivity fakeActivity = this.b;
        if (fakeActivity != null) {
            fakeActivity.setContentView(view);
        }
    }

    private FakeActivity a(String str) {
        Object objNewInstance;
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (str.startsWith(Consts.DOT)) {
                str = getPackageName() + str;
            }
            String strImportClass = ReflectHelper.importClass(str);
            if (TextUtils.isEmpty(strImportClass) || (objNewInstance = ReflectHelper.newInstance(strImportClass, new Object[0])) == null || !(objNewInstance instanceof FakeActivity)) {
                return null;
            }
            return (FakeActivity) objNewInstance;
        } catch (Throwable th) {
            FlyLog.getInstance().w(th);
            return null;
        }
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i5, Bundle bundle) {
        FakeActivity fakeActivity = this.b;
        if (fakeActivity != null) {
            fakeActivity.beforeStartActivityForResult(intent, i5, bundle);
        }
        if (DH.SyncMtd.getOSVersionIntForFly() >= 16) {
            super.startActivityForResult(intent, i5, bundle);
        } else {
            super.startActivityForResult(intent, i5);
        }
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        if (view == null) {
            return;
        }
        if (layoutParams == null) {
            super.setContentView(view);
        } else {
            super.setContentView(view, layoutParams);
        }
        FakeActivity fakeActivity = this.b;
        if (fakeActivity != null) {
            fakeActivity.setContentView(view);
        }
    }

    public FakeActivity a() {
        String string;
        try {
            string = getPackageManager().getActivityInfo(getComponentName(), 128).metaData.getString(n.a("015BbaWd5cd2b6be+eg3dbFagKbgbbbg[gBca"));
        } catch (Throwable th) {
            FlyLog.getInstance().w(th);
            string = null;
        }
        return a(string);
    }
}
