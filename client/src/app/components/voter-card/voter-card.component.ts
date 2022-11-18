import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Poll } from 'src/app/model/Poll';

@Component({
  selector: 'app-voter-card',
  templateUrl: './voter-card.component.html',
  styleUrls: ['./voter-card.component.css']
})
export class VoterCardComponent implements OnInit {


  polls: any;

  constructor(private httpClient: HttpClient) { }

  ngOnInit(): void {
    this.httpClient.get('http://localhost:8080/poll/').subscribe(data=>{
      this.polls = data;
    })

  }

  //fix this
  displayVoteOptions(poll: Poll) {
    this.httpClient.put("http://localhost:8080/poll/update",
    {
      "userId": poll.pollId,

    })
    .subscribe(data=> {window.location.reload()}
    );
    // window.location.reload();
  }

}
