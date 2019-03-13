export class Order {
    constructor(private _vendorId:number, private _custId:number, private _quantity:number, private _vendorComments:string, private _totalBill:number, private _venName:string) {

    }
    set vendorId(vendorId:number) {
        this._vendorId = vendorId;
    }
    get vendorId():number{
    return this._vendorId;
    }
    set custId(custId:number) {
        this._custId = custId;
    }
    get custId():number{
    return this._custId;
    }
    set quantity(quantity:number) {
        this._quantity = quantity;
    }
    get quantity():number{
    return this._quantity;
    }
    set vendorComments(vendorComments:string) {
        this._vendorComments = vendorComments;
    }
    get vendorComments():string {
        return this._vendorComments;
    }
    set totalBill(totalBill:number) {
        this._totalBill = totalBill;
    }
    get totalBill():number{
    return this._totalBill;
    }
    set venName(venName:string){
        this._venName= venName;
    }
    get venName():string{
        return this._venName;
    }

}