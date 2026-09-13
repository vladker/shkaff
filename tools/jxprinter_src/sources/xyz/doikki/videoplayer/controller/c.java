package xyz.doikki.videoplayer.controller;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public class c implements h, g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f8974a;
    public final g b;

    public c(@NonNull h hVar, @NonNull g gVar) {
        this.f8974a = hVar;
        this.b = gVar;
    }

    @Override // xyz.doikki.videoplayer.controller.h
    public final void a(boolean z6) {
        this.f8974a.a(z6);
    }

    @Override // xyz.doikki.videoplayer.controller.g
    public final boolean b() {
        return this.b.b();
    }

    @Override // xyz.doikki.videoplayer.controller.h
    public final void c() {
        this.f8974a.c();
    }

    @Override // xyz.doikki.videoplayer.controller.g
    public final void d() {
        this.b.d();
    }

    @Override // xyz.doikki.videoplayer.controller.h
    public final boolean e() {
        return this.f8974a.e();
    }

    @Override // xyz.doikki.videoplayer.controller.g
    public final void f() {
        this.b.f();
    }

    @Override // xyz.doikki.videoplayer.controller.g
    public final void g() {
        this.b.g();
    }

    @Override // xyz.doikki.videoplayer.controller.h
    public final int getBufferedPercentage() {
        return this.f8974a.getBufferedPercentage();
    }

    @Override // xyz.doikki.videoplayer.controller.h
    public final long getCurrentPosition() {
        return this.f8974a.getCurrentPosition();
    }

    @Override // xyz.doikki.videoplayer.controller.g
    public final int getCutoutHeight() {
        return this.b.getCutoutHeight();
    }

    @Override // xyz.doikki.videoplayer.controller.h
    public final long getDuration() {
        return this.f8974a.getDuration();
    }

    @Override // xyz.doikki.videoplayer.controller.h
    public final float getSpeed() {
        return this.f8974a.getSpeed();
    }

    @Override // xyz.doikki.videoplayer.controller.h
    public final boolean h() {
        return this.f8974a.h();
    }

    @Override // xyz.doikki.videoplayer.controller.g
    public final void hide() {
        this.b.hide();
    }

    @Override // xyz.doikki.videoplayer.controller.g
    public final boolean i() {
        return this.b.i();
    }

    @Override // xyz.doikki.videoplayer.controller.g
    public final boolean isShowing() {
        return this.b.isShowing();
    }

    @Override // xyz.doikki.videoplayer.controller.g
    public final void j() {
        this.b.j();
    }

    @Override // xyz.doikki.videoplayer.controller.h
    public final void k() {
        this.f8974a.k();
    }

    @Override // xyz.doikki.videoplayer.controller.h
    public final void pause() {
        this.f8974a.pause();
    }

    @Override // xyz.doikki.videoplayer.controller.h
    public final void seekTo(long j6) {
        this.f8974a.seekTo(j6);
    }

    @Override // xyz.doikki.videoplayer.controller.g
    public final void setLocked(boolean z6) {
        this.b.setLocked(z6);
    }

    @Override // xyz.doikki.videoplayer.controller.g
    public final void show() {
        this.b.show();
    }

    @Override // xyz.doikki.videoplayer.controller.h
    public final void start() {
        this.f8974a.start();
    }
}
