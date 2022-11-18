import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/model/User';

@Component({
  selector: 'app-owner-page',
  templateUrl: './owner-page.component.html',
  styleUrls: ['./owner-page.component.css']
})
export class OwnerPageComponent implements OnInit {

  users: any;

  constructor(private httpClient: HttpClient) { }

  ngOnInit(): void {
    this.httpClient.get('http://localhost:8080/user/').subscribe(data=>{
      this.users = data;
    })

  }


  delete(id: number, firstName: string, lastName: string) {
    if(confirm("Are you sure you want to delete " + firstName + " " + lastName)) {
      var url = "http://localhost:8080/user/delete/" + id;
      this.httpClient.delete(url).subscribe(data => window.location.reload());
    }
  }

  makeAdmin(user: User) {
    this.httpClient.put("http://localhost:8080/user/update",
    {
      "userId": user.userId,
      "firstName": user.firstName,
      "lastName": user.lastName,
      "email": user.email,
      "username": user.username,
      "password": user.password,
      "role": "admin"
    })
    .subscribe(data=> {window.location.reload()}
    );
    // window.location.reload();
  }

}
