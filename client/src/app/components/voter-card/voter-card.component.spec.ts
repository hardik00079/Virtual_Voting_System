import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VoterCardComponent } from './voter-card.component';

describe('VoterCardComponent', () => {
  let component: VoterCardComponent;
  let fixture: ComponentFixture<VoterCardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VoterCardComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(VoterCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
