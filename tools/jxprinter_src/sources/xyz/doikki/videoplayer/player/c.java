package xyz.doikki.videoplayer.player;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final class c extends a implements MediaPlayer.OnErrorListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnInfoListener, MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnVideoSizeChangedListener {
    public MediaPlayer b;
    public int c;
    public Context d;
    public boolean e;

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i5) {
        this.c = i5;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public final void onCompletion(MediaPlayer mediaPlayer) {
        g gVar = this.f8991a;
        gVar.c.setKeepScreenOn(false);
        gVar.f9001k = 0L;
        gVar.setPlayState(5);
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public final boolean onError(MediaPlayer mediaPlayer, int i5, int i6) {
        this.f8991a.f();
        return true;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public final boolean onInfo(MediaPlayer mediaPlayer, int i5, int i6) {
        if (i5 != 3) {
            this.f8991a.g(i5, i6);
            return true;
        }
        if (!this.e) {
            return true;
        }
        this.f8991a.g(i5, i6);
        this.e = false;
        return true;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public final void onPrepared(MediaPlayer mediaPlayer) {
        e eVar;
        AudioManager audioManager;
        g gVar = this.f8991a;
        gVar.setPlayState(2);
        if (!gVar.f8998h && (eVar = gVar.mAudioFocusHelper) != null && eVar.f8994f != 1 && (audioManager = eVar.c) != null) {
            if (1 == audioManager.requestAudioFocus(eVar, 3, 1)) {
                eVar.f8994f = 1;
            } else {
                eVar.d = true;
            }
        }
        long j6 = gVar.f9001k;
        if (j6 > 0) {
            gVar.seekTo(j6);
        }
        try {
            this.b.start();
        } catch (IllegalStateException unused) {
            this.f8991a.f();
        }
        try {
            for (MediaPlayer.TrackInfo trackInfo : this.b.getTrackInfo()) {
                if (trackInfo.getTrackType() == 1) {
                    return;
                }
            }
        } catch (Exception unused2) {
        }
        this.f8991a.g(3, 0);
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i5, int i6) {
        int videoWidth = mediaPlayer.getVideoWidth();
        int videoHeight = mediaPlayer.getVideoHeight();
        if (videoWidth == 0 || videoHeight == 0) {
            return;
        }
        g gVar = this.f8991a;
        int[] iArr = gVar.f8997g;
        iArr[0] = videoWidth;
        iArr[1] = videoHeight;
        E5.d dVar = gVar.d;
        if (dVar != null) {
            dVar.setScaleType(gVar.f8996f);
            E5.d dVar2 = gVar.d;
            dVar2.getClass();
            if (videoWidth <= 0 || videoHeight <= 0) {
                return;
            }
            E5.b bVar = dVar2.f235a;
            bVar.f234a = videoWidth;
            bVar.b = videoHeight;
            dVar2.requestLayout();
        }
    }
}
