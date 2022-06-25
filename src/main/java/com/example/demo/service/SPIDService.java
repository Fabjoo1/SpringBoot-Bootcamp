package com.example.demo.service;
import com.example.demo.enteties.SPID;
import com.example.demo.enteties.Status;
import com.example.demo.enteties.User;
import org.springframework.stereotype.Service;

public class SPIDService {
    public SPID createSpid(SPID spid) {
        return new SPID(
                spid.getId(),
                spid.getUser(),
                spid.getStatus(),
                spid.getDescription()
        );
    }

    public void editSpid(SPID spid, long id, User user, Status status, String description) {
        spid.setId(id);
        spid.setUser(user);
        spid.setStatus(status);
        spid.setDescription(description);
    }
}
