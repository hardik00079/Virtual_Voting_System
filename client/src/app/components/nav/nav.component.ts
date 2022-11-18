import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {

  loggedIn: Boolean = false;

  fdmLogo: String =  '../assets/images/fdm.webp';
  logoAlt: String = 'fdm'

  constructor() { }

  ngOnInit(): void {
    if(localStorage.getItem('logged_in_username')){
      this.loggedIn = true;

    }

  }

  logout() {
    localStorage.removeItem('logged_in_username');
    
    window.location.replace("/home");
    
  }
}
