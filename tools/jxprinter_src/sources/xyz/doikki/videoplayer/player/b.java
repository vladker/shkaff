package xyz.doikki.videoplayer.player;

import android.media.MediaPlayer;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final class b extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MediaPlayer f8992a;

    public b(MediaPlayer mediaPlayer) {
        this.f8992a = mediaPlayer;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        try {
            this.f8992a.release();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
