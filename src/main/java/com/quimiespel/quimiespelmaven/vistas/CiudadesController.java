package com.quimiespel.quimiespelmaven.vistas;

import com.quimiespel.quimiespelmaven.map.Ciudades;
import com.quimiespel.quimiespelmaven.vistas.util.JsfUtil;
import com.quimiespel.quimiespelmaven.vistas.util.JsfUtil.PersistAction;
import com.quimiespel.quimiespelmaven.beans.CiudadesFacade;

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

@Named("ciudadesController")
@SessionScoped
public class CiudadesController implements Serializable {

    @EJB
    private com.quimiespel.quimiespelmaven.beans.CiudadesFacade ejbFacade;
    private List<Ciudades> items = null;
    private Ciudades selected;

    public CiudadesController() {
    }

    public Ciudades getSelected() {
        return selected;
    }

    public void setSelected(Ciudades selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
        selected.setId(new com.quimiespel.quimiespelmaven.map.CiudadesId());
    }

    private CiudadesFacade getFacade() {
        return ejbFacade;
    }

    public Ciudades prepareCreate() {
        selected = new Ciudades();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("CiudadesCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("CiudadesUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("CiudadesDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Ciudades> getItems() {
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

    public Ciudades getCiudades(com.quimiespel.quimiespelmaven.map.CiudadesId id) {
        return getFacade().find(id);
    }

    public List<Ciudades> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Ciudades> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Ciudades.class)
    public static class CiudadesControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CiudadesController controller = (CiudadesController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "ciudadesController");
            return controller.getCiudades(getKey(value));
        }

        com.quimiespel.quimiespelmaven.map.CiudadesId getKey(String value) {
            com.quimiespel.quimiespelmaven.map.CiudadesId key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new com.quimiespel.quimiespelmaven.map.CiudadesId();
            key.setIdCiudad(Long.parseLong(values[0]));
            key.setDepartamentoId(Long.parseLong(values[1]));
            return key;
        }

        String getStringKey(com.quimiespel.quimiespelmaven.map.CiudadesId value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdCiudad());
            sb.append(SEPARATOR);
            sb.append(value.getDepartamentoId());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Ciudades) {
                Ciudades o = (Ciudades) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Ciudades.class.getName()});
                return null;
            }
        }

    }

}
