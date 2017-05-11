package com.quimiespel.quimiespelmaven.vistas;

import com.quimiespel.quimiespelmaven.map.Embalajes;
import com.quimiespel.quimiespelmaven.vistas.util.JsfUtil;
import com.quimiespel.quimiespelmaven.vistas.util.JsfUtil.PersistAction;
import com.quimiespel.quimiespelmaven.beans.EmbalajesFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("embalajesController")
@SessionScoped
public class EmbalajesController implements Serializable {

    @EJB
    private com.quimiespel.quimiespelmaven.beans.EmbalajesFacade ejbFacade;
    private List<Embalajes> items = null;
    private Embalajes selected;

    public EmbalajesController() {
    }

    public Embalajes getSelected() {
        return selected;
    }

    public void setSelected(Embalajes selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private EmbalajesFacade getFacade() {
        return ejbFacade;
    }

    public Embalajes prepareCreate() {
        selected = new Embalajes();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("EmbalajesCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("EmbalajesUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("EmbalajesDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Embalajes> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Embalajes getEmbalajes(java.lang.Long id) {
        return getFacade().find(id);
    }

    public List<Embalajes> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Embalajes> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Embalajes.class)
    public static class EmbalajesControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            EmbalajesController controller = (EmbalajesController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "embalajesController");
            return controller.getEmbalajes(getKey(value));
        }

        java.lang.Long getKey(String value) {
            java.lang.Long key;
            key = Long.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Long value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Embalajes) {
                Embalajes o = (Embalajes) object;
                return getStringKey(o.getIdEmbalaje());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Embalajes.class.getName()});
                return null;
            }
        }

    }

}
