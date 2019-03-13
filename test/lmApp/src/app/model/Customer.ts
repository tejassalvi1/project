
export class Customer {
    constructor(private _cusId:number, private _cusName:string, private _cusMob: string, private _cusTotalBalance:number) {
    }

    

    set cusId(cusId:number){
        this._cusId = cusId;
    }

    get cusId():number{
        return this._cusId;
    }

    set cusName(cusName:string){
        this._cusName = cusName;
    }

    get cusName():string{
        return this._cusName;
    }
    set cusMob(cusMob:string){
        this._cusMob = cusMob;
    }

    get cusMob():string{
        return this._cusMob;
    }

    set cusTotalBalance(cusTotalBalance:number){
        this._cusTotalBalance = cusTotalBalance;
    }

    get cusTotalBalance():number{
        return this._cusTotalBalance;
    }




}