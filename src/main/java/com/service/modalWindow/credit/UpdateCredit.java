package com.service.modalWindow.credit;

import com.model.Credit;
import com.service.grids.CreditGrid;
import com.vaadin.ui.*;

import java.math.BigDecimal;

public class UpdateCredit extends  AbstractWindowCredit{
    private Credit credit;

    public UpdateCredit(Credit credit, CreditGrid creditGrid) {
        super(creditGrid);
        this.creditGrid = creditGrid;
        this.credit = credit;
        this.id.setValue(String.valueOf(credit.getId()));
        this.limitCredit.setValue(String.valueOf(credit.getLimitCredit()));
        this.interestRate.setValue(String.valueOf(credit.getInterestRate()));
        this.id.setEnabled(false);
        setContent(initComponents());
    }
    @Override
    protected VerticalLayout initComponents() {
        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.addComponents(new Label("Редактирование кредита"), id, limitCredit,interestRate,
                new HorizontalLayout(accept, cancel));
        return verticalLayout;
    }
    @Override
    protected void accept() {
        Credit credit = new Credit(this.credit.getId(),Long.parseLong(limitCredit.getValue()), Long.parseLong(interestRate.getValue()));
        creditRepository.update(credit);
        creditGrid.refresh();
        setVisible(false);
    }
}
