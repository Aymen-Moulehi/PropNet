export class Post {
    idPost!: number;
    title!: string;
    content!: string;
    postDate!: Date;
    likes!: Number;
    imageUrl!: string;
    responses!: [Response];
    appUser!: any;
    category!: string;
    relatedTags !: string;
    status !: string;
    formatedDate!: string;
}