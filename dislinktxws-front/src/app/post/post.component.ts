import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Post } from '../model/post.model';
import { PostService } from '../service/post.service';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})
export class PostComponent implements OnInit {

  postToAdd:Post;
  posts:Post[];
  idOfUser:any;
  id:number;
  selectedFile: File;
  linkk:string;
  constructor(private postService:PostService, private userService: UserService, private router: Router, private http: HttpClient) { 

    this.postToAdd=new Post(
      {
        id: 0,
        ownerId:0,
        text:"",
        userIdWhoLikes:[],
        userIdWhoDislikes:[],
        comments:[],
        numberOfLikes:0,
        numberOfDislikes:0
      });
      this.posts = [];
  }

  ngOnInit(): void {
    this.reloadData();
    this.loadUser();
  }

  reloadData() {
    this.postService.getPosts()
    .subscribe(res=>this.posts=res);
  }
    

  savePost(){ 
    var path_picture="/assets/picturePost/"+this.selectedFile.name;
    this.postToAdd.picture = path_picture
    this.postService.save(this.postToAdd)
    .subscribe(_=>this.reloadData())
  }
  loadUser(){
    this.idOfUser = sessionStorage.getItem('id');
    this.postToAdd.ownerId=this.idOfUser;
    /*
    this.userService.findUserById(this.idOfUser)
    .subscribe(res=>this.postToAdd.ownerId=res.id)*/
}

backToProfile()
{
  this.id = Number(sessionStorage.getItem('id'))
  this.router.navigate(['/profile', this.id]);
}

public onFileChanged(event: any) {
  this.selectedFile = event.target.files[0];
}
onUpload() {
  console.log(this.selectedFile);

  //FormData API provides methods and properties to allow us easily prepare form data to be sent with POST HTTP requests.
  const uploadImageData = new FormData();
  uploadImageData.append('file', this.selectedFile, this.selectedFile.name);
  this.http.post('http://localhost:8081/upload', uploadImageData)
    .subscribe((response) => {

    }
    );
}
}
