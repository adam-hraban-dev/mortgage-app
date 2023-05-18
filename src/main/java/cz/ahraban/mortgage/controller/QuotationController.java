package cz.ahraban.mortgage.controller;

import cz.ahraban.mortgage.exception.ApplicationException;
import cz.ahraban.mortgage.persistence.model.QuotationDTO;
import cz.ahraban.mortgage.persistence.model.mapper.QuotationControllerMapper;
import cz.ahraban.mortgage.service.QuotationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Adam Hrabaň <a hrej="mailto:adam.hraban@seznam.cz">adam.hraban@seznam.cz</a>
 */
@RestController
@RequestMapping("quotation")
@RequiredArgsConstructor
public class QuotationController {

    private final QuotationService quotationService;
    private final QuotationControllerMapper mapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    QuotationDTO create(@RequestBody QuotationDTO quotationDTO) throws ApplicationException {
        return mapper.toQuotationDTO(quotationService.create(mapper.toQuotationDO(quotationDTO)));
    }
}
