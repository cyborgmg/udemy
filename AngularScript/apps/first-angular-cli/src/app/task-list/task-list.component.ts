import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-task-list',
  templateUrl: './task-list.component.html',
  styleUrls: ['./task-list.component.css']
})
export class TaskListComponent implements OnInit {

  tasks = [];
  task = "";
  isAdmin = false;

  constructor() { }

  ngOnInit() {
  }

  add():void{
    this.tasks.push(this.task);
  }

}
