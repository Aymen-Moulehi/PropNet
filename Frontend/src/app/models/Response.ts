import { DateProcessor } from "../features/DateProcessor";

export class Response {
    idRespons!: number;
    content!: string
    author!: string
    responseDate!: Date;
    dateProcessor!: DateProcessor;
    formatedDate!: string;
}
