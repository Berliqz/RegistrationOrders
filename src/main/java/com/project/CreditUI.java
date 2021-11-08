package com.project;
import com.service.ButtonObject;
import com.service.grids.CreditGrid;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
public class CreditUI extends UI {
    private CreditGrid creditGrid = new CreditGrid(this);
    @Override
    protected void init(VaadinRequest vaadinRequest) {

        setContent(new VerticalLayout(ButtonObject.getLayout(), creditGrid.getVerticalLayout()));

    }

    @WebServlet(urlPatterns = "/credit/*", name = "CreditUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = CreditUI.class, productionMode = false)
    public static class CreditUIServlet extends VaadinServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            new CreditUI.CreditUIServlet();
            super.doGet(req, resp);
        }
    }
}
