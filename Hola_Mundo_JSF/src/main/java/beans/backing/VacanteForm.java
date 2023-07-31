
package beans.backing;

import beans.model.Candidato;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class VacanteForm {
    
    @Inject //Hace la CDI (Context Dependence Injection)
    private Candidato candidato;
    
    public void setCandidato(Candidato candidato){
        this.candidato = candidato;
    }
    
    public String enviar(){
        if("Juana".equals(this.candidato.getNombre())){
            return "exito";
        }
        else
            return "fallo";
    }
    
}
