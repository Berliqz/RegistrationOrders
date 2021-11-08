package com.service.grids;


import com.model.Credit;
import com.project.CreditUI;
import com.repository.CreditDAO;
import com.repository.CreditDAOlmpl;
import com.service.modalWindow.client.DeleteClient;
import com.service.modalWindow.credit.DeleteCredit;
import com.service.modalWindow.credit.NewCredit;
import com.service.modalWindow.credit.UpdateCredit;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.*;
import com.vaadin.ui.components.grid.ItemClickListener;

import java.math.BigDecimal;

public class CreditGrid {
    private Credit credit;
    private Button addCredit = new Button("Новый кредит");
    private Button updateCredit = new Button("Редактировать");
    private Button deleteCredit = new Button("Удалить");
    private Button clearFilterText = new Button(VaadinIcons.CLOSE);
    private TextField filterText = new TextField();
    private CssLayout filter = new CssLayout();
    private CreditDAO creditRepository = new CreditDAOlmpl();
    private Grid<Credit> grid = new Grid<>(Credit.class);
    private CreditUI creditUI;

    public CreditGrid(CreditUI creditUI) {
        gridInit();
        // refresh();
        clearFilterTextInit();
        addCreditButtonInit();
        updateCreditButtonInit();
        deleteCreditButtonInit();
        filterTextInit();
        this.creditUI = creditUI;
    }
    private void gridInit() {
        grid.setColumns("id", "limitCredit", "interestRate");
        grid.getColumn("limitCredit").setCaption("Лимит по кредиту");
        grid.getColumn("interestRate").setCaption("Процентная ставка");
        grid.setSizeFull();
        filter.addComponents( addCredit, updateCredit, deleteCredit);
        grid.addItemClickListener((ItemClickListener<Credit>) itemClick -> {
            credit = itemClick.getItem();
            deleteCredit.setEnabled(true);
            updateCredit.setEnabled(true);
        });
    }
  private void clearFilterTextInit() {
        clearFilterText.addClickListener(e -> filterText.clear());
    }
    private void filterTextInit() {
    filterText.addValueChangeListener(valueChangeEvent -> refresh());
    }

    public VerticalLayout getVerticalLayout() {
        VerticalLayout verticalLayout = new VerticalLayout();
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.addComponents(filterText, clearFilterText);
        horizontalLayout.addComponents( clearFilterText);
        verticalLayout.addComponents(horizontalLayout, filter, grid);
        return verticalLayout;
    }
    private void addCreditButtonInit() {
        this.addCredit.addClickListener(clickEvent -> {
            creditUI.addWindow(new NewCredit(this));
        });
    }
    private void updateCreditButtonInit() {
        this.updateCredit.addClickListener(clickEvent -> creditUI.addWindow(new UpdateCredit(this.credit, this)));
    }
    private void deleteCreditButtonInit() {
        this.deleteCredit.addClickListener(clickEvent -> creditUI.addWindow(new DeleteCredit(this.credit, this) {
        }));
    }

            public final void refresh() {
                this.deleteCredit.setEnabled(false);
                this.updateCredit.setEnabled(false);
                this.credit = null;
                grid.setItems(creditRepository.findAllByFragments(filterText.getValue()));
            }

        }



