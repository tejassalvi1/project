
export class Menus {
    constructor(private _foodId:number, private _foodName:string, private _foodPrice: number, private _vendorId:number, private _vendorName:string) {
    }

    set foodId(foodId:number){
        this._foodId = foodId;
    }

    get foodId():number{
        return this._foodId;
    }

    set foodName(foodName:string){
        this._foodName = foodName;
    }
    get foodName():string{
        return this._foodName;
    }

    set foodPrice(foodPrice:number){
        this._foodPrice = foodPrice;
    }

    get foodPrice():number{
        return this._foodPrice;
    }

    set vendorId(vendorId:number){
        this._vendorId = vendorId;
    }

    get vendorId():number{
        return this._vendorId;
    }

    set vendorName(vendorName:string){
        this._vendorName = vendorName;
    }

    get vendorName():string{
        return this._vendorName;
    }

}