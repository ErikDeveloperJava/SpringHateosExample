package spring.hateos.test.hateoas;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;
import spring.hateos.test.controller.UserRestController;
import spring.hateos.test.model.User;

@Component
public class UserResourceAssembler extends ResourceAssemblerSupport<User,UserResource> {

    public UserResourceAssembler() {
        super(UserRestController.class, UserResource.class);
    }

    @Override
    public UserResource toResource(User user) {
        UserResource userResource = createResourceWithId(user.getId(), user);
        userResource.setName(user.getName());
        userResource.setSurname(user.getSurname());
        return userResource;
    }
}
