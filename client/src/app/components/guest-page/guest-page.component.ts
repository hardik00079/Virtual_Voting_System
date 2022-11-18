import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { dateFormat } from 'src/app/utils/dateFormat';

@Component({
  selector: 'app-guest-page',
  templateUrl: './guest-page.component.html',
  styleUrls: ['./guest-page.component.css']
})
export class GuestPageComponent implements OnInit {

  polls: any;

  constructor(private httpClient: HttpClient) { }

  ngOnInit(): void {
    this.httpClient.get('http://localhost:8080/api/v1/polls/').subscribe(data=>{
      this.polls = data;
      for( let i = 0; i< this.polls.length; i++) {
        this.polls[i].publishDate = dateFormat(this.polls[i].publishDate, 'MM-dd-yyyy');
      }
      //window.location.replace("/home");
    })
     
  }

}
