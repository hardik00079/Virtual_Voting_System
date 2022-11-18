
import { JsonPipe } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import {Component, OnInit, ChangeDetectorRef} from '@angular/core';
import { ActivatedRoute, Router, NavigationStart, Params } from '@angular/router';
import { map, filter} from 'rxjs/operators';
import { dateFormat } from 'src/app/utils/dateFormat';

//import { Observable} from 'rxjs/observable';

@Component({
  selector: 'app-view-poll',
  templateUrl: './view-poll.component.html',
  styleUrls: ['./view-poll.component.css']
})
export class ViewPollComponent implements OnInit {

  poll: any;
  //today: String = dateFormat(new Date(), 'MM-dd-yyyy');

  loggedIn: Boolean = false;
  username: any;
  user: any;
  product: any;
  user_id: any;

  constructor(private router:Router, private activatedRoute:ActivatedRoute, private httpClient: HttpClient) {
       //console.log(this.router.getCurrentNavigation()?.extras.state);
  }

  ngOnInit() {


    this.activatedRoute.queryParams.subscribe((queryParams: Params) => {
              console.log(queryParams.unit);
              this.user_id = queryParams.unit;
        this.product = queryParams;
    });
    localStorage.setItem('logged_in_poll_id', this.user_id);

    if(localStorage.getItem('logged_in_username')){
      this.loggedIn = true;
      this.username = localStorage.getItem('logged_in_username');
    }
    console.log(this.username);
    var url = "http://localhost:8080/user/username/" + this.username;
    this.httpClient.get(url).subscribe(data => (this.user = data));





    console.log(this.user_id);
    this.httpClient.get('http://localhost:8080/api/v1/polls/id/' + this.user_id ).subscribe(data=>{
      this.poll = data;
     
        this.poll.publishDate = dateFormat(this.poll.publishDate, 'MM-dd-yyyy');
      
      /*
      for( let i = 0; i< this.polls.length; i++) {
        this.polls[i].publishDate = dateFormat(this.polls[i].publishDate, 'MM-dd-yyyy');
      } */
    })

  }


}
