
export class customerOrders {
    constructor(private _orderId:number, private _vendorName:string, private _orderDate:string, private _orderPrice:number, private _walName:number, private _orderStatus:string, private _comments){
    }
    set orderId(orderId:number){
        this._orderId = orderId; 
    }
    get orderId():number{
        return this._orderId;
    }
    set vendorName(vendorName:string){
        this._vendorName = vendorName;
    }
    get vendorName():string{
        return this._vendorName;
    }
    set orderDate(orderDate:string){
        this._orderDate = orderDate;
    }
    get orderDate(){
        return this._orderDate;
    }
    set walName(walName:number){
        this._walName = walName; 
    }
    get walName():number{
        return this._walName;
    }
    set orderStatus(orderStatus:string){
        this._orderStatus = orderStatus;
    }
    get orderStatus():string{
        return this._orderStatus;
    }
}