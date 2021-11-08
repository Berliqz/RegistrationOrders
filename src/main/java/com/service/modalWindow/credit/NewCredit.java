package com.service.modalWindow.credit;
import com.model.Credit;
import com.repository.CreditDAO;
import com.service.grids.CreditGrid;
import com.service.modalWindow.credit.AbstractWindowCredit;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import java.math.BigDecimal;

public class NewCredit extends  AbstractWindowCredit{
    public NewCredit(CreditGrid creditGrid) {
        super(creditGrid);
        setContent(initComponents());
    }
    @Override
    protected VerticalLayout initComponents() {
        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.addComponents(new Label("Создание нового кредита"), limitCredit,interestRate,
                 new HorizontalLayout(accept, cancel));
        return verticalLayout;
    }
    @Override
    protected void accept() {
        Credit credit = new Credit(Long.parseLong(limitCredit.getValue()), Long.parseLong(interestRate.getValue()));

        creditRepository.insert(credit);
        creditGrid.refresh();
        setVisible(false);
    }

}
