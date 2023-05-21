package cz.ahraban.mortgage.controller;

import cz.ahraban.mortgage.domainapi.SubscriptionDTO;
import cz.ahraban.mortgage.domainapi.mapper.SubscriptionControllerMapper;
import cz.ahraban.mortgage.exception.ApplicationException;
import cz.ahraban.mortgage.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Adam Hrabaň <a hrej="mailto:adam.hraban@seznam.cz">adam.hraban@seznam.cz</a>
 */
@RestController
@RequestMapping("subscription")
@RequiredArgsConstructor
public class SubscriptionController {

    private final SubscriptionService subscriptionService;
    private final SubscriptionControllerMapper mapper;

    @GetMapping("/{id}")
    SubscriptionDTO getById(@PathVariable Long id) throws ApplicationException {
        return mapper.toSubscriptionDTO(subscriptionService.getById(id));
    }

    @PostMapping
    SubscriptionDTO create(@RequestBody SubscriptionDTO subscriptionDTO) throws ApplicationException {
        return mapper.toSubscriptionDTO(subscriptionService.create(mapper.toSubscriptionDO(subscriptionDTO)));
    }


}
