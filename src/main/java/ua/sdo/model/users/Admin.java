package ua.sdo.model.users;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "admin")
@DiscriminatorValue("Admin")
public class Admin extends User {
}
