import { Component, OnInit } from '@angular/core';
import { SharedService } from '../../services/shared.service';
import { User } from '../../model/user.model';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  public share: SharedService;

  constructor() {

    this.share = SharedService.getInstance();
    this.share.user = new User('', '', '', '');

   }

  ngOnInit() {
  }

  singOut(): void {
    this.share.token = null;
    this.share.user = null;
    window.location.href = '/login';
    window.location.reload();
  }

}
