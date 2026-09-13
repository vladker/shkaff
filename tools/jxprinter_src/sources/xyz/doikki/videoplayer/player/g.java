package xyz.doikki.videoplayer.player;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.TypedArray;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public class g extends FrameLayout implements xyz.doikki.videoplayer.controller.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f8995a;
    public h b;
    public final FrameLayout c;
    public E5.d d;
    public E5.c e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f8996f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int[] f8997g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f8998h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f8999i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public AssetFileDescriptor f9000j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f9001k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f9002l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f9003m;

    @Nullable
    protected e mAudioFocusHelper;

    @Nullable
    protected i mProgressManager;

    @Nullable
    protected xyz.doikki.videoplayer.controller.b mVideoController;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f9004n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f9005o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ArrayList f9006p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f9007q;

    public g(@NonNull Context context) {
        this(context, null);
    }

    @Override // xyz.doikki.videoplayer.controller.h
    public final void a(boolean z6) {
        if (z6) {
            this.f9001k = 0L;
        }
        b();
        j(true);
    }

    public void addOnStateChangeListener(@NonNull f fVar) {
        if (this.f9006p == null) {
            this.f9006p = new ArrayList();
        }
        this.f9006p.add(fVar);
    }

    public final void b() {
        E5.d dVar = this.d;
        if (dVar != null) {
            this.c.removeView(dVar.getView());
            E5.d dVar2 = this.d;
            Surface surface = dVar2.c;
            if (surface != null) {
                surface.release();
            }
            SurfaceTexture surfaceTexture = dVar2.b;
            if (surfaceTexture != null) {
                surfaceTexture.release();
            }
        }
        E5.c cVar = this.e;
        Context context = getContext();
        ((E5.e) cVar).getClass();
        E5.d dVar3 = new E5.d(context);
        this.d = dVar3;
        dVar3.attachToPlayer(this.f8995a);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1, 17);
        this.c.addView(this.d.getView(), 0, layoutParams);
    }

    @Override // xyz.doikki.videoplayer.controller.h
    public final void c() {
        ViewGroup decorView;
        if (this.f9004n && (decorView = getDecorView()) != null) {
            this.f9004n = false;
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() & (-4099));
            getActivity().getWindow().clearFlags(1024);
            decorView.removeView(this.c);
            addView(this.c);
            setPlayerState(10);
        }
    }

    public final boolean d() {
        int i5;
        return (this.f8995a == null || (i5 = this.f9002l) == -1 || i5 == 0 || i5 == 1 || i5 == 8 || i5 == 5) ? false : true;
    }

    @Override // xyz.doikki.videoplayer.controller.h
    public final boolean e() {
        return this.f9004n;
    }

    public final void f() {
        this.c.setKeepScreenOn(false);
        setPlayState(-1);
    }

    public final void g(int i5, int i6) {
        if (i5 == 3) {
            setPlayState(3);
            this.c.setKeepScreenOn(true);
            return;
        }
        if (i5 == 10001) {
            E5.d dVar = this.d;
            if (dVar != null) {
                dVar.setVideoRotation(i6);
                return;
            }
            return;
        }
        if (i5 == 701) {
            setPlayState(6);
        } else {
            if (i5 != 702) {
                return;
            }
            setPlayState(7);
        }
    }

    public Activity getActivity() {
        xyz.doikki.videoplayer.controller.b bVar = this.mVideoController;
        if (bVar == null) {
            return F5.c.d(getContext());
        }
        Activity activityD = F5.c.d(bVar.getContext());
        return activityD == null ? F5.c.d(getContext()) : activityD;
    }

    @Override // xyz.doikki.videoplayer.controller.h
    public int getBufferedPercentage() {
        c cVar = this.f8995a;
        if (cVar != null) {
            return cVar.c;
        }
        return 0;
    }

    public ViewGroup getContentView() {
        Activity activity = getActivity();
        if (activity == null) {
            return null;
        }
        return (ViewGroup) activity.findViewById(R.id.content);
    }

    public int getCurrentPlayState() {
        return this.f9002l;
    }

    public int getCurrentPlayerState() {
        return this.f9003m;
    }

    @Override // xyz.doikki.videoplayer.controller.h
    public long getCurrentPosition() {
        if (!d()) {
            return 0L;
        }
        long currentPosition = this.f8995a.b.getCurrentPosition();
        this.f9001k = currentPosition;
        return currentPosition;
    }

    public ViewGroup getDecorView() {
        Activity activity = getActivity();
        if (activity == null) {
            return null;
        }
        return (ViewGroup) activity.getWindow().getDecorView();
    }

    @Override // xyz.doikki.videoplayer.controller.h
    public long getDuration() {
        if (d()) {
            return this.f8995a.b.getDuration();
        }
        return 0L;
    }

    @Override // xyz.doikki.videoplayer.controller.h
    public float getSpeed() {
        if (!d()) {
            return 1.0f;
        }
        c cVar = this.f8995a;
        cVar.getClass();
        try {
            float speed = cVar.b.getPlaybackParams().getSpeed();
            if (speed == 0.0f) {
                return 1.0f;
            }
            return speed;
        } catch (Exception unused) {
            return 1.0f;
        }
    }

    public long getTcpSpeed() {
        return 0L;
    }

    public int[] getVideoSize() {
        return this.f8997g;
    }

    @Override // xyz.doikki.videoplayer.controller.h
    public final boolean h() {
        return d() && this.f8995a.b.isPlaying();
    }

    public final void i() {
        if (this.f9002l == 0) {
            return;
        }
        c cVar = this.f8995a;
        if (cVar != null) {
            cVar.b.setOnErrorListener(null);
            cVar.b.setOnCompletionListener(null);
            cVar.b.setOnInfoListener(null);
            cVar.b.setOnBufferingUpdateListener(null);
            cVar.b.setOnPreparedListener(null);
            cVar.b.setOnVideoSizeChangedListener(null);
            try {
                cVar.b.stop();
            } catch (IllegalStateException unused) {
                cVar.f8991a.f();
            }
            MediaPlayer mediaPlayer = cVar.b;
            cVar.b = null;
            new b(mediaPlayer).start();
            this.f8995a = null;
        }
        E5.d dVar = this.d;
        if (dVar != null) {
            this.c.removeView(dVar.getView());
            E5.d dVar2 = this.d;
            Surface surface = dVar2.c;
            if (surface != null) {
                surface.release();
            }
            SurfaceTexture surfaceTexture = dVar2.b;
            if (surfaceTexture != null) {
                surfaceTexture.release();
            }
            this.d = null;
        }
        AssetFileDescriptor assetFileDescriptor = this.f9000j;
        if (assetFileDescriptor != null) {
            try {
                assetFileDescriptor.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        e eVar = this.mAudioFocusHelper;
        if (eVar != null) {
            AudioManager audioManager = eVar.c;
            if (audioManager != null) {
                eVar.d = false;
                audioManager.abandonAudioFocus(eVar);
            }
            this.mAudioFocusHelper = null;
        }
        this.c.setKeepScreenOn(false);
        this.f9001k = 0L;
        setPlayState(0);
    }

    public final void j(boolean z6) {
        if (z6) {
            c cVar = this.f8995a;
            cVar.getClass();
            try {
                cVar.b.stop();
            } catch (IllegalStateException unused) {
                cVar.f8991a.f();
            }
            cVar.b.reset();
            cVar.b.setSurface(null);
            cVar.b.setDisplay(null);
            cVar.b.setVolume(1.0f, 1.0f);
            this.f8995a.b.setLooping(this.f9007q);
            float f6 = this.f8998h ? 0.0f : 1.0f;
            this.f8995a.b.setVolume(f6, f6);
        }
        AssetFileDescriptor assetFileDescriptor = this.f9000j;
        if (assetFileDescriptor != null) {
            c cVar2 = this.f8995a;
            cVar2.getClass();
            try {
                cVar2.b.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
            } catch (Exception unused2) {
                cVar2.f8991a.f();
            }
        } else {
            if (TextUtils.isEmpty(this.f8999i)) {
                return;
            }
            c cVar3 = this.f8995a;
            String str = this.f8999i;
            cVar3.getClass();
            try {
                cVar3.b.setDataSource(cVar3.d, Uri.parse(str), (Map<String, String>) null);
            } catch (Exception unused3) {
                cVar3.f8991a.f();
            }
        }
        c cVar4 = this.f8995a;
        cVar4.getClass();
        try {
            cVar4.e = true;
            cVar4.b.prepareAsync();
        } catch (IllegalStateException unused4) {
            cVar4.f8991a.f();
        }
        setPlayState(1);
        setPlayerState(this.f9004n ? 11 : 10);
    }

    @Override // xyz.doikki.videoplayer.controller.h
    public final void k() {
        ViewGroup decorView;
        if (this.f9004n || (decorView = getDecorView()) == null) {
            return;
        }
        this.f9004n = true;
        decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | InputDeviceCompat.SOURCE_TOUCHSCREEN);
        getActivity().getWindow().setFlags(1024, 1024);
        removeView(this.c);
        decorView.addView(this.c);
        setPlayerState(11);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        int i5 = F5.b.f276a;
        return super.onSaveInstanceState();
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z6) {
        super.onWindowFocusChanged(z6);
        if (z6 && this.f9004n) {
            ViewGroup decorView = getDecorView();
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | InputDeviceCompat.SOURCE_TOUCHSCREEN);
            getActivity().getWindow().setFlags(1024, 1024);
        }
    }

    @Override // xyz.doikki.videoplayer.controller.h
    public final void pause() {
        AudioManager audioManager;
        if (d() && this.f8995a.b.isPlaying()) {
            c cVar = this.f8995a;
            cVar.getClass();
            try {
                cVar.b.pause();
            } catch (IllegalStateException unused) {
                cVar.f8991a.f();
            }
            setPlayState(4);
            e eVar = this.mAudioFocusHelper;
            if (eVar != null && !this.f8998h && (audioManager = eVar.c) != null) {
                eVar.d = false;
                audioManager.abandonAudioFocus(eVar);
            }
            this.c.setKeepScreenOn(false);
        }
    }

    public void removeOnStateChangeListener(@NonNull f fVar) {
        ArrayList arrayList = this.f9006p;
        if (arrayList != null) {
            arrayList.remove(fVar);
        }
    }

    @Override // xyz.doikki.videoplayer.controller.h
    public final void seekTo(long j6) {
        if (d()) {
            c cVar = this.f8995a;
            cVar.getClass();
            try {
                cVar.b.seekTo(j6, 3);
            } catch (IllegalStateException unused) {
                cVar.f8991a.f();
            }
        }
    }

    public void setAssetFileDescriptor(AssetFileDescriptor assetFileDescriptor) {
        this.f8999i = null;
        this.f9000j = assetFileDescriptor;
    }

    public void setEnableAudioFocus(boolean z6) {
        this.f9005o = z6;
    }

    public void setLooping(boolean z6) {
        this.f9007q = z6;
        c cVar = this.f8995a;
        if (cVar != null) {
            cVar.b.setLooping(z6);
        }
    }

    public void setMirrorRotation(boolean z6) {
        E5.d dVar = this.d;
        if (dVar != null) {
            dVar.getView().setScaleX(z6 ? -1.0f : 1.0f);
        }
    }

    public void setMute(boolean z6) {
        this.f8998h = z6;
        c cVar = this.f8995a;
        if (cVar != null) {
            float f6 = z6 ? 0.0f : 1.0f;
            cVar.b.setVolume(f6, f6);
        }
    }

    public void setOnStateChangeListener(@NonNull f fVar) {
        ArrayList arrayList = this.f9006p;
        if (arrayList == null) {
            this.f9006p = new ArrayList();
        } else {
            arrayList.clear();
        }
        this.f9006p.add(fVar);
    }

    public void setPlayState(int i5) {
        this.f9002l = i5;
        xyz.doikki.videoplayer.controller.b bVar = this.mVideoController;
        if (bVar != null) {
            bVar.setPlayState(i5);
        }
        ArrayList arrayList = this.f9006p;
        if (arrayList != null) {
            Iterator it = F5.c.getSnapshot(arrayList).iterator();
            while (it.hasNext()) {
                if (it.next() != null) {
                    throw new ClassCastException();
                }
            }
        }
    }

    public void setPlayerBackgroundColor(int i5) {
        this.c.setBackgroundColor(i5);
    }

    public void setPlayerFactory(h hVar) {
        if (hVar == null) {
            throw new IllegalArgumentException("PlayerFactory can not be null!");
        }
        this.b = hVar;
    }

    public void setPlayerState(int i5) {
        this.f9003m = i5;
        xyz.doikki.videoplayer.controller.b bVar = this.mVideoController;
        if (bVar != null) {
            bVar.setPlayerState(i5);
        }
        ArrayList arrayList = this.f9006p;
        if (arrayList != null) {
            Iterator it = F5.c.getSnapshot(arrayList).iterator();
            while (it.hasNext()) {
                if (it.next() != null) {
                    throw new ClassCastException();
                }
            }
        }
    }

    public void setRenderViewFactory(E5.c cVar) {
        if (cVar == null) {
            throw new IllegalArgumentException("RenderViewFactory can not be null!");
        }
        this.e = cVar;
    }

    @Override // android.view.View
    public void setRotation(float f6) {
        E5.d dVar = this.d;
        if (dVar != null) {
            dVar.setVideoRotation((int) f6);
        }
    }

    public void setScreenScaleType(int i5) {
        this.f8996f = i5;
        E5.d dVar = this.d;
        if (dVar != null) {
            dVar.setScaleType(i5);
        }
    }

    public void setSpeed(float f6) {
        if (d()) {
            c cVar = this.f8995a;
            cVar.getClass();
            try {
                MediaPlayer mediaPlayer = cVar.b;
                mediaPlayer.setPlaybackParams(mediaPlayer.getPlaybackParams().setSpeed(f6));
            } catch (Exception unused) {
                cVar.f8991a.f();
            }
        }
    }

    public void setUrl(String str) {
        this.f9000j = null;
        this.f8999i = str;
    }

    public void setVideoController(@Nullable xyz.doikki.videoplayer.controller.b bVar) {
        this.c.removeView(this.mVideoController);
        this.mVideoController = bVar;
        if (bVar != null) {
            bVar.setMediaPlayer(this);
            this.c.addView(this.mVideoController, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0044  */
    /* JADX WARN: Code duplicated, block: B:39:0x0087  */
    /* JADX WARN: Code duplicated, block: B:41:0x008b  */
    /* JADX WARN: Code duplicated, block: B:43:0x0093  */
    @Override // xyz.doikki.videoplayer.controller.h
    public final void start() {
        xyz.doikki.videoplayer.controller.b bVar;
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        int subtype;
        AudioManager audioManager;
        int i5 = this.f9002l;
        if (i5 != 0 && i5 != 8) {
            if (d()) {
                c cVar = this.f8995a;
                cVar.getClass();
                try {
                    cVar.b.start();
                } catch (IllegalStateException unused) {
                    cVar.f8991a.f();
                }
                setPlayState(3);
                e eVar = this.mAudioFocusHelper;
                if (eVar != null && !this.f8998h && eVar.f8994f != 1 && (audioManager = eVar.c) != null) {
                    if (1 == audioManager.requestAudioFocus(eVar, 3, 1)) {
                        eVar.f8994f = 1;
                    } else {
                        eVar.d = true;
                    }
                }
                this.c.setKeepScreenOn(true);
                return;
            }
            return;
        }
        if (this.f9000j == null) {
            if (TextUtils.isEmpty(this.f8999i)) {
                bVar = this.mVideoController;
                if (bVar != null) {
                    subtype = activeNetworkInfo.getSubtype();
                    if (subtype != 20) {
                        switch (subtype) {
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                            case 8:
                            case 9:
                            case 10:
                            case 11:
                            case 12:
                            case 13:
                            case 14:
                            case 15:
                                if (!l.b().f9009a) {
                                    setPlayState(8);
                                    return;
                                }
                                break;
                        }
                    } else if (!l.b().f9009a) {
                        setPlayState(8);
                        return;
                    }
                }
            } else {
                Uri uri = Uri.parse(this.f8999i);
                if (!"android.resource".equals(uri.getScheme()) && !Constants.FILE.equals(uri.getScheme()) && !"rawresource".equals(uri.getScheme())) {
                    bVar = this.mVideoController;
                    if (bVar != null && (connectivityManager = (ConnectivityManager) bVar.getContext().getApplicationContext().getSystemService("connectivity")) != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected() && activeNetworkInfo.getType() != 9 && activeNetworkInfo.getType() != 1 && activeNetworkInfo.getType() == 0) {
                        subtype = activeNetworkInfo.getSubtype();
                        if (subtype != 20) {
                            switch (subtype) {
                                case 1:
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                case 6:
                                case 7:
                                case 8:
                                case 9:
                                case 10:
                                case 11:
                                case 12:
                                case 13:
                                case 14:
                                case 15:
                                    if (!l.b().f9009a) {
                                        setPlayState(8);
                                        return;
                                    }
                                    break;
                            }
                        } else if (!l.b().f9009a) {
                            setPlayState(8);
                            return;
                        }
                    }
                }
            }
        }
        if (this.f9005o) {
            this.mAudioFocusHelper = new e(this);
        }
        h hVar = this.b;
        Context context = getContext();
        ((d) hVar).getClass();
        c cVar2 = new c();
        cVar2.d = context.getApplicationContext();
        this.f8995a = cVar2;
        cVar2.f8991a = this;
        MediaPlayer mediaPlayer = new MediaPlayer();
        cVar2.b = mediaPlayer;
        mediaPlayer.setAudioStreamType(3);
        cVar2.b.setOnErrorListener(cVar2);
        cVar2.b.setOnCompletionListener(cVar2);
        cVar2.b.setOnInfoListener(cVar2);
        cVar2.b.setOnBufferingUpdateListener(cVar2);
        cVar2.b.setOnPreparedListener(cVar2);
        cVar2.b.setOnVideoSizeChangedListener(cVar2);
        this.f8995a.b.setLooping(this.f9007q);
        float f6 = this.f8998h ? 0.0f : 1.0f;
        this.f8995a.b.setVolume(f6, f6);
        b();
        j(false);
    }

    public g(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public g(@NonNull Context context, @Nullable AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.f8997g = new int[]{0, 0};
        this.f9002l = 0;
        this.f9003m = 10;
        k kVarA = l.a();
        kVarA.getClass();
        this.f9005o = true;
        this.b = (d) kVarA.b;
        this.f8996f = 0;
        this.e = (E5.e) kVarA.c;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, D5.a.BaseVideoView);
        this.f9005o = typedArrayObtainStyledAttributes.getBoolean(D5.a.BaseVideoView_enableAudioFocus, this.f9005o);
        this.f9007q = typedArrayObtainStyledAttributes.getBoolean(D5.a.BaseVideoView_looping, false);
        this.f8996f = typedArrayObtainStyledAttributes.getInt(D5.a.BaseVideoView_screenScaleType, this.f8996f);
        int color = typedArrayObtainStyledAttributes.getColor(D5.a.BaseVideoView_playerBackgroundColor, ViewCompat.MEASURED_STATE_MASK);
        typedArrayObtainStyledAttributes.recycle();
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.c = frameLayout;
        frameLayout.setBackgroundColor(color);
        addView(this.c, new FrameLayout.LayoutParams(-1, -1));
    }

    public void setProgressManager(@Nullable i iVar) {
    }

    public void setTinyScreenSize(int[] iArr) {
    }
}
