package com.service.modalWindow.client;


import com.model.Client;
import com.repository.ClientDAO;
import com.service.grids.ClientGrig;
import com.service.modalWindow.client.AbstractWindowClient;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;


public class NewClient extends AbstractWindowClient {

    public NewClient(ClientGrig clientGrig) {
        super(clientGrig);
        setContent(initComponents());
    }

    @Override
    protected VerticalLayout initComponents() {
        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.addComponents(new Label("Создание нового клиента"), name, surname, middleName, passportNumber,
                phoneNumber, email,   new HorizontalLayout(accept, cancel));
        return verticalLayout;
    }

    @Override
    protected void accept() {
        Client client = new Client(name.getValue(), surname.getValue(), middleName.getValue(), Long.parseLong(passportNumber.getValue()) ,Long.parseLong(phoneNumber.getValue()),email.getValue());

        clientRepository.insert(client);
        clientGrig.refresh();
        setVisible(false);
    }
}
