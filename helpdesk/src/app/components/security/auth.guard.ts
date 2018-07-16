import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { CanActivate, Router, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { SharedService } from '../../services/shared.service';

@Injectable()
export class AuthGuard implements CanActivate {

    public shared: SharedService;

    constructor(private router: Router) {
        this.shared = SharedService.getInstance();
    }

    canActivate(
        route: ActivatedRouteSnapshot,
        state: RouterStateSnapshot): Observable<boolean> | boolean {

        if (this.shared.isLoggedIn()) {
            console.log(`esta logado ${this.shared.token}`);
            return true;
        } else {
            this.router.navigate(['/login']);
            console.log(`não esta logado ${this.shared.token}`);
            return false;
        }
    }

}
