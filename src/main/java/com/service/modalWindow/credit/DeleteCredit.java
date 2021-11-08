package com.service.modalWindow.credit;

import com.model.Credit;
import com.service.grids.CreditGrid;
import com.service.modalWindow.credit.AbstractWindowCredit;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;

public abstract  class DeleteCredit extends AbstractWindowCredit {
    private Credit credit;
    public DeleteCredit(Credit credit, CreditGrid creditGrid) {
        super(creditGrid);
        id.setEnabled(false);
        limitCredit.setEnabled(false);
        interestRate.setEnabled(false);
        accept.setCaption("Удалить");
        id.setValue(String.valueOf(credit.getId()));
        limitCredit.setValue(String.valueOf(credit.getLimitCredit()));
        interestRate.setValue(String.valueOf(credit.getInterestRate()));
        this.credit = credit;
        setContent(initComponents());
    }
    @Override
    protected VerticalLayout initComponents() {
        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.addComponents(new Label("Подтвердите удаление"), id, limitCredit, interestRate,  new HorizontalLayout(accept, cancel));
        return verticalLayout;
    }

    @Override
    protected void accept() {
        boolean bool = creditRepository.deleteById(credit.getId());
        if (bool) Notification.show("Кредит удален.", Notification.Type.TRAY_NOTIFICATION);
        else
            Notification.show("Не удалось удалить кредит.", Notification.Type.WARNING_MESSAGE);
        creditGrid.refresh();
        close();
    }

}
