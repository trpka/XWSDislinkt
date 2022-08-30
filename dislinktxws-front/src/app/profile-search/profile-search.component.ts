import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Post } from '../model/post.model';
import { Profile } from '../model/profile';
import { ProfileService } from '../service/profile.service';


@Component({
  selector: 'app-profile-search',
  templateUrl: './profile-search.component.html',
  styleUrls: ['./profile-search.component.css']
})
export class ProfileSearchComponent implements OnInit 
{
  id:any;
  profile:Profile;
  posts:Post[];
  username:string;
  password: string;
  listsOfExperiance:string='';
  

  idFollower:any;
  idUser: number;
  
  listsOfEducation:string='';
  listsOfSkills:string='';
  listsOfInterests:string='';

  
  
  constructor(private route: ActivatedRoute, private profileService:ProfileService) { }

  ngOnInit(): void 
  {
     this.loadProfile();
     //this.findProfileById();
     //this.findPosts();
  }

  loadProfile()
  {
     this.username = this.route.snapshot.params['username'];
     this.password = this.route.snapshot.params['password'];
    
    this.profileService.searchProfileByUsername(this.username)
    .subscribe(res =>{this.profile=res;
      this.insertExperianceIntoString(res.experience);
      this.insertEducationIntoString(res.education);
      this.insertSkillsIntoString(res.skills);
      this.insertInterestsIntoString(res.interests)})
   

    this.findPosts()


  }

  

  findPosts()
  {
    this.id = sessionStorage.getItem('id');


    this.profileService.findAllPostsByOwnerId(this.profile.user.id).subscribe((res: Post[]) => {
      this.posts = res;
    });
  }  

  UpdateProfile()
  {
    this.profile.experience=this.listsOfExperiance.split(",");

    this.profile.education = this.listsOfEducation.split(",");
    this.profile.skills = this.listsOfSkills.split(",");
    this.profile.interests = this.listsOfInterests.split(",");

    this.profileService.UpdateProfile(this.profile)
    .subscribe(res => this.profile=res)
    window.location.reload()
    
  }

  //Lista Iskustva
  insertExperianceIntoString(experiance:string[])
  {
    var listsExperiance:string[]=[];
    experiance.forEach(function(lan:string){
      listsExperiance.push(lan)
    })
    this.listsOfExperiance=listsExperiance.join(",")
  }

  insertEducationIntoString(education:string[])
  {
    var listsEducation:string[]=[];
    education.forEach(function(lan:string){
      listsEducation.push(lan)
    })
    this.listsOfEducation=listsEducation.join(",")
  }

  insertSkillsIntoString(skills:string[])
  {
    var listsSkills:string[]=[];
    skills.forEach(function(lan:string)
    {
      listsSkills.push(lan);
    })

    this.listsOfSkills=listsSkills.join(",");

  }

  insertInterestsIntoString(interests:string[])
  {
    var listsInterests:string[]=[];
    interests.forEach(function(lan:string)
    {
        listsInterests.push(lan);
    })

    this.listsOfInterests=listsInterests.join(",");
  }
  
  

}
