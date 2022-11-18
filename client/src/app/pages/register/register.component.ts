import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  firstName: String = "";
  lastName: String = "";
  email: String = "";
  username: string = "";
  password: String = "";

  constructor(private httpClient: HttpClient, private router: Router) { }

  ngOnInit(): void {
  }

  register() {


    this.httpClient.post("http://localhost:8080/user/add",
    {
      "firstName": this.firstName,
      "lastName": this.lastName,
      "email": this.email,
      "username": this.username,
      "password": this.password,
      "role": "guest"
    })
    .subscribe(response => {localStorage.setItem('logged_in_username', this.username);
    this.router.navigate(["/home"]);
    window.location.replace("/home");
  });


  }

}
