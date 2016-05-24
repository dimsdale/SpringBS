package ukr.dsa.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ukr.dsa.model.Contact;
import ukr.dsa.repositories.ContactRepository;
import ukr.dsa.services.ContactService;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public void createContact(Contact contact) {
        contactRepository.saveAndFlush(contact);
    }

    @Override
    public void editContact(Contact contact) {
        contactRepository.saveAndFlush(contact);
    }

    @Override
    public List<Contact> getContactListFromUserLogin(String login) {
        return contactRepository.findByLogin(login);
    }


    @Override
    public void deleteContact(int id) {
        contactRepository.delete(id);
    }

}
