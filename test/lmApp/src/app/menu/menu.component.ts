import { Component, OnInit } from '@angular/core';
import { MenuService} from 'src/app/menu.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  menuService:MenuService;
  menus;
  constructor(menuService:MenuService) { 
    this.menuService = menuService;
  }

  ngOnInit() {
    this.menuService.getAllMenus()
    .subscribe(response=> {
      this.menus = response;
    })
  }
}
