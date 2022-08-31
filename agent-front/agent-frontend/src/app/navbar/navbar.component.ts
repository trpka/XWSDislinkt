import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  id :number;
  constructor(
  ) {
    this.id =0;
   }

  ngOnInit(): void {
  }

}
