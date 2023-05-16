package cz.ahraban.mortgage.controller;

import cz.ahraban.mortgage.persistence.model.CustomerDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Adam Hrabaň <a hrej="mailto:adam.hraban@seznam.cz">adam.hraban@seznam.cz</a>
 */
@Slf4j
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @GetMapping("/hello")
    String helloWorld(){
        if (true) {
            throw new IllegalStateException("illegal state");
        }

        return "Hello-world";
    }

    @PutMapping
    //ResponseEntity<String> putCustomer(@RequestBody CustomerDTO customerDTO) {
    String putCustomer(@RequestBody CustomerDTO customerDTO) {
            System.out.println(customerDTO);

            if (true) {
                throw new RuntimeException("vyjimka");
            }
            return "message received";
            //return ResponseEntity.of("received");
        /*} catch (Exception e) {
            return e.getMessage();*/
    }
}
