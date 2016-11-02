package org.jehack.flux;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import org.jehack.flux.view.OnFluxStoreRegisterHandler;

public final class Flux implements Application.ActivityLifecycleCallbacks {

    private static final String TAG = Flux.class.getSimpleName();

    private static final Flux INSTANCE = new Flux();

    public static Flux getInstance() {
        return INSTANCE;
    }

    public void register(Application application) {
        application.registerActivityLifecycleCallbacks(this);
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        if (activity instanceof OnFluxStoreRegisterHandler) {
            ((OnFluxStoreRegisterHandler) activity).onFluxStoreRegister();
        }
    }

    @Override
    public void onActivityStarted(Activity activity) {

    }

    @Override
    public void onActivityResumed(Activity activity) {
        if (activity instanceof OnFluxStoreRegisterHandler) {
            ((OnFluxStoreRegisterHandler) activity).onFluxStoreRegister();
        }
    }

    @Override
    public void onActivityPaused(Activity activity) {
        if (activity instanceof OnFluxStoreRegisterHandler) {
            ((OnFluxStoreRegisterHandler) activity).onFluxStoreUnRegister();
        }
    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {

    }
}
