

package sec.project.domain;

import javax.persistence.Entity;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Topic extends AbstractPersistable<Long> {

    private String name;
    private String address;

    public Topic() {
        super();
    }

    public Topic(String name) {
        this();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}