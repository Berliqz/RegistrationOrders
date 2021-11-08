package com.service.modalWindow.credit;
import com.model.Credit;
import com.repository.CreditDAO;
import com.repository.CreditDAOlmpl;
import com.service.grids.CreditGrid;
import com.vaadin.data.Binder;
import com.vaadin.data.converter.StringToBigDecimalConverter;
import com.vaadin.data.converter.StringToLongConverter;
import com.vaadin.data.converter.StringToUuidConverter;
import com.vaadin.ui.Button;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.service.modalWindow.credit.NewCredit;

import java.math.BigDecimal;

public abstract class AbstractWindowCredit extends Window {
    protected CreditDAO creditRepository = new CreditDAOlmpl();
    protected TextField id = new TextField("Идентификатор");
    protected TextField limitCredit = new TextField("Лимит по кредиту");
    protected TextField interestRate = new TextField("Процентная ставка");
    protected Button accept = new Button("Сохранить");
    protected Button cancel = new Button("Отменить");
    protected CreditGrid creditGrid;
    protected AbstractWindowCredit(CreditGrid creditGrid){
        this.creditGrid = creditGrid;
        accept.setEnabled(false);
        center();
        setModal(true);
        setClosable(false);
        setResizable(false);
        cancelButtonInit();
        acceptButtonInit();
        validationInit();
    }
    private   void validationInit() {
        Binder<Credit> binder = new Binder<>(Credit.class);
        binder.forField(limitCredit).
                withConverter(new StringToLongConverter(
                        "Проверьте правильность заполнения номера")).asRequired("Проверьте правильность заполнения  кредитного лимита")
                .withValidator(limitCredit -> limitCredit > 0, "Проверьте правильность заполнения кредитного лимита")
                .bind("limitCredit");
        binder.forField(interestRate).
                withConverter(new StringToLongConverter(
                        "Проверьте правильность заполнения номера")).asRequired("Проверьте правильность заполнения  процентной ставки")
                .withValidator( interestRate-> interestRate > 0, "Проверьте правильность заполнения процентной ставки")
                .bind("interestRate");
        binder.addStatusChangeListener(statusChangeEvent -> accept.setEnabled(binder.isValid()));
    }
    private void cancelButtonInit() {
        cancel.addClickListener(clickEvent -> setVisible(false));
    }
    private void acceptButtonInit() {
        accept.addClickListener(clickEvent -> accept());
    }
    protected abstract void accept();
    protected abstract VerticalLayout initComponents();
}
