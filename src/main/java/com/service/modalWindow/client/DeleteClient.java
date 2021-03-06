package com.service.modalWindow.client;

import com.model.Client;
import com.service.grids.ClientGrig;
import com.vaadin.ui.*;

public class DeleteClient extends AbstractWindowClient {

    private Client client;

    public DeleteClient(Client client, ClientGrig clientGrig) {
        super(clientGrig);
        id.setEnabled(false);
        name.setEnabled(false);
        surname.setEnabled(false);
        middleName.setEnabled(false);
        passportNumber.setEnabled(false);
        phoneNumber.setEnabled(false);
        email.setEnabled(false);
        accept.setCaption("Удалить");
        id.setValue(String.valueOf(client.getId()));
        name.setValue(client.getName());
        surname.setValue(client.getSurname());
        middleName.setValue(client.getMiddleName());
        passportNumber.setValue(String.valueOf(client.getPassportNumber()));
        phoneNumber.setValue(String.valueOf(client.getPhoneNumber()));
        email.setValue(client.getEmail());
        this.client = client;
        setContent(initComponents());
    }

    @Override
    protected VerticalLayout initComponents() {
        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.addComponents(new Label("Подтвердите удаление"), id, name, surname, middleName, passportNumber,
                phoneNumber, email,  new HorizontalLayout(accept, cancel));
        return verticalLayout;
    }

    @Override
    protected void accept() {
        boolean bool = clientRepository.deleteById(client.getId());
        if (bool) Notification.show("Клиент удален.", Notification.Type.TRAY_NOTIFICATION);
        else
            Notification.show("Не удалось удалить клиента.", Notification.Type.WARNING_MESSAGE);
        clientGrig.refresh();
        close();
    }
}
