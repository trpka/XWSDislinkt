import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AgentUser } from '../model/AgentUser';
import { AgentServiceService } from '../service/agent-service.service';

@Component({
  selector: 'app-all-agents',
  templateUrl: './all-agents.component.html',
  styleUrls: ['./all-agents.component.css']
})
export class AllAgentsComponent implements OnInit {

  newAgent: AgentUser;
  agents: AgentUser[];

  constructor(private agentService: AgentServiceService, private router: Router) { }

  ngOnInit(): void 
  {
    this.LoadData();
  }

  LoadData()
  {
    this.agentService.getAgents()
    .subscribe(res => this.agents = res)
  }

  AddNewAgent()
  {
    this.router.navigate(['agent/registration']);
  }

}
