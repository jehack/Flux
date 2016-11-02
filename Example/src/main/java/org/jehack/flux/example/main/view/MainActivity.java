package org.jehack.flux.example.main.view;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.jehack.flux.action.FluxAction;
import org.jehack.flux.view.OnFluxStoreChangedListener;
import org.jehack.flux.view.OnFluxStoreRegisterHandler;

import org.jehack.flux.example.ExampleFlux;
import org.jehack.flux.example.R;
import org.jehack.flux.example.main.action.MainActions;

public class MainActivity extends AppCompatActivity implements
        OnFluxStoreChangedListener,
        OnFluxStoreRegisterHandler{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView messageList = (RecyclerView) findViewById(R.id.message_list);
        MessageAdapter messageAdapter = new MessageAdapter(this);
        messageList.setAdapter(messageAdapter);
        messageList.setLayoutManager(new LinearLayoutManager(this));

        messageAdapter.update(new MessageTemp().getMessages());
    }

    @Override
    public void onFluxStoreChanged(FluxAction fluxAction) {
        switch (fluxAction.getType()) {

            case MainActions.SHOW_MESSAGE:
                new AlertDialog.Builder(this)
                        .setMessage(ExampleFlux.getStore().getMain().getMessage())
                        .setPositiveButton("OK", null)
                        .show();
                break;
        }
    }

    @Override
    public void onFluxStoreRegister() {
        ExampleFlux.getStore().getMain().register(this);
    }

    @Override
    public void onFluxStoreUnRegister() {
        ExampleFlux.getStore().getMain().unRegister(this);
    }
}
