import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './pages/login/login.component';
import { RegisterComponent } from './pages/register/register.component';
import { HomeComponent } from './pages/home/home.component';

import { FdmEmailDirective } from './fdm-email.directive';
import { PasswordDirective } from './password.directive';

import { VoterCardComponent } from './components/voter-card/voter-card.component';
import { AdminPageComponent } from './components/admin-page/admin-page.component';
import { VoterPageComponent } from './components/voter-page/voter-page.component';
import { OwnerPageComponent } from './components/owner-page/owner-page.component';
//import { VoterPageComponent } from './components/voter-page/voter-page.component';
import { GuestPageComponent } from './components/guest-page/guest-page.component';
import { NavComponent } from './components/nav/nav.component';
import { AddPollComponent } from './pages/add-poll/add-poll.component';
import { LandingComponent } from './pages/landing/landing.component';
import { VoteComponent } from './pages/vote/vote.component';
import { VoteInputComponent } from './pages/vote-input/vote-input.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { AddPollMembersComponent } from './pages/add-poll-members/add-poll-members.component';
import { ViewPollComponent } from './pages/view-poll/view-poll.component';
import { FooterComponent } from './components/footer/footer.component';
//import { FooterComponent } from './components/footer/footer.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,

    FdmEmailDirective,
    PasswordDirective,
    VoteInputComponent,
    VoterCardComponent,
     AdminPageComponent,
     VoterPageComponent,
     OwnerPageComponent,
     //VoterPageComponent,
     GuestPageComponent,
     NavComponent,
     AddPollComponent,
     LandingComponent,
     VoteComponent,
     AddPollMembersComponent,
     ViewPollComponent,
     FooterComponent,
     //FooterComponent


  ],
  imports: [
    BrowserModule,
    //NgbModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
