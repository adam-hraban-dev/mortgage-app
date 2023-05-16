package cz.ahraban.mortgage.controller;

import cz.ahraban.mortgage.persistence.model.CustomerDTO;
import cz.ahraban.mortgage.service.CustomerServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerServiceImpl customerService;

    @GetMapping("/hello")
    String helloWorld(){

        if (true) {
            throw new IllegalStateException("illegal state");
        }

        return "Hello-world";
    }

    @GetMapping("/{id}")
    CustomerDTO getById(@PathVariable Long id){
        return null;
    }

    @PutMapping("/{id}")
    @ResponseStatus
    String update(@PathVariable Long id, @RequestBody CustomerDTO customerDTO) {
            System.out.println(customerDTO);

            if (true) {
                throw new RuntimeException("vyjimka");
            }
            return "message received";
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    CustomerDTO create(@RequestBody CustomerDTO customerDTO) {
       try {
           return customerService.createCustomer(customerDTO);
       } catch (Exception e) {
           System.out.println(e.getMessage());
           return null;
       }
    }
}
