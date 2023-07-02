import {City} from "./City";
import {Governorate} from "./Governorate";

export class Annonce{
    idAnnoce!: number;
    title!: string;
    price!: number;
    area!: number;
    operation!: any;
    location!: string;
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
    creationDate!: Date;
    latitude! : number;
    longitude! : number;
    builtYear! : number;
    floorNumber! : number;
    orderBy!: string;
}
