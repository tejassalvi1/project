
export class Wallet {
    constructor(private _walId:number, private _modPay:string, private _walBal: number, private _walCusId: number, private _walTotalBalance:number) {
    }

    set walId(walId:number){
        this._walId = walId;
    }

    get walId():number{
        return this._walId;
    }

    set modPay(modPay:string){
        this._modPay = modPay;
    }

    get modPay():string{
        return this._modPay;
    }

    set walBal(walBal:number){
        this._walBal = walBal;
    }

    get walBal():number{
        return this._walBal;
    }

    set walCusId(walCusId:number){
        this._walCusId = walCusId;
    }

    get walCusId():number{
        return this._walCusId;
    }

}
