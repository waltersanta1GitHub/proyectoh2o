package com.quimiespel.quimiespelmaven.vistas;

import com.quimiespel.quimiespelmaven.map.Formatosdetalle;
import com.quimiespel.quimiespelmaven.vistas.util.JsfUtil;
import com.quimiespel.quimiespelmaven.vistas.util.JsfUtil.PersistAction;
import com.quimiespel.quimiespelmaven.beans.FormatosdetalleFacade;

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

@Named("formatosdetalleController")
@SessionScoped
public class FormatosdetalleController implements Serializable {

    @EJB
    private com.quimiespel.quimiespelmaven.beans.FormatosdetalleFacade ejbFacade;
    private List<Formatosdetalle> items = null;
    private Formatosdetalle selected;

    public FormatosdetalleController() {
    }

    public Formatosdetalle getSelected() {
        return selected;
    }

    public void setSelected(Formatosdetalle selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
        selected.setId(new com.quimiespel.quimiespelmaven.map.FormatosdetalleId());
    }

    private FormatosdetalleFacade getFacade() {
        return ejbFacade;
    }

    public Formatosdetalle prepareCreate() {
        selected = new Formatosdetalle();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("FormatosdetalleCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("FormatosdetalleUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("FormatosdetalleDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Formatosdetalle> getItems() {
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

    public Formatosdetalle getFormatosdetalle(com.quimiespel.quimiespelmaven.map.FormatosdetalleId id) {
        return getFacade().find(id);
    }

    public List<Formatosdetalle> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Formatosdetalle> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Formatosdetalle.class)
    public static class FormatosdetalleControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            FormatosdetalleController controller = (FormatosdetalleController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "formatosdetalleController");
            return controller.getFormatosdetalle(getKey(value));
        }

        com.quimiespel.quimiespelmaven.map.FormatosdetalleId getKey(String value) {
            com.quimiespel.quimiespelmaven.map.FormatosdetalleId key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new com.quimiespel.quimiespelmaven.map.FormatosdetalleId();
            key.setIdFormatoDetalle(Long.parseLong(values[0]));
            key.setEstadoMaterialId(Long.parseLong(values[1]));
            key.setEmbalajesId(Long.parseLong(values[2]));
            key.setUnidadesId(Long.parseLong(values[3]));
            key.setFormatosEncabezadoId(Long.parseLong(values[4]));
            return key;
        }

        String getStringKey(com.quimiespel.quimiespelmaven.map.FormatosdetalleId value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdFormatoDetalle());
            sb.append(SEPARATOR);
            sb.append(value.getEstadoMaterialId());
            sb.append(SEPARATOR);
            sb.append(value.getEmbalajesId());
            sb.append(SEPARATOR);
            sb.append(value.getUnidadesId());
            sb.append(SEPARATOR);
            sb.append(value.getFormatosEncabezadoId());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Formatosdetalle) {
                Formatosdetalle o = (Formatosdetalle) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Formatosdetalle.class.getName()});
                return null;
            }
        }

    }

}
