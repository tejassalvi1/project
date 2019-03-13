
export class vendorOrders {
    constructor(private _orderId:number, private _cusName:string, private _orderDate:string, private _orderPrice:number, private _walName:string, private _qty:number, private _orderStatus:string, private _comments){
    }
    set orderId(orderId:number){
        this._orderId = orderId; 
    }
    get orderId():number{
        return this._orderId;
    }
    set cusName(cusName:string){
        this._cusName = cusName; 
    }
    get cusName():string{
        return this._cusName;
    }
    set orderDate(orderDate:string){
        this._orderDate = orderDate;
    }
    get orderDate(){
        return this._orderDate;
    }
    set walName(walName:string){
        this._walName = walName; 
    }
    get walName():string{
        return this._walName;
    }
    set qty(qty:number){
        this._qty = qty; 
    }
    get qty():number{
        return this._qty;
    }
    set orderStatus(orderStatus:string){
        this._orderStatus = orderStatus;
    }
    get orderStatus():string{
        return this._orderStatus;
    }
}