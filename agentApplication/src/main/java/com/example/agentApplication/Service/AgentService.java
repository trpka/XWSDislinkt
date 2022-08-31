package com.example.agentApplication.Service;


import com.example.agentApplication.Repository.AgentRepository;
import com.example.agentApplication.model.AgentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgentService
{
    @Autowired
    private AgentRepository agentRepository;

    public AgentUser getAgentUserByUsername(String username)
    {
        AgentUser au = agentRepository.getAgentUserByUsername(username);
        return  au;
    }

    public AgentUser getAgentByID(Long id)
    {
        AgentUser au = agentRepository.getAgentById(id);
        return  au;
    }

    public List<AgentUser> findAll()
    {
        return  this.agentRepository.findAll();
    }

    public AgentUser registration(AgentUser agentUser)
    {
        List<AgentUser> listOfAll = this.agentRepository.findAll();

        if(agentRepository.getAgentUserByUsername(agentUser.getUsername()) != null)
        {
            System.out.println("Agent User with this username already exist!");
            return  null;
        }
        else if(agentUser.getFirstName().isEmpty() || agentUser.getLastName().isEmpty())
        {
            return  null;
        }

        Long id = (long)0;
        for(AgentUser au: listOfAll)
        {
            id = au.getId();
        }
        id = id + 1;
        agentUser.setId(id);

        return this.agentRepository.save(agentUser);

    }


}
