import { Component, OnInit } from '@angular/core';
import { CommentService } from './comment.service';
import { Comment } from './comment.modelo';

@Component({
  selector: 'app-comments',
  templateUrl: './comments.component.html',
  styleUrls: ['./comments.component.css']
})
export class CommentsComponent implements OnInit {

  comments: Comment[];
    
  constructor(private commetsService:CommentService) { }

  ngOnInit() {

    this.commetsService.getComments().subscribe(comments => this.comments = comments)

  }

}
