
package beans.backing;

import beans.model.Candidato;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIInput;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Named
@RequestScoped
public class VacanteForm {
    
    Logger log = LogManager.getRootLogger();
    
    @Inject //Hace la CDI (Context Dependence Injection)
    private Candidato candidato;

    public VacanteForm() {
        log.info("Creando el objeto VacanteForm");
    }
    
    public void setCandidato(Candidato candidato){
        this.candidato = candidato;
    }
    
    public String enviar(){
        if("Juana".equals(this.candidato.getNombre())){
            if(this.candidato.getApellido().equals("Perez")){
                String msg = "Gracias, pero Juan Perez ya trabaja con nosotros.";
                FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
                FacesContext facesContext = FacesContext.getCurrentInstance();
                String componentId = null; //este es un mensaje global. No a un componente
                facesContext.addMessage(componentId, facesMessage);
                return "index";
            }
            log.info("Entrando al caso de éxito");
            return "exito";
        }
        else{
            log.info("Entrando al caso de fallo");
            return "fallo";
        }
            
    }
    
    public void codigoPostalListener(ValueChangeEvent valueChangeEvent){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        UIViewRoot uIViewRoot = facesContext.getViewRoot();
        
        String nuevoCodigoPostal = valueChangeEvent.getNewValue().toString();
        if("03810".equals(nuevoCodigoPostal)){
            UIInput coloniaInputText = (UIInput) uIViewRoot.findComponent("vacanteForm:colonia");
            String nuevaColonia = "Napoles";
            coloniaInputText.setValue(nuevaColonia);
            coloniaInputText.setSubmittedValue(nuevaColonia);
            
            UIInput ciudadInputText = (UIInput) uIViewRoot.findComponent("vacanteForm:ciudad");
            String nuevaCiudad = "Ciudad de México";
            ciudadInputText.setValue(nuevaCiudad);
            ciudadInputText.setSubmittedValue(nuevaCiudad);
            
            facesContext.renderResponse();
        }
    }
    
}
