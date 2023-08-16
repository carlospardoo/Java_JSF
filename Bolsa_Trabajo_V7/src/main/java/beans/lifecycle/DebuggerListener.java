package beans.lifecycle;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DebuggerListener implements PhaseListener {
    
    Logger log = LogManager.getRootLogger();
    
    @Override
    public void beforePhase(PhaseEvent event) {
        if (log.isInfoEnabled()) {
            log.info("Antes de la fase: " + event.getPhaseId().toString());
        }
    }
    
    @Override
    public void afterPhase(PhaseEvent event) {
        if (log.isInfoEnabled()) {
            log.info("Después de la fase: " + event.getPhaseId().toString());
        }
    }
    
    @Override
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }
    
}
