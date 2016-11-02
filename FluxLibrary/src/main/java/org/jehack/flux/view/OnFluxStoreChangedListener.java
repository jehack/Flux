package org.jehack.flux.view;

import org.jehack.flux.action.FluxAction;

public interface OnFluxStoreChangedListener {

    void onFluxStoreChanged(FluxAction fluxAction);
}
