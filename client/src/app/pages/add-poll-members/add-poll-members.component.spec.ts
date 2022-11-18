import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddPollMembersComponent } from './add-poll-members.component';

describe('AddPollMembersComponent', () => {
  let component: AddPollMembersComponent;
  let fixture: ComponentFixture<AddPollMembersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddPollMembersComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddPollMembersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
