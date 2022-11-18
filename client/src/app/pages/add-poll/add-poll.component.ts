import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { dateFormat } from '../../utils/dateFormat';
import { Router } from "@angular/router";

@Component({
  selector: 'app-add-poll',
  templateUrl: './add-poll.component.html',
  styleUrls: ['./add-poll.component.css']
})
export class AddPollComponent implements OnInit {

  pollName: string = "";
  category: string = "";
  publishDate: Date = new Date();

  constructor(private httpClient: HttpClient, private router: Router) { }



  ngOnInit(): void {
  }

  addPoll() {
    this.httpClient.post("http://localhost:8080/api/v1/polls",
    {
      "pollName": this.pollName,
      "category": this.category,
      "publishDate": this.publishDate
    }).subscribe(response => this.router.navigate(["/home"]));

    // window.location.reload();
  }

}
