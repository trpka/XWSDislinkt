import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FindProfileForUpdatedComponent } from './find-profile-for-updated.component';

describe('FindProfileForUpdatedComponent', () => {
  let component: FindProfileForUpdatedComponent;
  let fixture: ComponentFixture<FindProfileForUpdatedComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FindProfileForUpdatedComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FindProfileForUpdatedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
