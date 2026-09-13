package androidx.core.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;
import androidx.annotation.RequiresApi;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class ViewPropertyAnimatorCompat {
    private final WeakReference<View> mView;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @RequiresApi(21)
    public static class Api21Impl {
        private Api21Impl() {
        }

        public static ViewPropertyAnimator translationZ(ViewPropertyAnimator viewPropertyAnimator, float f6) {
            return viewPropertyAnimator.translationZ(f6);
        }

        public static ViewPropertyAnimator translationZBy(ViewPropertyAnimator viewPropertyAnimator, float f6) {
            return viewPropertyAnimator.translationZBy(f6);
        }

        public static ViewPropertyAnimator z(ViewPropertyAnimator viewPropertyAnimator, float f6) {
            return viewPropertyAnimator.z(f6);
        }

        public static ViewPropertyAnimator zBy(ViewPropertyAnimator viewPropertyAnimator, float f6) {
            return viewPropertyAnimator.zBy(f6);
        }
    }

    public ViewPropertyAnimatorCompat(View view) {
        this.mView = new WeakReference<>(view);
    }

    private void setListenerInternal(final View view, final ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        if (viewPropertyAnimatorListener != null) {
            view.animate().setListener(new AnimatorListenerAdapter() { // from class: androidx.core.view.ViewPropertyAnimatorCompat.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    viewPropertyAnimatorListener.onAnimationCancel(view);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    viewPropertyAnimatorListener.onAnimationEnd(view);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    viewPropertyAnimatorListener.onAnimationStart(view);
                }
            });
        } else {
            view.animate().setListener(null);
        }
    }

    public ViewPropertyAnimatorCompat alpha(float f6) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().alpha(f6);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat alphaBy(float f6) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().alphaBy(f6);
        }
        return this;
    }

    public void cancel() {
        View view = this.mView.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public long getDuration() {
        View view = this.mView.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0L;
    }

    public Interpolator getInterpolator() {
        View view = this.mView.get();
        if (view != null) {
            return (Interpolator) view.animate().getInterpolator();
        }
        return null;
    }

    public long getStartDelay() {
        View view = this.mView.get();
        if (view != null) {
            return view.animate().getStartDelay();
        }
        return 0L;
    }

    public ViewPropertyAnimatorCompat rotation(float f6) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().rotation(f6);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat rotationBy(float f6) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().rotationBy(f6);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat rotationX(float f6) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().rotationX(f6);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat rotationXBy(float f6) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().rotationXBy(f6);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat rotationY(float f6) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().rotationY(f6);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat rotationYBy(float f6) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().rotationYBy(f6);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat scaleX(float f6) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().scaleX(f6);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat scaleXBy(float f6) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().scaleXBy(f6);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat scaleY(float f6) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().scaleY(f6);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat scaleYBy(float f6) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().scaleYBy(f6);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat setDuration(long j6) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().setDuration(j6);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat setInterpolator(Interpolator interpolator) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat setListener(ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        View view = this.mView.get();
        if (view != null) {
            setListenerInternal(view, viewPropertyAnimatorListener);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat setStartDelay(long j6) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().setStartDelay(j6);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat setUpdateListener(final ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener) {
        final View view = this.mView.get();
        if (view != null) {
            view.animate().setUpdateListener(viewPropertyAnimatorUpdateListener != null ? new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.core.view.n
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    viewPropertyAnimatorUpdateListener.onAnimationUpdate(view);
                }
            } : null);
        }
        return this;
    }

    public void start() {
        View view = this.mView.get();
        if (view != null) {
            view.animate().start();
        }
    }

    public ViewPropertyAnimatorCompat translationX(float f6) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().translationX(f6);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat translationXBy(float f6) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().translationXBy(f6);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat translationY(float f6) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().translationY(f6);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat translationYBy(float f6) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().translationYBy(f6);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat translationZ(float f6) {
        View view = this.mView.get();
        if (view != null) {
            Api21Impl.translationZ(view.animate(), f6);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat translationZBy(float f6) {
        View view = this.mView.get();
        if (view != null) {
            Api21Impl.translationZBy(view.animate(), f6);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat withEndAction(Runnable runnable) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().withEndAction(runnable);
        }
        return this;
    }

    @SuppressLint({"WrongConstant"})
    public ViewPropertyAnimatorCompat withLayer() {
        View view = this.mView.get();
        if (view != null) {
            view.animate().withLayer();
        }
        return this;
    }

    public ViewPropertyAnimatorCompat withStartAction(Runnable runnable) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().withStartAction(runnable);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat x(float f6) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().x(f6);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat xBy(float f6) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().xBy(f6);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat y(float f6) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().y(f6);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat yBy(float f6) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().yBy(f6);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat z(float f6) {
        View view = this.mView.get();
        if (view != null) {
            Api21Impl.z(view.animate(), f6);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat zBy(float f6) {
        View view = this.mView.get();
        if (view != null) {
            Api21Impl.zBy(view.animate(), f6);
        }
        return this;
    }
}
