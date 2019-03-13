import { Component } from '@angular/core';

import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'The page';
constructor(private router:Router){}
  readLocalStorage(key):string{
    return localStorage.getItem(key);
 }
 logout(){
  localStorage.clear();
  this.router.navigate(['']);
 }
;
}
