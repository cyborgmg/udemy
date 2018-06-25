import { Component } from '@angular/core';
import { User } from './user';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  
  title = 'Tasks';
  upperText: string = 'Display Uppercase text';
  lowerText:string='Display Lowercase text';
  percentValue: number = 0.5;
  date:Date = new Date();
  money: number=598;
  isAdmin2:boolean = true;
  profile: number = 2;

  user: User = {name:'Bob',age:25};


}
