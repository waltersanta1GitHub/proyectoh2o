package com.quimiespel.quimiespelmaven.vistas;

import com.quimiespel.quimiespelmaven.map.Formatosencabezado;
import com.quimiespel.quimiespelmaven.vistas.util.JsfUtil;
import com.quimiespel.quimiespelmaven.vistas.util.JsfUtil.PersistAction;
import com.quimiespel.quimiespelmaven.beans.FormatosencabezadoFacade;

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

@Named("formatosencabezadoController")
@SessionScoped
public class FormatosencabezadoController implements Serializable {

    @EJB
    private com.quimiespel.quimiespelmaven.beans.FormatosencabezadoFacade ejbFacade;
    private List<Formatosencabezado> items = null;
    private Formatosencabezado selected;

    public FormatosencabezadoController() {
    }

    public Formatosencabezado getSelected() {
        return selected;
    }

    public void setSelected(Formatosencabezado selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
        selected.setId(new com.quimiespel.quimiespelmaven.map.FormatosencabezadoId());
    }

    private FormatosencabezadoFacade getFacade() {
        return ejbFacade;
    }

    public Formatosencabezado prepareCreate() {
        selected = new Formatosencabezado();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("FormatosencabezadoCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("FormatosencabezadoUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("FormatosencabezadoDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Formatosencabezado> getItems() {
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

    public Formatosencabezado getFormatosencabezado(com.quimiespel.quimiespelmaven.map.FormatosencabezadoId id) {
        return getFacade().find(id);
    }

    public List<Formatosencabezado> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Formatosencabezado> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Formatosencabezado.class)
    public static class FormatosencabezadoControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            FormatosencabezadoController controller = (FormatosencabezadoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "formatosencabezadoController");
            return controller.getFormatosencabezado(getKey(value));
        }

        com.quimiespel.quimiespelmaven.map.FormatosencabezadoId getKey(String value) {
            com.quimiespel.quimiespelmaven.map.FormatosencabezadoId key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new com.quimiespel.quimiespelmaven.map.FormatosencabezadoId();
            key.setIdFormatoEncabezado(Long.parseLong(values[0]));
            key.setEmpleadosId(Long.parseLong(values[1]));
            key.setTipoFormatoId(Long.parseLong(values[2]));
            key.setCiiuId(Long.parseLong(values[3]));
            return key;
        }

        String getStringKey(com.quimiespel.quimiespelmaven.map.FormatosencabezadoId value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdFormatoEncabezado());
            sb.append(SEPARATOR);
            sb.append(value.getEmpleadosId());
            sb.append(SEPARATOR);
            sb.append(value.getTipoFormatoId());
            sb.append(SEPARATOR);
            sb.append(value.getCiiuId());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Formatosencabezado) {
                Formatosencabezado o = (Formatosencabezado) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Formatosencabezado.class.getName()});
                return null;
            }
        }

    }

}
