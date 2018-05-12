package controller;

import bean.LigneRegistreInventaire;
import controller.util.JsfUtil;
import controller.util.JsfUtil.PersistAction;
import service.LigneRegistreInventaireFacade;

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

@Named("ligneRegistreInventaireController")
@SessionScoped
public class LigneRegistreInventaireController implements Serializable {

    @EJB
    private service.LigneRegistreInventaireFacade ejbFacade;
    private List<LigneRegistreInventaire> items = null;
    private LigneRegistreInventaire selected;

    public LigneRegistreInventaireController() {
    }

    public LigneRegistreInventaire getSelected() {
        return selected;
    }

    public void setSelected(LigneRegistreInventaire selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private LigneRegistreInventaireFacade getFacade() {
        return ejbFacade;
    }

    public LigneRegistreInventaire prepareCreate() {
        selected = new LigneRegistreInventaire();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("LigneRegistreInventaireCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("LigneRegistreInventaireUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("LigneRegistreInventaireDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<LigneRegistreInventaire> getItems() {
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

    public LigneRegistreInventaire getLigneRegistreInventaire(java.lang.Long id) {
        return getFacade().find(id);
    }

    public List<LigneRegistreInventaire> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<LigneRegistreInventaire> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = LigneRegistreInventaire.class)
    public static class LigneRegistreInventaireControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            LigneRegistreInventaireController controller = (LigneRegistreInventaireController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "ligneRegistreInventaireController");
            return controller.getLigneRegistreInventaire(getKey(value));
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
            if (object instanceof LigneRegistreInventaire) {
                LigneRegistreInventaire o = (LigneRegistreInventaire) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), LigneRegistreInventaire.class.getName()});
                return null;
            }
        }

    }

}
