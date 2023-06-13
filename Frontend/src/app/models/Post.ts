import { Byte } from "@angular/compiler/src/util";

class Post {
    private title: string;
    private Content: string;
    private postDate: Date;
    private image: Byte[] ;
    private likes: Number;
  
    constructor(title: string, Content: string, postDate: Date, image: Byte[], likes: Number
    ) {
        this.title = title;
        this.Content = Content;
        this.postDate = postDate;
        this.image = image;
        this.likes = likes
    }
  
    getTitle(): string {
      return this.title;
    }
  
    getContent(): string {
      return this.Content;
    }
  
    getImage(): Byte[] {
      return this.image;
    }

    getPostDate(): Date {
        return this.postDate
    }

    getLikes(): Number {
        return this.likes
    }
}