import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  loggedIn: Boolean = false;
  username: any;
  user: any;
  voteImage: String = '../assets/voting.jpg';

  constructor(private httpClient: HttpClient) { }

  ngOnInit(): void {

    if (localStorage.getItem('logged_in_username')) {
      this.loggedIn = true;
      this.username = localStorage.getItem('logged_in_username');
    }
    var url = "http://localhost:8080/user/username/" + this.username;
    this.httpClient.get(url).subscribe(data => (this.user = data));

    console.log(this.user);
  }

}
