package com.example.agentApplication.Repository;

import com.example.agentApplication.model.AgentUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentRepository extends MongoRepository<AgentUser, Long>
{
    AgentUser getAgentUserByUsername(String username);
    AgentUser getAgentById(Long id);
}
