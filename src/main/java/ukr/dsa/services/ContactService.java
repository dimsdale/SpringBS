package ukr.dsa.services;

import ukr.dsa.model.Contact;

import java.util.List;

/**
 * Created by Surger on 10.05.2016.
 */
public interface ContactService {

    public void createContact(Contact contact);

    public void editContact (Contact contact);

    public List<Contact> getContactListFromUserLogin(String login);

    public void deleteContact(int id);
}
