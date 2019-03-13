import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Menus } from './model/Menus';
import { Vendor } from 'src/app/model/Vendor';

@Injectable({
  providedIn: 'root'
})
export class MenuService {

   private http:HttpClient;

  constructor(http:HttpClient) { 
    this.http = http;
  }

  getAllMenus(): Observable<Menus[]>{
    return this.http.get<Menus[]>('http://localhost:8080/FTP109/api/menudetails');
  }

  getFoodPrice(foodId:number, vendorId:number): Observable<Menus[]> {
    return this.http.get<Menus[]>('http://localhost:8080/FTP109/api/menudetails/'+foodId+'/'+vendorId);
  }

  getAllVendorsByFoodId(foodId):Observable<Menus[]>{
    return this.http.get<Menus[]>('http://localhost:8080/FTP109/api/menudetails/'+foodId);
  }
}
