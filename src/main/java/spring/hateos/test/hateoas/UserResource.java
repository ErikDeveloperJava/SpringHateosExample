package spring.hateos.test.hateoas;

import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.ResourceSupport;

public class UserResource extends ResourceSupport {

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String surname;
}