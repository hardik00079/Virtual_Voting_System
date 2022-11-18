import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule } from '@angular/forms';



@Component({
  selector: 'app-vote-input',
  templateUrl: './vote-input.component.html',
  styleUrls: ['./vote-input.component.css']
})
export class VoteInputComponent implements OnInit {

  contactForm!: FormGroup;

  optionsVote = [
    { id: 1, name: "Australia" },
    { id: 2, name: "UK" },
    { id: 3, name: "Canada" },
    { id: 4, name: "Germany" },
    { id: 5, name: "Singapore" }
  ];
  constructor(private fb: FormBuilder) { }

  ngOnInit() {
    this.contactForm = this.fb.group({
      optionVote:[null]
    });
  }

  submit() {
    console.log("Form Submitted")
    console.log(this.contactForm.value)
  }

}
