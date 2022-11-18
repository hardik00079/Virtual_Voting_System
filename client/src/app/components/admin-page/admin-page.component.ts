import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { User } from 'src/app/model/User';
import { dateFormat } from 'src/app/utils/dateFormat';

@Component({
  selector: 'app-admin-page',
  templateUrl: './admin-page.component.html',
  styleUrls: ['./admin-page.component.css']
})
export class AdminPageComponent implements OnInit {

  users: any;
  searchInput: string ="";
  searchResults: any;
  polls: any;
  poll:any;

  constructor(private httpClient: HttpClient, private router: Router) { }

  ngOnInit(): void {

    this.httpClient.get('http://localhost:8080/user/').subscribe(data=>{
      this.users = data;
    })
    this.httpClient.get('http://localhost:8080/api/v1/polls/').subscribe(data=>{
      this.polls = data;
      for( let i = 0; i< this.polls.length; i++) {
        this.polls[i].publishDate = dateFormat(this.polls[i].publishDate, 'MM-dd-yyyy');
      }
    })
  }

  delete(id: number, firstName: string, lastName: string) {
    if(confirm("Are you sure you want to delete " + firstName + " " + lastName)) {
      var url = "http://localhost:8080/user/delete/" + id;
      this.httpClient.delete(url).subscribe(data => window.location.reload())
    }
  }

  deletepoll(id: number, pollName: string, category: string) {
    if(confirm("Are you sure you want to delete " + pollName + " " + category)) {
      var url = "http://localhost:8080/api/v1/polls/" + id;
      this.httpClient.delete(url).subscribe(data => window.location.reload());
    }
  }
  /*
  updatepoll(id: number, pollName: string, category: string) {
    if(confirm("Are you sure you want to update " + pollName + " " + category)) {
      var url = "http://localhost:8080/api/v1/polls/" + id;
      this.httpClient.delete(url).subscribe(data => window.location.reload());
    }
  }
  */
  viewpoll(id: number, pollName: string, category: string){
    var url = "http://localhost:8080/api/v1/polls/id/" + id;

    this.httpClient.get(url).subscribe(data => {
      this.poll = data});
      const myObj = JSON.stringify(this.poll);
      console.log(myObj);
      localStorage.setItem("testJSON", myObj);
      this.router.navigate(['/view-poll', { my_object: myObj}]);
    //this.router.navigate(["/view-poll"]);
    }


  async makeVoter(user: User) {
    await this.httpClient.put("http://localhost:8080/user/update",
    {
      "userId": user.userId,
      "firstName": user.firstName,
      "lastName": user.lastName,
      "email": user.email,
      "username": user.username,
      "password": user.password,
      "role": "voter"
    })
    .subscribe(data=> {window.location.reload()}
    );
   // window.location.reload();
  }

  search() {
    var url = "http://localhost:8080/user/username/" + this.searchInput;
    this.httpClient.get(url).subscribe(response => this.searchResults = response);

  }

}


