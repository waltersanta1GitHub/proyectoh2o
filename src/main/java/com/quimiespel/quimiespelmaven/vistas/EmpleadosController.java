package com.quimiespel.quimiespelmaven.vistas;

import com.quimiespel.quimiespelmaven.map.Empleados;
import com.quimiespel.quimiespelmaven.vistas.util.JsfUtil;
import com.quimiespel.quimiespelmaven.vistas.util.JsfUtil.PersistAction;
import com.quimiespel.quimiespelmaven.beans.EmpleadosFacade;

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

@Named("empleadosController")
@SessionScoped
public class EmpleadosController implements Serializable {

    @EJB
    private com.quimiespel.quimiespelmaven.beans.EmpleadosFacade ejbFacade;
    private List<Empleados> items = null;
    private Empleados selected;

    public EmpleadosController() {
    }

    public Empleados getSelected() {
        return selected;
    }

    public void setSelected(Empleados selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
        selected.setId(new com.quimiespel.quimiespelmaven.map.EmpleadosId());
    }

    private EmpleadosFacade getFacade() {
        return ejbFacade;
    }

    public Empleados prepareCreate() {
        selected = new Empleados();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("EmpleadosCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("EmpleadosUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("EmpleadosDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Empleados> getItems() {
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

    public Empleados getEmpleados(com.quimiespel.quimiespelmaven.map.EmpleadosId id) {
        return getFacade().find(id);
    }

    public List<Empleados> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Empleados> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Empleados.class)
    public static class EmpleadosControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            EmpleadosController controller = (EmpleadosController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "empleadosController");
            return controller.getEmpleados(getKey(value));
        }

        com.quimiespel.quimiespelmaven.map.EmpleadosId getKey(String value) {
            com.quimiespel.quimiespelmaven.map.EmpleadosId key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new com.quimiespel.quimiespelmaven.map.EmpleadosId();
            key.setIdEmpleado(Long.parseLong(values[0]));
            key.setCiudadesId(Long.parseLong(values[1]));
            key.setCargosId(Long.parseLong(values[2]));
            key.setTipoDocumentoId(Long.parseLong(values[3]));
            key.setAreasId(Long.parseLong(values[4]));
            return key;
        }

        String getStringKey(com.quimiespel.quimiespelmaven.map.EmpleadosId value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdEmpleado());
            sb.append(SEPARATOR);
            sb.append(value.getCiudadesId());
            sb.append(SEPARATOR);
            sb.append(value.getCargosId());
            sb.append(SEPARATOR);
            sb.append(value.getTipoDocumentoId());
            sb.append(SEPARATOR);
            sb.append(value.getAreasId());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Empleados) {
                Empleados o = (Empleados) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Empleados.class.getName()});
                return null;
            }
        }

    }

}
