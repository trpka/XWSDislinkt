import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {


  id:number;
  constructor(private router:Router) { }


  ngOnInit(): void {
  }

  goToProfile(){
    this.id = Number(sessionStorage.getItem('id'))
    this.router.navigate(['/profile', this.id]);
  }

}

