import { Byte } from "@angular/compiler/src/util";

export class Post {
    idPost!: number;
    title!: string;
    content!: string;
    postDate!: Date;
    likes!: Number;
    imageUrl!: string;
    responses!: any;
    appUser!: any;
    category!: string;
    relatedTags !: string;
}