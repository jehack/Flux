# Flux
How to use Flux structure in Android

#### Example is how RecyclerView can pass messages to AlertDialog to display messages

1. Use Flux to register various events
 ```java
 public class MainApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Flux.getInstance().register(this);
    }
 }
 ```
2. Create new MainActionsCreator and extends FluxActionsCreator
 ```java
 public class MainActionsCreator extends FluxActionsCreator {

    public void showMessage(String message) {
        addAction(newAction(MainActions.SHOW_MESSAGE, message));
    }
 }
 ```
3. Create new MainStore and extends FluxStore
 ```java
 public class MainStore extends FluxStore {

    private String message;

    @Override
    public void onFluxActionHandling(FluxAction fluxAction) {
        switch (fluxAction.getType()) {

            case MainActions.SHOW_MESSAGE:
                message = (String) fluxAction.getData().get(0);
                emitChanged(fluxAction);
                break;
        }
    }

    public String getMessage() {
        return message;
    }
 }
 ```
4. MainActivity implements OnFluxStoreChangedListener and OnFluxStoreRegisterHandler
 ```java
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
 ```
 ```java
 ExampleFlux.getStore().getMain().register(this);
 ```
 MainActivity register MainStore. When the Event is triggered, onFluxStoreChanged receive Event processing action.
