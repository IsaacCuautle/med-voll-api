package med.voll.api.controllers;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.dto.consultations.DataScheduleConsultation;
import med.voll.api.services.consultation.ConsultationSchedulingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("/consultation")
@SecurityRequirement(name = "bearer-key")
public class ConsultationController
{

    @Autowired
    private ConsultationSchedulingService service;

    @PostMapping
    @Transactional
    public ResponseEntity schedulingConsultation(@RequestBody @Valid DataScheduleConsultation data)
    {

        var response = service.scheduling(data);
        return ResponseEntity.ok(response);
    }
}
