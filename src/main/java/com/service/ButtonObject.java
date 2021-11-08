package com.service;

import com.vaadin.server.ExternalResource;
import com.vaadin.ui.*;

public class ButtonObject {
    private ButtonObject(){}


    public static HorizontalLayout getLayout() {
        HorizontalLayout layout = new HorizontalLayout();
        Link buttonClient = new Link("Клиент", new ExternalResource("/"));
        Link buttonBank = new Link("Банк", new ExternalResource("/bank"));
        Link buttonCredit = new Link("Кредит", new ExternalResource("/credit"));
        //Link buttonCredit = new Link("Кредитное предложение", new ExternalResource("/order"));
        layout.addComponent(buttonClient);
        layout.addComponent(buttonBank);
        layout.addComponent(buttonCredit);
        return layout;
    }
}
