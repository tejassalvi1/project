import { Injectable, ɵConsole } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Customer } from './model/Customer';
import { Observable } from 'rxjs/internal/Observable';
import { customerOrders } from 'src/app/model/customerOrders';
import { Wallet } from './model/Wallet';
import { Menus } from './model/Menus';
import {Order} from './model/Order';

@Injectable({
  providedIn: 'root'
})
export class CustomerdetailsService {
  constructor(private http:HttpClient) { 
 }

  getcustomerdetails(id): Observable<Customer[]>{
    console.log("came inside the get details method..")
    console.log(id);
    return this.http.get<Customer[]>('http://localhost:8080/FTP109/api/customers/'+id);
  }

  getcustomerorderdetails(id):Observable<customerOrders[]>{
    return this.http.get<customerOrders[]>('http://localhost:8080/FTP109/api/customers/'+id+'/orders');
  }

   getWallet(id):Observable<Wallet[]>{
    return this.http.get<Wallet[]>('http://localhost:8080/FTP109/api/customers/'+id+'/wallet');
  }
   placeOrder(custId, foodId, vendorId, qty, totalPrice, selectedwallet):Observable<any>{
   return this.http.post('http://localhost:8080/FTP109/api/customers/'+custId+'/orders/'+foodId+'/'+qty,{
    'orderPrice':+totalPrice,
    'walId':+selectedwallet ,
    'venId':+vendorId
  });
 }
  authenticate(custId:number, custPassword:string):Observable<Customer[]>{

    console.log("came inside authenticvate block");
    console.log(custId, custPassword);
    return this.http.post<Customer[]>('http://localhost:8080/FTP109/api/customers/auth',{'cusId':+custId, 'cusPas':custPassword});
  }

  getAvailableWallet(custId, totalPrice):Observable<Wallet[]>{
    return this.http.get<Wallet[]>('http://localhost:8080/FTP109/api/customers/'+custId+'/orders')
  }
  getAllOrders(orderId):Observable<Order[]>{
    return this.http.get<Order[]>('http://localhost:8080/FTP109/api/customers/'+orderId+'/allorders')
  }
}
