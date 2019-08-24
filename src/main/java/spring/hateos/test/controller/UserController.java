package spring.hateos.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.data.web.SortDefault;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.hateos.test.hateoas.UserResource;
import spring.hateos.test.model.User;
import spring.hateos.test.repository.UserRepository;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private ResourceAssemblerSupport<User, UserResource> userResourceAssembler;

    @Autowired
    private PagedResourcesAssembler<User> pagedResourcesAssembler;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/all")
    public String allUsers(@SortDefault(sort = "id",direction = Sort.Direction.DESC)Pageable pageable, Model model){
        Page<User> userPage = userRepository.findAll(pageable);
        PagedResources<UserResource> userResources = pagedResourcesAssembler.toResource(userPage, userResourceAssembler);
        model.addAttribute("userResource",userResources);
        return "user";
    }
}