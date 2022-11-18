import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { dateFormat } from '../../utils/dateFormat';
import { Router } from '@angular/router';

@Component({
  selector: 'app-landing',
  templateUrl: './landing.component.html',
  styleUrls: ['./landing.component.css']
})
export class LandingComponent implements OnInit {

  polls: any;
  loggedIn: Boolean = false;
  constructor(private httpClient: HttpClient, private router: Router) { }

  ngOnInit(): void {
    if(localStorage.getItem('logged_in_username')){
      this.loggedIn = true;

    }
    this.httpClient.get('http://localhost:8080/api/v1/polls/').subscribe(data=>{
      this.polls = data;
      for( let i = 0; i< this.polls.length; i++) {
        this.polls[i].publishDate = dateFormat(this.polls[i].publishDate, 'MM-dd-yyyy');
      }
    })
  }

   delete(id: number, pollName: string, category: string) {
    if(confirm("Are you sure you want to delete " + pollName + " " + category)) {
      var url = "http://localhost:8080/api/v1/polls/" + id;
      this.httpClient.delete(url).subscribe(data => window.location.reload());
    }
  }
  viewpoll(id: number, pollName: string, category: string){
    var url = "http://localhost:8080/api/v1/polls/id/" + id;

    this.httpClient.get(url).subscribe(data => {
      this.polls = data});
      const myObj = JSON.stringify(this.polls);
      console.log(myObj);
      localStorage.setItem("testJSON", myObj);
      this.router.navigate(['/view-poll', { my_object: myObj}]);
    //this.router.navigate(["/view-poll"]);
    }
}
