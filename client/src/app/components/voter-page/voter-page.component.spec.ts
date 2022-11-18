import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VoterPageComponent } from './voter-page.component';

describe('VoterPageComponent', () => {
  let component: VoterPageComponent;
  let fixture: ComponentFixture<VoterPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VoterPageComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(VoterPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
