import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from 'src/app/model/User';
import { Router } from '@angular/router';
import { dateFormat } from 'src/app/utils/dateFormat';

@Component({
  selector: 'app-add-poll-members',
  templateUrl: './add-poll-members.component.html',
  styleUrls: ['./add-poll-members.component.css']
})
export class AddPollMembersComponent implements OnInit {

  loggedIn: Boolean = false;
  username: any;
  user: any;
  users: any;
  polls: any;
  voteDate: Date = new Date();
  poll: any;
  user_id:any;

  constructor(private httpClient: HttpClient, private router: Router) { }

  ngOnInit(): void {
    this.httpClient.get('http://localhost:8080/user/').subscribe(data=>{
      this.users = data;
    })
    if(localStorage.getItem('logged_in_username')){
      this.loggedIn = true;
      this.username = localStorage.getItem('logged_in_username');
    }
    console.log(this.username);
    var url = "http://localhost:8080/user/username/" + this.username;
    this.httpClient.get(url).subscribe(data => (this.user = data));

  }

  addVote(user: User){
    //console.log( user.userId);
    //console.log(this.voteDate);
    //console.log(this.user);
    //console.log(this.poll);

    this.user_id = localStorage.getItem('logged_in_poll_id');
    this.httpClient.get('http://localhost:8080/api/v1/polls/').subscribe(data=>{
      this.poll = data;
        this.poll.publishDate = dateFormat(this.poll.publishDate, 'MM-dd-yyyy');
    })

      this.httpClient.post("http://localhost:8080/api/v1/votes",
        {
          "user": this.user,
          "date": this.voteDate,
          "voter": this.user,
          "poll": this.poll,
        }).subscribe(response => this.router.navigate(["/home"]));
        //.subscribe(response => {localStorage.setItem('logged_in_username', this.username);
        //this.router.navigate(["/home"]);
  }


}
