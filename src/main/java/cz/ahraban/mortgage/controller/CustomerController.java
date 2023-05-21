package cz.ahraban.mortgage.controller;

import cz.ahraban.mortgage.exception.ApplicationException;
import cz.ahraban.mortgage.domainapi.CustomerDTO;
import cz.ahraban.mortgage.domainapi.mapper.CustomerControllerMapper;
import cz.ahraban.mortgage.service.CustomerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Adam Hrabaň <a hrej="mailto:adam.hraban@seznam.cz">adam.hraban@seznam.cz</a>
 */
@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerServiceImpl customerService;
    private final CustomerControllerMapper mapper;

    @GetMapping("/{id}")
    CustomerDTO getById(@PathVariable Long id) throws ApplicationException {
        return mapper.toCustomerDTO(customerService.getById(id));
    }

    @PutMapping("/{id}")
    @ResponseStatus
    CustomerDTO update(@PathVariable Long id, @RequestBody CustomerDTO customerDTO) throws ApplicationException {
            return mapper.toCustomerDTO(customerService.update(id, mapper.toCustomerDO(customerDTO)));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    CustomerDTO create(@RequestBody CustomerDTO customerDTO) {
           return mapper.toCustomerDTO(customerService.create(mapper.toCustomerDO(customerDTO)));
    }
}
