import { Component } from '@angular/core';
import { SharedService } from './services/shared.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  showTemplate: boolean = false;
  public shared: SharedService;

  constructor() {
    this.shared = SharedService.getInstance();
  }

  ngOnInit(): void {

    this.shared.showTemplate.subscribe(
      show => this.showTemplate = show
    );

  }

  showContentWarpper() {
    return {
      'content-wrapper': this.shared.isLoggedIn()
    };
  }

}
