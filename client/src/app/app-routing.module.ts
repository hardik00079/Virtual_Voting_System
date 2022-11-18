import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { LoginComponent } from './pages/login/login.component';
import { RegisterComponent } from './pages/register/register.component';
import { AddPollComponent } from './pages/add-poll/add-poll.component';
import { LandingComponent } from './pages/landing/landing.component';
import { VoteInputComponent } from './pages/vote-input/vote-input.component';
import { VoteComponent } from './pages/vote/vote.component';
import { ViewPollComponent } from './pages/view-poll/view-poll.component';

const routes: Routes = [
  {
    path: '',
    component: LandingComponent
  },
  {
    path: 'register',
    component: RegisterComponent
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'home',
    component: HomeComponent
  },
  {
    path: 'add_poll',
    component: AddPollComponent
  },
  {
    path: 'vote',
    component: VoteComponent
  },
  {
    path: 'vote-input',
    component: VoteInputComponent
  },
  {

    path: 'view-poll',
    component: ViewPollComponent

  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
