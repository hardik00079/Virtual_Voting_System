import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { dateFormat } from '../../utils/dateFormat';

@Component({
  selector: 'app-voter-page',
  templateUrl: './voter-page.component.html',
  styleUrls: ['./voter-page.component.css']
})
export class VoterPageComponent implements OnInit {


  polls: any;
  today: String = dateFormat(new Date(), 'MM-dd-yyyy');

  loggedIn: Boolean = false;
  username: any;
  user: any;


  constructor(private httpClient: HttpClient) { }

  ngOnInit(): void {

    if(localStorage.getItem('logged_in_username')){
      this.loggedIn = true;
      this.username = localStorage.getItem('logged_in_username');
    }
    var url = "http://localhost:8080/user/username/" + this.username;
    this.httpClient.get(url).subscribe(data => (this.user = data));



  console.log(this.user);


    this.httpClient.get('http://localhost:8080/api/v1/polls/').subscribe(data=>{
      this.polls = data;
      for( let i = 0; i< this.polls.length; i++) {
        this.polls[i].publishDate = dateFormat(this.polls[i].publishDate, 'MM-dd-yyyy');
      }
    })
  }

}
