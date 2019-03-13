
export class Vendor {
    constructor(private _venId:number, private _venName:string, private _venMob: number, private _venBal:number) {
    }

    set venId(venId:number){
        this._venId = venId;
    }
    get venId():number{
        return this._venId;
    }

    set venName(venName:string){
        this._venName= venName;
    }
    get venName():string{
        return this._venName;
    }

    set venMob(venMob:number){
        this._venMob = venMob;
    }
    get venMob():number{
        return this._venMob;
    }

    set venBal(venBal:number){
        this._venBal = venBal;
    }
    get venBal():number{
        return this._venBal;
    }
}