package org.jehack.flux.example.main.stroe;

import org.jehack.flux.action.FluxAction;
import org.jehack.flux.store.FluxStore;

import org.jehack.flux.example.main.action.MainActions;

public class MainStore extends FluxStore {

    private String message;

    @Override
    public void onFluxActionHandling(FluxAction fluxAction) {
        switch (fluxAction.getType()) {

            case MainActions.SHOW_MESSAGE:
                message = (String) fluxAction.getData().get(0);
                emit(fluxAction);
                break;
        }
    }

    public String getMessage() {
        return message;
    }
}
