package spring.hateos.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.hateos.test.hateoas.UserResource;
import spring.hateos.test.model.User;
import spring.hateos.test.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserRestController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ResourceAssemblerSupport<User, UserResource> userResourceAssembler;

    @GetMapping
    public ResponseEntity users(){
        List<UserResource> userResourceList = userRepository.findAll()
                .stream()
                .map(userResourceAssembler::toResource)
                .collect(Collectors.toList());
        return ResponseEntity.ok(userResourceList);
    }
}