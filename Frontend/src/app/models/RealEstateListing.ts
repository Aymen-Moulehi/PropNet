import {City} from "./City";
import {Governorate} from "./Governorate";

export class RealEstateListing{
    idRealEstateListing!: number;
    title!: string;
    creationDate!: Date;
    realEstateStatus!: any;
    price!: number;
    area!: number;
    operation!: any;
    realEstateIsSold!: any;
    numberOfBedrooms! :number;
    numberOfBathrooms! :number;
    propertyType!: any;
    hasParking!: boolean;
    hasGarden!: boolean;
    hasBalcony!: boolean;
    hasPool!: boolean;
    isFurnished!: boolean;
    hasSecurity!: boolean;
    city!: City;
    governorate!: Governorate;
    latitude! : number;
    longitude! : number;
    builtYear! : number;
}



