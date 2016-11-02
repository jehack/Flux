package org.jehack.flux.example.main.action;

import org.jehack.flux.action.FluxActionsCreator;

public class MainActionsCreator extends FluxActionsCreator {

    public void showMessage(String message) {
        addAction(newAction(MainActions.SHOW_MESSAGE, message));
    }
}
