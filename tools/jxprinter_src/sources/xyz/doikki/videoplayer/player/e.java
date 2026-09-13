package xyz.doikki.videoplayer.player;

import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final class e implements AudioManager.OnAudioFocusChangeListener {
    public final WeakReference b;
    public final AudioManager c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f8993a = new Handler(Looper.getMainLooper());
    public boolean d = false;
    public boolean e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f8994f = 0;

    public e(@NonNull g gVar) {
        this.b = new WeakReference(gVar);
        this.c = (AudioManager) gVar.getContext().getApplicationContext().getSystemService("audio");
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public final void onAudioFocusChange(int i5) {
        if (this.f8994f == i5) {
            return;
        }
        this.f8993a.post(new H2.e(this, i5, 2));
        this.f8994f = i5;
    }
}
