import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfilesIFollowPostsComponent } from './profiles-ifollow-posts.component';

describe('ProfilesIFollowPostsComponent', () => {
  let component: ProfilesIFollowPostsComponent;
  let fixture: ComponentFixture<ProfilesIFollowPostsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProfilesIFollowPostsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ProfilesIFollowPostsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
