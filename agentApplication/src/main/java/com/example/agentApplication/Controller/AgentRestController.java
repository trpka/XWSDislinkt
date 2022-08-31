package com.example.agentApplication.Controller;

import com.example.agentApplication.Service.AgentService;
import com.example.agentApplication.model.AgentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin("*")
@RestController
public class AgentRestController
{
    @Autowired
    AgentService agentService;

    @RequestMapping(value="api/agent/registration",method = RequestMethod.POST,
            consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AgentUser> registration(@RequestBody AgentUser agentUser)
    {


        AgentUser savedUser=this.agentService.registration(agentUser);

        return new ResponseEntity("Succesfully created a new account!", HttpStatus.CREATED);
    }

    //Prikaz svi korisnika
    @RequestMapping(value="api/agents",method = RequestMethod.GET,produces = {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<List<AgentUser>> findAll()
    {
        List<AgentUser> users=this.agentService.findAll();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }


}
