package org.jehack.flux.store;

import org.jehack.flux.action.FluxAction;
import org.jehack.flux.dispatcher.FluxDispatcher;
import org.jehack.flux.view.OnFluxStoreChangedListener;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class FluxStore {

    public abstract void onFluxActionHandling(FluxAction fluxAction);

    private Map<String, Object> fluxStoreChangedListener = new ConcurrentHashMap<>();

    public FluxStore() {
        FluxDispatcher.getInstance().register(this);
    }

    public void register(final Object cls) {
        fluxStoreChangedListener.put(cls.getClass().getName(), cls);
    }

    public void unRegister(final Object cls) {
        fluxStoreChangedListener.remove(cls.getClass().getName());
    }

    protected void emit(FluxAction fluxAction) {
        for (Object cls : fluxStoreChangedListener.values()) {
            if (cls instanceof OnFluxStoreChangedListener) {
                ((OnFluxStoreChangedListener) cls).onFluxStoreChanged(fluxAction);
            }
        }
    }
}
