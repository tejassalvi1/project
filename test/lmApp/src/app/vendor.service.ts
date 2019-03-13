import { Injectable } from '@angular/core';
import {HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/internal/Observable';
import { vendorOrders } from 'src/app/model/vendororders';
import { Vendor } from 'src/app/model/Vendor';
import { Order } from './model/Order';


@Injectable({
  providedIn: 'root'
})
export class VendorService {
  vendorDetails;
  private http:HttpClient;
  constructor(http:HttpClient){
    this.http = http;
  }
  getVendorDetails(id):Observable<Vendor[]>{
    return this.http.get<Vendor[]>('http://localhost:8080/FTP109/api/vendors/'+id)
    }
   vendororderdetails(id,status):Observable<vendorOrders[]>{
    return this.http.get<vendorOrders[]>('http://localhost:8080/FTP109/api/vendors/'+id+'/status?vstatus='+status)
    }

  authentication(venId:number, venPass:string):Observable<Vendor[]>{
    return this.http.post<Vendor[]>('http://localhost:8080/FTP109/api/vendors/auth',{'venId':+venId, 'venPass':venPass});
  }
  UpdateStatus(vendId, orderId, status, comment):Observable<Order[]>{
    return this.http.put<Order[]>('http://localhost:8080/FTP109/api/vendors/'+vendId+'/orders/'+orderId,{
        "orderStatus":status,
        "comments":comment})
  }
}