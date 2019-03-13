import { Pipe, PipeTransform } from '@angular/core';
import { Menus } from 'src/app/model/Menus';

@Pipe({
  name: 'filtermenu'
})
export class FiltermenuPipe implements PipeTransform {

  transform(menus: Menus[], args?: string): Menus[] {
    if (!args || args[0].length === 0){
      return menus;
    }
    else {
      return menus.filter(menus => menus.foodName.toLowerCase().includes(args.toLowerCase()) );
    }
  }
}
