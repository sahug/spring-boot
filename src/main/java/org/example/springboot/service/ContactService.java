package org.example.springboot.service;


import lombok.extern.slf4j.Slf4j;
import org.example.springboot.controller.ContactController;
import org.example.springboot.model.Contact;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.context.annotation.ApplicationScope;

@Slf4j
@Service

/**
 * @RequestScope creates an instance of the bean class for every HTTP request.
 * The instance exists only for that specific HTTP request.
 */
/* @RequestScope */

/**
 * @SessionScope creates an instance of the bean class and keeps the instance in the server's memory
 * for full HTTP session. Spring links the instance in  the context with the clien'ts session.
 */
/* @SessionScope */

/**
 * @ApplicationScope creates a unique instance of the bean class in the app context
 * and is available while the app is running.
 */
@ApplicationScope
public class ContactService {

    /*private static Logger log = LoggerFactory.getLogger(ContactService.class);*/

    /**
     * Save Contact Details into DB
     * @param contact
     * @return boolean
     */
    public boolean saveMessageDetails(Contact contact){
        boolean isSaved = true;
        //TODO - Need to persist the data into the DB table
        log.info(contact.toString());
        return isSaved;
    }

}
