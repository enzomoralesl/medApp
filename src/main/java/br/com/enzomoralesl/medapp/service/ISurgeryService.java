package br.com.enzomoralesl.medapp.service;

import br.com.enzomoralesl.medapp.controller.surgery.model.SurgeryRequest;
import br.com.enzomoralesl.medapp.controller.surgery.model.SurgeryResponse;


public interface ISurgeryService {
    SurgeryResponse save(SurgeryRequest request);
}
