import { Component, OnInit } from '@angular/core';
import { AgentUser } from '../model/AgentUser';
import { AgentServiceService } from '../service/agent-service.service';

@Component({
  selector: 'app-registration-agent',
  templateUrl: './registration-agent.component.html',
  styleUrls: ['./registration-agent.component.css']
})
export class RegistrationAgentComponent implements OnInit 
{
   newAgent:AgentUser;
   agents:AgentUser[];

  constructor(private agentService: AgentServiceService) 
  {
     this.newAgent = new AgentUser
     (
      {
        id:0,
        firstName: "",
        lastName: "",
        email: "",
        username: "",
        password: "",
        phone: ""
      }
     );

     this.agents = [];

  }

  ngOnInit(): void 
  {
    this.RegistrationAgent()
  }

  RegistrationAgent()
  {
     console.log(this.newAgent)
     this.agentService.registrationAgent(this.newAgent)
     .subscribe(_=>this.reloadData());
  }

  reloadData()
  {

  }

}
