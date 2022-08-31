import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegistrationAgentComponent } from './registration-agent.component';

describe('RegistrationAgentComponent', () => {
  let component: RegistrationAgentComponent;
  let fixture: ComponentFixture<RegistrationAgentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegistrationAgentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RegistrationAgentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
