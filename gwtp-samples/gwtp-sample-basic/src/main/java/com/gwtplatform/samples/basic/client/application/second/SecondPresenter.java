package com.gwtplatform.samples.basic.client.application.second;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;
import com.gwtplatform.samples.basic.client.application.widget.WidgetPresenter;
import com.gwtplatform.samples.basic.client.place.NameTokens;
import com.gwtplatform.samples.basic.client.place.TokenParameters;

public class SecondPresenter extends Presenter<SecondPresenter.MyView, SecondPresenter.MyProxy>
        implements SecondUiHandlers {
    // TODO: Document this!
    @ProxyStandard
    @NameToken(NameTokens.second)
    interface MyProxy extends ProxyPlace<SecondPresenter> {

    }

    interface MyView extends View, HasUiHandlers<SecondUiHandlers> {

    }

    // New slot
    public static final Object LOGIN_SLOT = new Object();
    // Our new presenter
    private final WidgetPresenter widgetPresenter;

    private final PlaceManager placeManager;

    @Inject
    public SecondPresenter(EventBus eventBus,
                           MyView view,
                           MyProxy proxy,
                           PlaceManager placeManager,
                           WidgetPresenter widgetPresenter) {
        // TODO: RevealType.Root !!!!!!!!!!!! Super important!
        super(eventBus, view, proxy, RevealType.Root);

        this.placeManager = placeManager;
        this.widgetPresenter = widgetPresenter;
    }

    @Override
    protected void onReset() {
        super.onReset();
    }

    @Override
    protected void onBind() {
        super.onBind();

        setInSlot(LOGIN_SLOT, widgetPresenter);
    }

    @Override
    public void prepareFromRequest(PlaceRequest request) {
        super.prepareFromRequest(request);

        String name = request.getParameter(TokenParameters.TEXT_TO_SEND, null);
        widgetPresenter.setUsername(name);
    }
}
