/**
 * Copyright 2011 ArcBees Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.gwtplatform.samples.basic.client.application;

import javax.inject.Inject;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.user.client.Window;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ContentSlot;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;
import com.gwtplatform.samples.basic.client.place.NameTokens;
import com.gwtplatform.samples.basic.client.place.TokenParameters;
import com.gwtplatform.samples.basic.shared.FieldVerifier;

public class ApplicationPresenter extends Presenter<ApplicationPresenter.MyView, ApplicationPresenter.MyProxy>
        implements ApplicationUiHandlers {
    @ProxyStandard
    @NameToken(NameTokens.home)
    interface MyProxy extends ProxyPlace<ApplicationPresenter> {

    }

    interface MyView extends View, HasUiHandlers<ApplicationUiHandlers> {

        void resetAndFocus();

        void setError(String errorText);

    }

    // The main content slot
    @ContentSlot
    public static final GwtEvent.Type<RevealContentHandler<?>> SLOT_MAIN_CONTENT = new GwtEvent.Type<>();

    private final PlaceManager placeManager;

    @Inject
    ApplicationPresenter(
            EventBus eventBus,
            MyView view,
            MyProxy proxy,
            PlaceManager placeManager) {
        super(eventBus, view, proxy, RevealType.Root);

        this.placeManager = placeManager;

        getView().setUiHandlers(this);
    }

    @Override
    public void sendName(String name) {
        Window.alert(name + " got passed from the view to the presenter!");

        sendNameToSecondPage(name);
    }

    public void sendNameToSecondPage(String name) {
        getView().setError("");
        if (!FieldVerifier.isValidName(name)) {
            getView().setError("<p><em>Please enter at least four characters</em></p>");
            return;
        }

        PlaceRequest responsePlaceRequest = new PlaceRequest.Builder()
                .nameToken(NameTokens.second)
                .with(TokenParameters.TEXT_TO_SEND, name)
                .build();
        placeManager.revealPlace(responsePlaceRequest);
    }

    @Override
    protected void onReset() {
        super.onReset();

        getView().resetAndFocus();
    }
}
