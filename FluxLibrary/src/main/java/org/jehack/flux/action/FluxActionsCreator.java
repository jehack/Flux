package org.jehack.flux.action;

import org.jehack.flux.dispatcher.FluxDispatcher;

import java.util.Arrays;

public class FluxActionsCreator {

    protected final void addAction(FluxAction action) {
        FluxDispatcher.getInstance().dispatch(action);
    }

    protected final void removeAction(String type, Object... data) {

    }

    protected final FluxAction newAction(String type, Object... data) {
        return new FluxAction.Builder().type(type).data(Arrays.asList(data)).build();
    }

    protected final void hasAction(String type, Object... data) {

    }
}
